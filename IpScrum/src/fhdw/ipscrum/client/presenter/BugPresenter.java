package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.DialogBox;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.presenter.interfaces.IBugPresenter;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.interfaces.IBugView;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.System;

public class BugPresenter implements IBugPresenter {
	private final IBugView view;
	private final PBIPresenter<?> presenter;
	private final Bug bug;

	public BugPresenter(IBugView view, PBIPresenter<?> presenter) {
		this.view = view;
		this.presenter = presenter;
		this.bug = (Bug) presenter.getPbi();
	}

	@Override
	public void registerViewEvents() {

		view.getChangeSystems().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				BugPresenter.this.view.getChangeSystems();
				final List<System> list1 = new ArrayList<System>();
				list1.addAll(BugPresenter.this.bug.getSystems());
				final List<System> list2 = new ArrayList<System>();
				list2.addAll(BugPresenter.this.presenter.getPbi().getBacklog().getProject().getPossibleSystems());
				final DialogBox box = GwtUtils.createDialog("Systeme zuordnen");
				final Presenter<?> presenter = new SelectSystemPresenter(box, BugPresenter.this.presenter, list1, list2);

				presenter.getFinished().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(final Object sender, final EventArgs eventArgs) {
						for (final System system : list1) {
							if (!BugPresenter.this.bug.getSystems().contains(system)) {
								try {
									BugPresenter.this.bug.addSystem(system);
								} catch (UserException e) {
									GwtUtils.displayError(e);
								}
							}
						}
						box.hide();
					}
				});

				presenter.getAborted().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						box.hide();
					}

				});
				box.center();
			}
		});

	}
}
