package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexSingleFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.System;

public class SystemSingleFieldTypeController extends SingleFieldTypeController<System> {

	private final ComplexSingleFieldWidget<System> widget;

	public SystemSingleFieldTypeController(final Ticket ticket,
			final GenericTicketPresenter presenter, final SingleField<System> field) {
		super(ticket, presenter, field);

		this.widget = new ComplexSingleFieldWidget<System>(TypeRenderes.SystemRenderer);
		this.initialize();
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setItems(this.getTicket().getProject().getSystems());
		this.getWidget().setValue(this.getField().getValue());
	}

	@Override
	public ComplexSingleFieldWidget<System> getWidget() {
		return this.widget;
	}

}
