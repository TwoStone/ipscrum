package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ReleaseArgs;
import fhdw.ipscrum.client.view.ReleaseView;
import fhdw.ipscrum.client.view.interfaces.IReleaseView;
import fhdw.ipscrum.shared.model.Project;

public class ReleasePresenter extends Presenter<IReleaseView> {

	private final Project project;

	public ReleasePresenter(Panel parent, Project project) {
		super(parent);
		this.project = project;
		this.initialize();
	}

	@Override
	protected IReleaseView createView() {
		final IReleaseView view = new ReleaseView();

		view.addNewReleaseEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				final DialogBox diaBox = new DialogBox();
				CreateReleasePresenter presenter = new CreateReleasePresenter(
						diaBox, ReleasePresenter.this.project);
				presenter.getFinished().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						view.refreshReleases(ReleasePresenter.this.project
								.getReleasePlan());
						diaBox.hide();
					}
				});
				diaBox.center();
			}
		});

		view.addDeleteReleaseEventHandler(new EventHandler<ReleaseArgs>() {

			@Override
			public void onUpdate(Object sender, ReleaseArgs eventArgs) {
				if (eventArgs.getRelease() != null) {
					ReleasePresenter.this.project.getReleasePlan().remove(
							eventArgs.getRelease());
					view.refreshReleases(ReleasePresenter.this.project
							.getReleasePlan());
				}
			}
		});

		view.addReleaseDetailsEventHandler(new EventHandler<ReleaseArgs>() {

			// TODO: WAS SOLL BEI DETAILANSICHT EINES RELEASES GESCHEHEN??????
			@Override
			public void onUpdate(Object sender, ReleaseArgs eventArgs) {

			}
		});

		return view;
	}

	private void initialize() {
		if (this.project.getReleasePlan() != null) {
			this.getView().refreshReleases(this.project.getReleasePlan());
		}
	}

}