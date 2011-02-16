package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.AddSprintToReleaseView;
import fhdw.ipscrum.client.view.interfaces.IAddSprintToReleaseView;
import fhdw.ipscrum.client.view.widgets.AbortDialog;
import fhdw.ipscrum.client.view.widgets.AbortDialog.OnOkayCommand;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;

/**
 * @author Phase II / Gruppe I
 * 
 * Presenter for {@link AddSprintToReleaseView} where you can add Sprints to a Release
 *
 */
public class AddSprintToReleasePresenter extends
		Presenter<IAddSprintToReleaseView> {

	private final Project project;
	private final Release release;

	/**
	 * Creates a new Instance of a {@link AddSprintToReleasePresenter}
	 * 
	 * @param parent
	 * @param release
	 */
	public AddSprintToReleasePresenter(final Panel parent, final Release release) {
		super(parent);
		this.release = release;
		this.project = this.release.getProject();
		this.initialize();
	}

	/**
	 * Fills the cellTable of {@link AddSprintToReleaseView} with the existing sprints
	 */
	private void initialize() {
		if (this.project.getSprints() != null) {
			this.getView().refreshSprints(this.project.getSprints());
		}
	}

	@Override
	protected IAddSprintToReleaseView createView() {

		// New instance of AddSprintToReleaseView
		final AddSprintToReleaseView view = new AddSprintToReleaseView();


		// Add a handler for the event which cancels the add-sprint-to-release-dialog
		// Creates an abort-dialog
		view.addCancelAddSprintViewEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				new AbortDialog(new OnOkayCommand() {

					@Override
					public void onExecute() {
						AddSprintToReleasePresenter.this.abort();
					}
				});
			}
		});


		// Add a handler for the event which saves the selected sprint to 
		// Displays an error if the selected sprint can not be added to the release
		view.addSaveSprintsEventHandler(new EventHandler<SprintArgs>() {

			@Override
			public void onUpdate(final Object sender, final SprintArgs eventArgs) {
				try {
					AddSprintToReleasePresenter.this.release
							.addSprint(eventArgs.getSprint());
				} catch (final UserException e) {
					GwtUtils.displayError(e.getMessage());
				}
				AddSprintToReleasePresenter.this.finish();
			}
		});

		return view;
	}
}
