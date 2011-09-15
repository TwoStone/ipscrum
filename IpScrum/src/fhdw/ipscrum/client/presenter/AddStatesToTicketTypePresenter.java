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
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TicketTypeAddStatetypeCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;

/**
 * This class represents the presenter which controls the view to add state types to
 * ticket types.
 */
public class AddStatesToTicketTypePresenter extends WritePresenter {
	/**
	 * Represents the Interface of the View which is related to this presenter. It's the
	 * interface to the ({@link} fhdw.ipscrum.client.view.AddStatesToTicketTypeView).
	 */
	public static interface IAddStatesToTicketTypeView extends IView {
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
		 * this method is needed to fill the list in the view with the data of the known
		 * state types.
		 * 
		 * @param states
		 *            are the known state types
		 */
		void refreshStates(List<StateType> states);

		/**
		 * Getter of the selected state type on the view.
		 * 
		 * @return selected state type
		 */
		StateType getSelectedStateType();

	}

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IAddStatesToTicketTypeView view;
	/**
	 * represents the ticket type related to this view. It is needed to make clear to
	 * which ticket type the field type should be added.
	 */
	private final TicketType ticketType;

	/**
	 * constructor of the ({@link}
	 * fhdw.ipscrum.client.presenter.AddStatesToTicketTypePresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 * @param ticketType
	 *            is the related ticketType which should be edited
	 */
	public AddStatesToTicketTypePresenter(final ClientContext context,
			final TicketType ticketType) {
		super(context);
		this.ticketType = ticketType;
		this.beginTransaction();
	}

	@Override
	public String getName() {
		return "Zustände zu Tickettyp hinzufügen";
	}

	@Override
	public IAddStatesToTicketTypeView getView() {
		if (this.view == null) {
			this.view =
					this.getContext().getViewFactory()
							.createAddStatesToTicketTypeView();
			this.view.registerSave(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					AddStatesToTicketTypePresenter.this.save();
					AddStatesToTicketTypePresenter.this.close();
				}
			});
			this.view.registetAbort(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					AddStatesToTicketTypePresenter.this.showQuestion(
							"Änderungen verwerfen?", new Answer("Ja") {

								@Override
								public void onAction(final QuestionDialog widget) {
									widget.hide();
									AddStatesToTicketTypePresenter.this.close();
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
			this.doCommand(new TicketTypeAddStatetypeCommand(this.ticketType, this.view
					.getSelectedStateType()));
			this.commitTransaction();
			return super.onSave();
		} catch (final IPScrumGeneralException e) {
			return false;
		}
	}

	@Override
	public void updateView() {
		this.view.refreshStates(this.getContext().getModel().getAllStateTypes());
	}

	@Override
	public void onModelUpdate() {

	}

}
