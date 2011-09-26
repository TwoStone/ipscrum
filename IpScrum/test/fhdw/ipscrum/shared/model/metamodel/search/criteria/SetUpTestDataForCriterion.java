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

/**
 * Sets up the data for the criterion test needed to test the search.
 */
public abstract class SetUpTestDataForCriterion {
	/**
	 * Represents the model needed for using the IPScrum.
	 */
	private static Model model;
	/**
	 * Represents the project textverarbeitung needed for testing the IPScrum.
	 */
	private static Project textverarbeitung = null;
	/**
	 * Represents the productBacklog pbltext needed for testing the IPScrum.
	 */
	private static ProductBacklog pbltext = null;
	/**
	 * Represents the system betriebssystem needed for testing the IPScrum.
	 */
	private static System betriebssystem = null;
	/**
	 * Represents the system windowsXP needed for testing the IPScrum.
	 */
	private static System windowsXP = null;
	/**
	 * Represents the system windows2000 needed for testing the IPScrum.
	 */
	private static System windows2000 = null;
	/**
	 * Represents the system windowsVista needed for testing the IPScrum.
	 */
	private static System windowsVista = null;
	/**
	 * Represents the system windows7 needed for testing the IPScrum.
	 */
	private static System windows7 = null;
	/**
	 * Represents the system linux needed for testing the IPScrum.
	 */
	private static System linux = null;
	/**
	 * Represents the release release1 needed for testing the IPScrum.
	 */
	private static Release release1 = null;
	/**
	 * Represents the release release2 needed for testing the IPScrum.
	 */
	private static Release release2 = null;
	/**
	 * Represents the feature pbi1 needed for testing the IPScrum.
	 */
	private static Feature pbi1 = null;
	/**
	 * Represents the feature pbi2 needed for testing the IPScrum.
	 */
	private static Feature pbi2 = null;
	/**
	 * Represents the feature pbi3 needed for testing the IPScrum.
	 */
	private static Feature pbi3 = null;
	/**
	 * Represents the bug pbi4 needed for testing the IPScrum.
	 */
	private static Bug pbi4 = null;
	/**
	 * Represents the person p1 needed for testing the IPScrum.
	 */
	private static Person p1 = null;
	/**
	 * Represents the person p2 needed for testing the IPScrum.
	 */
	private static Person p2 = null;
	/**
	 * Represents the person p3 needed for testing the IPScrum.
	 */
	private static Person p3 = null;
	/**
	 * Represents the person p4 needed for testing the IPScrum.
	 */
	private static Person p4 = null;
	/**
	 * Represents the person p5 needed for testing the IPScrum.
	 */
	private static Person p5 = null;
	/**
	 * Represents the person p6 needed for testing the IPScrum.
	 */
	private static Person p6 = null;
	/**
	 * Represents the person p7 needed for testing the IPScrum.
	 */
	private static Person p7 = null;
	/**
	 * Represents the team entwickler needed for testing the IPScrum.
	 */
	private static Team entwickler = null;
	/**
	 * Represents the team planung needed for testing the IPScrum.
	 */
	private static Team planung = null;
	/**
	 * Represents the team test needed for testing the IPScrum.
	 */
	private static Team test = null;
	/**
	 * Represents the team ideen needed for testing the IPScrum.
	 */
	private static Team ideen = null;
	/**
	 * Represents the sprint sprint1 needed for testing the IPScrum.
	 */
	private static Sprint sprint1 = null;
	/**
	 * Represents the sprint sprint2 needed for testing the IPScrum.
	 */
	private static Sprint sprint2 = null;
	/**
	 * Represents the sprint sprint3 needed for testing the IPScrum.
	 */
	private static Sprint sprint3 = null;
	/**
	 * Represents the sprint sprint4 needed for testing the IPScrum.
	 */
	private static Sprint sprint4 = null;
	/**
	 * Represents the relationType rt1 needed for testing the IPScrum.
	 */
	private static RelationType rt1 = null;
	/**
	 * Represents the relationType rt2 needed for testing the IPScrum.
	 */
	private static RelationType rt2 = null;
	/**
	 * Represents the relationType rt3 needed for testing the IPScrum.
	 */
	private static RelationType rt3 = null;
	/**
	 * Represents the relation r1 needed for testing the IPScrum.
	 */
	private static Relation r1 = null;
	/**
	 * Represents the relation r2 needed for testing the IPScrum.
	 */
	private static Relation r2 = null;
	/**
	 * Represents the relation r3 needed for testing the IPScrum.
	 */
	private static Relation r3 = null;
	/**
	 * Represents the project taschenrechner needed for testing the IPScrum.
	 */
	private static Project taschenrechner = null;

	/**
	 * Sets up the data before the class.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		TestUtils.deleteFolderContent(new File("output"));
		ServerContext.resetServerContext();
		SetUpTestDataForCriterion.model = ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		SetUpTestDataForCriterion.model.setUuidManager(new IDGenerator());
		SetUpTestDataForCriterion.setTextverarbeitung(new Project(SetUpTestDataForCriterion.getModel(),
				"Textverarbeitung"));
		SetUpTestDataForCriterion
				.setTaschenrechner(new Project(SetUpTestDataForCriterion.getModel(), "Taschenrechner"));
		SetUpTestDataForCriterion.pbltext = SetUpTestDataForCriterion.getTextverarbeitung().getBacklog();
		SetUpTestDataForCriterion.setRelease1(new Release(SetUpTestDataForCriterion.getModel(), "Release 1",
				new Date(), SetUpTestDataForCriterion.getTextverarbeitung()));
		SetUpTestDataForCriterion.setRelease2(new Release(SetUpTestDataForCriterion.getModel(), "Release 2",
				new Date(), SetUpTestDataForCriterion.getTextverarbeitung()));
		SetUpTestDataForCriterion.betriebssystem =
				new System(SetUpTestDataForCriterion.getModel(), "Betriebssystem",
						SetUpTestDataForCriterion.model.getRootsystem());
		SetUpTestDataForCriterion.setWindowsXP(new System(SetUpTestDataForCriterion.getModel(), "Windows XP",
				SetUpTestDataForCriterion.betriebssystem));
		SetUpTestDataForCriterion.setWindows2000(new System(SetUpTestDataForCriterion.getModel(), "Windows 2000",
				SetUpTestDataForCriterion.betriebssystem));
		SetUpTestDataForCriterion.windowsVista =
				new System(SetUpTestDataForCriterion.getModel(), "Windows Vista",
						SetUpTestDataForCriterion.betriebssystem);
		SetUpTestDataForCriterion.windows7 =
				new System(SetUpTestDataForCriterion.getModel(), "Windows 7", SetUpTestDataForCriterion.betriebssystem);
		SetUpTestDataForCriterion.linux =
				new System(SetUpTestDataForCriterion.getModel(), "Linux", SetUpTestDataForCriterion.betriebssystem);
		SetUpTestDataForCriterion.getTextverarbeitung().addSystem(SetUpTestDataForCriterion.betriebssystem);
		SetUpTestDataForCriterion.getTextverarbeitung().addSystem(SetUpTestDataForCriterion.getWindowsXP());
		SetUpTestDataForCriterion.getTextverarbeitung().addSystem(SetUpTestDataForCriterion.getWindows2000());
		SetUpTestDataForCriterion.getTextverarbeitung().addSystem(SetUpTestDataForCriterion.windowsVista);
		SetUpTestDataForCriterion.getTextverarbeitung().addSystem(SetUpTestDataForCriterion.windows7);
		SetUpTestDataForCriterion.getTextverarbeitung().addSystem(SetUpTestDataForCriterion.linux);
		// TODO: Feature erstellen
		SetUpTestDataForCriterion.setPbi1(new Feature(SetUpTestDataForCriterion.getModel(),
				SetUpTestDataForCriterion.model.getTypeManager().getStandardFeatureType(), "Texte eingeben",
				"Texte im Programm erfassen", SetUpTestDataForCriterion.pbltext));
		SetUpTestDataForCriterion.pbi2 =
				new Feature(SetUpTestDataForCriterion.getModel(), SetUpTestDataForCriterion.model.getTypeManager()
						.getStandardFeatureType(), "Textbearbeitung", "Texte bearbeiten",
						SetUpTestDataForCriterion.pbltext);
		SetUpTestDataForCriterion.pbi3 =
				new Feature(SetUpTestDataForCriterion.getModel(), SetUpTestDataForCriterion.model.getTypeManager()
						.getStandardFeatureType(), "Farben", "Farbige Markierungen ermöglichen",
						SetUpTestDataForCriterion.pbltext);
		SetUpTestDataForCriterion.setPbi4(new Bug(SetUpTestDataForCriterion.getModel(), SetUpTestDataForCriterion.model
				.getTypeManager().getStandardBugType(), "Fehler bei Farben", "Darstellung der Farben fehlerhaft",
				SetUpTestDataForCriterion.pbltext, SetUpTestDataForCriterion.getRelease1()));

		SetUpTestDataForCriterion.getPbi1().addHint("Groß-/Kleinschreibung, Zahlen, Sonderzeichen");
		SetUpTestDataForCriterion.getPbi2().addHint("fett, unterstrichen, kursiv, farbig");
		SetUpTestDataForCriterion.getPbi3().addHint(
				"Farben für Texte und Hintergründe definieren; Option ergänzen, dass Farben eingefügt werden können");
		SetUpTestDataForCriterion.getPbi4().addHint("werden bei unterschiedlichen Systemen anders angezeigt");

		SetUpTestDataForCriterion.getPbi4().addSystem(SetUpTestDataForCriterion.betriebssystem);
		SetUpTestDataForCriterion.getPbi4().addSystem(SetUpTestDataForCriterion.windows7);
		SetUpTestDataForCriterion.getPbi4().addSystem(SetUpTestDataForCriterion.linux);
		SetUpTestDataForCriterion.getPbi4().addSystem(SetUpTestDataForCriterion.getWindowsXP());

		SetUpTestDataForCriterion.getPbi1().setManDayCosts(new Effort(10));
		SetUpTestDataForCriterion.getPbi2().setManDayCosts(new Effort(7));
		SetUpTestDataForCriterion.getPbi3().setManDayCosts(new Effort(3));
		SetUpTestDataForCriterion.getPbi4().setManDayCosts(new Effort(5));

		SetUpTestDataForCriterion.pbltext.addItem(SetUpTestDataForCriterion.getPbi1());
		SetUpTestDataForCriterion.pbltext.addItem(SetUpTestDataForCriterion.getPbi2());
		SetUpTestDataForCriterion.pbltext.addItem(SetUpTestDataForCriterion.getPbi3());
		SetUpTestDataForCriterion.pbltext.addItem(SetUpTestDataForCriterion.getPbi4());

		SetUpTestDataForCriterion.setP1(new Person(SetUpTestDataForCriterion.getModel(), "Max", "Mustermann"));
		SetUpTestDataForCriterion.setP2(new Person(SetUpTestDataForCriterion.getModel(), "Petra", "Plüsch"));
		SetUpTestDataForCriterion.setP3(new Person(SetUpTestDataForCriterion.getModel(), "Michel", "Meier"));
		SetUpTestDataForCriterion.p4 = new Person(SetUpTestDataForCriterion.getModel(), "Michel", "Mayer");
		SetUpTestDataForCriterion.p5 = new Person(SetUpTestDataForCriterion.getModel(), "Maximilian", "Schulz");
		SetUpTestDataForCriterion.p6 = new Person(SetUpTestDataForCriterion.getModel(), "Klaus", "Krüger");
		SetUpTestDataForCriterion.p7 = new Person(SetUpTestDataForCriterion.getModel(), "Joachim", "Krüger");

		SetUpTestDataForCriterion.entwickler = new Team(SetUpTestDataForCriterion.getModel(), "Entwickler");
		SetUpTestDataForCriterion.entwickler.addProject(SetUpTestDataForCriterion.taschenrechner);
		SetUpTestDataForCriterion.entwickler.addProject(SetUpTestDataForCriterion.textverarbeitung);
		SetUpTestDataForCriterion.planung = new Team(SetUpTestDataForCriterion.getModel(), "Planung");
		SetUpTestDataForCriterion.planung.addProject(SetUpTestDataForCriterion.taschenrechner);
		SetUpTestDataForCriterion.planung.addProject(SetUpTestDataForCriterion.textverarbeitung);
		SetUpTestDataForCriterion.test = new Team(SetUpTestDataForCriterion.getModel(), "Test");
		SetUpTestDataForCriterion.test.addProject(SetUpTestDataForCriterion.taschenrechner);
		SetUpTestDataForCriterion.test.addProject(SetUpTestDataForCriterion.textverarbeitung);
		SetUpTestDataForCriterion.ideen = new Team(SetUpTestDataForCriterion.getModel(), "Ideen");
		SetUpTestDataForCriterion.ideen.addProject(SetUpTestDataForCriterion.taschenrechner);
		SetUpTestDataForCriterion.ideen.addProject(SetUpTestDataForCriterion.textverarbeitung);

		SetUpTestDataForCriterion.entwickler.addMember(SetUpTestDataForCriterion.getP1());
		SetUpTestDataForCriterion.entwickler.addMember(SetUpTestDataForCriterion.getP3());
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
				new Sprint(SetUpTestDataForCriterion.getModel(), "Sprint 1", "Beschreibung", new Date(), new Date(),
						SetUpTestDataForCriterion.entwickler, SetUpTestDataForCriterion.getTextverarbeitung());
		SetUpTestDataForCriterion.sprint2 =
				new Sprint(SetUpTestDataForCriterion.getModel(), "Sprint 2", "Beschreibung", new Date(), new Date(),
						SetUpTestDataForCriterion.entwickler, SetUpTestDataForCriterion.getTextverarbeitung());
		SetUpTestDataForCriterion.sprint3 =
				new Sprint(SetUpTestDataForCriterion.getModel(), "Sprint 3", "Beschreibung", new Date(), new Date(),
						SetUpTestDataForCriterion.entwickler, SetUpTestDataForCriterion.getTextverarbeitung());
		SetUpTestDataForCriterion.sprint4 =
				new Sprint(SetUpTestDataForCriterion.getModel(), "Sprint 4", "Beschreibung", new Date(), new Date(),
						SetUpTestDataForCriterion.entwickler, SetUpTestDataForCriterion.getTextverarbeitung());

		SetUpTestDataForCriterion.getPbi1().setSprint(SetUpTestDataForCriterion.sprint1);
		SetUpTestDataForCriterion.getPbi2().setSprint(SetUpTestDataForCriterion.sprint2);
		SetUpTestDataForCriterion.getPbi3().setSprint(SetUpTestDataForCriterion.sprint3);
		SetUpTestDataForCriterion.getPbi4().setSprint(SetUpTestDataForCriterion.sprint4);

		SetUpTestDataForCriterion.setRt1(new RelationType(SetUpTestDataForCriterion.getModel(), "Abhängig von"));
		SetUpTestDataForCriterion.setRt2(new RelationType(SetUpTestDataForCriterion.getModel(), "Fehler zu"));
		SetUpTestDataForCriterion.setRt3(new RelationType(SetUpTestDataForCriterion.getModel(), "ausgehend von"));

		SetUpTestDataForCriterion.r1 =
				new Relation(SetUpTestDataForCriterion.getModel(), SetUpTestDataForCriterion.getRt1(),
						SetUpTestDataForCriterion.getPbi1());
		SetUpTestDataForCriterion.r2 =
				new Relation(SetUpTestDataForCriterion.getModel(), SetUpTestDataForCriterion.getRt2(),
						SetUpTestDataForCriterion.getPbi3());
		SetUpTestDataForCriterion.setR3(new Relation(SetUpTestDataForCriterion.getModel(), SetUpTestDataForCriterion
				.getRt3(), SetUpTestDataForCriterion.getPbi4()));

		SetUpTestDataForCriterion.getPbi2().addRelation(SetUpTestDataForCriterion.r1);
		SetUpTestDataForCriterion.getPbi3().addRelation(SetUpTestDataForCriterion.r1);
		SetUpTestDataForCriterion.getPbi3().addRelation(SetUpTestDataForCriterion.r2);
		SetUpTestDataForCriterion.getPbi4().addRelation(SetUpTestDataForCriterion.r2);

	}

	/**
	 * @return the model needed for using the IPScrum.
	 */
	public static Model getModel() {
		return SetUpTestDataForCriterion.model;
	}

	/**
	 * Sets the release Release1.
	 * 
	 * @param release1
	 *            is the release to set
	 */
	public static void setRelease1(final Release release1) {
		SetUpTestDataForCriterion.release1 = release1;
	}

	/**
	 * @return the release Release1.
	 */
	public static Release getRelease1() {
		return SetUpTestDataForCriterion.release1;
	}

	/**
	 * Sets the Bug Pbi4.
	 * 
	 * @param pbi4
	 *            is the Bug to set
	 */
	public static void setPbi4(final Bug pbi4) {
		SetUpTestDataForCriterion.pbi4 = pbi4;
	}

	/**
	 * @return the Bug Pbi4.
	 */
	public static Bug getPbi4() {
		return SetUpTestDataForCriterion.pbi4;
	}

	/**
	 * Sets the release Release2.
	 * 
	 * @param release2
	 *            is the release to set
	 */
	public static void setRelease2(final Release release2) {
		SetUpTestDataForCriterion.release2 = release2;
	}

	/**
	 * @return the release Release2.
	 */
	public static Release getRelease2() {
		return SetUpTestDataForCriterion.release2;
	}

	/**
	 * Sets the feature Pbi1.
	 * 
	 * @param pbi1
	 *            is the feature to set
	 */
	public static void setPbi1(final Feature pbi1) {
		SetUpTestDataForCriterion.pbi1 = pbi1;
	}

	/**
	 * @return the feature Pbi1.
	 */
	public static Feature getPbi1() {
		return SetUpTestDataForCriterion.pbi1;
	}

	/**
	 * Sets the system WindowsXP.
	 * 
	 * @param windowsXP
	 *            is the system to set
	 */
	public static void setWindowsXP(final System windowsXP) {
		SetUpTestDataForCriterion.windowsXP = windowsXP;
	}

	/**
	 * @return the system WindowsXP.
	 */
	public static System getWindowsXP() {
		return SetUpTestDataForCriterion.windowsXP;
	}

	/**
	 * Sets the system Windows2000.
	 * 
	 * @param windows2000
	 *            is the system to set
	 */
	public static void setWindows2000(final System windows2000) {
		SetUpTestDataForCriterion.windows2000 = windows2000;
	}

	/**
	 * @return the system Windows2000.
	 */
	public static System getWindows2000() {
		return SetUpTestDataForCriterion.windows2000;
	}

	/**
	 * Sets the person P3.
	 * 
	 * @param p3
	 *            is the person to set
	 */
	public static void setP3(final Person p3) {
		SetUpTestDataForCriterion.p3 = p3;
	}

	/**
	 * @return the person P3.
	 */
	public static Person getP3() {
		return SetUpTestDataForCriterion.p3;
	}

	/**
	 * Sets the person P1.
	 * 
	 * @param p1
	 *            is the person to set
	 */
	public static void setP1(final Person p1) {
		SetUpTestDataForCriterion.p1 = p1;
	}

	/**
	 * @return the person P1.
	 */
	public static Person getP1() {
		return SetUpTestDataForCriterion.p1;
	}

	/**
	 * Sets the person P2.
	 * 
	 * @param p2
	 *            is the person to set
	 */
	public static void setP2(final Person p2) {
		SetUpTestDataForCriterion.p2 = p2;
	}

	/**
	 * @return the person P2.
	 */
	public static Person getP2() {
		return SetUpTestDataForCriterion.p2;
	}

	/**
	 * Sets the feature Pbi2.
	 * 
	 * @param pbi2
	 *            is the feature to set
	 */
	public static void setPbi2(final Feature pbi2) {
		SetUpTestDataForCriterion.pbi2 = pbi2;
	}

	/**
	 * @return the feature Pbi2.
	 */
	public static Feature getPbi2() {
		return SetUpTestDataForCriterion.pbi2;
	}

	/**
	 * Sets the feature Pbi3.
	 * 
	 * @param pbi3
	 *            the feature to set
	 */
	public static void setPbi3(final Feature pbi3) {
		SetUpTestDataForCriterion.pbi3 = pbi3;
	}

	/**
	 * @return the feature Pbi3.
	 */
	public static Feature getPbi3() {
		return SetUpTestDataForCriterion.pbi3;
	}

	/**
	 * Sets the relationType Rt2.
	 * 
	 * @param rt2
	 *            is the type to set
	 */
	public static void setRt2(final RelationType rt2) {
		SetUpTestDataForCriterion.rt2 = rt2;
	}

	/**
	 * @return the realtionType Rt2.
	 */
	public static RelationType getRt2() {
		return SetUpTestDataForCriterion.rt2;
	}

	/**
	 * Sets the realationType Rt3.
	 * 
	 * @param rt3
	 *            is the type to set.
	 */
	public static void setRt3(final RelationType rt3) {
		SetUpTestDataForCriterion.rt3 = rt3;
	}

	/**
	 * @return the relationType Rt3.
	 */
	public static RelationType getRt3() {
		return SetUpTestDataForCriterion.rt3;
	}

	/**
	 * Sets the realtionType Rt1.
	 * 
	 * @param rt1
	 *            is the type to set
	 */
	public static void setRt1(final RelationType rt1) {
		SetUpTestDataForCriterion.rt1 = rt1;
	}

	/**
	 * @return the realtionType Rt1.
	 */
	public static RelationType getRt1() {
		return SetUpTestDataForCriterion.rt1;
	}

	/**
	 * Sets the project textverarbeitung.
	 * 
	 * @param textverarbeitung
	 *            is the project to set
	 */
	public static void setTextverarbeitung(final Project textverarbeitung) {
		SetUpTestDataForCriterion.textverarbeitung = textverarbeitung;
	}

	/**
	 * @return the project textverarbeitung.
	 */
	public static Project getTextverarbeitung() {
		return SetUpTestDataForCriterion.textverarbeitung;
	}

	/**
	 * Sets the project taschenrechner.
	 * 
	 * @param taschenrechner
	 *            is the project to set
	 */
	public static void setTaschenrechner(final Project taschenrechner) {
		SetUpTestDataForCriterion.taschenrechner = taschenrechner;
	}

	/**
	 * @return the project taschenrechner.
	 */
	public static Project getTaschenrechner() {
		return SetUpTestDataForCriterion.taschenrechner;
	}

	/**
	 * @param r3
	 *            the r3 to set
	 */
	public static void setR3(final Relation r3) {
		SetUpTestDataForCriterion.r3 = r3;
	}

	/**
	 * @return the r3
	 */
	public static Relation getR3() {
		return SetUpTestDataForCriterion.r3;
	}
}
