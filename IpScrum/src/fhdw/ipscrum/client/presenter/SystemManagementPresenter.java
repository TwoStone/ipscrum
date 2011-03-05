package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.SystemManagementView;
import fhdw.ipscrum.client.view.interfaces.ISystemManagementView;
import fhdw.ipscrum.client.view.interfaces.ISystemManagementView.NewSystemEventArgs;

public class SystemManagementPresenter extends Presenter<ISystemManagementView> {

	public SystemManagementPresenter(Panel parent, Presenter<?> parentPresenter) {
		super(parent, parentPresenter);

	}

	@Override
	protected ISystemManagementView createView() {
		final ISystemManagementView view = new SystemManagementView();
		this.registerEvents();
		return view;
	}

	private void registerEvents() {
		this.getView()
				.getCreateSystemEvent()
				.add(new EventHandler<ISystemManagementView.NewSystemEventArgs>() {

					@Override
					public void onUpdate(Object sender,
							NewSystemEventArgs eventArgs) {

					}
				});
	}

}
