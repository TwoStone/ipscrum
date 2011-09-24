package fhdw.ipscrum.client.presenter;

import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.eventargs.AssociatePersonAndRoleArgs;
import fhdw.ipscrum.client.eventargs.MultipleRoleArgs;
import fhdw.ipscrum.client.viewinterfaces.IPersonRoleView;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonAddRoleCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonRemoveRoleCommand;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.RoleDeleteCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Role;

/**
 * This class represents the presenter which controls the view to administer Roles and Persons.
 */
public class PersonRolePresenter extends WritePresenter {

	/**
	 * Represents the view which is related to and controlled by this presenter.
	 */
	private IPersonRoleView view;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.PersonRolePresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 */
	public PersonRolePresenter(final ClientContext context) {
		super(context);
	}

	@Override
	public String getName() {
		return "Personen- und Rollenübersicht";
	}

	@Override
	public IView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createPersonRoleView();

			this.view.defineNewPersonEventHandler(new DefaultEventHandler() {
				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					PersonRolePresenter.this.newPerson();
				}
			});

			this.view.defineModifyPersonEventHandler(new EventHandler<TypedEventArg<Person>>() {
				@Override
				public void onUpdate(final Object sender, final TypedEventArg<Person> eventArgs) {
					PersonRolePresenter.this.modifyPerson(eventArgs.getObject());
				}
			});

			this.view.defineNewRoleEventHandler(new DefaultEventHandler() {
				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					PersonRolePresenter.this.newRole();
				}
			});

			this.view.defineRemoveRoleEventHandler(new EventHandler<MultipleRoleArgs>() {
				@Override
				public void onUpdate(final Object sender, final MultipleRoleArgs eventArgs) {
					PersonRolePresenter.this.deleteRoles(eventArgs.getRoles());
				}
			});

			this.view.defineAddRoleToPersonEventHandler(new EventHandler<AssociatePersonAndRoleArgs>() {
				@Override
				public void onUpdate(final Object sender, final AssociatePersonAndRoleArgs eventArgs) {
					PersonRolePresenter.this.addRoleToPerson(eventArgs.getPerson(), eventArgs.getRoles());
				}
			});

			this.view.defineRemoveRoleFromPersonEventHandler(new EventHandler<AssociatePersonAndRoleArgs>() {
				@Override
				public void onUpdate(final Object sender, final AssociatePersonAndRoleArgs eventArgs) {
					PersonRolePresenter.this.removeRoleFromPerson(eventArgs.getPerson(), eventArgs.getRoles());
				}
			});
			this.view.defineEditRightsEventHander(new EventHandler<TypedEventArg<Role>>() {

				@Override
				public void onUpdate(final Object sender, final TypedEventArg<Role> eventArgs) {
					PersonRolePresenter.this.startPresenter(new AddRightsToRolePresenter(PersonRolePresenter.this
							.getContext(), eventArgs.getObject()));
				}
			});

		}

		return this.view;
	}

	/**
	 * this method opens the function to create a new person. The creation is done in the {@link}
	 * fhdw.ipscrum.client.presenter.PersonCreatePresenter .
	 */
	private void newPerson() {
		final PersonCreatePresenter personCreatePresenter = new PersonCreatePresenter(this.getContext());
		this.startPresenter(personCreatePresenter);
	}

	/**
	 * this method opens the function to edit a person. The edit is done in the {@link}
	 * fhdw.ipscrum.client.presenter.PersonEditPresenter .
	 * 
	 * @param person
	 *            to edit
	 */
	private void modifyPerson(final Person person) {
		final PersonEditPresenter personEditPresenter = new PersonEditPresenter(this.getContext(), person);
		this.startPresenter(personEditPresenter);
	}

	/**
	 * this method opens the function to create a new role. The creation is done in the {@link}
	 * fhdw.ipscrum.client.presenter.RoleCreatePresenter .
	 */
	private void newRole() {
		final RoleCreatePresenter roleCreatePresenter = new RoleCreatePresenter(this.getContext());
		this.startPresenter(roleCreatePresenter);
	}

	/**
	 * this method opens the function to delete a role.
	 * 
	 * @param roles
	 *            to delete
	 */
	private void deleteRoles(final List<Role> roles) {
		try {
			this.beginTransaction();
			for (final Role role : roles) {
				final RoleDeleteCommand command = new RoleDeleteCommand(role);
				this.doCommand(command);
			}
			this.commitTransaction();
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			this.rollbackTransaction();
		}
	}

	/**
	 * this method opens the function to add roles to a person.
	 * 
	 * @param person
	 *            to add the roles to
	 * @param roles
	 *            the roles to add to the person
	 * 
	 */
	private void addRoleToPerson(final Person person, final List<Role> roles) {
		try {
			this.beginTransaction();
			for (final Role role : roles) {
				final PersonAddRoleCommand command = new PersonAddRoleCommand(person, role);
				this.doCommand(command);
			}
			this.commitTransaction();
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			this.rollbackTransaction();
		}
	}

	/**
	 * this method opens the function to remove roles from a person.
	 * 
	 * @param person
	 *            to remove the roles from
	 * @param roles
	 *            the roles to remove from the person
	 * 
	 */
	private void removeRoleFromPerson(final Person person, final List<Role> roles) {
		try {
			this.beginTransaction();
			for (final Role role : roles) {
				final PersonRemoveRoleCommand command = new PersonRemoveRoleCommand(person, role);
				this.doCommand(command);
			}
			this.commitTransaction();
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			this.rollbackTransaction();
		}
	}

	@Override
	public void updateView() {
		this.setViewRightVisibility(this.getContext().getModel().getRightManager().getPersonRoleAdminRight());
		this.view.updatePersonTable(this.getContext().getModel().getAllPersons());
		this.view.updateAvailRoleList(this.getContext().getModel().getAllRoles());
		this.view.updateAssignedRoleDisplay();
	}

	@Override
	public void onModelUpdate() {
		this.updateView();
	}

}
