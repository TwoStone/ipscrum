package fhdw.ipscrum.client.view.metamodel.controller;

import java.util.Date;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.DateListFieldWidget;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Represents the DateListFieldTypeController needed for editing tickets.
 */
public class DateListFieldTypeController extends ListFieldTypeController<Date> {

	private final DateListFieldWidget widget;

	/**
	 * Constructor of the DateListFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public DateListFieldTypeController(final GenericTicketPresenter presenter,
			final ListField<Date> field, final Ticket ticket) {
		super(presenter, field, ticket);

		this.widget = new DateListFieldWidget(this.getField());
		this.initialize();
	}

	@Override
	public DateListFieldWidget getWidget() {
		return this.widget;
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setItems(this.getField().getValues());
	}

}
