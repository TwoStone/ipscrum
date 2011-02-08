package fhdw.ipscrum.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

public class SprintDialogView extends Composite {

	public SprintDialogView() {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("320px", "200px");
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel.add(verticalPanel_1);
		verticalPanel_1.setSize("320px", "50px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel_1.add(horizontalPanel);
		
		VerticalPanel verticalPanel_3 = new VerticalPanel();
		horizontalPanel.add(verticalPanel_3);
		verticalPanel_3.setSize("180px", "");
		
		Label lblStarttermin = new Label("Starttermin");
		verticalPanel_3.add(lblStarttermin);
		
		DateBox dateBox = new DateBox();
		verticalPanel_3.add(dateBox);
		
		VerticalPanel verticalPanel_4 = new VerticalPanel();
		horizontalPanel.add(verticalPanel_4);
		verticalPanel_4.setWidth("140px");
		
		Label lblEndtermin = new Label("Endtermin");
		verticalPanel_4.add(lblEndtermin);
		
		DateBox dateBox_1 = new DateBox();
		verticalPanel_4.add(dateBox_1);
		
		VerticalPanel verticalPanel_2 = new VerticalPanel();
		verticalPanel.add(verticalPanel_2);
		verticalPanel_2.setSize("320px", "60px");
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel_2.add(horizontalPanel_1);
		horizontalPanel_1.setSize("320px", "60px");
		
		VerticalPanel verticalPanel_5 = new VerticalPanel();
		horizontalPanel_1.add(verticalPanel_5);
		verticalPanel_5.setSize("180px", "50px");
		
		Label label = new Label("Team:");
		verticalPanel_5.add(label);
		
		ListBox listBox = new ListBox();
		verticalPanel_5.add(listBox);
		listBox.setSize("148px", "22px");
		
		VerticalPanel verticalPanel_6 = new VerticalPanel();
		verticalPanel_6.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		horizontalPanel_1.add(verticalPanel_6);
		verticalPanel_6.setSize("140px", "40px");
		
		Button button = new Button("New button");
		button.setText("Zuordnen");
		verticalPanel_6.add(button);
		button.setSize("100px", "28px");
		
		VerticalPanel verticalPanel_7 = new VerticalPanel();
		verticalPanel_7.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		verticalPanel_7.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel.add(verticalPanel_7);
		verticalPanel_7.setSize("320px", "90px");
		
		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		horizontalPanel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel_7.add(horizontalPanel_2);
		horizontalPanel_2.setSize("219px", "36px");
		
		Button button_1 = new Button("New button");
		button_1.setText("OK");
		horizontalPanel_2.add(button_1);
		button_1.setSize("100px", "28px");
		
		Button button_2 = new Button("New button");
		button_2.setText("Abberchen");
		horizontalPanel_2.add(button_2);
		button_2.setSize("100px", "28px");
	}

}
