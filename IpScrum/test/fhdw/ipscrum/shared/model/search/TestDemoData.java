package fhdw.ipscrum.shared.model.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import fhdw.ipscrum.client.utils.CalendarUtils;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Effort;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.Root;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Task;
import fhdw.ipscrum.shared.model.Team;

public class TestDemoData {

	public Feature pro1rel2spr1fea1;
	public Feature pro1rel1spr5fea5;
	public Feature pro1rel1spr1fea1;
	public Feature pro1rel1spr1fea2;
	public Feature pro1rel1spr1fea3;
	public Feature pro1rel1spr1fea4;
	public Feature pro1rel1spr1fea5;
	public Feature pro1rel1spr2fea1;
	public Feature pro1rel1spr2fea2;
	public Feature pro1rel1spr2fea3;
	public Feature pro1rel1spr2fea4;
	public Feature pro1rel1spr2fea5;
	public Feature pro1rel1spr3fea1;
	public Feature pro1rel1spr3fea2;
	public Feature pro1rel1spr3fea3;
	public Feature pro1rel1spr3fea4;
	public Feature pro1rel1spr3fea5;
	public Feature pro1rel1spr4fea1;
	public Feature pro1rel1spr4fea2;
	public Feature pro1rel1spr4fea3;
	public Feature pro1rel1spr4fea4;
	public Feature pro1rel1spr4fea5;
	public Feature pro1rel1spr5fea1;
	public Feature pro1rel1spr5fea2;
	public Feature pro1rel1spr5fea3;
	public Feature pro1rel1spr5fea4;
	public Feature pro1rel2spr1fea2;
	public Feature pro1rel2spr1fea3;
	public Feature pro1rel2spr1fea4;
	public Feature pro1rel2spr1fea5;
	public Feature pro1rel2spr2fea1;
	public Feature pro1rel2spr2fea2;
	public Feature pro1rel2spr2fea3;
	public Feature pro1rel2spr2fea4;
	public Feature pro1rel2spr2fea5;
	public Feature pro1rel2spr3fea1;
	public Feature pro1rel2spr3fea2;
	public Feature pro1rel2spr3fea3;
	public Feature pro1rel2spr3fea4;
	public Feature pro1rel2spr3fea5;
	public Feature pro1rel2spr4fea1;
	public Feature pro1rel2spr4fea2;
	public Feature pro1rel2spr4fea3;
	public Feature pro1rel2spr4fea4;
	public Feature pro1rel2spr4fea5;
	public Feature pro1rel2spr5fea1;
	public Feature pro1rel2spr5fea2;
	public Feature pro1rel2spr5fea3;
	public Feature pro1rel2spr5fea4;
	public Feature pro1rel2spr5fea5;
	public Feature pro2rel1spr1fea1;
	public Feature pro2rel1spr1fea2;
	public Feature pro2rel1spr1fea3;
	public Feature pro2rel1spr1fea4;
	public Feature pro2rel1spr1fea5;
	public Feature pro2rel1spr2fea1;
	public Feature pro2rel1spr2fea2;
	public Feature pro2rel1spr2fea3;
	public Feature pro2rel1spr2fea4;
	public Feature pro2rel1spr2fea5;
	public Feature pro2rel1spr3fea1;
	public Feature pro2rel1spr3fea2;
	public Feature pro2rel1spr3fea3;
	public Feature pro2rel1spr3fea4;
	public Feature pro2rel1spr3fea5;
	public Feature pro2rel1spr4fea1;
	public Feature pro2rel1spr4fea2;
	public Feature pro2rel1spr4fea3;
	public Feature pro2rel1spr4fea4;
	public Feature pro2rel1spr4fea5;
	public Feature pro2rel1spr5fea1;
	public Feature pro2rel1spr5fea2;
	public Feature pro2rel1spr5fea3;
	public Feature pro2rel1spr5fea4;
	public Feature pro2rel1spr5fea5;
	public Feature pro2rel2spr1fea1;
	public Feature pro2rel2spr1fea2;
	public Feature pro2rel2spr1fea3;
	public Feature pro2rel2spr1fea4;
	public Feature pro2rel2spr1fea5;
	public Feature pro2rel2spr2fea1;
	public Feature pro2rel2spr2fea2;
	public Feature pro2rel2spr2fea3;
	public Feature pro2rel2spr2fea4;
	public Feature pro2rel2spr2fea5;
	public Feature pro2rel2spr3fea1;
	public Feature pro2rel2spr3fea2;
	public Feature pro2rel2spr3fea3;
	public Feature pro2rel2spr3fea4;
	public Feature pro2rel2spr3fea5;
	public Feature pro2rel2spr4fea1;
	public Feature pro2rel2spr4fea2;
	public Feature pro2rel2spr4fea3;
	public Feature pro2rel2spr4fea4;
	public Feature pro2rel2spr4fea5;
	public Feature pro2rel2spr5fea1;
	public Feature pro2rel2spr5fea2;
	public Feature pro2rel2spr5fea3;
	public Feature pro2rel2spr5fea4;
	public Feature pro2rel2spr5fea5;
	public Role roleTSUser;
	public Root root;
	public Role roleScrummaster;
	public Role roleProductOwner;
	public Role roleDeveloper;
	public Role roleTester;
	public Role roleGUIWiz;
	public Person pSarah;
	public Person pWilken;
	public Person pChristin;
	public Person pBjoern;
	public Person pChris;
	public Team team1;
	public Team team2;
	public Team team3;
	public Team team4;
	public Project projekt1;
	public Project projekt2;
	public Release pro1rel1;
	public Release pro1rel2;
	public Release pro2rel1;
	public Release pro2rel2;
	public Sprint pro1rel1spr1;
	public Sprint pro1rel1spr2;
	public Sprint pro1rel1spr3;
	public Sprint pro1rel1spr4;
	public Sprint pro1rel1spr5;
	public Sprint pro1rel2spr1;
	public Sprint pro1rel2spr2;
	public Sprint pro1rel2spr3;
	public Sprint pro1rel2spr4;
	public Sprint pro1rel2spr5;
	public Sprint pro2rel1spr1;
	public Sprint pro2rel1spr2;
	public Sprint pro2rel1spr3;
	public Sprint pro2rel1spr4;
	public Sprint pro2rel1spr5;
	public Sprint pro2rel2spr1;
	public Sprint pro2rel2spr2;
	public Sprint pro2rel2spr3;
	public Sprint pro2rel2spr4;
	public Sprint pro2rel2spr5;
	public Task pro1rel1spr1tas1;
	public Task pro1rel1spr1tas2;
	public Task pro1rel1spr1tas3;
	public Task pro1rel1spr1tas4;
	public Task pro1rel1spr1tas5;
	public Task pro1rel1spr2tas1;
	public Task pro1rel1spr2tas2;
	public Task pro1rel1spr2tas3;
	public Task pro1rel1spr2tas4;
	public Task pro1rel1spr2tas5;
	public Task pro1rel1spr3tas1;
	public Task pro1rel1spr3tas2;
	public Task pro1rel1spr3tas3;
	public Task pro1rel1spr3tas4;
	public Task pro1rel1spr3tas5;
	public Task pro1rel1spr4tas1;
	public Task pro1rel1spr4tas2;
	public Task pro1rel1spr4tas3;
	public Task pro1rel1spr4tas4;
	public Task pro1rel1spr4tas5;
	public Task pro1rel1spr5tas1;
	public Task pro1rel1spr5tas2;
	public Task pro1rel1spr5tas3;
	public Task pro1rel1spr5tas4;
	public Task pro1rel1spr5tas5;
	public Task pro1rel2spr1tas1;
	public Task pro1rel2spr1tas2;
	public Task pro1rel2spr1tas3;
	public Task pro1rel2spr1tas4;
	public Task pro1rel2spr1tas5;
	public Task pro1rel2spr2tas1;
	public Task pro1rel2spr2tas2;
	public Task pro1rel2spr2tas3;
	public Task pro1rel2spr2tas4;
	public Task pro1rel2spr2tas5;
	public Task pro1rel2spr3tas1;
	public Task pro1rel2spr3tas2;
	public Task pro1rel2spr3tas3;
	public Task pro1rel2spr3tas4;
	public Task pro1rel2spr3tas5;
	public Task pro1rel2spr4tas1;
	public Task pro1rel2spr4tas2;
	public Task pro1rel2spr4tas3;
	public Task pro1rel2spr4tas4;
	public Task pro1rel2spr4tas5;
	public Task pro1rel2spr5tas1;
	public Task pro1rel2spr5tas2;
	public Task pro1rel2spr5tas3;
	public Task pro1rel2spr5tas4;
	public Task pro1rel2spr5tas5;
	public Task pro2rel1spr1tas1;
	public Task pro2rel1spr1tas2;
	public Task pro2rel1spr1tas3;
	public Task pro2rel1spr1tas4;
	public Task pro2rel1spr1tas5;
	public Task pro2rel1spr2tas1;
	public Task pro2rel1spr2tas2;
	public Task pro2rel1spr2tas3;
	public Task pro2rel1spr2tas4;
	public Task pro2rel1spr2tas5;
	public Task pro2rel1spr3tas1;
	public Task pro2rel1spr3tas2;
	public Task pro2rel1spr3tas3;
	public Task pro2rel1spr3tas4;
	public Task pro2rel1spr3tas5;
	public Task pro2rel1spr4tas1;
	public Task pro2rel1spr4tas2;
	public Task pro2rel1spr4tas3;
	public Task pro2rel1spr4tas4;
	public Task pro2rel1spr4tas5;
	public Task pro2rel1spr5tas2;
	public Task pro2rel1spr5tas3;
	public Task pro2rel1spr5tas4;
	public Task pro2rel1spr5tas5;
	public Task pro2rel2spr1tas1;
	public Task pro2rel2spr1tas2;
	public Task pro2rel2spr1tas3;
	public Task pro2rel2spr1tas4;
	public Task pro2rel2spr1tas5;
	public Task pro2rel2spr2tas1;
	public Task pro2rel2spr2tas2;
	public Task pro2rel2spr2tas3;
	public Task pro2rel2spr2tas4;
	public Task pro2rel2spr2tas5;
	public Task pro2rel2spr3tas1;
	public Task pro2rel2spr3tas2;
	public Task pro2rel2spr3tas3;
	public Task pro2rel2spr3tas4;
	public Task pro2rel2spr3tas5;
	public Task pro2rel2spr4tas2;
	public Task pro2rel2spr4tas1;
	public Task pro2rel2spr4tas3;
	public Task pro2rel2spr4tas4;
	public Task pro2rel2spr4tas5;
	public Task pro2rel2spr5tas1;
	public Task pro2rel2spr5tas2;
	public Task pro2rel2spr5tas3;
	public Task pro2rel2spr5tas4;
	public Task pro2rel2spr5tas5;
	public Task pro2rel1spr5tas1;
	public Collection<ProductBacklogItem> listOfFeatures;

	public TestDemoData() throws UserException {
		RelationType.create("Abhängig von");
		RelationType.create("Siehe auch");

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
		pro1rel1 = new Release("1.0", CalendarUtils.getRandomReleaseDate(),
				projekt1);
		pro1rel2 = new Release("2.0", CalendarUtils.getRandomReleaseDate(),
				projekt1);
		pro2rel1 = new Release("1.0", CalendarUtils.getRandomReleaseDate(),
				projekt2);
		pro2rel2 = new Release("2.0", CalendarUtils.getRandomReleaseDate(),
				projekt2);

		// Initial Sprints
		// Für Projekt 1, Release 1
		Date pro1rel1spr1BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro1rel1spr1EndDate = CalendarUtils.getRandomSprintEnddate(
				pro1rel1spr1BeginDate, pro1rel1.getReleaseDate());
		pro1rel1spr1 = new Sprint("Pro1Rel1Sprint1", "Beschreibung Sprint 1",
				new Date(2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 2 - 1,
						28), team1);

		Date pro1rel1spr2BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro1rel1spr2EndDate = CalendarUtils.getRandomSprintEnddate(
				pro1rel1spr2BeginDate, pro1rel1.getReleaseDate());
		pro1rel1spr2 = new Sprint("Pro1Rel1Sprint2", "Beschreibung Sprint 2",
				new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
						31), team1);

		Date pro1rel1spr3BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro1rel1spr3EndDate = CalendarUtils.getRandomSprintEnddate(
				pro1rel1spr3BeginDate, pro1rel1.getReleaseDate());
		pro1rel1spr3 = new Sprint("Pro1Rel1Sprint3", "Beschreibung Sprint 3",
				new Date(2011 - 1900, 1 - 1, 1), new Date(2011 - 1900, 1 - 1,
						31), team1);

		Date pro1rel1spr4BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro1rel1spr4EndDate = CalendarUtils.getRandomSprintEnddate(
				pro1rel1spr4BeginDate, pro1rel1.getReleaseDate());
		pro1rel1spr4 = new Sprint("Pro1Rel1Sprint4", "Beschreibung Sprint 4",
				new Date(2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 3 - 1,
						31), team1);

		Date pro1rel1spr5BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro1rel1spr5EndDate = CalendarUtils.getRandomSprintEnddate(
				pro1rel1spr5BeginDate, pro1rel1.getReleaseDate());
		pro1rel1spr5 = new Sprint("Pro1Rel1Sprint5", "Beschreibung Sprint 5",
				new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
						31), team1);

		// Für Projekt 1, Release 2
		Date pro1rel2spr1BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro1rel2spr1EndDate = CalendarUtils.getRandomSprintEnddate(
				pro1rel2spr1BeginDate, pro1rel2.getReleaseDate());
		pro1rel2spr1 = new Sprint("Pro1Rel2Sprint1", "Beschreibung Sprint 1",
				new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
						31), team1);

		Date pro1rel2spr2BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro1rel2spr2EndDate = CalendarUtils.getRandomSprintEnddate(
				pro1rel2spr2BeginDate, pro1rel2.getReleaseDate());
		pro1rel2spr2 = new Sprint("Pro1Rel2Sprint2", "Beschreibung Sprint 2",
				new Date(2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 3 - 1,
						31), team1);

		Date pro1rel2spr3BeginDate = new Date();
		Date pro1rel2spr3EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro1rel2spr3BeginDate, 6);
		CalendarUtils.removeDaysFromDate(pro1rel2spr3EndDate, 4);
		pro1rel2spr3 = new Sprint("Pro1Rel2Sprint3", "Beschreibung Sprint 3",
				new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
						31), team1);

		Date pro1rel2spr4BeginDate = new Date();
		Date pro1rel2spr4EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro1rel2spr4BeginDate, 8);
		CalendarUtils.removeDaysFromDate(pro1rel2spr4EndDate, 1);
		pro1rel2spr4 = new Sprint("Pro1Rel2Sprint4", "Beschreibung Sprint 4",
				new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
						31), team1);

		Date pro1rel2spr5BeginDate = new Date();
		Date pro1rel2spr5EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro1rel2spr5BeginDate, 9);
		CalendarUtils.removeDaysFromDate(pro1rel2spr5EndDate, 4);
		pro1rel2spr5 = new Sprint("Pro1Rel2Sprint5", "Beschreibung Sprint 5",
				new Date(2011 - 1900, 4 - 1, 1), new Date(2011 - 1900, 4 - 1,
						30), team1);

		// Für Projekt 2, Release 1
		Date pro2rel1spr1BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro2rel1spr1EndDate = CalendarUtils.getRandomSprintEnddate(
				pro2rel1spr1BeginDate, pro2rel1.getReleaseDate());
		pro2rel1spr1 = new Sprint("Pro2Rel1Sprint1", "Beschreibung Sprint 1",
				new Date(2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 4 - 1,
						30), team1);

		Date pro2rel1spr2BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date pro2rel1spr2EndDate = CalendarUtils.getRandomSprintEnddate(
				pro2rel1spr2BeginDate, pro2rel1.getReleaseDate());
		pro2rel1spr2 = new Sprint("Pro2Rel1Sprint2", "Beschreibung Sprint 2",
				new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
						31), team1);

		Date pro2rel1spr3BeginDate = new Date();
		Date pro2rel1spr3EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro2rel1spr3BeginDate, 6);
		CalendarUtils.removeDaysFromDate(pro2rel1spr3EndDate, 4);
		pro2rel1spr3 = new Sprint("Pro2Rel1Sprint3", "Beschreibung Sprint 3",
				new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 4 - 1,
						30), team1);

		Date pro2rel1spr4BeginDate = new Date();
		Date pro2rel1spr4EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro2rel1spr4BeginDate, 8);
		CalendarUtils.removeDaysFromDate(pro2rel1spr4EndDate, 1);
		pro2rel1spr4 = new Sprint("Pro2Rel1Sprint4", "Beschreibung Sprint 4",
				new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
						31), team1);

		Date pro2rel1spr5BeginDate = new Date();
		Date pro2rel1spr5EndDate = new Date();
		CalendarUtils.removeDaysFromDate(pro2rel1spr5BeginDate, 9);
		CalendarUtils.removeDaysFromDate(pro2rel1spr5EndDate, 4);
		pro2rel1spr5 = new Sprint("Pro2Rel1Sprint5", "Beschreibung Sprint 5",
				new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
						31), team1);

		// Für Projekt 2, Release 2
		Date sprint6BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date sprint6EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint6BeginDate, pro2rel2.getReleaseDate());
		pro2rel2spr1 = new Sprint("Pro2Rel2Sprint1", "Beschreibung Sprint 1",
				new Date(2011 - 1900, 6 - 1, 1), new Date(2011 - 1900, 6 - 1,
						30), team1);

		Date sprint7BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date sprint7EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint7BeginDate, pro2rel2.getReleaseDate());
		pro2rel2spr2 = new Sprint("Pro2Rel2Sprint2", "Beschreibung Sprint 2",
				new Date(2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 3 - 1,
						31), team1);

		Date sprint8BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date sprint8EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint8BeginDate, pro2rel2.getReleaseDate());
		pro2rel2spr3 = new Sprint("Pro2Rel2Sprint3", "Beschreibung Sprint 3",
				new Date(2011 - 1900, 1 - 1, 1), new Date(2011 - 1900, 1 - 1,
						31), team1);

		Date sprint9BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date sprint9EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint9BeginDate, pro2rel2.getReleaseDate());
		pro2rel2spr4 = new Sprint("Pro2Rel2Sprint4", "Beschreibung Sprint 4",
				new Date(2011 - 1900, 3 - 1, 1), new Date(2011 - 1900, 3 - 1,
						31), team1);

		Date sprint10BeginDate = CalendarUtils.getRandomDateOfThisMonth();
		Date sprint10EndDate = CalendarUtils.getRandomSprintEnddate(
				sprint10BeginDate, pro2rel2.getReleaseDate());
		pro2rel2spr5 = new Sprint("Pro2Rel2Sprint5", "Beschreibung Sprint 5",
				new Date(2011 - 1900, 2 - 1, 1), new Date(2011 - 1900, 3 - 1,
						31), team1);

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
		pro1rel1spr1fea1 = new Feature(
				"Projekt 1, Release 1, Sprint 1, Feature 1",
				"Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel1spr1fea1.setLastEditor(pBjoern);
		pro1rel1spr1fea1.setManDayCosts(new Effort(3));
		pro1rel1spr1fea1.setSprint(pro1rel1spr1);
		pro1rel1spr1fea1.close();

		pro1rel1spr1fea2 = new Feature(
				"Projekt 1, Release 1, Sprint 1, Feature 2",
				"Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel1spr1fea2.setLastEditor(pBjoern);
		pro1rel1spr1fea2.setManDayCosts(new Effort(4));
		pro1rel1spr1fea2.setSprint(pro1rel1spr1);
		pro1rel1spr1fea2.close();

		pro1rel1spr1fea3 = new Feature(
				"Projekt 1, Release 1, Sprint 1, Feature 3",
				"Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel1spr1fea3.setLastEditor(pBjoern);
		pro1rel1spr1fea3.setManDayCosts(new Effort(5));
		pro1rel1spr1fea3.setSprint(pro1rel1spr1);
		// pro1rel1spr1fea3.close();

		pro1rel1spr1fea4 = new Feature(
				"Projekt 1, Release 1, Sprint 1, Feature 4",
				"Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel1spr1fea4.setLastEditor(pBjoern);
		pro1rel1spr1fea4.setManDayCosts(new Effort(4));
		pro1rel1spr1fea4.setSprint(pro1rel1spr1);
		// pro1rel1spr1fea4.close();

		pro1rel1spr1fea5 = new Feature(
				"Projekt 1, Release 1, Sprint 1, Feature 5",
				"Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel1spr1fea5.setLastEditor(pBjoern);
		pro1rel1spr1fea5.setManDayCosts(new Effort(3));
		pro1rel1spr1fea5.setSprint(pro1rel1spr1);
		pro1rel1spr1fea5.close();

		// für Projekt 1, Release 1, Sprint 2
		pro1rel1spr2fea1 = new Feature(
				"Projekt 1, Release 1, Sprint 2, Feature 1",
				"Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel1spr2fea1.setLastEditor(pBjoern);
		pro1rel1spr2fea1.setManDayCosts(new Effort(2));
		pro1rel1spr2fea1.setSprint(pro1rel1spr2);
		pro1rel1spr2fea1.close();

		pro1rel1spr2fea2 = new Feature(
				"Projekt 1, Release 1, Sprint 2, Feature 2",
				"Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel1spr2fea2.setLastEditor(pBjoern);
		pro1rel1spr2fea2.setManDayCosts(new Effort(10));
		pro1rel1spr2fea2.setSprint(pro1rel1spr2);
		// pro1rel1spr2fea2.close();

		pro1rel1spr2fea3 = new Feature(
				"Projekt 1, Release 1, Sprint 2, Feature 3",
				"Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel1spr2fea3.setLastEditor(pBjoern);
		pro1rel1spr2fea3.setManDayCosts(new Effort(15));
		pro1rel1spr2fea3.setSprint(pro1rel1spr2);
		pro1rel1spr2fea3.close();

		pro1rel1spr2fea4 = new Feature(
				"Projekt 1, Release 1, Sprint 2, Feature 4",
				"Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel1spr2fea4.setLastEditor(pBjoern);
		pro1rel1spr2fea4.setManDayCosts(new Effort(3));
		pro1rel1spr2fea4.setSprint(pro1rel1spr2);
		pro1rel1spr2fea4.close();

		pro1rel1spr2fea5 = new Feature(
				"Projekt 1, Release 1, Sprint 2, Feature 5",
				"Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel1spr2fea5.setLastEditor(pBjoern);
		pro1rel1spr2fea5.setManDayCosts(new Effort(6));
		pro1rel1spr2fea5.setSprint(pro1rel1spr2);
		// pro1rel1spr2fea5.close();

		// für Projekt 1, Release 1, Sprint 3
		pro1rel1spr3fea1 = new Feature(
				"Projekt 1, Release 1, Sprint 3, Feature 1",
				"Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel1spr3fea1.setLastEditor(pBjoern);
		pro1rel1spr3fea1.setManDayCosts(new Effort(20));
		pro1rel1spr3fea1.setSprint(pro1rel1spr3);
		// pro1rel1spr3fea1.close();

		pro1rel1spr3fea2 = new Feature(
				"Projekt 1, Release 1, Sprint 3, Feature 2",
				"Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel1spr3fea2.setLastEditor(pBjoern);
		pro1rel1spr3fea2.setManDayCosts(new Effort(6));
		pro1rel1spr3fea2.setSprint(pro1rel1spr3);
		// pro1rel1spr3fea2.close();

		pro1rel1spr3fea3 = new Feature(
				"Projekt 1, Release 1, Sprint 3, Feature 3",
				"Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel1spr3fea3.setLastEditor(pBjoern);
		pro1rel1spr3fea3.setManDayCosts(new Effort(48));
		pro1rel1spr3fea3.setSprint(pro1rel1spr3);
		pro1rel1spr3fea3.close();

		pro1rel1spr3fea4 = new Feature(
				"Projekt 1, Release 1, Sprint 3, Feature 4",
				"Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel1spr3fea4.setLastEditor(pBjoern);
		pro1rel1spr3fea4.setManDayCosts(new Effort(2));
		pro1rel1spr3fea4.setSprint(pro1rel1spr3);
		pro1rel1spr3fea4.close();

		pro1rel1spr3fea5 = new Feature(
				"Projekt 1, Release 1, Sprint 3, Feature 5",
				"Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel1spr3fea5.setLastEditor(pBjoern);
		pro1rel1spr3fea5.setManDayCosts(new Effort(1));
		pro1rel1spr3fea5.setSprint(pro1rel1spr3);
		// pro1rel1spr3fea5.close();

		// für Projekt 1, Release 1, Sprint 4
		pro1rel1spr4fea1 = new Feature(
				"Projekt 1, Release 1, Sprint 4, Feature 1",
				"Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel1spr4fea1.setLastEditor(pBjoern);
		pro1rel1spr4fea1.setManDayCosts(new Effort(4));
		pro1rel1spr4fea1.setSprint(pro1rel1spr4);
		// pro1rel1spr4fea1.close();

		pro1rel1spr4fea2 = new Feature(
				"Projekt 1, Release 1, Sprint 4, Feature 2",
				"Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel1spr4fea2.setLastEditor(pBjoern);
		pro1rel1spr4fea2.setManDayCosts(new Effort(10));
		pro1rel1spr4fea2.setSprint(pro1rel1spr4);
		// pro1rel1spr4fea2.close();

		pro1rel1spr4fea3 = new Feature(
				"Projekt 1, Release 1, Sprint 4, Feature 3",
				"Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel1spr4fea3.setLastEditor(pBjoern);
		pro1rel1spr4fea3.setManDayCosts(new Effort(5));
		pro1rel1spr4fea3.setSprint(pro1rel1spr4);
		// pro1rel1spr4fea3.close();

		pro1rel1spr4fea4 = new Feature(
				"Projekt 1, Release 1, Sprint 4, Feature 4",
				"Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel1spr4fea4.setLastEditor(pBjoern);
		pro1rel1spr4fea4.setManDayCosts(new Effort(9));
		pro1rel1spr4fea4.setSprint(pro1rel1spr4);
		// pro1rel1spr4fea4.close();

		pro1rel1spr4fea5 = new Feature(
				"Projekt 1, Release 1, Sprint 4, Feature 5",
				"Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel1spr4fea5.setLastEditor(pBjoern);
		pro1rel1spr4fea5.setManDayCosts(new Effort(3));
		pro1rel1spr4fea5.setSprint(pro1rel1spr4);
		// pro1rel1spr4fea5.close();

		// für Projekt 1, Release 1, Sprint 5
		pro1rel1spr5fea1 = new Feature(
				"Projekt 1, Release 1, Sprint 5, Feature 1",
				"Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel1spr5fea1.setLastEditor(pBjoern);
		pro1rel1spr5fea1.setManDayCosts(new Effort(16));
		pro1rel1spr5fea1.setSprint(pro1rel1spr5);
		pro1rel1spr5fea1.close();

		pro1rel1spr5fea2 = new Feature(
				"Projekt 1, Release 1, Sprint 5, Feature 2",
				"Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel1spr5fea2.setLastEditor(pBjoern);
		pro1rel1spr5fea2.setManDayCosts(new Effort(4));
		pro1rel1spr5fea2.setSprint(pro1rel1spr5);
		pro1rel1spr5fea2.close();

		pro1rel1spr5fea3 = new Feature(
				"Projekt 1, Release 1, Sprint 5, Feature 3",
				"Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel1spr5fea3.setLastEditor(pBjoern);
		pro1rel1spr5fea3.setManDayCosts(new Effort(5));
		pro1rel1spr5fea3.setSprint(pro1rel1spr5);
		pro1rel1spr5fea3.close();

		pro1rel1spr5fea4 = new Feature(
				"Projekt 1, Release 1, Sprint 5, Feature 4",
				"Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel1spr5fea4.setLastEditor(pBjoern);
		pro1rel1spr5fea4.setManDayCosts(new Effort(35));
		pro1rel1spr5fea4.setSprint(pro1rel1spr5);
		pro1rel1spr5fea4.close();

		pro1rel1spr5fea5 = new Feature(
				"Projekt 1, Release 1, Sprint 5, Feature 5",
				"Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel1spr5fea5.setLastEditor(pBjoern);
		pro1rel1spr5fea5.setManDayCosts(new Effort(3));
		pro1rel1spr5fea5.setSprint(pro1rel1spr5);
		pro1rel1spr5fea5.close();

		// für Projekt 1, Release 2, Sprint 1
		pro1rel2spr1fea1 = new Feature(
				"Projekt 1, Release 2, Sprint 1, Feature 1",
				"Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel2spr1fea1.setLastEditor(pBjoern);
		pro1rel2spr1fea1.setManDayCosts(new Effort(80));
		pro1rel2spr1fea1.setSprint(pro1rel2spr1);
		pro1rel2spr1fea1.close();

		pro1rel2spr1fea2 = new Feature(
				"Projekt 1, Release 2, Sprint 1, Feature 2",
				"Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel2spr1fea2.setLastEditor(pBjoern);
		pro1rel2spr1fea2.setManDayCosts(new Effort(20));
		pro1rel2spr1fea2.setSprint(pro1rel2spr1);
		// pro1rel2spr1fea2.close();

		pro1rel2spr1fea3 = new Feature(
				"Projekt 1, Release 2, Sprint 1, Feature 3",
				"Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel2spr1fea3.setLastEditor(pBjoern);
		pro1rel2spr1fea3.setManDayCosts(new Effort(5));
		pro1rel2spr1fea3.setSprint(pro1rel2spr1);
		pro1rel2spr1fea3.close();

		pro1rel2spr1fea4 = new Feature(
				"Projekt 1, Release 2, Sprint 1, Feature 4",
				"Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel2spr1fea4.setLastEditor(pBjoern);
		pro1rel2spr1fea4.setManDayCosts(new Effort(4));
		pro1rel2spr1fea4.setSprint(pro1rel2spr1);
		pro1rel2spr1fea4.close();

		pro1rel2spr1fea5 = new Feature(
				"Projekt 1, Release 2, Sprint 1, Feature 5",
				"Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel2spr1fea5.setLastEditor(pBjoern);
		pro1rel2spr1fea5.setManDayCosts(new Effort(3));
		pro1rel2spr1fea5.setSprint(pro1rel2spr1);
		pro1rel2spr1fea5.close();

		// für Projekt 1, Release 2, Sprint 2
		pro1rel2spr2fea1 = new Feature(
				"Projekt 1, Release 2, Sprint 2, Feature 1",
				"Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel2spr2fea1.setLastEditor(pBjoern);
		pro1rel2spr2fea1.setManDayCosts(new Effort(5));
		pro1rel2spr2fea1.setSprint(pro1rel2spr2);
		// pro1rel2spr2fea1.close();

		pro1rel2spr2fea2 = new Feature(
				"Projekt 1, Release 2, Sprint 2, Feature 2",
				"Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel2spr2fea2.setLastEditor(pBjoern);
		pro1rel2spr2fea2.setManDayCosts(new Effort(20));
		pro1rel2spr2fea2.setSprint(pro1rel2spr2);
		// pro1rel2spr2fea2.close();

		pro1rel2spr2fea3 = new Feature(
				"Projekt 1, Release 2, Sprint 2, Feature 3",
				"Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel2spr2fea3.setLastEditor(pBjoern);
		pro1rel2spr2fea3.setManDayCosts(new Effort(5));
		pro1rel2spr2fea3.setSprint(pro1rel2spr2);
		// pro1rel2spr2fea3.close();

		pro1rel2spr2fea4 = new Feature(
				"Projekt 1, Release 2, Sprint 2, Feature 4",
				"Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel2spr2fea4.setLastEditor(pBjoern);
		pro1rel2spr2fea4.setManDayCosts(new Effort(6));
		pro1rel2spr2fea4.setSprint(pro1rel2spr2);
		pro1rel2spr2fea4.close();

		pro1rel2spr2fea5 = new Feature(
				"Projekt 1, Release 2, Sprint 2, Feature 5",
				"Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel2spr2fea5.setLastEditor(pBjoern);
		pro1rel2spr2fea5.setManDayCosts(new Effort(35));
		pro1rel2spr2fea5.setSprint(pro1rel2spr2);
		pro1rel2spr2fea5.close();

		// für Projekt 1, Release 2, Sprint 3
		pro1rel2spr3fea1 = new Feature(
				"Projekt 1, Release 2, Sprint 3, Feature 1",
				"Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel2spr3fea1.setLastEditor(pBjoern);
		pro1rel2spr3fea1.setManDayCosts(new Effort(13));
		pro1rel2spr3fea1.setSprint(pro1rel2spr3);
		pro1rel2spr3fea1.close();

		pro1rel2spr3fea2 = new Feature(
				"Projekt 1, Release 2, Sprint 3, Feature 2",
				"Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel2spr3fea2.setLastEditor(pBjoern);
		pro1rel2spr3fea2.setManDayCosts(new Effort(7));
		pro1rel2spr3fea2.setSprint(pro1rel2spr3);
		pro1rel2spr3fea2.close();

		pro1rel2spr3fea3 = new Feature(
				"Projekt 1, Release 2, Sprint 3, Feature 3",
				"Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel2spr3fea3.setLastEditor(pBjoern);
		pro1rel2spr3fea3.setManDayCosts(new Effort(100));
		pro1rel2spr3fea3.setSprint(pro1rel2spr3);
		// pro1rel2spr3fea3.close();

		pro1rel2spr3fea4 = new Feature(
				"Projekt 1, Release 2, Sprint 3, Feature 4",
				"Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel2spr3fea4.setLastEditor(pBjoern);
		pro1rel2spr3fea4.setManDayCosts(new Effort(83));
		pro1rel2spr3fea4.setSprint(pro1rel2spr3);
		pro1rel2spr3fea4.close();

		pro1rel2spr3fea5 = new Feature(
				"Projekt 1, Release 2, Sprint 3, Feature 5",
				"Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel2spr3fea5.setLastEditor(pBjoern);
		pro1rel2spr3fea5.setManDayCosts(new Effort(3));
		pro1rel2spr3fea5.setSprint(pro1rel2spr3);
		// pro1rel2spr3fea5.close();

		// für Projekt 1, Release 2, Sprint 4
		pro1rel2spr4fea1 = new Feature(
				"Projekt 1, Release 2, Sprint 4, Feature 1",
				"Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel2spr4fea1.setLastEditor(pBjoern);
		pro1rel2spr4fea1.setManDayCosts(new Effort(20));
		pro1rel2spr4fea1.setSprint(pro1rel2spr4);
		pro1rel2spr4fea1.close();

		pro1rel2spr4fea2 = new Feature(
				"Projekt 1, Release 2, Sprint 4, Feature 2",
				"Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel2spr4fea2.setLastEditor(pBjoern);
		pro1rel2spr4fea2.setManDayCosts(new Effort(14));
		pro1rel2spr4fea2.setSprint(pro1rel2spr4);
		// pro1rel2spr4fea2.close();

		pro1rel2spr4fea3 = new Feature(
				"Projekt 1, Release 2, Sprint 4, Feature 3",
				"Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel2spr4fea3.setLastEditor(pBjoern);
		pro1rel2spr4fea3.setManDayCosts(new Effort(80));
		pro1rel2spr4fea3.setSprint(pro1rel2spr4);
		pro1rel2spr4fea3.close();

		pro1rel2spr4fea4 = new Feature(
				"Projekt 1, Release 2, Sprint 4, Feature 4",
				"Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel2spr4fea4.setLastEditor(pBjoern);
		pro1rel2spr4fea4.setManDayCosts(new Effort(12));
		pro1rel2spr4fea4.setSprint(pro1rel2spr4);
		// pro1rel2spr4fea4.close();

		pro1rel2spr4fea5 = new Feature(
				"Projekt 1, Release 2, Sprint 4, Feature 5",
				"Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel2spr4fea5.setLastEditor(pBjoern);
		pro1rel2spr4fea5.setManDayCosts(new Effort(16));
		pro1rel2spr4fea5.setSprint(pro1rel2spr4);
		pro1rel2spr4fea5.close();

		// für Projekt 1, Release 2, Sprint 5
		pro1rel2spr5fea1 = new Feature(
				"Projekt 1, Release 2, Sprint 5, Feature 1",
				"Beschreibung Feature 1", projekt1.getBacklog());
		pro1rel2spr5fea1.setLastEditor(pBjoern);
		pro1rel2spr5fea1.setManDayCosts(new Effort(13));
		pro1rel2spr5fea1.setSprint(pro1rel2spr5);
		// pro1rel2spr5fea1.close();

		pro1rel2spr5fea2 = new Feature(
				"Projekt 1, Release 2, Sprint 5, Feature 2",
				"Beschreibung Feature 2", projekt1.getBacklog());
		pro1rel2spr5fea2.setLastEditor(pBjoern);
		pro1rel2spr5fea2.setManDayCosts(new Effort(14));
		pro1rel2spr5fea2.setSprint(pro1rel2spr5);
		pro1rel2spr5fea2.close();

		pro1rel2spr5fea3 = new Feature(
				"Projekt 1, Release 2, Sprint 5, Feature 3",
				"Beschreibung Feature 3", projekt1.getBacklog());
		pro1rel2spr5fea3.setLastEditor(pBjoern);
		pro1rel2spr5fea3.setManDayCosts(new Effort(5));
		pro1rel2spr5fea3.setSprint(pro1rel2spr5);
		pro1rel2spr5fea3.close();

		pro1rel2spr5fea4 = new Feature(
				"Projekt 1, Release 2, Sprint 5, Feature 4",
				"Beschreibung Feature 4", projekt1.getBacklog());
		pro1rel2spr5fea4.setLastEditor(pBjoern);
		pro1rel2spr5fea4.setManDayCosts(new Effort(4));
		pro1rel2spr5fea4.setSprint(pro1rel2spr5);
		// pro1rel2spr5fea4.close();

		pro1rel2spr5fea5 = new Feature(
				"Projekt 1, Release 2, Sprint 5, Feature 5",
				"Beschreibung Feature 5", projekt1.getBacklog());
		pro1rel2spr5fea5.setLastEditor(pBjoern);
		pro1rel2spr5fea5.setManDayCosts(new Effort(3));
		pro1rel2spr5fea5.setSprint(pro1rel2spr5);
		pro1rel2spr5fea5.close();

		// für Projekt 2, Release 1, Sprint 1
		pro2rel1spr1fea1 = new Feature(
				"Projekt 2, Release 1, Sprint 1, Feature 1",
				"Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel1spr1fea1.setLastEditor(pBjoern);
		pro2rel1spr1fea1.setManDayCosts(new Effort(3));
		pro2rel1spr1fea1.setSprint(pro2rel1spr1);
		// pro2rel1spr1fea1.close();

		pro2rel1spr1fea2 = new Feature(
				"Projekt 2, Release 1, Sprint 1, Feature 2",
				"Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel1spr1fea2.setLastEditor(pBjoern);
		pro2rel1spr1fea2.setManDayCosts(new Effort(4));
		pro2rel1spr1fea2.setSprint(pro2rel1spr1);
		pro2rel1spr1fea2.close();

		pro2rel1spr1fea3 = new Feature(
				"Projekt 2, Release 1, Sprint 1, Feature 3",
				"Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel1spr1fea3.setLastEditor(pBjoern);
		pro2rel1spr1fea3.setManDayCosts(new Effort(5));
		pro2rel1spr1fea3.setSprint(pro2rel1spr1);
		pro2rel1spr1fea3.close();

		pro2rel1spr1fea4 = new Feature(
				"Projekt 2, Release 1, Sprint 1, Feature 4",
				"Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel1spr1fea4.setLastEditor(pBjoern);
		pro2rel1spr1fea4.setManDayCosts(new Effort(4));
		pro2rel1spr1fea4.setSprint(pro2rel1spr1);
		pro2rel1spr1fea4.close();

		pro2rel1spr1fea5 = new Feature(
				"Projekt 2, Release 1, Sprint 1, Feature 5",
				"Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel1spr1fea5.setLastEditor(pBjoern);
		pro2rel1spr1fea5.setManDayCosts(new Effort(3));
		pro2rel1spr1fea5.setSprint(pro2rel1spr1);
		pro2rel1spr1fea5.close();

		// für Projekt 2, Release 1, Sprint 2
		pro2rel1spr2fea1 = new Feature(
				"Projekt 2, Release 1, Sprint 2, Feature 1",
				"Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel1spr2fea1.setLastEditor(pBjoern);
		pro2rel1spr2fea1.setManDayCosts(new Effort(3));
		pro2rel1spr2fea1.setSprint(pro2rel1spr2);
		// pro2rel1spr2fea1.close();

		pro2rel1spr2fea2 = new Feature(
				"Projekt 2, Release 1, Sprint 2, Feature 2",
				"Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel1spr2fea2.setLastEditor(pBjoern);
		pro2rel1spr2fea2.setManDayCosts(new Effort(4));
		pro2rel1spr2fea2.setSprint(pro2rel1spr2);
		// pro2rel1spr2fea2.close();

		pro2rel1spr2fea3 = new Feature(
				"Projekt 2, Release 1, Sprint 2, Feature 3",
				"Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel1spr2fea3.setLastEditor(pBjoern);
		pro2rel1spr2fea3.setManDayCosts(new Effort(5));
		pro2rel1spr2fea3.setSprint(pro2rel1spr2);
		pro2rel1spr2fea3.close();

		pro2rel1spr2fea4 = new Feature(
				"Projekt 2, Release 1, Sprint 2, Feature 4",
				"Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel1spr2fea4.setLastEditor(pBjoern);
		pro2rel1spr2fea4.setManDayCosts(new Effort(4));
		pro2rel1spr2fea4.setSprint(pro2rel1spr2);
		pro2rel1spr2fea4.close();

		pro2rel1spr2fea5 = new Feature(
				"Projekt 2, Release 1, Sprint 2, Feature 5",
				"Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel1spr2fea5.setLastEditor(pBjoern);
		pro2rel1spr2fea5.setManDayCosts(new Effort(3));
		pro2rel1spr2fea5.setSprint(pro2rel1spr2);
		pro2rel1spr2fea5.close();

		// für Projekt 2, Release 1, Sprint 3
		pro2rel1spr3fea1 = new Feature(
				"Projekt 2, Release 1, Sprint 3, Feature 1",
				"Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel1spr3fea1.setLastEditor(pBjoern);
		pro2rel1spr3fea1.setManDayCosts(new Effort(3));
		pro2rel1spr3fea1.setSprint(pro2rel1spr3);
		// pro2rel1spr3fea1.close();

		pro2rel1spr3fea2 = new Feature(
				"Projekt 2, Release 1, Sprint 3, Feature 2",
				"Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel1spr3fea2.setLastEditor(pBjoern);
		pro2rel1spr3fea2.setManDayCosts(new Effort(4));
		pro2rel1spr3fea2.setSprint(pro2rel1spr3);
		// pro2rel1spr3fea2.close();

		pro2rel1spr3fea3 = new Feature(
				"Projekt 2, Release 1, Sprint 3, Feature 3",
				"Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel1spr3fea3.setLastEditor(pBjoern);
		pro2rel1spr3fea3.setManDayCosts(new Effort(5));
		pro2rel1spr3fea3.setSprint(pro2rel1spr3);
		// pro2rel1spr3fea3.close();

		pro2rel1spr3fea4 = new Feature(
				"Projekt 2, Release 1, Sprint 3, Feature 4",
				"Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel1spr3fea4.setLastEditor(pBjoern);
		pro2rel1spr3fea4.setManDayCosts(new Effort(4));
		pro2rel1spr3fea4.setSprint(pro2rel1spr3);
		pro2rel1spr3fea4.close();

		pro2rel1spr3fea5 = new Feature(
				"Projekt 2, Release 1, Sprint 3, Feature 5",
				"Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel1spr3fea5.setLastEditor(pBjoern);
		pro2rel1spr3fea5.setManDayCosts(new Effort(3));
		pro2rel1spr3fea5.setSprint(pro2rel1spr3);
		pro2rel1spr3fea5.close();

		// für Projekt 2, Release 1, Sprint 4
		pro2rel1spr4fea1 = new Feature(
				"Projekt 2, Release 1, Sprint 4, Feature 1",
				"Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel1spr4fea1.setLastEditor(pBjoern);
		pro2rel1spr4fea1.setManDayCosts(new Effort(3));
		pro2rel1spr4fea1.setSprint(pro2rel1spr4);
		// pro2rel1spr4fea1.close();

		pro2rel1spr4fea2 = new Feature(
				"Projekt 2, Release 1, Sprint 4, Feature 2",
				"Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel1spr4fea2.setLastEditor(pBjoern);
		pro2rel1spr4fea2.setManDayCosts(new Effort(4));
		pro2rel1spr4fea2.setSprint(pro2rel1spr4);
		// pro2rel1spr4fea2.close();

		pro2rel1spr4fea3 = new Feature(
				"Projekt 2, Release 1, Sprint 4, Feature 3",
				"Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel1spr4fea3.setLastEditor(pBjoern);
		pro2rel1spr4fea3.setManDayCosts(new Effort(5));
		pro2rel1spr4fea3.setSprint(pro2rel1spr4);
		// pro2rel1spr4fea3.close();

		pro2rel1spr4fea4 = new Feature(
				"Projekt 2, Release 1, Sprint 4, Feature 4",
				"Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel1spr4fea4.setLastEditor(pBjoern);
		pro2rel1spr4fea4.setManDayCosts(new Effort(4));
		pro2rel1spr4fea4.setSprint(pro2rel1spr4);
		// pro2rel1spr4fea4.close();

		pro2rel1spr4fea5 = new Feature(
				"Projekt 2, Release 1, Sprint 4, Feature 5",
				"Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel1spr4fea5.setLastEditor(pBjoern);
		pro2rel1spr4fea5.setManDayCosts(new Effort(3));
		pro2rel1spr4fea5.setSprint(pro2rel1spr4);
		pro2rel1spr4fea5.close();

		// für Projekt 2, Release 1, Sprint 5
		pro2rel1spr5fea1 = new Feature(
				"Projekt 2, Release 1, Sprint 5, Feature 1",
				"Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel1spr5fea1.setLastEditor(pBjoern);
		pro2rel1spr5fea1.setManDayCosts(new Effort(3));
		pro2rel1spr5fea1.setSprint(pro2rel1spr5);
		// pro2rel1spr5fea1.close();

		pro2rel1spr5fea2 = new Feature(
				"Projekt 2, Release 1, Sprint 5, Feature 2",
				"Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel1spr5fea2.setLastEditor(pBjoern);
		pro2rel1spr5fea2.setManDayCosts(new Effort(4));
		pro2rel1spr5fea2.setSprint(pro2rel1spr5);
		// pro2rel1spr5fea2.close();

		pro2rel1spr5fea3 = new Feature(
				"Projekt 2, Release 1, Sprint 5, Feature 3",
				"Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel1spr5fea3.setLastEditor(pBjoern);
		pro2rel1spr5fea3.setManDayCosts(new Effort(5));
		pro2rel1spr5fea3.setSprint(pro2rel1spr5);
		// pro2rel1spr5fea3.close();

		pro2rel1spr5fea4 = new Feature(
				"Projekt 2, Release 1, Sprint 5, Feature 4",
				"Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel1spr5fea4.setLastEditor(pBjoern);
		pro2rel1spr5fea4.setManDayCosts(new Effort(4));
		pro2rel1spr5fea4.setSprint(pro2rel1spr5);
		// pro2rel1spr5fea4.close();

		pro2rel1spr5fea5 = new Feature(
				"Projekt 2, Release 1, Sprint 5, Feature 5",
				"Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel1spr5fea5.setLastEditor(pBjoern);
		pro2rel1spr5fea5.setManDayCosts(new Effort(3));
		pro2rel1spr5fea5.setSprint(pro2rel1spr5);
		// pro2rel1spr5fea5.close();

		// für Projekt 2, Release 2, Sprint 1
		pro2rel2spr1fea1 = new Feature(
				"Projekt 2, Release 2, Sprint 1, Feature 1",
				"Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel2spr1fea1.setLastEditor(pBjoern);
		pro2rel2spr1fea1.setManDayCosts(new Effort(20));
		pro2rel2spr1fea1.setSprint(pro2rel2spr1);
		pro2rel2spr1fea1.close();

		pro2rel2spr1fea2 = new Feature(
				"Projekt 2, Release 2, Sprint 1, Feature 2",
				"Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel2spr1fea2.setLastEditor(pBjoern);
		pro2rel2spr1fea2.setManDayCosts(new Effort(41));
		pro2rel2spr1fea2.setSprint(pro2rel2spr1);
		// pro2rel2spr1fea2.close();

		pro2rel2spr1fea3 = new Feature(
				"Projekt 2, Release 2, Sprint 1, Feature 3",
				"Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel2spr1fea3.setLastEditor(pBjoern);
		pro2rel2spr1fea3.setManDayCosts(new Effort(57));
		pro2rel2spr1fea3.setSprint(pro2rel2spr1);
		// pro2rel2spr1fea3.close();

		pro2rel2spr1fea4 = new Feature(
				"Projekt 2, Release 2, Sprint 1, Feature 4",
				"Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel2spr1fea4.setLastEditor(pBjoern);
		pro2rel2spr1fea4.setManDayCosts(new Effort(48));
		pro2rel2spr1fea4.setSprint(pro2rel2spr1);
		pro2rel2spr1fea4.close();

		pro2rel2spr1fea5 = new Feature(
				"Projekt 2, Release 2, Sprint 1, Feature 5",
				"Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel2spr1fea5.setLastEditor(pBjoern);
		pro2rel2spr1fea5.setManDayCosts(new Effort(3));
		pro2rel2spr1fea5.setSprint(pro2rel2spr1);
		pro2rel2spr1fea5.close();

		// für Projekt 2, Release 2, Sprint 2
		pro2rel2spr2fea1 = new Feature(
				"Projekt 2, Release 2, Sprint 2, Feature 1",
				"Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel2spr2fea1.setLastEditor(pBjoern);
		pro2rel2spr2fea1.setManDayCosts(new Effort(3));
		pro2rel2spr2fea1.setSprint(pro2rel2spr2);
		// pro2rel2spr2fea1.close();

		pro2rel2spr2fea2 = new Feature(
				"Projekt 2, Release 2, Sprint 2, Feature 2",
				"Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel2spr2fea2.setLastEditor(pBjoern);
		pro2rel2spr2fea2.setManDayCosts(new Effort(18));
		pro2rel2spr2fea2.setSprint(pro2rel2spr2);
		pro2rel2spr2fea2.close();

		pro2rel2spr2fea3 = new Feature(
				"Projekt 2, Release 2, Sprint 2, Feature 3",
				"Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel2spr2fea3.setLastEditor(pBjoern);
		pro2rel2spr2fea3.setManDayCosts(new Effort(5));
		pro2rel2spr2fea3.setSprint(pro2rel2spr2);
		pro2rel2spr2fea3.close();

		pro2rel2spr2fea4 = new Feature(
				"Projekt 2, Release 2, Sprint 2, Feature 4",
				"Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel2spr2fea4.setLastEditor(pBjoern);
		pro2rel2spr2fea4.setManDayCosts(new Effort(13));
		pro2rel2spr2fea4.setSprint(pro2rel2spr2);
		// pro2rel2spr2fea4.close();

		pro2rel2spr2fea5 = new Feature(
				"Projekt 2, Release 2, Sprint 2, Feature 5",
				"Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel2spr2fea5.setLastEditor(pBjoern);
		pro2rel2spr2fea5.setManDayCosts(new Effort(8));
		pro2rel2spr2fea5.setSprint(pro2rel2spr2);
		pro2rel2spr2fea5.close();

		// für Projekt 2, Release 2, Sprint 3
		pro2rel2spr3fea1 = new Feature(
				"Projekt 2, Release 2, Sprint 3, Feature 1",
				"Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel2spr3fea1.setLastEditor(pBjoern);
		pro2rel2spr3fea1.setManDayCosts(new Effort(18));
		pro2rel2spr3fea1.setSprint(pro2rel2spr3);
		pro2rel2spr3fea1.close();

		pro2rel2spr3fea2 = new Feature(
				"Projekt 2, Release 2, Sprint 3, Feature 2",
				"Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel2spr3fea2.setLastEditor(pBjoern);
		pro2rel2spr3fea2.setManDayCosts(new Effort(19));
		pro2rel2spr3fea2.setSprint(pro2rel2spr3);
		pro2rel2spr3fea2.close();

		pro2rel2spr3fea3 = new Feature(
				"Projekt 2, Release 2, Sprint 3, Feature 3",
				"Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel2spr3fea3.setLastEditor(pBjoern);
		pro2rel2spr3fea3.setManDayCosts(new Effort(15));
		pro2rel2spr3fea3.setSprint(pro2rel2spr3);
		// pro2rel2spr3fea3.close();

		pro2rel2spr3fea4 = new Feature(
				"Projekt 2, Release 2, Sprint 3, Feature 4",
				"Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel2spr3fea4.setLastEditor(pBjoern);
		pro2rel2spr3fea4.setManDayCosts(new Effort(2));
		pro2rel2spr3fea4.setSprint(pro2rel2spr3);
		// pro2rel2spr3fea4.close();

		pro2rel2spr3fea5 = new Feature(
				"Projekt 2, Release 2, Sprint 3, Feature 5",
				"Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel2spr3fea5.setLastEditor(pBjoern);
		pro2rel2spr3fea5.setManDayCosts(new Effort(6));
		pro2rel2spr3fea5.setSprint(pro2rel2spr3);
		pro2rel2spr3fea5.close();

		// für Projekt 2, Release 2, Sprint 4
		pro2rel2spr4fea1 = new Feature(
				"Projekt 2, Release 2, Sprint 4, Feature 1",
				"Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel2spr4fea1.setLastEditor(pBjoern);
		pro2rel2spr4fea1.setManDayCosts(new Effort(13));
		pro2rel2spr4fea1.setSprint(pro2rel2spr4);
		pro2rel2spr4fea1.close();

		pro2rel2spr4fea2 = new Feature(
				"Projekt 2, Release 2, Sprint 4, Feature 2",
				"Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel2spr4fea2.setLastEditor(pBjoern);
		pro2rel2spr4fea2.setManDayCosts(new Effort(15));
		pro2rel2spr4fea2.setSprint(pro2rel2spr4);
		// pro2rel2spr4fea2.close();

		pro2rel2spr4fea3 = new Feature(
				"Projekt 2, Release 2, Sprint 4, Feature 3",
				"Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel2spr4fea3.setLastEditor(pBjoern);
		pro2rel2spr4fea3.setManDayCosts(new Effort(7));
		pro2rel2spr4fea3.setSprint(pro2rel2spr4);
		pro2rel2spr4fea3.close();

		pro2rel2spr4fea4 = new Feature(
				"Projekt 2, Release 2, Sprint 4, Feature 4",
				"Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel2spr4fea4.setLastEditor(pBjoern);
		pro2rel2spr4fea4.setManDayCosts(new Effort(4));
		pro2rel2spr4fea4.setSprint(pro2rel2spr4);
		pro2rel2spr4fea4.close();

		pro2rel2spr4fea5 = new Feature(
				"Projekt 2, Release 2, Sprint 4, Feature 5",
				"Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel2spr4fea5.setLastEditor(pBjoern);
		pro2rel2spr4fea5.setManDayCosts(new Effort(6));
		pro2rel2spr4fea5.setSprint(pro2rel2spr4);
		// pro2rel2spr4fea5.close();

		// für Projekt 2, Release 2, Sprint 5
		pro2rel2spr5fea1 = new Feature(
				"Projekt 2, Release 2, Sprint 5, Feature 1",
				"Beschreibung Feature 1", projekt2.getBacklog());
		pro2rel2spr5fea1.setLastEditor(pBjoern);
		pro2rel2spr5fea1.setManDayCosts(new Effort(7));
		pro2rel2spr5fea1.setSprint(pro2rel2spr5);
		pro2rel2spr5fea1.close();

		pro2rel2spr5fea2 = new Feature(
				"Projekt 2, Release 2, Sprint 5, Feature 2",
				"Beschreibung Feature 2", projekt2.getBacklog());
		pro2rel2spr5fea2.setLastEditor(pBjoern);
		pro2rel2spr5fea2.setManDayCosts(new Effort(8));
		pro2rel2spr5fea2.setSprint(pro2rel2spr5);
		// pro2rel2spr5fea2.close();

		pro2rel2spr5fea3 = new Feature(
				"Projekt 2, Release 2, Sprint 5, Feature 3",
				"Beschreibung Feature 3", projekt2.getBacklog());
		pro2rel2spr5fea3.setLastEditor(pBjoern);
		pro2rel2spr5fea3.setManDayCosts(new Effort(5));
		pro2rel2spr5fea3.setSprint(pro2rel2spr5);
		// pro2rel2spr5fea3.close();

		pro2rel2spr5fea4 = new Feature(
				"Projekt 2, Release 2, Sprint 5, Feature 4",
				"Beschreibung Feature 4", projekt2.getBacklog());
		pro2rel2spr5fea4.setLastEditor(pBjoern);
		pro2rel2spr5fea4.setManDayCosts(new Effort(2));
		pro2rel2spr5fea4.setSprint(pro2rel2spr5);
		pro2rel2spr5fea4.close();

		pro2rel2spr5fea5 = new Feature(
				"Projekt 2, Release 2, Sprint 5, Feature 5",
				"Beschreibung Feature 5", projekt2.getBacklog());
		pro2rel2spr5fea5.setLastEditor(pBjoern);
		pro2rel2spr5fea5.setManDayCosts(new Effort(3));
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
		pro1rel1spr1tas1 = new Task("Projekt 1, Release 1, Sprint 1, Task 1",
				"Beschreibung von Task 1");
		pro1rel1spr1.getSprintBacklog().addTask(pro1rel1spr1tas1);
		pro1rel1spr1tas1.addPBI(pro1rel1spr1fea1);
		pro1rel1spr1tas1.setPlanEffort(new Effort(1));
		pro1rel1spr1tas1.setResponsibility(pBjoern);
		pro1rel1spr1tas1.finish(new Date(2011 - 1900, 2 - 1, 3));

		pro1rel1spr1tas2 = new Task("Projekt 1, Release 1, Sprint 1, Task 2",
				"Beschreibung von Task 2");
		pro1rel1spr1.getSprintBacklog().addTask(pro1rel1spr1tas2);
		pro1rel1spr1tas2.addPBI(pro1rel1spr1fea2);
		pro1rel1spr1tas2.setPlanEffort(new Effort(2));
		pro1rel1spr1tas2.setResponsibility(pBjoern);
		pro1rel1spr1tas2.finish(new Date(2011 - 1900, 2 - 1, 3));

		pro1rel1spr1tas3 = new Task("Projekt 1, Release 1, Sprint 1, Task 3",
				"Beschreibung von Task 3");
		pro1rel1spr1.getSprintBacklog().addTask(pro1rel1spr1tas3);
		pro1rel1spr1tas3.addPBI(pro1rel1spr1fea3);
		pro1rel1spr1tas3.setPlanEffort(new Effort(3));
		pro1rel1spr1tas3.setResponsibility(pBjoern);
		pro1rel1spr1tas3.finish(new Date(2011 - 1900, 2 - 1, 1));

		pro1rel1spr1tas4 = new Task("Projekt 1, Release 1, Sprint 1, Task 4",
				"Beschreibung von Task 4");
		pro1rel1spr1.getSprintBacklog().addTask(pro1rel1spr1tas4);
		pro1rel1spr1tas4.addPBI(pro1rel1spr1fea4);
		pro1rel1spr1tas4.setPlanEffort(new Effort(4));
		pro1rel1spr1tas4.setResponsibility(pBjoern);
		pro1rel1spr1tas4.finish(new Date(2011 - 1900, 2 - 1, 2));

		pro1rel1spr1tas5 = new Task("Projekt 1, Release 1, Sprint 1, Task 5",
				"Beschreibung von Task 5");
		pro1rel1spr1.getSprintBacklog().addTask(pro1rel1spr1tas5);
		pro1rel1spr1tas5.addPBI(pro1rel1spr1fea5);
		pro1rel1spr1tas5.setPlanEffort(new Effort(5));
		pro1rel1spr1tas5.setResponsibility(pBjoern);
		pro1rel1spr1tas5.finish(new Date(2011 - 1900, 2 - 1, 4));

		// für Projekt 1, Release 1, Sprint 2
		pro1rel1spr2tas1 = new Task("Projekt 1, Release 1, Sprint 2, Task 1",
				"Beschreibung von Task 1");
		pro1rel1spr2.getSprintBacklog().addTask(pro1rel1spr2tas1);
		pro1rel1spr2tas1.addPBI(pro1rel1spr2fea1);
		pro1rel1spr2tas1.setPlanEffort(new Effort(6));
		pro1rel1spr2tas1.setResponsibility(pBjoern);
		pro1rel1spr2tas1.finish(new Date(2011 - 1900, 3 - 1, 13));

		pro1rel1spr2tas2 = new Task("Projekt 1, Release 1, Sprint 2, Task 2",
				"Beschreibung von Task 2");
		pro1rel1spr2.getSprintBacklog().addTask(pro1rel1spr2tas2);
		pro1rel1spr2tas2.addPBI(pro1rel1spr2fea2);
		pro1rel1spr2tas2.setPlanEffort(new Effort(7));
		pro1rel1spr2tas2.setResponsibility(pBjoern);
		pro1rel1spr2tas2.finish(new Date(2011 - 1900, 3 - 1, 14));

		pro1rel1spr2tas3 = new Task("Projekt 1, Release 1, Sprint 2, Task 3",
				"Beschreibung von Task 3");
		pro1rel1spr2.getSprintBacklog().addTask(pro1rel1spr2tas3);
		pro1rel1spr2tas3.addPBI(pro1rel1spr2fea3);
		pro1rel1spr2tas3.setPlanEffort(new Effort(8));
		pro1rel1spr2tas3.setResponsibility(pBjoern);
		pro1rel1spr2tas3.finish(new Date(2011 - 1900, 3 - 1, 14));

		pro1rel1spr2tas4 = new Task("Projekt 1, Release 1, Sprint 2, Task 4",
				"Beschreibung von Task 4");
		pro1rel1spr2.getSprintBacklog().addTask(pro1rel1spr2tas4);
		pro1rel1spr2tas4.addPBI(pro1rel1spr2fea4);
		pro1rel1spr2tas4.setPlanEffort(new Effort(1));
		pro1rel1spr2tas4.setResponsibility(pBjoern);
		pro1rel1spr2tas4.finish(new Date(2011 - 1900, 3 - 1, 13));

		pro1rel1spr2tas5 = new Task("Projekt 1, Release 1, Sprint 2, Task 5",
				"Beschreibung von Task 5");
		pro1rel1spr2.getSprintBacklog().addTask(pro1rel1spr2tas5);
		pro1rel1spr2tas5.addPBI(pro1rel1spr2fea5);
		pro1rel1spr2tas5.setPlanEffort(new Effort(2));
		pro1rel1spr2tas5.setResponsibility(pBjoern);
		pro1rel1spr2tas5.finish(new Date(2011 - 1900, 3 - 1, 12));

		// für Projekt 1, Release 1, Sprint 3
		pro1rel1spr3tas1 = new Task("Projekt 1, Release 1, Sprint 3, Task 1",
				"Beschreibung von Task 1");
		pro1rel1spr3.getSprintBacklog().addTask(pro1rel1spr3tas1);
		pro1rel1spr3tas1.addPBI(pro1rel1spr3fea1);
		pro1rel1spr3tas1.setPlanEffort(new Effort(7));
		pro1rel1spr3tas1.setResponsibility(pBjoern);
		pro1rel1spr3tas1.finish(new Date(2011 - 1900, 1 - 1, 4));

		pro1rel1spr3tas2 = new Task("Projekt 1, Release 1, Sprint 3, Task 2",
				"Beschreibung von Task 2");
		pro1rel1spr3.getSprintBacklog().addTask(pro1rel1spr3tas2);
		pro1rel1spr3tas2.addPBI(pro1rel1spr3fea2);
		pro1rel1spr3tas2.setPlanEffort(new Effort(7));
		pro1rel1spr3tas2.setResponsibility(pBjoern);
		pro1rel1spr3tas2.finish(new Date(2011 - 1900, 1 - 1, 4));

		pro1rel1spr3tas3 = new Task("Projekt 1, Release 1, Sprint 3, Task 3",
				"Beschreibung von Task 3");
		pro1rel1spr3.getSprintBacklog().addTask(pro1rel1spr3tas3);
		pro1rel1spr3tas3.addPBI(pro1rel1spr3fea3);
		pro1rel1spr3tas3.setPlanEffort(new Effort(7));
		pro1rel1spr3tas3.setResponsibility(pBjoern);
		pro1rel1spr3tas3.finish(new Date(2011 - 1900, 1 - 1, 3));

		pro1rel1spr3tas4 = new Task("Projekt 1, Release 1, Sprint 3, Task 4",
				"Beschreibung von Task 4");
		pro1rel1spr3.getSprintBacklog().addTask(pro1rel1spr3tas4);
		pro1rel1spr3tas4.addPBI(pro1rel1spr3fea4);
		pro1rel1spr3tas4.setPlanEffort(new Effort(7));
		pro1rel1spr3tas4.setResponsibility(pBjoern);
		pro1rel1spr3tas4.finish(new Date(2011 - 1900, 1 - 1, 3));

		pro1rel1spr3tas5 = new Task("Projekt 1, Release 1, Sprint 3, Task 5",
				"Beschreibung von Task 5");
		pro1rel1spr3.getSprintBacklog().addTask(pro1rel1spr3tas5);
		pro1rel1spr3tas5.addPBI(pro1rel1spr3fea5);
		pro1rel1spr3tas5.setPlanEffort(new Effort(7));
		pro1rel1spr3tas5.setResponsibility(pBjoern);
		pro1rel1spr3tas5.finish(new Date(2011 - 1900, 1 - 1, 4));

		// für Projekt 1, Release 1, Sprint 4
		pro1rel1spr4tas1 = new Task("Projekt 1, Release 1, Sprint 4, Task 1",
				"Beschreibung von Task 1");
		pro1rel1spr4.getSprintBacklog().addTask(pro1rel1spr4tas1);
		pro1rel1spr4tas1.addPBI(pro1rel1spr4fea1);
		pro1rel1spr4tas1.setPlanEffort(new Effort(2));
		pro1rel1spr4tas1.setResponsibility(pBjoern);
		pro1rel1spr4tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr4tas2 = new Task("Projekt 1, Release 1, Sprint 4, Task 2",
				"Beschreibung von Task 2");
		pro1rel1spr4.getSprintBacklog().addTask(pro1rel1spr4tas2);
		pro1rel1spr4tas2.addPBI(pro1rel1spr4fea2);
		pro1rel1spr4tas2.setPlanEffort(new Effort(2));
		pro1rel1spr4tas2.setResponsibility(pBjoern);
		pro1rel1spr4tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr4tas3 = new Task("Projekt 1, Release 1, Sprint 4, Task 3",
				"Beschreibung von Task 3");
		pro1rel1spr4.getSprintBacklog().addTask(pro1rel1spr4tas3);
		pro1rel1spr4tas3.addPBI(pro1rel1spr4fea3);
		pro1rel1spr4tas3.setPlanEffort(new Effort(2));
		pro1rel1spr4tas3.setResponsibility(pBjoern);
		pro1rel1spr4tas3.finish(new Date(2011 - 1900, 2 - 1, 28));

		pro1rel1spr4tas4 = new Task("Projekt 1, Release 1, Sprint 4, Task 4",
				"Beschreibung von Task 4");
		pro1rel1spr4.getSprintBacklog().addTask(pro1rel1spr4tas4);
		pro1rel1spr4tas4.addPBI(pro1rel1spr4fea4);
		pro1rel1spr4tas4.setPlanEffort(new Effort(3));
		pro1rel1spr4tas4.setResponsibility(pBjoern);
		pro1rel1spr4tas4.finish(new Date(2011 - 1900, 2 - 1, 28));

		pro1rel1spr4tas5 = new Task("Projekt 1, Release 1, Sprint 4, Task 5",
				"Beschreibung von Task 5");
		pro1rel1spr4.getSprintBacklog().addTask(pro1rel1spr4tas5);
		pro1rel1spr4tas5.addPBI(pro1rel1spr4fea5);
		pro1rel1spr4tas5.setPlanEffort(new Effort(8));
		pro1rel1spr4tas5.setResponsibility(pBjoern);
		pro1rel1spr4tas5.finish(new Date(2011 - 1900, 3 - 1, 2));

		// für Projekt 1, Release 1, Sprint 5
		pro1rel1spr5tas1 = new Task("Projekt 1, Release 1, Sprint 5, Task 1",
				"Beschreibung von Task 1");
		pro1rel1spr5.getSprintBacklog().addTask(pro1rel1spr5tas1);
		pro1rel1spr5tas1.addPBI(pro1rel1spr5fea1);
		pro1rel1spr5tas1.setPlanEffort(new Effort(5));
		pro1rel1spr5tas1.setResponsibility(pBjoern);
		pro1rel1spr5tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel1spr5tas2 = new Task("Projekt 1, Release 1, Sprint 5, Task 2",
				"Beschreibung von Task 2");
		pro1rel1spr5.getSprintBacklog().addTask(pro1rel1spr5tas2);
		pro1rel1spr5tas2.addPBI(pro1rel1spr5fea2);
		pro1rel1spr5tas2.setPlanEffort(new Effort(3));
		pro1rel1spr5tas2.setResponsibility(pBjoern);
		pro1rel1spr5tas2.finish(new Date(2011 - 1900, 3 - 1, 2));

		pro1rel1spr5tas3 = new Task("Projekt 1, Release 1, Sprint 5, Task 3",
				"Beschreibung von Task 3");
		pro1rel1spr5.getSprintBacklog().addTask(pro1rel1spr5tas3);
		pro1rel1spr5tas3.addPBI(pro1rel1spr5fea3);
		pro1rel1spr5tas3.setPlanEffort(new Effort(4));
		pro1rel1spr5tas3.setResponsibility(pBjoern);
		pro1rel1spr5tas3.finish(new Date(2011 - 1900, 3 - 1, 3));

		pro1rel1spr5tas4 = new Task("Projekt 1, Release 1, Sprint 5, Task 4",
				"Beschreibung von Task 4");
		pro1rel1spr5.getSprintBacklog().addTask(pro1rel1spr5tas4);
		pro1rel1spr5tas4.addPBI(pro1rel1spr5fea4);
		pro1rel1spr5tas4.setPlanEffort(new Effort(7));
		pro1rel1spr5tas4.setResponsibility(pBjoern);
		pro1rel1spr5tas4.finish(new Date(2011 - 1900, 3 - 1, 4));

		pro1rel1spr5tas5 = new Task("Projekt 1, Release 1, Sprint 5, Task 5",
				"Beschreibung von Task 5");
		pro1rel1spr5.getSprintBacklog().addTask(pro1rel1spr5tas5);
		pro1rel1spr5tas5.addPBI(pro1rel1spr5fea5);
		pro1rel1spr5tas5.setPlanEffort(new Effort(2));
		pro1rel1spr5tas5.setResponsibility(pBjoern);
		pro1rel1spr5tas5.finish(new Date(2011 - 1900, 3 - 1, 10));

		// für Projekt 1, Release 2, Sprint 1
		pro1rel2spr1tas1 = new Task("Projekt 1, Release 2, Sprint 1, Task 1",
				"Beschreibung von Task 1");
		pro1rel2spr1.getSprintBacklog().addTask(pro1rel2spr1tas1);
		pro1rel2spr1tas1.addPBI(pro1rel2spr1fea1);
		pro1rel2spr1tas1.setPlanEffort(new Effort(8));
		pro1rel2spr1tas1.setResponsibility(pBjoern);
		// pro1rel2spr1tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr1tas2 = new Task("Projekt 1, Release 2, Sprint 1, Task 2",
				"Beschreibung von Task 2");
		pro1rel2spr1.getSprintBacklog().addTask(pro1rel2spr1tas2);
		pro1rel2spr1tas2.addPBI(pro1rel2spr1fea2);
		pro1rel2spr1tas2.setPlanEffort(new Effort(6));
		pro1rel2spr1tas2.setResponsibility(pBjoern);
		// pro1rel2spr1tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr1tas3 = new Task("Projekt 1, Release 2, Sprint 1, Task 3",
				"Beschreibung von Task 3");
		pro1rel2spr1.getSprintBacklog().addTask(pro1rel2spr1tas3);
		pro1rel2spr1tas3.addPBI(pro1rel2spr1fea3);
		pro1rel2spr1tas3.setPlanEffort(new Effort(4));
		pro1rel2spr1tas3.setResponsibility(pBjoern);
		// pro1rel2spr1tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr1tas4 = new Task("Projekt 1, Release 2, Sprint 1, Task 4",
				"Beschreibung von Task 4");
		pro1rel2spr1.getSprintBacklog().addTask(pro1rel2spr1tas4);
		pro1rel2spr1tas4.addPBI(pro1rel2spr1fea4);
		pro1rel2spr1tas4.setPlanEffort(new Effort(6));
		pro1rel2spr1tas4.setResponsibility(pBjoern);
		// pro1rel2spr1tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr1tas5 = new Task("Projekt 1, Release 2, Sprint 1, Task 5",
				"Beschreibung von Task 5");
		pro1rel2spr1.getSprintBacklog().addTask(pro1rel2spr1tas5);
		pro1rel2spr1tas5.addPBI(pro1rel2spr1fea5);
		pro1rel2spr1tas5.setPlanEffort(new Effort(8));
		pro1rel2spr1tas5.setResponsibility(pBjoern);
		pro1rel2spr1tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 1, Release 2, Sprint 2
		pro1rel2spr2tas1 = new Task("Projekt 1, Release 2, Sprint 2, Task 1",
				"Beschreibung von Task 1");
		pro1rel2spr2.getSprintBacklog().addTask(pro1rel2spr2tas1);
		pro1rel2spr2tas1.addPBI(pro1rel2spr2fea1);
		pro1rel2spr2tas1.setPlanEffort(new Effort(7));
		pro1rel2spr2tas1.setResponsibility(pBjoern);
		// pro1rel2spr2tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr2tas2 = new Task("Projekt 1, Release 2, Sprint 2, Task 2",
				"Beschreibung von Task 2");
		pro1rel2spr2.getSprintBacklog().addTask(pro1rel2spr2tas2);
		pro1rel2spr2tas2.addPBI(pro1rel2spr2fea2);
		pro1rel2spr2tas2.setPlanEffort(new Effort(8));
		pro1rel2spr2tas2.setResponsibility(pBjoern);
		// pro1rel2spr2tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr2tas3 = new Task("Projekt 1, Release 2, Sprint 2, Task 3",
				"Beschreibung von Task 3");
		pro1rel2spr2.getSprintBacklog().addTask(pro1rel2spr2tas3);
		pro1rel2spr2tas3.addPBI(pro1rel2spr2fea3);
		pro1rel2spr2tas3.setPlanEffort(new Effort(2));
		pro1rel2spr2tas3.setResponsibility(pBjoern);
		// pro1rel2spr2tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr2tas4 = new Task("Projekt 1, Release 2, Sprint 2, Task 4",
				"Beschreibung von Task 4");
		pro1rel2spr2.getSprintBacklog().addTask(pro1rel2spr2tas4);
		pro1rel2spr2tas4.addPBI(pro1rel2spr2fea4);
		pro1rel2spr2tas4.setPlanEffort(new Effort(3));
		pro1rel2spr2tas4.setResponsibility(pBjoern);
		pro1rel2spr2tas4.finish(new Date(2011 - 1900, 3 - 1, 5));

		pro1rel2spr2tas5 = new Task("Projekt 1, Release 2, Sprint 2, Task 5",
				"Beschreibung von Task 5");
		pro1rel2spr2.getSprintBacklog().addTask(pro1rel2spr2tas5);
		pro1rel2spr2tas5.addPBI(pro1rel2spr2fea5);
		pro1rel2spr2tas5.setPlanEffort(new Effort(3));
		pro1rel2spr2tas5.setResponsibility(pBjoern);
		pro1rel2spr2tas5.finish(new Date(2011 - 1900, 2 - 1, 1));

		// für Projekt 1, Release 2, Sprint 3
		pro1rel2spr3tas1 = new Task("Projekt 1, Release 2, Sprint 3, Task 1",
				"Beschreibung von Task 1");
		pro1rel2spr3.getSprintBacklog().addTask(pro1rel2spr3tas1);
		pro1rel2spr3tas1.addPBI(pro1rel2spr3fea1);
		pro1rel2spr3tas1.setPlanEffort(new Effort(5));
		pro1rel2spr3tas1.setResponsibility(pBjoern);
		// pro1rel2spr3tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr3tas2 = new Task("Projekt 1, Release 2, Sprint 3, Task 2",
				"Beschreibung von Task 2");
		pro1rel2spr3.getSprintBacklog().addTask(pro1rel2spr3tas2);
		pro1rel2spr3tas2.addPBI(pro1rel2spr3fea2);
		pro1rel2spr3tas2.setPlanEffort(new Effort(5));
		pro1rel2spr3tas2.setResponsibility(pBjoern);
		// pro1rel2spr3tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr3tas3 = new Task("Projekt 1, Release 2, Sprint 3, Task 3",
				"Beschreibung von Task 3");
		pro1rel2spr3.getSprintBacklog().addTask(pro1rel2spr3tas3);
		pro1rel2spr3tas3.addPBI(pro1rel2spr3fea3);
		pro1rel2spr3tas3.setPlanEffort(new Effort(8));
		pro1rel2spr3tas3.setResponsibility(pBjoern);
		pro1rel2spr3tas3.finish(new Date(2011 - 1900, 3 - 1, 19));

		pro1rel2spr3tas4 = new Task("Projekt 1, Release 2, Sprint 3, Task 4",
				"Beschreibung von Task 4");
		pro1rel2spr3.getSprintBacklog().addTask(pro1rel2spr3tas4);
		pro1rel2spr3tas4.addPBI(pro1rel2spr3fea4);
		pro1rel2spr3tas4.setPlanEffort(new Effort(8));
		pro1rel2spr3tas4.setResponsibility(pBjoern);
		pro1rel2spr3tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr3tas5 = new Task("Projekt 1, Release 2, Sprint 3, Task 5",
				"Beschreibung von Task 5");
		pro1rel2spr3.getSprintBacklog().addTask(pro1rel2spr3tas5);
		pro1rel2spr3tas5.addPBI(pro1rel2spr3fea5);
		pro1rel2spr3tas5.setPlanEffort(new Effort(9));
		pro1rel2spr3tas5.setResponsibility(pBjoern);
		pro1rel2spr3tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 1, Release 2, Sprint 4
		pro1rel2spr4tas1 = new Task("Projekt 1, Release 2, Sprint 4, Task 1",
				"Beschreibung von Task 1");
		pro1rel2spr4.getSprintBacklog().addTask(pro1rel2spr4tas1);
		pro1rel2spr4tas1.addPBI(pro1rel2spr4fea1);
		pro1rel2spr4tas1.setPlanEffort(new Effort(1));
		pro1rel2spr4tas1.setResponsibility(pBjoern);
		// pro1rel2spr4tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr4tas2 = new Task("Projekt 1, Release 2, Sprint 4, Task 2",
				"Beschreibung von Task 2");
		pro1rel2spr4.getSprintBacklog().addTask(pro1rel2spr4tas2);
		pro1rel2spr4tas2.addPBI(pro1rel2spr4fea2);
		pro1rel2spr4tas2.setPlanEffort(new Effort(2));
		pro1rel2spr4tas2.setResponsibility(pBjoern);
		pro1rel2spr4tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr4tas3 = new Task("Projekt 1, Release 2, Sprint 4, Task 3",
				"Beschreibung von Task 3");
		pro1rel2spr4.getSprintBacklog().addTask(pro1rel2spr4tas3);
		pro1rel2spr4tas3.addPBI(pro1rel2spr4fea3);
		pro1rel2spr4tas3.setPlanEffort(new Effort(6));
		pro1rel2spr4tas3.setResponsibility(pBjoern);
		pro1rel2spr4tas3.finish(new Date(2011 - 1900, 3 - 1, 2));

		pro1rel2spr4tas4 = new Task("Projekt 1, Release 2, Sprint 4, Task 4",
				"Beschreibung von Task 4");
		pro1rel2spr4.getSprintBacklog().addTask(pro1rel2spr4tas4);
		pro1rel2spr4tas4.addPBI(pro1rel2spr4fea4);
		pro1rel2spr4tas4.setPlanEffort(new Effort(1));
		pro1rel2spr4tas4.setResponsibility(pBjoern);
		pro1rel2spr4tas4.finish(new Date(2011 - 1900, 3 - 1, 3));

		pro1rel2spr4tas5 = new Task("Projekt 1, Release 2, Sprint 4, Task 5",
				"Beschreibung von Task 5");
		pro1rel2spr4.getSprintBacklog().addTask(pro1rel2spr4tas5);
		pro1rel2spr4tas5.addPBI(pro1rel2spr4fea5);
		pro1rel2spr4tas5.setPlanEffort(new Effort(3));
		pro1rel2spr4tas5.setResponsibility(pBjoern);
		pro1rel2spr4tas5.finish(new Date(2011 - 1900, 3 - 1, 2));

		// für Projekt 1, Release 2, Sprint 5
		pro1rel2spr5tas1 = new Task("Projekt 1, Release 2, Sprint 5, Task 1",
				"Beschreibung von Task 1");
		pro1rel2spr5.getSprintBacklog().addTask(pro1rel2spr5tas1);
		pro1rel2spr5tas1.addPBI(pro1rel2spr5fea1);
		pro1rel2spr5tas1.setPlanEffort(new Effort(8));
		pro1rel2spr5tas1.setResponsibility(pBjoern);
		// pro1rel2spr5tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr5tas2 = new Task("Projekt 1, Release 2, Sprint 5, Task 2",
				"Beschreibung von Task 2");
		pro1rel2spr5.getSprintBacklog().addTask(pro1rel2spr5tas2);
		pro1rel2spr5tas2.addPBI(pro1rel2spr5fea2);
		pro1rel2spr5tas2.setPlanEffort(new Effort(8));
		pro1rel2spr5tas2.setResponsibility(pBjoern);
		// pro1rel2spr5tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr5tas3 = new Task("Projekt 1, Release 2, Sprint 5, Task 3",
				"Beschreibung von Task 3");
		pro1rel2spr5.getSprintBacklog().addTask(pro1rel2spr5tas3);
		pro1rel2spr5tas3.addPBI(pro1rel2spr5fea3);
		pro1rel2spr5tas3.setPlanEffort(new Effort(8));
		pro1rel2spr5tas3.setResponsibility(pBjoern);
		// pro1rel2spr5tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr5tas4 = new Task("Projekt 1, Release 2, Sprint 5, Task 4",
				"Beschreibung von Task 4");
		pro1rel2spr5.getSprintBacklog().addTask(pro1rel2spr5tas4);
		pro1rel2spr5tas4.addPBI(pro1rel2spr5fea4);
		pro1rel2spr5tas4.setPlanEffort(new Effort(8));
		pro1rel2spr5tas4.setResponsibility(pBjoern);
		// pro1rel2spr5tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro1rel2spr5tas5 = new Task("Projekt 1, Release 2, Sprint 5, Task 5",
				"Beschreibung von Task 5");
		pro1rel2spr5.getSprintBacklog().addTask(pro1rel2spr5tas5);
		pro1rel2spr5tas5.addPBI(pro1rel2spr5fea5);
		pro1rel2spr5tas5.setPlanEffort(new Effort(8));
		pro1rel2spr5tas5.setResponsibility(pBjoern);
		// pro1rel2spr5tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 2, Release 1, Sprint 1
		pro2rel1spr1tas1 = new Task("Projekt 2, Release 1, Sprint 1, Task 1",
				"Beschreibung von Task 1");
		pro2rel1spr1.getSprintBacklog().addTask(pro2rel1spr1tas1);
		pro2rel1spr1tas1.addPBI(pro2rel1spr1fea1);
		pro2rel1spr1tas1.setPlanEffort(new Effort(7));
		pro2rel1spr1tas1.setResponsibility(pBjoern);
		pro2rel1spr1tas1.finish(new Date(2011 - 1900, 2 - 1, 1));

		pro2rel1spr1tas2 = new Task("Projekt 2, Release 1, Sprint 1, Task 2",
				"Beschreibung von Task 2");
		pro2rel1spr1.getSprintBacklog().addTask(pro2rel1spr1tas2);
		pro2rel1spr1tas2.addPBI(pro2rel1spr1fea2);
		pro2rel1spr1tas2.setPlanEffort(new Effort(3));
		pro2rel1spr1tas2.setResponsibility(pBjoern);
		pro2rel1spr1tas2.finish(new Date(2011 - 1900, 4 - 1, 1));

		pro2rel1spr1tas3 = new Task("Projekt 2, Release 1, Sprint 1, Task 3",
				"Beschreibung von Task 3");
		pro2rel1spr1.getSprintBacklog().addTask(pro2rel1spr1tas3);
		pro2rel1spr1tas3.addPBI(pro2rel1spr1fea3);
		pro2rel1spr1tas3.setPlanEffort(new Effort(3));
		pro2rel1spr1tas3.setResponsibility(pBjoern);
		pro2rel1spr1tas3.finish(new Date(2011 - 1900, 4 - 1, 1));

		pro2rel1spr1tas4 = new Task("Projekt 2, Release 1, Sprint 1, Task 4",
				"Beschreibung von Task 4");
		pro2rel1spr1.getSprintBacklog().addTask(pro2rel1spr1tas4);
		pro2rel1spr1tas4.addPBI(pro2rel1spr1fea4);
		pro2rel1spr1tas4.setPlanEffort(new Effort(5));
		pro2rel1spr1tas4.setResponsibility(pBjoern);
		pro2rel1spr1tas4.finish(new Date(2011 - 1900, 4 - 1, 1));

		pro2rel1spr1tas5 = new Task("Projekt 2, Release 1, Sprint 1, Task 5",
				"Beschreibung von Task 5");
		pro2rel1spr1.getSprintBacklog().addTask(pro2rel1spr1tas5);
		pro2rel1spr1tas5.addPBI(pro2rel1spr1fea5);
		pro2rel1spr1tas5.setPlanEffort(new Effort(4));
		pro2rel1spr1tas5.setResponsibility(pBjoern);
		pro2rel1spr1tas5.finish(new Date(2011 - 1900, 2 - 1, 1));

		// für Projekt 2, Release 1, Sprint 2
		pro2rel1spr2tas1 = new Task("Projekt 2, Release 1, Sprint 2, Task 1",
				"Beschreibung von Task 1");
		pro2rel1spr2.getSprintBacklog().addTask(pro2rel1spr2tas1);
		pro2rel1spr2tas1.addPBI(pro2rel1spr2fea1);
		pro2rel1spr2tas1.setPlanEffort(new Effort(3));
		pro2rel1spr2tas1.setResponsibility(pBjoern);
		// pro2rel1spr2tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr2tas2 = new Task("Projekt 2, Release 1, Sprint 2, Task 2",
				"Beschreibung von Task 2");
		pro2rel1spr2.getSprintBacklog().addTask(pro2rel1spr2tas2);
		pro2rel1spr2tas2.addPBI(pro2rel1spr2fea2);
		pro2rel1spr2tas2.setPlanEffort(new Effort(3));
		pro2rel1spr2tas2.setResponsibility(pBjoern);
		// pro2rel1spr2tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr2tas3 = new Task("Projekt 2, Release 1, Sprint 2, Task 3",
				"Beschreibung von Task 3");
		pro2rel1spr2.getSprintBacklog().addTask(pro2rel1spr2tas3);
		pro2rel1spr2tas3.addPBI(pro2rel1spr2fea3);
		pro2rel1spr2tas3.setPlanEffort(new Effort(3));
		pro2rel1spr2tas3.setResponsibility(pBjoern);
		pro2rel1spr2tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr2tas4 = new Task("Projekt 2, Release 1, Sprint 2, Task 4",
				"Beschreibung von Task 4");
		pro2rel1spr2.getSprintBacklog().addTask(pro2rel1spr2tas4);
		pro2rel1spr2tas4.addPBI(pro2rel1spr2fea4);
		pro2rel1spr2tas4.setPlanEffort(new Effort(3));
		pro2rel1spr2tas4.setResponsibility(pBjoern);
		pro2rel1spr2tas4.finish(new Date(2011 - 1900, 3 - 1, 15));

		pro2rel1spr2tas5 = new Task("Projekt 2, Release 1, Sprint 2, Task 5",
				"Beschreibung von Task 5");
		pro2rel1spr2.getSprintBacklog().addTask(pro2rel1spr2tas5);
		pro2rel1spr2tas5.addPBI(pro2rel1spr2fea5);
		pro2rel1spr2tas5.setPlanEffort(new Effort(3));
		pro2rel1spr2tas5.setResponsibility(pBjoern);
		pro2rel1spr2tas5.finish(new Date(2011 - 1900, 3 - 1, 30));

		// für Projekt 2, Release 1, Sprint 3
		pro2rel1spr3tas1 = new Task("Projekt 2, Release 1, Sprint 3, Task 1",
				"Beschreibung von Task 1");
		pro2rel1spr3.getSprintBacklog().addTask(pro2rel1spr3tas1);
		pro2rel1spr3tas1.addPBI(pro2rel1spr3fea1);
		pro2rel1spr3tas1.setPlanEffort(new Effort(3));
		pro2rel1spr3tas1.setResponsibility(pBjoern);
		pro2rel1spr3tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr3tas2 = new Task("Projekt 2, Release 1, Sprint 3, Task 2",
				"Beschreibung von Task 2");
		pro2rel1spr3.getSprintBacklog().addTask(pro2rel1spr3tas2);
		pro2rel1spr3tas2.addPBI(pro2rel1spr3fea2);
		pro2rel1spr3tas2.setPlanEffort(new Effort(6));
		pro2rel1spr3tas2.setResponsibility(pBjoern);
		pro2rel1spr3tas2.finish(new Date(2011 - 1900, 4 - 1, 1));

		pro2rel1spr3tas3 = new Task("Projekt 2, Release 1, Sprint 3, Task 3",
				"Beschreibung von Task 3");
		pro2rel1spr3.getSprintBacklog().addTask(pro2rel1spr3tas3);
		pro2rel1spr3tas3.addPBI(pro2rel1spr3fea3);
		pro2rel1spr3tas3.setPlanEffort(new Effort(2));
		pro2rel1spr3tas3.setResponsibility(pBjoern);
		pro2rel1spr3tas3.finish(new Date(2011 - 1900, 4 - 1, 1));

		pro2rel1spr3tas4 = new Task("Projekt 2, Release 1, Sprint 3, Task 4",
				"Beschreibung von Task 4");
		pro2rel1spr3.getSprintBacklog().addTask(pro2rel1spr3tas4);
		pro2rel1spr3tas4.addPBI(pro2rel1spr3fea4);
		pro2rel1spr3tas4.setPlanEffort(new Effort(3));
		pro2rel1spr3tas4.setResponsibility(pBjoern);
		// pro2rel1spr3tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr3tas5 = new Task("Projekt 2, Release 1, Sprint 3, Task 5",
				"Beschreibung von Task 5");
		pro2rel1spr3.getSprintBacklog().addTask(pro2rel1spr3tas5);
		pro2rel1spr3tas5.addPBI(pro2rel1spr3fea5);
		pro2rel1spr3tas5.setPlanEffort(new Effort(6));
		pro2rel1spr3tas5.setResponsibility(pBjoern);
		// pro2rel1spr3tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 2, Release 1, Sprint 4
		pro2rel1spr4tas1 = new Task("Projekt 2, Release 1, Sprint 4, Task 1",
				"Beschreibung von Task 1");
		pro2rel1spr4.getSprintBacklog().addTask(pro2rel1spr4tas1);
		pro2rel1spr4tas1.addPBI(pro2rel1spr4fea1);
		pro2rel1spr4tas1.setPlanEffort(new Effort(4));
		pro2rel1spr4tas1.setResponsibility(pBjoern);
		// pro2rel1spr4tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr4tas2 = new Task("Projekt 2, Release 1, Sprint 4, Task 2",
				"Beschreibung von Task 2");
		pro2rel1spr4.getSprintBacklog().addTask(pro2rel1spr4tas2);
		pro2rel1spr4tas2.addPBI(pro2rel1spr4fea2);
		pro2rel1spr4tas2.setPlanEffort(new Effort(6));
		pro2rel1spr4tas2.setResponsibility(pBjoern);
		// pro2rel1spr4tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr4tas3 = new Task("Projekt 2, Release 1, Sprint 4, Task 3",
				"Beschreibung von Task 3");
		pro2rel1spr4.getSprintBacklog().addTask(pro2rel1spr4tas3);
		pro2rel1spr4tas3.addPBI(pro2rel1spr4fea3);
		pro2rel1spr4tas3.setPlanEffort(new Effort(7));
		pro2rel1spr4tas3.setResponsibility(pBjoern);
		// pro2rel1spr4tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr4tas4 = new Task("Projekt 2, Release 1, Sprint 4, Task 4",
				"Beschreibung von Task 4");
		pro2rel1spr4.getSprintBacklog().addTask(pro2rel1spr4tas4);
		pro2rel1spr4tas4.addPBI(pro2rel1spr4fea4);
		pro2rel1spr4tas4.setPlanEffort(new Effort(8));
		pro2rel1spr4tas4.setResponsibility(pBjoern);
		// pro2rel1spr4tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr4tas5 = new Task("Projekt 2, Release 1, Sprint 4, Task 5",
				"Beschreibung von Task 5");
		pro2rel1spr4.getSprintBacklog().addTask(pro2rel1spr4tas5);
		pro2rel1spr4tas5.addPBI(pro2rel1spr4fea5);
		pro2rel1spr4tas5.setPlanEffort(new Effort(1));
		pro2rel1spr4tas5.setResponsibility(pBjoern);
		pro2rel1spr4tas5.finish(new Date(2011 - 1900, 3 - 1, 17));

		// für Projekt 2, Release 1, Sprint 5
		pro2rel1spr5tas1 = new Task("Projekt 2, Release 1, Sprint 5, Task 1",
				"Beschreibung von Task 1");
		pro2rel1spr5.getSprintBacklog().addTask(pro2rel1spr5tas1);
		pro2rel1spr5tas1.addPBI(pro2rel1spr5fea1);
		pro2rel1spr5tas1.setPlanEffort(new Effort(2));
		pro2rel1spr5tas1.setResponsibility(pBjoern);
		// pro2rel1spr5tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr5tas2 = new Task("Projekt 2, Release 1, Sprint 5, Task 2",
				"Beschreibung von Task 2");
		pro2rel1spr5.getSprintBacklog().addTask(pro2rel1spr5tas2);
		pro2rel1spr5tas2.addPBI(pro2rel1spr5fea2);
		pro2rel1spr5tas2.setPlanEffort(new Effort(8));
		pro2rel1spr5tas2.setResponsibility(pBjoern);
		pro2rel1spr5tas2.finish(new Date(2011 - 1900, 3 - 1, 14));

		pro2rel1spr5tas3 = new Task("Projekt 2, Release 1, Sprint 5, Task 3",
				"Beschreibung von Task 3");
		pro2rel1spr5.getSprintBacklog().addTask(pro2rel1spr5tas3);
		pro2rel1spr5tas3.addPBI(pro2rel1spr5fea3);
		pro2rel1spr5tas3.setPlanEffort(new Effort(3));
		pro2rel1spr5tas3.setResponsibility(pBjoern);
		// pro2rel1spr5tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel1spr5tas4 = new Task("Projekt 2, Release 1, Sprint 5, Task 4",
				"Beschreibung von Task 4");
		pro2rel1spr5.getSprintBacklog().addTask(pro2rel1spr5tas4);
		pro2rel1spr5tas4.addPBI(pro2rel1spr5fea4);
		pro2rel1spr5tas4.setPlanEffort(new Effort(5));
		pro2rel1spr5tas4.setResponsibility(pBjoern);
		pro2rel1spr5tas4.finish(new Date(2011 - 1900, 3 - 1, 14));

		pro2rel1spr5tas5 = new Task("Projekt 2, Release 1, Sprint 5, Task 5",
				"Beschreibung von Task 5");
		pro2rel1spr5.getSprintBacklog().addTask(pro2rel1spr5tas5);
		pro2rel1spr5tas5.addPBI(pro2rel1spr5fea5);
		pro2rel1spr5tas5.setPlanEffort(new Effort(3));
		pro2rel1spr5tas5.setResponsibility(pBjoern);
		pro2rel1spr5tas5.finish(new Date(2011 - 1900, 3 - 1, 7));

		// für Projekt 2, Release 2, Sprint 1
		pro2rel2spr1tas1 = new Task("Projekt 2, Release 2, Sprint 1, Task 1",
				"Beschreibung von Task 1");
		pro2rel2spr1.getSprintBacklog().addTask(pro2rel2spr1tas1);
		pro2rel2spr1tas1.addPBI(pro2rel2spr1fea1);
		pro2rel2spr1tas1.setPlanEffort(new Effort(5));
		pro2rel2spr1tas1.setResponsibility(pBjoern);
		// pro2rel2spr1tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr1tas2 = new Task("Projekt 2, Release 2, Sprint 1, Task 2",
				"Beschreibung von Task 2");
		pro2rel2spr1.getSprintBacklog().addTask(pro2rel2spr1tas2);
		pro2rel2spr1tas2.addPBI(pro2rel2spr1fea2);
		pro2rel2spr1tas2.setPlanEffort(new Effort(5));
		pro2rel2spr1tas2.setResponsibility(pBjoern);
		// pro2rel2spr1tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr1tas3 = new Task("Projekt 2, Release 2, Sprint 1, Task 3",
				"Beschreibung von Task 3");
		pro2rel2spr1.getSprintBacklog().addTask(pro2rel2spr1tas3);
		pro2rel2spr1tas3.addPBI(pro2rel2spr1fea3);
		pro2rel2spr1tas3.setPlanEffort(new Effort(5));
		pro2rel2spr1tas3.setResponsibility(pBjoern);
		// pro2rel2spr1tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr1tas4 = new Task("Projekt 2, Release 2, Sprint 1, Task 4",
				"Beschreibung von Task 4");
		pro2rel2spr1.getSprintBacklog().addTask(pro2rel2spr1tas4);
		pro2rel2spr1tas4.addPBI(pro2rel2spr1fea4);
		pro2rel2spr1tas4.setPlanEffort(new Effort(5));
		pro2rel2spr1tas4.setResponsibility(pBjoern);
		// pro2rel2spr1tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr1tas5 = new Task("Projekt 2, Release 2, Sprint 1, Task 5",
				"Beschreibung von Task 5");
		pro2rel2spr1.getSprintBacklog().addTask(pro2rel2spr1tas5);
		pro2rel2spr1tas5.addPBI(pro2rel2spr1fea5);
		pro2rel2spr1tas5.setPlanEffort(new Effort(5));
		pro2rel2spr1tas5.setResponsibility(pBjoern);
		pro2rel2spr1tas5.finish(new Date(2011 - 1900, 6 - 1, 13));

		// für Projekt 2, Release 2, Sprint 2
		pro2rel2spr2tas1 = new Task("Projekt 2, Release 2, Sprint 2, Task 1",
				"Beschreibung von Task 1");
		pro2rel2spr2.getSprintBacklog().addTask(pro2rel2spr2tas1);
		pro2rel2spr2tas1.addPBI(pro2rel2spr2fea1);
		pro2rel2spr2tas1.setPlanEffort(new Effort(5));
		pro2rel2spr2tas1.setResponsibility(pBjoern);
		// pro2rel2spr2tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr2tas2 = new Task("Projekt 2, Release 2, Sprint 2, Task 2",
				"Beschreibung von Task 2");
		pro2rel2spr2.getSprintBacklog().addTask(pro2rel2spr2tas2);
		pro2rel2spr2tas2.addPBI(pro2rel2spr2fea2);
		pro2rel2spr2tas2.setPlanEffort(new Effort(5));
		pro2rel2spr2tas2.setResponsibility(pBjoern);
		pro2rel2spr2tas2.finish(new Date(2011 - 1900, 2 - 1, 11));

		pro2rel2spr2tas3 = new Task("Projekt 2, Release 2, Sprint 2, Task 3",
				"Beschreibung von Task 3");
		pro2rel2spr2.getSprintBacklog().addTask(pro2rel2spr2tas3);
		pro2rel2spr2tas3.addPBI(pro2rel2spr2fea3);
		pro2rel2spr2tas3.setPlanEffort(new Effort(5));
		pro2rel2spr2tas3.setResponsibility(pBjoern);
		pro2rel2spr2tas3.finish(new Date(2011 - 1900, 2 - 1, 12));

		pro2rel2spr2tas4 = new Task("Projekt 2, Release 2, Sprint 2, Task 4",
				"Beschreibung von Task 4");
		pro2rel2spr2.getSprintBacklog().addTask(pro2rel2spr2tas4);
		pro2rel2spr2tas4.addPBI(pro2rel2spr2fea4);
		pro2rel2spr2tas4.setPlanEffort(new Effort(5));
		pro2rel2spr2tas4.setResponsibility(pBjoern);
		// pro2rel2spr2tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr2tas5 = new Task("Projekt 2, Release 2, Sprint 2, Task 5",
				"Beschreibung von Task 5");
		pro2rel2spr2.getSprintBacklog().addTask(pro2rel2spr2tas5);
		pro2rel2spr2tas5.addPBI(pro2rel2spr2fea5);
		pro2rel2spr2tas5.setPlanEffort(new Effort(5));
		pro2rel2spr2tas5.setResponsibility(pBjoern);
		pro2rel2spr2tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 2, Release 2, Sprint 3
		pro2rel2spr3tas1 = new Task("Projekt 2, Release 2, Sprint 3, Task 1",
				"Beschreibung von Task 1");
		pro2rel2spr3.getSprintBacklog().addTask(pro2rel2spr3tas1);
		pro2rel2spr3tas1.addPBI(pro2rel2spr3fea1);
		pro2rel2spr3tas1.setPlanEffort(new Effort(5));
		pro2rel2spr3tas1.setResponsibility(pBjoern);
		pro2rel2spr3tas1.finish(new Date(2011 - 1900, 1 - 1, 1));

		pro2rel2spr3tas2 = new Task("Projekt 2, Release 2, Sprint 3, Task 2",
				"Beschreibung von Task 2");
		pro2rel2spr3.getSprintBacklog().addTask(pro2rel2spr3tas2);
		pro2rel2spr3tas2.addPBI(pro2rel2spr3fea2);
		pro2rel2spr3tas2.setPlanEffort(new Effort(5));
		pro2rel2spr3tas2.setResponsibility(pBjoern);
		pro2rel2spr3tas2.finish(new Date(2011 - 1900, 1 - 1, 2));

		pro2rel2spr3tas3 = new Task("Projekt 2, Release 2, Sprint 3, Task 3",
				"Beschreibung von Task 3");
		pro2rel2spr3.getSprintBacklog().addTask(pro2rel2spr3tas3);
		pro2rel2spr3tas3.addPBI(pro2rel2spr3fea3);
		pro2rel2spr3tas3.setPlanEffort(new Effort(5));
		pro2rel2spr3tas3.setResponsibility(pBjoern);
		pro2rel2spr3tas3.finish(new Date(2011 - 1900, 1 - 1, 11));

		pro2rel2spr3tas4 = new Task("Projekt 2, Release 2, Sprint 3, Task 4",
				"Beschreibung von Task 4");
		pro2rel2spr3.getSprintBacklog().addTask(pro2rel2spr3tas4);
		pro2rel2spr3tas4.addPBI(pro2rel2spr3fea4);
		pro2rel2spr3tas4.setPlanEffort(new Effort(5));
		pro2rel2spr3tas4.setResponsibility(pBjoern);
		// pro2rel2spr3tas4.finish(new Date(2011 - 1900, 1 - 1, 1));

		pro2rel2spr3tas5 = new Task("Projekt 2, Release 2, Sprint 3, Task 5",
				"Beschreibung von Task 5");
		pro2rel2spr3.getSprintBacklog().addTask(pro2rel2spr3tas5);
		pro2rel2spr3tas5.addPBI(pro2rel2spr3fea5);
		pro2rel2spr3tas5.setPlanEffort(new Effort(5));
		pro2rel2spr3tas5.setResponsibility(pBjoern);
		// pro2rel2spr3tas5.finish(new Date(2011 - 1900, 1 - 1, 1));

		// für Projekt 2, Release 2, Sprint 4
		pro2rel2spr4tas1 = new Task("Projekt 2, Release 2, Sprint 4, Task 1",
				"Beschreibung von Task 1");
		pro2rel2spr4.getSprintBacklog().addTask(pro2rel2spr4tas1);
		pro2rel2spr4tas1.addPBI(pro2rel2spr4fea1);
		pro2rel2spr4tas1.setPlanEffort(new Effort(5));
		pro2rel2spr4tas1.setResponsibility(pBjoern);
		pro2rel2spr4tas1.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr4tas2 = new Task("Projekt 2, Release 2, Sprint 4, Task 2",
				"Beschreibung von Task 2");
		pro2rel2spr4.getSprintBacklog().addTask(pro2rel2spr4tas2);
		pro2rel2spr4tas2.addPBI(pro2rel2spr4fea2);
		pro2rel2spr4tas2.setPlanEffort(new Effort(5));
		pro2rel2spr4tas2.setResponsibility(pBjoern);
		pro2rel2spr4tas2.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr4tas3 = new Task("Projekt 2, Release 2, Sprint 4, Task 3",
				"Beschreibung von Task 3");
		pro2rel2spr4.getSprintBacklog().addTask(pro2rel2spr4tas3);
		pro2rel2spr4tas3.addPBI(pro2rel2spr4fea3);
		pro2rel2spr4tas3.setPlanEffort(new Effort(5));
		pro2rel2spr4tas3.setResponsibility(pBjoern);
		pro2rel2spr4tas3.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr4tas4 = new Task("Projekt 2, Release 2, Sprint 4, Task 4",
				"Beschreibung von Task 4");
		pro2rel2spr4.getSprintBacklog().addTask(pro2rel2spr4tas4);
		pro2rel2spr4tas4.addPBI(pro2rel2spr4fea4);
		pro2rel2spr4tas4.setPlanEffort(new Effort(5));
		pro2rel2spr4tas4.setResponsibility(pBjoern);
		pro2rel2spr4tas4.finish(new Date(2011 - 1900, 3 - 1, 1));

		pro2rel2spr4tas5 = new Task("Projekt 2, Release 2, Sprint 4, Task 5",
				"Beschreibung von Task 5");
		pro2rel2spr4.getSprintBacklog().addTask(pro2rel2spr4tas5);
		pro2rel2spr4tas5.addPBI(pro2rel2spr4fea5);
		pro2rel2spr4tas5.setPlanEffort(new Effort(5));
		pro2rel2spr4tas5.setResponsibility(pBjoern);
		pro2rel2spr4tas5.finish(new Date(2011 - 1900, 3 - 1, 1));

		// für Projekt 2, Release 2, Sprint 5
		pro2rel2spr5tas1 = new Task("Projekt 2, Release 2, Sprint 5, Task 1",
				"Beschreibung von Task 1");
		pro2rel2spr5.getSprintBacklog().addTask(pro2rel2spr5tas1);
		pro2rel2spr5tas1.addPBI(pro2rel2spr5fea1);
		pro2rel2spr5tas1.setPlanEffort(new Effort(5));
		pro2rel2spr5tas1.setResponsibility(pBjoern);
		pro2rel2spr5tas1.finish(new Date(2011 - 1900, 2 - 1, 27));

		pro2rel2spr5tas2 = new Task("Projekt 2, Release 2, Sprint 5, Task 2",
				"Beschreibung von Task 2");
		pro2rel2spr5.getSprintBacklog().addTask(pro2rel2spr5tas2);
		pro2rel2spr5tas2.addPBI(pro2rel2spr5fea2);
		pro2rel2spr5tas2.setPlanEffort(new Effort(5));
		pro2rel2spr5tas2.setResponsibility(pBjoern);
		pro2rel2spr5tas2.finish(new Date(2011 - 1900, 2 - 1, 27));

		pro2rel2spr5tas3 = new Task("Projekt 2, Release 2, Sprint 5, Task 3",
				"Beschreibung von Task 3");
		pro2rel2spr5.getSprintBacklog().addTask(pro2rel2spr5tas3);
		pro2rel2spr5tas3.addPBI(pro2rel2spr5fea3);
		pro2rel2spr5tas3.setPlanEffort(new Effort(5));
		pro2rel2spr5tas3.setResponsibility(pBjoern);
		pro2rel2spr5tas3.finish(new Date(2011 - 1900, 3 - 1, 2));

		pro2rel2spr5tas4 = new Task("Projekt 2, Release 2, Sprint 5, Task 4",
				"Beschreibung von Task 4");
		pro2rel2spr5.getSprintBacklog().addTask(pro2rel2spr5tas4);
		pro2rel2spr5tas4.addPBI(pro2rel2spr5fea4);
		pro2rel2spr5tas4.setPlanEffort(new Effort(5));
		pro2rel2spr5tas4.setResponsibility(pBjoern);
		pro2rel2spr5tas4.finish(new Date(2011 - 1900, 3 - 1, 3));

		pro2rel2spr5tas5 = new Task("Projekt 2, Release 2, Sprint 5, Task 5",
				"Beschreibung von Task 5");
		pro2rel2spr5.getSprintBacklog().addTask(pro2rel2spr5tas5);
		pro2rel2spr5tas5.addPBI(pro2rel2spr5fea5);
		pro2rel2spr5tas5.setPlanEffort(new Effort(5));
		pro2rel2spr5tas5.setResponsibility(pBjoern);
		pro2rel2spr5tas5.finish(new Date(2011 - 1900, 3 - 1, 7));

		// Alle Features der Liste der Features hinzufügen
		listOfFeatures = new ArrayList<ProductBacklogItem>();
		listOfFeatures.add(pro1rel2spr1fea1);
		listOfFeatures.add(pro1rel1spr5fea5);
		listOfFeatures.add(pro1rel1spr1fea1);
		listOfFeatures.add(pro1rel1spr1fea2);
		listOfFeatures.add(pro1rel1spr1fea3);
		listOfFeatures.add(pro1rel1spr1fea4);
		listOfFeatures.add(pro1rel1spr1fea5);
		listOfFeatures.add(pro1rel1spr2fea1);
		listOfFeatures.add(pro1rel1spr2fea2);
		listOfFeatures.add(pro1rel1spr2fea3);
		listOfFeatures.add(pro1rel1spr2fea4);
		listOfFeatures.add(pro1rel1spr2fea5);
		listOfFeatures.add(pro1rel1spr3fea1);
		listOfFeatures.add(pro1rel1spr3fea2);
		listOfFeatures.add(pro1rel1spr3fea3);
		listOfFeatures.add(pro1rel1spr3fea4);
		listOfFeatures.add(pro1rel1spr3fea5);
		listOfFeatures.add(pro1rel1spr4fea1);
		listOfFeatures.add(pro1rel1spr4fea2);
		listOfFeatures.add(pro1rel1spr4fea3);
		listOfFeatures.add(pro1rel1spr4fea4);
		listOfFeatures.add(pro1rel1spr4fea5);
		listOfFeatures.add(pro1rel1spr5fea1);
		listOfFeatures.add(pro1rel1spr5fea2);
		listOfFeatures.add(pro1rel1spr5fea3);
		listOfFeatures.add(pro1rel1spr5fea4);
		listOfFeatures.add(pro1rel2spr1fea2);
		listOfFeatures.add(pro1rel2spr1fea3);
		listOfFeatures.add(pro1rel2spr1fea4);
		listOfFeatures.add(pro1rel2spr1fea5);
		listOfFeatures.add(pro1rel2spr2fea1);
		listOfFeatures.add(pro1rel2spr2fea2);
		listOfFeatures.add(pro1rel2spr2fea3);
		listOfFeatures.add(pro1rel2spr2fea4);
		listOfFeatures.add(pro1rel2spr2fea5);
		listOfFeatures.add(pro1rel2spr3fea1);
		listOfFeatures.add(pro1rel2spr3fea2);
		listOfFeatures.add(pro1rel2spr3fea3);
		listOfFeatures.add(pro1rel2spr3fea4);
		listOfFeatures.add(pro1rel2spr3fea5);
		listOfFeatures.add(pro1rel2spr4fea1);
		listOfFeatures.add(pro1rel2spr4fea2);
		listOfFeatures.add(pro1rel2spr4fea3);
		listOfFeatures.add(pro1rel2spr4fea4);
		listOfFeatures.add(pro1rel2spr4fea5);
		listOfFeatures.add(pro1rel2spr5fea1);
		listOfFeatures.add(pro1rel2spr5fea2);
		listOfFeatures.add(pro1rel2spr5fea3);
		listOfFeatures.add(pro1rel2spr5fea4);
		listOfFeatures.add(pro1rel2spr5fea5);
		listOfFeatures.add(pro2rel1spr1fea1);
		listOfFeatures.add(pro2rel1spr1fea2);
		listOfFeatures.add(pro2rel1spr1fea3);
		listOfFeatures.add(pro2rel1spr1fea4);
		listOfFeatures.add(pro2rel1spr1fea5);
		listOfFeatures.add(pro2rel1spr2fea1);
		listOfFeatures.add(pro2rel1spr2fea2);
		listOfFeatures.add(pro2rel1spr2fea3);
		listOfFeatures.add(pro2rel1spr2fea4);
		listOfFeatures.add(pro2rel1spr2fea5);
		listOfFeatures.add(pro2rel1spr3fea1);
		listOfFeatures.add(pro2rel1spr3fea2);
		listOfFeatures.add(pro2rel1spr3fea3);
		listOfFeatures.add(pro2rel1spr3fea4);
		listOfFeatures.add(pro2rel1spr3fea5);
		listOfFeatures.add(pro2rel1spr4fea1);
		listOfFeatures.add(pro2rel1spr4fea2);
		listOfFeatures.add(pro2rel1spr4fea3);
		listOfFeatures.add(pro2rel1spr4fea4);
		listOfFeatures.add(pro2rel1spr4fea5);
		listOfFeatures.add(pro2rel1spr5fea1);
		listOfFeatures.add(pro2rel1spr5fea2);
		listOfFeatures.add(pro2rel1spr5fea3);
		listOfFeatures.add(pro2rel1spr5fea4);
		listOfFeatures.add(pro2rel1spr5fea5);
		listOfFeatures.add(pro2rel2spr1fea1);
		listOfFeatures.add(pro2rel2spr1fea2);
		listOfFeatures.add(pro2rel2spr1fea3);
		listOfFeatures.add(pro2rel2spr1fea4);
		listOfFeatures.add(pro2rel2spr1fea5);
		listOfFeatures.add(pro2rel2spr2fea1);
		listOfFeatures.add(pro2rel2spr2fea2);
		listOfFeatures.add(pro2rel2spr2fea3);
		listOfFeatures.add(pro2rel2spr2fea4);
		listOfFeatures.add(pro2rel2spr2fea5);
		listOfFeatures.add(pro2rel2spr3fea1);
		listOfFeatures.add(pro2rel2spr3fea2);
		listOfFeatures.add(pro2rel2spr3fea3);
		listOfFeatures.add(pro2rel2spr3fea4);
		listOfFeatures.add(pro2rel2spr3fea5);
		listOfFeatures.add(pro2rel2spr4fea1);
		listOfFeatures.add(pro2rel2spr4fea2);
		listOfFeatures.add(pro2rel2spr4fea3);
		listOfFeatures.add(pro2rel2spr4fea4);
		listOfFeatures.add(pro2rel2spr4fea5);
		listOfFeatures.add(pro2rel2spr5fea1);
		listOfFeatures.add(pro2rel2spr5fea2);
		listOfFeatures.add(pro2rel2spr5fea3);
		listOfFeatures.add(pro2rel2spr5fea4);
		listOfFeatures.add(pro2rel2spr5fea5);
	}

}