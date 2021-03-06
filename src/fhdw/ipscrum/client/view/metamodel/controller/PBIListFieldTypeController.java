package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexListFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.utils.ListUtils;

/**
 * Represents the PBIListFieldTypeController needed for editing tickets.
 */
public class PBIListFieldTypeController extends ListFieldTypeController<ProductBacklogItem> {

	private final ComplexListFieldWidget<ProductBacklogItem> widget;

	/**
	 * Constructor of the PBIListFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public PBIListFieldTypeController(final GenericTicketPresenter presenter,
			final ListField<ProductBacklogItem> field, final Ticket ticket) {
		super(presenter, field, ticket);
		this.widget = new ComplexListFieldWidget<ProductBacklogItem>(this.getField(), TypeRenderes.PBIRENDERER);
		this.initialize();
	}

	@Override
	public ComplexListFieldWidget<ProductBacklogItem> getWidget() {
		return this.widget;
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setItems(this.getField().getValues());
		this.getWidget()
				.setAvailableItems(
						ListUtils.difference(this.getTicket().getProject().getBacklog().getItems(), this.getField()
								.getValues()));

	}

}
