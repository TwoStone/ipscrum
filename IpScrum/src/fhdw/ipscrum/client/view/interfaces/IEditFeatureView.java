package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.shared.model.interfaces.IFeatureState;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public interface IEditFeatureView extends ICreateFeatureView {

	void setComplexity(Integer complexity);

	Integer getComplexity();

	void setState(IFeatureState state);

	IEvent<EventArgs> toggleFeatureState();

	void setLastEditor(IPerson editor);

}
