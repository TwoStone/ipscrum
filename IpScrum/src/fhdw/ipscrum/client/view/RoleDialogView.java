package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;

import fhdw.ipscrum.client.view.interfaces.IRoleDialogView;

public class RoleDialogView extends Composite implements IRoleDialogView {

	private TextBox role;
	private Button ok_button;
	private Button abb_button_1;

	public RoleDialogView() {
		
		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("320px", "120px");
		
		VerticalPanel topPanel = new VerticalPanel();
		verticalPanel.add(topPanel);
		topPanel.setSize("320px", "76px");
		
		VerticalPanel rolePanel = new VerticalPanel();
		topPanel.add(rolePanel);
		rolePanel.setWidth("320px");
		
		Label label = new Label("Rollenbezeichnung");
		rolePanel.add(label);
		label.setSize("115px", "19px");
		
		role = new TextBox();
		rolePanel.add(role);
		role.setSize("261px", "16px");
		
		VerticalPanel bottomPanel = new VerticalPanel();
		bottomPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		bottomPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		verticalPanel.add(bottomPanel);
		bottomPanel.setSize("320px", "64px");
		
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		bottomPanel.add(buttonPanel);
		buttonPanel.setSize("219px", "36px");
		
		ok_button = new Button("New button");
		ok_button.setText("OK");
		buttonPanel.add(ok_button);
		ok_button.setSize("100px", "28px");
		
		abb_button_1 = new Button("New button");
		abb_button_1.setText("Abberchen");
		buttonPanel.add(abb_button_1);
		abb_button_1.setSize("100px", "28px");
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IRoleDialogView#getRole()
	 */
	@Override
	public HasText getRole() {
		return role;
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IRoleDialogView#getOk_button()
	 */
	@Override
	public HasClickHandlers getOk_button() {
		return ok_button;
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IRoleDialogView#getAbb_button_1()
	 */
	@Override
	public HasClickHandlers getAbb_button_1() {
		return abb_button_1;
	}

}
