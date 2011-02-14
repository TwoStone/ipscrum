package fhdw.ipscrum.client.phase2.group2;


import static org.junit.Assert.assertEquals;

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
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.RelationType;

import static org.junit.Assert.*;

public class Tests_Tickets1 {
	
	private String featureName1;
	private String featureDescription1;
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
		this.featureDescription1 = "TestFeature1";
		this.project = new Project("TestProject");
		this.productBacklog = project.getBacklog();
		
		 this.feature1 = new Feature(this.featureName1, this.featureDescription1, this.productBacklog);
		 this.feature2 = new Feature(this.featureName1, this.featureDescription1, this.productBacklog);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void createFeature() throws Exception {
		assertEquals(this.featureName1, this.feature1.getName());
		assertEquals(this.featureDescription1, this.feature1.getDescription());
		assertEquals(this.productBacklog, this.feature1.getBacklog());
	}
	
	@Test
	public void closeFeature() throws Exception {
		assertTrue(this.feature1.getState() instanceof Open);
		this.feature1.close();
		assertTrue(this.feature1.getState() instanceof Closed);
	}
	
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
	
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void addHintDoubleContent_DiffenretObjects() throws Exception {
		Hint hint1 = new Hint("TestHint");
		Hint hint2 = new Hint("TestHint");
		assertFalse(this.feature1.getHints().listIterator().hasNext());
		this.feature1.addHint(hint1);
		this.feature1.addHint(hint2);
		assertTrue(this.feature1.getHints().listIterator().hasNext());
	}
	
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void addHintDoubleContent_DoubleAdd() throws Exception {
		Hint hint = new Hint("TestHint");
		assertFalse(this.feature1.getHints().listIterator().hasNext());
		this.feature1.addHint(hint);
		this.feature1.addHint(hint);
		assertTrue(this.feature1.getHints().listIterator().hasNext());
	}
	
	@Test
	public void addAcceptanceCriterion() throws Exception {
		AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion("TestAcceptanceCriterion");
		assertFalse(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
		this.feature1.addAcceptanceCriterion(acceptanceCriterion);
		assertTrue(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
		assertEquals(acceptanceCriterion, this.feature1.getAcceptanceCriteria().listIterator().next());
	}
	
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
	
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void addAcceptanceCriterionDoubleContent_DiffenretObjects() throws Exception {
		AcceptanceCriterion acceptanceCriterion1 = new AcceptanceCriterion("TestAcceptanceCriterion");
		AcceptanceCriterion acceptanceCriterion2 = new AcceptanceCriterion("TestAcceptanceCriterion");
		assertFalse(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
		this.feature1.addAcceptanceCriterion(acceptanceCriterion1);
		this.feature1.addAcceptanceCriterion(acceptanceCriterion2);
		assertTrue(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
	}
	
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void addAcceptanceCriterionDoubleContent_DoubleAdd() throws Exception {
		AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion("TestAcceptanceCriterion");
		assertFalse(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
		this.feature1.addAcceptanceCriterion(acceptanceCriterion);
		this.feature1.addAcceptanceCriterion(acceptanceCriterion);
		assertTrue(this.feature1.getAcceptanceCriteria().listIterator().hasNext());
	}
	
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
	
	@Test (expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void addHintToClosedFeature() throws Exception {
		this.feature1.close();
		assertTrue(this.feature1.getState() instanceof Closed);
		
		Hint hint = new Hint("TestHint");
		
		this.feature1.addHint(hint);
	}
	
	@Test (expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void addAcceptanceCriterionToClosedFeature() throws Exception {
		this.feature1.close();
		assertTrue(this.feature1.getState() instanceof Closed);
		
		AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion("TestAcceptanceCriterion");
		
		this.feature1.addAcceptanceCriterion(acceptanceCriterion);
	}
	
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
	
	@Test (expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void removeHintToClosedFeature() throws Exception {
		Hint hint = new Hint("TestHint");
		
		this.feature1.addHint(hint);

		this.feature1.close();
		assertTrue(this.feature1.getState() instanceof Closed);
		
		this.feature1.removeHint(hint);
		
	}
	
	@Test (expected = fhdw.ipscrum.shared.exceptions.ForbiddenStateException.class)
	public void removeAcceptanceCriterionToClosedFeature() throws Exception {
		AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion("TestAcceptanceCriterion");
		
		this.feature1.addAcceptanceCriterion(acceptanceCriterion);

		this.feature1.close();
		assertTrue(this.feature1.getState() instanceof Closed);
		
		this.feature1.removeAcceptanceCriterion(acceptanceCriterion);
		
	}
	
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
	
	
	
	

}
