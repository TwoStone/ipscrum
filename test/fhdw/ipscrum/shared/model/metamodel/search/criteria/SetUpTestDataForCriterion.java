package fhdw.ipscrum.shared.model.metamodel.search.criteria;

import java.io.File;
import java.util.Date;

import org.junit.Before;

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
	private Model model;
	/**
	 * Represents the project textverarbeitung needed for testing the IPScrum.
	 */
	private Project textverarbeitung = null;
	/**
	 * Represents the productBacklog pbltext needed for testing the IPScrum.
	 */
	private ProductBacklog pbltext = null;
	/**
	 * Represents the system betriebssystem needed for testing the IPScrum.
	 */
	private System betriebssystem = null;
	/**
	 * Represents the system windowsXP needed for testing the IPScrum.
	 */
	private System windowsXP = null;
	/**
	 * Represents the system windows2000 needed for testing the IPScrum.
	 */
	private System windows2000 = null;
	/**
	 * Represents the system windowsVista needed for testing the IPScrum.
	 */
	private System windowsVista = null;
	/**
	 * Represents the system windows7 needed for testing the IPScrum.
	 */
	private System windows7 = null;
	/**
	 * Represents the system linux needed for testing the IPScrum.
	 */
	private System linux = null;
	/**
	 * Represents the release release1 needed for testing the IPScrum.
	 */
	private Release release1 = null;
	/**
	 * Represents the release release2 needed for testing the IPScrum.
	 */
	private Release release2 = null;
	/**
	 * Represents the feature pbi1 needed for testing the IPScrum.
	 */
	private Feature pbi1 = null;
	/**
	 * Represents the feature pbi2 needed for testing the IPScrum.
	 */
	private Feature pbi2 = null;
	/**
	 * Represents the feature pbi3 needed for testing the IPScrum.
	 */
	private Feature pbi3 = null;
	/**
	 * Represents the bug pbi4 needed for testing the IPScrum.
	 */
	private Bug pbi4 = null;
	/**
	 * Represents the person p1 needed for testing the IPScrum.
	 */
	private Person p1 = null;
	/**
	 * Represents the person p2 needed for testing the IPScrum.
	 */
	private Person p2 = null;
	/**
	 * Represents the person p3 needed for testing the IPScrum.
	 */
	private Person p3 = null;
	/**
	 * Represents the person p4 needed for testing the IPScrum.
	 */
	private Person p4 = null;
	/**
	 * Represents the person p5 needed for testing the IPScrum.
	 */
	private Person p5 = null;
	/**
	 * Represents the person p6 needed for testing the IPScrum.
	 */
	private Person p6 = null;
	/**
	 * Represents the person p7 needed for testing the IPScrum.
	 */
	private Person p7 = null;
	/**
	 * Represents the team entwickler needed for testing the IPScrum.
	 */
	private Team entwickler = null;
	/**
	 * Represents the team planung needed for testing the IPScrum.
	 */
	private Team planung = null;
	/**
	 * Represents the team test needed for testing the IPScrum.
	 */
	private Team test = null;
	/**
	 * Represents the team ideen needed for testing the IPScrum.
	 */
	private Team ideen = null;
	/**
	 * Represents the sprint sprint1 needed for testing the IPScrum.
	 */
	private Sprint sprint1 = null;
	/**
	 * Represents the sprint sprint2 needed for testing the IPScrum.
	 */
	private Sprint sprint2 = null;
	/**
	 * Represents the sprint sprint3 needed for testing the IPScrum.
	 */
	private Sprint sprint3 = null;
	/**
	 * Represents the sprint sprint4 needed for testing the IPScrum.
	 */
	private Sprint sprint4 = null;
	/**
	 * Represents the relationType rt1 needed for testing the IPScrum.
	 */
	private RelationType rt1 = null;
	/**
	 * Represents the relationType rt2 needed for testing the IPScrum.
	 */
	private RelationType rt2 = null;
	/**
	 * Represents the relationType rt3 needed for testing the IPScrum.
	 */
	private RelationType rt3 = null;
	/**
	 * Represents the relation r1 needed for testing the IPScrum.
	 */
	private Relation r1 = null;
	/**
	 * Represents the relation r2 needed for testing the IPScrum.
	 */
	private Relation r2 = null;
	/**
	 * Represents the relation r3 needed for testing the IPScrum.
	 */
	private Relation r3 = null;
	/**
	 * Represents the project taschenrechner needed for testing the IPScrum.
	 */
	private Project taschenrechner = null;

	/**
	 * Sets up the data before the class.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Before
	public void setUpBefore() throws Exception {
		TestUtils.deleteFolderContent(new File("output"));
		ServerContext.resetServerContext();
		this.model = ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		this.model.setUuidManager(new IDGenerator());
		this.setTextverarbeitung(new Project(this.getModel(), "Textverarbeitung"));
		this.setTaschenrechner(new Project(this.getModel(), "Taschenrechner"));
		this.pbltext = this.getTextverarbeitung().getBacklog();
		this.setRelease1(new Release(this.getModel(), "Release 1", new Date(), this.getTextverarbeitung()));
		this.setRelease2(new Release(this.getModel(), "Release 2", new Date(), this.getTextverarbeitung()));
		this.betriebssystem = new System(this.getModel(), "Betriebssystem", this.model.getRootsystem());
		this.setWindowsXP(new System(this.getModel(), "Windows XP", this.betriebssystem));
		this.setWindows2000(new System(this.getModel(), "Windows 2000", this.betriebssystem));
		this.windowsVista = new System(this.getModel(), "Windows Vista", this.betriebssystem);
		this.windows7 = new System(this.getModel(), "Windows 7", this.betriebssystem);
		this.linux = new System(this.getModel(), "Linux", this.betriebssystem);
		this.getTextverarbeitung().addSystem(this.betriebssystem);
		this.getTextverarbeitung().addSystem(this.getWindowsXP());
		this.getTextverarbeitung().addSystem(this.getWindows2000());
		this.getTextverarbeitung().addSystem(this.windowsVista);
		this.getTextverarbeitung().addSystem(this.windows7);
		this.getTextverarbeitung().addSystem(this.linux);
		// TODO: Feature erstellen
		this.setPbi1(new Feature(this.getModel(), this.model.getTypeManager().getStandardFeatureType(),
				"Texte eingeben", "Texte im Programm erfassen", this.pbltext));
		this.pbi2 =
				new Feature(this.getModel(), this.model.getTypeManager().getStandardFeatureType(), "Textbearbeitung",
						"Texte bearbeiten", this.pbltext);
		this.pbi3 =
				new Feature(this.getModel(), this.model.getTypeManager().getStandardFeatureType(), "Farben",
						"Farbige Markierungen ermöglichen", this.pbltext);
		this.setPbi4(new Bug(this.getModel(), this.model.getTypeManager().getStandardBugType(), "Fehler bei Farben",
				"Darstellung der Farben fehlerhaft", this.pbltext, this.getRelease1()));

		this.getPbi1().addHint("Groß-/Kleinschreibung, Zahlen, Sonderzeichen");
		this.getPbi2().addHint("fett, unterstrichen, kursiv, farbig");
		this.getPbi3().addHint(
				"Farben für Texte und Hintergründe definieren; Option ergänzen, dass Farben eingefügt werden können");
		this.getPbi4().addHint("werden bei unterschiedlichen Systemen anders angezeigt");

		this.getPbi4().addSystem(this.betriebssystem);
		this.getPbi4().addSystem(this.windows7);
		this.getPbi4().addSystem(this.linux);
		this.getPbi4().addSystem(this.getWindowsXP());

		this.getPbi1().setManDayCosts(new Effort(10));
		this.getPbi2().setManDayCosts(new Effort(7));
		this.getPbi3().setManDayCosts(new Effort(3));
		this.getPbi4().setManDayCosts(new Effort(5));

		this.pbltext.addItem(this.getPbi1());
		this.pbltext.addItem(this.getPbi2());
		this.pbltext.addItem(this.getPbi3());
		this.pbltext.addItem(this.getPbi4());

		this.setP1(new Person(this.getModel(), "Max", "Mustermann"));
		this.setP2(new Person(this.getModel(), "Petra", "Plüsch"));
		this.setP3(new Person(this.getModel(), "Michel", "Meier"));
		this.p4 = new Person(this.getModel(), "Michel", "Mayer");
		this.p5 = new Person(this.getModel(), "Maximilian", "Schulz");
		this.p6 = new Person(this.getModel(), "Klaus", "Krüger");
		this.p7 = new Person(this.getModel(), "Joachim", "Krüger");

		this.entwickler = new Team(this.getModel(), "Entwickler");
		this.entwickler.addProject(this.taschenrechner);
		this.entwickler.addProject(this.textverarbeitung);
		this.planung = new Team(this.getModel(), "Planung");
		this.planung.addProject(this.taschenrechner);
		this.planung.addProject(this.textverarbeitung);
		this.test = new Team(this.getModel(), "Test");
		this.test.addProject(this.taschenrechner);
		this.test.addProject(this.textverarbeitung);
		this.ideen = new Team(this.getModel(), "Ideen");
		this.ideen.addProject(this.taschenrechner);
		this.ideen.addProject(this.textverarbeitung);

		this.entwickler.addMember(this.getP1());
		this.entwickler.addMember(this.getP3());
		this.entwickler.addMember(this.p4);
		this.planung.addMember(this.getP2());
		this.planung.addMember(this.p4);
		this.planung.addMember(this.p5);
		this.planung.addMember(this.p7);
		this.test.addMember(this.getP1());
		this.test.addMember(this.p6);
		this.ideen.addMember(this.getP3());
		this.ideen.addMember(this.p4);
		this.ideen.addMember(this.p6);

		this.sprint1 =
				new Sprint(this.getModel(), "Sprint 1", "Beschreibung", new Date(), new Date(), this.entwickler,
						this.getTextverarbeitung());
		this.sprint2 =
				new Sprint(this.getModel(), "Sprint 2", "Beschreibung", new Date(), new Date(), this.entwickler,
						this.getTextverarbeitung());
		this.sprint3 =
				new Sprint(this.getModel(), "Sprint 3", "Beschreibung", new Date(), new Date(), this.entwickler,
						this.getTextverarbeitung());
		this.sprint4 =
				new Sprint(this.getModel(), "Sprint 4", "Beschreibung", new Date(), new Date(), this.entwickler,
						this.getTextverarbeitung());

		this.getPbi1().setSprint(this.sprint1);
		this.getPbi2().setSprint(this.sprint2);
		this.getPbi3().setSprint(this.sprint3);
		this.getPbi4().setSprint(this.sprint4);

		this.setRt1(new RelationType(this.getModel(), "Abhängig von"));
		this.setRt2(new RelationType(this.getModel(), "Fehler zu"));
		this.setRt3(new RelationType(this.getModel(), "ausgehend von"));

		this.r1 = new Relation(this.getModel(), this.getRt1(), this.getPbi1());
		this.r2 = new Relation(this.getModel(), this.getRt2(), this.getPbi3());
		this.setR3(new Relation(this.getModel(), this.getRt3(), this.getPbi4()));

		this.getPbi2().addRelation(this.r1);
		this.getPbi3().addRelation(this.r1);
		this.getPbi3().addRelation(this.r2);
		this.getPbi4().addRelation(this.r2);

	}

	/**
	 * @return the model needed for using the IPScrum.
	 */
	public Model getModel() {
		return this.model;
	}

	/**
	 * Sets the release Release1.
	 * 
	 * @param release1
	 *            is the release to set
	 */
	public void setRelease1(final Release release1) {
		this.release1 = release1;
	}

	/**
	 * @return the release Release1.
	 */
	public Release getRelease1() {
		return this.release1;
	}

	/**
	 * Sets the Bug Pbi4.
	 * 
	 * @param pbi4
	 *            is the Bug to set
	 */
	public void setPbi4(final Bug pbi4) {
		this.pbi4 = pbi4;
	}

	/**
	 * @return the Bug Pbi4.
	 */
	public Bug getPbi4() {
		return this.pbi4;
	}

	/**
	 * Sets the release Release2.
	 * 
	 * @param release2
	 *            is the release to set
	 */
	public void setRelease2(final Release release2) {
		this.release2 = release2;
	}

	/**
	 * @return the release Release2.
	 */
	public Release getRelease2() {
		return this.release2;
	}

	/**
	 * Sets the feature Pbi1.
	 * 
	 * @param pbi1
	 *            is the feature to set
	 */
	public void setPbi1(final Feature pbi1) {
		this.pbi1 = pbi1;
	}

	/**
	 * @return the feature Pbi1.
	 */
	public Feature getPbi1() {
		return this.pbi1;
	}

	/**
	 * Sets the system WindowsXP.
	 * 
	 * @param windowsXP
	 *            is the system to set
	 */
	public void setWindowsXP(final System windowsXP) {
		this.windowsXP = windowsXP;
	}

	/**
	 * @return the system WindowsXP.
	 */
	public System getWindowsXP() {
		return this.windowsXP;
	}

	/**
	 * Sets the system Windows2000.
	 * 
	 * @param windows2000
	 *            is the system to set
	 */
	public void setWindows2000(final System windows2000) {
		this.windows2000 = windows2000;
	}

	/**
	 * @return the system Windows2000.
	 */
	public System getWindows2000() {
		return this.windows2000;
	}

	/**
	 * Sets the person P3.
	 * 
	 * @param p3
	 *            is the person to set
	 */
	public void setP3(final Person p3) {
		this.p3 = p3;
	}

	/**
	 * @return the person P3.
	 */
	public Person getP3() {
		return this.p3;
	}

	/**
	 * Sets the person P1.
	 * 
	 * @param p1
	 *            is the person to set
	 */
	public void setP1(final Person p1) {
		this.p1 = p1;
	}

	/**
	 * @return the person P1.
	 */
	public Person getP1() {
		return this.p1;
	}

	/**
	 * Sets the person P2.
	 * 
	 * @param p2
	 *            is the person to set
	 */
	public void setP2(final Person p2) {
		this.p2 = p2;
	}

	/**
	 * @return the person P2.
	 */
	public Person getP2() {
		return this.p2;
	}

	/**
	 * Sets the feature Pbi2.
	 * 
	 * @param pbi2
	 *            is the feature to set
	 */
	public void setPbi2(final Feature pbi2) {
		this.pbi2 = pbi2;
	}

	/**
	 * @return the feature Pbi2.
	 */
	public Feature getPbi2() {
		return this.pbi2;
	}

	/**
	 * Sets the feature Pbi3.
	 * 
	 * @param pbi3
	 *            the feature to set
	 */
	public void setPbi3(final Feature pbi3) {
		this.pbi3 = pbi3;
	}

	/**
	 * @return the feature Pbi3.
	 */
	public Feature getPbi3() {
		return this.pbi3;
	}

	/**
	 * Sets the relationType Rt2.
	 * 
	 * @param rt2
	 *            is the type to set
	 */
	public void setRt2(final RelationType rt2) {
		this.rt2 = rt2;
	}

	/**
	 * @return the realtionType Rt2.
	 */
	public RelationType getRt2() {
		return this.rt2;
	}

	/**
	 * Sets the realationType Rt3.
	 * 
	 * @param rt3
	 *            is the type to set.
	 */
	public void setRt3(final RelationType rt3) {
		this.rt3 = rt3;
	}

	/**
	 * @return the relationType Rt3.
	 */
	public RelationType getRt3() {
		return this.rt3;
	}

	/**
	 * Sets the realtionType Rt1.
	 * 
	 * @param rt1
	 *            is the type to set
	 */
	public void setRt1(final RelationType rt1) {
		this.rt1 = rt1;
	}

	/**
	 * @return the realtionType Rt1.
	 */
	public RelationType getRt1() {
		return this.rt1;
	}

	/**
	 * Sets the project textverarbeitung.
	 * 
	 * @param textverarbeitung
	 *            is the project to set
	 */
	public void setTextverarbeitung(final Project textverarbeitung) {
		this.textverarbeitung = textverarbeitung;
	}

	/**
	 * @return the project textverarbeitung.
	 */
	public Project getTextverarbeitung() {
		return this.textverarbeitung;
	}

	/**
	 * Sets the project taschenrechner.
	 * 
	 * @param taschenrechner
	 *            is the project to set
	 */
	public void setTaschenrechner(final Project taschenrechner) {
		this.taschenrechner = taschenrechner;
	}

	/**
	 * @return the project taschenrechner.
	 */
	public Project getTaschenrechner() {
		return this.taschenrechner;
	}

	/**
	 * @param r3
	 *            the r3 to set
	 */
	public void setR3(final Relation r3) {
		this.r3 = r3;
	}

	/**
	 * @return the r3
	 */
	public Relation getR3() {
		return this.r3;
	}
}
