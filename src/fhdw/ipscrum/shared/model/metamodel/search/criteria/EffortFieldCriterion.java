package fhdw.ipscrum.shared.model.metamodel.search.criteria;

import fhdw.ipscrum.shared.model.metamodel.fields.Field;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldVisitor;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.search.SearchCriteria;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Effort;

/**
 * Represents the Search Criterion for EffortFields.
 */
@SuppressWarnings("serial")
public class EffortFieldCriterion extends SearchCriteria {

	/**
	 * Represents the searched Effort.
	 */
	private final Effort effort;

	/**
	 * Represents the success of the search.
	 */
	private Boolean returnValue = false;;

	/**
	 * Getter of the SearchCriterion.
	 * 
	 * @return the searched effort
	 */
	public Effort getEffort() {
		return this.effort;
	}

	/**
	 * Constructor of the EffortFieldCriterion.
	 * 
	 * @param effort
	 *            is the searched effort
	 */
	public EffortFieldCriterion(final Effort effort) {
		super();
		this.effort = effort;
	}

	@Override
	public boolean search(final Ticket ticket) {

		for (final Field<Effort> current : ticket.getAllEffortFields()) {
			current.accept(new FieldVisitor() {

				@Override
				public void handleSingleField(final SingleField<?> singleField) {
					EffortFieldCriterion.this.returnValue =
							singleField.getValue().equals(EffortFieldCriterion.this.effort);

				}

				@Override
				public void handleListField(final ListField<?> listField) {
					@SuppressWarnings("unchecked")
					final ListField<Effort> lf = (ListField<Effort>) listField;
					for (final Effort cur : lf.getValues()) {
						if (cur.equals(EffortFieldCriterion.this.effort)) {
							EffortFieldCriterion.this.returnValue = true;
							break;
						}
					}

				}
			});
		}
		return this.returnValue;
	}

}
