package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexTextListFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeParser;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Hint;

/**
 * Represents the HintListFieldTypeController which is needed for editing tickets.
 */
public class HintListFieldTypeController extends ListFieldTypeController<Hint> {

	/**
	 * Constructor of the HintListFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public HintListFieldTypeController(final GenericTicketPresenter presenter, final ListField<Hint> field,
			final Ticket ticket) {
		super(presenter, field, ticket);
		this.widget = new ComplexTextListFieldWidget<Hint>(this.getField(), TypeRenderes.HINTRENDERER, this.parser);
		this.initialize();
	}

	private final TypeParser<Hint, String> parser = new TypeParser<Hint, String>() {

		@Override
		public Hint parse(final String value) {
			return new Hint(HintListFieldTypeController.this.getPresenter().getContext().getModel(), value);
		}
	};

	private final ComplexTextListFieldWidget<Hint> widget;

	@Override
	public ComplexTextListFieldWidget<Hint> getWidget() {
		return this.widget;
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setItems(this.getField().getValues());
	}
}
