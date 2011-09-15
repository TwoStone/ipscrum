package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexSingleFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Release;

public class ReleaseSingleFieldTypeController
		extends SingleFieldTypeController<Release> {

	private final ComplexSingleFieldWidget<Release> widget;

	public ReleaseSingleFieldTypeController(final Ticket ticket,
			final GenericTicketPresenter presenter, final SingleField<Release> field) {
		super(ticket, presenter, field);

		this.widget =
				new ComplexSingleFieldWidget<Release>(TypeRenderes.ReleaseRenderer);
		this.initialize();
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setItems(this.getTicket().getProject().getReleases());
		this.getWidget().setValue(this.getField().getValue());
	}

	@Override
	public ComplexSingleFieldWidget<Release> getWidget() {
		return this.widget;
	}

}
