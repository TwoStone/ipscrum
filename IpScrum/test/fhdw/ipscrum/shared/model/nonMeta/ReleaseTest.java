package fhdw.ipscrum.shared.model.nonMeta;

import java.util.Date;
import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.SetUpTestData;

/**
 * The class <code>ReleaseTest</code> contains tests for the class
 * <code>{@link Release}</code>.
 */
public class ReleaseTest extends SetUpTestData {

	/**
	 * Tests to set the version of a release.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetVersion1() throws Exception {
		this.pro1rel1.setVersion("neue Version");
	}

	/**
	 * Tests to set the version of a release identical to another to check if the
	 * exception is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testSetVersion2() throws Exception {
		final Date d = fhdw.ipscrum.shared.utils.CalendarUtils.getRandomReleaseDate();
		final Release rel1 = new Release(this.model, "1.0", d, this.projekt1);
		final Release rel2 = new Release(this.model, "2.0", d, this.projekt1);
		Assert.assertNotNull(rel2);
		rel1.setVersion("2.0");
	}

	/**
	 * Test the set of the release date.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testSetReleaseDate1() throws Exception {
		this.pro1rel1.setReleaseDate(new Date());
	}

	/**
	 * Test to set the release date identical to another release to check if the exception
	 * is thrown.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test(expected = DoubleDefinitionException.class)
	public void testSetReleaseDate2() throws Exception {
		final Date d = fhdw.ipscrum.shared.utils.CalendarUtils.getRandomReleaseDate();
		final Release rel1 =
				new Release(this.model, "2.0",
						fhdw.ipscrum.shared.utils.CalendarUtils.getRandomReleaseDate(),
						this.projekt1);
		final Release rel2 = new Release(this.model, "2.0", d, this.projekt1);
		Assert.assertNotNull(rel2);
		rel1.setReleaseDate(d);
	}

	/**
	 * Test the method which counts all sprints related to the release.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCountSprints() throws Exception {
		Assert.assertEquals(Integer.valueOf(5), this.pro1rel1.countSprints());
	}

	/**
	 * Test the deadline check of the release.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testCheckDeadline() throws Exception {
		this.pro1rel1.checkDeadline();
	}

	/**
	 * Test if the method to get the overall efforts calculates right.
	 */
	@Test
	public void testGetOverallEfforts() {
		Assert.assertEquals(226, this.pro1rel1.getOverallEfforts());
		Assert.assertEquals(570, this.pro1rel2.getOverallEfforts());

		Assert.assertEquals(95, this.pro2rel1.getOverallEfforts());
		Assert.assertEquals(346, this.pro2rel2.getOverallEfforts());
	}

	/**
	 * Test of the method to get the overall efforts and the the method to get the
	 * cumulated man day costs calculates the right way.
	 * 
	 */
	@Test
	public void testGetOverallEffortsWithGetCumulatedManDayCosts() {

		try {
			// Estimating the overall Efforts with the method
			// getCumulatedManDayCosts
			Integer result1 = 0;
			final Iterator<Sprint> sprintIteratorPro1Rel1 =
					this.pro1rel1.getSprints().iterator();

			while (sprintIteratorPro1Rel1.hasNext()) {
				final Sprint current = sprintIteratorPro1Rel1.next();
				result1 += current.getCumulatedManDayCosts().getValue();
			}

			Integer result2 = 0;
			final Iterator<Sprint> sprintIteratorPro1Rel2 =
					this.pro1rel2.getSprints().iterator();

			while (sprintIteratorPro1Rel2.hasNext()) {
				final Sprint current = sprintIteratorPro1Rel2.next();
				result2 += current.getCumulatedManDayCosts().getValue();
			}

			Integer result3 = 0;
			final Iterator<Sprint> sprintIteratorPro2Rel1 =
					this.pro2rel1.getSprints().iterator();

			while (sprintIteratorPro2Rel1.hasNext()) {
				final Sprint current = sprintIteratorPro2Rel1.next();
				result3 += current.getCumulatedManDayCosts().getValue();
			}

			Integer result4 = 0;
			final Iterator<Sprint> sprintIteratorPro2Rel2 =
					this.pro2rel2.getSprints().iterator();

			while (sprintIteratorPro2Rel2.hasNext()) {
				final Sprint current = sprintIteratorPro2Rel2.next();
				result4 += current.getCumulatedManDayCosts().getValue();
			}

			// Compares the estimated results with the results given by the
			// method getOverallEfforts
			Assert.assertEquals(result1.intValue(), this.pro1rel1.getOverallEfforts());
			Assert.assertEquals(result2.intValue(), this.pro1rel2.getOverallEfforts());

			Assert.assertEquals(result3.intValue(), this.pro2rel1.getOverallEfforts());
			Assert.assertEquals(result4.intValue(), this.pro2rel2.getOverallEfforts());
		} catch (final NoValidValueException e) {
			Assert.fail(e.getMessage());
		}
	}

}
