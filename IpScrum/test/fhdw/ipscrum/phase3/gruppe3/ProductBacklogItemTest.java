package fhdw.ipscrum.phase3.gruppe3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.Person;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * The class <code>ProductBacklogItemTest</code> contains tests for the class
 * <code>{@link ProductBacklogItem}</code>.
 * 
 * @generatedBy CodePro at 03.03.11 15:39
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class ProductBacklogItemTest {
	/**
	 * Run the void addAcceptanceCriterion(AcceptanceCriterion) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testAddAcceptanceCriterion_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion(
				"");

		fixture.addAcceptanceCriterion(acceptanceCriterion);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void addAcceptanceCriterion(AcceptanceCriterion) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testAddAcceptanceCriterion_2() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion(
				"");

		fixture.addAcceptanceCriterion(acceptanceCriterion);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void addAcceptanceCriterion(AcceptanceCriterion) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testAddAcceptanceCriterion_3() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion(
				"");

		fixture.addAcceptanceCriterion(acceptanceCriterion);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void addHint(Hint) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testAddHint_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Hint hint = new Hint("");

		fixture.addHint(hint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void addHint(Hint) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testAddHint_2() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Hint hint = new Hint("");

		fixture.addHint(hint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void addHint(Hint) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testAddHint_3() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Hint hint = new Hint("");

		fixture.addHint(hint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void addRelation(Relation) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testAddRelation_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Relation relation = new Relation(RelationType.create(""),
				new Bug("", "", (ProductBacklog) null));

		fixture.addRelation(relation);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void addRelation(Relation) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testAddRelation_2() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Relation relation = new Relation(RelationType.create(""),
				new Bug("", "", (ProductBacklog) null));

		fixture.addRelation(relation);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void addRelation(Relation) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testAddRelation_3() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Relation relation = new Relation(RelationType.create(""),
				new Bug("", "", (ProductBacklog) null));

		fixture.addRelation(relation);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void close() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testClose_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);

		fixture.close();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void close() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testClose_2() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);

		fixture.close();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
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
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Bug("", "", (ProductBacklog) null);

		final boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
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
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Object();

		final boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
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
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Object();

		final boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
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
	public void testEquals_4() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Bug("", "", (ProductBacklog) null);

		final boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
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
	public void testEquals_5() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Bug("", "", (ProductBacklog) null);

		final boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
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
	public void testEquals_6() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Bug("", "", (ProductBacklog) null);

		final boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
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
	public void testEquals_7() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Bug("", "", (ProductBacklog) null);

		final boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
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
	public void testEquals_8() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Bug("", "", (ProductBacklog) null);

		final boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
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
	public void testEquals_9() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Bug("", "", (ProductBacklog) null);

		final boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
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
	public void testEquals_10() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Bug("", "", (ProductBacklog) null);

		final boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertTrue(result);
	}

	/**
	 * Run the List<AcceptanceCriterion> getAcceptanceCriteria() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetAcceptanceCriteria_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);

		final List<AcceptanceCriterion> result = fixture
				.getAcceptanceCriteria();

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
	 * Run the ProductBacklog getBacklog() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetBacklog_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);

		final ProductBacklog result = fixture.getBacklog();

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
	 * Run the String getDescription() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetDescription_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);

		final String result = fixture.getDescription();

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
	 * Run the List<Hint> getHints() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetHints_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);

		final List<Hint> result = fixture.getHints();

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
	 * Run the IPerson getLastEditor() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetLastEditor_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);

		final IPerson result = fixture.getLastEditor();

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
	 * Run the Integer getManDayCosts() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetManDayCosts_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);

		final Integer result = fixture.getManDayCosts();

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
	 * Run the String getName() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetName_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);

		final String result = fixture.getName();

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
	 * Run the List<Relation> getRelations() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetRelations_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);

		final List<Relation> result = fixture.getRelations();

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
	 * Run the ISprint getSprint() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetSprint_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);

		final ISprint result = fixture.getSprint();

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
	 * Run the int hashCode() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testHashCode_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);

		final int result = fixture.hashCode();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertEquals(0, result);
	}

	/**
	 * Run the int hashCode() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testHashCode_2() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);

		final int result = fixture.hashCode();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertEquals(0, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testIndirectEquals_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Bug("", "", (ProductBacklog) null);

		final boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testIndirectEquals_2() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Object();

		final boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testIndirectEquals_3() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Object();

		final boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testIndirectEquals_4() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Bug("", "", (ProductBacklog) null);

		final boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testIndirectEquals_5() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Bug("", "", (ProductBacklog) null);

		final boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testIndirectEquals_6() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Bug("", "", (ProductBacklog) null);

		final boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testIndirectEquals_7() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Bug("", "", (ProductBacklog) null);

		final boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testIndirectEquals_8() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Object obj = new Bug("", "", (ProductBacklog) null);

		final boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertTrue(result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testIndirectHashCode_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);

		final int result = fixture.indirectHashCode();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertEquals(0, result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testIndirectHashCode_2() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);

		final int result = fixture.indirectHashCode();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertEquals(0, result);
	}

	/**
	 * Run the void removeAcceptanceCriterion(AcceptanceCriterion) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testRemoveAcceptanceCriterion_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final AcceptanceCriterion criterion = new AcceptanceCriterion("");

		fixture.removeAcceptanceCriterion(criterion);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void removeAcceptanceCriterion(AcceptanceCriterion) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testRemoveAcceptanceCriterion_2() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final AcceptanceCriterion criterion = new AcceptanceCriterion("");

		fixture.removeAcceptanceCriterion(criterion);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void removeHint(Hint) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testRemoveHint_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Hint hint = new Hint("");

		fixture.removeHint(hint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void removeHint(Hint) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testRemoveHint_2() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Hint hint = new Hint("");

		fixture.removeHint(hint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void removeRelation(Relation) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testRemoveRelation_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Relation relation = new Relation(RelationType.create(""),
				new Bug("", "", (ProductBacklog) null));

		fixture.removeRelation(relation);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void removeRelation(Relation) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testRemoveRelation_2() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Relation relation = new Relation(RelationType.create(""),
				new Bug("", "", (ProductBacklog) null));

		fixture.removeRelation(relation);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setDescription(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetDescription_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final String description = "";

		fixture.setDescription(description);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setDescription(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetDescription_2() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final String description = "";

		fixture.setDescription(description);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setLastEditor(IPerson) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetLastEditor_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final IPerson lastEditor = new Person("", "");

		fixture.setLastEditor(lastEditor);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setLastEditor(IPerson) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetLastEditor_2() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final IPerson lastEditor = new Person("", "");

		fixture.setLastEditor(lastEditor);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setManDayCosts(Integer) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetManDayCosts_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Integer manDayCosts = new Integer(1);

		fixture.setManDayCosts(manDayCosts);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setManDayCosts(Integer) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetManDayCosts_2() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Integer manDayCosts = new Integer(1);

		fixture.setManDayCosts(manDayCosts);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setManDayCosts(Integer) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetManDayCosts_3() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final Integer manDayCosts = new Integer(1);

		fixture.setManDayCosts(manDayCosts);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setName(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetName_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final String name = "";

		fixture.setName(name);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setName(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetName_2() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final String name = "";

		fixture.setName(name);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setName(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetName_3() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final String name = "";

		fixture.setName(name);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setName(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetName_4() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final String name = "";

		fixture.setName(name);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setName(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetName_5() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final String name = "";

		fixture.setName(name);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setSprint(ISprint) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetSprint_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final ISprint sprint = new Sprint("", "", new Date(), new Date(),
				new Team(""));

		fixture.setSprint(sprint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setSprint(ISprint) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetSprint_2() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final ISprint sprint = new Sprint("", "", new Date(), new Date(),
				new Team(""));

		fixture.setSprint(sprint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setSprint(ISprint) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetSprint_3() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final ISprint sprint = new Sprint("", "", new Date(), new Date(),
				new Team(""));

		fixture.setSprint(sprint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setSprint(ISprint) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testSetSprint_4() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);
		final ISprint sprint = new Sprint("", "", new Date(), new Date(),
				new Team(""));

		fixture.setSprint(sprint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		// at
		// fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		// at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testToString_1() throws Exception {
		final ProductBacklogItem fixture = new Bug("", "",
				(ProductBacklog) null);

		final String result = fixture.toString();

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