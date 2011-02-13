package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.CreateProjectView;
import fhdw.ipscrum.client.view.interfaces.ICreateProjectView;
import fhdw.ipscrum.client.view.widgets.AbortDialog;
import fhdw.ipscrum.client.view.widgets.AbortDialog.OnOkayCommand;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Project;

/**
 * Presenter for creating new {@link Project}
 * 
 * @author Manu
 * 
 */
public class CreateProjectPresenter extends Presenter<ICreateProjectView> {

	/**
	 * Creates a new instance of {@link CreateProjectPresenter}
	 * @param parent
	 */
	public CreateProjectPresenter(Panel parent) {
		super(parent);
	}

	@Override
	protected ICreateProjectView createView() {

		// New instance of CreateProjectView
		final ICreateProjectView view = new CreateProjectView();

		// Add a handler for the event which creates a new project
		view.addSaveProjectHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				try {
					try {
						SessionManager.getInstance().getModel()
								.addProject(new Project(view.getProjectName()));
					} catch (ConsistencyException e) {
						GwtUtils.displayError(e.getMessage());
					}
					finish();
				} catch (NoValidValueException e) {
					Window.alert(e.getMessage());
				}
			}
		});

	// Add a handler for the event which cancels creating of a new project
		view.addCancelCreateProjectHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {

				new AbortDialog(new OnOkayCommand() {

					@Override
					public void onExecute() {
						CreateProjectPresenter.this.abort();
					}
				});

			}
		});

		return view;
	}
}
