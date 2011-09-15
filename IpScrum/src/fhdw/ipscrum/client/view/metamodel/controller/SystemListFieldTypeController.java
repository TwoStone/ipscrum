package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexListFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.System;

public class SystemListFieldTypeController extends ListFieldTypeController<System> {

	private final ComplexListFieldWidget<System> widget;

	public SystemListFieldTypeController(final GenericTicketPresenter presenter,
			final ListField<System> field, final Ticket ticket) {
		super(presenter, field, ticket);

		this.widget =
				new ComplexListFieldWidget<System>(this.getField(),
						TypeRenderes.SystemRenderer);
		this.initialize();
	}

	@Override
	public ComplexListFieldWidget<System> getWidget() {
		return this.widget;
	}

	@Override
	public void updateWidget(final Model model) {
		this.widget.setItems(this.getField().getValues());
		this.widget.setAvailableItems(this.getTicket().getProject().getSystems());
	}

}
