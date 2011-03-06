package fhdw.ipscrum.shared.model;

import java.util.Date;

import fhdw.ipscrum.client.utils.CalendarUtils;
import fhdw.ipscrum.shared.exceptions.UserException;

public class DemoModel {

	@SuppressWarnings("deprecation")
	public static void populateModel(Root model) throws UserException {

		final Root root = model;

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
		final Team team1 = new Team("Frontend");
		team1.addMember(pSarah);
		team1.addMember(pWilken);

		final Team team2 = new Team("Backend");
		team2.addMember(pChristin);
		team2.addMember(pNils);

		final Team team3 = new Team("Reporting");
		team3.addMember(pChris);
		team3.addMember(pSarah);
		team3.addMember(pWilken);

		final Team team4 = new Team("Testing");
		team4.addMember(pChris);
		team4.addMember(pNils);

		root.addTeam(team1);
		root.addTeam(team2);
		root.addTeam(team3);
		root.addTeam(team4);

		// Initial Projects
		final Project projekt1 = new Project("Projekt 1");
		final Project projekt2 = new Project("Projekt 2");
		final Project ipScrum = new Project("IP-Scrum");

		// Initial Releases
		final Release rel10 = new Release("1.0",
				CalendarUtils.getRandomReleaseDate(), projekt1);
		final Release rel13 = new Release("1.3",
				CalendarUtils.getRandomReleaseDate(), projekt1);
		final Release rel20 = new Release("2.0",
				CalendarUtils.getRandomReleaseDate(), projekt2);
		final Release phase3 = new Release("Phase III", new Date(2011 - 1900,
				3 - 1, 9), ipScrum);

		// Initial Sprints
		final Date sprint1BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		final Date sprint1EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint1BeginDate, rel10.getReleaseDate());
		final Sprint sprint1rel10 = new Sprint("Sprint1",
				"Beschreibung Sprint 1", sprint1BeginDate, sprint1EndDate,
				team1);

		final Date sprint2BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		final Date sprint2EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint2BeginDate, rel10.getReleaseDate());
		final Sprint sprint2rel10 = new Sprint("Sprint2",
				"Beschreibung Sprint 2", sprint2BeginDate, sprint2EndDate,
				team2);

		final Date sprint3BeginDate = new Date();
		final Date sprint3EndDate = new Date();
		CalendarUtils.removeDaysFromDate(sprint3BeginDate, 6);
		CalendarUtils.removeDaysFromDate(sprint3EndDate, 4);
		final Sprint sprint3rel10 = new Sprint("Sprint3",
				"Beschreibung Sprint 3", sprint3BeginDate, sprint3EndDate,
				team1);

		final Date sprint4BeginDate = new Date();
		final Date sprint4EndDate = new Date();
		CalendarUtils.removeDaysFromDate(sprint4BeginDate, 8);
		CalendarUtils.removeDaysFromDate(sprint4EndDate, 1);
		final Sprint sprint4rel10 = new Sprint("Sprint4",
				"Beschreibung Sprint 4", sprint4BeginDate, sprint4EndDate,
				team1);

		final Date sprint5BeginDate = new Date();
		final Date sprint5EndDate = new Date();
		CalendarUtils.removeDaysFromDate(sprint5BeginDate, 9);
		CalendarUtils.removeDaysFromDate(sprint5EndDate, 4);
		final Sprint sprint5rel10 = new Sprint("Sprint5",
				"Beschreibung Sprint 5", sprint5BeginDate, sprint5EndDate,
				team2);

		final Date sprint6BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		final Date sprint6EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint6BeginDate, rel13.getReleaseDate());
		final Sprint sprint6rel13 = new Sprint("Sprint6",
				"Beschreibung Sprint 6", sprint6BeginDate, sprint6EndDate,
				team2);

		final Date sprint7BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		final Date sprint7EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint7BeginDate, rel20.getReleaseDate());
		final Sprint sprint7rel20 = new Sprint("Sprint7",
				"Beschreibung Sprint 7", sprint7BeginDate, sprint7EndDate,
				team2);

		final Date sprint8BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		final Date sprint8EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint8BeginDate, rel20.getReleaseDate());
		final Sprint sprint8rel20 = new Sprint("Sprint8",
				"Beschreibung Sprint 8", sprint8BeginDate, sprint8EndDate,
				team2);

		final Date sprint9BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		final Date sprint9EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint9BeginDate, rel20.getReleaseDate());
		final Sprint sprint9rel20 = new Sprint("Sprint9",
				"Beschreibung Sprint 9", sprint9BeginDate, sprint9EndDate,
				team2);

		final Date sprint10BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		final Date sprint10EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint10BeginDate, rel20.getReleaseDate());
		final Sprint sprint10rel20 = new Sprint("Sprint10",
				"Beschreibung Sprint 10", sprint10BeginDate, sprint10EndDate,
				team2);

		final Sprint taskboardRelPhase3 = new Sprint("Taskboard",
				"Bereitstellung von Task-Funktionalitäten", new Date(
						2011 - 1900, 2 - 1, 14),
						new Date(2011 - 1900, 3 - 1, 9), team1);
		final Sprint reportingRelPhase3 = new Sprint("Reporting I",
				"Bereitstellung von Statistikelementen", new Date(2011 - 1900,
						2 - 1, 14), new Date(2011 - 1900, 3 - 1, 9), team3);
		final Sprint ticketsRelPhase3 = new Sprint("Tickets II",
				"Bereitstellung von Bugtracking-Funktionen", new Date(
						2011 - 1900, 2 - 1, 14),
						new Date(2011 - 1900, 3 - 1, 9), team2);

		// assigning sprints to projects
		projekt1.addSprint(sprint1rel10);
		projekt1.addSprint(sprint2rel10);
		projekt1.addSprint(sprint3rel10);
		projekt1.addSprint(sprint4rel10);
		projekt1.addSprint(sprint5rel10);
		projekt1.addSprint(sprint6rel13);

		projekt2.addSprint(sprint7rel20);
		projekt2.addSprint(sprint8rel20);
		projekt2.addSprint(sprint9rel20);
		projekt2.addSprint(sprint10rel20);

		ipScrum.addSprint(taskboardRelPhase3);
		ipScrum.addSprint(reportingRelPhase3);
		ipScrum.addSprint(ticketsRelPhase3);

		// assigning sprints to releases
		rel10.addSprint(sprint1rel10);
		rel10.addSprint(sprint2rel10);
		rel10.addSprint(sprint3rel10);
		rel10.addSprint(sprint4rel10);
		rel10.addSprint(sprint5rel10);
		rel13.addSprint(sprint6rel13);

		rel20.addSprint(sprint7rel20);
		rel20.addSprint(sprint8rel20);
		rel20.addSprint(sprint9rel20);
		rel20.addSprint(sprint10rel20);

		phase3.addSprint(taskboardRelPhase3);
		phase3.addSprint(reportingRelPhase3);
		phase3.addSprint(ticketsRelPhase3);

		root.addProject(projekt1);
		root.addProject(projekt2);
		root.addProject(ipScrum);

		// Initial Features
		final Feature f1 = new Feature("Feature 1", "Beschreibung Feature 1",
				projekt1.getBacklog());
		f1.setLastEditor(pNils);
		f1.setManDayCosts(6);
		f1.setSprint(sprint1rel10);
		f1.close();

		final Feature f2 = new Feature("Feature 2", "Beschreibung Feature 2",
				projekt1.getBacklog());
		f2.setLastEditor(pNils);
		f2.setManDayCosts(4);
		f2.setSprint(sprint4rel10);
		f2.close();

		final Feature f3 = new Feature("Feature 3", "Beschreibung Feature 3",
				projekt1.getBacklog());
		f3.setLastEditor(pNils);
		f3.setManDayCosts(4);
		f3.setSprint(sprint4rel10);
		f3.close();

		final Feature f4 = new Feature("Feature 4", "Beschreibung Feature 4",
				projekt1.getBacklog());
		f4.setLastEditor(pNils);
		f4.setManDayCosts(12);
		f4.setSprint(sprint3rel10);
		f4.close();


		final Feature f5 = new Feature("Feature 5", "Beschreibung Feature 5",
				projekt1.getBacklog());
		f5.setLastEditor(pNils);
		f5.setManDayCosts(10);
		f5.setSprint(sprint5rel10);
		f5.close();


		final Feature f6 = new Feature("Feature 6", "Beschreibung Feature 6",
				projekt1.getBacklog());
		f6.setLastEditor(pNils);
		f6.setManDayCosts(5);
		f6.setSprint(sprint2rel10);
		f6.close();


		final Feature f7 = new Feature("Feature 7", "Beschreibung Feature 7",
				projekt2.getBacklog());
		f7.setLastEditor(pNils);
		f7.setManDayCosts(7);
		f7.setSprint(sprint7rel20);

		final Feature f8 = new Feature("Feature 8", "Beschreibung Feature 8",
				projekt2.getBacklog());
		f8.setLastEditor(pNils);
		f8.setManDayCosts(9);
		f8.setSprint(sprint7rel20);
		f8.close();

		final Feature f9 = new Feature("Sprint-BDChart", "Burndown-Auswertung", ipScrum.getBacklog());
		f9.setLastEditor(pWilken);
		f9.setManDayCosts(20);
		f9.setSprint(reportingRelPhase3);
		//		f9.close();

		final Feature f10 = new Feature("Release-BDChart", "Burndown-Auswertung", ipScrum.getBacklog());
		f10.setLastEditor(pWilken);
		f10.setManDayCosts(15);
		f10.setSprint(reportingRelPhase3);
		//		f10.close();

		final Feature f11 = new Feature("Reporting-Page", "Statistik-Bereich", ipScrum.getBacklog());
		f11.setLastEditor(pWilken);
		f11.setManDayCosts(5);
		f11.setSprint(reportingRelPhase3);
		//		f11.close();

		// adding features to projects
		projekt1.getBacklog().addItem(f1);
		projekt1.getBacklog().addItem(f2);
		projekt1.getBacklog().addItem(f3);
		projekt1.getBacklog().addItem(f4);
		projekt1.getBacklog().addItem(f5);
		projekt1.getBacklog().addItem(f6);

		projekt2.getBacklog().addItem(f7);
		projekt2.getBacklog().addItem(f8);

		ipScrum.getBacklog().addItem(f9);
		ipScrum.getBacklog().addItem(f10);
		ipScrum.getBacklog().addItem(f11);

		// Initial Relations
		RelationType.create("Abhängig von");
		RelationType.create("Siehe auch");

		// Initial Tasks
		Task taskSBDCurve = new Task("Sprint: Burndown-Curve", "Darstellung Sprint-Fortschritt");
		reportingRelPhase3.getSprintBacklog().addTask(taskSBDCurve);
		taskSBDCurve.addPBI(f9);
		taskSBDCurve.setPlanEffort(5);
		taskSBDCurve.setResponsibility(pWilken);

		Task taskSIdealCurve = new Task("Sprint: Ideal-Curve", "Darstellung Ideal-Fortschritt");
		reportingRelPhase3.getSprintBacklog().addTask(taskSIdealCurve);
		taskSIdealCurve.addPBI(f9);
		taskSIdealCurve.setPlanEffort(5);
		taskSIdealCurve.setResponsibility(pWilken);

		Task taskSTrendCurve = new Task("Sprint: Trend-Curve", "Darstellung Trend");
		reportingRelPhase3.getSprintBacklog().addTask(taskSTrendCurve);
		taskSTrendCurve.addPBI(f9);
		taskSTrendCurve.setPlanEffort(10);
		taskSTrendCurve.setResponsibility(pWilken);


		Task taskRBDCurve = new Task("Release: Burndown-Curve", "Darstellung Release-Fortschritt");
		reportingRelPhase3.getSprintBacklog().addTask(taskRBDCurve);
		taskRBDCurve.addPBI(f10);
		taskRBDCurve.setPlanEffort(5);
		taskRBDCurve.setResponsibility(pSarah);

		Task taskRIdealCurve = new Task("Release: Ideal-Curve", "Darstellung Release-Fortschritt");
		reportingRelPhase3.getSprintBacklog().addTask(taskRIdealCurve);
		taskRIdealCurve.addPBI(f10);
		taskRIdealCurve.setPlanEffort(5);
		taskRIdealCurve.setResponsibility(pSarah);

		Task taskRTrendCurve = new Task("Release: Trend-Curve", "Darstellung Release");
		reportingRelPhase3.getSprintBacklog().addTask(taskRTrendCurve);
		taskRTrendCurve.addPBI(f10);
		taskRTrendCurve.setPlanEffort(5);
		taskRTrendCurve.setResponsibility(pSarah);


		Task taskReportView = new Task("Report: View", "Report: View-Komponente");
		reportingRelPhase3.getSprintBacklog().addTask(taskReportView);
		taskReportView.addPBI(f11);
		taskReportView.setPlanEffort(4);
		taskReportView.setResponsibility(pChris);

		Task taskReportPresenter = new Task("Report: Presenter", "Report: Presenter-Komponente");
		reportingRelPhase3.getSprintBacklog().addTask(taskReportPresenter);
		taskReportPresenter.addPBI(f11);
		taskReportPresenter.setPlanEffort(1);
		taskReportPresenter.setResponsibility(pChris);
	}
}