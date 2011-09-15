package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexListFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

public class SprintListFieldTypeController extends ListFieldTypeController<Sprint> {

	private final ComplexListFieldWidget<Sprint> widget;

	public SprintListFieldTypeController(final GenericTicketPresenter presenter,
			final ListField<Sprint> field, final Ticket ticket) {
		super(presenter, field, ticket);

		this.widget =
				new ComplexListFieldWidget<Sprint>(this.getField(),
						TypeRenderes.SprintRenderer);
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
