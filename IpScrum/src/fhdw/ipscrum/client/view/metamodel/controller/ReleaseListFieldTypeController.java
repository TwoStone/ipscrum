package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexListFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * Represents the ReleaseListFieldTypeController needed for editing tickets.
 */
public class ReleaseListFieldTypeController extends ListFieldTypeController<Release> {

	private final ComplexListFieldWidget<Release> widget;

	/**
	 * Constructor of the ReleaseListFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public ReleaseListFieldTypeController(final GenericTicketPresenter presenter,
			final ListField<Release> field, final Ticket ticket) {
		super(presenter, field, ticket);

		this.widget =
				new ComplexListFieldWidget<Release>(this.getField(),
						TypeRenderes.RELEASERENDERER);
		this.initialize();
	}

	@Override
	public ComplexListFieldWidget<Release> getWidget() {
		return this.widget;
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setItems(this.getField().getValues());
		this.getWidget().setAvailableItems(this.getTicket().getProject().getReleases());
	}

}
