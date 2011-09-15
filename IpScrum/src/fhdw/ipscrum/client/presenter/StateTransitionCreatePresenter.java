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
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TransitionRuleCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;

/**
 * This class represents the presenter which controls the view to create
 * StateTransistions.
 */
public class StateTransitionCreatePresenter extends WritePresenter {
	/**
	 * Represents the Interface of the View which is related to this presenter. It's the
	 * interface to the ({@link} fhdw.ipscrum.client.view.StateTransitionCreateView).
	 */
	public static interface IStateTransitionCreateView extends IView {
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
		 * Getter of the text of the original state field on the view.
		 * 
		 * @return the text in the original state field
		 */
		StateType getOriginalState();

		/**
		 * Getter of the text of the subsequent state field on the view.
		 * 
		 * @return the text in the subsequent state field
		 */
		StateType getSubSequentState();

		/**
		 * this method is needed to fill the list in the view with the data of the known
		 * state types for the original state.
		 * 
		 * @param statetype
		 *            are the known state types
		 */
		void updateComboBoxType(List<StateType> statetype);

		/**
		 * this method is needed to fill the list in the view with the data of the known
		 * state types for the subsequnet state.
		 * 
		 * @param statetype
		 *            are the known state types
		 */
		void updateComboBoxMultiplicity(List<StateType> statetype);

	}

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IStateTransitionCreateView view;
	/**
	 * represents the ticket type related to this view. It is needed to make clear to
	 * which ticket type the transition should be created.
	 */
	private final TicketType ticketType;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.TeamCreatePresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 * @param ticketType
	 *            is the ticketType to which the new transition is related
	 */
	public StateTransitionCreatePresenter(final ClientContext context,
			final TicketType ticketType) {
		super(context);
		this.ticketType = ticketType;
		this.beginTransaction();
	}

	@Override
	public String getName() {
		return "Zustandsübergang erstellen";
	}

	@Override
	public IStateTransitionCreateView getView() {
		if (this.view == null) {
			this.view =
					this.getContext().getViewFactory()
							.createStateTransitionCreateView();
			this.view.registerSave(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					StateTransitionCreatePresenter.this.save();
					StateTransitionCreatePresenter.this.close();
				}
			});
			this.view.registetAbort(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					StateTransitionCreatePresenter.this.showQuestion(
							"Möchten sie die Seite ohne Speichern verlassen?",
							new Answer("Ja!") {

								@Override
								public void onAction(final QuestionDialog widget) {
									widget.hide();
									StateTransitionCreatePresenter.this.close();
								}
							}, new Answer("Nein!") {

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
			this.doCommand(new TransitionRuleCreateCommand(this.ticketType, this.view
					.getOriginalState(), this.view.getSubSequentState()));
			this.commitTransaction();
			return super.onSave();
		} catch (final IPScrumGeneralException e) {
			return false;
		}

	}

	@Override
	public void updateView() {
		this.view.updateComboBoxMultiplicity(this.ticketType.getStateProfile()
				.getPossibleStates());
		this.view.updateComboBoxType(this.ticketType.getStateProfile()
				.getPossibleStates());
	}

	@Override
	public void onModelUpdate() {

	}

}
