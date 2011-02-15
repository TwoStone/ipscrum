package fhdw.ipscrum.phase2.gruppe3.shared.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 * The class <code>SprintTest</code> contains tests for the class
 * <code>{@link Sprint}</code>.
 */
public class SprintTest {
	/**
	 * Run the Sprint(String,String,Date,Date,ITeam) constructor test.
	 */
	@Test
	public void testSprint_1() throws Exception {
		String name = "sprintname";
		String description = "sprintdescription";
		Date begin = new Date();
		Date end = new Date();
		end.setTime(end.getTime() + 1000);
		ITeam team = new Team("team");

		Sprint result = new Sprint(name, description, begin, end, team);
		assertNotNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,ITeam) constructor test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSprint_2() throws Exception {
		String name = "";
		String description = "a";
		Date begin = new Date();
		Date end = new Date();
		end.setTime(end.getTime() + 1000);
		ITeam team = new Team("team");

		Sprint result = new Sprint(name, description, begin, end, team);
		assertNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,ITeam) constructor test.
	 */
	@Test
	public void testSprint_3() throws Exception {
		String name = "name";
		String description = "";
		Date begin = new Date();
		Date end = new Date();
		end.setTime(end.getTime() + 1000);
		ITeam team = new Team("team");

		Sprint result = new Sprint(name, description, begin, end, team);
		assertNotNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,ITeam) constructor test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSprint_4() throws Exception {
		String name = "MehrAlsZwanzigZeichen.";
		String description = "a";
		Date begin = new Date();
		Date end = new Date();
		end.setTime(end.getTime() + 1000);
		ITeam team = new Team("team");

		Sprint result = new Sprint(name, description, begin, end, team);
		assertNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,ITeam) constructor test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSprint_5() throws Exception {
		String name = "name";
		String description = "";
		Date begin = new Date();
		Date end = new Date();
		end.setTime(end.getTime() - 1000);
		ITeam team = new Team("team");

		Sprint result = new Sprint(name, description, begin, end, team);
		assertNotNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,ITeam) constructor test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSprint_6() throws Exception {
		String name = "name";
		String description = "";
		Date begin = null;
		Date end = new Date();
		ITeam team = new Team("team");

		Sprint result = new Sprint(name, description, begin, end, team);
		assertNotNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,ITeam) constructor test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSprint_7() throws Exception {
		String name = "name";
		String description = "";
		Date begin = new Date();
		Date end = null;
		ITeam team = new Team("team");

		Sprint result = new Sprint(name, description, begin, end, team);
		assertNotNull(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_1() throws Exception {
		Date a = new Date();
		Date b = new Date();
		b.setTime(b.getTime() + 100);
		Date c = new Date();
		c.setTime(b.getTime() + 100);
		Sprint fixture = new Sprint("name", "", a, b, new Team("team1"));
		Sprint obj = new Sprint("name", "a", b, c, new Team("team2"));

		boolean result = fixture.equals(obj);
		assertTrue(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_2() throws Exception {
		Date a = new Date();
		Date b = new Date();
		b.setTime(b.getTime() + 100);
		Sprint fixture = new Sprint("name1", "", a, b, new Team("team1"));
		Sprint obj = new Sprint("name2", "", a, b, new Team("team1"));

		boolean result = fixture.equals(obj);
		assertFalse(result);
	}

	/**
	 * Run the Date getBegin() method test.
	 */
	@Test
	public void testGetBegin_1() throws Exception {
		Date d = new Date();
		Sprint fixture = new Sprint("name", "", d, new Date(), new Team("team"));

		Date result = fixture.getBegin();
		assertEquals(d, result);
	}

	/**
	 * Run the String getDescription() method test.
	 */
	@Test
	public void testGetDescription_1() throws Exception {
		Sprint fixture = new Sprint("name", "desc", new Date(), new Date(), new Team("team"));

		String result = fixture.getDescription();
		assertEquals("desc", result);
	}

	/**
	 * Run the Date getEnd() method test.
	 */
	@Test
	public void testGetEnd_1() throws Exception {
		Date d = new Date();
		Sprint fixture = new Sprint("name", "", new Date(), d, new Team("team"));

		Date result = fixture.getEnd();
		assertEquals(d, result);
	}

	/**
	 * Run the String getName() method test.
	 */
	@Test
	public void testGetName_1() throws Exception {
		Sprint fixture = new Sprint("name", "", new Date(), new Date(), new Team("team"));

		String result = fixture.getName();
		assertEquals("name", result);
	}

	/**
	 * Run the Vector<ProductBacklogItem> getPBIs() method test.
	 */
	@Test
	public void testGetPBIs_1() throws Exception {
		Sprint fixture = new Sprint("name", "", new Date(), new Date(), new Team("team"));

		Vector<ProductBacklogItem> result = fixture.getPBIs();
		assertEquals(0, result.size());
	}

	/**
	 * Run the Vector<ProductBacklogItem> getPBIs() method test.
	 */
	@Test
	public void testGetPBIs_2() throws Exception {
		Sprint fixture = new Sprint("name", "", new Date(), new Date(), new Team("team"));
		Project p = new Project("project");
		p.addSprint(fixture);
		ProductBacklogItem pbi = new Feature("pbi", "bla", p.getBacklog());
		pbi.setSprint(fixture);

		Vector<ProductBacklogItem> result = fixture.getPBIs();
		assertEquals(1, result.size());
	}

	/**
	 * Run the IRelease getRelease() method test.
	 */
	@Test
	public void testGetRelease_1() throws Exception {
		Sprint fixture = new Sprint("name", "a", new Date(), new Date(), new Team("team"));
		Project p = new Project("project");
		p.addSprint(fixture);
		Release r = new Release("release", new Date(), p);
		r.addSprint(fixture);

		IRelease result = fixture.getRelease();
		assertEquals(r, result);
	}

	/**
	 * Run the ITeam getTeam() method test.
	 */
	@Test
	public void testGetTeam_1() throws Exception {
		Team team = new Team("team");
		Sprint fixture = new Sprint("name", "a", new Date(), new Date(), team);

		ITeam result = fixture.getTeam();
		assertEquals(team, result);
	}

	/**
	 * Run the fhdw.ipscrum.shared.model.interfaces.ISprint.ToPBIAssoc
	 * getToPBIAssoc() method test.
	 */
	@Test
	public void testGetToPBIAssoc_1() throws Exception {
		Sprint fixture = new Sprint("name", "a", new Date(), new Date(), new Team("team"));

		fhdw.ipscrum.shared.model.interfaces.ISprint.ToPBIAssoc result = fixture.getToPBIAssoc();
		assertNotNull(result);
	}

	/**
	 * Run the fhdw.ipscrum.shared.model.interfaces.ISprint.ToReleaseAssoc
	 * getToReleaseAssoc() method test.
	 */
	@Test
	public void testGetToReleaseAssoc_1() throws Exception {
		Sprint fixture = new Sprint("name", "a", new Date(), new Date(), new Team("team"));

		fhdw.ipscrum.shared.model.interfaces.ISprint.ToReleaseAssoc result = fixture.getToReleaseAssoc();
		assertNotNull(result);
	}

	/**
	 * Run the int hashCode() method test.
	 */
	@Test
	public void testHashCode_1() throws Exception {
		Date a = new Date();
		Date b = new Date();
		b.setTime(b.getTime() + 100);
		Date c = new Date();
		c.setTime(b.getTime() + 100);
		Sprint fixture = new Sprint("name", "", a, b, new Team("team1"));
		Sprint obj = new Sprint("name", "a", b, c, new Team("team2"));

		assertEquals(obj.hashCode(), fixture.hashCode());
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 */
	@Test
	public void testIndirectEquals_2() throws Exception {
		Sprint fixture = new Sprint("name1", "", new Date(), new Date(), new Team("team"));
		Sprint obj = new Sprint("name", "", new Date(), new Date(), new Team("team"));

		assertFalse(fixture.indirectEquals(obj));
	}

	/**
	 * Run the boolean indirectEquals(Object) method test.
	 */
	@Test
	public void testIndirectEquals_1() throws Exception {
		Date a = new Date();
		Date b = new Date();
		b.setTime(b.getTime() + 100);
		Date c = new Date();
		c.setTime(b.getTime() + 100);
		Sprint fixture = new Sprint("name", "", a, b, new Team("team1"));
		Sprint obj = new Sprint("name", "a", b, c, new Team("team2"));

		assertTrue(fixture.indirectEquals(obj));
	}

	/**
	 * Run the int indirectHashCode() method test.
	 */
	@Test
	public void testIndirectHashCode_1() throws Exception {
		Date a = new Date();
		Date b = new Date();
		b.setTime(b.getTime() + 100);
		Date c = new Date();
		c.setTime(b.getTime() + 100);
		Sprint fixture = new Sprint("name", "", a, b, new Team("team1"));
		Sprint obj = new Sprint("name", "a", b, c, new Team("team2"));

		assertEquals(obj.indirectHashCode(), fixture.indirectHashCode());
	}

	/**
	 * Run the int indirectHashCode() method test.
	 */
	@Test
	public void testIndirectHashCode_2() throws Exception {
		Sprint fixture = new Sprint("name1", "", new Date(), new Date(), new Team("team"));
		Sprint obj = new Sprint("name", "", new Date(), new Date(), new Team("team"));

		assertFalse(obj.indirectHashCode() == fixture.indirectHashCode());
	}

	/**
	 * Run the void setDescription(String) method test.
	 */
	@Test
	public void testSetDescription_1() throws Exception {
		Sprint fixture = new Sprint("name", "a", new Date(), new Date(), new Team("team"));
		String description = "newDesc";
		fixture.setDescription(description);

		assertEquals(description, fixture.getDescription());
	}

	/**
	 * Run the void setName(String) method test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetName_1() throws Exception {
		Sprint fixture = new Sprint("name", "a", new Date(), new Date(), new Team("team"));
		fixture.setDescription("");
		String name = null;

		fixture.setName(name);
		assertEquals("name", fixture.getName());
	}

	/**
	 * Run the void setName(String) method test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetName_2() throws Exception {
		Sprint fixture = new Sprint("name", "a", new Date(), new Date(), new Team("name"));
		String name = "DasSindLockerUeberZwanzigZeichen";

		fixture.setName(name);
		assertEquals("name", fixture.getName());
	}

	/**
	 * Run the void setName(String) method test.
	 */
	@Test
	public void testSetName_3() throws Exception {
		Sprint fixture = new Sprint("name", "a", new Date(), new Date(), new Team("team"));
		String name = "newName8901234567890";

		fixture.setName(name);
		assertEquals(name, fixture.getName());
	}

	/**
	 * Run the void setName(String) method test.
	 */
	@Test
	public void testSetName_4() throws Exception {
		Sprint fixture = new Sprint("name", "a", new Date(), new Date(), new Team("team"));
		String name = "n";

		fixture.setName(name);
		assertEquals(name, fixture.getName());
	}

	/**
	 * Run the void setTeam(ITeam) method test.
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
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetTimeFrame_1() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Date begin = null;
		Date end = new Date();
		end.setTime(end.getTime() + 1000);

		fixture.setTimeFrame(begin, end);

	}

	/**
	 * Run the void setTimeFrame(Date,Date) method test.
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
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetTimeFrame_3() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Date begin = new Date();
		Date end = new Date();
		end.setTime(end.getTime() + 1000);

		fixture.setTimeFrame(begin, end);

	}

	/**
	 * Run the void setTimeFrame(Date,Date) method test.
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testSetTimeFrame_4() throws Exception {
		Sprint fixture = new Sprint("", "a", new Date(), new Date(), new Team(""));
		fixture.setDescription("");
		Date begin = new Date();
		Date end = new Date();
		end.setTime(end.getTime() + 1000);

		fixture.setTimeFrame(begin, end);

	}

	/**
	 * Run the String toString() method test.
	 */
	@Test
	public void testToString_1() throws Exception {
		Sprint fixture = new Sprint("name", "a", new Date(), new Date(), new Team("team"));
		String result = fixture.toString();
		assertEquals("name", result);
	}

	/**
	 * Perform pre-test initialization.
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Perform post-test clean-up.
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Launch the test.
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SprintTest.class);
	}
}