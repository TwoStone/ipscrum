package fhdw.ipscrum.shared.model.nonMeta;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.SetUpTestData;

/**
 * The class <code>SprintTest</code> contains tests for the class
 * <code>{@link Sprint}</code>.
 */
public class SprintTest extends SetUpTestData {

	/**
	 * Test the creation of a sprint.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSprint1() throws Exception {

		final String name = "sprintname";
		final String description = "sprintdescription";
		final Date begin = new Date();
		final Date end = new Date();
		end.setTime(end.getTime() + 1000);
		final Team team = new Team(this.getModel(), "team");
		team.addProject(this.getProjekt1());

		final Sprint result =
				new Sprint(this.getModel(), name, description, begin, end, team,
						this.getProjekt1());
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,ITeam) constructor test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSprint2() throws Exception {
		final String name = "";
		final String description = "a";
		final Date begin = new Date();
		final Date end = new Date();
		end.setTime(end.getTime() + 1000);
		final Team team = new Team(this.getModel(), "team");

		final Sprint result =
				new Sprint(this.getModel(), name, description, begin, end, team,
						this.getProjekt1());
		Assert.assertNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,Team) constructor test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSprint3() throws Exception {

		final String name = "name";
		final String description = "";
		final Date begin = new Date();
		final Date end = new Date();
		end.setTime(end.getTime() + 1000);
		final Team team = new Team(this.getModel(), "team");
		team.addProject(this.getProjekt1());

		final Sprint result =
				new Sprint(this.getModel(), name, description, begin, end, team,
						this.getProjekt1());
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,Team) constructor test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSprint4() throws Exception {
		final String name = "MehrAlsZwanzigZeichen.";
		final String description = "a";
		final Date begin = new Date();
		final Date end = new Date();
		end.setTime(end.getTime() + 1000);
		final Team team = new Team(this.getModel(), "team");

		final Sprint result =
				new Sprint(this.getModel(), name, description, begin, end, team,
						this.getProjekt1());
		Assert.assertNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,Team) constructor test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSprint5() throws Exception {
		final String name = "name";
		final String description = "";
		final Date begin = new Date();
		final Date end = new Date();
		end.setTime(end.getTime() - 1000);
		final Team team = new Team(this.getModel(), "team");

		final Sprint result =
				new Sprint(this.getModel(), name, description, begin, end, team,
						this.getProjekt1());
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,Team) constructor test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSprint6() throws Exception {

		final String name = "name";
		final String description = "";
		final Date begin = null;
		final Date end = new Date();
		final Team team = new Team(this.getModel(), "team");

		final Sprint result =
				new Sprint(this.getModel(), name, description, begin, end, team,
						this.getProjekt1());
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Sprint(String,String,Date,Date,Team) constructor test. With not valid
	 * values to check if the Exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSprint7() throws Exception {
		final String name = "name";
		final String description = "";
		final Date begin = new Date();
		final Date end = null;
		final Team team = new Team(this.getModel(), "team");

		final Sprint result =
				new Sprint(this.getModel(), name, description, begin, end, team,
						this.getProjekt1());
		Assert.assertNotNull(result);
	}

	/**
	 * Run the Date getBegin() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetBegin1() throws Exception {
		final Team team = new Team(this.getModel(), "Team");
		team.addProject(this.getProjekt1());

		final Date d = new Date();
		final Sprint fixture =
				new Sprint(this.getModel(), "name", "", d, new Date(), team, this.getProjekt1());

		final Date result = fixture.getBegin();
		Assert.assertEquals(d, result);
	}

	/**
	 * Run the String getDescription() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetDescription1() throws Exception {
		final Team team = new Team(this.getModel(), "Team");
		team.addProject(this.getProjekt1());
		final Sprint fixture =
				new Sprint(this.getModel(), "name", "desc", new Date(), new Date(), team,
						this.getProjekt1());

		final String result = fixture.getDescription();
		Assert.assertEquals("desc", result);
	}

	/**
	 * Run the Date getEnd() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetEnd1() throws Exception {
		final Team team = new Team(this.getModel(), "Team");
		team.addProject(this.getProjekt1());
		final Date d = new Date();
		final Sprint fixture =
				new Sprint(this.getModel(), "name", "", new Date(), d, team, this.getProjekt1());

		final Date result = fixture.getEnd();
		Assert.assertEquals(d, result);
	}

	/**
	 * Run the String getName() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetName1() throws Exception {
		final Team team = new Team(this.getModel(), "Team");
		team.addProject(this.getProjekt1());
		final Sprint fixture =
				new Sprint(this.getModel(), "name", "", new Date(), new Date(), team,
						this.getProjekt1());

		final String result = fixture.getName();
		Assert.assertEquals("name", result);
	}

	/**
	 * Run the Vector<ProductBacklogItem> getPBIs() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetPBIs1() throws Exception {
		final Team team = new Team(this.getModel(), "Team");
		team.addProject(this.getProjekt1());
		final Sprint fixture =
				new Sprint(this.getModel(), "name", "", new Date(), new Date(), team,
						this.getProjekt1());

		final List<ProductBacklogItem> result = fixture.getPBIs();
		Assert.assertEquals(0, result.size());
	}

	/**
	 * Run the Release getRelease() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetRelease1() throws Exception {
		final Team team = new Team(this.getModel(), "Team");
		team.addProject(this.getProjekt1());

		final Sprint fixture =
				new Sprint(this.getModel(), "name", "a", new Date(), new Date(), team,
						this.getProjekt1());
		final Project p = new Project(this.getModel(), "project");
		p.addSprint(fixture);
		final Release r = new Release(this.getModel(), "release", new Date(), p);
		r.addSprint(fixture);

		final Release result = fixture.getRelease();
		Assert.assertEquals(r, result);
	}

	/**
	 * Run the Team getTeam() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testGetTeam1() throws Exception {
		final Team team = new Team(this.getModel(), "team");
		team.addProject(this.getProjekt1());

		final Sprint fixture =
				new Sprint(this.getModel(), "name", "a", new Date(), new Date(), team,
						this.getProjekt1());

		final Team result = fixture.getTeam();
		Assert.assertEquals(team, result);
	}

	/**
	 * Run the void setDescription(String) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetDescription1() throws Exception {
		final Team team = new Team(this.getModel(), "Team");
		team.addProject(this.getProjekt1());
		final Sprint fixture =
				new Sprint(this.getModel(), "name", "a", new Date(), new Date(), team,
						this.getProjekt1());
		final String description = "newDesc";
		fixture.setDescription(description);

		Assert.assertEquals(description, fixture.getDescription());
	}

	/**
	 * Run the void setName(String) method test. With a not valid value to check if the
	 * exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSetName1() throws Exception {
		final Team team = new Team(this.getModel(), "Team");
		team.addProject(this.getProjekt1());

		final Sprint fixture =
				new Sprint(this.getModel(), "name", "a", new Date(), new Date(), team,
						this.getProjekt1());
		fixture.setDescription("");
		final String name = null;

		fixture.setName(name);
		Assert.assertEquals("name", fixture.getName());
	}

	/**
	 * Run the void setName(String) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSetName2() throws Exception {
		final Team team = new Team(this.getModel(), "Team");
		team.addProject(this.getProjekt1());

		final Sprint fixture =
				new Sprint(this.getModel(), "name", "a", new Date(), new Date(), team,
						this.getProjekt1());
		final String name = "DasSindLockerUeberZwanzigZeichen";

		fixture.setName(name);
		Assert.assertEquals("name", fixture.getName());
	}

	/**
	 * Run the void setName(String) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetName3() throws Exception {
		final Team team = new Team(this.getModel(), "Team");
		team.addProject(this.getProjekt1());

		final Sprint fixture =
				new Sprint(this.getModel(), "name", "a", new Date(), new Date(), team,
						this.getProjekt1());
		final String name = "newName8901234567890";

		fixture.setName(name);
		Assert.assertEquals(name, fixture.getName());
	}

	/**
	 * Run the void setName(String) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetName4() throws Exception {
		final Team team = new Team(this.getModel(), "Team");
		team.addProject(this.getProjekt1());

		final Sprint fixture =
				new Sprint(this.getModel(), "name", "a", new Date(), new Date(), team,
						this.getProjekt1());
		final String name = "n";

		fixture.setName(name);
		Assert.assertEquals(name, fixture.getName());
	}

	/**
	 * Run the void setTeam(Team) method test. With a not valid value to check if the
	 * exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSetTeam1() throws Exception {
		final Sprint fixture = this.getPro1rel1spr1();
		final Team team = null;
		fixture.setTeam(team);
	}

	/**
	 * Run the void setTeam(Team) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetTeam2() throws Exception {
		final Sprint fixture = this.getPro1rel1spr1();
		final Team team = this.getTeam1();
		fixture.setTeam(team);
	}

	/**
	 * Run the void setTeam(Team) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.ConsistencyException.class)
	public void testSetTeam3() throws Exception {
		final Sprint fixture = this.getPro1rel1spr1();
		final Team team = new Team(this.getModel(), "Konsistenztest");
		fixture.setTeam(team);
	}

	/**
	 * Run the void setTimeFrame(Date,Date) method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSetTimeFrame1() throws Exception {
		final Sprint fixture =
				new Sprint(this.getModel(), "", "a", new Date(), new Date(), new Team(
						this.getModel(), ""), this.getProjekt1());
		fixture.setDescription("");
		final Date begin = null;
		final Date end = new Date();
		end.setTime(end.getTime() + 1000);

		fixture.setTimeFrame(begin, end);

	}

	/**
	 * Run the void setTimeFrame(Date,Date) method test. With a not valid value to check
	 * if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSetTimeFrame2() throws Exception {
		final Sprint fixture =
				new Sprint(this.getModel(), "", "a", new Date(), new Date(), new Team(
						this.getModel(), ""), this.getProjekt1());
		fixture.setDescription("");
		final Date begin = new Date();
		final Date end = null;

		fixture.setTimeFrame(begin, end);

	}

	/**
	 * Run the void setTimeFrame(Date,Date) method test. With a not valid value to check
	 * if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSetTimeFrame3() throws Exception {
		final Sprint fixture =
				new Sprint(this.getModel(), "", "a", new Date(), new Date(), new Team(
						this.getModel(), ""), this.getProjekt1());
		fixture.setDescription("");
		final Date begin = new Date();
		final Date end = new Date();
		end.setTime(end.getTime() + 1000);

		fixture.setTimeFrame(begin, end);

	}

	/**
	 * Run the void setTimeFrame(Date,Date) method test. With a not valid value to check
	 * if the exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = fhdw.ipscrum.shared.exceptions.model.NoValidValueException.class)
	public void testSetTimeFrame4() throws Exception {
		final Sprint fixture =
				new Sprint(this.getModel(), "", "a", new Date(), new Date(), new Team(
						this.getModel(), ""), this.getProjekt1());
		fixture.setDescription("");
		final Date begin = new Date();
		final Date end = new Date();
		end.setTime(end.getTime() + 1000);

		fixture.setTimeFrame(begin, end);

	}

	/**
	 * Run the String toString() method test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testToString1() throws Exception {
		final Team team = new Team(this.getModel(), "Team");
		team.addProject(this.getProjekt1());
		final Sprint fixture =
				new Sprint(this.getModel(), "name", "a", new Date(), new Date(), team,
						this.getProjekt1());
		final String result = fixture.toString();
		Assert.assertEquals("name", result);
	}

	/**
	 * Perform post-test clean-up.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test if the method to get the cumulated man day costs calculates the right way.
	 */
	@Test
	public void testGetCumulatedManDayCosts() {
		try {
			Assert.assertEquals(Integer.valueOf(19), this.getPro1rel1spr1()
					.getCumulatedManDayCosts().getValue());
			Assert.assertEquals(Integer.valueOf(36), this.getPro1rel1spr2()
					.getCumulatedManDayCosts().getValue());
			Assert.assertEquals(Integer.valueOf(77), this.getPro1rel1spr3()
					.getCumulatedManDayCosts().getValue());
			Assert.assertEquals(Integer.valueOf(31), this.getPro1rel1spr4()
					.getCumulatedManDayCosts().getValue());
			Assert.assertEquals(Integer.valueOf(63), this.getPro1rel1spr5()
					.getCumulatedManDayCosts().getValue());

			Assert.assertEquals(Integer.valueOf(112), this.getPro1rel2spr1()
					.getCumulatedManDayCosts().getValue());
			Assert.assertEquals(Integer.valueOf(71), this.getPro1rel2spr2()
					.getCumulatedManDayCosts().getValue());
			Assert.assertEquals(Integer.valueOf(206), this.getPro1rel2spr3()
					.getCumulatedManDayCosts().getValue());
			Assert.assertEquals(Integer.valueOf(142), this.getPro1rel2spr4()
					.getCumulatedManDayCosts().getValue());
			Assert.assertEquals(Integer.valueOf(39), this.getPro1rel2spr5()
					.getCumulatedManDayCosts().getValue());

			Assert.assertEquals(Integer.valueOf(19), this.getPro2rel1spr1()
					.getCumulatedManDayCosts().getValue());
			Assert.assertEquals(Integer.valueOf(19), this.getPro2rel1spr2()
					.getCumulatedManDayCosts().getValue());
			Assert.assertEquals(Integer.valueOf(19), this.getPro2rel1spr3()
					.getCumulatedManDayCosts().getValue());
			Assert.assertEquals(Integer.valueOf(19), this.getPro2rel1spr4()
					.getCumulatedManDayCosts().getValue());
			Assert.assertEquals(Integer.valueOf(19), this.getPro2rel1spr5()
					.getCumulatedManDayCosts().getValue());

			Assert.assertEquals(Integer.valueOf(169), this.getPro2rel2spr1()
					.getCumulatedManDayCosts().getValue());
			Assert.assertEquals(Integer.valueOf(47), this.getPro2rel2spr2()
					.getCumulatedManDayCosts().getValue());
			Assert.assertEquals(Integer.valueOf(60), this.getPro2rel2spr3()
					.getCumulatedManDayCosts().getValue());
			Assert.assertEquals(Integer.valueOf(45), this.getPro2rel2spr4()
					.getCumulatedManDayCosts().getValue());
			Assert.assertEquals(Integer.valueOf(25), this.getPro2rel2spr5()
					.getCumulatedManDayCosts().getValue());
		} catch (final NoValidValueException e) {
			Assert.fail(e.getMessage());
		}

	}

	/**
	 * Tests if the method to get the cumulated man day costs og closed pbis calculates
	 * the right way.
	 */
	@Test
	public void testGetCumulatedManDayCostsOfClosedPbis() {
		try {
			Assert.assertEquals(Integer.valueOf(10), this.getPro1rel1spr1()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
			Assert.assertEquals(Integer.valueOf(20), this.getPro1rel1spr2()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
			Assert.assertEquals(Integer.valueOf(50), this.getPro1rel1spr3()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
			Assert.assertEquals(Integer.valueOf(0), this.getPro1rel1spr4()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
			Assert.assertEquals(Integer.valueOf(63), this.getPro1rel1spr5()
					.getCumulatedManDayCostsOfClosedPbis().getValue());

			Assert.assertEquals(Integer.valueOf(92), this.getPro1rel2spr1()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
			Assert.assertEquals(Integer.valueOf(41), this.getPro1rel2spr2()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
			Assert.assertEquals(Integer.valueOf(103), this.getPro1rel2spr3()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
			Assert.assertEquals(Integer.valueOf(116), this.getPro1rel2spr4()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
			Assert.assertEquals(Integer.valueOf(22), this.getPro1rel2spr5()
					.getCumulatedManDayCostsOfClosedPbis().getValue());

			Assert.assertEquals(Integer.valueOf(16), this.getPro2rel1spr1()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
			Assert.assertEquals(Integer.valueOf(12), this.getPro2rel1spr2()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
			Assert.assertEquals(Integer.valueOf(7), this.getPro2rel1spr3()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
			Assert.assertEquals(Integer.valueOf(3), this.getPro2rel1spr4()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
			Assert.assertEquals(Integer.valueOf(0), this.getPro2rel1spr5()
					.getCumulatedManDayCostsOfClosedPbis().getValue());

			Assert.assertEquals(Integer.valueOf(71), this.getPro2rel2spr1()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
			Assert.assertEquals(Integer.valueOf(31), this.getPro2rel2spr2()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
			Assert.assertEquals(Integer.valueOf(43), this.getPro2rel2spr3()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
			Assert.assertEquals(Integer.valueOf(24), this.getPro2rel2spr4()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
			Assert.assertEquals(Integer.valueOf(12), this.getPro2rel2spr5()
					.getCumulatedManDayCostsOfClosedPbis().getValue());
		} catch (final NoValidValueException e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Test if the method to get the cumulated man day costs of closed features calculates
	 * the right way.
	 */
	@Test
	public void testGetCumulatedManDayCostsOfClosedFeatures() {
		try {
			// ohne Bugs
			Assert.assertEquals(Integer.valueOf(10), this.getPro1rel1spr1()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(20), this.getPro1rel1spr2()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(50), this.getPro1rel1spr3()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(0), this.getPro1rel1spr4()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(63), this.getPro1rel1spr5()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());

			Assert.assertEquals(Integer.valueOf(92), this.getPro1rel2spr1()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(41), this.getPro1rel2spr2()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(103), this.getPro1rel2spr3()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(116), this.getPro1rel2spr4()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(22), this.getPro1rel2spr5()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());

			Assert.assertEquals(Integer.valueOf(16), this.getPro2rel1spr1()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(12), this.getPro2rel1spr2()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(7), this.getPro2rel1spr3()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(3), this.getPro2rel1spr4()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(0), this.getPro2rel1spr5()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());

			Assert.assertEquals(Integer.valueOf(71), this.getPro2rel2spr1()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(31), this.getPro2rel2spr2()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(43), this.getPro2rel2spr3()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(24), this.getPro2rel2spr4()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(12), this.getPro2rel2spr5()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());

			// mit Bugs
			Assert.assertEquals(Integer.valueOf(7), this.getPro3rel1spr1()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(2), this.getPro3rel1spr2()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(2), this.getPro3rel1spr3()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(0), this.getPro3rel1spr4()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(39), this.getPro3rel1spr5()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());

			Assert.assertEquals(Integer.valueOf(7), this.getPro3rel2spr1()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(35), this.getPro3rel2spr2()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(36), this.getPro3rel2spr4()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
			Assert.assertEquals(Integer.valueOf(0), this.getPro3rel2spr5()
					.getCumulatedManDayCostsOfClosedFeatures().getValue());
		} catch (final NoValidValueException e) {
			Assert.fail(e.getMessage());
		}
	}

	/**
	 * Test the method which checks if the sprint is related to a pbi.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testHasPBI1() throws Exception {
		final Sprint fixture =
				new Sprint(this.getModel(), "bla", "a", new Date(), new Date(), this.getTeam1(),
						this.getProjekt1());
		Assert.assertEquals(false, fixture.hasPBI(this.getPro1rel2spr1fea1()));
	}

	/**
	 * Test the method which checks if the sprint is related to a pbi.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testHasPBI2() throws Exception {
		Assert.assertEquals(true, this.getPro1rel2spr1().hasPBI(this.getPro1rel2spr1fea1()));
	}

	/**
	 * Test the method to check the deadline of the sprint.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testcheckDeadline1() throws Exception {
		this.getPro1rel2spr1().checkDeadline();
	}
}
