package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Panel;

public interface INavigationView extends IView{

	public abstract HasClickHandlers getPersonalverwaltung();
	
	public abstract HasClickHandlers getProjekte();
	
	public abstract Panel getMasterMainPanel();
	
	
}
