package fhdw.ipscrum.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import fhdw.ipscrum.client.presenter.RootPresenter;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Role;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class IpScrum implements EntryPoint {
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		if (SessionManager.getInstance().getModel().countRoles() == 0) {
			this.initDemodate();
		}
		
		new RootPresenter(RootPanel.get("mainPanel"));
	}

	/**
	 * This method is used to populate the model with demo-data.
	 */
	private void initDemodate() {
		
		// Initial Roles
		Role roleTSUser = new Role("Ticketsystem-Benutzer");
		Role roleScrummaster = new Role("Scrum-Master");
		Role roleProductOwner = new Role("Product-Owner");
		Role roleDeveloper = new Role("Entwickler");
		Role roleTester = new Role("Tester");
		Role roleGUIWiz = new Role("GUI-Wizard");
		SessionManager.getInstance().getModel().addRole(roleTSUser);
		SessionManager.getInstance().getModel().addRole(roleScrummaster);
		SessionManager.getInstance().getModel().addRole(roleProductOwner);
		SessionManager.getInstance().getModel().addRole(roleDeveloper);
		SessionManager.getInstance().getModel().addRole(roleTester);
		SessionManager.getInstance().getModel().addRole(roleGUIWiz);
		
		// Initial Persons
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
		
		SessionManager.getInstance().getModel().addPerson(pSarah);
		SessionManager.getInstance().getModel().addPerson(pWilken);
		SessionManager.getInstance().getModel().addPerson(pChristin);
		SessionManager.getInstance().getModel().addPerson(pNils);
		
		// Initial Projects
		try {
			SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 1"));
			SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 2"));
			SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 3"));
		} catch (NoValidValueException e) {
			//Da später entfernt wird, wird diese Meldung zunächst nicht beachtet!
		}
	}
 }
	
