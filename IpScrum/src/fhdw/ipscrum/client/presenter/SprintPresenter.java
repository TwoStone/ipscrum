package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.view.SprintView;
import fhdw.ipscrum.client.view.interfaces.ISprintView;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Sprint;

/**
 * Presenter for {@link Sprint}
 * 
 * @author Manu
 *
 */
public class SprintPresenter extends Presenter<ISprintView>{

	private ISprintView concreteView;
	private final Project project;


	/**
	 * Creates a new instance of {@link SprintPresenter}
	 * 
	 * @param parent
	 * @param project
	 */
	public SprintPresenter(Panel parent, Project project) {
		super(parent);
		this.project = project;
		this.initialize();
	}

	private void initialize() {
		if (this.project.getReleasePlan() != null) {
			this.getView().refreshSprints(this.project.getSprints());
		}
	}

	@Override
	protected ISprintView createView() {
		this.concreteView = new SprintView();

		this.concreteView.addNewReleaseEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				final DialogBox box = new DialogBox();
				final SprintDialogPresenter presenter = new SprintDialogPresenter(box);
				box.setAnimationEnabled(true);
				box.setAutoHideEnabled(true);
				box.setGlassEnabled(true);
				box.setText("Neuen Sprint anlegen");

				presenter.getFinished().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						project.addSprint(presenter.getSprint());
						SprintPresenter.this.initialize();
						box.hide();
					}
				});

				presenter.getAborted().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						box.hide();
					}
				});
				box.center();
			}
		});

		this.concreteView.addSprintDetailsEventHandler(new EventHandler<SprintArgs>() {

			@Override
			public void onUpdate(Object sender, SprintArgs eventArgs) {
				final DialogBox box = new DialogBox();
				final SprintDialogPresenter presenter = new SprintDialogPresenter(box, eventArgs.getSprint());
				box.setAnimationEnabled(true);
				box.setAutoHideEnabled(true);
				box.setGlassEnabled(true);
				box.setText("Sprint " + eventArgs.getSprint().getDescription() + " bearbeiten");

				presenter.getFinished().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						SprintPresenter.this.initialize();
						box.hide();
					}
				});

				presenter.getAborted().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						box.hide();
					}
				});
				box.center();
			}
		});

		this.concreteView.addDeleteReleaseEventHandler(new EventHandler<SprintArgs>() {

			@Override
			public void onUpdate(Object sender, SprintArgs eventArgs) {
				Window.alert("TODO im SprintPresenter beachten!");
				// TODO eventArgs.getSprint entfernen - evtl vorher fragen?
			}
		});

		return this.concreteView;

	}


}