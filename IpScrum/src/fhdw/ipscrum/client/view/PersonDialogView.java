package fhdw.ipscrum.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.VerticalSplitPanel;

public class PersonDialogView extends Composite {

	public PersonDialogView() {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("320px", "170px");
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel.add(verticalPanel_1);
		verticalPanel_1.setSize("320px", "100px");
		
		VerticalPanel verticalPanel_2 = new VerticalPanel();
		verticalPanel_1.add(verticalPanel_2);
		verticalPanel_2.setSize("185px", "50px");
		
		Label label = new Label("Vorname");
		verticalPanel_2.add(label);
		
		TextBox textBox = new TextBox();
		verticalPanel_2.add(textBox);
		
		VerticalPanel verticalPanel_3 = new VerticalPanel();
		verticalPanel_1.add(verticalPanel_3);
		verticalPanel_3.setSize("185px", "50px");
		
		Label label_1 = new Label("Nachname");
		verticalPanel_3.add(label_1);
		
		TextBox textBox_1 = new TextBox();
		verticalPanel_3.add(textBox_1);
		
		VerticalPanel verticalPanel_4 = new VerticalPanel();
		verticalPanel_4.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel_4.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		verticalPanel.add(verticalPanel_4);
		verticalPanel_4.setSize("320px", "70px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel_4.add(horizontalPanel);
		horizontalPanel.setSize("219px", "36px");
		
		Button button = new Button("New button");
		button.setText("OK");
		horizontalPanel.add(button);
		button.setSize("100px", "28px");
		
		Button button_1 = new Button("New button");
		button_1.setText("Abberchen");
		horizontalPanel.add(button_1);
		button_1.setSize("100px", "28px");
	}

}
