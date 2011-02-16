package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.ReleaseDetailView;
import fhdw.ipscrum.client.view.interfaces.IReleaseDetailView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.Release;

/**
 * @author Phase II / Gruppe I
 *
 * Presenter for {@link ReleaseDetailView}, where you can see all sprints for a release
 */
public class ReleaseDetailPresenter extends Presenter<IReleaseDetailView> {

	private final Release release;

	/**
	 * Creates a new instance for {@link ReleaseDetailPresenter}
	 * 
	 * @param parent
	 * @param release
	 */
	public ReleaseDetailPresenter(final Panel parent, final Release release) {
		super(parent);
		this.release = release;
		this.initialize();
	}

	private void initialize() {
		if (this.release.getSprints() != null) {
			this.getView().refreshSprints(this.release.getSprints());
		}
	}

	@Override
	protected IReleaseDetailView createView() {
		
		// New instance of AddSprintToReleaseView
		final IReleaseDetailView view = new ReleaseDetailView();

		// Add a handler for the event which cancels the release-details-dialog
		view.addCancelReleaseDetailViewHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {

				ReleaseDetailPresenter.this.abort();

			}
		});

		// Add a handler for the event which opens the add-sprint-to-release-dialog
		view.addAddSprintEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {

				final DialogBox diaBox = new DialogBox();

				final AddSprintToReleasePresenter presenter = new AddSprintToReleasePresenter(
						diaBox, ReleaseDetailPresenter.this.release);

				presenter.getAborted().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final EventArgs eventArgs) {
						diaBox.clear();
						diaBox.hide();
					}
				});

				presenter.getFinished().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final EventArgs eventArgs) {

						diaBox.clear();
						diaBox.hide();
						ReleaseDetailPresenter.this.initialize();
					}
				});
				diaBox.center();
			}
		});


		// Add a handler for the event which removes a selected sprint from the release
		// Displays an error if no sprint is selected
		view.addDeleteSprintEventHandler(new EventHandler<SprintArgs>() {

			@Override
			public void onUpdate(final Object sender, final SprintArgs eventArgs) {

				if(eventArgs.getSprint() == null){
				GwtUtils.displayError(TextConstants.NO_SPRINT_SELECTED);	
				} else {
				ReleaseDetailPresenter.this.release.removeSprint(eventArgs
						.getSprint());
				ReleaseDetailPresenter.this.initialize();
				}
			}
		});

		return view;
	}

}
