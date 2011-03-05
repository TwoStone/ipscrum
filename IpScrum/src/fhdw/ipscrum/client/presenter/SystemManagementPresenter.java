package fhdw.ipscrum.client.presenter;

import java.util.List;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.SystemManagementView;
import fhdw.ipscrum.client.view.interfaces.ISystemManagementView;
import fhdw.ipscrum.client.view.interfaces.ISystemManagementView.NewSystemEventArgs;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.ConcreteSystem;
import fhdw.ipscrum.shared.model.Systemgroup;
import fhdw.ipscrum.shared.model.interfaces.IHasChildren;

public class SystemManagementPresenter extends Presenter<ISystemManagementView> {

	public SystemManagementPresenter(final Panel parent,
			final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
		this.registerEvents();
		this.updateView();
	}

	private void updateView() {
		final IHasChildren root = this.getSessionManager().getModel()
				.getSysManager().getSystems();
		this.getView().setRootSystemGroup(root.getChilds());
		final List<Systemgroup> groups = root.getGroups();
		this.getView().setPossibleParents(groups);
	}

	@Override
	protected ISystemManagementView createView() {
		final ISystemManagementView view = new SystemManagementView();

		return view;
	}

	private void registerEvents() {
		this.getView().getCreateSystemEvent().add(
				new EventHandler<ISystemManagementView.NewSystemEventArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final NewSystemEventArgs eventArgs) {
						SystemManagementPresenter.this.createSystem(eventArgs);
					}
				});
	}

	private void createSystem(final NewSystemEventArgs eventArgs) {
		final IHasChildren parent;
		if (eventArgs.Parent == null) {
			parent = this.getSessionManager().getModel().getSysManager()
					.getSystems();
		} else {
			parent = eventArgs.Parent;
		}

		try {
			if (eventArgs.AsGroup) {
				new Systemgroup(eventArgs.Name, parent);
			} else {
				new ConcreteSystem(eventArgs.Name, parent);
			}
			this.updateView();
		} catch (final UserException e) {
			GwtUtils.displayError(e.getMessage());
		}

	}
}
