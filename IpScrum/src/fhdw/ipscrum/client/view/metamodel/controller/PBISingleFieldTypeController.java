package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexSingleFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;

/**
 * Represents the PBISingleFieldTypeController needed for editing tickets.
 */
public class PBISingleFieldTypeController
		extends SingleFieldTypeController<ProductBacklogItem> {

	/**
	 * Constructor of the PBISingleFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public PBISingleFieldTypeController(final Ticket ticket,
			final GenericTicketPresenter presenter,
			final SingleField<ProductBacklogItem> field) {
		super(ticket, presenter, field);
		this.widget =
				new ComplexSingleFieldWidget<ProductBacklogItem>(
						TypeRenderes.PBIRENDERER);
		this.initialize();
	}

	private final ComplexSingleFieldWidget<ProductBacklogItem> widget;

	@Override
	public void updateWidget(final Model model) {
		this.widget.setItems(this.getTicket().getProject().getBacklog().getItems());
	}

	@Override
	public ComplexSingleFieldWidget<ProductBacklogItem> getWidget() {
		return this.widget;
	}

}
