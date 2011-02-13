package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.OneStringArgs;
import fhdw.ipscrum.client.view.RoleDialogView;
import fhdw.ipscrum.client.view.interfaces.IRoleDialogView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.interfaces.IRole;

/**
 * Represents the presenter of the view with which the user could make new roles or change roles. 
 * 
 */
public class RoleDialogPresenter extends Presenter<IRoleDialogView> {

	private IRoleDialogView concreteView;
	private final IRole role;

	/**
	 * Constructor for RoleDialogPresenter.
	 *           
	 *Required for making new roles.
	 * 
	 * @param parent Panel
	 * 
	 */
	public RoleDialogPresenter(Panel parent) {
		this(parent, null);
	}

	/**
	 * Constructor for RoleDialogPresenter.
	 * 
	 * Required for changing roles.
	 * 
	 * @param parent Panel
	 * @param selectedRole IRole 
	 *            
	 */
	public RoleDialogPresenter(Panel parent, IRole selectedRole) {
		super(parent);
		this.role = selectedRole;
		initialize();
	}

	/**
	 * Method createView.
	 * 
	 * Creates the view in which the user could make a
	 * new role or change a role and defines what happens when the user
	 * pushes the cancel- or OK-button.
	 * 
	 * @return IRoleDialogView 
	 * 
	 */
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
					try {
						SessionManager.getInstance().getModel().addRole(new Role(eventArgs.getString()));
					} catch (NoValidValueException e) {
						Window.alert("Die Rolle konnte nicht erzeugt werden!");
						e.printStackTrace();
					}
				} else {
					try {
						RoleDialogPresenter.this.role.setDescription(eventArgs.getString());
					} catch (NoValidValueException e) {
						Window.alert("Die Rolle konnte nicht geändert werden!");
						e.printStackTrace();
					}
				}

				finish();
			}
		});

		return this.concreteView;
	}

	/**
	 * Initializes the view with the values of the role chosen to change.
	 */
	private void initialize() {
		if (this.role != null) {
			this.concreteView.getRole().setText(this.role.getDescription());
		}
	}

}
