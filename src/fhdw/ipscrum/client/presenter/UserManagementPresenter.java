package fhdw.ipscrum.client.presenter;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.presenter.ReadPresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.services.AccountService;
import fhdw.ipscrum.shared.session.User;

/**
 * This class represents the presenter which controls the view to manage the users.
 */
public class UserManagementPresenter extends ReadPresenter {

	/**
	 * is needed if something in the update of the user management fails.
	 */
	private abstract class DefaultAsyncCallback implements AsyncCallback<List<User>> {

		@Override
		public void onFailure(final Throwable caught) {
			UserManagementPresenter.this.toastMessage(caught.getMessage());
		}
	}

	/**
	 * Represents the Interface of the View which is related to this presenter. It's the interface to the ({@link}
	 * fhdw.ipscrum.client.view.UserManagementView).
	 */
	public interface IUserManagementView extends IView {

		/**
		 * this method is needed to fill the list in the view with the data of the existing users.
		 * 
		 * @param users
		 *            are the existing users
		 */
		void setUsers(List<User> users);

		/**
		 * Represents the Event to handle the create of a new user.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles the create of the new user
		 */
		EventRegistration registerNewUserHandler(DefaultEventHandler handler);
	}

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IUserManagementView view;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.UserManagementPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 */
	public UserManagementPresenter(final ClientContext context) {
		super(context);
	}

	@Override
	public String getName() {
		return "Benutzerverwaltung";
	}

	@Override
	public IUserManagementView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createUserManagementView();
			this.view.registerNewUserHandler(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					UserManagementPresenter.this.gotoNewUser();
				}
			});

		}

		return this.view;
	}

	/**
	 * this method opens the function to create a new user. The creation is done in the {@link}
	 * fhdw.ipscrum.client.presenter.UserCreatePresenter .
	 */
	private void gotoNewUser() {
		final UserCreatePresenter presenter = new UserCreatePresenter(this.getContext());
		this.startPresenter(presenter);
	}

	@Override
	public void updateView() {
		AccountService.Util.getInstance().getUsers(new DefaultAsyncCallback() {

			@Override
			public void onSuccess(final List<User> result) {
				UserManagementPresenter.this.doGetView().setUsers(result);
			}
		});
	}

	@Override
	public void onModelUpdate() {
		this.updateView();
	}

}
