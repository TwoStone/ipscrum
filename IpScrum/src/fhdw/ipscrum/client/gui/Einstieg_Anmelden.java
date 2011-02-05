package fhdw.ipscrum.client.gui;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class Einstieg_Anmelden extends Composite{ 
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void einstieg(final RootPanel rootPanel) {
		
		/* Adding the mainPanel to the static HTML page inside the tag with ID="mainPanel" */
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		rootPanel.add(horizontalPanel, 15, 15);
		horizontalPanel.setSize("800px", "40px");
		
		Label label = new Label("");
		horizontalPanel.add(label);
		
		Image image_1 = new Image("images/fhdw_logo.png");
		horizontalPanel.add(image_1);
		image_1.setSize("89px", "39px");
		
		Label lblBenutzername = new Label("Benutzername: ");
		horizontalPanel.add(lblBenutzername);
		lblBenutzername.setWidth("90px");
		
		final TextBox textBox = new TextBox();
		horizontalPanel.add(textBox);
		textBox.setWidth("150px");
		
		Label lblKennwort = new Label("Kennwort:");
		horizontalPanel.add(lblKennwort);
		lblKennwort.setWidth("70px");
		
		PasswordTextBox passwordTextBox = new PasswordTextBox();
		horizontalPanel.add(passwordTextBox);
		passwordTextBox.setWidth("150px");
		
		
		Button button = new Button("New button");
		button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				String benutzername = textBox.getText();
				if (benutzername.equals("")){
					Window.alert("Bitte einen Benutzernamen eingeben!"); 
				}else{
				rootPanel.clear();
				Einstieg_Angemeldet angemeldet = new Einstieg_Angemeldet();
				angemeldet.einstieg(rootPanel, benutzername);}
			}
		});
		button.setText("Login");
		horizontalPanel.add(button);
		
		Image image = new Image("images/Black_Line.PNG");
		rootPanel.add(image, 10, 55);
		image.setSize("780px", "16px");
		
		Label lblWillkommenBeimIntegrationsprojekt = new Label("Willkommen beim Integrationsprojekt der Studiengruppe HFW408");
		rootPanel.add(lblWillkommenBeimIntegrationsprojekt, 15, 90);
		lblWillkommenBeimIntegrationsprojekt.setWidth("780px");
		lblWillkommenBeimIntegrationsprojekt.setStyleName("header");
	}
}
