package fhdw.ipscrum.client.gui;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class ProjectOverviewView extends Composite{
	
	public ProjectOverviewView(){
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("800px", "200");
		
		HorizontalPanel horizontalPanel_3 = new HorizontalPanel();
		horizontalPanel_3.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_3.setSpacing(20);
		horizontalPanel_3.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(horizontalPanel_3);
		horizontalPanel_3.setSize("800", "60");
		
		Image image = new Image("images/fhdw_logo.png");
		horizontalPanel_3.add(image);
		image.setSize("89px", "39px");
		
		Label label = new Label("Angemeldet als:");
		horizontalPanel_3.add(label);
		label.setWidth("102px");
		
		TextBox textBox_2 = new TextBox();
		textBox_2.setText("Max Mustermann");
		textBox_2.setReadOnly(true);
		horizontalPanel_3.add(textBox_2);
		textBox_2.setWidth("150px");
		
		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2.setSpacing(20);
		verticalPanel.add(horizontalPanel_2);
		
		Label lblProjektErstellen = new Label("Projekt > Scrum");
		horizontalPanel_2.add(lblProjektErstellen);
		lblProjektErstellen.setStyleName("header4");
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(20);
		verticalPanel.add(horizontalPanel_1);
		
		Button button = new Button("New button");
		horizontalPanel_1.add(button);
		button.setText("ProductBacklog");
		button.setWidth("130px");
		
		Button button_1 = new Button("New button");
		button_1.setText("Releaseplan");
		horizontalPanel_1.add(button_1);
	

}
}
