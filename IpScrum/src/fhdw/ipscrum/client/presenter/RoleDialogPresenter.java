package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.OneStringArgs;
import fhdw.ipscrum.client.view.RoleDialogView;
import fhdw.ipscrum.client.view.interfaces.IRoleDialogView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.interfaces.IRole;

/**
 * Represents the presenter of the view with which the user could make new roles
 * or change roles.
 */
public class RoleDialogPresenter extends Presenter<IRoleDialogView> {

	private IRoleDialogView concreteView;
	private final IRole role;

	/**
	 * Constructor for RoleDialogPresenter.
	 * 
	 * Required for changing roles.
	 * 
	 * @param parent
	 *            Panel
	 * @param selectedRole
	 *            IRole
	 * @param parentPresenter
	 */
	public RoleDialogPresenter(final Panel parent, final IRole selectedRole,
			final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
		this.role = selectedRole;
		this.initialize();
	}

	/**
	 * Constructor for RoleDialogPresenter.
	 * 
	 * Required for making new roles.
	 * 
	 * @param parent
	 *            Panel
	 * @param parentPresenter
	 */
	public RoleDialogPresenter(final Panel parent,
			final Presenter<?> parentPresenter) {
		this(parent, null, parentPresenter);
	}

	/**
	 * Method createView.
	 * 
	 * Creates the view in which the user could make a new role or change a role
	 * and defines what happens when the user pushes the cancel- or OK-button.
	 * 
	 * @return IRoleDialogView
	 */
	@Override
	protected IRoleDialogView createView() {
		this.concreteView = new RoleDialogView();

		this.concreteView.addCancelEventHandler(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				RoleDialogPresenter.this.abort();
			}
		});

		this.concreteView.addOkEventHandler(new EventHandler<OneStringArgs>() {
			@Override
			public void onUpdate(final Object sender,
					final OneStringArgs eventArgs) {
				try {
					if (RoleDialogPresenter.this.role == null) {
						SessionManager.getInstance().getModel()
								.addRole(new Role(eventArgs.getString()));
					} else {
						RoleDialogPresenter.this.role.setDescription(eventArgs
								.getString());
					}
					RoleDialogPresenter.this.finish();
				} catch (final NoValidValueException e) {
					Window.alert(e.getMessage());
				} catch (final DoubleDefinitionException e) {
					Window.alert(e.getMessage());
				}
			}
		});

		return this.concreteView;
	}

	/**
	 * Initializes the view with the values of the role chosen to change.
	 */
	private void initialize() {
		if (this.role != null) {
			this.concreteView.setRole(this.role.getDescription());
		}
	}

}
