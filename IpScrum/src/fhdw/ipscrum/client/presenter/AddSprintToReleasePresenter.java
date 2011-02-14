package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.view.AddSprintToReleaseView;
import fhdw.ipscrum.client.view.interfaces.IAddSprintToReleaseView;
import fhdw.ipscrum.client.view.widgets.AbortDialog;
import fhdw.ipscrum.client.view.widgets.AbortDialog.OnOkayCommand;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;

public class AddSprintToReleasePresenter extends
		Presenter<IAddSprintToReleaseView> {

	private Project project;
	private Release release;
	
	public AddSprintToReleasePresenter(Panel parent, Release release) {
		super(parent);
		this.release = release;
		this.project = this.release.getProject();
		this.initialize();
	}

	private void initialize() {
		if (this.project.getSprints() != null){
			this.getView().refreshSprints(this.project.getSprints());
		}
	}

	@Override
	protected IAddSprintToReleaseView createView() {

		final AddSprintToReleaseView view = new AddSprintToReleaseView();
		
		view.addCancelAddSprintViewEventHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				new AbortDialog(new OnOkayCommand() {
					
					@Override
					public void onExecute() {
						AddSprintToReleasePresenter.this.abort();
					}
				});
			}
		});
		
		view.addSaveSprintsEventHandler(new EventHandler<SprintArgs>() {

			@Override
			public void onUpdate(Object sender, SprintArgs eventArgs) {
				try {
					AddSprintToReleasePresenter.this.release.addSprint(eventArgs.getSprint());
				} catch (UserException e) {
					e.getMessage();
				}
			AddSprintToReleasePresenter.this.finish();
			}
		});
		
		return view;
	}
}
