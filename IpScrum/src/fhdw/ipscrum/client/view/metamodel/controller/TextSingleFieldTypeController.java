package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.TextSingleFieldWidget;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Represents the TextSingleFieldTypeController needed for editing tickets.
 */
public class TextSingleFieldTypeController extends SingleFieldTypeController<String> {

	private final TextSingleFieldWidget widget;

	/**
	 * Constructor of the TextSingleFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public TextSingleFieldTypeController(final Ticket ticket, final GenericTicketPresenter presenter,
			final SingleField<String> field) {
		super(ticket, presenter, field);

		this.widget = new TextSingleFieldWidget();
		this.initialize();
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setValue(this.getField().getValue());
	}

	@Override
	public TextSingleFieldWidget getWidget() {
		return this.widget;
	}

}
