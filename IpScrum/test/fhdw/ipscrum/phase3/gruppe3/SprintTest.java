package fhdw.ipscrum.phase3.gruppe3;

import java.util.Date;
import java.util.Vector;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.model.interfaces.ITeam;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.visitor.ITreeConstructionVisitor;
import org.junit.*;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.SprintBacklog;
import static org.junit.Assert.*;

/**
 * The class <code>SprintTest</code> contains tests for the class <code>{@link Sprint}</code>.
 *
 * @generatedBy CodePro at 05.03.11 11:25
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class SprintTest {
	/**
	 * Run the Sprint(String,String,Date,Date,ITeam) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSprint_1()
		throws Exception {
		String name = "";
		String description = "";
		Date begin = new Date();
		Date end = new Date();
		ITeam team = new Team("");

		Sprint result = new Sprint(name, description, begin, end, team);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,ITeam) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSprint_2()
		throws Exception {
		String name = "";
		String description = "a";
		Date begin = new Date();
		Date end = new Date();
		ITeam team = new Team("");

		Sprint result = new Sprint(name, description, begin, end, team);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,ITeam) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSprint_3()
		throws Exception {
		String name = "";
		String description = "a";
		Date begin = new Date();
		Date end = new Date();
		ITeam team = new Team("");

		Sprint result = new Sprint(name, description, begin, end, team);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,ITeam) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSprint_4()
		throws Exception {
		String name = "";
		String description = "a";
		Date begin = new Date();
		Date end = new Date();
		ITeam team = new Team("");

		Sprint result = new Sprint(name, description, begin, end, team);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void accept(ITreeConstructionVisitor) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testAccept_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		ITreeConstructionVisitor treeVisitor = null;

		fixture.accept(treeVisitor);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertTrue(result);
	}

	/**
	 * Run the Date getBegin() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetBegin_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		Date result = fixture.getBegin();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the int getCumulatedManDayCosts() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetCumulatedManDayCosts_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		int result = fixture.getCumulatedManDayCosts();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertEquals(0, result);
	}

	/**
	 * Run the int getCumulatedManDayCosts() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetCumulatedManDayCosts_2()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		int result = fixture.getCumulatedManDayCosts();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertEquals(0, result);
	}

	/**
	 * Run the int getCumulatedManDayCostsOfClosedPbis() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetCumulatedManDayCostsOfClosedPbis_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		int result = fixture.getCumulatedManDayCostsOfClosedPbis();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertEquals(0, result);
	}

	/**
	 * Run the int getCumulatedManDayCostsOfClosedPbis() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetCumulatedManDayCostsOfClosedPbis_2()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		int result = fixture.getCumulatedManDayCostsOfClosedPbis();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertEquals(0, result);
	}

	/**
	 * Run the String getDescription() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetDescription_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		String result = fixture.getDescription();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the Date getEnd() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetEnd_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		Date result = fixture.getEnd();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		String result = fixture.getName();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the Vector<ProductBacklogItem> getPBIs() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetPBIs_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		Vector<ProductBacklogItem> result = fixture.getPBIs();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the Vector<ProductBacklogItem> getPBIs() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetPBIs_2()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		Vector<ProductBacklogItem> result = fixture.getPBIs();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the IRelease getRelease() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetRelease_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		IRelease result = fixture.getRelease();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the SprintBacklog getSprintBacklog() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetSprintBacklog_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		SprintBacklog result = fixture.getSprintBacklog();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the ITeam getTeam() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetTeam_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		ITeam result = fixture.getTeam();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the OneToMany<ManyToOne, ISprint> getToPBIAssoc() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetToPBIAssoc_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		OneToMany<ManyToOne, ISprint> result = fixture.getToPBIAssoc();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the ManyToOne<OneToMany, ISprint> getToReleaseAssoc() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testGetToReleaseAssoc_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		ManyToOne<OneToMany, ISprint> result = fixture.getToReleaseAssoc();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		int result = fixture.hashCode();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertEquals(0, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIndirectEquals_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Sprint obj = new Sprint("", "a", new Date(), new Date(), new Team(""));
		obj.setDescription("");

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIndirectEquals_2()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Object obj = null;

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIndirectEquals_3()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Object obj = new Object();

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIndirectEquals_4()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Object obj = new Sprint("", "a", new Date(), new Date(), new Team(""));

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIndirectEquals_5()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Object obj = new Sprint("", "a", new Date(), new Date(), new Team(""));

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIndirectEquals_6()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Object obj = new Sprint("", "a", new Date(), new Date(), new Team(""));

		boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertTrue(result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIndirectHashCode_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		int result = fixture.indirectHashCode();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertEquals(0, result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testIndirectHashCode_2()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		int result = fixture.indirectHashCode();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertEquals(0, result);
	}

	/**
	 * Run the void setDescription(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testSetDescription_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		String description = "";

		fixture.setDescription(description);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetName_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		String name = null;

		fixture.setName(name);

		// add additional test code here
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetName_2()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		String name = "";

		fixture.setName(name);

		// add additional test code here
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetName_3()
		throws Exception {
		Sprint fixture = new Sprint("aaaaaaaaaaaaaaaaaaaaa", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		String name = "aaaaaaaaaaaaaaaaaaaaa";

		fixture.setName(name);

		// add additional test code here
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetName_4()
		throws Exception {
		Sprint fixture = new Sprint("a", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		String name = "a";

		fixture.setName(name);

		// add additional test code here
	}

	/**
	 * Run the void setTeam(ITeam) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetTeam_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		ITeam team = null;

		fixture.setTeam(team);

		// add additional test code here
	}

	/**
	 * Run the void setTeam(ITeam) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetTeam_2()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		ITeam team = new Team("");

		fixture.setTeam(team);

		// add additional test code here
	}

	/**
	 * Run the void setTimeFrame(Date,Date) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetTimeFrame_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Date begin = null;
		Date end = new Date();

		fixture.setTimeFrame(begin, end);

		// add additional test code here
	}

	/**
	 * Run the void setTimeFrame(Date,Date) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetTimeFrame_2()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Date begin = new Date();
		Date end = null;

		fixture.setTimeFrame(begin, end);

		// add additional test code here
	}

	/**
	 * Run the void setTimeFrame(Date,Date) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetTimeFrame_3()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Date begin = new Date();
		Date end = new Date();

		fixture.setTimeFrame(begin, end);

		// add additional test code here
	}

	/**
	 * Run the void setTimeFrame(Date,Date) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetTimeFrame_4()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Date begin = new Date();
		Date end = new Date();

		fixture.setTimeFrame(begin, end);

		// add additional test code here
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		String result = fixture.toString();

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		//    fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein Beschreibung angegeben werden.
		//       at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:157)
		//       at fhdw.ipscrum.shared.model.Team.<init>(Team.java:35)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 05.03.11 11:25
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
	 * @generatedBy CodePro at 05.03.11 11:25
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
	 * @generatedBy CodePro at 05.03.11 11:25
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SprintTest.class);
	}
}