package fhdw.ipscrum.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;

public class Projekt_Erstellen extends Composite{
	
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
		
		Label lblProjektErstellen = new Label("Projekt > Erstellen");
		lblProjektErstellen.setStyleName("header4");
		verticalPanel.add(lblProjektErstellen);
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setSize("252px", "74px");
		verticalPanel.add(verticalPanel_1);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel_1.add(horizontalPanel_1);
		
		Label lblBezeichnung = new Label("Bezeichnung:");
		horizontalPanel_1.add(lblBezeichnung);
		lblBezeichnung.setWidth("94px");
		
		TextBox textBox_1 = new TextBox();
		horizontalPanel_1.add(textBox_1);
		
		Button button = new Button("New button");
		button.setText("Projekt einf\u00FCgen");
		verticalPanel_1.add(button);
		button.setWidth("130px");
		
		Image image = new Image("images/Black_Line.PNG");
		rootPanel.add(image, 10, 55);
		image.setSize("780px", "16px");

}
}
