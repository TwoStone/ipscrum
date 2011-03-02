package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.CreateTaskView;
import fhdw.ipscrum.client.view.interfaces.ICreateTaskView;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

public class CreateTaskPresenter extends Presenter<ICreateTaskView> {

	private final ProductBacklogItem pbi;
	private ICreateTaskView concreteView;

	public CreateTaskPresenter(final Panel parent,
			final ProductBacklogItem pbi, final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
		this.pbi = pbi;
		this.initzialize();
	}

	@Override
	protected ICreateTaskView createView() {
		this.concreteView = new CreateTaskView();

		this.concreteView
				.addSaveNewTaskEventHandler(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final EventArgs eventArgs) {

						// TODO: TASK zum pbi hinzufügen

					}
				});

		this.concreteView
				.addCancelNewTaskEventHandler(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final EventArgs eventArgs) {
						CreateTaskPresenter.this.abort();
					}
				});

		return this.concreteView;
	}

	private void initzialize() {
		this.concreteView.refreshNameBox(this.pbi.getSprint().getTeam()
				.getMembers());
	}

}
