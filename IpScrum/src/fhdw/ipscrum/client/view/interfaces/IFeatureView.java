package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.view.client.HasData;

import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.events.args.RemoveCriterionEventArgs;
import fhdw.ipscrum.client.events.args.RemoveHintEventArgs;
import fhdw.ipscrum.client.events.args.RemoveRelationEventArgs;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.Relation;


public interface IFeatureView extends IView {
	HasText getName();
	HasText getState();
	HasText getDescription();
	HasValue<Integer> getComplexity();
	
	HasClickHandlers getSave();
	HasClickHandlers getAbort();
	
	HasClickHandlers getCloseFeature();
	
	HasClickHandlers getCreateRelation();
	HasClickHandlers getCreateHint();
	HasClickHandlers getCreateCriterion();
	
	HasData<Relation> getRelations();
	HasData<Hint> getHints();
	HasData<AcceptanceCriterion> getCriteria();
	
	Panel getAddCriterionPanel();
	Panel getAddHintPanel();
	
	IEvent<RemoveRelationEventArgs> getRemoveRelation();
	IEvent<RemoveCriterionEventArgs> getRemoveCriterion();
	IEvent<RemoveHintEventArgs> getRemoveHint();
}