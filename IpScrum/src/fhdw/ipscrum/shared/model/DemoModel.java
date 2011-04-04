package fhdw.ipscrum.shared.model;

import java.util.Date;

import fhdw.ipscrum.client.utils.CalendarUtils;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.interfaces.ISystem;
import fhdw.ipscrum.shared.model.search.And;
import fhdw.ipscrum.shared.model.search.MultiLogicSearchOperator;
import fhdw.ipscrum.shared.model.search.Search;
import fhdw.ipscrum.shared.model.search.SearchExpression;
import fhdw.ipscrum.shared.model.search.criteria.PBINameCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIProjectCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIReleaseCriterion;

public class DemoModel {

	@SuppressWarnings("deprecation")
	public static void populateModel(final Root model) throws UserException {

		final Root root = model;

		// Initial Systems
		final ISystem rootSystem = root.getSysManager().getSystems();
		final System betriebssysteme = new System("Betriebssysteme", rootSystem);
		final System browser = new System("Browser", rootSystem);
		final System applicationServer = new System("ApplicationServer",
				rootSystem);
		final System anwendungen = new System("Anwendungen", rootSystem);
		final System firefox = new System("Firefox", browser);
		final System iexplorer = new System("InternetExplorer", browser);
		final System windows = new System("Windows", betriebssysteme);
		final System winxp = new System("XP", windows);
		final System winvista = new System("Vista", windows);
		final System win7 = new System("7", windows);
		final System sap = new System("SAP", anwendungen);
		final System saphr = new System("HR", sap);
		final System sapbw = new System("BW", sap);

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

		final Person pAngelina = new Person("Angelina", "Jung");
		pAngelina.addRole(roleDeveloper);
		pAngelina.addRole(roleTSUser);

		final Person pTimo = new Person("Timo", "Hochwald");
		pTimo.addRole(roleTester);
		pTimo.addRole(roleDeveloper);
		pTimo.addRole(roleTSUser);

		final Person pStefan = new Person("Stefan", "Pietsch");
		pStefan.addRole(roleDeveloper);
		pStefan.addRole(roleTSUser);

		root.addPerson(pSarah);
		root.addPerson(pWilken);
		root.addPerson(pChristin);
		root.addPerson(pNils);
		root.addPerson(pChris);
		root.addPerson(pAngelina);
		root.addPerson(pTimo);
		root.addPerson(pStefan);

		// Initial Teams
		final Team teamFrontend = new Team("Frontend");
		teamFrontend.addMember(pSarah);
		teamFrontend.addMember(pWilken);

		final Team teamBackend = new Team("Backend");
		teamBackend.addMember(pChristin);
		teamBackend.addMember(pNils);

		final Team teamReporting = new Team("Reporting");
		teamReporting.addMember(pChris);
		teamReporting.addMember(pSarah);
		teamReporting.addMember(pWilken);
		teamReporting.addMember(pNils);
		teamReporting.addMember(pTimo);
		teamReporting.addMember(pAngelina);
		teamReporting.addMember(pStefan);

		final Team teamTesting = new Team("Testing");
		teamTesting.addMember(pChris);
		teamTesting.addMember(pNils);

		root.addTeam(teamFrontend);
		root.addTeam(teamBackend);
		root.addTeam(teamReporting);
		root.addTeam(teamTesting);

		// Initial Projects
		final Project projekt1 = new Project("Projekt 1");
		final Project projekt2 = new Project("Projekt 2");
		final Project ipScrum = new Project("IP-Scrum");

		ipScrum.addSystem(browser);
		projekt1.addSystem(win7);
		projekt1.addSystem(winxp);
		projekt2.addSystem(sapbw);

		// Initial Releases
		final Release rel10 = new Release("1.0",
				CalendarUtils.getRandomReleaseDate(), projekt1);
		final Release rel13 = new Release("1.3",
				CalendarUtils.getRandomReleaseDate(), projekt1);
		final Release rel20 = new Release("2.0",
				CalendarUtils.getRandomReleaseDate(), projekt2);
		final Release phase3 = new Release("Phase III", new Date(2011 - 1900,
				3 - 1, 9), ipScrum);
		final Release phase4 = new Release("Phase IV", new Date(2011 - 1900,
				4 - 1, 8), ipScrum);

		// Initial Sprints
		final Date sprint1BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		final Date sprint1EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint1BeginDate, rel10.getReleaseDate());
		final Sprint sprint1rel10 = new Sprint("Sprint1",
				"Beschreibung Sprint 1", sprint1BeginDate, sprint1EndDate,
				teamFrontend);

		final Date sprint2BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		final Date sprint2EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint2BeginDate, rel10.getReleaseDate());
		final Sprint sprint2rel10 = new Sprint("Sprint2",
				"Beschreibung Sprint 2", sprint2BeginDate, sprint2EndDate,
				teamBackend);

		final Date sprint3BeginDate = new Date();
		final Date sprint3EndDate = new Date();
		CalendarUtils.removeDaysFromDate(sprint3BeginDate, 6);
		CalendarUtils.removeDaysFromDate(sprint3EndDate, 4);
		final Sprint sprint3rel10 = new Sprint("Sprint3",
				"Beschreibung Sprint 3", sprint3BeginDate, sprint3EndDate,
				teamFrontend);

		final Date sprint4BeginDate = new Date();
		final Date sprint4EndDate = new Date();
		CalendarUtils.removeDaysFromDate(sprint4BeginDate, 8);
		CalendarUtils.removeDaysFromDate(sprint4EndDate, 1);
		final Sprint sprint4rel10 = new Sprint("Sprint4",
				"Beschreibung Sprint 4", sprint4BeginDate, sprint4EndDate,
				teamFrontend);

		final Date sprint5BeginDate = new Date();
		final Date sprint5EndDate = new Date();
		CalendarUtils.removeDaysFromDate(sprint5BeginDate, 9);
		CalendarUtils.removeDaysFromDate(sprint5EndDate, 4);
		final Sprint sprint5rel10 = new Sprint("Sprint5",
				"Beschreibung Sprint 5", sprint5BeginDate, sprint5EndDate,
				teamBackend);

		final Date sprint6BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		final Date sprint6EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint6BeginDate, rel13.getReleaseDate());
		final Sprint sprint6rel13 = new Sprint("Sprint6",
				"Beschreibung Sprint 6", sprint6BeginDate, sprint6EndDate,
				teamBackend);

		final Date sprint7BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		final Date sprint7EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint7BeginDate, rel20.getReleaseDate());
		final Sprint sprint7rel20 = new Sprint("Sprint7",
				"Beschreibung Sprint 7", sprint7BeginDate, sprint7EndDate,
				teamBackend);

		final Date sprint8BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		final Date sprint8EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint8BeginDate, rel20.getReleaseDate());
		final Sprint sprint8rel20 = new Sprint("Sprint8",
				"Beschreibung Sprint 8", sprint8BeginDate, sprint8EndDate,
				teamBackend);

		final Date sprint9BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		final Date sprint9EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint9BeginDate, rel20.getReleaseDate());
		final Sprint sprint9rel20 = new Sprint("Sprint9",
				"Beschreibung Sprint 9", sprint9BeginDate, sprint9EndDate,
				teamBackend);

		final Date sprint10BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		final Date sprint10EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint10BeginDate, rel20.getReleaseDate());
		final Sprint sprint10rel20 = new Sprint("Sprint10",
				"Beschreibung Sprint 10", sprint10BeginDate, sprint10EndDate,
				teamBackend);

		final Sprint taskboardRelPhase3 = new Sprint("Taskboard",
				"Bereitstellung von Task-Funktionalitäten", new Date(
						2011 - 1900, 2 - 1, 14),
				new Date(2011 - 1900, 3 - 1, 9), teamBackend);
		final Sprint reportingRelPhase3 = new Sprint("Reporting I",
				"Bereitstellung von Statistikelementen", new Date(2011 - 1900,
						2 - 1, 14), new Date(2011 - 1900, 3 - 1, 9),
				teamReporting);
		final Sprint ticketsRelPhase3 = new Sprint("Tickets II",
				"Bereitstellung von Bugtracking-Funktionen", new Date(
						2011 - 1900, 2 - 1, 14),
				new Date(2011 - 1900, 3 - 1, 9), teamBackend);

		final Sprint reporting2RelPhase4 = new Sprint(
				"Reporting II",
				"Projekthistorie, Sprintdetailerweiterungen und Velocitycharts",
				new Date(2011 - 1900, 3 - 1, 10), new Date(2011 - 1900, 4 - 1,
						8), teamReporting);

		// add possible Systems
		projekt1.addSystem(anwendungen);
		projekt2.addSystem(betriebssysteme);
		projekt2.addSystem(browser);
		projekt2.addSystem(applicationServer);
		ipScrum.addSystem(betriebssysteme);
		ipScrum.addSystem(browser);

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

		ipScrum.addSprint(reporting2RelPhase4);

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

		phase4.addSprint(reporting2RelPhase4);

		root.addProject(projekt1);
		root.addProject(projekt2);
		root.addProject(ipScrum);

		// Initial Features
		final Feature f1 = new Feature("Feature 1", "Beschreibung Feature 1",
				projekt1.getBacklog());
		f1.setLastEditor(pNils);
		f1.setManDayCosts(new Effort(11));
		f1.setSprint(sprint1rel10);
		f1.close();

		final Feature f2 = new Feature("Feature 2", "Beschreibung Feature 2",
				projekt1.getBacklog());
		f2.setLastEditor(pNils);
		f2.setManDayCosts(new Effort(4));
		f2.setSprint(sprint4rel10);
		f2.close();

		final Feature f3 = new Feature("Feature 3", "Beschreibung Feature 3",
				projekt1.getBacklog());
		f3.setLastEditor(pNils);
		f3.setManDayCosts(new Effort(4));
		f3.setSprint(sprint4rel10);
		f3.close();

		final Feature f4 = new Feature("Feature 4", "Beschreibung Feature 4",
				projekt1.getBacklog());
		f4.setLastEditor(pNils);
		f4.setManDayCosts(new Effort(12));
		f4.setSprint(sprint3rel10);
		f4.close();

		final Feature f5 = new Feature("Feature 5", "Beschreibung Feature 5",
				projekt1.getBacklog());
		f5.setLastEditor(pNils);
		f5.setManDayCosts(new Effort(10));
		f5.setSprint(sprint5rel10);
		f5.close();

		final Feature f6 = new Feature("Feature 6", "Beschreibung Feature 6",
				projekt1.getBacklog());
		f6.setLastEditor(pNils);
		f6.setManDayCosts(new Effort(5));
		f6.setSprint(sprint2rel10);
		f6.close();

		final Feature f7 = new Feature("Feature 7", "Beschreibung Feature 7",
				projekt2.getBacklog());
		f7.setLastEditor(pNils);
		f7.setManDayCosts(new Effort(7));
		f7.setSprint(sprint7rel20);

		final Feature f8 = new Feature("Feature 8", "Beschreibung Feature 8",
				projekt2.getBacklog());
		f8.setLastEditor(pNils);
		f8.setManDayCosts(new Effort(9));
		f8.setSprint(sprint7rel20);
		f8.close();

		final Feature f9 = new Feature("Sprint-BDChart", "Burndown-Auswertung",
				ipScrum.getBacklog());
		f9.setLastEditor(pWilken);
		f9.setManDayCosts(new Effort(20));
		f9.setSprint(reportingRelPhase3);
		f9.close();

		final Feature f10 = new Feature("Release-BDChart",
				"Burndown-Auswertung", ipScrum.getBacklog());
		f10.setLastEditor(pWilken);
		f10.setManDayCosts(new Effort(15));
		f10.setSprint(reportingRelPhase3);
		f10.close();

		final Feature f11 = new Feature("Reporting-Page", "Statistik-Bereich",
				ipScrum.getBacklog());
		f11.setLastEditor(pWilken);
		f11.setManDayCosts(new Effort(5));
		f11.setSprint(reportingRelPhase3);
		f11.close();

		final Feature f12 = new Feature("Projekthistorie",
				"Details zum Projektablauf", ipScrum.getBacklog());
		f12.setLastEditor(pWilken);
		f12.setManDayCosts(new Effort(15));
		f12.setSprint(reporting2RelPhase4);
		final Feature f13 = new Feature("Erweiterung Sprint-Details",
				"Mehr Detaileigenschaften im Sprint", ipScrum.getBacklog());
		f13.setLastEditor(pWilken);
		f13.setManDayCosts(new Effort(10));
		f13.setSprint(reporting2RelPhase4);
		final Feature f14 = new Feature("Velocitycharts",
				"Zur Analyse der Entwiklungsgeschwindigkeit",
				ipScrum.getBacklog());
		f14.setLastEditor(pWilken);
		f14.setManDayCosts(new Effort(15));
		f14.setSprint(reporting2RelPhase4);

		final Bug bug1 = new Bug(
				"Presenter",
				"Presenter sollten im Konstruktor keine Template method aufrufen.",
				phase3, ipScrum.getBacklog());

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
		ipScrum.getBacklog().addItem(f12);
		ipScrum.getBacklog().addItem(f13);
		ipScrum.getBacklog().addItem(f14);
		ipScrum.getBacklog().addItem(bug1);

		// Initial Relations
		RelationType.create("Abhängig von");
		RelationType.create("Siehe auch");

		// Initial Tasks
		final Task taskSBDCurve = new Task("Sprint Burndown-Curve",
				"Darstellung Sprint-Fortschritt");
		reportingRelPhase3.getSprintBacklog().addTask(taskSBDCurve);
		taskSBDCurve.addPBI(f9);
		taskSBDCurve.setPlanEffort(new Effort(5));
		taskSBDCurve.setResponsibility(pWilken);
		taskSBDCurve.finish(new Date(2011 - 1900, 3 - 1, 1));

		final Task taskSIdealCurve = new Task("Sprint Ideal-Curve",
				"Darstellung Ideal-Fortschritt");
		reportingRelPhase3.getSprintBacklog().addTask(taskSIdealCurve);
		taskSIdealCurve.addPBI(f9);
		taskSIdealCurve.setPlanEffort(new Effort(5));
		taskSIdealCurve.setResponsibility(pWilken);
		taskSIdealCurve.finish(new Date(2011 - 1900, 3 - 1, 1));

		final Task taskSTrendCurve = new Task("Sprint Trend-Curve",
				"Darstellung Trend");
		reportingRelPhase3.getSprintBacklog().addTask(taskSTrendCurve);
		taskSTrendCurve.addPBI(f9);
		taskSTrendCurve.setPlanEffort(new Effort(10));
		taskSTrendCurve.setResponsibility(pWilken);
		taskSTrendCurve.finish(new Date(2011 - 1900, 3 - 1, 5));

		final Task taskRBDCurve = new Task("Release Burndown-Curve",
				"Darstellung Release-Fortschritt");
		reportingRelPhase3.getSprintBacklog().addTask(taskRBDCurve);
		taskRBDCurve.addPBI(f10);
		taskRBDCurve.setPlanEffort(new Effort(5));
		taskRBDCurve.setResponsibility(pSarah);

		taskRBDCurve.finish(new Date(2011 - 1900, 2 - 1, 18));
		final Task taskRIdealCurve = new Task("Release Ideal-Curve",
				"Darstellung Release-Fortschritt");
		reportingRelPhase3.getSprintBacklog().addTask(taskRIdealCurve);
		taskRIdealCurve.addPBI(f10);
		taskRIdealCurve.setPlanEffort(new Effort(5));
		taskRIdealCurve.setResponsibility(pSarah);
		taskRIdealCurve.finish(new Date(2011 - 1900, 2 - 1, 19));

		final Task taskRTrendCurve = new Task("Release Trend-Curve",
				"Darstellung Release");
		reportingRelPhase3.getSprintBacklog().addTask(taskRTrendCurve);
		taskRTrendCurve.addPBI(f10);
		taskRTrendCurve.setPlanEffort(new Effort(5));
		taskRTrendCurve.setResponsibility(pSarah);
		taskRTrendCurve.finish(new Date(2011 - 1900, 2 - 1, 19));

		final Task taskReportView = new Task("Report View",
				"Report View-Komponente");
		reportingRelPhase3.getSprintBacklog().addTask(taskReportView);
		taskReportView.addPBI(f11);
		taskReportView.setPlanEffort(new Effort(4));
		taskReportView.setResponsibility(pChris);
		taskReportView.finish(new Date(2011 - 1900, 2 - 1, 17));

		final Task taskReportPresenter = new Task("Report Presenter",
				"Report Presenter-Komponente");
		reportingRelPhase3.getSprintBacklog().addTask(taskReportPresenter);
		taskReportPresenter.addPBI(f11);
		taskReportPresenter.setPlanEffort(new Effort(1));
		taskReportPresenter.setResponsibility(pChris);
		taskReportPresenter.finish(new Date(2011 - 1900, 2 - 1, 17));

		final Task taskTestdaten = new Task("Testdaten", "Demomodel aufräumen");
		reporting2RelPhase4.getSprintBacklog().addTask(taskTestdaten);
		taskTestdaten.addPBI(f12);
		taskTestdaten.addPBI(f13);
		taskTestdaten.addPBI(f14);
		taskTestdaten.setPlanEffort(new Effort(8));
		taskTestdaten.setResponsibility(pChris);
		// taskTestdaten.finish(new Date(2011 - 1900, 3 - 1, 23));

		final Task taskChartAnpassungen = new Task(
				"Implementierung Chart-Anpassungen",
				"Neuen Chart-Typ einführen");
		reporting2RelPhase4.getSprintBacklog().addTask(taskChartAnpassungen);
		taskChartAnpassungen.addPBI(f14);
		taskChartAnpassungen.setPlanEffort(new Effort(10));
		taskChartAnpassungen.setResponsibility(pWilken);
		// taskChartAnpassungen.finish(new Date(2011 - 1900, 3 - 1, 23));

		final Task taskProjektHistorieModell = new Task("PH-Modell",
				"Model für Projekthistorie entwickeln");
		reporting2RelPhase4.getSprintBacklog().addTask(
				taskProjektHistorieModell);
		taskProjektHistorieModell.addPBI(f12);
		taskProjektHistorieModell.setPlanEffort(new Effort(6));
		taskProjektHistorieModell.setResponsibility(pStefan);
		// taskProjektHistorieModell.finish(new Date(2011 - 1900, 3 - 1, 23));

		final Task taskProjektHistorieGUI = new Task("PH-GUI",
				"GUI für Projekthistorie entwickeln");
		reporting2RelPhase4.getSprintBacklog().addTask(taskProjektHistorieGUI);
		taskProjektHistorieGUI.addPBI(f12);
		taskProjektHistorieGUI.setPlanEffort(new Effort(5));
		taskProjektHistorieGUI.setResponsibility(pAngelina);
		// taskProjektHistorieGUI.finish(new Date(2011 - 1900, 3 - 1, 23));

		final Task taskSprintDetailsModell = new Task("SprintDetail-Modell",
				"Mehr Detaileigenschaften");
		reporting2RelPhase4.getSprintBacklog().addTask(taskSprintDetailsModell);
		taskSprintDetailsModell.addPBI(f13);
		taskSprintDetailsModell.setPlanEffort(new Effort(4));
		taskSprintDetailsModell.setResponsibility(pChris);
		// taskSprintDetailsModell.finish(new Date(2011 - 1900, 3 - 1, 23));

		final Task taskSprintDetailsGUI = new Task("SprintDetail-GUI",
				"Mehr Detaileigenschaften");
		reporting2RelPhase4.getSprintBacklog().addTask(taskSprintDetailsGUI);
		taskSprintDetailsGUI.addPBI(f13);
		taskSprintDetailsGUI.setPlanEffort(new Effort(3));
		taskSprintDetailsGUI.setResponsibility(pAngelina);
		// taskSprintDetailsGUI.finish(new Date(2011 - 1900, 3 - 1, 23));

		final Task taskGliederungsentwurf = new Task("Gliederungsentwurf",
				"Gliederung der Doku vorbereiten");
		reporting2RelPhase4.getSprintBacklog().addTask(taskGliederungsentwurf);
		taskGliederungsentwurf.addPBI(f12);
		taskGliederungsentwurf.addPBI(f13);
		taskGliederungsentwurf.addPBI(f14);
		taskGliederungsentwurf.setPlanEffort(new Effort(4));
		taskGliederungsentwurf.setResponsibility(pChris);
		// taskGliederungsentwurf.finish(new Date(2011 - 1900, 3 - 1, 23));

		final SearchExpression expr = new PBINameCriterion("Feature");
		final Search nameFeatureSuche = new Search("Name = Feature", expr);

		final MultiLogicSearchOperator and = new And();
		and.add(new PBIProjectCriterion(ipScrum));
		and.add(new PBIReleaseCriterion(phase4.getVersion()));
		final Search p4Suche = new Search("IpScrum Phase4", and);

		model.getSearchManager().addSearch(nameFeatureSuche);
		model.getSearchManager().addSearch(p4Suche);

	}
}