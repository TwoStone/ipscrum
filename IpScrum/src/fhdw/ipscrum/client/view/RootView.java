package fhdw.ipscrum.client.view;

import java.util.ArrayList;
import java.util.HashMap;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
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
 */
public class RootView extends Composite implements IRootView {
	private final ListBox comboBoxUsers;
	private final Button btnLogin;
	private final Button btnLogout;
	private final Event<PersonArgs> loginEvent = new Event<PersonArgs>();
	private final Event<EventArgs> logoutEvent = new Event<EventArgs>();
	private final VerticalPanel contentPanel;
	private final HashMap<Integer,IPerson> userMap = new HashMap<Integer,IPerson>();

	public RootView() {

		FlowPanel mainPanel = new FlowPanel();
		initWidget(mainPanel);
		mainPanel.setSize("1000px", "700px");

		AbsolutePanel loginPanel = new AbsolutePanel();
		mainPanel.add(loginPanel);
		loginPanel.setSize("1000px", "50px");

		Image image = new Image("images/logoSmall.png");
		loginPanel.add(image, 0, 0);
		image.setSize("157px", "50px");

		this.comboBoxUsers = new ListBox();
		loginPanel.add(this.comboBoxUsers, 590, 10);
		this.comboBoxUsers.setSize("242px", "28px");

		this.btnLogin = new Button("Login");
		this.btnLogin.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				RootView.this.loginEvent.fire(RootView.this, new PersonArgs(RootView.this.getSelectedUser()));
			}
		});
		loginPanel.add(this.btnLogin, 852, 10);
		this.btnLogin.setSize("66px", "28px");

		this.btnLogout = new Button("Logout");
		this.btnLogout.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				RootView.this.logoutEvent.fire(RootView.this, new EventArgs());
			}
		});
		loginPanel.add(this.btnLogout, 924, 10);
		this.btnLogout.setSize("66px", "28px");

		this.contentPanel = new VerticalPanel();
		mainPanel.add(this.contentPanel);
		this.contentPanel.setSize("1000px", "650px");
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IRootView#fillComboBoxUsers(java.util.Set)
	 */
	@Override
	public void fillComboBoxUsers(ArrayList<IPerson> tempUserList) {
		this.comboBoxUsers.clear();
		for (int i = 0; i < tempUserList.size(); i++) {
			this.comboBoxUsers.addItem(tempUserList.get(i).toString());
			this.userMap.put(i, tempUserList.get(i));
		}
	}

	private IPerson getSelectedUser() {
		return this.userMap.get(this.comboBoxUsers.getSelectedIndex());
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IRootView#activateLogin()
	 */
	@Override
	public void activateLogin() {
		this.comboBoxUsers.setEnabled(true);
		this.btnLogin.setEnabled(true);
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IRootView#deactivateLogin()
	 */
	@Override
	public void deactivateLogin() {
		this.comboBoxUsers.setEnabled(false);
		this.btnLogin.setEnabled(false);
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IRootView#getContentPanel()
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
