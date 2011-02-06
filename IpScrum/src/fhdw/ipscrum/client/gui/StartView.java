package fhdw.ipscrum.client.gui;


import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class StartView extends Composite{
	
	
	public StartView(){
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("800", "300");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(20);
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setSize("800", "60");
		
		Image image_1 = new Image("images/fhdw_logo.png");
		horizontalPanel.add(image_1);
		image_1.setSize("89px", "39px");
		
		Label lblKennwort = new Label("Angemeldet als:");
		horizontalPanel.add(lblKennwort);
		lblKennwort.setWidth("102px");
		
		TextBox textBox = new TextBox();
		textBox.setReadOnly(true);
		horizontalPanel.add(textBox);
		textBox.setWidth("150px");
		textBox.setText("Max Mustermann");
		
		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2.setSpacing(20);
		horizontalPanel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(horizontalPanel_2);
		
		Label label_1 = new Label("Willkommen beim Integrationsprojekt der Studiengruppe HFW408");
		horizontalPanel_2.add(label_1);
		label_1.setWidth("826px");
		label_1.setStyleName("header2");
		
		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		horizontalPanel_3.setSpacing(20);
		verticalPanel.add(horizontalPanel_3);
		
		Label lblProjekte_1 = new Label("Projekte:");
		horizontalPanel_3.add(lblProjekte_1);
		lblProjekte_1.setStyleName("header3");
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(20);
		verticalPanel.add(horizontalPanel_1);
		horizontalPanel_1.setSize("800", "100");
		
		Button button_1 = new Button("New button");
		button_1.setText("Scrum");
		horizontalPanel_1.add(button_1);
		button_1.setSize("106px", "36px");
		
		Button button_2 = new Button("New button");
//		button_2.addClickHandler(new ClickHandler() {
//			public void onClick(ClickEvent event) {
//				rootPanel.clear();
//				Projekt_Erstellen neuesProjekt = new Projekt_Erstellen();
//				neuesProjekt.einstieg(rootPanel, benutzername);}
//			
//		});
		button_2.setText("Neues Projekt\r\n");
		button_2.setSize("106px", "36px");
		horizontalPanel_1.add(button_2);

		
	}
}



