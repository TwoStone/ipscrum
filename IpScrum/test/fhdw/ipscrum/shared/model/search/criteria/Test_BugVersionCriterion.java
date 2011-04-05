package fhdw.ipscrum.shared.model.search.criteria;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.shared.model.*;
import fhdw.ipscrum.shared.model.System;

public class Test_BugVersionCriterion {
	
	private static Project textverarbeitung = null;
	private static ProductBacklog pbltext = null;
	private static SystemManager systemmanager = null;
	private static System betriebssystem = null;
	private static System windowsXP = null;
	private static System windows2000 = null;
	private static System windowsVista = null;
	private static System windows7 = null;
	private static System linux = null;
	private static Release release1 = null;
	private static Feature pbi1 = null;
	private static Feature pbi2= null;
	private static Feature pbi3 = null;
	private static Bug pbi4 = null;
	private static Person p1 = null;
	private static Person p2 = null;
	private static Person p3 = null;
	private static Person p4 = null;
	private static Person p5 = null;
	private static Person p6 = null;
	private static Person p7 = null;
	private static Team entwickler = null;
	private static Team planung = null;
	private static Team test = null;
	private static Team ideen = null;
	private static Sprint sprint1 = null;
	private static Sprint sprint2 = null;
	private static Sprint sprint3 = null;
	private static Sprint sprint4 = null;
	
	
	
	private static System testsys = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		textverarbeitung = new Project("Textverarbeitung");
		pbltext = textverarbeitung.getBacklog();
		release1 = new Release("Release 1", new Date(), textverarbeitung);
		systemmanager = new SystemManager();
		betriebssystem = new System("Betriebssystem", systemmanager.getSystems());
		windowsXP = new System("Windows XP", betriebssystem);
		windows2000 = new System("Windows 2000", betriebssystem);
		windowsVista = new System("Windows Vista", betriebssystem);
		windows7 = new System("Windows 7", betriebssystem);
		linux = new System("Linux", betriebssystem);
		textverarbeitung.addSystem(betriebssystem);
		textverarbeitung.addSystem(windowsXP);
		textverarbeitung.addSystem(windows2000);
		textverarbeitung.addSystem(windowsVista);
		textverarbeitung.addSystem(windows7);
		textverarbeitung.addSystem(linux);
				
		pbi1 = new Feature("Texte eingeben", "Texte im Programm erfassen", pbltext);
		pbi2 = new Feature("Textbearbeitung", "Texte bearbeiten", pbltext);
		pbi3 = new Feature("Farben", "Farbige Markierungen ermöglichen", pbltext);
		pbi4 = new Bug("Fehler bei Farben", "Darstellung der Farben fehlerhaft", release1,pbltext);
		
		pbi1.addHint(new Hint("Groß-/Kleinschreibung, Zahlen, Sonderzeichen"));
		pbi2.addHint(new Hint("fett, unterstrichen, kursiv, farbig"));
		pbi3.addHint(new Hint("Farben für Texte und Hintergründe definieren; Option ergänzen, dass Farben eingefügt werden können"));
		pbi4.addHint(new Hint("werden bei unterschiedlichen Systemen anders angezeigt"));

		pbi4.addSystem(betriebssystem);
		pbi4.addSystem(windows7);
		pbi4.addSystem(linux);
		pbi4.addSystem(windowsXP);

		pbi1.setManDayCosts(new Effort(10));
		pbi2.setManDayCosts(new Effort(7));
		pbi3.setManDayCosts(new Effort(3));
		pbi4.setManDayCosts(new Effort(5));

	pbltext.addItem(pbi1);
	pbltext.addItem(pbi2);
	pbltext.addItem(pbi3);
	pbltext.addItem(pbi4);

	p1 = new Person("Max", "Mustermann");
	p2 = new Person("Petra", "Plüsch");
	p3 = new Person("Michel", "Meier");
	p4 = new Person("Michel", "Mayer");
	p5 = new Person("Maximilian", "Schulz");
	p6 = new Person("Klaus", "Krüger");
	p7 = new Person("Joachim", "Krüger");

	entwickler = new Team("Entwickler");
	planung = new Team("Planung");
	test = new Team("Test");
	ideen = new Team("Ideen");

	entwickler.addMember(p1);
	entwickler.addMember(p3);
	entwickler.addMember(p4);
	planung.addMember(p2);
	planung.addMember(p4);
	planung.addMember(p5);
	planung.addMember(p7);
	test.addMember(p1);
	test.addMember(p6);
	ideen.addMember(p3);
	ideen.addMember(p4);
	ideen.addMember(p6);
	
	sprint1 = new Sprint("Sprint 1", "Beschreibung", new Date(), new Date(), entwickler);
	sprint2 = new Sprint("Sprint 2", "Beschreibung", new Date(), new Date(), entwickler);
	sprint3 = new Sprint("Sprint 3", "Beschreibung", new Date(), new Date(), entwickler);
	sprint4 = new Sprint("Sprint 4", "Beschreibung", new Date(), new Date(), entwickler);
	
	textverarbeitung.addSprint(sprint1);
	textverarbeitung.addSprint(sprint2);
	textverarbeitung.addSprint(sprint3);
	textverarbeitung.addSprint(sprint4);

	pbi1.setSprint(sprint1);
	pbi2.setSprint(sprint2);
	pbi3.setSprint(sprint3);
	pbi4.setSprint(sprint4);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	// ---------------------------------------------------------------------------
	// ---------------------- Test of functions ----------------------------------
	// ---------------------------------------------------------------------------
	
	@Test
	/**
	 * Test of constructor
	 */
	public void testConstructor() throws Exception{
	BugVersionCriterion BugSV1 = new BugVersionCriterion("Release");
	assertEquals("Release", BugSV1.getValue());
	}
	
	@Test
	/**
	 * Search for a Version in a Bug
	 * Version is part of the Bug
	 */
	
	public void testsearch1() throws Exception{
		BugVersionCriterion BugVC2 = new BugVersionCriterion("Release 1"); 
		assertEquals(true, BugVC2.search(pbi4));
	}
	
	@Test
	/**
	 * Search for a Version in a Bug
	 * Version is not part of the Bug
	 */
	
	public void testsearch2() throws Exception{
		BugVersionCriterion BugVC3 = new BugVersionCriterion("Release 2"); 
		assertEquals(false, BugVC3.search(pbi4));
	}

	@Test
	/**
	 * Search for a Version in a Feature
	 */
	
	public void testsearch3() throws Exception{
		BugVersionCriterion BugVC4 = new BugVersionCriterion("Release 1"); 
		assertEquals(false, BugVC4.search(pbi1));
	}
}
