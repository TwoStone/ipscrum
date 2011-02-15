package fhdw.ipscrum.client.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

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
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.AssociatePersonAndRoleArgs;
import fhdw.ipscrum.client.events.args.MultipleRoleArgs;
import fhdw.ipscrum.client.events.args.PersonArgs;
import fhdw.ipscrum.client.view.interfaces.IPersonRoleView;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;

/**
 * This view is intended to be a central management console for persons and roles.
 * It provides controls for creating, modifying and deleting persons and roles as well associate roles to persons or remove associations.
 */
public class PersonRoleView extends Composite implements IPersonRoleView {
	private CellTable<IPerson> cellTablePersons;
	private CellList<IRole> cellListAssignedRoles;
	private CellList<IRole> cellListRoles;
	private final Event<EventArgs> newPersonEvent = new Event<EventArgs>();
	private final Event<PersonArgs> modifyPersonEvent = new Event<PersonArgs>();
	private final Event<AssociatePersonAndRoleArgs> removeRoleFromPersonEvent = new Event<AssociatePersonAndRoleArgs>();
	private final Event<AssociatePersonAndRoleArgs> addRoletoPersonEvent = new Event<AssociatePersonAndRoleArgs>();
	private final Event<EventArgs> newRoleEvent = new Event<EventArgs>();
	private final Event<MultipleRoleArgs> removeRoleEvent = new Event<MultipleRoleArgs>();

	public PersonRoleView() {

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		initWidget(horizontalPanel);

		CaptionPanel cptnpnlPersons = new CaptionPanel(TextConstants.PERSROLEMNGMT_PERSONAREA_HEADER);
		cptnpnlPersons.setStyleName("coloredBG2");
		horizontalPanel.add(cptnpnlPersons);
		cptnpnlPersons.setWidth("");

		HorizontalPanel horizontalPanelPers = new HorizontalPanel();
		cptnpnlPersons.setContentWidget(horizontalPanelPers);
		horizontalPanelPers.setSize("5cm", "3cm");

		VerticalPanel verticalPanelPersons = new VerticalPanel();
		horizontalPanelPers.add(verticalPanelPersons);

		Label lblPersonen = new Label(TextConstants.PERSROLEMNGMT_PERSONTABLE_HEADER);
		verticalPanelPersons.add(lblPersonen);

		ScrollPanel scrollPanelPersons = new ScrollPanel();
		verticalPanelPersons.add(scrollPanelPersons);
		scrollPanelPersons.setStyleName("tableBorder");
		scrollPanelPersons.setSize("300px", "400px");

		this.cellTablePersons = new CellTable<IPerson>();
		scrollPanelPersons.setWidget(this.cellTablePersons);
		this.cellTablePersons.setSize("100%", "100%");
		this.cellTablePersons.setSelectionModel(new SingleSelectionModel<IPerson>());
		this.cellTablePersons.getSelectionModel().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				if (PersonRoleView.this.getSelectedPerson() != null) {
					PersonRoleView.this.cellListAssignedRoles.setRowData(new ArrayList<IRole>(PersonRoleView.this.getSelectedPerson().getRoles()));
				}
			}
		});

		TextColumn<IPerson> colFirstname = new TextColumn<IPerson>() {
			@Override
			public String getValue(IPerson object) {
				return object.getFirstname();
			}
		};
		this.cellTablePersons.addColumn(colFirstname, TextConstants.PERSROLEMNGMT_PERSONTABLE_COL_FIRSTNAME);

		TextColumn<IPerson> colLastname = new TextColumn<IPerson>() {
			@Override
			public String getValue(IPerson object) {
				return object.getLastname();
			}
		};
		this.cellTablePersons.addColumn(colLastname, TextConstants.PERSROLEMNGMT_PERSONTABLE_COL_LASTNAME);

		VerticalPanel verticalPanelPersonButtons = new VerticalPanel();
		verticalPanelPersons.add(verticalPanelPersonButtons);
		verticalPanelPersonButtons.setWidth("100%");
		verticalPanelPersons.setCellHorizontalAlignment(verticalPanelPersonButtons, HasHorizontalAlignment.ALIGN_CENTER);

		Button btnPersonNew = new Button(TextConstants.PERSROLEMNGMT_BUTTONLABEL_CREATENEWPERSON);
		btnPersonNew.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PersonRoleView.this.newPersonEvent.fire(PersonRoleView.this, new EventArgs());
			}
		});
		verticalPanelPersonButtons.add(btnPersonNew);
		btnPersonNew.setWidth("100%");

		Button btnPersonModify = new Button(TextConstants.PERSROLEMNGMT_BUTTONLABEL_MODIFYPERSON);
		btnPersonModify.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PersonRoleView.this.modifyPersonEvent.fire(PersonRoleView.this, new PersonArgs(PersonRoleView.this.getSelectedPerson()));
			}
		});
		verticalPanelPersonButtons.add(btnPersonModify);
		btnPersonModify.setWidth("100%");

		VerticalPanel verticalPanelAssignedRoles = new VerticalPanel();
		horizontalPanelPers.add(verticalPanelAssignedRoles);

		Label lblNewLabel = new Label(TextConstants.PERSROLEMNGMT_ASSIGNEDROLELIST_HEADER);
		verticalPanelAssignedRoles.add(lblNewLabel);
		this.cellListAssignedRoles = new CellList<IRole>(new AbstractCell<IRole>() {
			@Override
			public void render(com.google.gwt.cell.client.Cell.Context context, IRole value, SafeHtmlBuilder sb) {
				if (value != null) {
					sb.appendEscaped(value.getDescription());
				}
			}
		});
		verticalPanelAssignedRoles.add(cellListAssignedRoles);
		this.cellListAssignedRoles.setStyleName("tableBorder");
		cellListAssignedRoles.setSize("200px", "400px");
		this.cellListAssignedRoles.setSelectionModel(new SingleSelectionModel<IRole>());


		Button buttonAddRoleToPerson = new Button(TextConstants.PERSROLEMNGMT_BUTTONLABEL_ASSIGNROLETOPERSON);
		verticalPanelAssignedRoles.add(buttonAddRoleToPerson);
		buttonAddRoleToPerson.setWidth("100%");
		buttonAddRoleToPerson.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Person affectedPerson = PersonRoleView.this.getSelectedPerson();
				Set<IRole> roleSet = PersonRoleView.this.getSelectedAvailRoles();
				if (roleSet.size() == 0 || affectedPerson == null) {
					Window.alert(ExceptionConstants.GUI_PERSROLEMNGMT_ASSIGNERROR);
				} else {
					PersonRoleView.this.addRoletoPersonEvent.fire(PersonRoleView.this, new AssociatePersonAndRoleArgs(affectedPerson, roleSet));
				}
			}
		});

		Button buttonRemoveRoleFromPerson = new Button(TextConstants.PERSROLEMNGMT_BUTTONLABEL_REMOVEROLEFROMPERSON);
		verticalPanelAssignedRoles.add(buttonRemoveRoleFromPerson);
		buttonRemoveRoleFromPerson.setWidth("100%");
		buttonRemoveRoleFromPerson.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Person affectedPerson = PersonRoleView.this.getSelectedPerson();
				HashSet<IRole> roleSet = new HashSet<IRole>();
				roleSet.add(PersonRoleView.this.getSelectedAssignedRole());
				PersonRoleView.this.removeRoleFromPersonEvent.fire(PersonRoleView.this, new AssociatePersonAndRoleArgs(affectedPerson, roleSet));
			}
		});

		CaptionPanel cptnpnlRoles = new CaptionPanel(TextConstants.PERSROLEMNGMT_ROLEAREA_HEADER);
		cptnpnlRoles.setStyleName("coloredBG1");
		horizontalPanel.add(cptnpnlRoles);

		VerticalPanel verticalPanelRoles = new VerticalPanel();
		cptnpnlRoles.setContentWidget(verticalPanelRoles);
		verticalPanelRoles.setSize("200px", "400px");

		Label lblRollen = new Label(TextConstants.PERSROLEMNGMT_ROLELIST_HEADER);
		verticalPanelRoles.add(lblRollen);
		this.cellListRoles = new CellList<IRole>(new AbstractCell<IRole>() {
			@Override
			public void render(com.google.gwt.cell.client.Cell.Context context, IRole value, SafeHtmlBuilder sb) {
				if (value != null) {
					sb.appendEscaped(value.getDescription());
				}
			}
		});
		this.cellListRoles.setStyleName("tableBorder");
		verticalPanelRoles.add(this.cellListRoles);
		cellListRoles.setSize("100%", "400px");
		this.cellListRoles.setSelectionModel(new MultiSelectionModel<IRole>());


		Button btnRoleNew = new Button(TextConstants.PERSROLEMNGMT_BUTTONLABEL_CREATENEWROLE);
		btnRoleNew.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PersonRoleView.this.newRoleEvent.fire(PersonRoleView.this, new EventArgs());
			}
		});
		verticalPanelRoles.add(btnRoleNew);
		btnRoleNew.setWidth("100%");

		Button btnRoleRemove = new Button(TextConstants.PERSROLEMNGMT_BUTTONLABEL_DELETEROLE);
		btnRoleRemove.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PersonRoleView.this.removeRoleEvent.fire(PersonRoleView.this, new MultipleRoleArgs(PersonRoleView.this.getSelectedAvailRoles()));
			}
		});
		verticalPanelRoles.add(btnRoleRemove);
		btnRoleRemove.setWidth("100%");
	}


	@Override
	public void updatePersonTable(HashSet<IPerson> personSet) {
		this.cellTablePersons.setRowData(new ArrayList<IPerson>(personSet));
	}


	@Override
	public void updateAssignedRoles(Vector<IRole> roleList) {
		this.cellListAssignedRoles.setRowData(roleList);
	}


	@Override
	public void updateAvailRoleList(HashSet<IRole> roleSet) {
		this.cellListRoles.setRowData(new ArrayList<IRole>(roleSet));
	}


	@Override
	public void defineNewPersonEventHandler(EventHandler<EventArgs> args) {
		this.newPersonEvent.add(args);
	}

	@Override
	public void defineModifyPersonEventHandler(EventHandler<PersonArgs> args) {
		this.modifyPersonEvent.add(args);
	}


	@Override
	public void defineRemoveRoleFromPersonEventHandler(EventHandler<AssociatePersonAndRoleArgs> args) {
		this.removeRoleFromPersonEvent.add(args);
	}


	@Override
	public void defineAddRoleToPersonEventHandler(EventHandler<AssociatePersonAndRoleArgs> args) {
		this.addRoletoPersonEvent.add(args);
	}


	@Override
	public void defineNewRoleEventHandler(EventHandler<EventArgs> args) {
		this.newRoleEvent.add(args);
	}

	@Override
	public void defineRemoveRoleEventHandler(EventHandler<MultipleRoleArgs> args) {
		this.removeRoleEvent.add(args);
	}

	@Override
	public Person getSelectedPerson() {
		SingleSelectionModel<IPerson> selPersModel = (SingleSelectionModel<IPerson>) this.cellTablePersons.getSelectionModel();
		Person selectedPerson = (Person) selPersModel.getSelectedObject();
		return selectedPerson;
	}


	@Override
	public Role getSelectedAssignedRole() {
		SingleSelectionModel<IRole> selAssignedRoleModel = (SingleSelectionModel<IRole>) this.cellListAssignedRoles.getSelectionModel();
		Role selectedRole = (Role) selAssignedRoleModel.getSelectedObject();
		return selectedRole;
	}


	@Override
	public Set<IRole> getSelectedAvailRoles() {
		MultiSelectionModel<IRole> selAvailRoleModel = (MultiSelectionModel<IRole>) this.cellListRoles.getSelectionModel();
		Set<IRole> selectedRoles = selAvailRoleModel.getSelectedSet();
		return selectedRoles;
	}
}
