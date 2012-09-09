package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexListFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * Represents the SprintListFieldTypeController needed for editing tickets.
 */
public class SprintListFieldTypeController extends ListFieldTypeController<Sprint> {

	private final ComplexListFieldWidget<Sprint> widget;

	/**
	 * Constructor of the SprintListFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public SprintListFieldTypeController(final GenericTicketPresenter presenter, final ListField<Sprint> field,
			final Ticket ticket) {
		super(presenter, field, ticket);

		this.widget = new ComplexListFieldWidget<Sprint>(this.getField(), TypeRenderes.SPRINTRENDERER);
		this.initialize();
	}

	@Override
	public ComplexListFieldWidget<Sprint> getWidget() {
		return this.widget;
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setItems(this.getField().getValues());
		this.getWidget().setAvailableItems(this.getTicket().getProject().getSprints());
	}

}
