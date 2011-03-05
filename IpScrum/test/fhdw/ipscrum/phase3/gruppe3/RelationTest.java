package fhdw.ipscrum.phase3.gruppe3;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.RelationType;

/**
 * The class <code>RelationTest</code> contains tests for the class
 * <code>{@link Relation}</code>.
 * 
 * @generatedBy CodePro at 03.03.11 15:39
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class RelationTest {
	/**
	 * Run the Relation(RelationType,ProductBacklogItem) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testRelation_1() throws Exception {
		final RelationType type = RelationType.create("");
		final ProductBacklogItem target = new Bug("", "", (ProductBacklog) null);

		final Relation result = new Relation(type, target);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testEquals_1() throws Exception {
		final Relation fixture = new Relation(RelationType.create(""), new Bug(
				"", "", (ProductBacklog) null));
		final Object obj = new Relation(RelationType.create(""), new Bug("",
				"", (ProductBacklog) null));

		final boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.DoubleDefinitionException:
		// Beziehungstyp bereits vorhanden.
		// at
		// fhdw.ipscrum.shared.model.RelationTypeManager.addRelationType(RelationTypeManager.java:36)
		// at
		// fhdw.ipscrum.shared.model.RelationType.create(RelationType.java:15)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testEquals_2() throws Exception {
		final Relation fixture = new Relation(RelationType.create(""), new Bug(
				"", "", (ProductBacklog) null));
		final Object obj = null;

		final boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.DoubleDefinitionException:
		// Beziehungstyp bereits vorhanden.
		// at
		// fhdw.ipscrum.shared.model.RelationTypeManager.addRelationType(RelationTypeManager.java:36)
		// at
		// fhdw.ipscrum.shared.model.RelationType.create(RelationType.java:15)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testEquals_3() throws Exception {
		final Relation fixture = new Relation(RelationType.create(""), new Bug(
				"", "", (ProductBacklog) null));
		final Object obj = new Object();

		final boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.DoubleDefinitionException:
		// Beziehungstyp bereits vorhanden.
		// at
		// fhdw.ipscrum.shared.model.RelationTypeManager.addRelationType(RelationTypeManager.java:36)
		// at
		// fhdw.ipscrum.shared.model.RelationType.create(RelationType.java:15)
		assertTrue(result);
	}

	/**
	 * Run the ProductBacklogItem getTarget() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetTarget_1() throws Exception {
		final Relation fixture = new Relation(RelationType.create(""), new Bug(
				"", "", (ProductBacklog) null));

		final ProductBacklogItem result = fixture.getTarget();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.DoubleDefinitionException:
		// Beziehungstyp bereits vorhanden.
		// at
		// fhdw.ipscrum.shared.model.RelationTypeManager.addRelationType(RelationTypeManager.java:36)
		// at
		// fhdw.ipscrum.shared.model.RelationType.create(RelationType.java:15)
		assertNotNull(result);
	}

	/**
	 * Run the RelationType getType() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetType_1() throws Exception {
		final Relation fixture = new Relation(RelationType.create(""), new Bug(
				"", "", (ProductBacklog) null));

		final RelationType result = fixture.getType();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.DoubleDefinitionException:
		// Beziehungstyp bereits vorhanden.
		// at
		// fhdw.ipscrum.shared.model.RelationTypeManager.addRelationType(RelationTypeManager.java:36)
		// at
		// fhdw.ipscrum.shared.model.RelationType.create(RelationType.java:15)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}
}