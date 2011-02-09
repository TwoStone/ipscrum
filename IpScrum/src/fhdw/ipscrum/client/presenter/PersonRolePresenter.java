package fhdw.ipscrum.client.presenter;

import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.view.PersonRoleView;
import fhdw.ipscrum.client.view.interfaces.IPersonRoleView;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;

public class PersonRolePresenter extends Presenter<IPersonRoleView> {

	
	private Vector<Role> roleList;
	private Vector<Person> personList;
	private IPersonRoleView concreteView;
	private CellTable<IPerson> personTable;
	private CellList<IRole> assignedRoleList;
	private CellList<IRole> availRoleList;

	public PersonRolePresenter(Panel parent) {
		super(parent);
	}

	@Override
	protected IPersonRoleView createView() {
		concreteView = PersonRoleView.createView();
		
		this.createDemoData();
		
		this.setupGuiTables();
		
		this.setupClickEvents();
		
		return concreteView;
	}

	/**
	 * This method is called to update the GUI with new data.
	 */
	private void updateGuiTables() {
		personTable.setRowData(personList);
		assignedRoleList.setRowData((this.getSelectedPerson() != null) ? this.getSelectedPerson().getRoles() : new Vector<Role>());
		availRoleList.setRowData(roleList);
	}

	/**
	 * This method is run once to set up the GUI-elements.
	 */
	private void setupGuiTables() {
		// Set up CellTable for Persons.
		personTable = concreteView.getCellTablePersons();
		
		TextColumn<IPerson> colFirstname = new TextColumn<IPerson>() {
			public String getValue(IPerson object) {
				return object.getFirstname();
			}
		};
		
		personTable.addColumn(colFirstname, "Vorname");
		
		TextColumn<IPerson> colLastname = new TextColumn<IPerson>() {
			public String getValue(IPerson object) {
				return object.getLastname();
			}
		};
		personTable.addColumn(colLastname, "Nachname");
		
		
		personTable.setRowCount(personList.size(), true);
		personTable.setRowData(personList);
		
		// Set up CellList of assigned roles to selected Person.
		assignedRoleList = concreteView.getCellListAssignedRoles();
		// Add a SelectionChangeHandler to update the roleList.
		personTable.getSelectionModel().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			public void onSelectionChange(SelectionChangeEvent event) {
				Person selectedPerson = PersonRolePresenter.this.getSelectedPerson();
				assignedRoleList.setRowData(selectedPerson.getRoles());
			}
		});
		
		// Set up CellList of available roles.
		availRoleList = concreteView.getCellListRoles();
		availRoleList.setRowData(roleList);
	}

	/**
	 * Fills <code>roleList</code> and <code>personList</code> with demo-data.
	 */
	private void createDemoData() {
		Role roleTSUser = new Role("Ticketsystem-Benutzer");
		Role roleScrummaster = new Role("Scrum-Master");
		Role roleProductOwner = new Role("Product-Owner");
		Role roleDeveloper = new Role("Entwickler");
		Role roleTester = new Role("Tester");
		Role roleGUIWiz = new Role("GUI-Wizard");
		roleList = new Vector<Role>();
		roleList.add(roleTSUser);
		roleList.add(roleScrummaster);
		roleList.add(roleProductOwner);
		roleList.add(roleDeveloper);
		roleList.add(roleTester);
		roleList.add(roleGUIWiz);
		
		
		Person pSarah = new Person("Sarah", "Gottwald");
		pSarah.addRole(roleScrummaster);
		pSarah.addRole(roleTSUser);
		
		Person pWilken = new Person("Wilken", "Hustedt");
		pWilken.addRole(roleDeveloper);
		pWilken.addRole(roleGUIWiz);
		pWilken.addRole(roleTSUser);
		
		Person pChristin = new Person("Christin", "Weckbrod");
		pChristin.addRole(roleProductOwner);
		pChristin.addRole(roleDeveloper);
		pChristin.addRole(roleTSUser);
		
		Person pNils = new Person("Nils", "Vincent");
		pNils.addRole(roleTester);
		pNils.addRole(roleTSUser);
		
		personList = new Vector<Person>();
		personList.add(pSarah);
		personList.add(pWilken);
		personList.add(pChristin);
		personList.add(pNils);
	}

	/**
	 * This method is called to set up the algorithms for each button of the GUI.
	 */
	private void setupClickEvents() {
		concreteView.getBtnPersonModify().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (PersonRolePresenter.this.getSelectedPerson() != null) {
					// TODO implement here.
					Window.alert("algorithm to modify "
							+ PersonRolePresenter.this.getSelectedPerson()
									.getFirstname() + " not ready yet.");
					PersonRolePresenter.this.updateGuiTables();
				}
			}
		});
		
		concreteView.getBtnPersonNew().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Person newPerson = new Person("Karl", "Test" + Math.random()*5); // TODO needs work.
				PersonRolePresenter.this.personList.add(newPerson);
				PersonRolePresenter.this.updateGuiTables();
			}
		});
		
		concreteView.getBtnPersonRemove().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (PersonRolePresenter.this.getSelectedPerson() != null) {
					PersonRolePresenter.this.personList.remove(PersonRolePresenter.this.getSelectedPerson());
					PersonRolePresenter.this.updateGuiTables();
				}
			}
		});
		
		concreteView.getBtnRoleNew().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Role newRole = new Role("Test" + Math.random()*5);
				PersonRolePresenter.this.roleList.add(newRole);
				PersonRolePresenter.this.updateGuiTables();
			}
		});
		
		concreteView.getBtnRoleRemove().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Iterator<IRole> i = PersonRolePresenter.this.getSelectedAvailRoles().iterator();
				while (i.hasNext()) {
					IRole current = i.next();
					PersonRolePresenter.this.roleList.remove(current);
				}
				// TODO: What about persons who posses these roles?
				PersonRolePresenter.this.updateGuiTables();
			}
		});
		
		concreteView.getButtonAddRoleToPerson().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Person selPers = PersonRolePresenter.this.getSelectedPerson();
				if (selPers != null) {
					Iterator<IRole> i = PersonRolePresenter.this
							.getSelectedAvailRoles().iterator();
					while (i.hasNext()) {
						IRole current = i.next();
						if (!selPers.getRoles().contains(current)) {
							selPers.addRole((Role) current);
						}
					}
					PersonRolePresenter.this.updateGuiTables();
				}
			}
		});
		
		concreteView.getButtonRemoveRoleFromPerson().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (PersonRolePresenter.this.getSelectedAssignedRole() != null) {
					PersonRolePresenter.this.getSelectedPerson().removeRole(PersonRolePresenter.this.getSelectedAssignedRole());
					PersonRolePresenter.this.updateGuiTables();
				}
			}
		});
	}

	/**
	 * Returns the selected Person of the CellTable.
	 * @return selected Person
	 */
	private Person getSelectedPerson() {
		SingleSelectionModel<IPerson> selPersModel = (SingleSelectionModel<IPerson>) personTable.getSelectionModel();
		Person selectedPerson = (Person) selPersModel.getSelectedObject();
		return selectedPerson;
	}
	
	/**
	 * Returns the selected Role of the CellList.
	 * @return selected Role from AssignedRolesList
	 */
	private Role getSelectedAssignedRole() {
		SingleSelectionModel<IRole> selAssignedRoleModel = (SingleSelectionModel<IRole>) assignedRoleList.getSelectionModel();
		Role selectedRole = (Role) selAssignedRoleModel.getSelectedObject();
		return selectedRole;
	}
	
	/**
	 * Returns a set of selected Roles from the list of available Roles.
	 * @return selected Roles
	 */
	private Set<IRole> getSelectedAvailRoles() {
		MultiSelectionModel<IRole> selAvailRoleModel = (MultiSelectionModel<IRole>) availRoleList.getSelectionModel();
		Set<IRole> selectedRoles = selAvailRoleModel.getSelectedSet();
		return selectedRoles;
	}

}
