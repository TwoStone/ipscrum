package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.CreateProjectView;
import fhdw.ipscrum.client.view.interfaces.ICreateProjectView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Project;

public class CreateProjectPresenter extends Presenter<ICreateProjectView> {

	public CreateProjectPresenter(Panel parent) {
		super(parent);
	}

	@Override
	protected ICreateProjectView createView() {
		final ICreateProjectView view = new CreateProjectView();
		
		view.addSaveProjectHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				try {
					SessionManager.getInstance().getModel().addProject(new Project(view.getProjectName()));
					finish();
				} catch (NoValidValueException e) {
					Window.alert(e.getMessage());
				}
			}
		});
		return view;
	}
}
