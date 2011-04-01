package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gwt.user.client.ui.DialogBox;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.presenter.interfaces.IBugPresenter;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.interfaces.IBugView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.NothingSelectedException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.Observer;

public class BugPresenter implements Observer, IBugPresenter {
	private final IBugView view;
	private final PBIPresenter<?> presenter;

	public BugPresenter(IBugView view, PBIPresenter<?> presenter) {
		this.view = view;
		this.presenter = presenter;
	}

	@Override
	public void registerViewEvents() {
		((IBugView) presenter.getView()).getChangeSystems().add(
				new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(final Object sender,
							final EventArgs eventArgs) {
						final List<System> list1 = new ArrayList<System>();
						final List<System> list2 = new ArrayList<System>();
						list1.addAll(((Bug) BugPresenter.this.presenter
								.getPbi()).getSystems());
						list2.addAll(BugPresenter.this.presenter.getPbi()
								.getBacklog().getProject().getPossibleSystems());

						final DialogBox box = GwtUtils
								.createDialog(TextConstants.CHANGE_SYSTEM);
						final SelectSystemPresenter presenter = new SelectSystemPresenter(
								box, BugPresenter.this.presenter, list1, list2);

						presenter.getFinished().add(
								new EventHandler<EventArgs>() {

									@Override
									public void onUpdate(final Object sender,
											final EventArgs eventArgs) {
										Bug bug = (Bug) BugPresenter.this.presenter
												.getPbi();
										Collection<System> s = new ArrayList<System>(
												bug.getSystems());
										for (final System system : s) {
											try {
												bug.removeSystem(system);
											} catch (UserException e) {
												GwtUtils.displayError(e);
											}
										}

										for (final System system : presenter
												.getSelectedSystems()) {
											try {
												bug.addSystem(system);
											} catch (UserException e) {
												GwtUtils.displayError(e);
											}
										}
										box.hide();
									}
								});

						presenter.getAborted().add(
								new EventHandler<EventArgs>() {

									@Override
									public void onUpdate(Object sender,
											EventArgs eventArgs) {
										box.hide();
									}

								});
						box.center();
					}
				});

	}

	@Override
	public void setupView() {
		this.view
				.setVersion(this.presenter.getPbi().getBacklog().getProject()
						.getReleasePlan(),
						((Bug) this.presenter.getPbi()).getVersion());
		this.updateView();
	}

	@Override
	public void updateView() {
		this.view.setSystems(new ArrayList<System>(((Bug) this.presenter
				.getPbi()).getSystems()));
	}

	@Override
	public void update(final Observable observable, final Object argument) {
		this.updateView();
	}

	@Override
	public void updatePBI() throws NothingSelectedException, UserException {
		Bug bug = (Bug) this.presenter.getPbi();
		bug.setVersion(this.view.getSelectedVersion());
	}

}
