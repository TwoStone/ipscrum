package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.NumberSingleFieldWidget;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Represents the NumberSingleFieldTypeController needed for editing tickets.
 */
public class NumberSingleFieldTypeController extends SingleFieldTypeController<Long> {

	private final NumberSingleFieldWidget widget;

	/**
	 * Constructor of the NumberSingleFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public NumberSingleFieldTypeController(final Ticket ticket,
			final GenericTicketPresenter presenter, final SingleField<Long> field) {
		super(ticket, presenter, field);
		this.widget = new NumberSingleFieldWidget();
		this.initialize();
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setValue(this.getField().getValue());
	}

	@Override
	public NumberSingleFieldWidget getWidget() {
		return this.widget;

	}

}
