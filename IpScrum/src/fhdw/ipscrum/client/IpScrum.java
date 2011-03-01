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
import fhdw.ipscrum.shared.model.Root;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class IpScrum implements EntryPoint {

	private static final Root root = SessionManager.getInstance().getModel();

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		if (root.countRoles() == 0) {
			initDemodate();
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
			root.addRole(roleTSUser);
			root.addRole(roleScrummaster);
			root.addRole(roleProductOwner);
			root.addRole(roleDeveloper);
			root.addRole(roleTester);
			root.addRole(roleGUIWiz);

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

			root.addPerson(pSarah);
			root.addPerson(pWilken);
			root.addPerson(pChristin);
			root.addPerson(pNils);
			root.addPerson(pChris);

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

			root.addTeam(t1);
			root.addTeam(t2);
			root.addTeam(t3);

			// Initial Projects
			final Project project1r1 = new Project("Testprojekt 1");
			final Project project2r3 = new Project("Testprojekt 2");
			final Project project3r4 = new Project("IP-Scrum");

			// Initial Releases
			final Release release1p1 = new Release("1.2", CalendarUtils.getRandomReleaseDate(), project1r1);
			final Release release2p1 = new Release("2.0", CalendarUtils.getRandomReleaseDate(), project1r1);
			final Release release3p2 = new Release("1.0", CalendarUtils.getRandomReleaseDate(), project2r3);
			final Release release4p3 = new Release("Phase III", new Date(2011-1900,3-1,9), project3r4);

			// Initial Sprints
			Date sprint1BeginDate = CalendarUtils.getRandomDateOfThisMonth();
			Date sprint2BeginDate = CalendarUtils.getRandomDateOfThisMonth();
			Date sprint3BeginDate = CalendarUtils.getRandomDateOfThisMonth();
			Date sprint4BeginDate = CalendarUtils.getRandomDateOfThisMonth();
			Date sprint5BeginDate = CalendarUtils.getRandomDateOfThisMonth();
			Date sprint6BeginDate = CalendarUtils.getRandomDateOfThisMonth();
			Date sprint7BeginDate = CalendarUtils.getRandomDateOfThisMonth();
			Date sprint8BeginDate = CalendarUtils.getRandomDateOfThisMonth();
			Date sprint9BeginDate = CalendarUtils.getRandomDateOfThisMonth();
			Date sprint10BeginDate = CalendarUtils.getRandomDateOfThisMonth();

			final Sprint sprint1p1r1 = new Sprint("Sprint1", "Beschreibung Sprint 1", sprint1BeginDate, CalendarUtils.getRandomSprintEnddate(sprint1BeginDate, release1p1.getReleaseDate()), t1);
			final Sprint sprint2p1r1 = new Sprint("Sprint2", "Beschreibung Sprint 2", sprint2BeginDate, CalendarUtils.getRandomSprintEnddate(sprint2BeginDate, release1p1.getReleaseDate()), t2);
			final Sprint sprint3p1r1 = new Sprint("Sprint3", "Beschreibung Sprint 3", sprint3BeginDate, CalendarUtils.getRandomSprintEnddate(sprint3BeginDate, release1p1.getReleaseDate()), t1);
			final Sprint sprint4p1r1 = new Sprint("Sprint4", "Beschreibung Sprint 4", sprint4BeginDate, CalendarUtils.getRandomSprintEnddate(sprint4BeginDate, release1p1.getReleaseDate()), t1);
			final Sprint sprint5p1r1 = new Sprint("Sprint5", "Beschreibung Sprint 5", sprint5BeginDate, CalendarUtils.getRandomSprintEnddate(sprint5BeginDate, release1p1.getReleaseDate()), t2);
			final Sprint sprint6p1r1 = new Sprint("Sprint6", "Beschreibung Sprint 6", sprint6BeginDate, CalendarUtils.getRandomSprintEnddate(sprint6BeginDate, release1p1.getReleaseDate()), t2);
			final Sprint sprint7p2r3 = new Sprint("Sprint7", "Beschreibung Sprint 7", sprint7BeginDate, CalendarUtils.getRandomSprintEnddate(sprint7BeginDate, release3p2.getReleaseDate()), t2);
			final Sprint sprint8p2r3 = new Sprint("Sprint8", "Beschreibung Sprint 8", sprint8BeginDate, CalendarUtils.getRandomSprintEnddate(sprint8BeginDate, release3p2.getReleaseDate()), t2);
			final Sprint sprint9p2r3 = new Sprint("Sprint9", "Beschreibung Sprint 9", sprint9BeginDate, CalendarUtils.getRandomSprintEnddate(sprint9BeginDate, release3p2.getReleaseDate()), t2);
			final Sprint sprint10p2r3 = new Sprint("Sprint10", "Beschreibung Sprint 10", sprint10BeginDate, CalendarUtils.getRandomSprintEnddate(sprint10BeginDate, release3p2.getReleaseDate()), t2);
			final Sprint sprint11p3r4 = new Sprint("Taskboard", "Bereitstellung von Task-Funktionalitäten", new Date(2011-1900,2-1,14), new Date(2011-1900,3-1,9), t1);
			final Sprint sprint12p3r4 = new Sprint("Reporting I", "Bereitstellung von Statistikelementen", new Date(2011-1900,2-1,14), new Date(2011-1900,3-1,9), t3);
			final Sprint sprint13p3r4 = new Sprint("Tickets II", "Bereitstellung von Bugtracking-Funktionen", new Date(2011-1900,2-1,14), new Date(2011-1900,3-1,9), t2);

			project1r1.addSprint(sprint1p1r1);
			project1r1.addSprint(sprint2p1r1);
			project1r1.addSprint(sprint3p1r1);
			project1r1.addSprint(sprint4p1r1);
			project1r1.addSprint(sprint5p1r1);
			project1r1.addSprint(sprint6p1r1);
			project2r3.addSprint(sprint7p2r3);
			project2r3.addSprint(sprint8p2r3);
			project2r3.addSprint(sprint9p2r3);
			project2r3.addSprint(sprint10p2r3);
			project3r4.addSprint(sprint11p3r4);
			project3r4.addSprint(sprint12p3r4);
			project3r4.addSprint(sprint13p3r4);

			release1p1.addSprint(sprint1p1r1);
			release1p1.addSprint(sprint2p1r1);
			release1p1.addSprint(sprint3p1r1);
			release1p1.addSprint(sprint4p1r1);
			release1p1.addSprint(sprint5p1r1);
			release2p1.addSprint(sprint6p1r1);
			release3p2.addSprint(sprint7p2r3);
			release3p2.addSprint(sprint8p2r3);
			release3p2.addSprint(sprint9p2r3);
			release3p2.addSprint(sprint10p2r3);
			release4p3.addSprint(sprint11p3r4);
			release4p3.addSprint(sprint12p3r4);
			release4p3.addSprint(sprint13p3r4);

			root.addProject(project1r1);
			root.addProject(project2r3);
			root.addProject(project3r4);

			// Initial Features
			final Feature f1 = new Feature("Feature 1", "Beschreibung Feature 1", project1r1.getBacklog());
			final Feature f2 = new Feature("Feature 2", "Beschreibung Feature 2", project1r1.getBacklog());
			final Feature f3 = new Feature("Feature 3", "Beschreibung Feature 3", project1r1.getBacklog());

			final Feature f4 = new Feature("Sprint-BDChart", "Burndown-Auswertung", project3r4.getBacklog());
			f4.setLastEditor(pWilken);
			f4.setManDayCosts(20);
			f4.setSprint(sprint12p3r4);

			final Feature f5 = new Feature("Release-BDChart", "Burndown-Auswertung", project3r4.getBacklog());
			f5.setLastEditor(pWilken);
			f5.setManDayCosts(15);
			f5.setSprint(sprint12p3r4);

			project1r1.getBacklog().addItem(f1);
			project1r1.getBacklog().addItem(f2);
			project1r1.getBacklog().addItem(f3);
			project3r4.getBacklog().addItem(f4);
			project3r4.getBacklog().addItem(f5);

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
