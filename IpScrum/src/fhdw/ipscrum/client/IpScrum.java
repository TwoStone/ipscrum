package fhdw.ipscrum.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RichTextArea;

import fhdw.ipscrum.client.gui.Einstieg_Anmelden;

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
rootPanel.add(mainPanel);

	Einstieg_Anmelden einstieg = new Einstieg_Anmelden();
	einstieg.einstieg(rootPanel);


	}
}