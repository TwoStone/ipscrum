package fhdw.ipscrum.shared.model.metamodel.search.criteria;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests the ScruumleCriterion.
 */
public class TestScruumleCriterion extends SetUpTestDataForCriterion {

	// ---------------------------------------------------------------------------
	// ---------------------- Test of functions
	// ----------------------------------
	// ---------------------------------------------------------------------------

	/**
	 * Scruumle Search on a Bug. String is in the Bug
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testsearch1() throws Exception {
		final ScruumleCriterion srCrit =
				new ScruumleCriterion(SetUpTestDataForCriterion.getModel(), "Fehler");
		Assert.assertTrue(srCrit.search(SetUpTestDataForCriterion.getPbi4()));
	}

	/**
	 * Scruumle Search on a Bug. String is in the Bug
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testsearch2() throws Exception {
		final ScruumleCriterion srCrit =
				new ScruumleCriterion(SetUpTestDataForCriterion.getModel(), "korrekt");
		Assert.assertFalse(srCrit.search(SetUpTestDataForCriterion.getPbi4()));
	}

	/**
	 * Scruumle Search on a Feature. String is not in the Feature
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testsearch3() throws Exception {
		final ScruumleCriterion srCrit =
				new ScruumleCriterion(SetUpTestDataForCriterion.getModel(), "Texte");
		Assert.assertTrue(srCrit.search(SetUpTestDataForCriterion.getPbi1()));
	}

	/**
	 * Scruumle Search on a Feature. String is not in the Feature
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Test
	public void testsearch4() throws Exception {
		final ScruumleCriterion srCrit =
				new ScruumleCriterion(SetUpTestDataForCriterion.getModel(), "Hallo");
		Assert.assertFalse(srCrit.search(SetUpTestDataForCriterion.getPbi1()));
	}

}
