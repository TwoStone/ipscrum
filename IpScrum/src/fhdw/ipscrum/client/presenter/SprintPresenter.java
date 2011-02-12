package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.SprintView;
import fhdw.ipscrum.client.view.interfaces.ISprintView;
import fhdw.ipscrum.shared.model.Project;

public class SprintPresenter extends Presenter<ISprintView>{

	private Project project;
	
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
		final ISprintView view = new SprintView();
	
		view.addNewReleaseEventHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				final DialogBox diaBox = new DialogBox();
				SprintDialogPresenter presenter = new SprintDialogPresenter(diaBox);
				
			presenter.getFinished().add(new EventHandler<EventArgs>() {

				@Override
				public void onUpdate(Object sender, EventArgs eventArgs) {

					SprintPresenter.this.initialize();
					
				}
			});
			diaBox.center();
			}
		});
		
		return view;
		
	}
	
	
}