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
 */
public class RootPresenter extends Presenter<IRootView> {

	private RootView concreteView;

	/**
	 * Constructor for RootPresenter.
	 * @param parent Panel
	 */
	public RootPresenter(Panel parent) {
		super(parent);
	}

	/**
	 * Method createView.
	 * @return IRootView
	 */
	@Override
	protected IRootView createView() {
		this.concreteView = new RootView();
		this.initUserList();
		this.setupEventHandlers();

		return this.concreteView;
	}

	private void initUserList() {
		ArrayList<IPerson> tempUserList = new ArrayList<IPerson>(SessionManager.getInstance().getModel().getPersons());
		tempUserList.add(Admin.getInstance());
		this.concreteView.fillComboBoxUsers(tempUserList);
	}

	private void setupEventHandlers() {
		this.concreteView.defineLoginEvent(new EventHandler<PersonArgs>() {
			@Override
			public void onUpdate(Object sender, PersonArgs eventArgs) {
				SessionManager.getInstance().setLoginUser(eventArgs.getPerson());
				new NavigationPresenter(RootPresenter.this.concreteView.getContentPanel());
				RootPresenter.this.concreteView.deactivateLogin();
			}
		});

		this.concreteView.defineLogoutEvent(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				RootPresenter.this.concreteView.getContentPanel().clear();
				RootPresenter.this.initUserList();
				RootPresenter.this.concreteView.activateLogin();
			}
		});
	}

}
