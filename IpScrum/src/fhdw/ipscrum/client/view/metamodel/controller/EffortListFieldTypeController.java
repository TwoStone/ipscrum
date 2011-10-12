package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexNumberListFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeParser;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Effort;

/**
 * Represents the EffortListFieldTypeControler needed for editing tickets.
 */
public class EffortListFieldTypeController extends ListFieldTypeController<Effort> {

	private final TypeParser<Effort, Integer> parser = new TypeParser<Effort, Integer>() {

		@Override
		public Effort parse(final Integer value) {
			try {
				return new Effort(value);
			} catch (final NoValidValueException e) {
				return Effort.NULL;
			}
		}
	};

	private final ComplexNumberListFieldWidget<Effort> widget;

	/**
	 * Constructor of the EffortListFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public EffortListFieldTypeController(final GenericTicketPresenter presenter, final ListField<Effort> field,
			final Ticket ticket) {
		super(presenter, field, ticket);
		this.widget =
				new ComplexNumberListFieldWidget<Effort>(this.getField(), TypeRenderes.EFFORTRENDERER, this.parser);
		this.initialize();
	}

	@Override
	public ComplexNumberListFieldWidget<Effort> getWidget() {
		return this.widget;
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setItems(this.getField().getValues());
	}

}
