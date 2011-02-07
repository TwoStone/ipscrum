package fhdw.ipscrum.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Label;
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
		final Label dummy = new Label();
		
		concreteView.getBtnProjekte().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				concreteView.getContentPanel().clear();
				dummy.setText("Hier kommt die Projektverwaltung hin!");
				concreteView.getContentPanel().add(dummy);
			}
		});
		
		concreteView.getBtnVerwaltung().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				concreteView.getContentPanel().clear();
				dummy.setText("Hier kommt die allgemeine Verwaltung hin!");
				concreteView.getContentPanel().add(dummy);
			}
		});
		
		return concreteView;
	}

}
