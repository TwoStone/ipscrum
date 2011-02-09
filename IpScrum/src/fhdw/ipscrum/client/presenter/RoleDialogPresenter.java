package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.RoleDialogView;
import fhdw.ipscrum.client.view.interfaces.IRoleDialogView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.Role;


public class RoleDialogPresenter extends Presenter<IRoleDialogView> {

	private Role role;
	final IRoleDialogView view = new RoleDialogView();
	
	public RoleDialogPresenter(Panel parent) {
		super(parent);
	}
	
	public RoleDialogPresenter(Panel parent, Role selectedRole) {
		super(parent);
		this.role = selectedRole;
	}

	@Override
	protected IRoleDialogView createView() {
		final Role roleHandler = this.role;
		view.addOkEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				if(role != null){
					roleHandler.setDescription(view.getRole().getText());
				} else {
					Role role = new Role(view.getRole().getText());
					SessionManager.getInstance().getModel().addRole(role);					
				} 
				finish();
			}
		});

		view.addCancelEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				finish();
			}
		});
		return view;
	}
	

}
