package fhdw.ipscrum.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

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
		
		/* Adding the mainPanel to the static HTML page inside the tag with ID="mainPanel" */
		RootPanel.get("mainPanel").add(mainPanel);
	}
}
