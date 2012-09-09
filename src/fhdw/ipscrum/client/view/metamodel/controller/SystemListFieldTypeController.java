package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexListFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.System;

/**
 * Represents the SystemListFieldTypeController needed for editing tickets.
 */
public class SystemListFieldTypeController extends ListFieldTypeController<System> {

	private final ComplexListFieldWidget<System> widget;

	/**
	 * Constructor of the SystemListFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public SystemListFieldTypeController(final GenericTicketPresenter presenter, final ListField<System> field,
			final Ticket ticket) {
		super(presenter, field, ticket);

		this.widget = new ComplexListFieldWidget<System>(this.getField(), TypeRenderes.SYSTEMRENDERER);
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
