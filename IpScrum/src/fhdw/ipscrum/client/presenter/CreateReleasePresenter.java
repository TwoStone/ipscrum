package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.CreateReleaseView;
import fhdw.ipscrum.client.view.interfaces.ICreateReleaseView;
import fhdw.ipscrum.client.view.widgets.AbortDialog;
import fhdw.ipscrum.client.view.widgets.AbortDialog.OnOkayCommand;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;

public class CreateReleasePresenter extends Presenter<ICreateReleaseView> {

	Project project;
	
	public CreateReleasePresenter(Panel parent, Project project) {
		super(parent);
	this.project = project;
	}

	@Override
	protected ICreateReleaseView createView() {
		final ICreateReleaseView view = new CreateReleaseView();
		
		
		view.addSaveVersionHandler(new EventHandler<EventArgs>(){

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				CreateReleasePresenter.this.project.addRelease(new Release(view.getReleaseVersion(),view.getDateBox().getValue(), project));
				finish();
			}
		
		});
	
		view.addCancelCreateReleaseHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				new AbortDialog(new OnOkayCommand() {
					
					@Override
					public void onExecute() {
						CreateReleasePresenter.this.abort();						
					}
				});
				
			}
		});
		
		return view;
	}
}
