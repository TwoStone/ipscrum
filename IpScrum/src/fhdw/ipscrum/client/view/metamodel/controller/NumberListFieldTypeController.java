package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.NumberListFieldWidget;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Represents the NumberListFieldTypeController needed for editing tickets.
 */
public class NumberListFieldTypeController extends ListFieldTypeController<Long> {

	private final NumberListFieldWidget widget;

	/**
	 * Constructor of the NumberListFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public NumberListFieldTypeController(final GenericTicketPresenter presenter,
			final ListField<Long> field, final Ticket ticket) {
		super(presenter, field, ticket);
		this.widget = new NumberListFieldWidget(this.getField());
		this.initialize();
	}

	@Override
	public NumberListFieldWidget getWidget() {
		return this.widget;
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setItems(this.getField().getValues());
	}

}
