package fhdw.ipscrum.client.presenter;

import java.util.Iterator;
import java.util.Set;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.CreateTaskView;
import fhdw.ipscrum.client.view.interfaces.ICreateTaskView;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.SprintAssociationException;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.SprintBacklog;
import fhdw.ipscrum.shared.model.Task;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public class CreateTaskPresenter extends Presenter<ICreateTaskView> {

	private final SprintBacklog sprintBacklog;
	private final Set<ProductBacklogItem> selectedPBIs;

	public CreateTaskPresenter(final Panel parent,
			final SprintBacklog sprintBacklog,
			final Set<ProductBacklogItem> selectedPBIs,
			final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
		this.sprintBacklog = sprintBacklog;
		this.selectedPBIs = selectedPBIs;
		this.addHandler();
	}

	private void addHandler() {
		CreateTaskPresenter.this.getView().addSaveNewTaskEventHandler(
				new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final EventArgs eventArgs) {

						try {
							ITask newTask = new Task(CreateTaskPresenter.this
									.getView().getName(),
									CreateTaskPresenter.this.getView()
											.getDescription());

							Iterator<ProductBacklogItem> pbiIterator = selectedPBIs
									.iterator();

							while (pbiIterator.hasNext()) {
								try {
									newTask.addPBI(pbiIterator.next());
								} catch (ForbiddenStateException e) {
									GwtUtils.displayError(e.getMessage());
								} catch (SprintAssociationException e) {
									// displays an error if the pbi is not contained in the sprint
									GwtUtils.displayError(e.getMessage());
								}
							}

							CreateTaskPresenter.this.sprintBacklog.addTask(newTask);
							CreateTaskPresenter.this.finish();
						} catch (NoValidValueException e1) {
							GwtUtils.displayError(e1.getMessage());
						}
						CreateTaskPresenter.this.finish();
					}
				});

		CreateTaskPresenter.this.getView().addCancelNewTaskEventHandler(
				new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final EventArgs eventArgs) {
						CreateTaskPresenter.this.abort();
					}
				});
	}

	@Override
	protected ICreateTaskView createView() {
		final ICreateTaskView concreteView = new CreateTaskView();
		return concreteView;
	}
}
