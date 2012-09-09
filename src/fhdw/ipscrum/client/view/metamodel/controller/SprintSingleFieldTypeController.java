package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexSingleFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * Represents the SprintSingleFieldTypeController needed for editing tickets.
 */
public class SprintSingleFieldTypeController extends SingleFieldTypeController<Sprint> {

	private final ComplexSingleFieldWidget<Sprint> widget;

	/**
	 * Constructor of the SprintSingleFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public SprintSingleFieldTypeController(final Ticket ticket, final GenericTicketPresenter presenter,
			final SingleField<Sprint> field) {
		super(ticket, presenter, field);

		this.widget = new ComplexSingleFieldWidget<Sprint>(TypeRenderes.SPRINTRENDERER);
		this.initialize();
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setItems(this.getTicket().getProject().getSprints());
		this.getWidget().setValue(this.getField().getValue());
	}

	@Override
	public ComplexSingleFieldWidget<Sprint> getWidget() {

		return this.widget;
	}

}
