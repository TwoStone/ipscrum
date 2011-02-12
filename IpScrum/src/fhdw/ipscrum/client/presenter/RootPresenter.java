package fhdw.ipscrum.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.RootView;
import fhdw.ipscrum.client.view.interfaces.IRootView;

/**
 */
public class RootPresenter extends Presenter<IRootView> {

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
		final IRootView rootView = RootView.createView();
		
		rootView.getBtnLogin().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				//TODO Benutzerprüfung
				new NavigationPresenter(rootView.getContentPanel());
				rootView.deactivateLogin();
			}
		});
		
		rootView.getButtonLogout().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				//TODO Aktivitäten auf dem ContentPanel
				rootView.activateLogin();
				rootView.getContentPanel().clear();
			}
		});
		
		return rootView;
	}
	
	
}
//public class RootPresenter extends Presenter<INavigationView> {
//
//	public RootPresenter(Panel parent) {
//		super(parent);
//	}
//
//	@Override
//	protected INavigationView createView() {
//		final INavigationView rootView = NavigationView.createView();
//		
////		rootView.getBtnLogin().addClickHandler(new ClickHandler() {
////			
////			@Override
////			public void onClick(ClickEvent event) {
////				//TODO Benutzerprüfung
////				new NavigationPresenter(rootView.getContentPanel());
////				rootView.deactivateLogin();
////			}
////		});
////		
////		rootView.getButtonLogout().addClickHandler(new ClickHandler() {
////			
////			@Override
////			public void onClick(ClickEvent event) {
////				//TODO Aktivitäten auf dem ContentPanel
////				rootView.activateLogin();
////				rootView.getContentPanel().clear();
////			}
////		});
//		
//		return rootView;
//	}
	
	
//}
