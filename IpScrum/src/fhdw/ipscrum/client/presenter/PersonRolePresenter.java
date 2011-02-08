package fhdw.ipscrum.client.presenter;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.view.PersonRoleView;
import fhdw.ipscrum.client.view.interfaces.IPersonRoleView;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;

public class PersonRolePresenter extends Presenter<IPersonRoleView> {

	
	private List<Role> roleList;
	private List<Person> personList;
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
		
		return concreteView;
	}

	/**
	 * 
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
				SingleSelectionModel<IPerson> selPersModel = (SingleSelectionModel<IPerson>) concreteView.getCellTablePersons().getSelectionModel();
				Person selectedPerson = (Person) selPersModel.getSelectedObject();
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
		roleList = Arrays.asList(roleTSUser,roleScrummaster,roleProductOwner,roleDeveloper,roleTester,roleGUIWiz);
		
		
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
		
		personList = Arrays.asList(pSarah, pWilken, pChristin, pNils);
	}

}
