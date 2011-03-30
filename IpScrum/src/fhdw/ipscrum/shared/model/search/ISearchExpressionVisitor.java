package fhdw.ipscrum.shared.model.search;

import fhdw.ipscrum.shared.model.search.criterias.BugSystemCriteria;
import fhdw.ipscrum.shared.model.search.criterias.BugVersionCriteria;
import fhdw.ipscrum.shared.model.search.criterias.PBIAcceptanceCriteria;
import fhdw.ipscrum.shared.model.search.criterias.PBIClosedCriteria;
import fhdw.ipscrum.shared.model.search.criterias.PBIComplexityCriteria;
import fhdw.ipscrum.shared.model.search.criterias.PBIDescriptionCriteria;
import fhdw.ipscrum.shared.model.search.criterias.PBIHintsCritera;
import fhdw.ipscrum.shared.model.search.criterias.PBILastEditorCriteria;
import fhdw.ipscrum.shared.model.search.criterias.PBINameCriteria;
import fhdw.ipscrum.shared.model.search.criterias.PBIOpenCriteria;
import fhdw.ipscrum.shared.model.search.criterias.PBIProjectCriteria;
import fhdw.ipscrum.shared.model.search.criterias.PBIRelationDestCriteria;
import fhdw.ipscrum.shared.model.search.criterias.PBIRelationTypeCriteria;
import fhdw.ipscrum.shared.model.search.criterias.PBIReleaseCriteria;
import fhdw.ipscrum.shared.model.search.criterias.PBISprintDescCriteria;
import fhdw.ipscrum.shared.model.search.criterias.PBISprintName;

public interface ISearchExpressionVisitor {

	void handleOr(Or or);

	void handleAnd(And and);

	void handleNot(ISearchExpressionVisitor visitor);

	void handleBugSystemCriteria(BugSystemCriteria bugSystemCriteria);

	void handleBugVersionCriteria(BugVersionCriteria bugVersionCriteria);

	void handlePBIAcceptanceCriteria(PBIAcceptanceCriteria pbiAcceptanceCriteria);

	void handlePBIClosedCriteria(PBIClosedCriteria pbiClosedCriteria);

	void handlePBIComplexityCriteria(PBIComplexityCriteria pbiComplexityCriteria);

	void handlePBIHintsCritera(PBIHintsCritera pbiHintsCritera);

	void handlePBIDescriptionCriteria(
			PBIDescriptionCriteria pbiDescriptionCriteria);

	void handlePBILastEditorCriteria(PBILastEditorCriteria pbiLastEditorCriteria);

	void handlePBINameCriteria(PBINameCriteria pbiNameCriteria);

	void handlePBIOpenCriteria(PBIOpenCriteria pbiOpenCriteria);

	void handlePBIProjectCriteria(PBIProjectCriteria pbiProjectCriteria);

	void handlePBIRelationDestCriteria(
			PBIRelationDestCriteria pbiRelationDestCriteria);

	void handlePBIRelationTypeCriteria(
			PBIRelationTypeCriteria pbiRelationTypeCriteria);

	void handlePBIReleaseCriteria(PBIReleaseCriteria pbiReleaseCriteria);

	void handlePBISprintDescCriteria(PBISprintDescCriteria pbiSprintDescCriteria);

	void handlePBISprintName(PBISprintName pbiSprintName);

	void handleNoSearchExpression(NoSearchExpression noSearchExpression);

}
