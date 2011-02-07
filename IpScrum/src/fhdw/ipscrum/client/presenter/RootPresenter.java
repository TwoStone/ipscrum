package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.StartLoggedInView;
import fhdw.ipscrum.client.view.interfaces.IRootView;

public class RootPresenter extends Presenter<IRootView> {

	public RootPresenter(Panel parent) {
		super(parent);
	}

	@Override
	protected IRootView createView() {
		return StartLoggedInView.createView();
	}
	
	
}
