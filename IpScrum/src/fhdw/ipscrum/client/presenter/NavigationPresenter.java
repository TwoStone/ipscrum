package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.NavigationView;
import fhdw.ipscrum.client.view.interfaces.INavigationView;

/**
 * Presenter class of the navigation element. This is used to compose the main
 * navigation bar of the application.
 */
public class NavigationPresenter extends Presenter<INavigationView> {

	/**
	 * Constructor for NavigationPresenter.
	 * 
	 * @param parent
	 *            Panel
	 * @param parentPresenter
	 */
	public NavigationPresenter(final Panel parent,
			final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
	}

	/**
	 * Method createView. Initializes the GUI and defines the behaviour of the
	 * buttons.
	 * 
	 * @return INavigationView
	 */
	@Override
	protected INavigationView createView() {
		final INavigationView concreteView = NavigationView.createView();

		concreteView.addProjectEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				concreteView.getContentPanel().clear();
				new ProjectPresenter(concreteView.getContentPanel(),
						NavigationPresenter.this);
			}
		});

		concreteView.addReportsEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				concreteView.getContentPanel().clear();
				new ReportPresenter(concreteView.getContentPanel(),
						NavigationPresenter.this);
			}
		});

		concreteView.addPersonEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				concreteView.getContentPanel().clear();
				new PersonRolePresenter(concreteView.getContentPanel(),
						NavigationPresenter.this);
			}
		});

		concreteView.addTeamEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				concreteView.getContentPanel().clear();
				new TeamPresenter(concreteView.getContentPanel(),
						NavigationPresenter.this);
			}
		});

		concreteView.addSaveEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				NavigationPresenter.this.getSessionManager().save();
			}
		});

		concreteView.addTasksEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				concreteView.getContentPanel().clear();
				new TaskBoardPresenter(concreteView.getContentPanel(),
						NavigationPresenter.this);
			}
		});

		return concreteView;
	}
}
