package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.NumberSingleFieldWidget;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

public class NumberSingleFieldTypeController extends SingleFieldTypeController<Long> {

	private final NumberSingleFieldWidget widget;

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
