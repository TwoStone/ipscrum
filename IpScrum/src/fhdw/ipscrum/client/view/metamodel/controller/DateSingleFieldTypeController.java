package fhdw.ipscrum.client.view.metamodel.controller;

import java.util.Date;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.DateSingleFieldWidget;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Represents the DateSingleFieldTypeController needed for editing tickets.
 */
public class DateSingleFieldTypeController extends SingleFieldTypeController<Date> {

	private final DateSingleFieldWidget widget;

	/**
	 * Constructor of the DateSingleFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public DateSingleFieldTypeController(final Ticket ticket,
			final GenericTicketPresenter presenter, final SingleField<Date> field) {
		super(ticket, presenter, field);

		this.widget = new DateSingleFieldWidget();
		this.initialize();
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setValue(this.getField().getValue());
	}

	@Override
	public DateSingleFieldWidget getWidget() {
		return this.widget;
	}

}
