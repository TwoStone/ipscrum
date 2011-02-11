package fhdw.ipscrum.client.view.interfaces;

import java.util.List;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.RelationType;

public interface IRelationView extends IView {
	IEvent<EventArgs> getAbort();

	IEvent<EventArgs> getCreateNewType();

	Panel getCreateNewTypePanel();

	IEvent<EventArgs> getSave();

	Feature getSelectedTarget();

	RelationType getSelectedType();

	void setOwningFeature(Feature feature);

	void setRelationTypes(List<RelationType> types);

	void setTargetFeatures(List<Feature> features);
}
