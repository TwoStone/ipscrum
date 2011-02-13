package fhdw.ipscrum.client;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import fhdw.ipscrum.client.presenter.RootPresenter;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class IpScrum implements EntryPoint {

	/**
	 * This method is used to populate the model with demo-data.
	 */
	private void initDemodate() {

		// Initial Roles
		Role roleTSUser;
		try {
			roleTSUser = new Role("Ticketsystem-Benutzer");

			final Role roleScrummaster = new Role("Scrum-Master");
			final Role roleProductOwner = new Role("Product-Owner");
			final Role roleDeveloper = new Role("Entwickler");
			final Role roleTester = new Role("Tester");
			final Role roleGUIWiz = new Role("GUI-Wizard");
			SessionManager.getInstance().getModel().addRole(roleTSUser);
			SessionManager.getInstance().getModel().addRole(roleScrummaster);
			SessionManager.getInstance().getModel().addRole(roleProductOwner);
			SessionManager.getInstance().getModel().addRole(roleDeveloper);
			SessionManager.getInstance().getModel().addRole(roleTester);
			SessionManager.getInstance().getModel().addRole(roleGUIWiz);

			// Initial Persons
			final Person pSarah = new Person("Sarah", "Gottwald");
			pSarah.addRole(roleScrummaster);
			pSarah.addRole(roleTSUser);

			final Person pWilken = new Person("Wilken", "Hustedt");
			pWilken.addRole(roleDeveloper);
			pWilken.addRole(roleGUIWiz);
			pWilken.addRole(roleTSUser);

			final Person pChristin = new Person("Christin", "Weckbrod");
			pChristin.addRole(roleProductOwner);
			pChristin.addRole(roleDeveloper);
			pChristin.addRole(roleTSUser);

			final Person pNils = new Person("Nils", "Vincent");
			pNils.addRole(roleTester);
			pNils.addRole(roleTSUser);

			SessionManager.getInstance().getModel().addPerson(pSarah);
			SessionManager.getInstance().getModel().addPerson(pWilken);
			SessionManager.getInstance().getModel().addPerson(pChristin);
			SessionManager.getInstance().getModel().addPerson(pNils);

			// Initial Teams
			final Team t1 = new Team("Frontend");
			t1.addMember(pSarah);
			t1.addMember(pWilken);

			final Team t2 = new Team("Backend");
			t2.addMember(pChristin);
			t2.addMember(pNils);

			SessionManager.getInstance().getModel().addTeam(t1);
			SessionManager.getInstance().getModel().addTeam(t2);

			// Initial Projects
			try {
				Project project1 = new Project("Testprojekt 4");
				Project project2 = new Project("Testprojekt 5");
				try {
					Release release1 = new Release("1.1", new Date(), project1);
					Release release2 = new Release("1.2", new Date(), project1);
					Release release3 = new Release("1.3", new Date(), project1);
					Release release4 = new Release("2.0", new Date(), project1);
					Release release5 = new Release("2.1", new Date(), project1);
					try {
						Feature f1 = new Feature("Feature 1", "Beschreibung Feature 1", project1.getBacklog());
						Feature f2 = new Feature("Feature 2", "Beschreibung Feature 2", project1.getBacklog());
						Feature f3 = new Feature("Feature 3", "Beschreibung Feature 3", project1.getBacklog());
						project1.getBacklog().addItem(f1);
						project1.getBacklog().addItem(f2);
						project1.getBacklog().addItem(f3);
					} catch (UserException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					project1.addRelease(release1);
					project1.addRelease(release2);
					project1.addRelease(release3);
					Sprint sprint1 = new Sprint("Beschreibung Sprint 1", new Date(), new Date(), t1);
					Sprint sprint2 = new Sprint("Beschreibung Sprint 2", new Date(), new Date(), t2);
					Sprint sprint3 = new Sprint("Beschreibung Sprint 3", new Date(), new Date(), t1);
					Sprint sprint4 = new Sprint("Beschreibung Sprint 4", new Date(), new Date(), t1);
					Sprint sprint5 = new Sprint("Beschreibung Sprint 5", new Date(), new Date(), t2);
					project1.addSprint(sprint1);
					project1.addSprint(sprint2);
					project1.addSprint(sprint3);
					project2.addRelease(release4);
					project2.addRelease(release5);
					project2.addSprint(sprint4);
					project2.addSprint(sprint3);

					try {
						release2.addSprint(sprint1);
						release2.addSprint(sprint2);
						release5.addSprint(sprint1);
					} catch (UserException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} catch (DoubleDefinitionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 1"));
				SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 2"));
				SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 3"));
				SessionManager.getInstance().getModel().addProject(project1);
				SessionManager.getInstance().getModel().addProject(project2);
			} catch (final NoValidValueException e) {
				// Da sp��ter entfernt wird, wird diese Meldung zun�chst nicht
				// beachtet!
			} catch (final ConsistencyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoValidValueException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} catch (ConsistencyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		if (SessionManager.getInstance().getModel().countRoles() == 0) {
			this.initDemodate();
		}

		new RootPresenter(RootPanel.get("mainPanel"));
	}
}
