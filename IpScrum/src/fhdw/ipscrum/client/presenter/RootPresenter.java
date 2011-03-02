package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PersonArgs;
import fhdw.ipscrum.client.view.RootView;
import fhdw.ipscrum.client.view.interfaces.IRootView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.Admin;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

/**
 * Presenter (Controller) of the Root-GUI.
 */
public class RootPresenter extends Presenter<IRootView> {

	private RootView concreteView;

	/**
	 * Constructor for RootPresenter.
	 * 
	 * @param parent
	 *            Panel
	 */
	public RootPresenter(final Panel parent) {
		super(parent, null);
	}

	/**
	 * Method createView.
	 * 
	 * @return IRootView
	 */
	@Override
	protected IRootView createView() {
		this.concreteView = new RootView();
		this.initUserList();
		this.setupEventHandlers();

		return this.concreteView;
	}

	/**
	 * Initializes the login-form by getting a list of all available users and
	 * adding the admin-user to it.
	 */
	private void initUserList() {
		final ArrayList<IPerson> tempUserList = new ArrayList<IPerson>(
				SessionManager.getInstance().getModel().getPersons());
		tempUserList.add(Admin.getInstance());
		this.concreteView.fillComboBoxUsers(tempUserList);
	}

	/**
	 * This is called to setup the various event handlers (button-behaviour) of
	 * the GUI.
	 */
	private void setupEventHandlers() {
		this.concreteView.defineLoginEvent(new EventHandler<PersonArgs>() {
			@Override
			public void onUpdate(final Object sender, final PersonArgs eventArgs) {
				SessionManager.getInstance()
						.setLoginUser(eventArgs.getPerson());
				new NavigationPresenter(RootPresenter.this.concreteView
						.getContentPanel(), RootPresenter.this);
				RootPresenter.this.concreteView.deactivateLogin();
			}
		});

		this.concreteView.defineLogoutEvent(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				RootPresenter.this.concreteView.getContentPanel().clear();
				RootPresenter.this.initUserList();
				RootPresenter.this.concreteView.activateLogin();
			}
		});
	}
}
