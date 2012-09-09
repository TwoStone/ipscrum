package fhdw.ipscrum.client.presenter;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonChangeNameCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.nonMeta.Person;

/**
 * This class represents the presenter which controls the view to edit Sprints.
 */
public class PersonEditPresenter extends WritePresenter {
	/**
	 * Represents the Interface of the View which is related to this presenter. It's the interface to the ({@link}
	 * fhdw.ipscrum.client.view.PersonEditView).
	 */
	public interface IPersonEditView extends IView {
		/**
		 * Represents the Event to handle the save.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles the save
		 */
		EventRegistration registerSave(DefaultEventHandler handler);

		/**
		 * Represents the Event to handle the abort.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles the abort
		 */
		EventRegistration registetAbort(DefaultEventHandler handler);

		/**
		 * Getter of the text of the first name field on the view.
		 * 
		 * @return the text in the first name field
		 */
		String getFirstName();

		/**
		 * Getter of the text of the last name field on the view.
		 * 
		 * @return the text in the last name field
		 */
		String getLastName();

		/**
		 * this method is needed to fill the fields in the view with the data of the person to edit.
		 * 
		 * @param person
		 *            to edit
		 */
		void updateFields(Person person);
	}

	/**
	 * represents the person related to this view. It is needed to make clear which person should be edited.
	 */
	private final Person person;
	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IPersonEditView view;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.PersonEditPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 * @param person
	 *            is the related person which should be edited
	 */
	public PersonEditPresenter(final ClientContext context, final Person person) {
		super(context);
		this.person = person;
		this.beginTransaction();
	}

	@Override
	public String getName() {
		return "Person bearbeiten";
	}

	@Override
	public IPersonEditView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createPersonEditView();
			this.view.registerSave(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					PersonEditPresenter.this.save();
					PersonEditPresenter.this.close();
				}
			});
			this.view.registetAbort(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					PersonEditPresenter.this.showQuestion("Änderungen verwerfen?", new Answer("Ja") {

						@Override
						public void onAction(final QuestionDialog widget) {
							widget.hide();
							PersonEditPresenter.this.close();
						}
					}, new Answer("Nein") {

						@Override
						public void onAction(final QuestionDialog widget) {
							widget.hide();
						}
					});
				}
			});
		}

		return this.view;
	}

	@Override
	public Boolean onSave() {
		try {
			this.doCommand(new PersonChangeNameCommand(this.person, this.view.getFirstName(), this.view.getLastName()));
			this.commitTransaction();
			return super.onSave();
		} catch (final IPScrumGeneralException e) {
			return false;
		}
	}

	@Override
	public void updateView() {
		this.view.updateFields(this.person);
	}

	@Override
	public void onModelUpdate() {

	}

}
