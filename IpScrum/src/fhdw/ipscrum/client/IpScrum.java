package fhdw.ipscrum.client;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.RootPanel;

import fhdw.ipscrum.client.presenter.RootPresenter;
import fhdw.ipscrum.client.utils.CalendarUtils;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class IpScrum implements EntryPoint {

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

	/**
	 * This method is used to populate the model with demo-data.
	 */
	private void initDemodate() {

		try {
			// Initial Roles
			Role roleTSUser;
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

			final Person pChris = new Person("Christoph", "Stürzekarn");
			pChris.addRole(roleTester);
			pChris.addRole(roleDeveloper);
			pChris.addRole(roleTSUser);

			SessionManager.getInstance().getModel().addPerson(pSarah);
			SessionManager.getInstance().getModel().addPerson(pWilken);
			SessionManager.getInstance().getModel().addPerson(pChristin);
			SessionManager.getInstance().getModel().addPerson(pNils);
			SessionManager.getInstance().getModel().addPerson(pChris);

			// Initial Teams
			final Team t1 = new Team("Frontend");
			t1.addMember(pSarah);
			t1.addMember(pWilken);

			final Team t2 = new Team("Backend");
			t2.addMember(pChristin);
			t2.addMember(pNils);

			final Team t3 = new Team("Reporting");
			t3.addMember(pChris);
			t3.addMember(pSarah);
			t3.addMember(pWilken);

			SessionManager.getInstance().getModel().addTeam(t1);
			SessionManager.getInstance().getModel().addTeam(t2);
			SessionManager.getInstance().getModel().addTeam(t3);

			// Initial Projects
			final Project project1 = new Project("Testprojekt 4");
			final Project project2 = new Project("Testprojekt 5");
			final Project project3 = new Project("IP-Scrum");

			// Initial Releases
			final Release release1 = new Release("1.1", CalendarUtils.getRandomReleaseDate(), project1);
			final Release release2 = new Release("1.2", CalendarUtils.getRandomReleaseDate(), project1);
			final Release release3 = new Release("1.3", CalendarUtils.getRandomReleaseDate(), project1);
			final Release release4 = new Release("2.0", CalendarUtils.getRandomReleaseDate(), project1);
			final Release release5 = new Release("2.1", CalendarUtils.getRandomReleaseDate(), project1);
			final Release release6 = new Release("Phase III", new Date(2011-1900,3-1,9), project3);

			// Initial Sprints
			Date sprint1BeginDate = CalendarUtils.getRandomDateOfThisMonth();
			Date sprint2BeginDate = CalendarUtils.getRandomDateOfThisMonth();
			Date sprint3BeginDate = CalendarUtils.getRandomDateOfThisMonth();
			Date sprint4BeginDate = CalendarUtils.getRandomDateOfThisMonth();
			Date sprint5BeginDate = CalendarUtils.getRandomDateOfThisMonth();

			final Sprint sprint1 = new Sprint("Sprint1", "Beschreibung Sprint 1", sprint1BeginDate, CalendarUtils.getRandomSprintEnddate(sprint1BeginDate), t1);
			final Sprint sprint2 = new Sprint("Sprint2", "Beschreibung Sprint 2", sprint2BeginDate, CalendarUtils.getRandomSprintEnddate(sprint2BeginDate), t2);
			final Sprint sprint3 = new Sprint("Sprint3", "Beschreibung Sprint 3", sprint3BeginDate, CalendarUtils.getRandomSprintEnddate(sprint3BeginDate), t1);
			final Sprint sprint4 = new Sprint("Sprint4", "Beschreibung Sprint 4", sprint4BeginDate, CalendarUtils.getRandomSprintEnddate(sprint4BeginDate), t1);
			final Sprint sprint5 = new Sprint("Sprint5", "Beschreibung Sprint 5", sprint5BeginDate, CalendarUtils.getRandomSprintEnddate(sprint5BeginDate), t2);
			final Sprint sprint6 = new Sprint("Taskboard", "Bereitstellung von Task-Funktionalitäten", new Date(2011-1900,2-1,14), new Date(2011-1900,3-1,9), t3);
			final Sprint sprint7 = new Sprint("Reporting I", "Bereitstellung von Statistikelementen", new Date(2011-1900,2-1,14), new Date(2011-1900,3-1,9), t1);
			final Sprint sprint8 = new Sprint("Tickets II", "Bereitstellung von Bugtracking-Funktionen", new Date(2011-1900,2-1,14), new Date(2011-1900,3-1,9), t2);

			project1.addSprint(sprint1);
			project1.addSprint(sprint2);
			project1.addSprint(sprint3);
			project2.addSprint(sprint4);
			project2.addSprint(sprint5);
			project3.addSprint(sprint6);
			project3.addSprint(sprint7);
			project3.addSprint(sprint8);

			// Initial Features
			final Feature f1 = new Feature("Feature 1", "Beschreibung Feature 1", project1.getBacklog());
			final Feature f2 = new Feature("Feature 2", "Beschreibung Feature 2", project1.getBacklog());
			final Feature f3 = new Feature("Feature 3", "Beschreibung Feature 3", project1.getBacklog());

			final Feature f4 = new Feature("Sprint-BDChart", "Burndown-Auswertung", project3.getBacklog());
			f4.setLastEditor(pWilken);
			f4.setManDayCosts(20);
			f4.setSprint(sprint7);

			final Feature f5 = new Feature("Release-BDChart", "Burndown-Auswertung", project3.getBacklog());
			f5.setLastEditor(pWilken);
			f5.setManDayCosts(15);
			f5.setSprint(sprint7);

			project1.getBacklog().addItem(f1);
			project1.getBacklog().addItem(f2);
			project1.getBacklog().addItem(f3);
			project3.getBacklog().addItem(f4);
			project3.getBacklog().addItem(f5);

			release2.addSprint(sprint1);
			release2.addSprint(sprint2);
			release5.addSprint(sprint3);
			release6.addSprint(sprint6);
			release6.addSprint(sprint7);
			release6.addSprint(sprint8);

			SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 1"));
			SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 2"));
			SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 3"));
			SessionManager.getInstance().getModel().addProject(project1);
			SessionManager.getInstance().getModel().addProject(project2);
			SessionManager.getInstance().getModel().addProject(project3);

			// Initial Relations
			RelationType.create("Abhängig von");
			RelationType.create("Siehe auch");

		} catch (NoValidValueException e) {
			Window.alert(e.getMessage());
		} catch (DoubleDefinitionException e) {
			Window.alert(e.getMessage());
		} catch (ConsistencyException e) {
			Window.alert(e.getMessage());
		} catch (ForbiddenStateException e) {
			Window.alert(e.getMessage());
		} catch (NoSprintDefinedException e) {
			Window.alert(e.getMessage());
		} catch (UserException e) {
			Window.alert(e.getMessage());
		}

	}
}
