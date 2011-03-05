package fhdw.ipscrum.phase3.gruppe3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.DateFormat;
import java.util.Date;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.visitor.ITreeConstructionVisitor;

/**
 * The class <code>ReleaseTest</code> contains tests for the class
 * <code>{@link Release}</code>.
 * 
 * @generatedBy CodePro at 03.03.11 15:39
 * @author wolf
 * @version $Revision: 1.0 $
 */
public class ReleaseTest {
	/**
	 * Run the Release(String,Date,Project) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testRelease_1() throws Exception {
		final String version = "";
		final Date releaseDate = new Date();
		final Project project = new Project("");

		final Release result = new Release(version, releaseDate, project);

		// add additional test code here
		assertNotNull(result);
		assertEquals(
				"Release [releaseDate=Thu Mar 03 15:39:35 CET 2011, version=]",
				result.toString());
		assertEquals("", result.getVersion());
		assertEquals(150137528, result.indirectHashCode());
		assertEquals(new Integer(0), result.countSprints());
		assertEquals(0, result.countObservers());
	}

	/**
	 * Run the Release(String,Date,Project) constructor test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testRelease_2() throws Exception {
		final String version = "";
		final Date releaseDate = new Date();
		final Project project = new Project("");

		final Release result = new Release(version, releaseDate, project);

		// add additional test code here
		assertNotNull(result);
		assertEquals(
				"Release [releaseDate=Thu Mar 03 15:39:35 CET 2011, version=]",
				result.toString());
		assertEquals("", result.getVersion());
		assertEquals(150137528, result.indirectHashCode());
		assertEquals(new Integer(0), result.countSprints());
		assertEquals(0, result.countObservers());
	}

	/**
	 * Run the void accept(ITreeConstructionVisitor) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testAccept_1() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));
		final ITreeConstructionVisitor treeVisitor = null;

		fixture.accept(treeVisitor);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// java.lang.NullPointerException
		// at fhdw.ipscrum.shared.model.Release.accept(Release.java:242)
	}

	/**
	 * Run the void addSprint(ISprint) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testAddSprint_1() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));
		final ISprint sprint = new Sprint("", "", new Date(), new Date(),
				new Team(""));

		fixture.addSprint(sprint);

		// add additional test code here
	}

	/**
	 * Run the void addSprint(ISprint) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.NoValidValueException.class)
	public void testAddSprint_2() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));
		final ISprint sprint = new Sprint("", "", new Date(), new Date(),
				new Team(""));

		fixture.addSprint(sprint);

		// add additional test code here
	}

	/**
	 * Run the Integer countSprints() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testCountSprints_1() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));

		final Integer result = fixture.countSprints();

		// add additional test code here
		assertNotNull(result);
		assertEquals("0", result.toString());
		assertEquals((byte) 0, result.byteValue());
		assertEquals(0.0, result.doubleValue(), 1.0);
		assertEquals(0.0f, result.floatValue(), 1.0f);
		assertEquals(0, result.intValue());
		assertEquals(0L, result.longValue());
		assertEquals((short) 0, result.shortValue());
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
		final Release fixture = new Release("", new Date(), new Project(""));
		final Object obj = new Object();

		final boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(false, result);
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
		final Release fixture = new Release("", new Date(), new Project(""));
		final Object obj = new Release("", new Date(), new Project(""));

		final boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
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
		final Release fixture = new Release("", new Date(), new Project(""));
		final Object obj = new Release("", new Date(), new Project(""));

		final boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
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
		final Release fixture = new Release("", new Date(), new Project(""));
		final Object obj = new Release("", new Date(), new Project(""));

		final boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
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
		final Release fixture = new Release("", new Date(), new Project(""));
		final Object obj = new Release("", new Date(), new Project(""));

		final boolean result = fixture.equals(obj);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the Project getProject() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetProject_1() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));

		final Project result = fixture.getProject();

		// add additional test code here
		assertNotNull(result);
		assertEquals("Project [name=]", result.toString());
		assertEquals("", result.getName());
		assertEquals(992, result.indirectHashCode());
		assertEquals(new Integer(0), result.countSprints());
		assertEquals(0, result.countObservers());
	}

	/**
	 * Run the ManyToOne<OneToMany, IRelease> getProjectAssoc() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetProjectAssoc_1() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));

		final ManyToOne<OneToMany, IRelease> result = fixture.getProjectAssoc();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Date getReleaseDate() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetReleaseDate_1() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));

		final Date result = fixture.getReleaseDate();

		// add additional test code here
		assertNotNull(result);
		assertEquals(DateFormat.getInstance().format(new Date(1299163175812L)),
				DateFormat.getInstance().format(result));
		assertEquals(1299163175812L, result.getTime());
	}

	/**
	 * Run the OneToMany<ManyToOne, IRelease> getSprintAssoc() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetSprintAssoc_1() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));

		final OneToMany<ManyToOne, IRelease> result = fixture.getSprintAssoc();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the Vector<ISprint> getSprints() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetSprints_1() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));

		final Vector<ISprint> result = fixture.getSprints();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the Vector<ISprint> getSprints() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetSprints_2() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));

		final Vector<ISprint> result = fixture.getSprints();

		// add additional test code here
		assertNotNull(result);
		assertEquals(0, result.size());
	}

	/**
	 * Run the String getVersion() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testGetVersion_1() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));

		final String result = fixture.getVersion();

		// add additional test code here
		assertEquals("", result);
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
		final Release fixture = new Release("", new Date(), new Project(""));

		final int result = fixture.hashCode();

		// add additional test code here
		assertEquals(-1729025849, result);
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
		final Release fixture = new Release("", new Date(), new Project(""));

		final int result = fixture.hashCode();

		// add additional test code here
		assertEquals(-1730455817, result);
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
		final Release fixture = new Release("", new Date(), new Project(""));
		final Object obj = new Release("", new Date(), new Project(""));

		final boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(true, result);
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
		final Release fixture = new Release("", new Date(), new Project(""));
		final Object obj = new Object();

		final boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(false, result);
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
		final Release fixture = new Release("", new Date(), new Project(""));
		final Object obj = new Object();

		final boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(false, result);
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
		final Release fixture = new Release("", new Date(), new Project(""));
		final Object obj = new Release("", new Date(), new Project(""));

		final boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(true, result);
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
		final Release fixture = new Release("", new Date(), new Project(""));
		final Object obj = new Release("", new Date(), new Project(""));

		final boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(true, result);
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
		final Release fixture = new Release("", new Date(), new Project(""));
		final Object obj = new Release("", new Date(), new Project(""));

		final boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(true, result);
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
		final Release fixture = new Release((String) null, new Date(),
				new Project(""));
		final Object obj = new Release((String) null, new Date(), new Project(
				""));

		final boolean result = fixture.indirectEquals(obj);

		// add additional test code here
		assertEquals(true, result);
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
		final Release fixture = new Release("", (Date) null, new Project(""));

		final int result = fixture.indirectHashCode();

		// add additional test code here
		assertEquals(30752, result);
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
		final Release fixture = new Release((String) null, new Date(),
				new Project(""));

		final int result = fixture.indirectHashCode();

		// add additional test code here
		assertEquals(150155322, result);
	}

	/**
	 * Run the void removeAllSprints() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testRemoveAllSprints_1() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));

		fixture.removeAllSprints();

		// add additional test code here
	}

	/**
	 * Run the void removeAllSprints() method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testRemoveAllSprints_2() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));

		fixture.removeAllSprints();

		// add additional test code here
	}

	/**
	 * Run the void removeSprint(ISprint) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test
	public void testRemoveSprint_1() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));
		final ISprint sprint = new Sprint("", "", new Date(), new Date(),
				new Team(""));

		fixture.removeSprint(sprint);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this
		// test:
		// fhdw.ipscrum.shared.exceptions.NoValidValueException: Es muss ein
		// Beschreibung angegeben werden.
		// at fhdw.ipscrum.shared.model.Team.setDescription(Team.java:55)
		// at fhdw.ipscrum.shared.model.Team.<init>(Team.java:30)
	}

	/**
	 * Run the void setReleaseDate(Date) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void testSetReleaseDate_1() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));
		final Date releaseDate = new Date();

		fixture.setReleaseDate(releaseDate);

		// add additional test code here
	}

	/**
	 * Run the void setReleaseDate(Date) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void testSetReleaseDate_2() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));
		final Date releaseDate = new Date();

		fixture.setReleaseDate(releaseDate);

		// add additional test code here
	}

	/**
	 * Run the void setVersion(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void testSetVersion_1() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));
		final String version = "";

		fixture.setVersion(version);

		// add additional test code here
	}

	/**
	 * Run the void setVersion(String) method test.
	 * 
	 * @throws Exception
	 * 
	 * @generatedBy CodePro at 03.03.11 15:39
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.DoubleDefinitionException.class)
	public void testSetVersion_2() throws Exception {
		final Release fixture = new Release("", new Date(), new Project(""));
		final String version = "";

		fixture.setVersion(version);

		// add additional test code here
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
		final Release fixture = new Release("", new Date(), new Project(""));

		final String result = fixture.toString();

		// add additional test code here
		assertEquals(
				"Release [releaseDate=Thu Mar 03 15:39:36 CET 2011, version=]",
				result);
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