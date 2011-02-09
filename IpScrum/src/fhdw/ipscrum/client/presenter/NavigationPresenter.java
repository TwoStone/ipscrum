package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.NavigationView;
import fhdw.ipscrum.client.view.interfaces.INavigationView;

public class NavigationPresenter extends Presenter<INavigationView> {

	public NavigationPresenter(Panel parent) {
		super(parent);
	}
	
	@Override
	protected INavigationView createView() {
		final INavigationView concreteView = NavigationView.createView();
		
		concreteView.getMntmProjekte().setCommand(new Command() {
			public void execute() {
				concreteView.getContentPanel().clear();
				new ProjectPresenter(concreteView.getContentPanel());
			}
		});
		
		concreteView.getMntmPersonenstammdaten().setCommand(new Command() {
			public void execute() {
				concreteView.getContentPanel().clear();
				new PersonRolePresenter(concreteView.getContentPanel());
			}
		});
		
		concreteView.getMntmTeamzuordnung().setCommand(new Command() {
			public void execute() {
				Window.alert("Teamzuordnung not ready yet."); // TODO
			}
		});
		
		return concreteView;
	}
}
