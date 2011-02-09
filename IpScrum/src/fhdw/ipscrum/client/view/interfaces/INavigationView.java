package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Panel;

public interface INavigationView extends IView{

	public abstract MenuItem getMntmProjekte();

	public abstract MenuItem getMntmPersonenstammdaten();

	public abstract MenuItem getMntmTeamzuordnung();
	
	public abstract Panel getContentPanel();
	
}
