package fhdw.ipscrum.client.presenter;

import java.util.Iterator;
import java.util.Vector;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.MultiplePBIArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.AddPBIsToTaskView;
import fhdw.ipscrum.client.view.interfaces.IAddPBIsToTaskView;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.SprintAssociationException;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public class AddPBIsToTaskPresenter extends Presenter<IAddPBIsToTaskView> {

	ITask task;

	public AddPBIsToTaskPresenter(Panel parent, Presenter<?> parentPresenter,
			ITask task) {
		super(parent, parentPresenter);
		this.task = task;
		addHandler();
		initializeView();
	}

	private void initializeView() {
		refreshTaskPBIs();
		refreshSprintPBIs();
	}

	private void refreshSprintPBIs() {
		Vector<ProductBacklogItem> pbis = this.task.getSprintBacklog()
				.getSprint().getPBIs();
		this.getView().refreshSprintPBIs(pbis);
	}

	private void refreshTaskPBIs() {
		Vector<ProductBacklogItem> pbis = new Vector<ProductBacklogItem>();
		Iterator<ProductBacklogItem> pbisIt = this.task.getPBIIterator();

		while (pbisIt.hasNext()) {
			pbis.add(pbisIt.next());
		}

		this.getView().refreshTaskPBIs(pbis);
	}

	private void addHandler() {
		this.getView().addAddPBIsToTaskEventHandler(
				new EventHandler<MultiplePBIArgs>() {

					@Override
					public void onUpdate(Object sender,
							MultiplePBIArgs eventArgs) {
						Iterator<ProductBacklogItem> pbis = eventArgs.getPbis()
								.iterator();

						while (pbis.hasNext()) {
							try {
								AddPBIsToTaskPresenter.this.task.addPBI(pbis
										.next());
							} catch (ForbiddenStateException e) {
								GwtUtils.displayError(e);
							} catch (SprintAssociationException e) {
								GwtUtils.displayError(e);
							} catch (DoubleDefinitionException e) {
								GwtUtils.displayError(e);
							}
						}
						AddPBIsToTaskPresenter.this.refreshTaskPBIs();
					}
				});

		this.getView().addCloseEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				AddPBIsToTaskPresenter.this.finish();
			}
		});

	}

	@Override
	protected IAddPBIsToTaskView createView() {

		IAddPBIsToTaskView view = new AddPBIsToTaskView();

		return view;
	}

}
