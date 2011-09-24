package fhdw.ipscrum.client.presenter;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.presenter.UserCreatePresenter.IUserCreateView.NewUserAndPersonEventArgs;
import fhdw.ipscrum.client.presenter.UserCreatePresenter.IUserCreateView.NewUserEventArgs;
import fhdw.ipscrum.client.services.AccountService;
import fhdw.ipscrum.client.view.UserCreateView;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.nonMeta.Person;

/**
 * This class represents the presenter which controls the view to create Users.
 */
public class UserCreatePresenter extends WritePresenter {

	/**
	 * Represents the Interface of the View which is related to this presenter. It's the
	 * interface to the ({@link} fhdw.ipscrum.client.view.UserCreateView).
	 */
	public static interface IUserCreateView extends IView {
		/**
		 * this method is needed to fill the list in the view with the data of the
		 * existing persons.
		 * 
		 * @param person
		 *            are the existing persons
		 */
		void setPersons(List<Person> person);

		/**
		 * Represents new EvetnArgs which contains data for a new user with a related
		 * person to create(name, password, personFirstName and personLastName).
		 */
		public static class NewUserAndPersonEventArgs extends EventArgs {
			/**
			 * represents the nick name of the user, which is needed for the login.
			 */
			private final String name;
			/**
			 * represents the password of the user, which is needed for the login.
			 */
			private final String password;
			/**
			 * represents the first name of the person related to the user.
			 */
			private final String personFirstName;

			/**
			 * represents the last name of the person related to the user.
			 */
			private final String personLastName;

			/**
			 * constructor of the NewUserAndPersonEventArgs.
			 * 
			 * @param name
			 *            of the user
			 * @param password
			 *            of the user
			 * @param personFirstName
			 *            of the person related to the user
			 * @param personLastName
			 *            of the person related to the user
			 */
			public NewUserAndPersonEventArgs(final String name, final String password,
					final String personFirstName, final String personLastName) {
				super();
				this.name = name;
				this.password = password;
				this.personFirstName = personFirstName;
				this.personLastName = personLastName;
			}

			/**
			 * getter of the nick name related to the user to create with this args.
			 * 
			 * @return the name
			 */
			public String getName() {
				return this.name;
			}

			/**
			 * getter of the password related to the user to create with this args.
			 * 
			 * @return the password
			 */
			public String getPassword() {
				return this.password;
			}

			/**
			 * getter of the first name of the person related to the user to create with
			 * this args.
			 * 
			 * @return the first name of the person
			 */
			public String getPersonFirstName() {
				return this.personFirstName;
			}

			/**
			 * getter of the last name of the person related to the user to create with
			 * this args.
			 * 
			 * @return the last name of the person
			 */
			public String getPersonLastName() {
				return this.personLastName;
			}
		}

		/**
		 * Represents new EvetnArgs which contains data for a new user with a related
		 * person(name, password).
		 */
		public static class NewUserEventArgs extends EventArgs {
			/**
			 * represents the nick name of the user, which is needed for the login.
			 */
			private final String name;
			/**
			 * represents the password of the user, which is needed for the login.
			 */
			private final String password;
			/**
			 * represents the person may related to the user.
			 */
			private final Person person;

			/**
			 * constructor of the NewUserEventArgs.
			 * 
			 * @param name
			 *            of the user
			 * @param password
			 *            of the user
			 * @param person
			 *            may related to the user
			 */
			public NewUserEventArgs(final String name, final String password,
					final Person person) {
				super();
				this.name = name;
				this.password = password;
				this.person = person;
			}

			/**
			 * getter of the nick name related to the user to create with this args.
			 * 
			 * @return the name
			 */
			public String getName() {
				return this.name;
			}

			/**
			 * getter of the password related to the user to create with this args.
			 * 
			 * @return the password
			 */
			public String getPassword() {
				return this.password;
			}

			/**
			 * getter of the person related to the user to create with this args.
			 * 
			 * @return the person
			 */
			public Person getPerson() {
				return this.person;
			}

		}

		/**
		 * Represents the Event to handle the create of a new user.
		 * 
		 * @param handler
		 *            needed to handle the event, which also knows the args to create the
		 *            new user
		 * @return the event which handles the create
		 */
		EventRegistration registerCreateNewUser(
				EventHandler<UserCreateView.NewUserEventArgs> handler);

		/**
		 * Represents the Event to handle the create of a new user and also a person.
		 * 
		 * @param handler
		 *            needed to handle the event, which also knows the args to create the
		 *            new user and the person
		 * @return the event which handles the create
		 */
		EventRegistration registerCreateNewUserAndPerson(
				EventHandler<UserCreateView.NewUserAndPersonEventArgs> handler);

		/**
		 * Represents the Event to handle the abort.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles the abort
		 */
		EventRegistration registerAbortHandler(DefaultEventHandler handler);
	}

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IUserCreateView view;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.UserCreatePresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 */
	public UserCreatePresenter(final ClientContext context) {
		super(context);

	}

	@Override
	public String getName() {
		return "Benutzer erstellen";
	}

	@Override
	public IUserCreateView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createUserCreateView();
			this.view
					.registerCreateNewUser(new EventHandler<UserCreatePresenter.IUserCreateView.NewUserEventArgs>() {

						@Override
						public void onUpdate(final Object sender,
								final NewUserEventArgs eventArgs) {
							UserCreatePresenter.this.createNewUser(eventArgs.getName(),
									eventArgs.getPassword(), eventArgs.getPerson());
						}
					});
			this.view
					.registerCreateNewUserAndPerson(new EventHandler<UserCreatePresenter.IUserCreateView.NewUserAndPersonEventArgs>() {

						@Override
						public void onUpdate(final Object sender,
								final NewUserAndPersonEventArgs eventArgs) {
							UserCreatePresenter.this.createNewUserAndPerson(
									eventArgs.getName(), eventArgs.getPassword(),
									eventArgs.getPersonFirstName(),
									eventArgs.getPersonLastName());
						}
					});
			this.view.registerAbortHandler(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					UserCreatePresenter.this.close();
				}
			});
		}

		return this.view;
	}

	/**
	 * this method is needed to create a user and also a new person.
	 * 
	 * @param name
	 *            of the user
	 * @param password
	 *            of the user
	 * @param personFirstName
	 *            of the person
	 * @param personLastName
	 *            of the person
	 */
	private void createNewUserAndPerson(final String name, final String password,
			final String personFirstName, final String personLastName) {
		try {
			final PersonCreateCommand command =
					new PersonCreateCommand(personLastName, personFirstName);
			this.beginTransaction();
			final Person person = this.doCommand(command);
			this.createNewUser(name, password, person);

		} catch (final IPScrumGeneralException e) {
			this.getContext().getToastMessageController().toastMessage(e.toString());
		}
	}

	/**
	 * this method is needed to create a new user with an already existing person.
	 * 
	 * @param name
	 *            of the user
	 * @param password
	 *            of the user
	 * @param person
	 *            already existing which should be related to the user
	 */
	private void createNewUser(final String name, final String password,
			final Person person) {
		AccountService.Util.getInstance().createAccount(name, password, person,
				this.getContext().getActiveRole(), new AsyncCallback<Void>() {

					@Override
					public void onSuccess(final Void result) {
						UserCreatePresenter.this.commitTransaction();
						UserCreatePresenter.this.close();
					}

					@Override
					public void onFailure(final Throwable caught) {
						UserCreatePresenter.this.toastMessage(caught.getMessage());
					}
				});
	}

	@Override
	public void updateView() {
		this.doGetView().setPersons(this.getContext().getModel().getAllPersons());
	}

	@Override
	public void onModelUpdate() {

	}

}
