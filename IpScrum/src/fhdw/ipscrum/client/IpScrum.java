package fhdw.ipscrum.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.view.ProductBacklogView;
import fhdw.ipscrum.client.view.ProjectCreateView;
import fhdw.ipscrum.client.view.ProjectOverviewView;
import fhdw.ipscrum.client.view.StartLoggedInView;
import fhdw.ipscrum.client.view.StartView;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class IpScrum implements EntryPoint {
	
	/**
	 * Panel containing the GWT stuff
	 * Change to whatever panel implementation is useful!
	 */
	private static Panel mainPanel =  new VerticalPanel();
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		
		RootPanel rootPanel = RootPanel.get("mainPanel");
		
ProductBacklogView pb = new ProductBacklogView();
StartLoggedInView einstieg = new StartLoggedInView();
StartView einstieg_angemeldet = new StartView();
ProjectCreateView pe = new ProjectCreateView();
ProjectOverviewView pue = new ProjectOverviewView();
//DialogBox dialog = new DialogBox();
//dialog.add(einstieg);
//dialog.show();

rootPanel.add(pb); 	
	}
 }
	
