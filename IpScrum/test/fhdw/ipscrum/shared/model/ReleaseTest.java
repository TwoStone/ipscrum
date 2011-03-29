package fhdw.ipscrum.shared.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.Test;

import fhdw.ipscrum.shared.exceptions.NoValidValueException;


public class ReleaseTest extends SetUpTestData {

	@Test
	public void testGetOverallEfforts() {
		assertEquals(226, this.pro1rel1.getOverallEfforts());
		assertEquals(570, this.pro1rel2.getOverallEfforts());

		assertEquals(95, this.pro2rel1.getOverallEfforts());
		assertEquals(346, this.pro2rel2.getOverallEfforts());
	}

	@Test
	public void testGetOverallEffortsWithGetCumulatedManDayCosts() {

		try {
			//Estimating the overall Efforts with the method getCumulatedManDayCosts
			Integer result1 = 0;
			Iterator sprintIteratorPro1Rel1 = this.pro1rel1.getSprints().iterator();

			while (sprintIteratorPro1Rel1 .hasNext()){
				Sprint current = (Sprint) sprintIteratorPro1Rel1 .next();
				result1 += current.getCumulatedManDayCosts().getValue();
			}

			Integer result2 = 0;
			Iterator sprintIteratorPro1Rel2 = this.pro1rel2.getSprints().iterator();

			while (sprintIteratorPro1Rel2.hasNext()){
				Sprint current = (Sprint) sprintIteratorPro1Rel2.next();
				result2 += current.getCumulatedManDayCosts().getValue();
			}

			Integer result3 = 0;
			Iterator sprintIteratorPro2Rel1 = this.pro2rel1.getSprints().iterator();

			while (sprintIteratorPro2Rel1.hasNext()){
				Sprint current = (Sprint) sprintIteratorPro2Rel1.next();
				result3 += current.getCumulatedManDayCosts().getValue();
			}

			Integer result4 = 0;
			Iterator sprintIteratorPro2Rel2 = this.pro2rel2.getSprints().iterator();

			while (sprintIteratorPro2Rel2.hasNext()){
				Sprint current = (Sprint) sprintIteratorPro2Rel2.next();
				result4 += current.getCumulatedManDayCosts().getValue();
			}

			// Compares the estimated results with the results given by the method getOverallEfforts
			assertEquals(result1.intValue(), this.pro1rel1.getOverallEfforts());
			assertEquals(result2.intValue(), this.pro1rel2.getOverallEfforts());

			assertEquals(result3.intValue(), this.pro2rel1.getOverallEfforts());
			assertEquals(result4.intValue(), this.pro2rel2.getOverallEfforts());
		} catch (NoValidValueException e) {
			fail(e.getMessage());
		}
	}

}
