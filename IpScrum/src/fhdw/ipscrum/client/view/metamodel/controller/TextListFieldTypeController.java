package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.TextListFieldWidget;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

public class TextListFieldTypeController extends ListFieldTypeController<String> {

	private final TextListFieldWidget widget;

	public TextListFieldTypeController(final GenericTicketPresenter presenter,
			final ListField<String> field, final Ticket ticket) {
		super(presenter, field, ticket);

		this.widget = new TextListFieldWidget(this.getField());
		this.initialize();
	}

	@Override
	public TextListFieldWidget getWidget() {
		return this.widget;
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setItems(this.getField().getValues());
	}

}
