package fhdw.ipscrum.client.view;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.eventargs.AssociatePersonAndRoleArgs;
import fhdw.ipscrum.client.eventargs.MultipleRoleArgs;
import fhdw.ipscrum.client.viewinterfaces.IPersonRoleView;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Role;

/**
 * This view is intended to be a central management console for persons and roles. It provides controls for creating,
 * modifying and deleting persons and roles as well associate roles to persons or remove associations.
 */
public class PersonRoleView extends MasterView implements IPersonRoleView {
	private CellTable<Person> cellTablePersons;
	private CellList<Role> cellListAssignedRoles;
	private CellList<Role> cellListRoles;
	private final DefaultEvent newPersonEvent = new DefaultEvent();
	private final Event<TypedEventArg<Person>> modifyPersonEvent = new Event<TypedEventArg<Person>>();
	private final Event<AssociatePersonAndRoleArgs> removeRoleFromPersonEvent = new Event<AssociatePersonAndRoleArgs>();
	private final Event<AssociatePersonAndRoleArgs> addRoletoPersonEvent = new Event<AssociatePersonAndRoleArgs>();
	private final DefaultEvent newRoleEvent = new DefaultEvent();
	private final Event<MultipleRoleArgs> removeRoleEvent = new Event<MultipleRoleArgs>();
	private final Event<TypedEventArg<Role>> rights = new Event<TypedEventArg<Role>>();
	private Button buttonAddRoleToPerson;
	private Button btnRoleNew;
	private Button btnRoleRemove;
	private Button btnRights;
	private Button btnPersonNew;
	private Button buttonRemoveRoleFromPerson;
	private Button btnPersonModify;

	/**
	 * constructor of the PersonRoleView.
	 */
	public PersonRoleView() {
		super();

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		this.add(horizontalPanel);

		final CaptionPanel cptnpnlPersons = new CaptionPanel(TextConstants.PERSROLEMNGMT_PERSONAREA_HEADER);
		cptnpnlPersons.setStyleName("coloredBG2");
		horizontalPanel.add(cptnpnlPersons);
		cptnpnlPersons.setWidth("");

		final HorizontalPanel horizontalPanelPers = new HorizontalPanel();
		cptnpnlPersons.setContentWidget(horizontalPanelPers);
		horizontalPanelPers.setSize("5cm", "3cm");

		final VerticalPanel verticalPanelPersons = new VerticalPanel();
		horizontalPanelPers.add(verticalPanelPersons);

		final Label lblPersonen = new Label(TextConstants.PERSROLEMNGMT_PERSONTABLE_HEADER);
		verticalPanelPersons.add(lblPersonen);

		final ScrollPanel scrollPanelPersons = new ScrollPanel();
		verticalPanelPersons.add(scrollPanelPersons);
		scrollPanelPersons.setStyleName("tableBorder");
		scrollPanelPersons.setSize("300px", "400px");

		this.cellTablePersons = new CellTable<Person>();
		scrollPanelPersons.setWidget(this.cellTablePersons);
		this.cellTablePersons.setSize("100%", "100%");
		this.cellTablePersons.setSelectionModel(new SingleSelectionModel<Person>());
		this.cellTablePersons.getSelectionModel().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(final SelectionChangeEvent event) {
				PersonRoleView.this.updateAssignedRoleDisplay();
			}
		});

		final TextColumn<Person> colFirstname = new TextColumn<Person>() {
			@Override
			public String getValue(final Person object) {
				return object.getFirstname();
			}
		};
		this.cellTablePersons.addColumn(colFirstname, TextConstants.PERSROLEMNGMT_PERSONTABLE_COL_FIRSTNAME);

		final TextColumn<Person> colLastname = new TextColumn<Person>() {
			@Override
			public String getValue(final Person object) {
				return object.getLastname();
			}
		};
		this.cellTablePersons.addColumn(colLastname, TextConstants.PERSROLEMNGMT_PERSONTABLE_COL_LASTNAME);

		final VerticalPanel verticalPanelPersonButtons = new VerticalPanel();
		verticalPanelPersons.add(verticalPanelPersonButtons);
		verticalPanelPersonButtons.setWidth("100%");
		verticalPanelPersons
				.setCellHorizontalAlignment(verticalPanelPersonButtons, HasHorizontalAlignment.ALIGN_CENTER);

		this.btnPersonNew = new Button(TextConstants.PERSROLEMNGMT_BUTTONLABEL_CREATENEWPERSON);
		this.btnPersonNew.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				PersonRoleView.this.newPersonEvent.fire(PersonRoleView.this, new EventArgs());
			}
		});
		verticalPanelPersonButtons.add(this.btnPersonNew);
		this.btnPersonNew.setWidth("100%");

		this.btnPersonModify = new Button(TextConstants.PERSROLEMNGMT_BUTTONLABEL_MODIFYPERSON);
		this.btnPersonModify.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				PersonRoleView.this.modifyPersonEvent.fire(PersonRoleView.this, new TypedEventArg<Person>(
						PersonRoleView.this.getSelectedPerson()));
			}
		});
		verticalPanelPersonButtons.add(this.btnPersonModify);
		this.btnPersonModify.setWidth("100%");

		final VerticalPanel verticalPanelAssignedRoles = new VerticalPanel();
		horizontalPanelPers.add(verticalPanelAssignedRoles);

		final Label lblNewLabel = new Label(TextConstants.PERSROLEMNGMT_ASSIGNEDROLELIST_HEADER);
		verticalPanelAssignedRoles.add(lblNewLabel);
		this.cellListAssignedRoles = new CellList<Role>(new AbstractCell<Role>() {
			@Override
			public void render(final com.google.gwt.cell.client.Cell.Context context, final Role value,
					final SafeHtmlBuilder sb) {
				if (value != null) {
					sb.appendEscaped(value.getDescription());
				}
			}
		});
		verticalPanelAssignedRoles.add(this.cellListAssignedRoles);
		this.cellListAssignedRoles.setStyleName("tableBorder");
		this.cellListAssignedRoles.setSize("200px", "400px");
		this.cellListAssignedRoles.setSelectionModel(new SingleSelectionModel<Role>());

		this.buttonAddRoleToPerson = new Button(TextConstants.PERSROLEMNGMT_BUTTONLABEL_ASSIGNROLETOPERSON);
		verticalPanelAssignedRoles.add(this.buttonAddRoleToPerson);
		this.buttonAddRoleToPerson.setWidth("100%");
		this.buttonAddRoleToPerson.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				final Person affectedPerson = PersonRoleView.this.getSelectedPerson();
				final List<Role> roleSet = PersonRoleView.this.getSelectedAvailRoles();
				if (roleSet.size() == 0 || affectedPerson == null) {
					Window.alert(ExceptionConstants.GUI_PERSROLEMNGMT_ASSIGNERROR);
				} else {
					PersonRoleView.this.addRoletoPersonEvent.fire(PersonRoleView.this, new AssociatePersonAndRoleArgs(
							affectedPerson, roleSet));
				}
			}
		});

		this.buttonRemoveRoleFromPerson = new Button(TextConstants.PERSROLEMNGMT_BUTTONLABEL_REMOVEROLEFROMPERSON);
		verticalPanelAssignedRoles.add(this.buttonRemoveRoleFromPerson);
		this.buttonRemoveRoleFromPerson.setWidth("100%");
		this.buttonRemoveRoleFromPerson.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				final Person affectedPerson = PersonRoleView.this.getSelectedPerson();
				final List<Role> roleSet = new ArrayList<Role>();
				roleSet.add(PersonRoleView.this.getSelectedAssignedRole());
				PersonRoleView.this.removeRoleFromPersonEvent.fire(PersonRoleView.this, new AssociatePersonAndRoleArgs(
						affectedPerson, roleSet));
			}
		});

		final CaptionPanel cptnpnlRoles = new CaptionPanel(TextConstants.PERSROLEMNGMT_ROLEAREA_HEADER);
		cptnpnlRoles.setStyleName("coloredBG1");
		horizontalPanel.add(cptnpnlRoles);

		final VerticalPanel verticalPanelRoles = new VerticalPanel();
		cptnpnlRoles.setContentWidget(verticalPanelRoles);
		verticalPanelRoles.setSize("250px", "400px");

		final Label lblRollen = new Label(TextConstants.PERSROLEMNGMT_ROLELIST_HEADER);
		verticalPanelRoles.add(lblRollen);
		this.cellListRoles = new CellList<Role>(new AbstractCell<Role>() {
			@Override
			public void render(final com.google.gwt.cell.client.Cell.Context context, final Role value,
					final SafeHtmlBuilder sb) {
				if (value != null) {
					sb.appendEscaped(value.getDescription());
				}
			}
		});
		this.cellListRoles.setStyleName("tableBorder");
		verticalPanelRoles.add(this.cellListRoles);
		this.cellListRoles.setSize("100%", "400px");
		this.cellListRoles.setSelectionModel(new MultiSelectionModel<Role>());

		final HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanelRoles.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("100%");

		this.btnRoleNew = new Button(TextConstants.PERSROLEMNGMT_BUTTONLABEL_CREATENEWROLE);
		horizontalPanel_1.add(this.btnRoleNew);
		this.btnRoleNew.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				PersonRoleView.this.newRoleEvent.fire(PersonRoleView.this, new EventArgs());
			}
		});
		this.btnRoleNew.setWidth("100%");

		this.btnRoleRemove = new Button(TextConstants.PERSROLEMNGMT_BUTTONLABEL_DELETEROLE);
		horizontalPanel_1.add(this.btnRoleRemove);
		this.btnRoleRemove.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				PersonRoleView.this.removeRoleEvent.fire(PersonRoleView.this,
						new MultipleRoleArgs(PersonRoleView.this.getSelectedAvailRoles()));
			}
		});
		this.btnRoleRemove.setWidth("100%");

		this.btnRights = new Button("Berechtigungen zuordnen");
		verticalPanelRoles.add(this.btnRights);
		this.btnRights.setWidth("100%");
		this.btnRights.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {

				PersonRoleView.this.rights.fire(PersonRoleView.this, new TypedEventArg<Role>(PersonRoleView.this
						.getSelectedAvailRoles().get(0)));

			}
		});
	}

	@Override
	public void updatePersonTable(final List<Person> persons) {
		this.cellTablePersons.setRowData(persons);
	}

	@Override
	public void updateAvailRoleList(final List<Role> roles) {
		this.cellListRoles.setRowData(roles);
	}

	@Override
	public void defineNewPersonEventHandler(final DefaultEventHandler handler) {
		this.newPersonEvent.add(handler);
	}

	@Override
	public void defineModifyPersonEventHandler(final EventHandler<TypedEventArg<Person>> args) {
		this.modifyPersonEvent.add(args);
	}

	@Override
	public void defineRemoveRoleFromPersonEventHandler(final EventHandler<AssociatePersonAndRoleArgs> args) {
		this.removeRoleFromPersonEvent.add(args);
	}

	@Override
	public void defineAddRoleToPersonEventHandler(final EventHandler<AssociatePersonAndRoleArgs> args) {
		this.addRoletoPersonEvent.add(args);
	}

	@Override
	public void defineNewRoleEventHandler(final DefaultEventHandler handler) {
		this.newRoleEvent.add(handler);
	}

	@Override
	public void defineRemoveRoleEventHandler(final EventHandler<MultipleRoleArgs> args) {
		this.removeRoleEvent.add(args);
	}

	@Override
	public Person getSelectedPerson() {
		@SuppressWarnings("unchecked")
		final SingleSelectionModel<Person> selPersModel =
				(SingleSelectionModel<Person>) this.cellTablePersons.getSelectionModel();
		final Person selectedPerson = selPersModel.getSelectedObject();
		return selectedPerson;
	}

	@Override
	public Role getSelectedAssignedRole() {
		@SuppressWarnings("unchecked")
		final SingleSelectionModel<Role> selAssignedRoleModel =
				(SingleSelectionModel<Role>) this.cellListAssignedRoles.getSelectionModel();
		final Role selectedRole = selAssignedRoleModel.getSelectedObject();
		return selectedRole;
	}

	@Override
	public List<Role> getSelectedAvailRoles() {
		@SuppressWarnings("unchecked")
		final MultiSelectionModel<Role> selAvailRoleModel =
				(MultiSelectionModel<Role>) this.cellListRoles.getSelectionModel();
		final List<Role> selectedRoles = new ArrayList<Role>(selAvailRoleModel.getSelectedSet());
		return selectedRoles;
	}

	@Override
	public void updateAssignedRoleDisplay() {
		if (this.getSelectedPerson() != null) {
			this.cellListAssignedRoles.setRowData(this.getSelectedPerson().getRoles());
		}
	}

	@Override
	public void close() {
		this.newPersonEvent.removeAllHandler();
		this.newRoleEvent.removeAllHandler();
		this.modifyPersonEvent.removeAllHandler();
		this.addRoletoPersonEvent.removeAllHandler();
		this.removeRoleEvent.removeAllHandler();
		this.removeRoleFromPersonEvent.removeAllHandler();
	}

	@Override
	public void defineEditRightsEventHander(final EventHandler<TypedEventArg<Role>> handler) {
		this.rights.add(handler);

	}

	@Override
	public void setRightVisibility(final Boolean value) {
		this.getButtonAddRoleToPerson().setEnabled(value);
		this.getBtnRoleNew().setEnabled(value);
		this.getBtnRoleRemove().setEnabled(value);
		this.getBtnRights().setEnabled(value);
		this.getBtnPersonNew().setEnabled(value);
		this.getButtonRemoveRoleFromPerson().setEnabled(value);
		this.getBtnPersonModify().setEnabled(value);
	}

	protected Button getButtonAddRoleToPerson() {
		return this.buttonAddRoleToPerson;
	}

	protected Button getBtnRoleNew() {
		return this.btnRoleNew;
	}

	protected Button getBtnRoleRemove() {
		return this.btnRoleRemove;
	}

	protected Button getBtnRights() {
		return this.btnRights;
	}

	protected Button getBtnPersonNew() {
		return this.btnPersonNew;
	}

	protected Button getButtonRemoveRoleFromPerson() {
		return this.buttonRemoveRoleFromPerson;
	}

	protected Button getBtnPersonModify() {
		return this.btnPersonModify;
	}
}
