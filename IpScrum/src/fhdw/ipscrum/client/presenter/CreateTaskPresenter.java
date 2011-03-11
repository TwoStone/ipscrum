package fhdw.ipscrum.client.presenter;

import java.util.Iterator;
import java.util.Set;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.CreateTaskView;
import fhdw.ipscrum.client.view.interfaces.ICreateTaskView;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.SprintAssociationException;
import fhdw.ipscrum.shared.model.Effort;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.SprintBacklog;
import fhdw.ipscrum.shared.model.Task;
import fhdw.ipscrum.shared.model.interfaces.ITask;

/**
 * Presenter for view-class {@link CreateTaskView} where a user can create new
 * tasks
 * 
 * @author Phase III / Group I
 * 
 */
public class CreateTaskPresenter extends Presenter<ICreateTaskView> {

	// Variable for the backlog of the selected sprint
	private final SprintBacklog sprintBacklog;
	// Variable for alle selected pbis in the taskboard
	private final Set<ProductBacklogItem> selectedPBIs;

	/**
	 * Creates a new instance of {@link CreateTaskPresenter} Sets the given
	 * variables and calls the addHandler() method
	 * 
	 * @param Panel
	 *            parent
	 * @param SprintBacklog
	 *            sprintBacklog
	 * @param Set
	 *            <ProductBacklogItem> selectedPBIs
	 * @param Presenter
	 *            parentPresenter
	 */
	public CreateTaskPresenter(final Panel parent,
			final SprintBacklog sprintBacklog,
			final Set<ProductBacklogItem> selectedPBIs,
			final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
		this.sprintBacklog = sprintBacklog;
		this.selectedPBIs = selectedPBIs;
		this.addHandler();
	}

	/**
	 * In this method are the concrete handlers for the events of
	 * {@link CreateTaskView} implementet
	 */
	private void addHandler() {

		// handler for the saveNewTaskEvent
		CreateTaskPresenter.this.getView().addSaveNewTaskEventHandler(
				new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final EventArgs eventArgs) {

						try {
							// creating a new task adding name and description
							// from the view-class
							ITask newTask = new Task(CreateTaskPresenter.this
									.getView().getName(),
									CreateTaskPresenter.this.getView()
									.getDescription());

							// adds the task to the sprintBacklog...
							CreateTaskPresenter.this.sprintBacklog
							.addTask(newTask);

							// sets the given plan effort from the view-class,
							// that could be 0
							newTask.setPlanEffort(new Effort(CreateTaskPresenter.this.getView().getEffortInput()));

							// adding all selected pbis to the new task
							Iterator<ProductBacklogItem> pbiIterator = selectedPBIs
							.iterator();

							while (pbiIterator.hasNext()) {
								try {
									newTask.addPBI(pbiIterator.next());
								} catch (ForbiddenStateException e) {
									GwtUtils.displayError(e.getMessage());
								} catch (SprintAssociationException e) {
									// displays an error if the pbi is not
									// contained in the sprint
									GwtUtils.displayError(e.getMessage());
								} catch (DoubleDefinitionException e) {
									GwtUtils.displayError(e.getMessage());
								}
							}

							// catching the exceptions
						} catch (NoValidValueException e1) {
							GwtUtils.displayError(e1.getMessage());
						} catch (ForbiddenStateException e) {
							GwtUtils.displayError(e.getMessage());
						}
						// ... and fires a finish event
						CreateTaskPresenter.this.finish();
					}
				});

		// adding a handler for the cancelnewTaskEvent
		CreateTaskPresenter.this.getView().addCancelNewTaskEventHandler(
				new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final EventArgs eventArgs) {
						// presenter get aborted
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
