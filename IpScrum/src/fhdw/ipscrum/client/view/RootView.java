package fhdw.ipscrum.client.view;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PersonArgs;
import fhdw.ipscrum.client.view.interfaces.IRootView;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

/**
 * RootView. Used for the main layout of the application.
 * This composite also contains the login form.
 */
public class RootView extends Composite implements IRootView {
	private final ListBox comboBoxUsers;
	private final HashMap<Integer,IPerson> userMap = new HashMap<Integer,IPerson>();
	private final Button btnLogin;
	private final Button btnLogout;
	private final Event<PersonArgs> loginEvent = new Event<PersonArgs>();
	private final Event<EventArgs> logoutEvent = new Event<EventArgs>();
	private final VerticalPanel contentPanel;

	public RootView() {

		FlowPanel mainPanel = new FlowPanel();
		initWidget(mainPanel);
		mainPanel.setSize("1000px", "700px");

		HorizontalPanel headPanel = new HorizontalPanel();
		mainPanel.add(headPanel);
		headPanel.setSize("1000px", "50px");

		Image image = new Image("images/logoSmall.png");
		headPanel.add(image);
		image.setSize("157px", "50px");

		HorizontalPanel loginPanel = new HorizontalPanel();
		loginPanel.setSpacing(5);
		headPanel.add(loginPanel);
		headPanel.setCellVerticalAlignment(loginPanel, HasVerticalAlignment.ALIGN_MIDDLE);
		headPanel.setCellHorizontalAlignment(loginPanel, HasHorizontalAlignment.ALIGN_RIGHT);

		this.comboBoxUsers = new ListBox();
		loginPanel.add(this.comboBoxUsers);
		this.comboBoxUsers.setSize("150px", "22px");

		HorizontalPanel loginButtonPanel = new HorizontalPanel();
		loginPanel.add(loginButtonPanel);

		this.btnLogin = new Button("Login");
		loginButtonPanel.add(this.btnLogin);
		this.btnLogin.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				RootView.this.loginEvent.fire(RootView.this, new PersonArgs(RootView.this.getSelectedUser()));
			}
		});
		this.btnLogin.setSize("66px", "22px");

		this.btnLogout = new Button("Logout");
		loginButtonPanel.add(this.btnLogout);
		this.btnLogout.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				RootView.this.logoutEvent.fire(RootView.this, new EventArgs());
			}
		});
		this.btnLogout.setSize("66px", "22px");

		this.contentPanel = new VerticalPanel();
		mainPanel.add(this.contentPanel);
		this.contentPanel.setSize("1000px", "650px");
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.interfaces.IRootView#fillComboBoxUsers(java.util.ArrayList)
	 */
	@Override
	public void fillComboBoxUsers(ArrayList<IPerson> tempUserList) {
		this.comboBoxUsers.clear();
		for (int i = 0; i < tempUserList.size(); i++) {
			this.comboBoxUsers.addItem(tempUserList.get(i).toString());
			this.userMap.put(i, tempUserList.get(i));
		}
	}

	/**
	 * Returns the selected user of the ComboBox.
	 * @return selected user as an instance of IPerson
	 */
	private IPerson getSelectedUser() {
		return this.userMap.get(this.comboBoxUsers.getSelectedIndex());
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.interfaces.IRootView#activateLogin()
	 */
	@Override
	public void activateLogin() {
		this.comboBoxUsers.setEnabled(true);
		this.btnLogin.setEnabled(true);
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.interfaces.IRootView#deactivateLogin()
	 */
	@Override
	public void deactivateLogin() {
		this.comboBoxUsers.setEnabled(false);
		this.btnLogin.setEnabled(false);
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.interfaces.IRootView#getContentPanel()
	 */
	@Override
	public VerticalPanel getContentPanel() {
		return this.contentPanel;
	}

	@Override
	public void defineLoginEvent(EventHandler<PersonArgs> args) {
		this.loginEvent.add(args);
	}

	@Override
	public void defineLogoutEvent(EventHandler<EventArgs> args) {
		this.logoutEvent.add(args);
	}
}
