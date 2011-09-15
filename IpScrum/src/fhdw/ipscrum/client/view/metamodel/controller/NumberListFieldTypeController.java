package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.NumberListFieldWidget;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

public class NumberListFieldTypeController extends ListFieldTypeController<Long> {

	private final NumberListFieldWidget widget;

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
