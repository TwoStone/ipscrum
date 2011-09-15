package fhdw.ipscrum.client.architecture.widgets;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.resources.MyResources;
import fhdw.ipscrum.client.resources.css.Login;
import fhdw.ipscrum.client.services.LoginService;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.session.User;

/**
 * represents the GUI which is needed to login the IPScrum.
 */
public class LoginView extends Composite implements KeyPressHandler, ILoginView {

	private static final int ERROR_MESSAGE_TIME = 3000;

	static {
		MyResources.INSTANCE.login().ensureInjected();
	}

	private final Event<LoggedInEventArgs> loggedInEvent;
	private final Label messageLabel;
	private final Timer messageTimer;
	private final TextBox usernameTextBox;
	private final PasswordTextBox passwordTextBox;
	private PopupPanel myPopup;
	private final Login resource;
	private final VerticalPanel verticalPanel;

	/**
	 * constructor of the LoginView.
	 */
	public LoginView() {
		super();
		this.resource = MyResources.INSTANCE.login();

		this.loggedInEvent = new Event<LoggedInEventArgs>();
		this.messageTimer = new Timer() {

			@Override
			public void run() {
				LoginView.this.messageLabel.setText("");
			}
		};

		this.verticalPanel = new VerticalPanel();
		this.verticalPanel.setSpacing(5);
		this.initWidget(this.verticalPanel);
		this.verticalPanel.setSize("80%", "auto");

		final Label usernameLabel = new Label("Benutzername");
		usernameLabel.setStyleName(this.resource.loginWidgetLabel());
		this.verticalPanel.add(usernameLabel);

		this.usernameTextBox = new TextBox();
		this.usernameTextBox.addKeyPressHandler(this);
		this.usernameTextBox.setStyleName(this.resource.loginWidgetTextbox());
		this.verticalPanel.add(this.usernameTextBox);
		this.verticalPanel.setCellHorizontalAlignment(this.usernameTextBox,
				HasHorizontalAlignment.ALIGN_CENTER);
		this.usernameTextBox.setSize("", "");

		final Label passwordLabel = new Label("Passwort");
		passwordLabel.setStyleName(this.resource.loginWidgetLabel());
		this.verticalPanel.add(passwordLabel);

		this.passwordTextBox = new PasswordTextBox();
		this.passwordTextBox.setStyleName(this.resource.loginWidgetTextbox());
		this.verticalPanel.add(this.passwordTextBox);
		this.verticalPanel.setCellHorizontalAlignment(this.passwordTextBox,
				HasHorizontalAlignment.ALIGN_CENTER);
		this.passwordTextBox.addKeyPressHandler(this);

		this.messageLabel = new Label("");
		this.messageLabel.setStyleName(this.resource.loginWidgetMessage());
		this.verticalPanel.add(this.messageLabel);

		final Button btnNewButton = new Button("Anmelden");
		btnNewButton.setStyleName(this.resource.loginWidgetButton());
		btnNewButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {

				LoginView.this.login();
			}
		});
		this.verticalPanel.add(btnNewButton);
		this.verticalPanel.setCellHorizontalAlignment(btnNewButton,
				HasHorizontalAlignment.ALIGN_CENTER);

		GwtUtils.setFocus(this.usernameTextBox);
		this.setStyleName(this.resource.loginWidgetContainer());
	}

	private void login() {
		final String name = this.usernameTextBox.getText();
		final String password = this.passwordTextBox.getText();

		LoginService.Util.getInstance().login(name, password,
				new AsyncCallback<User>() {

					@Override
					public void onSuccess(final User result) {

						final List<Role> userRoles = result.getPerson().getRoles();

						if (userRoles.size() == 1) {
							LoginView.this.loggedInEvent.fire(LoginView.this,
									new LoggedInEventArgs(result, userRoles.get(0)));
						} else {

							final RoleChooserView roleView = new RoleChooserView();

							roleView.refreshRoles(result.getPerson().getRoles());

							LoginView.this.getVerticalPanel().clear();

							LoginView.this.getVerticalPanel().setHorizontalAlignment(
									HasHorizontalAlignment.ALIGN_CENTER);

							LoginView.this.getVerticalPanel().add(roleView);

							roleView.registerGo(new ClickHandler() {

								@Override
								public void onClick(final ClickEvent event) {

									final Role activeRole = roleView.getSelRole();
									if (activeRole != null) {
										LoginView.this.getVerticalPanel().clear();
										LoginView.this.loggedInEvent.fire(
												LoginView.this, new LoggedInEventArgs(
														result, activeRole));
									} else {
										roleView.setFailure("Keine Rolle selektiert!");
									}
								}
							});
						}
					}

					@Override
					public void onFailure(final Throwable caught) {
						LoginView.this.showMessage(caught.getMessage());
						LoginView.this.passwordTextBox.setText("");
					}
				});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.architecture.client.widgets.ILoginView#registerLoginHandler
	 * (fhdw.ipscrum.architecture.client.events.EventHandler)
	 */
	@Override
	public EventRegistration registerLoginHandler(
			final EventHandler<LoggedInEventArgs> handler) {
		return this.loggedInEvent.add(handler);
	}

	private void showMessage(final String message) {
		final String styleName = this.getPopup().getStyleName();
		this.shake("." + styleName, 50, 300);

		this.messageLabel.setText(message);
		this.messageTimer.schedule(LoginView.ERROR_MESSAGE_TIME);
	}

	@Override
	public void onKeyPress(final KeyPressEvent event) {
		final int keyCode = event.getNativeEvent().getKeyCode();
		if (keyCode == KeyCodes.KEY_ENTER) {
			this.login();
		}

	}

	/**
	 * gets the pop up of the login view.
	 * 
	 * @return the pop up
	 */
	public PopupPanel getPopup() {
		if (this.myPopup == null) {

			this.myPopup = new PopupPanel(false, true);
			this.myPopup.add(this);
			this.myPopup.setGlassEnabled(true);
			this.myPopup.setWidth("400px");
			this.myPopup.setStyleName(this.resource.loginWidgetPopup());
			this.myPopup.setGlassStyleName(this.resource.loginWidgetGlass());
		}
		return this.myPopup;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.architecture.client.widgets.ILoginView#showPopup()
	 */
	@Override
	public void showPopup() {
		this.getPopup().center();
		this.usernameTextBox.setFocus(true);
		GwtUtils.setFocus(this.usernameTextBox);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.architecture.client.widgets.ILoginView#hidePopup()
	 */
	@Override
	public void hidePopup() {
		this.getPopup().hide();

	}

	/**
	 * represents the movement of the view to indicate that the login failed.
	 * 
	 * @param selector
	 *            of the shake
	 * @param pixel
	 *            the popup should shake
	 * @param duration
	 *            of the shake
	 */
	private void shake(final String selector, final int pixel, final int duration) {
		final GQuery popup = GQuery.$(selector);
		final int animationDuration = duration / 3;

		popup.animate("left: '+=" + pixel + "px'", animationDuration)
				.animate("left: '-=" + pixel * 2 + "px'", animationDuration)
				.animate("left: '+=" + pixel + "px'", animationDuration);
	}

	public VerticalPanel getVerticalPanel() {
		return this.verticalPanel;
	}
}
