package fhdw.ipscrum.shared.model.search.criteria;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * The class <code>TestAll</code> builds a suite that can be used to run all of
 * the tests within its package as well as within any subpackages of its
 * package.
 * 
 * @generatedBy CodePro at 07.03.11 23:17
 * @author wolf
 * @version $Revision: 1.0 $
 */
@RunWith(Suite.class)
@Suite.SuiteClasses( { Test_BugSystemCriterion.class,
		Test_BugVersionCriterion.class, Test_PBIAcceptanceCriterion.class,
		Test_PBIClosedCriterion.class, Test_PBIComplexityCriterion.class,
		Test_PBIDescriptionCriterion.class, Test_PBIHintsCriterion.class,
		Test_PBILastEditorCriterion.class, Test_PBINameCriterion.class,
		Test_PBIOpenCriterion.class, Test_PBIProjectCriterion.class,
		Test_PBIRelationCriterion.class, Test_PBIRelationDestCriterion.class,
		Test_PBIRelationTypeCriterion.class, Test_PBIReleaseCriterion.class,
		Test_PBISprintCriterion.class, Test_PBISprintDescCriterion.class,
		Test_PBISprintNameCriterion.class, Test_PBIStateCriterion.class,
		Test_ProjectCriterion.class, Test_ScruumleCriterion.class,
		Test_TextCriterion.class, })
public class TestAll {

	/**
	 * Launch the test.
	 * 
	 * @param args
	 *            the command line arguments
	 * 
	 * @generatedBy CodePro at 07.03.11 23:17
	 */
	public static void main(final String[] args) {
		JUnitCore.runClasses(new Class[] { TestAll.class });
	}
}
