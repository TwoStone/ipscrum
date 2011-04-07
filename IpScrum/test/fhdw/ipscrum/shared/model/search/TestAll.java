package fhdw.ipscrum.shared.model.search;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import fhdw.ipscrum.shared.model.search.criteria.Test_BugConcreteVersionCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_BugSystemCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_BugVersionNameCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBIAcceptanceCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBIBugTypeCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBIClosedCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBIComplexityCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBIConcreteReleaseCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBIDescriptionCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBIFeatureTypeCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBIHintsCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBILastEditorCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBINameCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBIOpenCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBIProjectCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBIRelationDestCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBIRelationTypeCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBIReleaseNameCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBISprintDescCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_PBISprintNameCriterion;
import fhdw.ipscrum.shared.model.search.criteria.Test_ScruumleCriterion;

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
@Suite.SuiteClasses({ Test_BugSystemCriterion.class, Test_BugVersionNameCriterion.class, Test_BugConcreteVersionCriterion.class, Test_PBIConcreteReleaseCriterion.class, Test_PBIAcceptanceCriterion.class, Test_PBINameCriterion.class, Test_PBIComplexityCriterion.class, Test_PBIDescriptionCriterion.class, Test_PBIHintsCriterion.class, Test_PBILastEditorCriterion.class, Test_PBIBugTypeCriterion.class, Test_PBIFeatureTypeCriterion.class, Test_PBIProjectCriterion.class, Test_PBIRelationDestCriterion.class, Test_PBIReleaseNameCriterion.class, Test_PBIRelationTypeCriterion.class, Test_PBISprintDescCriterion.class, Test_PBISprintNameCriterion.class, Test_ScruumleCriterion.class, Test_PBIOpenCriterion.class, Test_PBIClosedCriterion.class, AndTest.class, MultiLogicSearchOperatorTest.class,
		NotTest.class, OrTest.class, SearchManagerTest.class, SearchTest.class, SingleLogicSearchOperatorTest.class, })
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
