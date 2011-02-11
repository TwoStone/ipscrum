package fhdw.ipscrum.client.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
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
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;

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

		VerticalPanel verticalPanel = new VerticalPanel();
		horizontalPanel.add(verticalPanel);

		Label lblPersonen = new Label("Personen");
		verticalPanel.add(lblPersonen);

		HorizontalPanel horizontalPanelPersonRoles = new HorizontalPanel();
		verticalPanel.add(horizontalPanelPersonRoles);
		horizontalPanelPersonRoles.setSize("", "300px");

		ScrollPanel scrollPanelPersons = new ScrollPanel();
		scrollPanelPersons.setStyleName("tableBorder");
		scrollPanelPersons.setSize("300px", "300px");
		horizontalPanelPersonRoles.add(scrollPanelPersons);

		cellTablePersons = new CellTable<IPerson>();
		scrollPanelPersons.setWidget(cellTablePersons);
		cellTablePersons.setSize("100%", "100%");
		final SingleSelectionModel<IPerson> selModelPersons = new SingleSelectionModel<IPerson>();
		cellTablePersons.setSelectionModel(selModelPersons);

		TextColumn<IPerson> colFirstname = new TextColumn<IPerson>() {
			@Override
			public String getValue(IPerson object) {
				return object.getFirstname();
			}
		};
		cellTablePersons.addColumn(colFirstname, "Vorname");

		TextColumn<IPerson> colLastname = new TextColumn<IPerson>() {
			@Override
			public String getValue(IPerson object) {
				return object.getLastname();
			}
		};
		cellTablePersons.addColumn(colLastname, "Nachname");

		cellTablePersons.getSelectionModel().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				PersonRoleView.this.cellListAssignedRoles.setRowData(new ArrayList<IRole>(PersonRoleView.this.getSelectedPerson().getRoles()));
			}
		});


		RoleCell roleCellAssignedRoles = new RoleCell();
		cellListAssignedRoles = new CellList<IRole>(roleCellAssignedRoles);
		cellListAssignedRoles.setStyleName("tableBorder");
		horizontalPanelPersonRoles.add(cellListAssignedRoles);
		cellListAssignedRoles.setSize("200px", "100%");
		SingleSelectionModel<IRole> selModelAssignedRoles = new SingleSelectionModel<IRole>();
		cellListAssignedRoles.setSelectionModel(selModelAssignedRoles);

		HorizontalPanel horizontalPanelPersonButtons = new HorizontalPanel();
		verticalPanel.add(horizontalPanelPersonButtons);
		horizontalPanelPersonButtons.setWidth("100%");
		verticalPanel.setCellHorizontalAlignment(horizontalPanelPersonButtons, HasHorizontalAlignment.ALIGN_CENTER);

		Button btnPersonNew = new Button("Neue Person anlegen");
		btnPersonNew.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				newPersonEvent.fire(PersonRoleView.this, new EventArgs());
			}
		});
		horizontalPanelPersonButtons.add(btnPersonNew);
		btnPersonNew.setWidth("100%");

		Button btnPersonModify = new Button("Editieren");
		btnPersonModify.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				modifyPersonEvent.fire(PersonRoleView.this, new PersonArgs(PersonRoleView.this.getSelectedPerson()));
			}
		});
		horizontalPanelPersonButtons.add(btnPersonModify);
		btnPersonModify.setWidth("100%");

		VerticalPanel verticalPanelAllocationButtons = new VerticalPanel();
		verticalPanelAllocationButtons.setStyleName("allocationButtonPanel");
		verticalPanelAllocationButtons.setHeight("");
		horizontalPanel.add(verticalPanelAllocationButtons);

		Button buttonRemoveRoleFromPerson = new Button("->");
		buttonRemoveRoleFromPerson.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Person affectedPerson = PersonRoleView.this.getSelectedPerson();
				HashSet<IRole> roleSet = new HashSet<IRole>();
				roleSet.add(PersonRoleView.this.getSelectedAssignedRole());
				removeRoleFromPersonEvent.fire(PersonRoleView.this, new AssociatePersonAndRoleArgs(affectedPerson, roleSet));
			}
		});
		verticalPanelAllocationButtons.add(buttonRemoveRoleFromPerson);

		Button buttonAddRoleToPerson = new Button("<-");
		buttonAddRoleToPerson.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				Person affectedPerson = PersonRoleView.this.getSelectedPerson();
				Set<IRole> roleSet = PersonRoleView.this.getSelectedAvailRoles();
				addRoletoPersonEvent.fire(PersonRoleView.this, new AssociatePersonAndRoleArgs(affectedPerson, roleSet));
			}
		});
		verticalPanelAllocationButtons.add(buttonAddRoleToPerson);

		VerticalPanel verticalPanelRoles = new VerticalPanel();
		horizontalPanel.add(verticalPanelRoles);
		verticalPanelRoles.setSize("200px", "");

		Label lblRollen = new Label("Rollen");
		verticalPanelRoles.add(lblRollen);

		RoleCell roleCellAvailRoles = new RoleCell();
		cellListRoles = new CellList<IRole>(roleCellAvailRoles);
		cellListRoles.setStyleName("tableBorder");
		verticalPanelRoles.add(cellListRoles);
		cellListRoles.setSize("100%", "300px");
		MultiSelectionModel<IRole> selModelAvailRoles = new MultiSelectionModel<IRole>();
		cellListRoles.setSelectionModel(selModelAvailRoles);

		Button btnRoleNew = new Button("Neue Rolle anlegen");
		btnRoleNew.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				newRoleEvent.fire(PersonRoleView.this, new EventArgs());
			}
		});
		verticalPanelRoles.add(btnRoleNew);
		btnRoleNew.setWidth("100%");

		Button btnRoleRemove = new Button("Entfernen");
		btnRoleRemove.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				removeRoleEvent.fire(PersonRoleView.this, new MultipleRoleArgs(PersonRoleView.this.getSelectedAvailRoles()));
			}
		});
		verticalPanelRoles.add(btnRoleRemove);
		btnRoleRemove.setWidth("100%");
	}

	@Override
	public CellTable<IPerson> getCellTablePersons() {
		return this.cellTablePersons;
	}

	@Override
	public CellList<IRole> getCellListAssignedRoles() {
		return this.cellListAssignedRoles;
	}

	@Override
	public void defineNewPersonEventHandler(EventHandler<EventArgs> args) {
		this.newPersonEvent.add(args);
	}

	@Override
	public void defineModifyPersonEventHandler(EventHandler<PersonArgs> args) {
		this.modifyPersonEvent.add(args); // TODO: wieso add handler? eventhandler korrekt?
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
	public CellList<IRole> getCellListRoles() {
		return this.cellListRoles;
	}

	/**
	 * This class is used to create cell-based widgets like <code>CellList</code> with <code>IRole</code>-Objects.
	 */
	private class RoleCell extends AbstractCell<IRole> {

		@Override
		public void render(com.google.gwt.cell.client.Cell.Context context, IRole value, SafeHtmlBuilder sb) {
			if (value != null) {
				sb.appendEscaped(value.getDescription());
			}
		}
	}

	/**
	 * Returns the selected Person of the CellTable.
	 * @return selected Person
	 */
	@Override
	public Person getSelectedPerson() {
		SingleSelectionModel<IPerson> selPersModel = (SingleSelectionModel<IPerson>) cellTablePersons.getSelectionModel();
		Person selectedPerson = (Person) selPersModel.getSelectedObject();
		return selectedPerson;
	}

	/**
	 * Returns the selected Role of the CellList.
	 * @return selected Role from AssignedRolesList
	 */
	@Override
	public Role getSelectedAssignedRole() {
		SingleSelectionModel<IRole> selAssignedRoleModel = (SingleSelectionModel<IRole>) cellListAssignedRoles.getSelectionModel();
		Role selectedRole = (Role) selAssignedRoleModel.getSelectedObject();
		return selectedRole;
	}

	/**
	 * Returns a set of selected Roles from the list of available Roles.
	 * @return selected Roles
	 */
	@Override
	public Set<IRole> getSelectedAvailRoles() {
		MultiSelectionModel<IRole> selAvailRoleModel = (MultiSelectionModel<IRole>) cellListRoles.getSelectionModel();
		Set<IRole> selectedRoles = selAvailRoleModel.getSelectedSet();
		return selectedRoles;
	}
}
