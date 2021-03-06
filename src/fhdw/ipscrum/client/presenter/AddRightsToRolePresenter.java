package fhdw.ipscrum.client.presenter;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.view.IAddRightsToRoleView;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleAddRightCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleRemoveRightCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.model.userRights.Right;

/**
 * Represents the presenter which controles the view to add rights to a role.
 */
public class AddRightsToRolePresenter extends WritePresenter {

	/**
	 * Represents the view controlled by the presenter.
	 */
	private IAddRightsToRoleView view;
	/**
	 * Represents the role of which the rights should be changed.
	 */
	private Role role;

	/**
	 * Constructor of the AddRightsToRolePresenter.
	 * 
	 * @param context
	 *            is the ClientContext related to the presenter
	 * @param role
	 *            of which the rights should be changed
	 */
	public AddRightsToRolePresenter(final ClientContext context, final Role role) {
		super(context);
		this.role = role;
	}

	@Override
	public String getName() {
		return "Berechtigungen zuordnen";
	}

	@Override
	public IView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createAddRightsToRoleView();

			this.view.registerAdd(new EventHandler<TypedEventArg<Right>>() {

				@Override
				public void onUpdate(final Object sender, final TypedEventArg<Right> eventArgs) {

					AddRightsToRolePresenter.this.beginTransaction();
					try {
						AddRightsToRolePresenter.this.doCommand(new RoleAddRightCommand(
								AddRightsToRolePresenter.this.role, eventArgs.getObject()));
						AddRightsToRolePresenter.this.commitTransaction();
					} catch (final IPScrumGeneralException e) {
						AddRightsToRolePresenter.this.toastMessage(e.getMessage());
						AddRightsToRolePresenter.this.rollbackTransaction();
					}
				}
			});

			this.view.registerRemove(new EventHandler<TypedEventArg<Right>>() {

				@Override
				public void onUpdate(final Object sender, final TypedEventArg<Right> eventArgs) {

					AddRightsToRolePresenter.this.beginTransaction();
					try {
						AddRightsToRolePresenter.this.doCommand(new RoleRemoveRightCommand(
								AddRightsToRolePresenter.this.role, eventArgs.getObject()));
						AddRightsToRolePresenter.this.commitTransaction();
					} catch (final IPScrumGeneralException e) {
						AddRightsToRolePresenter.this.toastMessage(e.getMessage());
						AddRightsToRolePresenter.this.rollbackTransaction();
					}
				}
			});

		}

		return this.view;
	}

	@Override
	public void updateView() {
		try {
			this.role = this.getContext().getModel().getObject(this.role);
		} catch (final NoObjectFindException e) {
			this.toastMessage(e.getMessage());
		}
		this.view.setAddedRights(this.role.getRights());
		this.view.setRightsToAdd(this.getContext().getModel().getRightManager().getAllRights());
	}

	@Override
	public void onModelUpdate() {
		this.updateView();
	}

}
