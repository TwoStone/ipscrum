package fhdw.ipscrum.shared.model.metamodel.search.criteria;

import java.io.File;
import java.util.Date;

import org.junit.BeforeClass;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Bug;
import fhdw.ipscrum.shared.model.nonMeta.Effort;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklog;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Relation;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.System;
import fhdw.ipscrum.shared.model.nonMeta.Team;

public abstract class SetUpTestDataForCriterion {
	private static Model model;
	private static Project textverarbeitung = null;
	private static ProductBacklog pbltext = null;
	private static System betriebssystem = null;
	private static System windowsXP = null;
	private static System windows2000 = null;
	private static System windowsVista = null;
	private static System windows7 = null;
	private static System linux = null;
	private static Release release1 = null;
	private static Release release2 = null;
	private static Feature pbi1 = null;
	private static Feature pbi2 = null;
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
	private static RelationType rt1 = null;
	private static RelationType rt2 = null;
	private static RelationType rt3 = null;
	private static Relation r1 = null;
	private static Relation r2 = null;
	private static Relation r3 = null;
	private static Project taschenrechner = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TestUtils.deleteFolderContent(new File("output"));
		ServerContext.resetServerContext();
		SetUpTestDataForCriterion.model =
				ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		SetUpTestDataForCriterion.model.setUuidManager(new IDGenerator());
		SetUpTestDataForCriterion.setTextverarbeitung(new Project(
				SetUpTestDataForCriterion.getModel(), "Textverarbeitung"));
		SetUpTestDataForCriterion.setTaschenrechner(new Project(
				SetUpTestDataForCriterion.getModel(), "Taschenrechner"));
		SetUpTestDataForCriterion.pbltext =
				SetUpTestDataForCriterion.getTextverarbeitung().getBacklog();
		SetUpTestDataForCriterion.setRelease1(new Release(SetUpTestDataForCriterion
				.getModel(), "Release 1", new Date(), SetUpTestDataForCriterion
				.getTextverarbeitung()));
		SetUpTestDataForCriterion.setRelease2(new Release(SetUpTestDataForCriterion
				.getModel(), "Release 2", new Date(), SetUpTestDataForCriterion
				.getTextverarbeitung()));
		SetUpTestDataForCriterion.betriebssystem =
				new System(SetUpTestDataForCriterion.getModel(), "Betriebssystem",
						SetUpTestDataForCriterion.model.getRootsystem());
		SetUpTestDataForCriterion.setWindowsXP(new System(SetUpTestDataForCriterion
				.getModel(), "Windows XP", SetUpTestDataForCriterion.betriebssystem));
		SetUpTestDataForCriterion.setWindows2000(new System(SetUpTestDataForCriterion
				.getModel(), "Windows 2000", SetUpTestDataForCriterion.betriebssystem));
		SetUpTestDataForCriterion.windowsVista =
				new System(SetUpTestDataForCriterion.getModel(), "Windows Vista",
						SetUpTestDataForCriterion.betriebssystem);
		SetUpTestDataForCriterion.windows7 =
				new System(SetUpTestDataForCriterion.getModel(), "Windows 7",
						SetUpTestDataForCriterion.betriebssystem);
		SetUpTestDataForCriterion.linux =
				new System(SetUpTestDataForCriterion.getModel(), "Linux",
						SetUpTestDataForCriterion.betriebssystem);
		SetUpTestDataForCriterion.getTextverarbeitung().addSystem(
				SetUpTestDataForCriterion.betriebssystem);
		SetUpTestDataForCriterion.getTextverarbeitung().addSystem(
				SetUpTestDataForCriterion.getWindowsXP());
		SetUpTestDataForCriterion.getTextverarbeitung().addSystem(
				SetUpTestDataForCriterion.getWindows2000());
		SetUpTestDataForCriterion.getTextverarbeitung().addSystem(
				SetUpTestDataForCriterion.windowsVista);
		SetUpTestDataForCriterion.getTextverarbeitung().addSystem(
				SetUpTestDataForCriterion.windows7);
		SetUpTestDataForCriterion.getTextverarbeitung().addSystem(
				SetUpTestDataForCriterion.linux);
		// TODO: Feature erstellen
		SetUpTestDataForCriterion.setPbi1(new Feature(SetUpTestDataForCriterion
				.getModel(), SetUpTestDataForCriterion.model.getTypeManager()
				.getStandardFeatureType(), "Texte eingeben",
				"Texte im Programm erfassen", SetUpTestDataForCriterion.pbltext));
		SetUpTestDataForCriterion.pbi2 =
				new Feature(SetUpTestDataForCriterion.getModel(),
						SetUpTestDataForCriterion.model.getTypeManager()
								.getStandardFeatureType(), "Textbearbeitung",
						"Texte bearbeiten", SetUpTestDataForCriterion.pbltext);
		SetUpTestDataForCriterion.pbi3 =
				new Feature(SetUpTestDataForCriterion.getModel(),
						SetUpTestDataForCriterion.model.getTypeManager()
								.getStandardFeatureType(), "Farben",
						"Farbige Markierungen ermöglichen",
						SetUpTestDataForCriterion.pbltext);
		SetUpTestDataForCriterion.setPbi4(new Bug(SetUpTestDataForCriterion.getModel(),
				SetUpTestDataForCriterion.model.getTypeManager().getStandardBugType(),
				"Fehler bei Farben", "Darstellung der Farben fehlerhaft",
				SetUpTestDataForCriterion.pbltext, SetUpTestDataForCriterion
						.getRelease1()));

		SetUpTestDataForCriterion.getPbi1().addHint(
				"Groß-/Kleinschreibung, Zahlen, Sonderzeichen");
		SetUpTestDataForCriterion.getPbi2().addHint(
				"fett, unterstrichen, kursiv, farbig");
		SetUpTestDataForCriterion
				.getPbi3()
				.addHint(
						"Farben für Texte und Hintergründe definieren; Option ergänzen, dass Farben eingefügt werden können");
		SetUpTestDataForCriterion.getPbi4().addHint(
				"werden bei unterschiedlichen Systemen anders angezeigt");

		SetUpTestDataForCriterion.getPbi4().addSystem(
				SetUpTestDataForCriterion.betriebssystem);
		SetUpTestDataForCriterion.getPbi4().addSystem(
				SetUpTestDataForCriterion.windows7);
		SetUpTestDataForCriterion.getPbi4().addSystem(SetUpTestDataForCriterion.linux);
		SetUpTestDataForCriterion.getPbi4().addSystem(
				SetUpTestDataForCriterion.getWindowsXP());

		SetUpTestDataForCriterion.getPbi1().setManDayCosts(new Effort(10));
		SetUpTestDataForCriterion.getPbi2().setManDayCosts(new Effort(7));
		SetUpTestDataForCriterion.getPbi3().setManDayCosts(new Effort(3));
		SetUpTestDataForCriterion.getPbi4().setManDayCosts(new Effort(5));

		SetUpTestDataForCriterion.pbltext.addItem(SetUpTestDataForCriterion.getPbi1());
		SetUpTestDataForCriterion.pbltext.addItem(SetUpTestDataForCriterion.getPbi2());
		SetUpTestDataForCriterion.pbltext.addItem(SetUpTestDataForCriterion.getPbi3());
		SetUpTestDataForCriterion.pbltext.addItem(SetUpTestDataForCriterion.getPbi4());

		SetUpTestDataForCriterion.setP1(new Person(
				SetUpTestDataForCriterion.getModel(), "Max", "Mustermann"));
		SetUpTestDataForCriterion.setP2(new Person(
				SetUpTestDataForCriterion.getModel(), "Petra", "Plüsch"));
		SetUpTestDataForCriterion.setP3(new Person(
				SetUpTestDataForCriterion.getModel(), "Michel", "Meier"));
		SetUpTestDataForCriterion.p4 =
				new Person(SetUpTestDataForCriterion.getModel(), "Michel", "Mayer");
		SetUpTestDataForCriterion.p5 =
				new Person(SetUpTestDataForCriterion.getModel(), "Maximilian", "Schulz");
		SetUpTestDataForCriterion.p6 =
				new Person(SetUpTestDataForCriterion.getModel(), "Klaus", "Krüger");
		SetUpTestDataForCriterion.p7 =
				new Person(SetUpTestDataForCriterion.getModel(), "Joachim", "Krüger");

		SetUpTestDataForCriterion.entwickler =
				new Team(SetUpTestDataForCriterion.getModel(), "Entwickler");
		SetUpTestDataForCriterion.entwickler
				.addProject(SetUpTestDataForCriterion.taschenrechner);
		SetUpTestDataForCriterion.entwickler
				.addProject(SetUpTestDataForCriterion.textverarbeitung);
		SetUpTestDataForCriterion.planung =
				new Team(SetUpTestDataForCriterion.getModel(), "Planung");
		SetUpTestDataForCriterion.planung
				.addProject(SetUpTestDataForCriterion.taschenrechner);
		SetUpTestDataForCriterion.planung
				.addProject(SetUpTestDataForCriterion.textverarbeitung);
		SetUpTestDataForCriterion.test =
				new Team(SetUpTestDataForCriterion.getModel(), "Test");
		SetUpTestDataForCriterion.test
				.addProject(SetUpTestDataForCriterion.taschenrechner);
		SetUpTestDataForCriterion.test
				.addProject(SetUpTestDataForCriterion.textverarbeitung);
		SetUpTestDataForCriterion.ideen =
				new Team(SetUpTestDataForCriterion.getModel(), "Ideen");
		SetUpTestDataForCriterion.ideen
				.addProject(SetUpTestDataForCriterion.taschenrechner);
		SetUpTestDataForCriterion.ideen
				.addProject(SetUpTestDataForCriterion.textverarbeitung);

		SetUpTestDataForCriterion.entwickler.addMember(SetUpTestDataForCriterion
				.getP1());
		SetUpTestDataForCriterion.entwickler.addMember(SetUpTestDataForCriterion
				.getP3());
		SetUpTestDataForCriterion.entwickler.addMember(SetUpTestDataForCriterion.p4);
		SetUpTestDataForCriterion.planung.addMember(SetUpTestDataForCriterion.getP2());
		SetUpTestDataForCriterion.planung.addMember(SetUpTestDataForCriterion.p4);
		SetUpTestDataForCriterion.planung.addMember(SetUpTestDataForCriterion.p5);
		SetUpTestDataForCriterion.planung.addMember(SetUpTestDataForCriterion.p7);
		SetUpTestDataForCriterion.test.addMember(SetUpTestDataForCriterion.getP1());
		SetUpTestDataForCriterion.test.addMember(SetUpTestDataForCriterion.p6);
		SetUpTestDataForCriterion.ideen.addMember(SetUpTestDataForCriterion.getP3());
		SetUpTestDataForCriterion.ideen.addMember(SetUpTestDataForCriterion.p4);
		SetUpTestDataForCriterion.ideen.addMember(SetUpTestDataForCriterion.p6);

		SetUpTestDataForCriterion.sprint1 =
				new Sprint(SetUpTestDataForCriterion.getModel(), "Sprint 1",
						"Beschreibung", new Date(), new Date(),
						SetUpTestDataForCriterion.entwickler,
						SetUpTestDataForCriterion.getTextverarbeitung());
		SetUpTestDataForCriterion.sprint2 =
				new Sprint(SetUpTestDataForCriterion.getModel(), "Sprint 2",
						"Beschreibung", new Date(), new Date(),
						SetUpTestDataForCriterion.entwickler,
						SetUpTestDataForCriterion.getTextverarbeitung());
		SetUpTestDataForCriterion.sprint3 =
				new Sprint(SetUpTestDataForCriterion.getModel(), "Sprint 3",
						"Beschreibung", new Date(), new Date(),
						SetUpTestDataForCriterion.entwickler,
						SetUpTestDataForCriterion.getTextverarbeitung());
		SetUpTestDataForCriterion.sprint4 =
				new Sprint(SetUpTestDataForCriterion.getModel(), "Sprint 4",
						"Beschreibung", new Date(), new Date(),
						SetUpTestDataForCriterion.entwickler,
						SetUpTestDataForCriterion.getTextverarbeitung());

		SetUpTestDataForCriterion.getPbi1()
				.setSprint(SetUpTestDataForCriterion.sprint1);
		SetUpTestDataForCriterion.getPbi2()
				.setSprint(SetUpTestDataForCriterion.sprint2);
		SetUpTestDataForCriterion.getPbi3()
				.setSprint(SetUpTestDataForCriterion.sprint3);
		SetUpTestDataForCriterion.getPbi4()
				.setSprint(SetUpTestDataForCriterion.sprint4);

		SetUpTestDataForCriterion.setRt1(new RelationType(SetUpTestDataForCriterion
				.getModel(), "Abhängig von"));
		SetUpTestDataForCriterion.setRt2(new RelationType(SetUpTestDataForCriterion
				.getModel(), "Fehler zu"));
		SetUpTestDataForCriterion.setRt3(new RelationType(SetUpTestDataForCriterion
				.getModel(), "ausgehend von"));

		SetUpTestDataForCriterion.r1 =
				new Relation(SetUpTestDataForCriterion.getModel(),
						SetUpTestDataForCriterion.getRt1(),
						SetUpTestDataForCriterion.getPbi1());
		SetUpTestDataForCriterion.r2 =
				new Relation(SetUpTestDataForCriterion.getModel(),
						SetUpTestDataForCriterion.getRt2(),
						SetUpTestDataForCriterion.getPbi3());
		SetUpTestDataForCriterion.r3 =
				new Relation(SetUpTestDataForCriterion.getModel(),
						SetUpTestDataForCriterion.getRt3(),
						SetUpTestDataForCriterion.getPbi4());

		SetUpTestDataForCriterion.getPbi2().addRelation(SetUpTestDataForCriterion.r1);
		SetUpTestDataForCriterion.getPbi3().addRelation(SetUpTestDataForCriterion.r1);
		SetUpTestDataForCriterion.getPbi3().addRelation(SetUpTestDataForCriterion.r2);
		SetUpTestDataForCriterion.getPbi4().addRelation(SetUpTestDataForCriterion.r2);

	}

	public static Model getModel() {
		return SetUpTestDataForCriterion.model;
	}

	public static void setRelease1(final Release release1) {
		SetUpTestDataForCriterion.release1 = release1;
	}

	public static Release getRelease1() {
		return SetUpTestDataForCriterion.release1;
	}

	public static void setPbi4(final Bug pbi4) {
		SetUpTestDataForCriterion.pbi4 = pbi4;
	}

	public static Bug getPbi4() {
		return SetUpTestDataForCriterion.pbi4;
	}

	public static void setRelease2(final Release release2) {
		SetUpTestDataForCriterion.release2 = release2;
	}

	public static Release getRelease2() {
		return SetUpTestDataForCriterion.release2;
	}

	public static void setPbi1(final Feature pbi1) {
		SetUpTestDataForCriterion.pbi1 = pbi1;
	}

	public static Feature getPbi1() {
		return SetUpTestDataForCriterion.pbi1;
	}

	public static void setWindowsXP(final System windowsXP) {
		SetUpTestDataForCriterion.windowsXP = windowsXP;
	}

	public static System getWindowsXP() {
		return SetUpTestDataForCriterion.windowsXP;
	}

	public static void setWindows2000(final System windows2000) {
		SetUpTestDataForCriterion.windows2000 = windows2000;
	}

	public static System getWindows2000() {
		return SetUpTestDataForCriterion.windows2000;
	}

	public static void setP3(final Person p3) {
		SetUpTestDataForCriterion.p3 = p3;
	}

	public static Person getP3() {
		return SetUpTestDataForCriterion.p3;
	}

	public static void setP1(final Person p1) {
		SetUpTestDataForCriterion.p1 = p1;
	}

	public static Person getP1() {
		return SetUpTestDataForCriterion.p1;
	}

	public static void setP2(final Person p2) {
		SetUpTestDataForCriterion.p2 = p2;
	}

	public static Person getP2() {
		return SetUpTestDataForCriterion.p2;
	}

	public static void setPbi2(final Feature pbi2) {
		SetUpTestDataForCriterion.pbi2 = pbi2;
	}

	public static Feature getPbi2() {
		return SetUpTestDataForCriterion.pbi2;
	}

	public static void setPbi3(final Feature pbi3) {
		SetUpTestDataForCriterion.pbi3 = pbi3;
	}

	public static Feature getPbi3() {
		return SetUpTestDataForCriterion.pbi3;
	}

	public static void setRt2(final RelationType rt2) {
		SetUpTestDataForCriterion.rt2 = rt2;
	}

	public static RelationType getRt2() {
		return SetUpTestDataForCriterion.rt2;
	}

	public static void setRt3(final RelationType rt3) {
		SetUpTestDataForCriterion.rt3 = rt3;
	}

	public static RelationType getRt3() {
		return SetUpTestDataForCriterion.rt3;
	}

	public static void setRt1(final RelationType rt1) {
		SetUpTestDataForCriterion.rt1 = rt1;
	}

	public static RelationType getRt1() {
		return SetUpTestDataForCriterion.rt1;
	}

	public static void setTextverarbeitung(final Project textverarbeitung) {
		SetUpTestDataForCriterion.textverarbeitung = textverarbeitung;
	}

	public static Project getTextverarbeitung() {
		return SetUpTestDataForCriterion.textverarbeitung;
	}

	public static void setTaschenrechner(final Project taschenrechner) {
		SetUpTestDataForCriterion.taschenrechner = taschenrechner;
	}

	public static Project getTaschenrechner() {
		return SetUpTestDataForCriterion.taschenrechner;
	}
}
