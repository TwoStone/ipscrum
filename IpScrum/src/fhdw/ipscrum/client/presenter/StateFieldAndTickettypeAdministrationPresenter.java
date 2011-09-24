package fhdw.ipscrum.client.presenter;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.presenter.ReadPresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.viewinterfaces.IStateFieldAndTickettypeAdministrationView;

/**
 * This class represents the presenter which controls the view to create new FieldTypes, StatTypes and TicketTypes.
 */
public class StateFieldAndTickettypeAdministrationPresenter extends ReadPresenter {

	/**
	 * Represents the view which is related to and controlled by this presenter.
	 */
	private IStateFieldAndTickettypeAdministrationView view;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.StateFieldAndTickettypeAdministrationPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 */
	public StateFieldAndTickettypeAdministrationPresenter(final ClientContext context) {
		super(context);
	}

	@Override
	public String getName() {
		return "Zustands-, Feld- und Tickettypenübersicht";
	}

	@Override
	public IView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createStateFieldAndTickettypeAdministrationView();

			this.view.defineNewStateTypeEvent(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					StateFieldAndTickettypeAdministrationPresenter.this.newStateType();

				}
			});
			this.view.defineNewTickettypeEvent(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					StateFieldAndTickettypeAdministrationPresenter.this.newTicketType();

				}
			});
			this.view.defineNewFieldTypeEvent(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					StateFieldAndTickettypeAdministrationPresenter.this.newFieldType();

				}
			});
		}

		return this.view;
	}

	/**
	 * this method opens the function to create a new state type. The creation is done in the {@link}
	 * fhdw.ipscrum.client.presenter.StateTypeCreatePresenter.
	 */
	private void newStateType() {
		final StateTypeCreatePresenter stateTypeCreatePresenter = new StateTypeCreatePresenter(this.getContext());
		this.startPresenter(stateTypeCreatePresenter);
	}

	/**
	 * this method opens the function to create a new ticket type. The creation is done in the {@link}
	 * fhdw.ipscrum.client.presenter.TicketTypeCreatePresenter.
	 */
	private void newTicketType() {
		final TicketTypeCreatePresenter ticketTypeCreatePresenter = new TicketTypeCreatePresenter(this.getContext());
		this.startPresenter(ticketTypeCreatePresenter);
	}

	/**
	 * this method opens the function to create a new field type. The creation is done in the {@link}
	 * fhdw.ipscrum.client.presenter.FieldTypeCreatePresenter.
	 */
	private void newFieldType() {
		final FieldTypeCreatePresenter fieldTypeCreatePresenter = new FieldTypeCreatePresenter(this.getContext());
		this.startPresenter(fieldTypeCreatePresenter);
	}

	@Override
	public void updateView() {

		this.view.updateStateTypeTableData(this.getContext().getModel().getAllStateTypes());
		this.view.updateFieldTypeTableData(this.getContext().getModel().getAllFieldTypes());
		this.view.updateTicketTypeTableData(this.getContext().getModel().getAllTicketTypes());
	}

	@Override
	public void onModelUpdate() {
	}

}
