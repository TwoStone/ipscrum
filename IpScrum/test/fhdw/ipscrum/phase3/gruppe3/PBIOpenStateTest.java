package fhdw.ipscrum.phase3.gruppe3;

import java.util.Date;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.BugOpenState;
import fhdw.ipscrum.shared.model.PBIOpenState;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.ITeam;
import fhdw.ipscrum.shared.model.Hint;
import org.junit.*;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Person;
import static org.junit.Assert.*;

/**
 * The class <code>PBIOpenStateTest</code> contains tests for the class <code>{@link PBIOpenState}</code>.
 *
 * @generatedBy CodePro at 02.03.11 20:35
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class PBIOpenStateTest {
	/**
	 * Run the void addAcceptanceCriterion(AcceptanceCriterion) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAddAcceptanceCriterion_1()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion("");

		fixture.addAcceptanceCriterion(acceptanceCriterion);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void addAcceptanceCriterion(AcceptanceCriterion) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAddAcceptanceCriterion_2()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion("");

		fixture.addAcceptanceCriterion(acceptanceCriterion);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void addHint(Hint) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAddHint_1()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		Hint hint = new Hint("");

		fixture.addHint(hint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void addHint(Hint) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAddHint_2()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		Hint hint = new Hint("");

		fixture.addHint(hint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void addRelation(Relation) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAddRelation_1()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		Relation relation = new Relation(RelationType.create(""), new Bug("", "", (ProductBacklog) null));

		fixture.addRelation(relation);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void addRelation(Relation) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testAddRelation_2()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		Relation relation = new Relation(RelationType.create(""), new Bug("", "", (ProductBacklog) null));

		fixture.addRelation(relation);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void close() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testClose_1()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));

		fixture.close();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		Object obj = new BugOpenState(new Bug("", "", (ProductBacklog) null));

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		Object obj = null;

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testEquals_3()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testEquals_4()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		Object obj = new BugOpenState(new Bug("", "", (ProductBacklog) null));

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testEquals_5()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		Object obj = new BugOpenState(new Bug("", "", (ProductBacklog) null));

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testEquals_6()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		Object obj = new BugOpenState(new Bug("", "", (ProductBacklog) null));

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testEquals_7()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		Object obj = new BugOpenState(new Bug("", "", (ProductBacklog) null));

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertTrue(result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));

		int result = fixture.hashCode();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertEquals(0, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testHashCode_2()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));

		int result = fixture.hashCode();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
		assertEquals(0, result);
	}

	/**
	 * Run the void removeAcceptanceCriterion(AcceptanceCriterion) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testRemoveAcceptanceCriterion_1()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion("");

		fixture.removeAcceptanceCriterion(acceptanceCriterion);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void removeHint(Hint) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testRemoveHint_1()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		Hint hint = new Hint("");

		fixture.removeHint(hint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void removeRelation(Relation) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testRemoveRelation_1()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		Relation relation = new Relation(RelationType.create(""), new Bug("", "", (ProductBacklog) null));

		fixture.removeRelation(relation);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setDescription(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetDescription_1()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		String description = "";

		fixture.setDescription(description);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setLastEditor(IPerson) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetLastEditor_1()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		IPerson lastEditor = new Person("", "");

		fixture.setLastEditor(lastEditor);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setLastEditor(IPerson) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetLastEditor_2()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		IPerson lastEditor = new Person("", "");

		fixture.setLastEditor(lastEditor);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setManDayCosts(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetManDayCosts_1()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		Integer manDayCosts = new Integer(1);

		fixture.setManDayCosts(manDayCosts);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setManDayCosts(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetManDayCosts_2()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		Integer manDayCosts = new Integer(1);

		fixture.setManDayCosts(manDayCosts);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setManDayCosts(Integer) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetManDayCosts_3()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		Integer manDayCosts = new Integer(1);

		fixture.setManDayCosts(manDayCosts);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetName_1()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		String name = "";

		fixture.setName(name);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetName_2()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		String name = "";

		fixture.setName(name);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetName_3()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		String name = "";

		fixture.setName(name);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetName_4()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		String name = "";

		fixture.setName(name);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetName_5()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		String name = "";

		fixture.setName(name);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setSprint(ISprint) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetSprint_1()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		ISprint sprint = new Sprint("", "", new Date(), new Date(), new Team(""));

		fixture.setSprint(sprint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setSprint(ISprint) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetSprint_2()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		ISprint sprint = new Sprint("", "", new Date(), new Date(), new Team(""));

		fixture.setSprint(sprint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setSprint(ISprint) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetSprint_3()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		ISprint sprint = new Sprint("", "", new Date(), new Date(), new Team(""));

		fixture.setSprint(sprint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Run the void setSprint(ISprint) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Test
	public void testSetSprint_4()
		throws Exception {
		PBIOpenState fixture = new BugOpenState(new Bug("", "", (ProductBacklog) null));
		ISprint sprint = new Sprint("", "", new Date(), new Date(), new Team(""));

		fixture.setSprint(sprint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    java.lang.NullPointerException
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.setBacklog(ProductBacklogItem.java:546)
		//       at fhdw.ipscrum.shared.model.ProductBacklogItem.<init>(ProductBacklogItem.java:103)
		//       at fhdw.ipscrum.shared.model.Bug.<init>(Bug.java:40)
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 02.03.11 20:35
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(PBIOpenStateTest.class);
	}
}