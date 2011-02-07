package fhdw.ipscrum.client.view;

import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.view.interfaces.IRootView;

public class RootView extends Composite implements IRootView {
	private Button btnLogin;
	private TextBox inputPassword;
	private TextBox inputUserName;
	private Button button;
	private VerticalPanel contentPanel;
	private final FlowPanel flowPanel;

	public static IRootView createView() {
		return new RootView();
	}

	private RootView() {

		flowPanel = new FlowPanel();
		initWidget(flowPanel);
		flowPanel.setSize("1000px", "700px");

		AbsolutePanel loginpanel = new AbsolutePanel();
		flowPanel.add(loginpanel);
		loginpanel.setSize("1000px", "50px");

		inputUserName = new TextBox();
		inputUserName.setText("Benutzername");
		loginpanel.add(inputUserName, 590, 10);
		inputUserName.setSize("112px", "20px");

		inputPassword = new TextBox();
		inputPassword.setText("Password");
		loginpanel.add(inputPassword, 716, 10);
		inputPassword.setSize("112px", "20px");

		btnLogin = new Button("Login");
		loginpanel.add(btnLogin, 852, 10);
		btnLogin.setSize("66px", "28px");

		button = new Button("Logout");
		loginpanel.add(button, 924, 10);
		button.setSize("66px", "28px");
		
		Image image = new Image("images/fhdw-logo.PNG");
		loginpanel.add(image, 0, 0);
		image.setSize("105px", "50px");

		contentPanel = new VerticalPanel();
		flowPanel.add(contentPanel);
		contentPanel.setSize("1000px", "650px");
	}
	
	@Override
	public void activateLogin() {
		this.getInputUserName().setEnabled(true);
		this.getInputUserName().setText("Benutzername");
		this.getInputPassword().setEnabled(true);
		this.getInputPassword().setText("Passwort");
		this.getBtnLogin().setEnabled(true);
	}
	
	@Override
	public void deactivateLogin() {
		this.getInputUserName().setEnabled(false);
		this.getInputPassword().setEnabled(false);
		this.getBtnLogin().setEnabled(false);
	}

	public Button getBtnLogin() {
		return btnLogin;
	}

	public TextBox getInputPassword() {
		return inputPassword;
	}

	public TextBox getInputUserName() {
		return inputUserName;
	}

	public Button getButtonLogout() {
		return button;
	}

	public VerticalPanel getContentPanel() {
		return contentPanel;
	}
}
