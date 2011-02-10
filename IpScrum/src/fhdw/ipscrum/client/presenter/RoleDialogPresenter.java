package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.OneStringArgs;
import fhdw.ipscrum.client.view.RoleDialogView;
import fhdw.ipscrum.client.view.interfaces.IRoleDialogView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.interfaces.IRole;


public class RoleDialogPresenter extends Presenter<IRoleDialogView> {

	private RoleDialogView concreteView;
	private IRole role;
	
	public RoleDialogPresenter(Panel parent) {
		this(parent, null);
	}
	
	public RoleDialogPresenter(Panel parent, IRole selectedRole) {
		super(parent);
		this.role = selectedRole;
		initialize();
	}

	@Override
	protected IRoleDialogView createView() {
		this.concreteView = new RoleDialogView();
		
		this.concreteView.addCancelEventHandler(new EventHandler<EventArgs>() {
			public void onUpdate(Object sender, EventArgs eventArgs) {
				abort();
			}
		});
		
		this.concreteView.addOkEventHandler(new EventHandler<OneStringArgs>() {
			public void onUpdate(Object sender, OneStringArgs eventArgs) {
				if (RoleDialogPresenter.this.role == null) {
					SessionManager.getInstance().getModel().addRole(new Role(eventArgs.getString()));
				} else {
					RoleDialogPresenter.this.role.setDescription(eventArgs.getString());					
				}
				
				finish();
			}
		});
		
		return concreteView;
	}
	
	/**
	 * 
	 */
	private void initialize() {
		if (this.role != null) {
			this.concreteView.getRole().setText(this.role.getDescription());
		}
	}

}
