package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.NavigationView;
import fhdw.ipscrum.client.view.interfaces.INavigationView;

public class NavigationPresenter extends Presenter<INavigationView> {

	public NavigationPresenter(Panel parent) {
		super(parent);
	}
	
	@Override
	protected INavigationView createView() {
		final INavigationView concreteView = NavigationView.createView();
		
		concreteView.addProjectEventHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				concreteView.getContentPanel().clear();
				new ProjectPresenter(concreteView.getContentPanel());
			}
		});
		
		concreteView.addPersonEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				concreteView.getContentPanel().clear();
				new PersonRolePresenter(concreteView.getContentPanel());
			}
		});
		
		concreteView.addTeamEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				Window.alert("Teamzuordnung not ready yet."); // TODO
			}
		});
		
		return concreteView;
	}
}
