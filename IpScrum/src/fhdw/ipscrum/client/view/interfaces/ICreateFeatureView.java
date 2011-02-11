package fhdw.ipscrum.client.view.interfaces;

import java.util.List;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.events.args.RemoveCriterionEventArgs;
import fhdw.ipscrum.client.events.args.RemoveHintEventArgs;
import fhdw.ipscrum.client.events.args.RemoveRelationEventArgs;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public interface ICreateFeatureView extends IView {

	Panel addCriterionPanel();

	Panel addHintPanel();

	IEvent<EventArgs> getAbort();

	IEvent<EventArgs> getCreateCriterion();

	IEvent<EventArgs> getCreateHint();

	IEvent<EventArgs> getCreateRelation();

	String getDescription();

	String getName();

	IEvent<RemoveCriterionEventArgs> getRemoveCriterion();

	IEvent<RemoveHintEventArgs> getRemoveHint();

	IEvent<RemoveRelationEventArgs> getRemoveRelation();

	IEvent<EventArgs> getSave();

	ISprint getSelectedSprint();

	void setCriteria(List<AcceptanceCriterion> criterions);

	void setDescription(String description);

	void setHints(List<Hint> hints);

	void setName(String name);

	void setNewCriterionEnabled(Boolean enabled);

	void setNewHintEnabled(Boolean enabled);

	void setRelations(List<Relation> relations);

	void setSprints(List<ISprint> sprints, ISprint selected);

}