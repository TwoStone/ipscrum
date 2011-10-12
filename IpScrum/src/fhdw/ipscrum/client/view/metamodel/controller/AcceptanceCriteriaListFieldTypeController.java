package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexTextListFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeParser;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.AcceptanceCriterion;

/**
 * Represents the Controller of the AcceptanceCriterilaListField needed for editing tickets.
 */
public class AcceptanceCriteriaListFieldTypeController extends ListFieldTypeController<AcceptanceCriterion> {

	private final TypeParser<AcceptanceCriterion, String> parser = new TypeParser<AcceptanceCriterion, String>() {

		@Override
		public AcceptanceCriterion parse(final String value) {
			// TODO create criterion!
			return new AcceptanceCriterion(AcceptanceCriteriaListFieldTypeController.this.getPresenter().getContext()
					.getModel(), value);
		}
	};
	private ComplexTextListFieldWidget<AcceptanceCriterion> widget;

	/**
	 * Constructor of the AcceptanceCriterialListFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public AcceptanceCriteriaListFieldTypeController(final GenericTicketPresenter presenter,
			final ListField<AcceptanceCriterion> field, final Ticket ticket) {
		super(presenter, field, ticket);
		this.initialize();

	}

	@Override
	public ComplexTextListFieldWidget<AcceptanceCriterion> getWidget() {
		if (this.widget == null) {
			this.widget =
					new ComplexTextListFieldWidget<AcceptanceCriterion>(this.getField(),
							TypeRenderes.ACCEPTANCECRITERIONRENDERER, this.parser);
		}

		return this.widget;
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setItems(this.getField().getValues());
	}

}
