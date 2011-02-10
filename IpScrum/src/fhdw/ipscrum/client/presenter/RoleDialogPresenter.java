package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.OneStringArgs;
import fhdw.ipscrum.client.view.RoleDialogView;
import fhdw.ipscrum.client.view.interfaces.IRoleDialogView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.Person;
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
		initialize();
	}

	@Override
	protected IRoleDialogView createView() {
		view.addOkEventHandler(new EventHandler<OneStringArgs>() {

			@Override
			public void onUpdate(Object sender, OneStringArgs eventArgs) {
				if (RoleDialogPresenter.this.role == null) {
					SessionManager.getInstance().getModel().addRole(new Role(eventArgs.getString()));
				} else {
					RoleDialogPresenter.this.role.setDescription(eventArgs.getString());					
				}
				
				finish();
			}
		});

		view.addCancelEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				abort();
			}
		});
		return view;
	}
	
	/**
	 * 
	 */
	private void initialize() {
		if (this.role != null) {
			this.view.getRole().setText(this.role.getDescription());
		}
	}

}
