package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusListener;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.client.view.interfaces.IRootView;
import com.google.gwt.user.client.ui.PasswordTextBox;

/**
 */
public class RootView extends Composite implements IRootView {
	private Button btnLogin;
	private PasswordTextBox inputPassword;
	private TextBox inputUserName;
	private Button button;
	private VerticalPanel contentPanel;
	private final FlowPanel flowPanel;

	/**
	 * Method createView.
	 * @return IRootView
	 */
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
		inputUserName.addFocusHandler(new FocusHandler() {
			public void onFocus(FocusEvent event) {
				if (inputUserName.getText().equals("Benutzername")) {
					inputUserName.setText("");
				}
			}
		});

		inputPassword = new PasswordTextBox();
		inputPassword.setText("Passwort");
		loginpanel.add(inputPassword, 716, 10);
		inputPassword.setSize("112px", "20px");

		btnLogin = new Button("Login");
		loginpanel.add(btnLogin, 852, 10);
		btnLogin.setSize("66px", "28px");

		button = new Button("Logout");
		loginpanel.add(button, 924, 10);
		button.setSize("66px", "28px");
		
		Image image = new Image("images/logoSmall.png");
		loginpanel.add(image, 0, 0);
		image.setSize("157px", "50px");

		contentPanel = new VerticalPanel();
		flowPanel.add(contentPanel);
		contentPanel.setSize("1000px", "650px");
	}
	
	/**
	 * Method activateLogin.
	 * @see fhdw.ipscrum.client.view.interfaces.IRootView#activateLogin()
	 */
	@Override
	public void activateLogin() {
		this.getInputUserName().setEnabled(true);
		this.getInputUserName().setText("Benutzername");
		this.getInputPassword().setEnabled(true);
		this.getInputPassword().setText("Passwort");
		this.getBtnLogin().setEnabled(true);
	}
	
	/**
	 * Method deactivateLogin.
	 * @see fhdw.ipscrum.client.view.interfaces.IRootView#deactivateLogin()
	 */
	@Override
	public void deactivateLogin() {
		this.getInputUserName().setEnabled(false);
		this.getInputPassword().setEnabled(false);
		this.getBtnLogin().setEnabled(false);
	}

	/**
	 * Method getBtnLogin.
	 * @return Button
	 * @see fhdw.ipscrum.client.view.interfaces.IRootView#getBtnLogin()
	 */
	public Button getBtnLogin() {
		return btnLogin;
	}

	/**
	 * Method getInputPassword.
	 * @return TextBox
	 * @see fhdw.ipscrum.client.view.interfaces.IRootView#getInputPassword()
	 */
	public TextBox getInputPassword() {
		return inputPassword;
	}

	/**
	 * Method getInputUserName.
	 * @return TextBox
	 * @see fhdw.ipscrum.client.view.interfaces.IRootView#getInputUserName()
	 */
	public TextBox getInputUserName() {
		return inputUserName;
	}

	/**
	 * Method getButtonLogout.
	 * @return Button
	 * @see fhdw.ipscrum.client.view.interfaces.IRootView#getButtonLogout()
	 */
	public Button getButtonLogout() {
		return button;
	}

	/**
	 * Method getContentPanel.
	 * @return VerticalPanel
	 * @see fhdw.ipscrum.client.view.interfaces.IRootView#getContentPanel()
	 */
	public VerticalPanel getContentPanel() {
		return contentPanel;
	}
}
