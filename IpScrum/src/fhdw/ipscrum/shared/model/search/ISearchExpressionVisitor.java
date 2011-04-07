package fhdw.ipscrum.shared.model.search;

import fhdw.ipscrum.shared.model.search.criteria.BugConcreteVersionCriterion;
import fhdw.ipscrum.shared.model.search.criteria.BugSystemCriterion;
import fhdw.ipscrum.shared.model.search.criteria.BugVersionCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIAcceptanceCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIBugTypeCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIClosedCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIComplexityCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIConcreteReleaseCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIDescriptionCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIFeatureTypeCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIHintsCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBILastEditorCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBINameCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIOpenCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIProjectCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIProjectNameCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIRelationDestCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIRelationTypeCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBIReleaseCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBISprintDescCriterion;
import fhdw.ipscrum.shared.model.search.criteria.PBISprintNameCriterion;
import fhdw.ipscrum.shared.model.search.criteria.ScruumleCriterion;

public interface ISearchExpressionVisitor {

	void handleOr(Or or);

	void handleAnd(And and);

	void handleNot(Not not);

	void handleBugSystemCriteria(BugSystemCriterion bugSystemCriteria);

	void handleBugVersionCriteria(BugVersionCriterion bugVersionCriteria);

	void handlePBIAcceptanceCriteria(
			PBIAcceptanceCriterion pbiAcceptanceCriteria);

	void handlePBIClosedCriteria(PBIClosedCriterion pbiClosedCriteria);

	void handlePBIComplexityCriteria(
			PBIComplexityCriterion pbiComplexityCriteria);

	void handlePBIHintsCritera(PBIHintsCriterion pbiHintsCritera);

	void handlePBIDescriptionCriteria(
			PBIDescriptionCriterion pbiDescriptionCriteria);

	void handlePBILastEditorCriteria(
			PBILastEditorCriterion pbiLastEditorCriteria);

	void handlePBINameCriteria(PBINameCriterion pbiNameCriteria);

	void handlePBIOpenCriteria(PBIOpenCriterion pbiOpenCriteria);

	void handlePBIProjectCriteria(PBIProjectCriterion pbiProjectCriteria);

	void handlePBIProjectNameCriteria(PBIProjectNameCriterion pbiProjectCriteria);

	void handlePBIRelationDestCriteria(
			PBIRelationDestCriterion pbiRelationDestCriteria);

	void handlePBIRelationTypeCriteria(
			PBIRelationTypeCriterion pbiRelationTypeCriteria);

	void handlePBIReleaseNameCriteria(PBIReleaseCriterion pbiReleaseCriteria);

	void handlePBISprintDescCriteria(
			PBISprintDescCriterion pbiSprintDescCriteria);

	void handlePBISprintName(PBISprintNameCriterion pbiSprintName);

	void handleScruumleCriterion(ScruumleCriterion scruumleCriterion);

	void handleBugTypeCriterion(PBIBugTypeCriterion scruumleCriterion);

	void handleFeatureTypeCriterion(PBIFeatureTypeCriterion scruumleCriterion);

	void handlePBIConcreteReleaseCriterion(
			PBIConcreteReleaseCriterion scruumleCriterion);

	void handleBugConcreteVersionCriteria(
			BugConcreteVersionCriterion scruumleCriterion);

}
