package fhdw.ipscrum.client.presenter;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.presenter.interfaces.IBugPresenter;
import fhdw.ipscrum.client.view.interfaces.IBugView;

public class BugPresenter implements IBugPresenter {
	private final IBugView view;

	public BugPresenter(IBugView view) {
		this.view = view;
	}

	@Override
	public void registerViewEvents() {

		view.getChangeSystems().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				BugPresenter.this.view.getChangeSystems();
			}
		});
	}
}
