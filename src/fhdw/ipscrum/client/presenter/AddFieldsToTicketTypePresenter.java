package fhdw.ipscrum.client.presenter;

import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddFieldTypeCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;

/**
 * This class represents the presenter which controls the view to add field types to ticket types.
 */
public class AddFieldsToTicketTypePresenter extends WritePresenter {
	/**
	 * Represents the Interface of the View which is related to this presenter. It's the interface to the ({@link}
	 * fhdw.ipscrum.client.view.AddFieldsToTicketTypeView).
	 */
	public interface IAddFieldsToTicketTypeView extends IView {
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
		 * this method is needed to fill the list in the view with the data of the known field types.
		 * 
		 * @param states
		 *            are the known field types
		 */
		void refreshFields(List<FieldType> states);

		/**
		 * Getter of the selected field type on the view.
		 * 
		 * @return selected field type
		 */
		FieldType getSelectedFieldType();

	}

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IAddFieldsToTicketTypeView view;
	/**
	 * represents the ticket type related to this view. It is needed to make clear to which ticket type the field type
	 * should be added.
	 */
	private TicketType ticketType;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.AddFieldsToTicketTypePresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 * @param ticketType
	 *            is the related ticketType which should be edited
	 */
	public AddFieldsToTicketTypePresenter(final ClientContext context, final TicketType ticketType) {
		super(context);
		this.ticketType = ticketType;
		this.beginTransaction();
	}

	@Override
	public String getName() {
		return "Felder zu Tickettyp hinzufügen";
	}

	@Override
	public IAddFieldsToTicketTypeView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createAddFieldsToTicketTypeView();
			this.view.registerSave(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					AddFieldsToTicketTypePresenter.this.save();
					AddFieldsToTicketTypePresenter.this.close();
				}
			});
			this.view.registetAbort(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					AddFieldsToTicketTypePresenter.this.showQuestion("Änderungen verwerfen?", new Answer("Ja") {

						@Override
						public void onAction(final QuestionDialog widget) {
							widget.hide();
							AddFieldsToTicketTypePresenter.this.close();
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
			this.doCommand(new TicketTypeAddFieldTypeCommand(this.ticketType, this.view.getSelectedFieldType()));
			this.commitTransaction();
			return super.onSave();
		} catch (final IPScrumGeneralException e) {
			return false;
		}
	}

	@Override
	public void updateView() {
		this.view.refreshFields(this.getContext().getModel().getAllFieldTypes());
	}

	@Override
	public void onModelUpdate() {
		this.ticketType = this.updateObject(this.ticketType);
		this.updateView();
	}

}
