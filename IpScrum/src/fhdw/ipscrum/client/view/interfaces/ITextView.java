package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;

public interface ITextView extends IView {
	
	HasText getContent();
	HasClickHandlers getSave();
	HasClickHandlers getAbort();
	
}
