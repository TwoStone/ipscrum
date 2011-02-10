package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;

public interface ITextView extends IView {

	IEvent<EventArgs> abort();

	String getContent();

	IEvent<EventArgs> save();

	void setContent(String content);

}
