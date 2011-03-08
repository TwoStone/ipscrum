package fhdw.ipscrum.shared.model;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import fhdw.ipscrum.client.utils.CalendarUtils;

public abstract class SetUpTestData {

	protected Feature pro1rel2spr1fea1;
	protected Feature pro1rel1spr5fea5;
	protected Feature pro1rel1spr1fea1;
	protected Feature pro1rel1spr1fea2;
	protected Feature pro1rel1spr1fea3;
	protected Feature pro1rel1spr1fea4;
	protected Feature pro1rel1spr1fea5;
	protected Feature pro1rel1spr2fea1;
	protected Feature pro1rel1spr2fea2;
	protected Feature pro1rel1spr2fea3;
	protected Feature pro1rel1spr2fea4;
	protected Feature pro1rel1spr2fea5;
	protected Feature pro1rel1spr3fea1;
	protected Feature pro1rel1spr3fea2;
	protected Feature pro1rel1spr3fea3;
	protected Feature pro1rel1spr3fea4;
	protected Feature pro1rel1spr3fea5;
	protected Feature pro1rel1spr4fea1;
	protected Feature pro1rel1spr4fea2;
	protected Feature pro1rel1spr4fea3;
	protected Feature pro1rel1spr4fea4;
	protected Feature pro1rel1spr4fea5;
	protected Feature pro1rel1spr5fea1;
	protected Feature pro1rel1spr5fea2;
	protected Feature pro1rel1spr5fea3;
	protected Feature pro1rel1spr5fea4;
	protected Feature pro1rel2spr1fea2;
	protected Feature pro1rel2spr1fea3;
	protected Feature pro1rel2spr1fea4;
	protected Feature pro1rel2spr1fea5;
	protected Feature pro1rel2spr2fea1;
	protected Feature pro1rel2spr2fea2;
	protected Feature pro1rel2spr2fea3;
	protected Feature pro1rel2spr2fea4;
	protected Feature pro1rel2spr2fea5;
	protected Feature pro1rel2spr3fea1;
	protected Feature pro1rel2spr3fea2;
	protected Feature pro1rel2spr3fea3;
	protected Feature pro1rel2spr3fea4;
	protected Feature pro1rel2spr3fea5;
	protected Feature pro1rel2spr4fea1;
	protected Feature pro1rel2spr4fea2;
	protected Feature pro1rel2spr4fea3;
	protected Feature pro1rel2spr4fea4;
	protected Feature pro1rel2spr4fea5;
	protected Feature pro1rel2spr5fea1;
	protected Feature pro1rel2spr5fea2;
	protected Feature pro1rel2spr5fea3;
	protected Feature pro1rel2spr5fea4;
	protected Feature pro1rel2spr5fea5;
	protected Feature pro2rel1spr1fea1;
	protected Feature pro2rel1spr1fea2;
	protected Feature pro2rel1spr1fea3;
	protected Feature pro2rel1spr1fea4;
	protected Feature pro2rel1spr1fea5;
	protected Feature pro2rel1spr2fea1;
	protected Feature pro2rel1spr2fea2;
	protected Feature pro2rel1spr2fea3;
	protected Feature pro2rel1spr2fea4;
	protected Feature pro2rel1spr2fea5;
	protected Feature pro2rel1spr3fea1;
	protected Feature pro2rel1spr3fea2;
	protected Feature pro2rel1spr3fea3;
	protected Feature pro2rel1spr3fea4;
	protected Feature pro2rel1spr3fea5;
	protected Feature pro2rel1spr4fea1;
	protected Feature pro2rel1spr4fea2;
	protected Feature pro2rel1spr4fea3;
	protected Feature pro2rel1spr4fea4;
	protected Feature pro2rel1spr4fea5;
	protected Feature pro2rel1spr5fea1;
	protected Feature pro2rel1spr5fea2;
	protected Feature pro2rel1spr5fea3;
	protected Feature pro2rel1spr5fea4;
	protected Feature pro2rel1spr5fea5;
	protected Feature pro2rel2spr1fea1;
	protected Feature pro2rel2spr1fea2;
	protected Feature pro2rel2spr1fea3;
	protected Feature pro2rel2spr1fea4;
	protected Feature pro2rel2spr1fea5;
	protected Feature pro2rel2spr2fea1;
	protected Feature pro2rel2spr2fea2;
	protected Feature pro2rel2spr2fea3;
	protected Feature pro2rel2spr2fea4;
	protected Feature pro2rel2spr2fea5;
	protected Feature pro2rel2spr3fea1;
	protected Feature pro2rel2spr3fea2;
	protected Feature pro2rel2spr3fea3;
	protected Feature pro2rel2spr3fea4;
	protected Feature pro2rel2spr3fea5;
	protected Feature pro2rel2spr4fea1;
	protected Feature pro2rel2spr4fea2;
	protected Feature pro2rel2spr4fea3;
	protected Feature pro2rel2spr4fea4;
	protected Feature pro2rel2spr4fea5;
	protected Feature pro2rel2spr5fea1;
	protected Feature pro2rel2spr5fea2;
	protected Feature pro2rel2spr5fea3;
	protected Feature pro2rel2spr5fea4;
	protected Feature pro2rel2spr5fea5;
	protected Role roleTSUser;
	protected Root root;
	protected Role roleScrummaster;
	protected Role roleProductOwner;
	protected Role roleDeveloper;
	protected Role roleTester;
	protected Role roleGUIWiz;
	protected Person pSarah;
	protected Person pWilken;
	protected Person pChristin;
	protected Person pBjoern;
	protected Person pChris;
	protected Team team1;
	protected Team team2;
	protected Team team3;
	protected Team team4;
	protected Project projekt1;
	protected Project projekt2;
	protected Release pro1rel1;
	protected Release pro1rel2;
	protected Release pro2rel1;
	protected Release pro2rel2;
	protected Sprint pro1rel1spr1;
	protected Sprint pro1rel1spr2;
	protected Sprint pro1rel1spr3;
	protected Sprint pro1rel1spr4;
	protected Sprint pro1rel1spr5;
	protected Sprint pro1rel2spr1;
	protected Sprint pro1rel2spr2;
	protected Sprint pro1rel2spr3;
	protected Sprint pro1rel2spr4;
	protected Sprint pro1rel2spr5;
	protected Sprint pro2rel1spr1;
	protected Sprint pro2rel1spr2;
	protected Sprint pro2rel1spr3;
	protected Sprint pro2rel1spr4;
	protected Sprint pro2rel1spr5;
	protected Sprint pro2rel2spr1;
	protected Sprint pro2rel2spr2;
	protected Sprint pro2rel2spr3;
	protected Sprint pro2rel2spr4;
	protected Sprint pro2rel2spr5;
	protected Task pro1rel1spr1tas1;
	protected Task pro1rel1spr1tas2;
	protected Task pro1rel1spr1tas3;
	protected Task pro1rel1spr1tas4;
	protected Task pro1rel1spr1tas5;
	protected Task pro1rel1spr2tas1;
	protected Task pro1rel1spr2tas2;
	protected Task pro1rel1spr2tas3;
	protected Task pro1rel1spr2tas4;
	protected Task pro1rel1spr2tas5;
	protected Task pro1rel1spr3tas1;
	protected Task pro1rel1spr3tas2;
	protected Task pro1rel1spr3tas3;
	protected Task pro1rel1spr3tas4;
	protected Task pro1rel1spr3tas5;
	protected Task pro1rel1spr4tas1;
	protected Task pro1rel1spr4tas2;
	protected Task pro1rel1spr4tas3;
	protected Task pro1rel1spr4tas4;
	protected Task pro1rel1spr4tas5;
	protected Task pro1rel1spr5tas1;
	protected Task pro1rel1spr5tas2;
	protected Task pro1rel1spr5tas3;
	protected Task pro1rel1spr5tas4;
	protected Task pro1rel1spr5tas5;
	protected Task pro1rel2spr1tas1;
	protected Task pro1rel2spr1tas2;
	protected Task pro1rel2spr1tas3;
	protected Task pro1rel2spr1tas4;
	protected Task pro1rel2spr1tas5;
	protected Task pro1rel2spr2tas1;
	protected Task pro1rel2spr2tas2;
	protected Task pro1rel2spr2tas3;
	protected Task pro1rel2spr2tas4;
	protected Task pro1rel2spr2tas5;
	protected Task pro1rel2spr3tas1;
	protected Task pro1rel2spr3tas2;
	protected Task pro1rel2spr3tas3;
	protected Task pro1rel2spr3tas4;
	protected Task pro1rel2spr3tas5;
	protected Task pro1rel2spr4tas1;
	protected Task pro1rel2spr4tas2;
	protected Task pro1rel2spr4tas3;
	protected Task pro1rel2spr4tas4;
	protected Task pro1rel2spr4tas5;
	protected Task pro1rel2spr5tas1;
	protected Task pro1rel2spr5tas2;
	protected Task pro1rel2spr5tas3;
	protected Task pro1rel2spr5tas4;
	protected Task pro1rel2spr5tas5;
	protected Task pro2rel1spr1tas1;
	protected Task pro2rel1spr1tas2;
	protected Task pro2rel1spr1tas3;
	protected Task pro2rel1spr1tas4;
	protected Task pro2rel1spr1tas5;
	protected Task pro2rel1spr2tas1;
	protected Task pro2rel1spr2tas2;
	protected Task pro2rel1spr2tas3;
	protected Task pro2rel1spr2tas4;
	protected Task pro2rel1spr2tas5;
	protected Task pro2rel1spr3tas1;
	protected Task pro2rel1spr3tas2;
	protected Task pro2rel1spr3tas3;
	protected Task pro2rel1spr3tas4;
	protected Task pro2rel1spr3tas5;
	protected Task pro2rel1spr4tas1;
	protected Task pro2rel1spr4tas2;
	protected Task pro2rel1spr4tas3;
	protected Task pro2rel1spr4tas4;
	protected Task pro2rel1spr4tas5;
	protected Task pro2rel1spr5tas2;
	protected Task pro2rel1spr5tas3;
	protected Task pro2rel1spr5tas4;
	protected Task pro2rel1spr5tas5;
	protected Task pro2rel2spr1tas1;
	protected Task pro2rel2spr1tas2;
	protected Task pro2rel2spr1tas3;
	protected Task pro2rel2spr1tas4;
	protected Task pro2rel2spr1tas5;
	protected Task pro2rel2spr2tas1;
	protected Task pro2rel2spr2tas2;
	protected Task pro2rel2spr2tas3;
	protected Task pro2rel2spr2tas4;
	protected Task pro2rel2spr2tas5;
	protected Task pro2rel2spr3tas1;
	protected Task pro2rel2spr3tas2;
	protected Task pro2rel2spr3tas3;
	protected Task pro2rel2spr3tas4;
	protected Task pro2rel2spr3tas5;
	protected Task pro2rel2spr4tas2;
	protected Task pro2rel2spr4tas1;
	protected Task pro2rel2spr4tas3;
	protected Task pro2rel2spr4tas4;
	protected Task pro2rel2spr4tas5;
	protected Task pro2rel2spr5tas1;
	protected Task pro2rel2spr5tas2;
	protected Task pro2rel2spr5tas3;
	protected Task pro2rel2spr5tas4;
	protected Task pro2rel2spr5tas5;
	private Task pro2rel1spr5tas1;

	@BeforeClass
	public static void SetUpBeforeClass() throws Exception {

		// Initial Relations
		RelationType.create("Abhängig von");
		RelationType.create("Siehe auch");
	}

	@Before
	public void setUp() throws Exception {

		root = new Root();

		roleTSUser = new Role("Ticketsystem-Benutzer");

		roleScrummaster = new Role("Scrum-Master");
		roleProductOwner = new Role("Product-Owner");
		roleDeveloper = new Role("Entwickler");
		roleTester = new Role("Tester");
		roleGUIWiz = new Role("GUI-Wizard");
		root.addRole(roleTSUser);
		root.addRole(roleScrummaster);
		root.addRole(roleProductOwner);
		root.addRole(roleDeveloper);
		root.addRole(roleTester);
		root.addRole(roleGUIWiz);

		// Initial Persons
		pSarah = new Person("Sarah", "Gottwald");
		pSarah.addRole(roleScrummaster);
		pSarah.addRole(roleTSUser);

		pWilken = new Person("Wilken", "Hustedt");
		pWilken.addRole(roleDeveloper);
		pWilken.addRole(roleGUIWiz);
		pWilken.addRole(roleTSUser);

		pChristin = new Person("Christin", "Weckbrod");
		pChristin.addRole(roleProductOwner);
		pChristin.addRole(roleDeveloper);
		pChristin.addRole(roleTSUser);

		pBjoern = new Person("Björn", "Bodensieck");
		pBjoern.addRole(roleTester);
		pBjoern.addRole(roleTSUser);

		pChris = new Person("Christoph", "Stürzekarn");
		pChris.addRole(roleTester);
		pChris.addRole(roleDeveloper);
		pChris.addRole(roleTSUser);

		root.addPerson(pSarah);
		root.addPerson(pWilken);
		root.addPerson(pChristin);
		root.addPerson(pBjoern);
		root.addPerson(pChris);

		// Initial Teams
		team1 = new Team("Frontend");
		team1.addMember(pSarah);
		team1.addMember(pWilken);
		team1.addMember(pBjoern);

		team2 = new Team("Backend");
		team2.addMember(pChristin);

		team3 = new Team("Reporting");
		team3.addMember(pChris);
		team3.addMember(pSarah);
		team3.addMember(pWilken);

		team4 = new Team("Testing");
		team4.addMember(pChris);
		team4.addMember(pBjoern);

		root.addTeam(team1);
		root.addTeam(team2);
		root.addTeam(team3);
		root.addTeam(team4);

		// Initial Projects
		projekt1 = new Project("Projekt 1");
		projekt2 = new Project("Projekt 2");
		root.addProject(projekt1);
		root.addProject(projekt2);

		// Initial Releases
		pro1rel1 = new Release("1.0", CalendarUtils.getRandomReleaseDate(), projekt1);
		pro1rel2 = new Release("2.0", CalendarUtils.getRandomReleaseDate(), projekt1);
		pro2rel1 = new Release("1.0", CalendarUtils.getRandomReleaseDate(), projekt2);
		pro2rel2 = new Release("2.0", CalendarUtils.getRandomReleaseDate(), projekt2);

		// Initial Sprints
		// Für Projekt 1, Release 1
		Date pro1rel1spr1BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro1rel1spr1EndDate = CalendarUtils.getRandomSprintEnddate(pro1rel1spr1BeginDate, pro1rel1.getReleaseDate());
		pro1rel1spr1 = new Sprint("Pro1Rel1Sprint1", "Beschreibung Sprint 1", pro1rel1spr1BeginDate, pro1rel1spr1EndDate, team1);

		Date pro1rel1spr2BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro1rel1spr2EndDate = CalendarUtils.getRandomSprintEnddate(pro1rel1spr2BeginDate, pro1rel1.getReleaseDate());
		pro1rel1spr2 = new Sprint("Pro1Rel1Sprint2", "Beschreibung Sprint 2", pro1rel1spr2BeginDate, pro1rel1spr2EndDate, team1);

		Date pro1rel1spr3BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro1rel1spr3EndDate = CalendarUtils.getRandomSprintEnddate(pro1rel1spr3BeginDate, pro1rel1.getReleaseDate());
		pro1rel1spr3 = new Sprint("Pro1Rel1Sprint3", "Beschreibung Sprint 3", pro1rel1spr3BeginDate, pro1rel1spr3EndDate, team1);

		Date pro1rel1spr4BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro1rel1spr4EndDate = CalendarUtils.getRandomSprintEnddate(pro1rel1spr4BeginDate, pro1rel1.getReleaseDate());
		pro1rel1spr4 = new Sprint("Pro1Rel1Sprint4", "Beschreibung Sprint 4", pro1rel1spr4BeginDate, pro1rel1spr4EndDate, team1);

		Date pro1rel1spr5BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro1rel1spr5EndDate = CalendarUtils.getRandomSprintEnddate(pro1rel1spr5BeginDate, pro1rel1.getReleaseDate());
		pro1rel1spr5 = new Sprint("Pro1Rel1Sprint5", "Beschreibung Sprint 5", pro1rel1spr5BeginDate, pro1rel1spr5EndDate, team1);

		// Für Projekt 1, Release 2
		Date pro1rel2spr1BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro1rel2spr1EndDate = CalendarUtils.getRandomSprintEnddate(pro1rel2spr1BeginDate, pro1rel2.getReleaseDate());
		pro1rel2spr1 = new Sprint("Pro1Rel2Sprint1", "Beschreibung Sprint 1", pro1rel2spr1BeginDate, pro1rel2spr1EndDate, team1);

		Date pro1rel2spr2BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro1rel2spr2EndDate = CalendarUtils.getRandomSprintEnddate(pro1rel2spr2BeginDate, pro1rel2.getReleaseDate());
		pro1rel2spr2 = new Sprint("Pro1Rel2Sprint2", "Beschreibung Sprint 2", pro1rel2spr2BeginDate, pro1rel2spr2EndDate, team1);

		Date pro1rel2spr3BeginDate = new Date();
		Date pro1rel2spr3EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro1rel2spr3BeginDate, 6);
		CalendarUtils.removeDaysFromDate(pro1rel2spr3EndDate, 4);
		pro1rel2spr3 = new Sprint("Pro1Rel2Sprint3", "Beschreibung Sprint 3", pro1rel2spr3BeginDate, pro1rel2spr3EndDate, team1);

		Date pro1rel2spr4BeginDate = new Date();
		Date pro1rel2spr4EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro1rel2spr4BeginDate, 8);
		CalendarUtils.removeDaysFromDate(pro1rel2spr4EndDate, 1);
		pro1rel2spr4 = new Sprint("Pro1Rel2Sprint4", "Beschreibung Sprint 4", pro1rel2spr4BeginDate, pro1rel2spr4EndDate, team1);

		Date pro1rel2spr5BeginDate = new Date();
		Date pro1rel2spr5EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro1rel2spr5BeginDate, 9);
		CalendarUtils.removeDaysFromDate(pro1rel2spr5EndDate, 4);
		pro1rel2spr5 = new Sprint("Pro1Rel2Sprint5", "Beschreibung Sprint 5", pro1rel2spr5BeginDate, pro1rel2spr5EndDate, team1);

		// Für Projekt 2, Release 1
		Date pro2rel1spr1BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro2rel1spr1EndDate = CalendarUtils.getRandomSprintEnddate(pro2rel1spr1BeginDate, pro2rel1.getReleaseDate());
		pro2rel1spr1 = new Sprint("Pro2Rel1Sprint1", "Beschreibung Sprint 1", pro2rel1spr1BeginDate, pro2rel1spr1EndDate, team1);

		Date pro2rel1spr2BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro2rel1spr2EndDate = CalendarUtils.getRandomSprintEnddate(pro2rel1spr2BeginDate, pro2rel1.getReleaseDate());
		pro2rel1spr2 = new Sprint("Pro2Rel1Sprint2", "Beschreibung Sprint 2", pro2rel1spr2BeginDate, pro2rel1spr2EndDate, team1);

		Date pro2rel1spr3BeginDate = new Date();
		Date pro2rel1spr3EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro2rel1spr3BeginDate, 6);
		CalendarUtils.removeDaysFromDate(pro2rel1spr3EndDate, 4);
		pro2rel1spr3 = new Sprint("Pro2Rel1Sprint3", "Beschreibung Sprint 3", pro2rel1spr3BeginDate, pro2rel1spr3EndDate, team1);

		Date pro2rel1spr4BeginDate = new Date();
		Date pro2rel1spr4EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro2rel1spr4BeginDate, 8);
		CalendarUtils.removeDaysFromDate(pro2rel1spr4EndDate, 1);
		pro2rel1spr4 = new Sprint("Pro2Rel1Sprint4", "Beschreibung Sprint 4", pro2rel1spr4BeginDate, pro2rel1spr4EndDate, team1);

		Date pro2rel1spr5BeginDate = new Date();
		Date pro2rel1spr5EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro2rel1spr5BeginDate, 9);
		CalendarUtils.removeDaysFromDate(pro2rel1spr5EndDate, 4);
		pro2rel1spr5 = new Sprint("Pro2Rel1Sprint5", "Beschreibung Sprint 5", pro2rel1spr5BeginDate, pro2rel1spr5EndDate, team1);

		// Für Projekt 2, Release 2
		Date sprint6BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date sprint6EndDate = CalendarUtils.getRandomSprintEnddate(sprint6BeginDate, pro2rel2.getReleaseDate());
		pro2rel2spr1 = new Sprint("Pro2Rel2Sprint1", "Beschreibung Sprint 1", sprint6BeginDate, sprint6EndDate, team1);

		Date sprint7BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date sprint7EndDate = CalendarUtils.getRandomSprintEnddate(sprint7BeginDate, pro2rel2.getReleaseDate());
		pro2rel2spr2 = new Sprint("Pro2Rel2Sprint2", "Beschreibung Sprint 2", sprint7BeginDate, sprint7EndDate, team1);

		Date sprint8BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date sprint8EndDate = CalendarUtils.getRandomSprintEnddate(sprint8BeginDate, pro2rel2.getReleaseDate());
		pro2rel2spr3 = new Sprint("Pro2Rel2Sprint3", "Beschreibung Sprint 3", sprint8BeginDate, sprint8EndDate, team1);

		Date sprint9BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date sprint9EndDate = CalendarUtils.getRandomSprintEnddate(sprint9BeginDate, pro2rel2.getReleaseDate());
		pro2rel2spr4 = new Sprint("Pro2Rel2Sprint4", "Beschreibung Sprint 4", sprint9BeginDate, sprint9EndDate, team1);

		Date sprint10BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date sprint10EndDate = CalendarUtils.getRandomSprintEnddate(sprint10BeginDate, pro2rel2.getReleaseDate());
		pro2rel2spr5 = new Sprint("Pro2Rel2Sprint5", "Beschreibung Sprint 5", sprint10BeginDate, sprint10EndDate, team1);

		// assigning sprints to projects
		projekt1.addSprint(pro1rel1spr1);
		projekt1.addSprint(pro1rel1spr2);
		projekt1.addSprint(pro1rel1spr3);
		projekt1.addSprint(pro1rel1spr4);
		projekt1.addSprint(pro1rel1spr5);

		projekt1.addSprint(pro1rel2spr1);
		projekt1.addSprint(pro1rel2spr2);
		projekt1.addSprint(pro1rel2spr3);
		projekt1.addSprint(pro1rel2spr4);
		projekt1.addSprint(pro1rel2spr5);

		projekt2.addSprint(pro2rel1spr1);
		projekt2.addSprint(pro2rel1spr2);
		projekt2.addSprint(pro2rel1spr3);
		projekt2.addSprint(pro2rel1spr4);
		projekt2.addSprint(pro2rel1spr5);

		projekt2.addSprint(pro2rel2spr1);
		projekt2.addSprint(pro2rel2spr2);
		projekt2.addSprint(pro2rel2spr3);
		projekt2.addSprint(pro2rel2spr4);
		projekt2.addSprint(pro2rel2spr5);

		// assigning sprints to releases
		pro1rel1.addSprint(pro1rel1spr1);
		pro1rel1.addSprint(pro1rel1spr2);
		pro1rel1.addSprint(pro1rel1spr3);
		pro1rel1.addSprint(pro1rel1spr4);
		pro1rel1.addSprint(pro1rel1spr5);

		pro1rel2.addSprint(pro1rel2spr1);
		pro1rel2.addSprint(pro1rel2spr2);
		pro1rel2.addSprint(pro1rel2spr3);
		pro1rel2.addSprint(pro1rel2spr4);
		pro1rel2.addSprint(pro1rel2spr5);

		pro2rel1.addSprint(pro2rel1spr1);
		pro2rel1.addSprint(pro2rel1spr2);
		pro2rel1.addSprint(pro2rel1spr3);
		pro2rel1.addSprint(pro2rel1spr4);
		pro2rel1.addSprint(pro2rel1spr5);

		pro2rel2.addSprint(pro2rel2spr1);
		pro2rel2.addSprint(pro2rel2spr2);
		pro2rel2.addSprint(pro2rel2spr3);
		pro2rel2.addSprint(pro2rel2spr4);
		pro2rel2.addSprint(pro2rel2spr5);

		// Initial Features
		// für Projekt 1, Release 1, Sprint 1
		pro1rel1spr1fea1 = new Feature("Projekt 1, Release 1, Sprint 1, Feature 1", "Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel1spr1fea1.setLastEditor(pBjoern);
		pro1rel1spr1fea1.setManDayCosts(3);
		pro1rel1spr1fea1.setSprint(pro1rel1spr1);
		pro1rel1spr1fea1.close();

		pro1rel1spr1fea2 = new Feature("Projekt 1, Release 1, Sprint 1, Feature 2", "Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel1spr1fea2.setLastEditor(pBjoern);
		pro1rel1spr1fea2.setManDayCosts(4);
		pro1rel1spr1fea2.setSprint(pro1rel1spr1);
		pro1rel1spr1fea2.close();

		pro1rel1spr1fea3 = new Feature("Projekt 1, Release 1, Sprint 1, Feature 3", "Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel1spr1fea3.setLastEditor(pBjoern);
		pro1rel1spr1fea3.setManDayCosts(5);
		pro1rel1spr1fea3.setSprint(pro1rel1spr1);
		pro1rel1spr1fea3.close();

		pro1rel1spr1fea4 = new Feature("Projekt 1, Release 1, Sprint 1, Feature 4", "Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel1spr1fea4.setLastEditor(pBjoern);
		pro1rel1spr1fea4.setManDayCosts(4);
		pro1rel1spr1fea4.setSprint(pro1rel1spr1);
		pro1rel1spr1fea4.close();

		pro1rel1spr1fea5 = new Feature("Projekt 1, Release 1, Sprint 1, Feature 5", "Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel1spr1fea5.setLastEditor(pBjoern);
		pro1rel1spr1fea5.setManDayCosts(3);
		pro1rel1spr1fea5.setSprint(pro1rel1spr1);
		pro1rel1spr1fea5.close();

		// für Projekt 1, Release 1, Sprint 2
		pro1rel1spr2fea1 = new Feature("Projekt 1, Release 1, Sprint 2, Feature 1", "Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel1spr2fea1.setLastEditor(pBjoern);
		pro1rel1spr2fea1.setManDayCosts(3);
		pro1rel1spr2fea1.setSprint(pro1rel1spr2);
		pro1rel1spr2fea1.close();

		pro1rel1spr2fea2 = new Feature("Projekt 1, Release 1, Sprint 2, Feature 2", "Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel1spr2fea2.setLastEditor(pBjoern);
		pro1rel1spr2fea2.setManDayCosts(4);
		pro1rel1spr2fea2.setSprint(pro1rel1spr2);
		pro1rel1spr2fea2.close();

		pro1rel1spr2fea3 = new Feature("Projekt 1, Release 1, Sprint 2, Feature 3", "Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel1spr2fea3.setLastEditor(pBjoern);
		pro1rel1spr2fea3.setManDayCosts(5);
		pro1rel1spr2fea3.setSprint(pro1rel1spr2);
		pro1rel1spr2fea3.close();

		pro1rel1spr2fea4 = new Feature("Projekt 1, Release 1, Sprint 2, Feature 4", "Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel1spr2fea4.setLastEditor(pBjoern);
		pro1rel1spr2fea4.setManDayCosts(4);
		pro1rel1spr2fea4.setSprint(pro1rel1spr2);
		pro1rel1spr2fea4.close();

		pro1rel1spr2fea5 = new Feature("Projekt 1, Release 1, Sprint 2, Feature 5", "Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel1spr2fea5.setLastEditor(pBjoern);
		pro1rel1spr2fea5.setManDayCosts(3);
		pro1rel1spr2fea5.setSprint(pro1rel1spr2);
		pro1rel1spr2fea5.close();

		// für Projekt 1, Release 1, Sprint 3
		pro1rel1spr3fea1 = new Feature("Projekt 1, Release 1, Sprint 3, Feature 1", "Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel1spr3fea1.setLastEditor(pBjoern);
		pro1rel1spr3fea1.setManDayCosts(3);
		pro1rel1spr3fea1.setSprint(pro1rel1spr3);
		pro1rel1spr3fea1.close();

		pro1rel1spr3fea2 = new Feature("Projekt 1, Release 1, Sprint 3, Feature 2", "Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel1spr3fea2.setLastEditor(pBjoern);
		pro1rel1spr3fea2.setManDayCosts(4);
		pro1rel1spr3fea2.setSprint(pro1rel1spr3);
		pro1rel1spr3fea2.close();

		pro1rel1spr3fea3 = new Feature("Projekt 1, Release 1, Sprint 3, Feature 3", "Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel1spr3fea3.setLastEditor(pBjoern);
		pro1rel1spr3fea3.setManDayCosts(5);
		pro1rel1spr3fea3.setSprint(pro1rel1spr3);
		pro1rel1spr3fea3.close();

		pro1rel1spr3fea4 = new Feature("Projekt 1, Release 1, Sprint 3, Feature 4", "Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel1spr3fea4.setLastEditor(pBjoern);
		pro1rel1spr3fea4.setManDayCosts(4);
		pro1rel1spr3fea4.setSprint(pro1rel1spr3);
		pro1rel1spr3fea4.close();

		pro1rel1spr3fea5 = new Feature("Projekt 1, Release 1, Sprint 3, Feature 5", "Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel1spr3fea5.setLastEditor(pBjoern);
		pro1rel1spr3fea5.setManDayCosts(3);
		pro1rel1spr3fea5.setSprint(pro1rel1spr3);
		pro1rel1spr3fea5.close();

		// für Projekt 1, Release 1, Sprint 4
		pro1rel1spr4fea1 = new Feature("Projekt 1, Release 1, Sprint 4, Feature 1", "Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel1spr4fea1.setLastEditor(pBjoern);
		pro1rel1spr4fea1.setManDayCosts(3);
		pro1rel1spr4fea1.setSprint(pro1rel1spr4);
		pro1rel1spr4fea1.close();

		pro1rel1spr4fea2 = new Feature("Projekt 1, Release 1, Sprint 4, Feature 2", "Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel1spr4fea2.setLastEditor(pBjoern);
		pro1rel1spr4fea2.setManDayCosts(4);
		pro1rel1spr4fea2.setSprint(pro1rel1spr4);
		pro1rel1spr4fea2.close();

		pro1rel1spr4fea3 = new Feature("Projekt 1, Release 1, Sprint 4, Feature 3", "Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel1spr4fea3.setLastEditor(pBjoern);
		pro1rel1spr4fea3.setManDayCosts(5);
		pro1rel1spr4fea3.setSprint(pro1rel1spr4);
		pro1rel1spr4fea3.close();

		pro1rel1spr4fea4 = new Feature("Projekt 1, Release 1, Sprint 4, Feature 4", "Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel1spr4fea4.setLastEditor(pBjoern);
		pro1rel1spr4fea4.setManDayCosts(4);
		pro1rel1spr4fea4.setSprint(pro1rel1spr4);
		pro1rel1spr4fea4.close();

		pro1rel1spr4fea5 = new Feature("Projekt 1, Release 1, Sprint 4, Feature 5", "Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel1spr4fea5.setLastEditor(pBjoern);
		pro1rel1spr4fea5.setManDayCosts(3);
		pro1rel1spr4fea5.setSprint(pro1rel1spr4);
		pro1rel1spr4fea5.close();

		// für Projekt 1, Release 1, Sprint 5
		pro1rel1spr5fea1 = new Feature("Projekt 1, Release 1, Sprint 5, Feature 1", "Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel1spr5fea1.setLastEditor(pBjoern);
		pro1rel1spr5fea1.setManDayCosts(3);
		pro1rel1spr5fea1.setSprint(pro1rel1spr5);
		pro1rel1spr5fea1.close();

		pro1rel1spr5fea2 = new Feature("Projekt 1, Release 1, Sprint 5, Feature 2", "Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel1spr5fea2.setLastEditor(pBjoern);
		pro1rel1spr5fea2.setManDayCosts(4);
		pro1rel1spr5fea2.setSprint(pro1rel1spr5);
		pro1rel1spr5fea2.close();

		pro1rel1spr5fea3 = new Feature("Projekt 1, Release 1, Sprint 5, Feature 3", "Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel1spr5fea3.setLastEditor(pBjoern);
		pro1rel1spr5fea3.setManDayCosts(5);
		pro1rel1spr5fea3.setSprint(pro1rel1spr5);
		pro1rel1spr5fea3.close();

		pro1rel1spr5fea4 = new Feature("Projekt 1, Release 1, Sprint 5, Feature 4", "Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel1spr5fea4.setLastEditor(pBjoern);
		pro1rel1spr5fea4.setManDayCosts(4);
		pro1rel1spr5fea4.setSprint(pro1rel1spr5);
		pro1rel1spr5fea4.close();

		pro1rel1spr5fea5 = new Feature("Projekt 1, Release 1, Sprint 5, Feature 5", "Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel1spr5fea5.setLastEditor(pBjoern);
		pro1rel1spr5fea5.setManDayCosts(3);
		pro1rel1spr5fea5.setSprint(pro1rel1spr5);
		pro1rel1spr5fea5.close();

		pro1rel2spr1fea1 = new Feature("Projekt 1, Release 2, Sprint 1, Feature 1", "Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel2spr1fea1.setLastEditor(pBjoern);
		pro1rel2spr1fea1.setManDayCosts(3);
		pro1rel2spr1fea1.setSprint(pro1rel2spr1);
		pro1rel2spr1fea1.close();

		pro1rel2spr1fea2 = new Feature("Projekt 1, Release 2, Sprint 1, Feature 2", "Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel2spr1fea2.setLastEditor(pBjoern);
		pro1rel2spr1fea2.setManDayCosts(4);
		pro1rel2spr1fea2.setSprint(pro1rel2spr1);
		pro1rel2spr1fea2.close();

		pro1rel2spr1fea3 = new Feature("Projekt 1, Release 2, Sprint 1, Feature 3", "Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel2spr1fea3.setLastEditor(pBjoern);
		pro1rel2spr1fea3.setManDayCosts(5);
		pro1rel2spr1fea3.setSprint(pro1rel2spr1);
		pro1rel2spr1fea3.close();

		pro1rel2spr1fea4 = new Feature("Projekt 1, Release 2, Sprint 1, Feature 4", "Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel2spr1fea4.setLastEditor(pBjoern);
		pro1rel2spr1fea4.setManDayCosts(4);
		pro1rel2spr1fea4.setSprint(pro1rel2spr1);
		pro1rel2spr1fea4.close();

		pro1rel2spr1fea5 = new Feature("Projekt 1, Release 2, Sprint 1, Feature 5", "Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel2spr1fea5.setLastEditor(pBjoern);
		pro1rel2spr1fea5.setManDayCosts(3);
		pro1rel2spr1fea5.setSprint(pro1rel2spr1);
		pro1rel2spr1fea5.close();

		// für Projekt 1, Release 2, Sprint 2
		pro1rel2spr2fea1 = new Feature("Projekt 1, Release 2, Sprint 2, Feature 1", "Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel2spr2fea1.setLastEditor(pBjoern);
		pro1rel2spr2fea1.setManDayCosts(3);
		pro1rel2spr2fea1.setSprint(pro1rel2spr2);
		pro1rel2spr2fea1.close();

		pro1rel2spr2fea2 = new Feature("Projekt 1, Release 2, Sprint 2, Feature 2", "Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel2spr2fea2.setLastEditor(pBjoern);
		pro1rel2spr2fea2.setManDayCosts(4);
		pro1rel2spr2fea2.setSprint(pro1rel2spr2);
		pro1rel2spr2fea2.close();

		pro1rel2spr2fea3 = new Feature("Projekt 1, Release 2, Sprint 2, Feature 3", "Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel2spr2fea3.setLastEditor(pBjoern);
		pro1rel2spr2fea3.setManDayCosts(5);
		pro1rel2spr2fea3.setSprint(pro1rel2spr2);
		pro1rel2spr2fea3.close();

		pro1rel2spr2fea4 = new Feature("Projekt 1, Release 2, Sprint 2, Feature 4", "Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel2spr2fea4.setLastEditor(pBjoern);
		pro1rel2spr2fea4.setManDayCosts(4);
		pro1rel2spr2fea4.setSprint(pro1rel2spr2);
		pro1rel2spr2fea4.close();

		pro1rel2spr2fea5 = new Feature("Projekt 1, Release 2, Sprint 2, Feature 5", "Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel2spr2fea5.setLastEditor(pBjoern);
		pro1rel2spr2fea5.setManDayCosts(3);
		pro1rel2spr2fea5.setSprint(pro1rel2spr2);
		pro1rel2spr2fea5.close();

		// für Projekt 1, Release 2, Sprint 3
		pro1rel2spr3fea1 = new Feature("Projekt 1, Release 2, Sprint 3, Feature 1", "Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel2spr3fea1.setLastEditor(pBjoern);
		pro1rel2spr3fea1.setManDayCosts(3);
		pro1rel2spr3fea1.setSprint(pro1rel2spr3);
		pro1rel2spr3fea1.close();

		pro1rel2spr3fea2 = new Feature("Projekt 1, Release 2, Sprint 3, Feature 2", "Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel2spr3fea2.setLastEditor(pBjoern);
		pro1rel2spr3fea2.setManDayCosts(4);
		pro1rel2spr3fea2.setSprint(pro1rel2spr3);
		pro1rel2spr3fea2.close();

		pro1rel2spr3fea3 = new Feature("Projekt 1, Release 2, Sprint 3, Feature 3", "Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel2spr3fea3.setLastEditor(pBjoern);
		pro1rel2spr3fea3.setManDayCosts(5);
		pro1rel2spr3fea3.setSprint(pro1rel2spr3);
		pro1rel2spr3fea3.close();

		pro1rel2spr3fea4 = new Feature("Projekt 1, Release 2, Sprint 3, Feature 4", "Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel2spr3fea4.setLastEditor(pBjoern);
		pro1rel2spr3fea4.setManDayCosts(4);
		pro1rel2spr3fea4.setSprint(pro1rel2spr3);
		pro1rel2spr3fea4.close();

		pro1rel2spr3fea5 = new Feature("Projekt 1, Release 2, Sprint 3, Feature 5", "Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel2spr3fea5.setLastEditor(pBjoern);
		pro1rel2spr3fea5.setManDayCosts(3);
		pro1rel2spr3fea5.setSprint(pro1rel2spr3);
		pro1rel2spr3fea5.close();

		// für Projekt 1, Release 2, Sprint 4
		pro1rel2spr4fea1 = new Feature("Projekt 1, Release 2, Sprint 4, Feature 1", "Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel2spr4fea1.setLastEditor(pBjoern);
		pro1rel2spr4fea1.setManDayCosts(3);
		pro1rel2spr4fea1.setSprint(pro1rel2spr4);
		pro1rel2spr4fea1.close();

		pro1rel2spr4fea2 = new Feature("Projekt 1, Release 2, Sprint 4, Feature 2", "Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel2spr4fea2.setLastEditor(pBjoern);
		pro1rel2spr4fea2.setManDayCosts(4);
		pro1rel2spr4fea2.setSprint(pro1rel2spr4);
		pro1rel2spr4fea2.close();

		pro1rel2spr4fea3 = new Feature("Projekt 1, Release 2, Sprint 4, Feature 3", "Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel2spr4fea3.setLastEditor(pBjoern);
		pro1rel2spr4fea3.setManDayCosts(5);
		pro1rel2spr4fea3.setSprint(pro1rel2spr4);
		pro1rel2spr4fea3.close();

		pro1rel2spr4fea4 = new Feature("Projekt 1, Release 2, Sprint 4, Feature 4", "Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel2spr4fea4.setLastEditor(pBjoern);
		pro1rel2spr4fea4.setManDayCosts(4);
		pro1rel2spr4fea4.setSprint(pro1rel2spr4);
		pro1rel2spr4fea4.close();

		pro1rel2spr4fea5 = new Feature("Projekt 1, Release 2, Sprint 4, Feature 5", "Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel2spr4fea5.setLastEditor(pBjoern);
		pro1rel2spr4fea5.setManDayCosts(3);
		pro1rel2spr4fea5.setSprint(pro1rel2spr4);
		pro1rel2spr4fea5.close();

		// für Projekt 1, Release 2, Sprint 5
		pro1rel2spr5fea1 = new Feature("Projekt 1, Release 2, Sprint 5, Feature 1", "Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel2spr5fea1.setLastEditor(pBjoern);
		pro1rel2spr5fea1.setManDayCosts(3);
		pro1rel2spr5fea1.setSprint(pro1rel2spr5);
		pro1rel2spr5fea1.close();

		pro1rel2spr5fea2 = new Feature("Projekt 1, Release 2, Sprint 5, Feature 2", "Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel2spr5fea2.setLastEditor(pBjoern);
		pro1rel2spr5fea2.setManDayCosts(4);
		pro1rel2spr5fea2.setSprint(pro1rel2spr5);
		pro1rel2spr5fea2.close();

		pro1rel2spr5fea3 = new Feature("Projekt 1, Release 2, Sprint 5, Feature 3", "Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel2spr5fea3.setLastEditor(pBjoern);
		pro1rel2spr5fea3.setManDayCosts(5);
		pro1rel2spr5fea3.setSprint(pro1rel2spr5);
		pro1rel2spr5fea3.close();

		pro1rel2spr5fea4 = new Feature("Projekt 1, Release 2, Sprint 5, Feature 4", "Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel2spr5fea4.setLastEditor(pBjoern);
		pro1rel2spr5fea4.setManDayCosts(4);
		pro1rel2spr5fea4.setSprint(pro1rel2spr5);
		pro1rel2spr5fea4.close();

		pro1rel2spr5fea5 = new Feature("Projekt 1, Release 2, Sprint 5, Feature 5", "Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel2spr5fea5.setLastEditor(pBjoern);
		pro1rel2spr5fea5.setManDayCosts(3);
		pro1rel2spr5fea5.setSprint(pro1rel2spr5);
		pro1rel2spr5fea5.close();

		// für Projekt 2, Release 1, Sprint 1
		pro2rel1spr1fea1 = new Feature("Projekt 2, Release 1, Sprint 1, Feature 1", "Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel1spr1fea1.setLastEditor(pBjoern);
		pro2rel1spr1fea1.setManDayCosts(3);
		pro2rel1spr1fea1.setSprint(pro2rel1spr1);
		pro2rel1spr1fea1.close();

		pro2rel1spr1fea2 = new Feature("Projekt 2, Release 1, Sprint 1, Feature 2", "Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel1spr1fea2.setLastEditor(pBjoern);
		pro2rel1spr1fea2.setManDayCosts(4);
		pro2rel1spr1fea2.setSprint(pro2rel1spr1);
		pro2rel1spr1fea2.close();

		pro2rel1spr1fea3 = new Feature("Projekt 2, Release 1, Sprint 1, Feature 3", "Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel1spr1fea3.setLastEditor(pBjoern);
		pro2rel1spr1fea3.setManDayCosts(5);
		pro2rel1spr1fea3.setSprint(pro2rel1spr1);
		pro2rel1spr1fea3.close();

		pro2rel1spr1fea4 = new Feature("Projekt 2, Release 1, Sprint 1, Feature 4", "Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel1spr1fea4.setLastEditor(pBjoern);
		pro2rel1spr1fea4.setManDayCosts(4);
		pro2rel1spr1fea4.setSprint(pro2rel1spr1);
		pro2rel1spr1fea4.close();

		pro2rel1spr1fea5 = new Feature("Projekt 2, Release 1, Sprint 1, Feature 5", "Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel1spr1fea5.setLastEditor(pBjoern);
		pro2rel1spr1fea5.setManDayCosts(3);
		pro2rel1spr1fea5.setSprint(pro2rel1spr1);
		pro2rel1spr1fea5.close();

		// für Projekt 2, Release 1, Sprint 2
		pro2rel1spr2fea1 = new Feature("Projekt 2, Release 1, Sprint 2, Feature 1", "Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel1spr2fea1.setLastEditor(pBjoern);
		pro2rel1spr2fea1.setManDayCosts(3);
		pro2rel1spr2fea1.setSprint(pro2rel1spr2);
		pro2rel1spr2fea1.close();

		pro2rel1spr2fea2 = new Feature("Projekt 2, Release 1, Sprint 2, Feature 2", "Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel1spr2fea2.setLastEditor(pBjoern);
		pro2rel1spr2fea2.setManDayCosts(4);
		pro2rel1spr2fea2.setSprint(pro2rel1spr2);
		pro2rel1spr2fea2.close();

		pro2rel1spr2fea3 = new Feature("Projekt 2, Release 1, Sprint 2, Feature 3", "Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel1spr2fea3.setLastEditor(pBjoern);
		pro2rel1spr2fea3.setManDayCosts(5);
		pro2rel1spr2fea3.setSprint(pro2rel1spr2);
		pro2rel1spr2fea3.close();

		pro2rel1spr2fea4 = new Feature("Projekt 2, Release 1, Sprint 2, Feature 4", "Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel1spr2fea4.setLastEditor(pBjoern);
		pro2rel1spr2fea4.setManDayCosts(4);
		pro2rel1spr2fea4.setSprint(pro2rel1spr2);
		pro2rel1spr2fea4.close();

		pro2rel1spr2fea5 = new Feature("Projekt 2, Release 1, Sprint 2, Feature 5", "Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel1spr2fea5.setLastEditor(pBjoern);
		pro2rel1spr2fea5.setManDayCosts(3);
		pro2rel1spr2fea5.setSprint(pro2rel1spr2);
		pro2rel1spr2fea5.close();

		// für Projekt 2, Release 1, Sprint 3
		pro2rel1spr3fea1 = new Feature("Projekt 2, Release 1, Sprint 3, Feature 1", "Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel1spr3fea1.setLastEditor(pBjoern);
		pro2rel1spr3fea1.setManDayCosts(3);
		pro2rel1spr3fea1.setSprint(pro2rel1spr3);
		pro2rel1spr3fea1.close();

		pro2rel1spr3fea2 = new Feature("Projekt 2, Release 1, Sprint 3, Feature 2", "Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel1spr3fea2.setLastEditor(pBjoern);
		pro2rel1spr3fea2.setManDayCosts(4);
		pro2rel1spr3fea2.setSprint(pro2rel1spr3);
		pro2rel1spr3fea2.close();

		pro2rel1spr3fea3 = new Feature("Projekt 2, Release 1, Sprint 3, Feature 3", "Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel1spr3fea3.setLastEditor(pBjoern);
		pro2rel1spr3fea3.setManDayCosts(5);
		pro2rel1spr3fea3.setSprint(pro2rel1spr3);
		pro2rel1spr3fea3.close();

		pro2rel1spr3fea4 = new Feature("Projekt 2, Release 1, Sprint 3, Feature 4", "Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel1spr3fea4.setLastEditor(pBjoern);
		pro2rel1spr3fea4.setManDayCosts(4);
		pro2rel1spr3fea4.setSprint(pro2rel1spr3);
		pro2rel1spr3fea4.close();

		pro2rel1spr3fea5 = new Feature("Projekt 2, Release 1, Sprint 3, Feature 5", "Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel1spr3fea5.setLastEditor(pBjoern);
		pro2rel1spr3fea5.setManDayCosts(3);
		pro2rel1spr3fea5.setSprint(pro2rel1spr3);
		pro2rel1spr3fea5.close();

		// für Projekt 2, Release 1, Sprint 4
		pro2rel1spr4fea1 = new Feature("Projekt 2, Release 1, Sprint 4, Feature 1", "Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel1spr4fea1.setLastEditor(pBjoern);
		pro2rel1spr4fea1.setManDayCosts(3);
		pro2rel1spr4fea1.setSprint(pro2rel1spr4);
		pro2rel1spr4fea1.close();

		pro2rel1spr4fea2 = new Feature("Projekt 2, Release 1, Sprint 4, Feature 2", "Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel1spr4fea2.setLastEditor(pBjoern);
		pro2rel1spr4fea2.setManDayCosts(4);
		pro2rel1spr4fea2.setSprint(pro2rel1spr4);
		pro2rel1spr4fea2.close();

		pro2rel1spr4fea3 = new Feature("Projekt 2, Release 1, Sprint 4, Feature 3", "Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel1spr4fea3.setLastEditor(pBjoern);
		pro2rel1spr4fea3.setManDayCosts(5);
		pro2rel1spr4fea3.setSprint(pro2rel1spr4);
		pro2rel1spr4fea3.close();

		pro2rel1spr4fea4 = new Feature("Projekt 2, Release 1, Sprint 4, Feature 4", "Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel1spr4fea4.setLastEditor(pBjoern);
		pro2rel1spr4fea4.setManDayCosts(4);
		pro2rel1spr4fea4.setSprint(pro2rel1spr4);
		pro2rel1spr4fea4.close();

		pro2rel1spr4fea5 = new Feature("Projekt 2, Release 1, Sprint 4, Feature 5", "Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel1spr4fea5.setLastEditor(pBjoern);
		pro2rel1spr4fea5.setManDayCosts(3);
		pro2rel1spr4fea5.setSprint(pro2rel1spr4);
		pro2rel1spr4fea5.close();

		// für Projekt 2, Release 1, Sprint 5
		pro2rel1spr5fea1 = new Feature("Projekt 2, Release 1, Sprint 5, Feature 1", "Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel1spr5fea1.setLastEditor(pBjoern);
		pro2rel1spr5fea1.setManDayCosts(3);
		pro2rel1spr5fea1.setSprint(pro2rel1spr5);
		pro2rel1spr5fea1.close();

		pro2rel1spr5fea2 = new Feature("Projekt 2, Release 1, Sprint 5, Feature 2", "Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel1spr5fea2.setLastEditor(pBjoern);
		pro2rel1spr5fea2.setManDayCosts(4);
		pro2rel1spr5fea2.setSprint(pro2rel1spr5);
		pro2rel1spr5fea2.close();

		pro2rel1spr5fea3 = new Feature("Projekt 2, Release 1, Sprint 5, Feature 3", "Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel1spr5fea3.setLastEditor(pBjoern);
		pro2rel1spr5fea3.setManDayCosts(5);
		pro2rel1spr5fea3.setSprint(pro2rel1spr5);
		pro2rel1spr5fea3.close();

		pro2rel1spr5fea4 = new Feature("Projekt 2, Release 1, Sprint 5, Feature 4", "Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel1spr5fea4.setLastEditor(pBjoern);
		pro2rel1spr5fea4.setManDayCosts(4);
		pro2rel1spr5fea4.setSprint(pro2rel1spr5);
		pro2rel1spr5fea4.close();

		pro2rel1spr5fea5 = new Feature("Projekt 2, Release 1, Sprint 5, Feature 5", "Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel1spr5fea5.setLastEditor(pBjoern);
		pro2rel1spr5fea5.setManDayCosts(3);
		pro2rel1spr5fea5.setSprint(pro2rel1spr5);
		pro2rel1spr5fea5.close();

		// für Projekt 2, Release 2, Sprint 1
		pro2rel2spr1fea1 = new Feature("Projekt 2, Release 2, Sprint 1, Feature 1", "Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel2spr1fea1.setLastEditor(pBjoern);
		pro2rel2spr1fea1.setManDayCosts(3);
		pro2rel2spr1fea1.setSprint(pro2rel2spr1);
		pro2rel2spr1fea1.close();

		pro2rel2spr1fea2 = new Feature("Projekt 2, Release 2, Sprint 1, Feature 2", "Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel2spr1fea2.setLastEditor(pBjoern);
		pro2rel2spr1fea2.setManDayCosts(4);
		pro2rel2spr1fea2.setSprint(pro2rel2spr1);
		pro2rel2spr1fea2.close();

		pro2rel2spr1fea3 = new Feature("Projekt 2, Release 2, Sprint 1, Feature 3", "Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel2spr1fea3.setLastEditor(pBjoern);
		pro2rel2spr1fea3.setManDayCosts(5);
		pro2rel2spr1fea3.setSprint(pro2rel2spr1);
		pro2rel2spr1fea3.close();

		pro2rel2spr1fea4 = new Feature("Projekt 2, Release 2, Sprint 1, Feature 4", "Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel2spr1fea4.setLastEditor(pBjoern);
		pro2rel2spr1fea4.setManDayCosts(4);
		pro2rel2spr1fea4.setSprint(pro2rel2spr1);
		pro2rel2spr1fea4.close();

		pro2rel2spr1fea5 = new Feature("Projekt 2, Release 2, Sprint 1, Feature 5", "Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel2spr1fea5.setLastEditor(pBjoern);
		pro2rel2spr1fea5.setManDayCosts(3);
		pro2rel2spr1fea5.setSprint(pro2rel2spr1);
		pro2rel2spr1fea5.close();

		// für Projekt 2, Release 2, Sprint 2
		pro2rel2spr2fea1 = new Feature("Projekt 2, Release 2, Sprint 2, Feature 1", "Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel2spr2fea1.setLastEditor(pBjoern);
		pro2rel2spr2fea1.setManDayCosts(3);
		pro2rel2spr2fea1.setSprint(pro2rel2spr2);
		pro2rel2spr2fea1.close();

		pro2rel2spr2fea2 = new Feature("Projekt 2, Release 2, Sprint 2, Feature 2", "Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel2spr2fea2.setLastEditor(pBjoern);
		pro2rel2spr2fea2.setManDayCosts(4);
		pro2rel2spr2fea2.setSprint(pro2rel2spr2);
		pro2rel2spr2fea2.close();

		pro2rel2spr2fea3 = new Feature("Projekt 2, Release 2, Sprint 2, Feature 3", "Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel2spr2fea3.setLastEditor(pBjoern);
		pro2rel2spr2fea3.setManDayCosts(5);
		pro2rel2spr2fea3.setSprint(pro2rel2spr2);
		pro2rel2spr2fea3.close();

		pro2rel2spr2fea4 = new Feature("Projekt 2, Release 2, Sprint 2, Feature 4", "Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel2spr2fea4.setLastEditor(pBjoern);
		pro2rel2spr2fea4.setManDayCosts(4);
		pro2rel2spr2fea4.setSprint(pro2rel2spr2);
		pro2rel2spr2fea4.close();

		pro2rel2spr2fea5 = new Feature("Projekt 2, Release 2, Sprint 2, Feature 5", "Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel2spr2fea5.setLastEditor(pBjoern);
		pro2rel2spr2fea5.setManDayCosts(3);
		pro2rel2spr2fea5.setSprint(pro2rel2spr2);
		pro2rel2spr2fea5.close();

		// für Projekt 2, Release 2, Sprint 3
		pro2rel2spr3fea1 = new Feature("Projekt 2, Release 2, Sprint 3, Feature 1", "Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel2spr3fea1.setLastEditor(pBjoern);
		pro2rel2spr3fea1.setManDayCosts(3);
		pro2rel2spr3fea1.setSprint(pro2rel2spr3);
		pro2rel2spr3fea1.close();

		pro2rel2spr3fea2 = new Feature("Projekt 2, Release 2, Sprint 3, Feature 2", "Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel2spr3fea2.setLastEditor(pBjoern);
		pro2rel2spr3fea2.setManDayCosts(4);
		pro2rel2spr3fea2.setSprint(pro2rel2spr3);
		pro2rel2spr3fea2.close();

		pro2rel2spr3fea3 = new Feature("Projekt 2, Release 2, Sprint 3, Feature 3", "Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel2spr3fea3.setLastEditor(pBjoern);
		pro2rel2spr3fea3.setManDayCosts(5);
		pro2rel2spr3fea3.setSprint(pro2rel2spr3);
		pro2rel2spr3fea3.close();

		pro2rel2spr3fea4 = new Feature("Projekt 2, Release 2, Sprint 3, Feature 4", "Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel2spr3fea4.setLastEditor(pBjoern);
		pro2rel2spr3fea4.setManDayCosts(4);
		pro2rel2spr3fea4.setSprint(pro2rel2spr3);
		pro2rel2spr3fea4.close();

		pro2rel2spr3fea5 = new Feature("Projekt 2, Release 2, Sprint 3, Feature 5", "Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel2spr3fea5.setLastEditor(pBjoern);
		pro2rel2spr3fea5.setManDayCosts(3);
		pro2rel2spr3fea5.setSprint(pro2rel2spr3);
		pro2rel2spr3fea5.close();

		// für Projekt 2, Release 2, Sprint 4
		pro2rel2spr4fea1 = new Feature("Projekt 2, Release 2, Sprint 4, Feature 1", "Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel2spr4fea1.setLastEditor(pBjoern);
		pro2rel2spr4fea1.setManDayCosts(3);
		pro2rel2spr4fea1.setSprint(pro2rel2spr4);
		pro2rel2spr4fea1.close();

		pro2rel2spr4fea2 = new Feature("Projekt 2, Release 2, Sprint 4, Feature 2", "Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel2spr4fea2.setLastEditor(pBjoern);
		pro2rel2spr4fea2.setManDayCosts(4);
		pro2rel2spr4fea2.setSprint(pro2rel2spr4);
		pro2rel2spr4fea2.close();

		pro2rel2spr4fea3 = new Feature("Projekt 2, Release 2, Sprint 4, Feature 3", "Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel2spr4fea3.setLastEditor(pBjoern);
		pro2rel2spr4fea3.setManDayCosts(5);
		pro2rel2spr4fea3.setSprint(pro2rel2spr4);
		pro2rel2spr4fea3.close();

		pro2rel2spr4fea4 = new Feature("Projekt 2, Release 2, Sprint 4, Feature 4", "Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel2spr4fea4.setLastEditor(pBjoern);
		pro2rel2spr4fea4.setManDayCosts(4);
		pro2rel2spr4fea4.setSprint(pro2rel2spr4);
		pro2rel2spr4fea4.close();

		pro2rel2spr4fea5 = new Feature("Projekt 2, Release 2, Sprint 4, Feature 5", "Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel2spr4fea5.setLastEditor(pBjoern);
		pro2rel2spr4fea5.setManDayCosts(3);
		pro2rel2spr4fea5.setSprint(pro2rel2spr4);
		pro2rel2spr4fea5.close();

		// für Projekt 2, Release 2, Sprint 5
		pro2rel2spr5fea1 = new Feature("Projekt 2, Release 2, Sprint 5, Feature 1", "Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel2spr5fea1.setLastEditor(pBjoern);
		pro2rel2spr5fea1.setManDayCosts(3);
		pro2rel2spr5fea1.setSprint(pro2rel2spr5);
		pro2rel2spr5fea1.close();

		pro2rel2spr5fea2 = new Feature("Projekt 2, Release 2, Sprint 5, Feature 2", "Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel2spr5fea2.setLastEditor(pBjoern);
		pro2rel2spr5fea2.setManDayCosts(4);
		pro2rel2spr5fea2.setSprint(pro2rel2spr5);
		pro2rel2spr5fea2.close();

		pro2rel2spr5fea3 = new Feature("Projekt 2, Release 2, Sprint 5, Feature 3", "Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel2spr5fea3.setLastEditor(pBjoern);
		pro2rel2spr5fea3.setManDayCosts(5);
		pro2rel2spr5fea3.setSprint(pro2rel2spr5);
		pro2rel2spr5fea3.close();

		pro2rel2spr5fea4 = new Feature("Projekt 2, Release 2, Sprint 5, Feature 4", "Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel2spr5fea4.setLastEditor(pBjoern);
		pro2rel2spr5fea4.setManDayCosts(4);
		pro2rel2spr5fea4.setSprint(pro2rel2spr5);
		pro2rel2spr5fea4.close();

		pro2rel2spr5fea5 = new Feature("Projekt 2, Release 2, Sprint 5, Feature 5", "Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel2spr5fea5.setLastEditor(pBjoern);
		pro2rel2spr5fea5.setManDayCosts(3);
		pro2rel2spr5fea5.setSprint(pro2rel2spr5);
		pro2rel2spr5fea5.close();

		// adding features to projects
		projekt1.getBacklog().addItem(pro1rel1spr1fea1);
		projekt1.getBacklog().addItem(pro1rel1spr1fea2);
		projekt1.getBacklog().addItem(pro1rel1spr1fea3);
		projekt1.getBacklog().addItem(pro1rel1spr1fea4);
		projekt1.getBacklog().addItem(pro1rel1spr1fea5);

		projekt1.getBacklog().addItem(pro1rel1spr2fea1);
		projekt1.getBacklog().addItem(pro1rel1spr2fea2);
		projekt1.getBacklog().addItem(pro1rel1spr2fea3);
		projekt1.getBacklog().addItem(pro1rel1spr2fea4);
		projekt1.getBacklog().addItem(pro1rel1spr2fea5);

		projekt1.getBacklog().addItem(pro1rel1spr3fea1);
		projekt1.getBacklog().addItem(pro1rel1spr3fea2);
		projekt1.getBacklog().addItem(pro1rel1spr3fea3);
		projekt1.getBacklog().addItem(pro1rel1spr3fea4);
		projekt1.getBacklog().addItem(pro1rel1spr3fea5);

		projekt1.getBacklog().addItem(pro1rel1spr4fea1);
		projekt1.getBacklog().addItem(pro1rel1spr4fea2);
		projekt1.getBacklog().addItem(pro1rel1spr4fea3);
		projekt1.getBacklog().addItem(pro1rel1spr4fea4);
		projekt1.getBacklog().addItem(pro1rel1spr4fea5);

		projekt1.getBacklog().addItem(pro1rel1spr5fea1);
		projekt1.getBacklog().addItem(pro1rel1spr5fea2);
		projekt1.getBacklog().addItem(pro1rel1spr5fea3);
		projekt1.getBacklog().addItem(pro1rel1spr5fea4);
		projekt1.getBacklog().addItem(pro1rel1spr5fea5);

		projekt1.getBacklog().addItem(pro1rel2spr1fea1);
		projekt1.getBacklog().addItem(pro1rel2spr1fea2);
		projekt1.getBacklog().addItem(pro1rel2spr1fea3);
		projekt1.getBacklog().addItem(pro1rel2spr1fea4);
		projekt1.getBacklog().addItem(pro1rel2spr1fea5);

		projekt1.getBacklog().addItem(pro1rel2spr2fea1);
		projekt1.getBacklog().addItem(pro1rel2spr2fea2);
		projekt1.getBacklog().addItem(pro1rel2spr2fea3);
		projekt1.getBacklog().addItem(pro1rel2spr2fea4);
		projekt1.getBacklog().addItem(pro1rel2spr2fea5);

		projekt1.getBacklog().addItem(pro1rel2spr3fea1);
		projekt1.getBacklog().addItem(pro1rel2spr3fea2);
		projekt1.getBacklog().addItem(pro1rel2spr3fea3);
		projekt1.getBacklog().addItem(pro1rel2spr3fea4);
		projekt1.getBacklog().addItem(pro1rel2spr3fea5);

		projekt1.getBacklog().addItem(pro1rel2spr4fea1);
		projekt1.getBacklog().addItem(pro1rel2spr4fea2);
		projekt1.getBacklog().addItem(pro1rel2spr4fea3);
		projekt1.getBacklog().addItem(pro1rel2spr4fea4);
		projekt1.getBacklog().addItem(pro1rel2spr4fea5);

		projekt1.getBacklog().addItem(pro1rel2spr5fea1);
		projekt1.getBacklog().addItem(pro1rel2spr5fea2);
		projekt1.getBacklog().addItem(pro1rel2spr5fea3);
		projekt1.getBacklog().addItem(pro1rel2spr5fea4);
		projekt1.getBacklog().addItem(pro1rel2spr5fea5);

		projekt2.getBacklog().addItem(pro2rel1spr1fea1);
		projekt2.getBacklog().addItem(pro2rel1spr1fea2);
		projekt2.getBacklog().addItem(pro2rel1spr1fea3);
		projekt2.getBacklog().addItem(pro2rel1spr1fea4);
		projekt2.getBacklog().addItem(pro2rel1spr1fea5);

		projekt2.getBacklog().addItem(pro2rel1spr2fea1);
		projekt2.getBacklog().addItem(pro2rel1spr2fea2);
		projekt2.getBacklog().addItem(pro2rel1spr2fea3);
		projekt2.getBacklog().addItem(pro2rel1spr2fea4);
		projekt2.getBacklog().addItem(pro2rel1spr2fea5);

		projekt2.getBacklog().addItem(pro2rel1spr3fea1);
		projekt2.getBacklog().addItem(pro2rel1spr3fea2);
		projekt2.getBacklog().addItem(pro2rel1spr3fea3);
		projekt2.getBacklog().addItem(pro2rel1spr3fea4);
		projekt2.getBacklog().addItem(pro2rel1spr3fea5);

		projekt2.getBacklog().addItem(pro2rel1spr4fea1);
		projekt2.getBacklog().addItem(pro2rel1spr4fea2);
		projekt2.getBacklog().addItem(pro2rel1spr4fea3);
		projekt2.getBacklog().addItem(pro2rel1spr4fea4);
		projekt2.getBacklog().addItem(pro2rel1spr4fea5);

		projekt2.getBacklog().addItem(pro2rel1spr5fea1);
		projekt2.getBacklog().addItem(pro2rel1spr5fea2);
		projekt2.getBacklog().addItem(pro2rel1spr5fea3);
		projekt2.getBacklog().addItem(pro2rel1spr5fea4);
		projekt2.getBacklog().addItem(pro2rel1spr5fea5);

		projekt2.getBacklog().addItem(pro2rel2spr1fea1);
		projekt2.getBacklog().addItem(pro2rel2spr1fea2);
		projekt2.getBacklog().addItem(pro2rel2spr1fea3);
		projekt2.getBacklog().addItem(pro2rel2spr1fea4);
		projekt2.getBacklog().addItem(pro2rel2spr1fea5);

		projekt2.getBacklog().addItem(pro2rel2spr2fea1);
		projekt2.getBacklog().addItem(pro2rel2spr2fea2);
		projekt2.getBacklog().addItem(pro2rel2spr2fea3);
		projekt2.getBacklog().addItem(pro2rel2spr2fea4);
		projekt2.getBacklog().addItem(pro2rel2spr2fea5);

		projekt2.getBacklog().addItem(pro2rel2spr3fea1);
		projekt2.getBacklog().addItem(pro2rel2spr3fea2);
		projekt2.getBacklog().addItem(pro2rel2spr3fea3);
		projekt2.getBacklog().addItem(pro2rel2spr3fea4);
		projekt2.getBacklog().addItem(pro2rel2spr3fea5);

		projekt2.getBacklog().addItem(pro2rel2spr4fea1);
		projekt2.getBacklog().addItem(pro2rel2spr4fea2);
		projekt2.getBacklog().addItem(pro2rel2spr4fea3);
		projekt2.getBacklog().addItem(pro2rel2spr4fea4);
		projekt2.getBacklog().addItem(pro2rel2spr4fea5);

		projekt2.getBacklog().addItem(pro2rel2spr5fea1);
		projekt2.getBacklog().addItem(pro2rel2spr5fea2);
		projekt2.getBacklog().addItem(pro2rel2spr5fea3);
		projekt2.getBacklog().addItem(pro2rel2spr5fea4);
		projekt2.getBacklog().addItem(pro2rel2spr5fea5);

		// Initial Tasks
		// für Projekt 1, Release 1, Sprint 1
		pro1rel1spr1tas1 = new Task("Projekt 1, Release 1, Sprint 1, Task 1", "Beschreibung von Task 1");
		pro1rel1spr1.getSprintBacklog().addTask(pro1rel1spr1tas1);
		pro1rel1spr1tas1.addPBI(pro1rel1spr1fea1);
		pro1rel1spr1tas1.setPlanEffort(5);
		pro1rel1spr1tas1.setResponsibility(pBjoern);
		pro1rel1spr1tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr1tas2 = new Task("Projekt 1, Release 1, Sprint 1, Task 2", "Beschreibung von Task 2");
		pro1rel1spr1.getSprintBacklog().addTask(pro1rel1spr1tas2);
		pro1rel1spr1tas2.addPBI(pro1rel1spr1fea2);
		pro1rel1spr1tas2.setPlanEffort(5);
		pro1rel1spr1tas2.setResponsibility(pBjoern);
		pro1rel1spr1tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr1tas3 = new Task("Projekt 1, Release 1, Sprint 1, Task 3", "Beschreibung von Task 3");
		pro1rel1spr1.getSprintBacklog().addTask(pro1rel1spr1tas3);
		pro1rel1spr1tas3.addPBI(pro1rel1spr1fea3);
		pro1rel1spr1tas3.setPlanEffort(5);
		pro1rel1spr1tas3.setResponsibility(pBjoern);
		pro1rel1spr1tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr1tas4 = new Task("Projekt 1, Release 1, Sprint 1, Task 4", "Beschreibung von Task 4");
		pro1rel1spr1.getSprintBacklog().addTask(pro1rel1spr1tas4);
		pro1rel1spr1tas4.addPBI(pro1rel1spr1fea4);
		pro1rel1spr1tas4.setPlanEffort(5);
		pro1rel1spr1tas4.setResponsibility(pBjoern);
		pro1rel1spr1tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr1tas5 = new Task("Projekt 1, Release 1, Sprint 1, Task 5", "Beschreibung von Task 5");
		pro1rel1spr1.getSprintBacklog().addTask(pro1rel1spr1tas5);
		pro1rel1spr1tas5.addPBI(pro1rel1spr1fea5);
		pro1rel1spr1tas5.setPlanEffort(5);
		pro1rel1spr1tas5.setResponsibility(pBjoern);
		pro1rel1spr1tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 1, Release 1, Sprint 2
		pro1rel1spr2tas1 = new Task("Projekt 1, Release 1, Sprint 2, Task 1", "Beschreibung von Task 1");
		pro1rel1spr2.getSprintBacklog().addTask(pro1rel1spr2tas1);
		pro1rel1spr2tas1.addPBI(pro1rel1spr2fea1);
		pro1rel1spr2tas1.setPlanEffort(5);
		pro1rel1spr2tas1.setResponsibility(pBjoern);
		pro1rel1spr2tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr2tas2 = new Task("Projekt 1, Release 1, Sprint 2, Task 2", "Beschreibung von Task 2");
		pro1rel1spr2.getSprintBacklog().addTask(pro1rel1spr2tas2);
		pro1rel1spr2tas2.addPBI(pro1rel1spr2fea2);
		pro1rel1spr2tas2.setPlanEffort(5);
		pro1rel1spr2tas2.setResponsibility(pBjoern);
		pro1rel1spr2tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr2tas3 = new Task("Projekt 1, Release 1, Sprint 2, Task 3", "Beschreibung von Task 3");
		pro1rel1spr2.getSprintBacklog().addTask(pro1rel1spr2tas3);
		pro1rel1spr2tas3.addPBI(pro1rel1spr2fea3);
		pro1rel1spr2tas3.setPlanEffort(5);
		pro1rel1spr2tas3.setResponsibility(pBjoern);
		pro1rel1spr2tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr2tas4 = new Task("Projekt 1, Release 1, Sprint 2, Task 4", "Beschreibung von Task 4");
		pro1rel1spr2.getSprintBacklog().addTask(pro1rel1spr2tas4);
		pro1rel1spr2tas4.addPBI(pro1rel1spr2fea4);
		pro1rel1spr2tas4.setPlanEffort(5);
		pro1rel1spr2tas4.setResponsibility(pBjoern);
		pro1rel1spr2tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr2tas5 = new Task("Projekt 1, Release 1, Sprint 2, Task 5", "Beschreibung von Task 5");
		pro1rel1spr2.getSprintBacklog().addTask(pro1rel1spr2tas5);
		pro1rel1spr2tas5.addPBI(pro1rel1spr2fea5);
		pro1rel1spr2tas5.setPlanEffort(5);
		pro1rel1spr2tas5.setResponsibility(pBjoern);
		pro1rel1spr2tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 1, Release 1, Sprint 3
		pro1rel1spr3tas1 = new Task("Projekt 1, Release 1, Sprint 3, Task 1", "Beschreibung von Task 1");
		pro1rel1spr3.getSprintBacklog().addTask(pro1rel1spr3tas1);
		pro1rel1spr3tas1.addPBI(pro1rel1spr3fea1);
		pro1rel1spr3tas1.setPlanEffort(5);
		pro1rel1spr3tas1.setResponsibility(pBjoern);
		pro1rel1spr3tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr3tas2 = new Task("Projekt 1, Release 1, Sprint 3, Task 2", "Beschreibung von Task 2");
		pro1rel1spr3.getSprintBacklog().addTask(pro1rel1spr3tas2);
		pro1rel1spr3tas2.addPBI(pro1rel1spr3fea2);
		pro1rel1spr3tas2.setPlanEffort(5);
		pro1rel1spr3tas2.setResponsibility(pBjoern);
		pro1rel1spr3tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr3tas3 = new Task("Projekt 1, Release 1, Sprint 3, Task 3", "Beschreibung von Task 3");
		pro1rel1spr3.getSprintBacklog().addTask(pro1rel1spr3tas3);
		pro1rel1spr3tas3.addPBI(pro1rel1spr3fea3);
		pro1rel1spr3tas3.setPlanEffort(5);
		pro1rel1spr3tas3.setResponsibility(pBjoern);
		pro1rel1spr3tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr3tas4 = new Task("Projekt 1, Release 1, Sprint 3, Task 4", "Beschreibung von Task 4");
		pro1rel1spr3.getSprintBacklog().addTask(pro1rel1spr3tas4);
		pro1rel1spr3tas4.addPBI(pro1rel1spr3fea4);
		pro1rel1spr3tas4.setPlanEffort(5);
		pro1rel1spr3tas4.setResponsibility(pBjoern);
		pro1rel1spr3tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr3tas5 = new Task("Projekt 1, Release 1, Sprint 3, Task 5", "Beschreibung von Task 5");
		pro1rel1spr3.getSprintBacklog().addTask(pro1rel1spr3tas5);
		pro1rel1spr3tas5.addPBI(pro1rel1spr3fea5);
		pro1rel1spr3tas5.setPlanEffort(5);
		pro1rel1spr3tas5.setResponsibility(pBjoern);
		pro1rel1spr3tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 1, Release 1, Sprint 4
		pro1rel1spr4tas1 = new Task("Projekt 1, Release 1, Sprint 4, Task 1", "Beschreibung von Task 1");
		pro1rel1spr4.getSprintBacklog().addTask(pro1rel1spr4tas1);
		pro1rel1spr4tas1.addPBI(pro1rel1spr4fea1);
		pro1rel1spr4tas1.setPlanEffort(5);
		pro1rel1spr4tas1.setResponsibility(pBjoern);
		pro1rel1spr4tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr4tas2 = new Task("Projekt 1, Release 1, Sprint 4, Task 2", "Beschreibung von Task 2");
		pro1rel1spr4.getSprintBacklog().addTask(pro1rel1spr4tas2);
		pro1rel1spr4tas2.addPBI(pro1rel1spr4fea2);
		pro1rel1spr4tas2.setPlanEffort(5);
		pro1rel1spr4tas2.setResponsibility(pBjoern);
		pro1rel1spr4tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr4tas3 = new Task("Projekt 1, Release 1, Sprint 4, Task 3", "Beschreibung von Task 3");
		pro1rel1spr4.getSprintBacklog().addTask(pro1rel1spr4tas3);
		pro1rel1spr4tas3.addPBI(pro1rel1spr4fea3);
		pro1rel1spr4tas3.setPlanEffort(5);
		pro1rel1spr4tas3.setResponsibility(pBjoern);
		pro1rel1spr4tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr4tas4 = new Task("Projekt 1, Release 1, Sprint 4, Task 4", "Beschreibung von Task 4");
		pro1rel1spr4.getSprintBacklog().addTask(pro1rel1spr4tas4);
		pro1rel1spr4tas4.addPBI(pro1rel1spr4fea4);
		pro1rel1spr4tas4.setPlanEffort(5);
		pro1rel1spr4tas4.setResponsibility(pBjoern);
		pro1rel1spr4tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr4tas5 = new Task("Projekt 1, Release 1, Sprint 4, Task 5", "Beschreibung von Task 5");
		pro1rel1spr4.getSprintBacklog().addTask(pro1rel1spr4tas5);
		pro1rel1spr4tas5.addPBI(pro1rel1spr4fea5);
		pro1rel1spr4tas5.setPlanEffort(5);
		pro1rel1spr4tas5.setResponsibility(pBjoern);
		pro1rel1spr4tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 1, Release 1, Sprint 5
		pro1rel1spr5tas1 = new Task("Projekt 1, Release 1, Sprint 5, Task 1", "Beschreibung von Task 1");
		pro1rel1spr5.getSprintBacklog().addTask(pro1rel1spr5tas1);
		pro1rel1spr5tas1.addPBI(pro1rel1spr5fea1);
		pro1rel1spr5tas1.setPlanEffort(5);
		pro1rel1spr5tas1.setResponsibility(pBjoern);
		pro1rel1spr5tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr5tas2 = new Task("Projekt 1, Release 1, Sprint 5, Task 2", "Beschreibung von Task 2");
		pro1rel1spr5.getSprintBacklog().addTask(pro1rel1spr5tas2);
		pro1rel1spr5tas2.addPBI(pro1rel1spr5fea2);
		pro1rel1spr5tas2.setPlanEffort(5);
		pro1rel1spr5tas2.setResponsibility(pBjoern);
		pro1rel1spr5tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr5tas3 = new Task("Projekt 1, Release 1, Sprint 5, Task 3", "Beschreibung von Task 3");
		pro1rel1spr5.getSprintBacklog().addTask(pro1rel1spr5tas3);
		pro1rel1spr5tas3.addPBI(pro1rel1spr5fea3);
		pro1rel1spr5tas3.setPlanEffort(5);
		pro1rel1spr5tas3.setResponsibility(pBjoern);
		pro1rel1spr5tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr5tas4 = new Task("Projekt 1, Release 1, Sprint 5, Task 4", "Beschreibung von Task 4");
		pro1rel1spr5.getSprintBacklog().addTask(pro1rel1spr5tas4);
		pro1rel1spr5tas4.addPBI(pro1rel1spr5fea4);
		pro1rel1spr5tas4.setPlanEffort(5);
		pro1rel1spr5tas4.setResponsibility(pBjoern);
		pro1rel1spr5tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr5tas5 = new Task("Projekt 1, Release 1, Sprint 5, Task 5", "Beschreibung von Task 5");
		pro1rel1spr5.getSprintBacklog().addTask(pro1rel1spr5tas5);
		pro1rel1spr5tas5.addPBI(pro1rel1spr5fea5);
		pro1rel1spr5tas5.setPlanEffort(5);
		pro1rel1spr5tas5.setResponsibility(pBjoern);
		pro1rel1spr5tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 1, Release 2, Sprint 1
		pro1rel2spr1tas1 = new Task("Projekt 1, Release 2, Sprint 1, Task 1", "Beschreibung von Task 1");
		pro1rel2spr1.getSprintBacklog().addTask(pro1rel2spr1tas1);
		pro1rel2spr1tas1.addPBI(pro1rel2spr1fea1);
		pro1rel2spr1tas1.setPlanEffort(5);
		pro1rel2spr1tas1.setResponsibility(pBjoern);
		pro1rel2spr1tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr1tas2 = new Task("Projekt 1, Release 2, Sprint 1, Task 2", "Beschreibung von Task 2");
		pro1rel2spr1.getSprintBacklog().addTask(pro1rel2spr1tas2);
		pro1rel2spr1tas2.addPBI(pro1rel2spr1fea2);
		pro1rel2spr1tas2.setPlanEffort(5);
		pro1rel2spr1tas2.setResponsibility(pBjoern);
		pro1rel2spr1tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr1tas3 = new Task("Projekt 1, Release 2, Sprint 1, Task 3", "Beschreibung von Task 3");
		pro1rel2spr1.getSprintBacklog().addTask(pro1rel2spr1tas3);
		pro1rel2spr1tas3.addPBI(pro1rel2spr1fea3);
		pro1rel2spr1tas3.setPlanEffort(5);
		pro1rel2spr1tas3.setResponsibility(pBjoern);
		pro1rel2spr1tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr1tas4 = new Task("Projekt 1, Release 2, Sprint 1, Task 4", "Beschreibung von Task 4");
		pro1rel2spr1.getSprintBacklog().addTask(pro1rel2spr1tas4);
		pro1rel2spr1tas4.addPBI(pro1rel2spr1fea4);
		pro1rel2spr1tas4.setPlanEffort(5);
		pro1rel2spr1tas4.setResponsibility(pBjoern);
		pro1rel2spr1tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr1tas5 = new Task("Projekt 1, Release 2, Sprint 1, Task 5", "Beschreibung von Task 5");
		pro1rel2spr1.getSprintBacklog().addTask(pro1rel2spr1tas5);
		pro1rel2spr1tas5.addPBI(pro1rel2spr1fea5);
		pro1rel2spr1tas5.setPlanEffort(5);
		pro1rel2spr1tas5.setResponsibility(pBjoern);
		pro1rel2spr1tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 1, Release 2, Sprint 2
		pro1rel2spr2tas1 = new Task("Projekt 1, Release 2, Sprint 2, Task 1", "Beschreibung von Task 1");
		pro1rel2spr2.getSprintBacklog().addTask(pro1rel2spr2tas1);
		pro1rel2spr2tas1.addPBI(pro1rel2spr2fea1);
		pro1rel2spr2tas1.setPlanEffort(5);
		pro1rel2spr2tas1.setResponsibility(pBjoern);
		pro1rel2spr2tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr2tas2 = new Task("Projekt 1, Release 2, Sprint 2, Task 2", "Beschreibung von Task 2");
		pro1rel2spr2.getSprintBacklog().addTask(pro1rel2spr2tas2);
		pro1rel2spr2tas2.addPBI(pro1rel2spr2fea2);
		pro1rel2spr2tas2.setPlanEffort(5);
		pro1rel2spr2tas2.setResponsibility(pBjoern);
		pro1rel2spr2tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr2tas3 = new Task("Projekt 1, Release 2, Sprint 2, Task 3", "Beschreibung von Task 3");
		pro1rel2spr2.getSprintBacklog().addTask(pro1rel2spr2tas3);
		pro1rel2spr2tas3.addPBI(pro1rel2spr2fea3);
		pro1rel2spr2tas3.setPlanEffort(5);
		pro1rel2spr2tas3.setResponsibility(pBjoern);
		pro1rel2spr2tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr2tas4 = new Task("Projekt 1, Release 2, Sprint 2, Task 4", "Beschreibung von Task 4");
		pro1rel2spr2.getSprintBacklog().addTask(pro1rel2spr2tas4);
		pro1rel2spr2tas4.addPBI(pro1rel2spr2fea4);
		pro1rel2spr2tas4.setPlanEffort(5);
		pro1rel2spr2tas4.setResponsibility(pBjoern);
		pro1rel2spr2tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr2tas5 = new Task("Projekt 1, Release 2, Sprint 2, Task 5", "Beschreibung von Task 5");
		pro1rel2spr2.getSprintBacklog().addTask(pro1rel2spr2tas5);
		pro1rel2spr2tas5.addPBI(pro1rel2spr2fea5);
		pro1rel2spr2tas5.setPlanEffort(5);
		pro1rel2spr2tas5.setResponsibility(pBjoern);
		pro1rel2spr2tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 1, Release 2, Sprint 3
		pro1rel2spr3tas1 = new Task("Projekt 1, Release 2, Sprint 3, Task 1", "Beschreibung von Task 1");
		pro1rel2spr3.getSprintBacklog().addTask(pro1rel2spr3tas1);
		pro1rel2spr3tas1.addPBI(pro1rel2spr3fea1);
		pro1rel2spr3tas1.setPlanEffort(5);
		pro1rel2spr3tas1.setResponsibility(pBjoern);
		pro1rel2spr3tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr3tas2 = new Task("Projekt 1, Release 2, Sprint 3, Task 2", "Beschreibung von Task 2");
		pro1rel2spr3.getSprintBacklog().addTask(pro1rel2spr3tas2);
		pro1rel2spr3tas2.addPBI(pro1rel2spr3fea2);
		pro1rel2spr3tas2.setPlanEffort(5);
		pro1rel2spr3tas2.setResponsibility(pBjoern);
		pro1rel2spr3tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr3tas3 = new Task("Projekt 1, Release 2, Sprint 3, Task 3", "Beschreibung von Task 3");
		pro1rel2spr3.getSprintBacklog().addTask(pro1rel2spr3tas3);
		pro1rel2spr3tas3.addPBI(pro1rel2spr3fea3);
		pro1rel2spr3tas3.setPlanEffort(5);
		pro1rel2spr3tas3.setResponsibility(pBjoern);
		pro1rel2spr3tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr3tas4 = new Task("Projekt 1, Release 2, Sprint 3, Task 4", "Beschreibung von Task 4");
		pro1rel2spr3.getSprintBacklog().addTask(pro1rel2spr3tas4);
		pro1rel2spr3tas4.addPBI(pro1rel2spr3fea4);
		pro1rel2spr3tas4.setPlanEffort(5);
		pro1rel2spr3tas4.setResponsibility(pBjoern);
		pro1rel2spr3tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr3tas5 = new Task("Projekt 1, Release 2, Sprint 3, Task 5", "Beschreibung von Task 5");
		pro1rel2spr3.getSprintBacklog().addTask(pro1rel2spr3tas5);
		pro1rel2spr3tas5.addPBI(pro1rel2spr3fea5);
		pro1rel2spr3tas5.setPlanEffort(5);
		pro1rel2spr3tas5.setResponsibility(pBjoern);
		pro1rel2spr3tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 1, Release 2, Sprint 4
		pro1rel2spr4tas1 = new Task("Projekt 1, Release 2, Sprint 4, Task 1", "Beschreibung von Task 1");
		pro1rel2spr4.getSprintBacklog().addTask(pro1rel2spr4tas1);
		pro1rel2spr4tas1.addPBI(pro1rel2spr4fea1);
		pro1rel2spr4tas1.setPlanEffort(5);
		pro1rel2spr4tas1.setResponsibility(pBjoern);
		pro1rel2spr4tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr4tas2 = new Task("Projekt 1, Release 2, Sprint 4, Task 2", "Beschreibung von Task 2");
		pro1rel2spr4.getSprintBacklog().addTask(pro1rel2spr4tas2);
		pro1rel2spr4tas2.addPBI(pro1rel2spr4fea2);
		pro1rel2spr4tas2.setPlanEffort(5);
		pro1rel2spr4tas2.setResponsibility(pBjoern);
		pro1rel2spr4tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr4tas3 = new Task("Projekt 1, Release 2, Sprint 4, Task 3", "Beschreibung von Task 3");
		pro1rel2spr4.getSprintBacklog().addTask(pro1rel2spr4tas3);
		pro1rel2spr4tas3.addPBI(pro1rel2spr4fea3);
		pro1rel2spr4tas3.setPlanEffort(5);
		pro1rel2spr4tas3.setResponsibility(pBjoern);
		pro1rel2spr4tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr4tas4 = new Task("Projekt 1, Release 2, Sprint 4, Task 4", "Beschreibung von Task 4");
		pro1rel2spr4.getSprintBacklog().addTask(pro1rel2spr4tas4);
		pro1rel2spr4tas4.addPBI(pro1rel2spr4fea4);
		pro1rel2spr4tas4.setPlanEffort(5);
		pro1rel2spr4tas4.setResponsibility(pBjoern);
		pro1rel2spr4tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr4tas5 = new Task("Projekt 1, Release 2, Sprint 4, Task 5", "Beschreibung von Task 5");
		pro1rel2spr4.getSprintBacklog().addTask(pro1rel2spr4tas5);
		pro1rel2spr4tas5.addPBI(pro1rel2spr4fea5);
		pro1rel2spr4tas5.setPlanEffort(5);
		pro1rel2spr4tas5.setResponsibility(pBjoern);
		pro1rel2spr4tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 1, Release 2, Sprint 5
		pro1rel2spr5tas1 = new Task("Projekt 1, Release 2, Sprint 5, Task 1", "Beschreibung von Task 1");
		pro1rel2spr5.getSprintBacklog().addTask(pro1rel2spr5tas1);
		pro1rel2spr5tas1.addPBI(pro1rel2spr5fea1);
		pro1rel2spr5tas1.setPlanEffort(5);
		pro1rel2spr5tas1.setResponsibility(pBjoern);
		pro1rel2spr5tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr5tas2 = new Task("Projekt 1, Release 2, Sprint 5, Task 2", "Beschreibung von Task 2");
		pro1rel2spr5.getSprintBacklog().addTask(pro1rel2spr5tas2);
		pro1rel2spr5tas2.addPBI(pro1rel2spr5fea2);
		pro1rel2spr5tas2.setPlanEffort(5);
		pro1rel2spr5tas2.setResponsibility(pBjoern);
		pro1rel2spr5tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr5tas3 = new Task("Projekt 1, Release 2, Sprint 5, Task 3", "Beschreibung von Task 3");
		pro1rel2spr5.getSprintBacklog().addTask(pro1rel2spr5tas3);
		pro1rel2spr5tas3.addPBI(pro1rel2spr5fea3);
		pro1rel2spr5tas3.setPlanEffort(5);
		pro1rel2spr5tas3.setResponsibility(pBjoern);
		pro1rel2spr5tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr5tas4 = new Task("Projekt 1, Release 2, Sprint 5, Task 4", "Beschreibung von Task 4");
		pro1rel2spr5.getSprintBacklog().addTask(pro1rel2spr5tas4);
		pro1rel2spr5tas4.addPBI(pro1rel2spr5fea4);
		pro1rel2spr5tas4.setPlanEffort(5);
		pro1rel2spr5tas4.setResponsibility(pBjoern);
		pro1rel2spr5tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr5tas5 = new Task("Projekt 1, Release 2, Sprint 5, Task 5", "Beschreibung von Task 5");
		pro1rel2spr5.getSprintBacklog().addTask(pro1rel2spr5tas5);
		pro1rel2spr5tas5.addPBI(pro1rel2spr5fea5);
		pro1rel2spr5tas5.setPlanEffort(5);
		pro1rel2spr5tas5.setResponsibility(pBjoern);
		pro1rel2spr5tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 2, Release 1, Sprint 1
		pro2rel1spr1tas1 = new Task("Projekt 2, Release 1, Sprint 1, Task 1", "Beschreibung von Task 1");
		pro2rel1spr1.getSprintBacklog().addTask(pro2rel1spr1tas1);
		pro2rel1spr1tas1.addPBI(pro2rel1spr1fea1);
		pro2rel1spr1tas1.setPlanEffort(5);
		pro2rel1spr1tas1.setResponsibility(pBjoern);
		pro2rel1spr1tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr1tas2 = new Task("Projekt 2, Release 1, Sprint 1, Task 2", "Beschreibung von Task 2");
		pro2rel1spr1.getSprintBacklog().addTask(pro2rel1spr1tas2);
		pro2rel1spr1tas2.addPBI(pro2rel1spr1fea2);
		pro2rel1spr1tas2.setPlanEffort(5);
		pro2rel1spr1tas2.setResponsibility(pBjoern);
		pro2rel1spr1tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr1tas3 = new Task("Projekt 2, Release 1, Sprint 1, Task 3", "Beschreibung von Task 3");
		pro2rel1spr1.getSprintBacklog().addTask(pro2rel1spr1tas3);
		pro2rel1spr1tas3.addPBI(pro2rel1spr1fea3);
		pro2rel1spr1tas3.setPlanEffort(5);
		pro2rel1spr1tas3.setResponsibility(pBjoern);
		pro2rel1spr1tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr1tas4 = new Task("Projekt 2, Release 1, Sprint 1, Task 4", "Beschreibung von Task 4");
		pro2rel1spr1.getSprintBacklog().addTask(pro2rel1spr1tas4);
		pro2rel1spr1tas4.addPBI(pro2rel1spr1fea4);
		pro2rel1spr1tas4.setPlanEffort(5);
		pro2rel1spr1tas4.setResponsibility(pBjoern);
		pro2rel1spr1tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr1tas5 = new Task("Projekt 2, Release 1, Sprint 1, Task 5", "Beschreibung von Task 5");
		pro2rel1spr1.getSprintBacklog().addTask(pro2rel1spr1tas5);
		pro2rel1spr1tas5.addPBI(pro2rel1spr1fea5);
		pro2rel1spr1tas5.setPlanEffort(5);
		pro2rel1spr1tas5.setResponsibility(pBjoern);
		pro2rel1spr1tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 2, Release 1, Sprint 2
		pro2rel1spr2tas1 = new Task("Projekt 2, Release 1, Sprint 2, Task 1", "Beschreibung von Task 1");
		pro2rel1spr2.getSprintBacklog().addTask(pro2rel1spr2tas1);
		pro2rel1spr2tas1.addPBI(pro2rel1spr2fea1);
		pro2rel1spr2tas1.setPlanEffort(5);
		pro2rel1spr2tas1.setResponsibility(pBjoern);
		pro2rel1spr2tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr2tas2 = new Task("Projekt 2, Release 1, Sprint 2, Task 2", "Beschreibung von Task 2");
		pro2rel1spr2.getSprintBacklog().addTask(pro2rel1spr2tas2);
		pro2rel1spr2tas2.addPBI(pro2rel1spr2fea2);
		pro2rel1spr2tas2.setPlanEffort(5);
		pro2rel1spr2tas2.setResponsibility(pBjoern);
		pro2rel1spr2tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr2tas3 = new Task("Projekt 2, Release 1, Sprint 2, Task 3", "Beschreibung von Task 3");
		pro2rel1spr2.getSprintBacklog().addTask(pro2rel1spr2tas3);
		pro2rel1spr2tas3.addPBI(pro2rel1spr2fea3);
		pro2rel1spr2tas3.setPlanEffort(5);
		pro2rel1spr2tas3.setResponsibility(pBjoern);
		pro2rel1spr2tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr2tas4 = new Task("Projekt 2, Release 1, Sprint 2, Task 4", "Beschreibung von Task 4");
		pro2rel1spr2.getSprintBacklog().addTask(pro2rel1spr2tas4);
		pro2rel1spr2tas4.addPBI(pro2rel1spr2fea4);
		pro2rel1spr2tas4.setPlanEffort(5);
		pro2rel1spr2tas4.setResponsibility(pBjoern);
		pro2rel1spr2tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr2tas5 = new Task("Projekt 2, Release 1, Sprint 2, Task 5", "Beschreibung von Task 5");
		pro2rel1spr2.getSprintBacklog().addTask(pro2rel1spr2tas5);
		pro2rel1spr2tas5.addPBI(pro2rel1spr2fea5);
		pro2rel1spr2tas5.setPlanEffort(5);
		pro2rel1spr2tas5.setResponsibility(pBjoern);
		pro2rel1spr2tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 2, Release 1, Sprint 3
		pro2rel1spr3tas1 = new Task("Projekt 2, Release 1, Sprint 3, Task 1", "Beschreibung von Task 1");
		pro2rel1spr3.getSprintBacklog().addTask(pro2rel1spr3tas1);
		pro2rel1spr3tas1.addPBI(pro2rel1spr3fea1);
		pro2rel1spr3tas1.setPlanEffort(5);
		pro2rel1spr3tas1.setResponsibility(pBjoern);
		pro2rel1spr3tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr3tas2 = new Task("Projekt 2, Release 1, Sprint 3, Task 2", "Beschreibung von Task 2");
		pro2rel1spr3.getSprintBacklog().addTask(pro2rel1spr3tas2);
		pro2rel1spr3tas2.addPBI(pro2rel1spr3fea2);
		pro2rel1spr3tas2.setPlanEffort(5);
		pro2rel1spr3tas2.setResponsibility(pBjoern);
		pro2rel1spr3tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr3tas3 = new Task("Projekt 2, Release 1, Sprint 3, Task 3", "Beschreibung von Task 3");
		pro2rel1spr3.getSprintBacklog().addTask(pro2rel1spr3tas3);
		pro2rel1spr3tas3.addPBI(pro2rel1spr3fea3);
		pro2rel1spr3tas3.setPlanEffort(5);
		pro2rel1spr3tas3.setResponsibility(pBjoern);
		pro2rel1spr3tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr3tas4 = new Task("Projekt 2, Release 1, Sprint 3, Task 4", "Beschreibung von Task 4");
		pro2rel1spr3.getSprintBacklog().addTask(pro2rel1spr3tas4);
		pro2rel1spr3tas4.addPBI(pro2rel1spr3fea4);
		pro2rel1spr3tas4.setPlanEffort(5);
		pro2rel1spr3tas4.setResponsibility(pBjoern);
		pro2rel1spr3tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr3tas5 = new Task("Projekt 2, Release 1, Sprint 3, Task 5", "Beschreibung von Task 5");
		pro2rel1spr3.getSprintBacklog().addTask(pro2rel1spr3tas5);
		pro2rel1spr3tas5.addPBI(pro2rel1spr3fea5);
		pro2rel1spr3tas5.setPlanEffort(5);
		pro2rel1spr3tas5.setResponsibility(pBjoern);
		pro2rel1spr3tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 2, Release 1, Sprint 4
		pro2rel1spr4tas1 = new Task("Projekt 2, Release 1, Sprint 4, Task 1", "Beschreibung von Task 1");
		pro2rel1spr4.getSprintBacklog().addTask(pro2rel1spr4tas1);
		pro2rel1spr4tas1.addPBI(pro2rel1spr4fea1);
		pro2rel1spr4tas1.setPlanEffort(5);
		pro2rel1spr4tas1.setResponsibility(pBjoern);
		pro2rel1spr4tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr4tas2 = new Task("Projekt 2, Release 1, Sprint 4, Task 2", "Beschreibung von Task 2");
		pro2rel1spr4.getSprintBacklog().addTask(pro2rel1spr4tas2);
		pro2rel1spr4tas2.addPBI(pro2rel1spr4fea2);
		pro2rel1spr4tas2.setPlanEffort(5);
		pro2rel1spr4tas2.setResponsibility(pBjoern);
		pro2rel1spr4tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr4tas3 = new Task("Projekt 2, Release 1, Sprint 4, Task 3", "Beschreibung von Task 3");
		pro2rel1spr4.getSprintBacklog().addTask(pro2rel1spr4tas3);
		pro2rel1spr4tas3.addPBI(pro2rel1spr4fea3);
		pro2rel1spr4tas3.setPlanEffort(5);
		pro2rel1spr4tas3.setResponsibility(pBjoern);
		pro2rel1spr4tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr4tas4 = new Task("Projekt 2, Release 1, Sprint 4, Task 4", "Beschreibung von Task 4");
		pro2rel1spr4.getSprintBacklog().addTask(pro2rel1spr4tas4);
		pro2rel1spr4tas4.addPBI(pro2rel1spr4fea4);
		pro2rel1spr4tas4.setPlanEffort(5);
		pro2rel1spr4tas4.setResponsibility(pBjoern);
		pro2rel1spr4tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr4tas5 = new Task("Projekt 2, Release 1, Sprint 4, Task 5", "Beschreibung von Task 5");
		pro2rel1spr4.getSprintBacklog().addTask(pro2rel1spr4tas5);
		pro2rel1spr4tas5.addPBI(pro2rel1spr4fea5);
		pro2rel1spr4tas5.setPlanEffort(5);
		pro2rel1spr4tas5.setResponsibility(pBjoern);
		pro2rel1spr4tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 2, Release 1, Sprint 5
		pro2rel1spr5tas1 = new Task("Projekt 2, Release 1, Sprint 5, Task 1", "Beschreibung von Task 1");
		pro2rel1spr5.getSprintBacklog().addTask(pro2rel1spr5tas1);
		pro2rel1spr5tas1.addPBI(pro2rel1spr5fea1);
		pro2rel1spr5tas1.setPlanEffort(5);
		pro2rel1spr5tas1.setResponsibility(pBjoern);
		pro2rel1spr5tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr5tas2 = new Task("Projekt 2, Release 1, Sprint 5, Task 2", "Beschreibung von Task 2");
		pro2rel1spr5.getSprintBacklog().addTask(pro2rel1spr5tas2);
		pro2rel1spr5tas2.addPBI(pro2rel1spr5fea2);
		pro2rel1spr5tas2.setPlanEffort(5);
		pro2rel1spr5tas2.setResponsibility(pBjoern);
		pro2rel1spr5tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr5tas3 = new Task("Projekt 2, Release 1, Sprint 5, Task 3", "Beschreibung von Task 3");
		pro2rel1spr5.getSprintBacklog().addTask(pro2rel1spr5tas3);
		pro2rel1spr5tas3.addPBI(pro2rel1spr5fea3);
		pro2rel1spr5tas3.setPlanEffort(5);
		pro2rel1spr5tas3.setResponsibility(pBjoern);
		pro2rel1spr5tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr5tas4 = new Task("Projekt 2, Release 1, Sprint 5, Task 4", "Beschreibung von Task 4");
		pro2rel1spr5.getSprintBacklog().addTask(pro2rel1spr5tas4);
		pro2rel1spr5tas4.addPBI(pro2rel1spr5fea4);
		pro2rel1spr5tas4.setPlanEffort(5);
		pro2rel1spr5tas4.setResponsibility(pBjoern);
		pro2rel1spr5tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr5tas5 = new Task("Projekt 2, Release 1, Sprint 5, Task 5", "Beschreibung von Task 5");
		pro2rel1spr5.getSprintBacklog().addTask(pro2rel1spr5tas5);
		pro2rel1spr5tas5.addPBI(pro2rel1spr5fea5);
		pro2rel1spr5tas5.setPlanEffort(5);
		pro2rel1spr5tas5.setResponsibility(pBjoern);
		pro2rel1spr5tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 2, Release 2, Sprint 1
		pro2rel2spr1tas1 = new Task("Projekt 2, Release 2, Sprint 1, Task 1", "Beschreibung von Task 1");
		pro2rel2spr1.getSprintBacklog().addTask(pro2rel2spr1tas1);
		pro2rel2spr1tas1.addPBI(pro2rel2spr1fea1);
		pro2rel2spr1tas1.setPlanEffort(5);
		pro2rel2spr1tas1.setResponsibility(pBjoern);
		pro2rel2spr1tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr1tas2 = new Task("Projekt 2, Release 2, Sprint 1, Task 2", "Beschreibung von Task 2");
		pro2rel2spr1.getSprintBacklog().addTask(pro2rel2spr1tas2);
		pro2rel2spr1tas2.addPBI(pro2rel2spr1fea2);
		pro2rel2spr1tas2.setPlanEffort(5);
		pro2rel2spr1tas2.setResponsibility(pBjoern);
		pro2rel2spr1tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr1tas3 = new Task("Projekt 2, Release 2, Sprint 1, Task 3", "Beschreibung von Task 3");
		pro2rel2spr1.getSprintBacklog().addTask(pro2rel2spr1tas3);
		pro2rel2spr1tas3.addPBI(pro2rel2spr1fea3);
		pro2rel2spr1tas3.setPlanEffort(5);
		pro2rel2spr1tas3.setResponsibility(pBjoern);
		pro2rel2spr1tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr1tas4 = new Task("Projekt 2, Release 2, Sprint 1, Task 4", "Beschreibung von Task 4");
		pro2rel2spr1.getSprintBacklog().addTask(pro2rel2spr1tas4);
		pro2rel2spr1tas4.addPBI(pro2rel2spr1fea4);
		pro2rel2spr1tas4.setPlanEffort(5);
		pro2rel2spr1tas4.setResponsibility(pBjoern);
		pro2rel2spr1tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr1tas5 = new Task("Projekt 2, Release 2, Sprint 1, Task 5", "Beschreibung von Task 5");
		pro2rel2spr1.getSprintBacklog().addTask(pro2rel2spr1tas5);
		pro2rel2spr1tas5.addPBI(pro2rel2spr1fea5);
		pro2rel2spr1tas5.setPlanEffort(5);
		pro2rel2spr1tas5.setResponsibility(pBjoern);
		pro2rel2spr1tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 2, Release 2, Sprint 2
		pro2rel2spr2tas1 = new Task("Projekt 2, Release 2, Sprint 2, Task 1", "Beschreibung von Task 1");
		pro2rel2spr2.getSprintBacklog().addTask(pro2rel2spr2tas1);
		pro2rel2spr2tas1.addPBI(pro2rel2spr2fea1);
		pro2rel2spr2tas1.setPlanEffort(5);
		pro2rel2spr2tas1.setResponsibility(pBjoern);
		pro2rel2spr2tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr2tas2 = new Task("Projekt 2, Release 2, Sprint 2, Task 2", "Beschreibung von Task 2");
		pro2rel2spr2.getSprintBacklog().addTask(pro2rel2spr2tas2);
		pro2rel2spr2tas2.addPBI(pro2rel2spr2fea2);
		pro2rel2spr2tas2.setPlanEffort(5);
		pro2rel2spr2tas2.setResponsibility(pBjoern);
		pro2rel2spr2tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr2tas3 = new Task("Projekt 2, Release 2, Sprint 2, Task 3", "Beschreibung von Task 3");
		pro2rel2spr2.getSprintBacklog().addTask(pro2rel2spr2tas3);
		pro2rel2spr2tas3.addPBI(pro2rel2spr2fea3);
		pro2rel2spr2tas3.setPlanEffort(5);
		pro2rel2spr2tas3.setResponsibility(pBjoern);
		pro2rel2spr2tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr2tas4 = new Task("Projekt 2, Release 2, Sprint 2, Task 4", "Beschreibung von Task 4");
		pro2rel2spr2.getSprintBacklog().addTask(pro2rel2spr2tas4);
		pro2rel2spr2tas4.addPBI(pro2rel2spr2fea4);
		pro2rel2spr2tas4.setPlanEffort(5);
		pro2rel2spr2tas4.setResponsibility(pBjoern);
		pro2rel2spr2tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr2tas5 = new Task("Projekt 2, Release 2, Sprint 2, Task 5", "Beschreibung von Task 5");
		pro2rel2spr2.getSprintBacklog().addTask(pro2rel2spr2tas5);
		pro2rel2spr2tas5.addPBI(pro2rel2spr2fea5);
		pro2rel2spr2tas5.setPlanEffort(5);
		pro2rel2spr2tas5.setResponsibility(pBjoern);
		pro2rel2spr2tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 2, Release 2, Sprint 3
		pro2rel2spr3tas1 = new Task("Projekt 2, Release 2, Sprint 3, Task 1", "Beschreibung von Task 1");
		pro2rel2spr3.getSprintBacklog().addTask(pro2rel2spr3tas1);
		pro2rel2spr3tas1.addPBI(pro2rel2spr3fea1);
		pro2rel2spr3tas1.setPlanEffort(5);
		pro2rel2spr3tas1.setResponsibility(pBjoern);
		pro2rel2spr3tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr3tas2 = new Task("Projekt 2, Release 2, Sprint 3, Task 2", "Beschreibung von Task 2");
		pro2rel2spr3.getSprintBacklog().addTask(pro2rel2spr3tas2);
		pro2rel2spr3tas2.addPBI(pro2rel2spr3fea2);
		pro2rel2spr3tas2.setPlanEffort(5);
		pro2rel2spr3tas2.setResponsibility(pBjoern);
		pro2rel2spr3tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr3tas3 = new Task("Projekt 2, Release 2, Sprint 3, Task 3", "Beschreibung von Task 3");
		pro2rel2spr3.getSprintBacklog().addTask(pro2rel2spr3tas3);
		pro2rel2spr3tas3.addPBI(pro2rel2spr3fea3);
		pro2rel2spr3tas3.setPlanEffort(5);
		pro2rel2spr3tas3.setResponsibility(pBjoern);
		pro2rel2spr3tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr3tas4 = new Task("Projekt 2, Release 2, Sprint 3, Task 4", "Beschreibung von Task 4");
		pro2rel2spr3.getSprintBacklog().addTask(pro2rel2spr3tas4);
		pro2rel2spr3tas4.addPBI(pro2rel2spr3fea4);
		pro2rel2spr3tas4.setPlanEffort(5);
		pro2rel2spr3tas4.setResponsibility(pBjoern);
		pro2rel2spr3tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr3tas5 = new Task("Projekt 2, Release 2, Sprint 3, Task 5", "Beschreibung von Task 5");
		pro2rel2spr3.getSprintBacklog().addTask(pro2rel2spr3tas5);
		pro2rel2spr3tas5.addPBI(pro2rel2spr3fea5);
		pro2rel2spr3tas5.setPlanEffort(5);
		pro2rel2spr3tas5.setResponsibility(pBjoern);
		pro2rel2spr3tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 2, Release 2, Sprint 4
		pro2rel2spr4tas1 = new Task("Projekt 2, Release 2, Sprint 4, Task 1", "Beschreibung von Task 1");
		pro2rel2spr4.getSprintBacklog().addTask(pro2rel2spr4tas1);
		pro2rel2spr4tas1.addPBI(pro2rel2spr4fea1);
		pro2rel2spr4tas1.setPlanEffort(5);
		pro2rel2spr4tas1.setResponsibility(pBjoern);
		pro2rel2spr4tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr4tas2 = new Task("Projekt 2, Release 2, Sprint 4, Task 2", "Beschreibung von Task 2");
		pro2rel2spr4.getSprintBacklog().addTask(pro2rel2spr4tas2);
		pro2rel2spr4tas2.addPBI(pro2rel2spr4fea2);
		pro2rel2spr4tas2.setPlanEffort(5);
		pro2rel2spr4tas2.setResponsibility(pBjoern);
		pro2rel2spr4tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr4tas3 = new Task("Projekt 2, Release 2, Sprint 4, Task 3", "Beschreibung von Task 3");
		pro2rel2spr4.getSprintBacklog().addTask(pro2rel2spr4tas3);
		pro2rel2spr4tas3.addPBI(pro2rel2spr4fea3);
		pro2rel2spr4tas3.setPlanEffort(5);
		pro2rel2spr4tas3.setResponsibility(pBjoern);
		pro2rel2spr4tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr4tas4 = new Task("Projekt 2, Release 2, Sprint 4, Task 4", "Beschreibung von Task 4");
		pro2rel2spr4.getSprintBacklog().addTask(pro2rel2spr4tas4);
		pro2rel2spr4tas4.addPBI(pro2rel2spr4fea4);
		pro2rel2spr4tas4.setPlanEffort(5);
		pro2rel2spr4tas4.setResponsibility(pBjoern);
		pro2rel2spr4tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr4tas5 = new Task("Projekt 2, Release 2, Sprint 4, Task 5", "Beschreibung von Task 5");
		pro2rel2spr4.getSprintBacklog().addTask(pro2rel2spr4tas5);
		pro2rel2spr4tas5.addPBI(pro2rel2spr4fea5);
		pro2rel2spr4tas5.setPlanEffort(5);
		pro2rel2spr4tas5.setResponsibility(pBjoern);
		pro2rel2spr4tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 2, Release 2, Sprint 5
		pro2rel2spr5tas1 = new Task("Projekt 2, Release 2, Sprint 5, Task 1", "Beschreibung von Task 1");
		pro2rel2spr5.getSprintBacklog().addTask(pro2rel2spr5tas1);
		pro2rel2spr5tas1.addPBI(pro2rel2spr5fea1);
		pro2rel2spr5tas1.setPlanEffort(5);
		pro2rel2spr5tas1.setResponsibility(pBjoern);
		pro2rel2spr5tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr5tas2 = new Task("Projekt 2, Release 2, Sprint 5, Task 2", "Beschreibung von Task 2");
		pro2rel2spr5.getSprintBacklog().addTask(pro2rel2spr5tas2);
		pro2rel2spr5tas2.addPBI(pro2rel2spr5fea2);
		pro2rel2spr5tas2.setPlanEffort(5);
		pro2rel2spr5tas2.setResponsibility(pBjoern);
		pro2rel2spr5tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr5tas3 = new Task("Projekt 2, Release 2, Sprint 5, Task 3", "Beschreibung von Task 3");
		pro2rel2spr5.getSprintBacklog().addTask(pro2rel2spr5tas3);
		pro2rel2spr5tas3.addPBI(pro2rel2spr5fea3);
		pro2rel2spr5tas3.setPlanEffort(5);
		pro2rel2spr5tas3.setResponsibility(pBjoern);
		pro2rel2spr5tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr5tas4 = new Task("Projekt 2, Release 2, Sprint 5, Task 4", "Beschreibung von Task 4");
		pro2rel2spr5.getSprintBacklog().addTask(pro2rel2spr5tas4);
		pro2rel2spr5tas4.addPBI(pro2rel2spr5fea4);
		pro2rel2spr5tas4.setPlanEffort(5);
		pro2rel2spr5tas4.setResponsibility(pBjoern);
		pro2rel2spr5tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr5tas5 = new Task("Projekt 2, Release 2, Sprint 5, Task 5", "Beschreibung von Task 5");
		pro2rel2spr5.getSprintBacklog().addTask(pro2rel2spr5tas5);
		pro2rel2spr5tas5.addPBI(pro2rel2spr5fea5);
		pro2rel2spr5tas5.setPlanEffort(5);
		pro2rel2spr5tas5.setResponsibility(pBjoern);
		pro2rel2spr5tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

	}

	@After
	public void tearDown() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
