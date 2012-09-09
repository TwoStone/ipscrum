package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexSingleFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.System;

/**
 * Represents the SystemSingleFieldTypeController needed for editing tickets.
 */
public class SystemSingleFieldTypeController extends SingleFieldTypeController<System> {

	private final ComplexSingleFieldWidget<System> widget;

	/**
	 * Constructor of the SystemSingleFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public SystemSingleFieldTypeController(final Ticket ticket, final GenericTicketPresenter presenter,
			final SingleField<System> field) {
		super(ticket, presenter, field);

		this.widget = new ComplexSingleFieldWidget<System>(TypeRenderes.SYSTEMRENDERER);
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
