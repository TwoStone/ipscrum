package fhdw.ipscrum.shared.model.metamodel.search.criteria;

import java.util.Date;
import java.util.List;

import fhdw.ipscrum.shared.model.metamodel.fields.Field;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldVisitor;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.search.SearchCriteria;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.utils.CalendarUtils;

/**
 * Represents the Search Criterion for DateFields.
 */
@SuppressWarnings("serial")
public class DateFieldCriterion extends SearchCriteria {

	/**
	 * Represents the value of the Criterion.
	 */
	private final Date value;

	/**
	 * Represents the answer if the search was successful.
	 */
	private Boolean bool;

	/**
	 * Constructor of the Criterion.
	 * 
	 * @param value
	 *            of the Criterion
	 */
	public DateFieldCriterion(final Date value) {

		this.value = CalendarUtils.copy(value);

		this.bool = false;
	}

	@Override
	public boolean search(final Ticket ticket) {
		final List<Field<Date>> dates = ticket.getAllDateFields();

		for (int i = 0; i <= dates.size(); i++) {

			dates.get(i).accept(new FieldVisitor() {

				@Override
				public void handleSingleField(final SingleField<?> singleField) {
					if (DateFieldCriterion.this.value.equals(singleField.getValue())) {
						DateFieldCriterion.this.bool = true;
					}

				}

				@Override
				public void handleListField(final ListField<?> listField) {
					// TODO Auto-generated method stub

				}
			});

		}

		return this.bool;
	}

}
