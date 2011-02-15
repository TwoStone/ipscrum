package fhdw.ipscrum.phase2.gruppe3.shared.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 * The class <code>SprintTest</code> contains tests for the class
 * <code>{@link Sprint}</code>.
 * 
 * @generatedBy CodePro at 15.02.11 11:21
 */
public class SprintTest {
	/**
	 * Run the Sprint(String,String,Date,Date,ITeam) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSprint_1() throws Exception {
		String name = "";
		String description = "";
		Date begin = new Date();
		Date end = new Date();
		ITeam team = new Team("");

		Sprint result = new Sprint(name, description, begin, end, team);

		assertNotNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,ITeam) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSprint_2() throws Exception {
		String name = "";
		String description = "a";
		Date begin = new Date();
		Date end = new Date();
		ITeam team = new Team("");

		Sprint result = new Sprint(name, description, begin, end, team);

		assertNotNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,ITeam) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSprint_3() throws Exception {
		String name = "";
		String description = "a";
		Date begin = new Date();
		Date end = new Date();
		ITeam team = new Team("");

		Sprint result = new Sprint(name, description, begin, end, team);

		assertNotNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,ITeam) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSprint_4() throws Exception {
		String name = "";
		String description = "a";
		Date begin = new Date();
		Date end = new Date();
		ITeam team = new Team("");

		Sprint result = new Sprint(name, description, begin, end, team);

		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testEquals_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testEquals_2() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Object obj = new Object();

		boolean result = fixture.equals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertTrue(result);
	}

	/**
	 * Run the Date getBegin() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetBegin_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		Date result = fixture.getBegin();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertNotNull(result);
	}

	/**
	 * Run the String getDescription() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetDescription_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		String result = fixture.getDescription();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertNotNull(result);
	}

	/**
	 * Run the Date getEnd() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetEnd_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		Date result = fixture.getEnd();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertNotNull(result);
	}

	/**
	 * Run the String getName() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetName_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		String result = fixture.getName();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertNotNull(result);
	}

	/**
	 * Run the Vector<ProductBacklogItem> getPBIs() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetPBIs_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		Vector<ProductBacklogItem> result = fixture.getPBIs();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertNotNull(result);
	}

	/**
	 * Run the Vector<ProductBacklogItem> getPBIs() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetPBIs_2() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		Vector<ProductBacklogItem> result = fixture.getPBIs();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertNotNull(result);
	}

	/**
	 * Run the IRelease getRelease() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetRelease_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		IRelease result = fixture.getRelease();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertNotNull(result);
	}

	/**
	 * Run the IRelease getRelease() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetRelease_2() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		IRelease result = fixture.getRelease();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertNotNull(result);
	}

	/**
	 * Run the ITeam getTeam() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetTeam_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		ITeam result = fixture.getTeam();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertNotNull(result);
	}

	/**
	 * Run the fhdw.ipscrum.shared.model.interfaces.ISprint.ToPBIAssoc
	 * getToPBIAssoc() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetToPBIAssoc_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		fhdw.ipscrum.shared.model.interfaces.ISprint.ToPBIAssoc result = fixture.getToPBIAssoc();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertNotNull(result);
	}

	/**
	 * Run the fhdw.ipscrum.shared.model.interfaces.ISprint.ToReleaseAssoc
	 * getToReleaseAssoc() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testGetToReleaseAssoc_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		fhdw.ipscrum.shared.model.interfaces.ISprint.ToReleaseAssoc result = fixture.getToReleaseAssoc();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertNotNull(result);
	}

	/**
	 * Run the int hashCode() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testHashCode_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		int result = fixture.hashCode();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertEquals(0, result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectEquals_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Sprint obj = new Sprint("", "a", new Date(), new Date(), new Team(""));
		obj.setDescription("");

		boolean result = fixture.indirectEquals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectEquals_2() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Object obj = null;

		boolean result = fixture.indirectEquals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectEquals_3() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Object obj = new Object();

		boolean result = fixture.indirectEquals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectEquals_4() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Object obj = new Sprint("", "a", new Date(), new Date(), new Team(""));

		boolean result = fixture.indirectEquals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectEquals_5() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Object obj = new Sprint("", "a", new Date(), new Date(), new Team(""));

		boolean result = fixture.indirectEquals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertTrue(result);
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectEquals_6() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Object obj = new Sprint("", "a", new Date(), new Date(), new Team(""));

		boolean result = fixture.indirectEquals(obj);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertTrue(result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectHashCode_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		int result = fixture.indirectHashCode();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertEquals(0, result);
	}

	/**
	 * Run the int indirectHashCode() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testIndirectHashCode_2() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		int result = fixture.indirectHashCode();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertEquals(0, result);
	}

	/**
	 * Run the void setDescription(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testSetDescription_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		String description = "";

		fixture.setDescription(description);

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
	}

	/**
	 * Run the void setName(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetName_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		String name = null;

		fixture.setName(name);

	}

	/**
	 * Run the void setName(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetName_2() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		String name = "";

		fixture.setName(name);

	}

	/**
	 * Run the void setName(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetName_3() throws Exception {
		Sprint fixture = new Sprint("aaaaaaaaaaaaaaaaaaaaa", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		String name = "aaaaaaaaaaaaaaaaaaaaa";

		fixture.setName(name);

	}

	/**
	 * Run the void setName(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetName_4() throws Exception {
		Sprint fixture = new Sprint("a", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		String name = "a";

		fixture.setName(name);

	}

	/**
	 * Run the void setTeam(ITeam) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetTeam_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		ITeam team = null;

		fixture.setTeam(team);

	}

	/**
	 * Run the void setTeam(ITeam) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetTeam_2() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		ITeam team = new Team("");

		fixture.setTeam(team);

	}

	/**
	 * Run the void setTimeFrame(Date,Date) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetTimeFrame_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Date begin = null;
		Date end = new Date();

		fixture.setTimeFrame(begin, end);

	}

	/**
	 * Run the void setTimeFrame(Date,Date) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetTimeFrame_2() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Date begin = new Date();
		Date end = null;

		fixture.setTimeFrame(begin, end);

	}

	/**
	 * Run the void setTimeFrame(Date,Date) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetTimeFrame_3() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Date begin = new Date();
		Date end = new Date();

		fixture.setTimeFrame(begin, end);

	}

	/**
	 * Run the void setTimeFrame(Date,Date) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetTimeFrame_4() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Date begin = new Date();
		Date end = new Date();

		fixture.setTimeFrame(begin, end);

	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Test
	public void testToString_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");

		String result = fixture.toString();

		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:28)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:16)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 * @generatedBy CodePro at 15.02.11 11:21
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SprintTest.class);
	}
}