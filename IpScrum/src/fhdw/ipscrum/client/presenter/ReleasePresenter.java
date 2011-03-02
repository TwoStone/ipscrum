package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ReleaseArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.ReleaseView;
import fhdw.ipscrum.client.view.interfaces.IReleaseView;
import fhdw.ipscrum.client.view.widgets.charts.ChartWrappingDialogBox;
import fhdw.ipscrum.client.view.widgets.charts.CompactReleaseBurndownChart;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;

/**
 * Presenter for {@link Release}
 * 
 * @author Phase II / Gruppe I
 * 
 */
public class ReleasePresenter extends Presenter<IReleaseView> {

	private final Project project;

	/**
	 * Creates a new instance of {@link ReleasePresenter}
	 * 
	 * @param parent
	 * @param project
	 * @param parentPresenter
	 */
	public ReleasePresenter(final Panel parent, final Project project,
			final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
		this.project = project;
		this.initialize();
	}

	@Override
	protected IReleaseView createView() {
		final IReleaseView view = new ReleaseView();

		// Add a handler for a event which should open a new dialog for creating
		// releases
		view.addNewReleaseEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				final DialogBox diaBox = new DialogBox();
				final CreateReleasePresenter presenter = new CreateReleasePresenter(
						diaBox, ReleasePresenter.this.project,
						ReleasePresenter.this);

				presenter.getAborted().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final EventArgs eventArgs) {
						diaBox.hide();
					}
				});

				presenter.getFinished().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(final Object sender,
							final EventArgs eventArgs) {

						ReleasePresenter.this.initialize();
						diaBox.hide();
					}
				});
				diaBox.center();
			}
		});

		// Add a handler for a event which should delete an selected release
		// Displays an error if no release selected
		view.addDeleteReleaseEventHandler(new EventHandler<ReleaseArgs>() {

			@Override
			public void onUpdate(final Object sender,
					final ReleaseArgs eventArgs) {
				if (eventArgs.getRelease() != null) {
					ReleasePresenter.this.project.removeRelease(eventArgs
							.getRelease());
					view.refreshReleases(ReleasePresenter.this.project
							.getReleasePlan());

					ReleasePresenter.this.initialize();

				} else {
					GwtUtils.displayError(TextConstants.NO_RELEASE_SELECTED);

				}
			}
		});

		// Add a handler for a event which should open the details of a selected
		// release a a dialog
		view.addReleaseDetailsEventHandler(new EventHandler<ReleaseArgs>() {

			@Override
			public void onUpdate(final Object sender,
					final ReleaseArgs eventArgs) {
				if (eventArgs.getRelease() != null) {
					final DialogBox diaBox = new DialogBox();
					final ReleaseDetailPresenter presenter = new ReleaseDetailPresenter(
							diaBox, eventArgs.getRelease(),
							ReleasePresenter.this);

					presenter.getFinished().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(final Object sender,
								final EventArgs eventArgs) {
							ReleasePresenter.this.finish();
						}
					});

					presenter.getAborted().add(new EventHandler<EventArgs>() {

						@Override
						public void onUpdate(final Object sender,
								final EventArgs eventArgs) {

							diaBox.clear();
							diaBox.hide();
						}
					});
					diaBox.center();
				} else {
					GwtUtils.displayError(TextConstants.NO_RELEASE_SELECTED);
				}
			}
		});

		view.addShowChartEventHandler(new EventHandler<ReleaseArgs>() {
			@Override
			public void onUpdate(Object sender, ReleaseArgs eventArgs) {
				ChartWrappingDialogBox box = new ChartWrappingDialogBox(new CompactReleaseBurndownChart(eventArgs.getRelease(), 300, 200));
				box.center();
			}
		});


		return view;
	}

	/**
	 * Fills the cellTable of {@link ReleaseView} with the existing releases for
	 * the project
	 */
	private void initialize() {
		if (this.project.getReleasePlan() != null) {
			this.getView().refreshReleases(this.project.getReleasePlan());
		}
	}

}