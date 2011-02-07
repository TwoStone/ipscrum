package fhdw.ipscrum.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.RootView;
import fhdw.ipscrum.client.view.interfaces.IRootView;

public class RootPresenter extends Presenter<IRootView> {

	public RootPresenter(Panel parent) {
		super(parent);
	}

	@Override
	protected IRootView createView() {
		final IRootView rootView = RootView.createView();
		final Label dummyLabel = new Label("Du bist jetzt angemeldet als:");
		
		rootView.getBtnLogin().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				//TODO Benutzerprüfung
				rootView.deactivateLogin();
				dummyLabel.setText(dummyLabel.getText()+rootView.getInputUserName().getText());
				rootView.getContentPanel().add(dummyLabel);
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
