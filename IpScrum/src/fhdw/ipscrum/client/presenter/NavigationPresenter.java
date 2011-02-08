package fhdw.ipscrum.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
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
		
		concreteView.getBtnProjekte().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				concreteView.getContentPanel().clear();
				new ProjectPresenter(concreteView.getContentPanel());
			}
		});
		
		concreteView.getBtnVerwaltung().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				concreteView.getContentPanel().clear();
				new PersonRolePresenter(concreteView.getContentPanel());
			}
		});
		
		return concreteView;
	}

}
