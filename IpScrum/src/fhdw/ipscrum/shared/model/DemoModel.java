package fhdw.ipscrum.shared.model;

import java.util.Date;

import fhdw.ipscrum.client.utils.CalendarUtils;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.CycleException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.incidents.IncidentType;
import fhdw.ipscrum.shared.model.interfaces.ISystem;
import fhdw.ipscrum.shared.model.search.And;
import fhdw.ipscrum.shared.model.search.MultiLogicSearchOperator;
import fhdw.ipscrum.shared.model.search.Search;
import fhdw.ipscrum.shared.model.search.SearchExpression;
import fhdw.ipscrum.shared.model.search.criteria.PBINameCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIProjectCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIReleaseNameCriterion;

public class DemoModel {

	@SuppressWarnings( { "deprecation", "unused" })
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
		final Release rel10 = new Release("1.0", CalendarUtils
				.getRandomReleaseDate(), projekt1);
		final Release rel13 = new Release("1.3", CalendarUtils
				.getRandomReleaseDate(), projekt1);
		final Release rel20 = new Release("2.0", CalendarUtils
				.getRandomReleaseDate(), projekt2);
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
				"Zur Analyse der Entwiklungsgeschwindigkeit", ipScrum
						.getBacklog());
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
		try {
			and.add(new PBIProjectCriterion(ipScrum));
			and.add(new PBIReleaseNameCriterion(phase4.getVersion()));
		} catch (final CycleException e) {
			// da Demodaten, kann hier kein Fehler auftreten!
			// Dafür wird gesorgt!
		}
		final Search p4Suche = new Search("IpScrum Phase4", and);

		model.getSearchManager().addSearch(nameFeatureSuche);
		model.getSearchManager().addSearch(p4Suche);
		
		//******************************************************************
		//******************************************************************
		//******************************************************************
		//******************************************************************
		
		// data for Velocity
		
		//******************************************************************
		//******************************************************************
		//******************************************************************
		//******************************************************************
		
		// Initial Projects
		final Project velocity1 = new Project("Velocity 1");
		final Project velocity2 = new Project("Velocity 2");
		
		velocity1.addSystem(win7);
		velocity1.addSystem(winxp);
		velocity2.addSystem(anwendungen);
		velocity2.addSystem(betriebssysteme);
		velocity1.addSystem(browser);
		velocity2.addSystem(applicationServer);
		
		// Initial Releases
		final Release relV1R1 = new Release("0.9", new Date(2011 - 1900, 1 - 1, 31), velocity1);
		final Release relV1R2 = new Release("1.0", new Date(2011 - 1900, 3 - 1, 28), velocity1);
		final Release relV2R1 = new Release("0.5", new Date(2011 - 1900, 3 - 1, 21), velocity2);

		// Initial Sprints for v1r1
		final Sprint sprint1relV1R1 = new Sprint("Velocity1 Sprint1", "Beschreibung Sprint 1", 
				new Date(2010 - 1900, 12 - 1, 20), new Date(2010 - 1900, 12 - 1, 30),
				teamBackend);
		final Sprint sprint2relV1R1 = new Sprint("Velocity1 Sprint2", "Beschreibung Sprint 2", 
				new Date(2011 - 1900, 1 - 1, 3), new Date(2011 - 1900, 1 - 1, 18),
				teamFrontend);
		final Sprint sprint3relV1R1 = new Sprint("Velocity1 Sprint3", "Beschreibung Sprint 3", 
				new Date(2011 - 1900, 1 - 1, 19), new Date(2011 - 1900, 1 - 1, 28),
				teamTesting);
		
		// Initial Sprints for v1r2
		final Sprint sprint1relV1R2 = new Sprint("Velocity1 Sprint4", "Beschreibung Sprint 4", 
				new Date(2011 - 1900, 1 - 1, 31), new Date(2011 - 1900, 2 - 1, 8),
				teamBackend);
		final Sprint sprint2relV1R2 = new Sprint("Velocity1 Sprint5", "Beschreibung Sprint 5", 
				new Date(2011 - 1900, 2 - 1, 9), new Date(2011 - 1900, 2 - 1, 16),
				teamFrontend);
		final Sprint sprint3relV1R2 = new Sprint("Velocity1 Sprint6", "Beschreibung Sprint 6", 
				new Date(2011 - 1900, 2 - 1, 17), new Date(2011 - 1900, 2 - 1, 25),
				teamReporting);
		final Sprint sprint4relV1R2 = new Sprint("Velocity1 Sprint7", "Beschreibung Sprint 7", 
				new Date(2011 - 1900, 2 - 1, 28), new Date(2011 - 1900, 3 - 1, 7),
				teamTesting);
		
		// Initial Sprints for v2r1
		final Sprint sprint1relV2R1 = new Sprint("Velocity2 Sprint1", "Beschreibung Sprint 1", 
				new Date(2011 - 1900, 2 - 1, 9), new Date(2011 - 1900, 2 - 1, 23),
				teamBackend);
		final Sprint sprint2relV2R1 = new Sprint("Velocity2 Sprint2", "Beschreibung Sprint 2", 
				new Date(2011 - 1900, 2 - 1, 24), new Date(2011 - 1900, 3 - 1, 7),
				teamFrontend);
		final Sprint sprint3relV2R1 = new Sprint("Velocity2 Sprint3", "Beschreibung Sprint 3", 
				new Date(2011 - 1900, 3 - 1, 8), new Date(2011 - 1900, 3 - 1, 18),
				teamTesting);
		
		// assigning sprints to projects
		velocity1.addSprint(sprint1relV1R1);
		velocity1.addSprint(sprint2relV1R1);
		velocity1.addSprint(sprint3relV1R1);
		
		velocity1.addSprint(sprint1relV1R2);
		velocity1.addSprint(sprint2relV1R2);
		velocity1.addSprint(sprint3relV1R2);
		velocity1.addSprint(sprint4relV1R2);

		velocity2.addSprint(sprint1relV2R1);
		velocity2.addSprint(sprint2relV2R1);
		velocity2.addSprint(sprint3relV2R1);
			
		// assigning sprints to releases
		relV1R1.addSprint(sprint1relV1R1);
		relV1R1.addSprint(sprint2relV1R1);
		relV1R1.addSprint(sprint3relV1R1);
		
		relV1R2.addSprint(sprint1relV1R2);
		relV1R2.addSprint(sprint2relV1R2);
		relV1R2.addSprint(sprint3relV1R2);
		relV1R2.addSprint(sprint4relV1R2);

		relV2R1.addSprint(sprint1relV2R1);
		relV2R1.addSprint(sprint2relV2R1);
		relV2R1.addSprint(sprint3relV2R1);
		
		root.addProject(velocity1);
		root.addProject(velocity2);
		
		// Initial Features
		final Feature v1r1f1 = new Feature("Feature 1", "Beschreibung Feature 1",
				velocity1.getBacklog());
		v1r1f1.setLastEditor(pNils);
		v1r1f1.setManDayCosts(new Effort(9));
		v1r1f1.setSprint(sprint1relV1R1);
		v1r1f1.close();

		final Feature v1r1f2 = new Feature("Feature 2", "Beschreibung Feature 2",
				velocity1.getBacklog());
		v1r1f2.setLastEditor(pChristin);
		v1r1f2.setManDayCosts(new Effort(4));
		v1r1f2.setSprint(sprint1relV1R1);
		v1r1f2.close();

		final Feature v1r1f3 = new Feature("Feature 3", "Beschreibung Feature 3",
				velocity1.getBacklog());
		v1r1f3.setLastEditor(pChristin);
		v1r1f3.setManDayCosts(new Effort(5));
		v1r1f3.setSprint(sprint1relV1R1);
		v1r1f3.close();
		
		final Feature v1r1f4 = new Feature("Feature 4", "Beschreibung Feature 4",
				velocity1.getBacklog());
		v1r1f4.setLastEditor(pWilken);
		v1r1f4.setManDayCosts(new Effort(8));
		v1r1f4.setSprint(sprint2relV1R1);
		v1r1f4.close();

		final Feature v1r1f5 = new Feature("Feature 5", "Beschreibung Feature 5",
				velocity1.getBacklog());
		v1r1f5.setLastEditor(pSarah);
		v1r1f5.setManDayCosts(new Effort(7));
		v1r1f5.setSprint(sprint2relV1R1);
		v1r1f5.close();

		final Feature v1r1f6 = new Feature("Feature 6", "Beschreibung Feature 6",
				velocity1.getBacklog());
		v1r1f6.setLastEditor(pSarah);
		v1r1f6.setManDayCosts(new Effort(5));
		v1r1f6.setSprint(sprint2relV1R1);
		v1r1f6.close();
		
		final Feature v1r1f7 = new Feature("Feature 7", "Beschreibung Feature 7",
				velocity1.getBacklog());
		v1r1f7.setLastEditor(pWilken);
		v1r1f7.setManDayCosts(new Effort(4));
		v1r1f7.setSprint(sprint2relV1R1);
		v1r1f7.close();

		final Feature v1r1f8 = new Feature("Feature 8", "Beschreibung Feature 8",
				velocity1.getBacklog());
		v1r1f8.setLastEditor(pNils);
		v1r1f8.setManDayCosts(new Effort(8));
		v1r1f8.setSprint(sprint3relV1R1);
		v1r1f8.close();

		final Feature v1r1f9 = new Feature("Feature 9", "Beschreibung Feature 9",
				velocity1.getBacklog());
		v1r1f9.setLastEditor(pChris);
		v1r1f9.setManDayCosts(new Effort(8));
		v1r1f9.setSprint(sprint3relV1R1);
		v1r1f9.close();
		
		// adding features to projects
		velocity1.getBacklog().addItem(v1r1f1);
		velocity1.getBacklog().addItem(v1r1f2);
		velocity1.getBacklog().addItem(v1r1f3);
		velocity1.getBacklog().addItem(v1r1f4);
		velocity1.getBacklog().addItem(v1r1f5);
		velocity1.getBacklog().addItem(v1r1f6);
		velocity1.getBacklog().addItem(v1r1f7);
		velocity1.getBacklog().addItem(v1r1f8);
		velocity1.getBacklog().addItem(v1r1f9);
		
		final Feature v1r2f1 = new Feature("Feature 10", "Beschreibung Feature 10",
				velocity1.getBacklog());
		v1r2f1.setLastEditor(pNils);
		v1r2f1.setManDayCosts(new Effort(7));
		v1r2f1.setSprint(sprint1relV1R2);
		v1r2f1.close();

		final Feature v1r2f2 = new Feature("Feature 11", "Beschreibung Feature 11",
				velocity1.getBacklog());
		v1r2f2.setLastEditor(pChristin);
		v1r2f2.setManDayCosts(new Effort(7));
		v1r2f2.setSprint(sprint1relV1R2);
		v1r2f2.close();

		final Feature v1r2f3 = new Feature("Feature 12", "Beschreibung Feature 12",
				velocity1.getBacklog());
		v1r2f3.setLastEditor(pWilken);
		v1r2f3.setManDayCosts(new Effort(6));
		v1r2f3.setSprint(sprint2relV1R2);
		v1r2f3.close();
		
		final Feature v1r2f4 = new Feature("Feature 13", "Beschreibung Feature 13",
				velocity1.getBacklog());
		v1r2f4.setLastEditor(pTimo);
		v1r2f4.setManDayCosts(new Effort(7));
		v1r2f4.setSprint(sprint3relV1R2);
		v1r2f4.close();

		final Feature v1r2f5 = new Feature("Feature 14", "Beschreibung Feature 14",
				velocity1.getBacklog());
		v1r2f5.setLastEditor(pAngelina);
		v1r2f5.setManDayCosts(new Effort(7));
		v1r2f5.setSprint(sprint3relV1R2);
		v1r2f5.close();

		final Feature v1r2f6 = new Feature("Feature 15", "Beschreibung Feature 15",
				velocity1.getBacklog());
		v1r2f6.setLastEditor(pStefan);
		v1r2f6.setManDayCosts(new Effort(7));
		v1r2f6.setSprint(sprint3relV1R2);
		v1r2f6.close();
		
		final Feature v1r2f7 = new Feature("Feature 16", "Beschreibung Feature 16",
				velocity1.getBacklog());
		v1r2f7.setLastEditor(pChris);
		v1r2f7.setManDayCosts(new Effort(6));
		v1r2f7.setSprint(sprint4relV1R2);
		v1r2f7.close();

		final Feature v1r2f8 = new Feature("Feature 17", "Beschreibung Feature 17",
				velocity1.getBacklog());
		v1r2f8.setLastEditor(pNils);
		v1r2f8.setManDayCosts(new Effort(6));
		v1r2f8.setSprint(sprint4relV1R2);
		v1r2f8.close();
		
		// adding features to projects
		velocity1.getBacklog().addItem(v1r2f1);
		velocity1.getBacklog().addItem(v1r2f2);
		velocity1.getBacklog().addItem(v1r2f3);
		velocity1.getBacklog().addItem(v1r2f4);
		velocity1.getBacklog().addItem(v1r2f5);
		velocity1.getBacklog().addItem(v1r2f6);
		velocity1.getBacklog().addItem(v1r2f7);
		velocity1.getBacklog().addItem(v1r2f8);
		
		// Initial Features
		final Feature v2r1f1 = new Feature("Feature 1", "Beschreibung Feature 1",
				velocity2.getBacklog());
		v2r1f1.setLastEditor(pNils);
		v2r1f1.setManDayCosts(new Effort(5));
		v2r1f1.setSprint(sprint1relV2R1);
		v2r1f1.close();

		final Feature v2r1f2 = new Feature("Feature 2", "Beschreibung Feature 2",
				velocity2.getBacklog());
		v2r1f2.setLastEditor(pChristin);
		v2r1f2.setManDayCosts(new Effort(7));
		v2r1f2.setSprint(sprint1relV2R1);
		v2r1f2.close();

		final Feature v2r1f3 = new Feature("Feature 3", "Beschreibung Feature 3",
				velocity2.getBacklog());
		v2r1f3.setLastEditor(pNils);
		v2r1f3.setManDayCosts(new Effort(6));
		v2r1f3.setSprint(sprint1relV2R1);
		v2r1f3.close();
		
		final Feature v2r1f4 = new Feature("Feature 4", "Beschreibung Feature 4",
				velocity2.getBacklog());
		v2r1f4.setLastEditor(pChristin);
		v2r1f4.setManDayCosts(new Effort(4));
		v2r1f4.setSprint(sprint1relV2R1);
		v2r1f4.close();

		final Feature v2r1f5 = new Feature("Feature 5", "Beschreibung Feature 5",
				velocity2.getBacklog());
		v2r1f5.setLastEditor(pSarah);
		v2r1f5.setManDayCosts(new Effort(8));
		v2r1f5.setSprint(sprint2relV2R1);
		v2r1f5.close();

		final Feature v2r1f6 = new Feature("Feature 6", "Beschreibung Feature 6",
				velocity2.getBacklog());
		v2r1f6.setLastEditor(pWilken);
		v2r1f6.setManDayCosts(new Effort(8));
		v2r1f6.setSprint(sprint2relV2R1);
		v2r1f6.close();
		
		final Feature v2r1f7 = new Feature("Feature 7", "Beschreibung Feature 7",
				velocity2.getBacklog());
		v2r1f7.setLastEditor(pNils);
		v2r1f7.setManDayCosts(new Effort(5));
		v2r1f7.setSprint(sprint3relV2R1);
		v2r1f7.close();

		final Feature v2r1f8 = new Feature("Feature 8", "Beschreibung Feature 8",
				velocity2.getBacklog());
		v2r1f8.setLastEditor(pNils);
		v2r1f8.setManDayCosts(new Effort(4));
		v2r1f8.setSprint(sprint3relV2R1);
		v2r1f8.close();

		final Feature v2r1f9 = new Feature("Feature 9", "Beschreibung Feature 9",
				velocity2.getBacklog());
		v2r1f9.setLastEditor(pChris);
		v2r1f9.setManDayCosts(new Effort(8));
		v2r1f9.setSprint(sprint3relV2R1);
		v2r1f9.close();
		
		// adding features to projects
		velocity2.getBacklog().addItem(v2r1f1);
		velocity2.getBacklog().addItem(v2r1f2);
		velocity2.getBacklog().addItem(v2r1f3);
		velocity2.getBacklog().addItem(v2r1f4);
		velocity2.getBacklog().addItem(v2r1f5);
		velocity2.getBacklog().addItem(v2r1f6);
		velocity2.getBacklog().addItem(v2r1f7);
		velocity2.getBacklog().addItem(v2r1f8);
		velocity2.getBacklog().addItem(v2r1f9);
		
		
		// Initial Tasks v1r1s1
		final Task task1 = new Task("Task 1","Beschreibung Task 1");
			sprint1relV1R1.getSprintBacklog().addTask(task1);
			task1.addPBI(v1r1f1);
			task1.setPlanEffort(new Effort(3));
			task1.setResponsibility(pNils);
			task1.finish(new Date(2010 - 1900, 12 - 1, 22));
			
		final Task task2 = new Task("Task 2","Beschreibung Task 2");
			sprint1relV1R1.getSprintBacklog().addTask(task2);
			task2.addPBI(v1r1f2);
			task2.setPlanEffort(new Effort(4));
			task2.setResponsibility(pChristin);
			task2.finish(new Date(2010 - 1900, 12 - 1, 23));
			
		final Task task3 = new Task("Task 3","Beschreibung Task 3");
			sprint1relV1R1.getSprintBacklog().addTask(task3);
			task3.addPBI(v1r1f1);
			task3.setPlanEffort(new Effort(6));
			task3.setResponsibility(pNils);
			task3.finish(new Date(2010 - 1900, 12 - 1, 30));

			
		final Task task4 = new Task("Task 4","Beschreibung Task 4");
			sprint1relV1R1.getSprintBacklog().addTask(task4);
			task4.addPBI(v1r1f3);
			task4.setPlanEffort(new Effort(5));
			task4.setResponsibility(pChristin);
			task4.finish(new Date(2011 - 1900, 12 - 1, 30));
			
		// Initial Tasks v1r1s2
		final Task task5 = new Task("Task 5","Beschreibung Task 5");
			sprint2relV1R1.getSprintBacklog().addTask(task5);
			task5.addPBI(v1r1f4);
			task5.setPlanEffort(new Effort(3));
			task5.setResponsibility(pWilken);
			task5.finish(new Date(2011 - 1900, 1 - 1, 5));
			
		final Task task6 = new Task("Task 6","Beschreibung Task 6");
			sprint2relV1R1.getSprintBacklog().addTask(task6);
			task6.addPBI(v1r1f5);
			task6.setPlanEffort(new Effort(7));
			task6.setResponsibility(pSarah);
			task6.finish(new Date(2011 - 1900, 1 - 1, 11));
			
		final Task task7 = new Task("Task 7","Beschreibung Task 7");
			sprint2relV1R1.getSprintBacklog().addTask(task7);
			task7.addPBI(v1r1f4);
			task7.setPlanEffort(new Effort(5));
			task7.setResponsibility(pWilken);
			task7.finish(new Date(2011 - 1900, 1 - 1, 12));
			
		final Task task8 = new Task("Task 8","Beschreibung Task 8");
			sprint2relV1R1.getSprintBacklog().addTask(task8);
			task8.addPBI(v1r1f7);
			task8.setPlanEffort(new Effort(4));
			task8.setResponsibility(pWilken);
			task8.finish(new Date(2011 - 1900, 1 - 1, 18));
		
		final Task task9 = new Task("Task 9","Beschreibung Task 9");
			sprint2relV1R1.getSprintBacklog().addTask(task9);
			task9.addPBI(v1r1f6);
			task9.setPlanEffort(new Effort(5));
			task9.setResponsibility(pSarah);
			task9.finish(new Date(2011 - 1900, 1 - 1, 18));
		
		// Initial Tasks v1r1s3
		final Task task10 = new Task("Task 10","Beschreibung Task 10");
			sprint3relV1R1.getSprintBacklog().addTask(task10);
			task10.addPBI(v1r1f8);
			task10.setPlanEffort(new Effort(8));
			task10.setResponsibility(pNils);
			task10.finish(new Date(2011 - 1900, 1 - 1, 28));
			
		final Task task11 = new Task("Task 11","Beschreibung Task 11");
			sprint3relV1R1.getSprintBacklog().addTask(task11);
			task11.addPBI(v1r1f9);
			task11.setPlanEffort(new Effort(8));
			task11.setResponsibility(pChris);
			task11.finish(new Date(2011 - 1900, 1 - 1, 27));
			
			
			
			
		// Initial Tasks v1r2s1
		final Task r2task1 = new Task("Task 1","Beschreibung Task 1");
			sprint1relV1R2.getSprintBacklog().addTask(r2task1);
			r2task1.addPBI(v1r2f1);
			r2task1.setPlanEffort(new Effort(7));
			r2task1.setResponsibility(pNils);
			r2task1.finish(new Date(2011 - 1900, 2 - 1, 7));
			
		final Task r2task2 = new Task("Task 2","Beschreibung Task 2");
			sprint1relV1R2.getSprintBacklog().addTask(r2task2);
			r2task2.addPBI(v1r2f2);
			r2task2.setPlanEffort(new Effort(4));
			r2task2.setResponsibility(pChristin);
			r2task2.finish(new Date(2011 - 1900, 2 - 1, 3));
			
		final Task r2task3 = new Task("Task 3","Beschreibung Task 3");
			sprint1relV1R2.getSprintBacklog().addTask(r2task3);
			r2task3.addPBI(v1r2f2);
			r2task3.setPlanEffort(new Effort(2));
			r2task3.setResponsibility(pChristin);
			r2task3.finish(new Date(2011 - 1900, 2 - 1, 8));

		// Initial Tasks v1r2s2	
		final Task r2task4 = new Task("Task 4","Beschreibung Task 4");
			sprint2relV1R2.getSprintBacklog().addTask(r2task4);
			r2task4.addPBI(v1r2f3);
			r2task4.setPlanEffort(new Effort(6));
			r2task4.setResponsibility(pWilken);
			r2task4.finish(new Date(2011 - 1900, 2 - 1, 16));
			
	    // Initial Tasks v1r2s3
		final Task r2task5 = new Task("Task 5","Beschreibung Task 5");
			sprint3relV1R2.getSprintBacklog().addTask(r2task5);
			r2task5.addPBI(v1r2f4);
			r2task5.setPlanEffort(new Effort(3));
			r2task5.setResponsibility(pTimo);
			r2task5.finish(new Date(2011 - 1900, 2 - 1, 21));
			
		final Task r2task6 = new Task("Task 6","Beschreibung Task 6");
			sprint3relV1R2.getSprintBacklog().addTask(r2task6);
			r2task6.addPBI(v1r2f5);
			r2task6.setPlanEffort(new Effort(7));
			r2task6.setResponsibility(pAngelina);
			r2task6.finish(new Date(2011 - 1900, 2 - 1, 25));
			
		final Task r2task7 = new Task("Task 7","Beschreibung Task 7");
			sprint3relV1R2.getSprintBacklog().addTask(r2task7);
			r2task7.addPBI(v1r2f6);
			r2task7.setPlanEffort(new Effort(7));
			r2task7.setResponsibility(pStefan);
			r2task7.finish(new Date(2011 - 1900, 2 - 1, 23));
			
		final Task r2task8 = new Task("Task 8","Beschreibung Task 8");
			sprint3relV1R2.getSprintBacklog().addTask(r2task8);
			r2task8.addPBI(v1r2f4);
			r2task8.setPlanEffort(new Effort(4));
			r2task8.setResponsibility(pTimo);
			r2task8.finish(new Date(2011 - 1900, 2 - 1, 25));
		
		// Initial Tasks v1r2s4			
		final Task r2task9 = new Task("Task 9","Beschreibung Task 9");
			sprint4relV1R2.getSprintBacklog().addTask(r2task9);
			r2task9.addPBI(v1r2f7);
			r2task9.setPlanEffort(new Effort(5));
			r2task9.setResponsibility(pChris);
			r2task9.finish(new Date(2011 - 1900, 3 - 1, 7));
		
		final Task r2task10 = new Task("Task 10","Beschreibung Task 10");
			sprint4relV1R2.getSprintBacklog().addTask(r2task10);
			r2task10.addPBI(v1r2f8);
			r2task10.setPlanEffort(new Effort(6));
			r2task10.setResponsibility(pNils);
			r2task10.finish(new Date(2011 - 1900, 3 - 1, 6));	
		
			
			
		// Initial Tasks v2r1s1
		final Task v2task1 = new Task("Task 1","Beschreibung Task 1");
			sprint1relV2R1.getSprintBacklog().addTask(v2task1);
			v2task1.addPBI(v2r1f1);
			v2task1.setPlanEffort(new Effort(5));
			v2task1.setResponsibility(pNils);
			v2task1.finish(new Date(2011 - 1900, 2 - 1, 15));
			
		final Task v2task2 = new Task("Task 2","Beschreibung Task 2");
			sprint1relV2R1.getSprintBacklog().addTask(v2task2);
			v2task2.addPBI(v2r1f2);
			v2task2.setPlanEffort(new Effort(7));
			v2task2.setResponsibility(pChristin);
			v2task2.finish(new Date(2011 - 1900, 2 - 1, 17));
			
		final Task v2task3 = new Task("Task 3","Beschreibung Task 3");
			sprint1relV2R1.getSprintBacklog().addTask(v2task3);
			v2task3.addPBI(v2r1f4);
			v2task3.setPlanEffort(new Effort(4));
			v2task3.setResponsibility(pChristin);
			v2task3.finish(new Date(2011 - 1900, 2 - 1, 23));
	
		final Task v2task4 = new Task("Task 4","Beschreibung Task 4");
			sprint1relV2R1.getSprintBacklog().addTask(v2task4);
			v2task4.addPBI(v2r1f3);
			v2task4.setPlanEffort(new Effort(6));
			v2task4.setResponsibility(pNils);
			v2task4.finish(new Date(2011 - 1900, 2 - 1, 23));
			
	    // Initial Tasks v2r1s2
		final Task v2task5 = new Task("Task 5","Beschreibung Task 5");
			sprint2relV2R1.getSprintBacklog().addTask(v2task5);
			v2task5.addPBI(v2r1f5);
			v2task5.setPlanEffort(new Effort(8));
			v2task5.setResponsibility(pSarah);
			v2task5.finish(new Date(2011 - 1900, 3 - 1, 6));
			
		final Task v2task6 = new Task("Task 6","Beschreibung Task 6");
			sprint2relV2R1.getSprintBacklog().addTask(v2task6);
			v2task6.addPBI(v2r1f6);
			v2task6.setPlanEffort(new Effort(8));
			v2task6.setResponsibility(pWilken);
			v2task6.finish(new Date(2011 - 1900, 3 - 1, 7));
		
		// Initial Tasks v2r1s3
		final Task v2task7 = new Task("Task 7","Beschreibung Task 7");
			sprint3relV2R1.getSprintBacklog().addTask(v2task7);
			v2task7.addPBI(v2r1f7);
			v2task7.setPlanEffort(new Effort(5));
			v2task7.setResponsibility(pNils);
			v2task7.finish(new Date(2011 - 1900, 3 - 1, 14));
			
		final Task v2task8 = new Task("Task 8","Beschreibung Task 8");
			sprint3relV2R1.getSprintBacklog().addTask(v2task8);
			v2task8.addPBI(v2r1f9);
			v2task8.setPlanEffort(new Effort(7));
			v2task8.setResponsibility(pChris);
			v2task8.finish(new Date(2011 - 1900, 3 - 1, 18));
		
		// Initial Tasks v1r2s4			
		final Task v2task9 = new Task("Task 9","Beschreibung Task 9");
			sprint3relV2R1.getSprintBacklog().addTask(v2task9);
			v2task9.addPBI(v2r1f8);
			v2task9.setPlanEffort(new Effort(4));
			v2task9.setResponsibility(pNils);
			v2task9.finish(new Date(2011 - 1900, 3 - 1, 18));
	
	}

	public static void populateStandardIncidentTypes(final Root model) {
		final Root root = model;

		try {
			root.addIncidentType(TextConstants.INCIDENT_VACATION_NAME,
					new IncidentType(TextConstants.INCIDENT_VACATION_NAME));
			root.addIncidentType(TextConstants.INCIDENT_ILLNESS_NAME,
					new IncidentType(TextConstants.INCIDENT_ILLNESS_NAME));
			root
					.addIncidentType(
							TextConstants.INCIDENT_TASKCOMPLETION_NAME,
							new IncidentType(
									TextConstants.INCIDENT_TASKCOMPLETION_NAME));
			root
					.addIncidentType(
							TextConstants.INCIDENT_PBICOMPLETION_NAME1,
							new IncidentType(
									TextConstants.INCIDENT_PBICOMPLETION_NAME1));
			root
					.addIncidentType(
							TextConstants.INCIDENT_PBICOMPLETION_NAME2,
							new IncidentType(
									TextConstants.INCIDENT_PBICOMPLETION_NAME2));
			root.addIncidentType(TextConstants.INCIDENT_RELEASECOMPLETION_NAME,
					new IncidentType(
							TextConstants.INCIDENT_RELEASECOMPLETION_NAME));
			root.addIncidentType(TextConstants.INCIDENT_SPRINTCOMPLETION_NAME,
					new IncidentType(
							TextConstants.INCIDENT_SPRINTCOMPLETION_NAME));
		} catch (final DoubleDefinitionException e) {
			// should never happen
		}
	}
}