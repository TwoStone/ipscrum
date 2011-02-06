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
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class StartLoggedInView extends Composite{ 
	
public StartLoggedInView(){
	
		FlowPanel flowPanel = new FlowPanel();
		initWidget(flowPanel);
		flowPanel.setSize("800px", "600");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(20);
		flowPanel.add(horizontalPanel);
		horizontalPanel.setSize("800", "60");
		
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
		horizontalPanel.add(button);
		//		button.addClickHandler(new ClickHandler() {
		//			public void onClick(ClickEvent event) {
		//				String benutzername = textBox.getText();
		//				if (benutzername.equals("")){
		//					Window.alert("Bitte einen Benutzernamen eingeben!"); 
		//				}else{
		//				rootPanel.clear();
		//				Einstieg_Angemeldet angemeldet = new Einstieg_Angemeldet();
		//				angemeldet.einstieg(rootPanel, benutzername);}
		//		);
				button.setText("Login");
				
				HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
				horizontalPanel_1.setSpacing(20);
				horizontalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
				flowPanel.add(horizontalPanel_1);
				horizontalPanel_1.setSize("800", "300");
				
				Label lblWillkommenBeimIntegrationsprojekt = new Label("Willkommen beim Integrationsprojekt der Studiengruppe HFW408");
				lblWillkommenBeimIntegrationsprojekt.setStyleName("header");
				lblWillkommenBeimIntegrationsprojekt.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
				lblWillkommenBeimIntegrationsprojekt.setSize("800", "300");
				horizontalPanel_1.add(lblWillkommenBeimIntegrationsprojekt);


}}
