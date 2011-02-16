package fhdw.ipscrum.client.phase2.group2;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Closed;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.Open;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

import static org.junit.Assert.*;

public class Tests_Tickets1 {
	
	private String featureName1;
	private String featureName2;
	private String featureDescription1;
	private String projectName;

	private Project project;
	private ProductBacklog productBacklog;
	private Feature feature1;
	private Feature feature2;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.featureName1 = "TestFeature1";
		this.featureName2 = "TestFeature2";
		this.featureDescription1 = "TestFeature1";
		this.projectName = "TestProject";
		
		this.project = new Project(this.projectName);
		this.productBacklog = this.project.getBacklog();
		
		 this.feature1 = new Feature(this.featureName1, this.featureDescription1, this.productBacklog);
		 this.feature2 = new Feature(this.featureName2, this.featureDescription1, this.productBacklog);
	}

	@After
	public void tearDown() throws Exception {
	}
	/*
	 * erstellen eines Features
	 * in diesem Fall wird das Feature in der setUp()-Methode erstellt und hier nur noch überprüft, ob Namen, Beschreibung und Product-Backlog richtig gesetzt wurden.
	 */
	@Test
	public void createFeature() throws Exception {
		assertEquals(this.featureName1, this.feature1.getName());
		assertEquals(this.featureDescription1, this.feature1.getDescription());
		assertEquals(this.productBacklog, this.feature1.getBacklog());
	}
	
	/*
	 * erstellen von zwei Featuren mit gleichem Namen
	 */
	@Test (expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void createFeatureDoubleFeatureInSameBacklog() throws Exception {
		new Feature("TestName", "TestDescription", this.productBacklog);
		new Feature("TestName", "TestDescription", this.productBacklog);
		
	}
	
	/*
	 * schließen eines Features
	 */
	@Test
	public void closeFeature() throws Exception {
		assertTrue(this.feature1.getState() instanceof Open);
		this.feature1.close();
		assertTrue(this.feature1.getState() instanceof Closed);
	}
	
	/*
	 * ein bereits geschlossenes Feature abschließen
	 */
	@Test (expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void closeAlreadyClosedFeature() throws Exception {
		assertTrue(this.feature1.getState() instanceof Open);
		this.feature1.close();
		assertTrue(this.feature1.getState() instanceof Closed);
		this.feature1.close();
	}
	
	/*
	 * eine Hinweis zu einem Feature hinzufügen
	 */
	@Test
	public void addHint() throws Exception {
		String content = "TestHint";
		Hint hint = new Hint(content);
		assertFalse(this.feature1.getHints().listIterator().hasNext());
		this.feature1.addHint(hint);
		assertTrue(this.feature1.getHints().listIterator().hasNext());
		assertEquals(hint, this.feature1.getHints().listIterator().next());
		assertEquals(content, this.feature1.getHints().listIterator().next().getContent());
	}
	
	/*
	 * einen Hinweis von einem Feature entfernen
	 */
	@Test
	public void removeHint() throws Exception {
		Hint hint = new Hint("TestHint");
		assertFalse(this.feature1.getHints().listIterator().hasNext());
		this.feature1.addHint(hint);
		assertTrue(this.feature1.getHints().listIterator().hasNext());
		assertEquals(hint, this.feature1.getHints().listIterator().next());
		this.feature1.removeHint(hint);
		assertFalse(this.feature1.getHints().listIterator().hasNext());
	}
	
	/*
	 * zwei gleiche Hinweise zu einem Feature hinzufügen
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void addHintDoubleContent_DiffenretObjects() throws Exception {
		Hint hint1 = new Hint("TestHint");
		Hint hint2 = new Hint("TestHint");
		assertFalse(this.feature1.getHints().listIterator().hasNext());
		this.feature1.addHint(hint1);
		this.feature1.addHint(hint2);
	}
	
	/*
	 * den selben Hinweis 2x zu einem Feature hinzufügen
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void addHintDoubleContent_DoubleAdd() throws Exception {
		Hint hint = new Hint("TestHint");
		assertFalse(this.feature1.getHints().listIterator().hasNext());
		this.feature1.addHint(hint);
		this.feature1.addHint(hint);
	}
	
	/*
	 * ein Akzeptanzkriterium zu einem Feature hinzufügen
	 */
	@Test
	public void addAcceptanceCriterion() throws Exception {
		AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion("TestAcceptanceCriterion");
		assertFalse(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
		this.feature1.addAcceptanceCriterion(acceptanceCriterion);
		assertTrue(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
		assertEquals(acceptanceCriterion, this.feature1.getAcceptanceCriteria().listIterator().next());
	}
	
	/*
	 * ein Akzeptanzkriterium von einem Feature entfernen
	 */
	@Test
	public void removeAcceptanceCriterion() throws Exception {
		AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion("TestAcceptanceCriterion");
		assertFalse(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
		this.feature1.addAcceptanceCriterion(acceptanceCriterion);
		assertTrue(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
		assertEquals(acceptanceCriterion, this.feature1.getAcceptanceCriteria().listIterator().next());
		this.feature1.removeAcceptanceCriterion(acceptanceCriterion);
		assertFalse(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
	}
	
	/*
	 * zwei gleiche Akzeptanzkriterien zu einem Feature hinzufügen
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void addAcceptanceCriterionDoubleContent_DiffenretObjects() throws Exception {
		AcceptanceCriterion acceptanceCriterion1 = new AcceptanceCriterion("TestAcceptanceCriterion");
		AcceptanceCriterion acceptanceCriterion2 = new AcceptanceCriterion("TestAcceptanceCriterion");
		assertFalse(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
		this.feature1.addAcceptanceCriterion(acceptanceCriterion1);
		this.feature1.addAcceptanceCriterion(acceptanceCriterion2);
	}
	
	/*
	 * das selbe Akzeptanzkriterium 2x zu einem Feature hinzufügen
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void addAcceptanceCriterionDoubleContent_DoubleAdd() throws Exception {
		AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion("TestAcceptanceCriterion");
		assertFalse(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
		this.feature1.addAcceptanceCriterion(acceptanceCriterion);
		this.feature1.addAcceptanceCriterion(acceptanceCriterion);
	}
	
	/*
	 * eine Relation zu einem anderen Feature zu einem Feature hinzufügen und dabei einen neuen Relations-Typ angeben
	 */
	@Test
	public void addRelationToOtherFeatureWithNewRelationType() throws Exception {
		RelationType relationType = RelationType.create("TestRelationType");
		Relation relation = new Relation(relationType, this.feature2);
		
		assertFalse(this.feature1.getRelations().iterator().hasNext());
		this.feature1.addRelation(relation);
		assertTrue(this.feature1.getRelations().iterator().hasNext());
		assertEquals(relation, this.feature1.getRelations().iterator().next());
		assertEquals(relationType, this.feature1.getRelations().iterator().next().getType());
	}
	
	/*
	 * eine Relation auf das eigene Feature hinzufügen und dabei einen neuen Relations-Typ angeben
	 */
	@Test
	public void addRelationToOwnFeatureWithNewRelationType() throws Exception {
		RelationType relationType = RelationType.create("TestRelationType2");
		Relation relation = new Relation(relationType, this.feature1);
		
		assertFalse(this.feature1.getRelations().iterator().hasNext());
		this.feature1.addRelation(relation);
		assertTrue(this.feature1.getRelations().iterator().hasNext());
		assertEquals(relation, this.feature1.getRelations().iterator().next());
		assertEquals(relationType, this.feature1.getRelations().iterator().next().getType());
	}
	
	/*
	 * eine Relation zu einem anderen Feature zu einem Feature hinzufügen und dabei einen vorhandenen Relations-Typ auswählen
	 */
	@Test
	public void addRelationToOtherFeatureWithoutNewRelationType() throws Exception {
		if(SessionManager.getInstance().getModel().getRelationTypeManager().getRelationTypes().iterator().hasNext() == false){
			RelationType.create("TestRelationType");
		}
		
		RelationType relationType = SessionManager.getInstance().getModel().getRelationTypeManager().getRelationTypes().iterator().next();
		Relation relation = new Relation(relationType, this.feature2);
		
		assertFalse(this.feature1.getRelations().iterator().hasNext());
		this.feature1.addRelation(relation);
		assertTrue(this.feature1.getRelations().iterator().hasNext());
		assertEquals(relation, this.feature1.getRelations().iterator().next());
		assertEquals(relationType, this.feature1.getRelations().iterator().next().getType());
		
	}
	
	/*
	 * eine Relation zu einem anderen Feature entfernen 
	 */
	@Test
	public void removeRelationToOtherFeatureWithoutNewRelationType() throws Exception {
		if(SessionManager.getInstance().getModel().getRelationTypeManager().getRelationTypes().iterator().hasNext() == false){
			RelationType.create("TestRelationType");
		}
		
		RelationType relationType = SessionManager.getInstance().getModel().getRelationTypeManager().getRelationTypes().iterator().next();
		Relation relation = new Relation(relationType, this.feature2);
		
		assertFalse(this.feature1.getRelations().iterator().hasNext());
		this.feature1.addRelation(relation);
		assertTrue(this.feature1.getRelations().iterator().hasNext());
		assertEquals(relation, this.feature1.getRelations().iterator().next());
		assertEquals(relationType, this.feature1.getRelations().iterator().next().getType());
		this.feature1.removeRelation(relation);
		assertFalse(this.feature1.getRelations().iterator().hasNext());
		
	}
	
	/*
	 * einen Hinweis zu einem geschlossenen Feature hinzufgüen
	 */
	@Test (expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void addHintToClosedFeature() throws Exception {
		this.feature1.close();
		assertTrue(this.feature1.getState() instanceof Closed);
		
		Hint hint = new Hint("TestHint");
		
		this.feature1.addHint(hint);
	}
	
	/*
	 * ein Akzeptanzkriterium zu einem geschlossenen Feature hinzufügen
	 */
	@Test (expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void addAcceptanceCriterionToClosedFeature() throws Exception {
		this.feature1.close();
		assertTrue(this.feature1.getState() instanceof Closed);
		
		AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion("TestAcceptanceCriterion");
		
		this.feature1.addAcceptanceCriterion(acceptanceCriterion);
	}
	
	/*
	 * eine Relation zu einem geschlossenen Feature hinzufügen
	 */
	@Test (expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void addRelationToClosedFeature() throws Exception {
		this.feature1.close();
		assertTrue(this.feature1.getState() instanceof Closed);
		
		if(SessionManager.getInstance().getModel().getRelationTypeManager().getRelationTypes().iterator().hasNext() == false){
			RelationType.create("TestRelationType");
		}
		
		RelationType relationType = SessionManager.getInstance().getModel().getRelationTypeManager().getRelationTypes().iterator().next();
		Relation relation = new Relation(relationType, this.feature2);
		
		assertFalse(this.feature1.getRelations().iterator().hasNext());
		this.feature1.addRelation(relation);
	}
	
	/*
	 * einen Hinweis von einem geschlossenen Feature entfernen
	 */
	@Test (expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void removeHintToClosedFeature() throws Exception {
		Hint hint = new Hint("TestHint");
		
		this.feature1.addHint(hint);

		this.feature1.close();
		assertTrue(this.feature1.getState() instanceof Closed);
		
		this.feature1.removeHint(hint);
		
	}
	
	/*
	 * ein Akzeptanzkriterieum von einem geschlossenen Feature entfernen
	 */
	@Test (expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void removeAcceptanceCriterionToClosedFeature() throws Exception {
		AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion("TestAcceptanceCriterion");
		
		this.feature1.addAcceptanceCriterion(acceptanceCriterion);

		this.feature1.close();
		assertTrue(this.feature1.getState() instanceof Closed);
		
		this.feature1.removeAcceptanceCriterion(acceptanceCriterion);
		
	}
	
	/*
	 * eine Relation von einem geschlossenen Feature entfernen
	 */
	@Test (expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void removeRelationToClosedFeature() throws Exception {
		if(SessionManager.getInstance().getModel().getRelationTypeManager().getRelationTypes().iterator().hasNext() == false){
			RelationType.create("TestRelationType");
		}
		
		RelationType relationType = SessionManager.getInstance().getModel().getRelationTypeManager().getRelationTypes().iterator().next();
		Relation relation = new Relation(relationType, this.feature2);
		
		assertFalse(this.feature1.getRelations().iterator().hasNext());
		this.feature1.addRelation(relation);
		
		this.feature1.close();
		assertTrue(this.feature1.getState() instanceof Closed);
		
		this.feature1.removeRelation(relation);
	}
	
	/*
	 * den Namen eines nicht abgeschlossenen Features verändern
	 */
	@Test
	public void setNameToOpenFeature() throws Exception {
		assertEquals(this.featureName1, this.feature1.getName());
		this.feature1.setName("TestNewName");
		assertEquals("TestNewName", this.feature1.getName());
	}
	
	/*
	 * den Namen einen geschlossenen Features verändern
	 */
	@Test (expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void setNameToClosedFeature() throws Exception {
		assertEquals(this.featureName1, this.feature1.getName());
		this.feature1.close();
		this.feature1.setName("TestNewName");
	}
	
	/*
	 * die Beschreibung eines nicht abgeschlossenen Features verändern
	 */
	@Test
	public void setDescriptionToOpenFeature() throws Exception {
		assertEquals(this.featureName1, this.feature1.getDescription());
		this.feature1.setDescription("TestNewDescription");
		assertEquals("TestNewDescription", this.feature1.getDescription());
	}
	
	/*
	 * die Beschreibung eines geschlossenen Features verändern
	 */
	@Test (expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void setDescriptionToClosedFeature() throws Exception {
		assertEquals(this.featureName1, this.feature1.getDescription());
		this.feature1.close();
		this.feature1.setDescription("TestNewDescription");
	}
	
	/*
	 * den letzten Bearbeiter bei einem nicht abgeschlossenen Features verändern
	 */
	@Test
	public void setLastEditorToOpenFeature() throws Exception {
		Person person = new Person("TestFirstname", "TestNachname");
		this.feature1.setLastEditor(person);
		assertEquals(person, this.feature1.getLastEditor());
	}
	
	/*
	 * den letzten Bearbeiter bei einem abgeschlossenen Features verändern
	 */
	@Test (expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void setLastEditorToClosedFeature() throws Exception {
		Person person = new Person("TestFirstname", "TestNachname");
		this.feature1.close();
		this.feature1.setLastEditor(person);
	}
	
	/*
	 * die Anzahl der Personentage eines nicht geschlossenen Features verändern
	 */
	@Test
	public void setManDayCostsToOpenFeature() throws Exception {
		Integer manDayCosts = 5;
		this.feature1.setManDayCosts(manDayCosts);
		assertEquals(manDayCosts, this.feature1.getManDayCosts());
	}
	
	/*
	 * die Anzahl der Personentage eines abgeschlossenen Features verändern
	 */
	@Test (expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void setManDayCostsToClosedFeature() throws Exception {
		Integer manDayCosts = 5;
		this.feature1.close();
		this.feature1.setManDayCosts(manDayCosts);
	}
	
	/*
	 * ein Sprint einem nicht geschlossenem Feature zuordnen 
	 */
	@Test
	public void setSprintToOpenFeature() throws Exception {
		Date begin = new Date();
		Date end = new Date();
		end.setTime(end.getTime() + 1000);
		
		ISprint sprint = new Sprint("TestName", "TestDescription", begin, end, new Team("TestDescription"));
		project.addSprint(sprint);
		this.feature1.setSprint(sprint);
		assertEquals(sprint, this.feature1.getSprint());
	}
	
	/*
	 * ein Sprint einem geschlossenem Feature zuordnen
	 */
	@Test (expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void setSprintToClosedFeature() throws Exception {
		Date begin = new Date();
		Date end = new Date();
		end.setTime(end.getTime() + 1000);
		
		ISprint sprint = new Sprint("TestName", "TestDescription", begin, end, new Team("TestDescription"));
		project.addSprint(sprint);
		this.feature1.close();
		this.feature1.setSprint(sprint);
	}
	
	
	
	
	
	
	
	
	
	

}
