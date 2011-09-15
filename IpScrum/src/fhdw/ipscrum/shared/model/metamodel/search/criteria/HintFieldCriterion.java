package fhdw.ipscrum.shared.model.metamodel.search.criteria;

import fhdw.ipscrum.shared.model.metamodel.fields.Field;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldVisitor;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.search.SearchCriteria;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Hint;

/**
 * Represents the Search Criterion for HintFields.
 */
@SuppressWarnings("serial")
public class HintFieldCriterion extends SearchCriteria {

	/**
	 * represents the searched hint.
	 */
	private final String hintContent;

	/**
	 * represents the success of the search.
	 */
	private Boolean returnValue = false;;

	/**
	 * Getter of the searched hint.
	 * 
	 * @return the value of the searched hint
	 */
	public String getHintContent() {
		return this.hintContent;
	}

	/**
	 * Constructor of the HintFieldCriterion.
	 * 
	 * @param hintContent
	 *            is the searched hint
	 */
	public HintFieldCriterion(final String hintContent) {
		super();
		this.hintContent = hintContent;
	}

	@Override
	public boolean search(final Ticket ticket) {

		for (final Field<Hint> current : ticket.getAllHintFields()) {
			current.accept(new FieldVisitor() {

				@Override
				public void handleSingleField(final SingleField<?> singleField) {
					@SuppressWarnings("unchecked")
					final SingleField<Hint> hf = (SingleField<Hint>) singleField;
					HintFieldCriterion.this.returnValue =
							hf.getValue().getContent()
									.contains(HintFieldCriterion.this.hintContent);

				}

				@Override
				public void handleListField(final ListField<?> listField) {
					@SuppressWarnings("unchecked")
					final ListField<Hint> lf = (ListField<Hint>) listField;
					for (final Hint current : lf.getValues()) {
						if (current.getContent().contains(
								HintFieldCriterion.this.hintContent)) {
							HintFieldCriterion.this.returnValue = true;
							break;
						}
					}

				}
			});
		}
		return this.returnValue;
	}
}
