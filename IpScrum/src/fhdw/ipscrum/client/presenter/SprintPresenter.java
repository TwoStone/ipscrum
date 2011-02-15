package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.SprintView;
import fhdw.ipscrum.client.view.interfaces.ISprintView;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
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

		this.concreteView.addNewSprintEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				final DialogBox box = new DialogBox();
				final SprintDialogPresenter presenter = new SprintDialogPresenter(box);
				box.setAnimationEnabled(true);
				box.setGlassEnabled(true);
				box.setText("Neuen Sprint anlegen");

				presenter.getFinished().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						try {
							SprintPresenter.this.project.addSprint(presenter.getSprint());
							SprintPresenter.this.initialize();
							box.hide();
						} catch (DoubleDefinitionException e) {
							GwtUtils.displayError(e.getMessage());
						}
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
				box.setGlassEnabled(true);
				box.setText("Sprint " + eventArgs.getSprint().getName() + " bearbeiten");

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

		this.concreteView.addDeleteSprintEventHandler(new EventHandler<SprintArgs>() {

			@Override
			public void onUpdate(Object sender, SprintArgs eventArgs) {
				GwtUtils.displayError("Entfernen von Sprints ist derzeit noch nicht vorgesehen!");
			}
		});

		return this.concreteView;

	}


}