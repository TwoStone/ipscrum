package fhdw.ipscrum.phase2.gruppe3.shared.model;

import java.text.DateFormat;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import java.util.Date;
import java.util.Vector;
import fhdw.ipscrum.shared.model.interfaces.ITeam;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>SprintTest</code> contains tests for the class <code>{@link Sprint}</code>.
 *
 * @generatedBy CodePro at 13.02.11 20:00
 */
public class SprintTest {
	/**
	 * Run the Sprint(String,Date,Date,ITeam) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testSprint_1()
		throws Exception {
		String description = "";
		Date begin = new Date();
		Date end = new Date();
		ITeam team = new Team("");

		Sprint result = new Sprint(description, begin, end, team);

		assertNotNull(result);
		assertEquals("Sprint mit Team mit Team beginnt am Sun Feb 13 20:00:56 CET 2011 endet am Sun Feb 13 20:00:56 CET 2011", result.toString());
		assertEquals("Sprint mit Team mit Team beginnt am Sun Feb 13 20:00:56 CET 2011 endet am Sun Feb 13 20:00:56 CET 2011", result.getName());
		assertEquals("", result.getDescription());
		assertEquals(null, result.getRelease());
		assertEquals(-1107459429, result.indirectHashCode());
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testEquals_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testEquals_2()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));
		Sprint obj = new Sprint("", new Date(), new Date(), new Team(""));
		obj.setTeam(new Team(""));

		boolean result = fixture.equals(obj);

		assertEquals(true, result);
	}

	/**
	 * Run the Date getBegin() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testGetBegin_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));

		Date result = fixture.getBegin();

		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(new Date(1297623656602L)), DateFormat.getInstance().format(result));
		assertEquals(1297623656602L, result.getTime());
	}

	/**
	 * Run the String getDescription() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testGetDescription_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));

		String result = fixture.getDescription();

		assertEquals("", result);
	}

	/**
	 * Run the Date getEnd() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testGetEnd_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));

		Date result = fixture.getEnd();

		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(new Date(1297623656632L)), DateFormat.getInstance().format(result));
		assertEquals(1297623656632L, result.getTime());
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testGetName_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));

		String result = fixture.getName();

		assertEquals("Sprint mit Team mit Team beginnt am Sun Feb 13 20:00:56 CET 2011 endet am Sun Feb 13 20:00:56 CET 2011", result);
	}

	/**
	 * Run the Vector<ProductBacklogItem> getPBIs() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testGetPBIs_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));

		Vector<ProductBacklogItem> result = fixture.getPBIs();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Vector<ProductBacklogItem> getPBIs() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testGetPBIs_2()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));

		Vector<ProductBacklogItem> result = fixture.getPBIs();

		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the IRelease getRelease() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testGetRelease_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));

		IRelease result = fixture.getRelease();

		assertEquals(null, result);
	}

	/**
	 * Run the IRelease getRelease() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testGetRelease_2()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));

		IRelease result = fixture.getRelease();

		assertEquals(null, result);
	}

	/**
	 * Run the ITeam getTeam() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testGetTeam_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));

		ITeam result = fixture.getTeam();

		assertNotNull(result);
		assertEquals("", result.getDescription());
	}

	/**
	 * Run the fhdw.ipscrum.shared.model.interfaces.ISprint.ToPBIAssoc getToPBIAssoc() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testGetToPBIAssoc_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));

		fhdw.ipscrum.shared.model.interfaces.ISprint.ToPBIAssoc result = fixture.getToPBIAssoc();

		assertNotNull(result);
		assertEquals(null, result.get());
	}

	/**
	 * Run the fhdw.ipscrum.shared.model.interfaces.ISprint.ToReleaseAssoc getToReleaseAssoc() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testGetToReleaseAssoc_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));

		fhdw.ipscrum.shared.model.interfaces.ISprint.ToReleaseAssoc result = fixture.getToReleaseAssoc();

		assertNotNull(result);
		assertEquals(null, result.get());
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testHashCode_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));

		int result = fixture.hashCode();

		assertEquals(-464636747, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectEquals_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));
		Sprint obj = new Sprint("", new Date(), new Date(), new Team(""));
		obj.setDescription("");
		obj.setEnd(new Date());
		obj.setBegin(new Date());
		obj.setTeam(new Team(""));

		boolean result = fixture.indirectEquals(obj);

		assertEquals(true, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectEquals_2()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));
		Object obj = null;

		boolean result = fixture.indirectEquals(obj);

		assertEquals(false, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectEquals_3()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));
		Object obj = new Object();

		boolean result = fixture.indirectEquals(obj);

		assertEquals(false, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectEquals_4()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));
		Sprint obj = new Sprint("", new Date(), new Date(), new Team(""));
		obj.setBegin(new Date());

		boolean result = fixture.indirectEquals(obj);

		assertEquals(false, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectEquals_5()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));
		Sprint obj = new Sprint("", new Date(), new Date(), new Team(""));
		obj.setDescription("");
		obj.setBegin(new Date());

		boolean result = fixture.indirectEquals(obj);

		assertEquals(true, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectEquals_6()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));
		Sprint obj = new Sprint("", new Date(), new Date(), new Team(""));
		obj.setDescription("");
		obj.setEnd(new Date());
		obj.setBegin(new Date());

		boolean result = fixture.indirectEquals(obj);

		assertEquals(false, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectEquals_7()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));
		Sprint obj = new Sprint("", new Date(), new Date(), new Team(""));
		obj.setDescription("");
		obj.setEnd(new Date());
		obj.setBegin(new Date());

		boolean result = fixture.indirectEquals(obj);

		assertEquals(true, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectEquals_8()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd((Date) null);
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));
		Sprint obj = new Sprint("", new Date(), new Date(), new Team(""));
		obj.setDescription("");
		obj.setEnd((Date) null);
		obj.setBegin(new Date());

		boolean result = fixture.indirectEquals(obj);

		assertEquals(true, result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectHashCode_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin((Date) null);
		fixture.setTeam(new Team(""));

		int result = fixture.indirectHashCode();

		assertEquals(543562926, result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testIndirectHashCode_2()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription((String) null);
		fixture.setEnd((Date) null);
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));

		int result = fixture.indirectHashCode();

		assertEquals(-1650650079, result);
	}

	/**
	 * Run the void setBegin(Date) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testSetBegin_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));
		Date begin = new Date();

		fixture.setBegin(begin);

	}

	/**
	 * Run the void setDescription(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testSetDescription_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));
		String description = "";

		fixture.setDescription(description);

	}

	/**
	 * Run the void setEnd(Date) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testSetEnd_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));
		Date end = new Date();

		fixture.setEnd(end);

	}

	/**
	 * Run the void setTeam(ITeam) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testSetTeam_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam(new Team(""));
		ITeam team = new Team("");

		fixture.setTeam(team);

	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testToString_1()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription((String) null);
		fixture.setEnd(new Date());
		fixture.setBegin(new Date());
		fixture.setTeam((ITeam) null);

		String result = fixture.toString();

		assertEquals("Sprint beginnt am Sun Feb 13 20:00:56 CET 2011 endet am Sun Feb 13 20:00:56 CET 2011", result);
	}

	/**
	 * Run the String toString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Test
	public void testToString_2()
		throws Exception {
		Sprint fixture = new Sprint("", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		fixture.setEnd((Date) null);
		fixture.setBegin((Date) null);
		fixture.setTeam(new Team(""));

		String result = fixture.toString();

		assertEquals("Sprint mit Team mit Team", result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@Before
	public void setUp()
		throws Exception {
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	@After
	public void tearDown()
		throws Exception {
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 13.02.11 20:00
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SprintTest.class);
	}
}