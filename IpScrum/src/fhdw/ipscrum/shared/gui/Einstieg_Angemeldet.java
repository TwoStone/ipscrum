package fhdw.ipscrum.shared.gui;

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
import com.google.gwt.user.client.ui.VerticalSplitPanel;
import com.google.gwt.user.client.ui.HorizontalSplitPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class Einstieg_Angemeldet{
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void einstieg(RootPanel rootPanel, String benutzername) {
		
		/* Adding the mainPanel to the static HTML page inside the tag with ID="mainPanel" */
		VerticalPanel verticalPanel = new VerticalPanel();
		rootPanel.add(verticalPanel, 15, 15);
		verticalPanel.setSize("918px", "288px");
		
		Label label = new Label("");
		verticalPanel.add(label);
		
		verticalPanel.add(label);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setWidth("828px");
		
		Image image_1 = new Image("images/fhdw_logo.png");
		horizontalPanel.add(image_1);
		image_1.setSize("89px", "39px");
		
		Label lblBenutzername = new Label("Integrationsprojekt HFW408");
		horizontalPanel.add(lblBenutzername);
		lblBenutzername.setWidth("174px");
		
		Label lblKennwort = new Label("Angemeldet als:");
		horizontalPanel.add(lblKennwort);
		lblKennwort.setWidth("102px");
		
		TextBox textBox = new TextBox();
		textBox.setReadOnly(true);
		horizontalPanel.add(textBox);
		textBox.setWidth("150px");
		textBox.setText(benutzername);
		
		Label label_1 = new Label("Willkommen beim Integrationsprojekt der Studiengruppe HFW408");
		verticalPanel.add(label_1);
		label_1.setWidth("826px");
		label_1.setStyleName("header2");
		
		Label lblProjekte_1 = new Label("Projekte:");
		lblProjekte_1.setStyleName("header3");
		verticalPanel.add(lblProjekte_1);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);
		horizontalPanel_1.setSize("282px", "40px");
		
		Button button_1 = new Button("New button");
		button_1.setText("Scrum");
		horizontalPanel_1.add(button_1);
		button_1.setSize("106px", "36px");
		
		Button button_2 = new Button("New button");
		button_2.setText("Neues Projekt\r\n");
		button_2.setSize("106px", "36px");
		horizontalPanel_1.add(button_2);
		
		Image image = new Image("images/Black_Line.PNG");
		rootPanel.add(image, 10, 55);
		image.setSize("780px", "16px");

		
	}
}



