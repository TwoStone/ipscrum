package fhdw.ipscrum.client.presenter;

import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.presenter.ReadPresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;

/**
 * This class represents the presenter which controls the view to switch to the ticketType
 * details.
 */
public class TicketTypeSelectionPresenter extends ReadPresenter {

	/**
	 * Represents the Interface of the View which is related to this presenter. It's the
	 * interface to the ({@link} fhdw.ipscrum.client.view.TicketTypeSelectionView).
	 */
	public static interface ITicketTypeSelectionView extends IView {

		/**
		 * Represents the Event to handle the switch to the ticketType details.
		 * 
		 * @param handler
		 *            needed to handle the event, and also knows the ticketType to switch
		 *            to
		 * @return the event which handles the switch
		 */
		EventRegistration registerGotoProjectHandler(
				EventHandler<TypedEventArg<TicketType>> handler);

		/**
		 * this method is needed to fill the list in the view with the data of the
		 * existing ticketTypes.
		 * 
		 * @param ticketTypes
		 *            are the existing ticketTypes
		 */
		void setTicketTypes(List<TicketType> ticketTypes);
	}

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private ITicketTypeSelectionView view;

	/**
	 * constructor of the ({@link}
	 * fhdw.ipscrum.client.presenter.TicketTypeSelectionPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 */
	public TicketTypeSelectionPresenter(final ClientContext context) {
		super(context);
	}

	@Override
	public String getName() {
		return "Tickettypübersicht";
	}

	@Override
	public ITicketTypeSelectionView getView() {
		if (this.view == null) {
			this.view =
					this.getContext().getViewFactory().createTicketTypeSelectionView();
			this.view
					.registerGotoProjectHandler(new EventHandler<TypedEventArg<TicketType>>() {

						@Override
						public void onUpdate(final Object sender,
								final TypedEventArg<TicketType> eventArgs) {
							if (eventArgs.getObject().isStandardTicketType()) {
								TicketTypeSelectionPresenter.this
										.getContext()
										.getToastMessageController()
										.toastMessage(
												"Standardtickettypen dürfen nicht verändert werden!");
							} else {
								TicketTypeSelectionPresenter.this.gotoProject(eventArgs
										.getObject());
							}

						}
					});

		}
		return this.view;
	}

	/**
	 * this method is needed to switch to a selected ticketType.
	 * 
	 * @param object
	 *            is the TicketType to show the details of
	 */
	private void gotoProject(final TicketType object) {
		this.startPresenter(new TypeEditPresenter(this.getContext(), object));
	}

	@Override
	public void updateView() {
		this.getView().setTicketTypes(this.getContext().getModel().getAllTicketTypes());
	}

	@Override
	public void onModelUpdate() {
		this.updateView();
	}

}
