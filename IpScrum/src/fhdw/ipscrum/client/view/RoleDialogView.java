package fhdw.ipscrum.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

public class RoleDialogView extends Composite {

	public RoleDialogView() {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("320px", "120px");
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel.add(verticalPanel_1);
		verticalPanel_1.setSize("327px", "76px");
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_1.add(horizontalPanel_1);
		horizontalPanel_1.setWidth("120px");
		
		Label lblRole = new Label("Rollenbezeichnung");
		horizontalPanel_1.add(lblRole);
		lblRole.setSize("115px", "19px");
		
		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_1.add(horizontalPanel_2);
		horizontalPanel_2.setSize("279px", "50px");
		
		TextBox role = new TextBox();
		horizontalPanel_2.add(role);
		role.setSize("261px", "16px");
		
		VerticalPanel verticalPanel_2 = new VerticalPanel();
		verticalPanel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel_2.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		verticalPanel.add(verticalPanel_2);
		verticalPanel_2.setSize("327px", "64px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel_2.add(horizontalPanel);
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
