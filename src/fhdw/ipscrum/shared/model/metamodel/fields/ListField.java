package fhdw.ipscrum.shared.model.metamodel.fields;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * A list field contains a list of elements typified by T.
 * 
 * @param <T>
 *            type of wrapped list entries
 */
public class ListField<T extends Serializable> extends Field<T> {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -1362128644113146408L;

	/**
	 * Represents the values of the listField.
	 */
	private List<T> values;

	/**
	 * Constructor of the ListField.
	 * 
	 * @param model
	 *            : the listField is inserted in the model
	 * @param type
	 *            of the listField
	 */
	public ListField(final Model model, final FieldType type) {
		super(model, type);
		this.values = new ArrayList<T>();
		this.putToObjectStore();
	}

	/**
	 * Constructor of the ListField without parameters.
	 */
	protected ListField() {
		super();
	}

	/**
	 * Returns the list of values of the field.
	 * 
	 * @return list of values
	 */
	public List<T> getValues() {
		return this.values;
	}

	/**
	 * Adds a new value to the list.
	 * 
	 * @param value
	 *            of the list
	 */
	protected void addValue(final T value) {
		this.values.add(value);
	}

	/**
	 * proper client field changer. Adds the value to the list, if a change is allowed
	 * 
	 * @param value
	 *            the value to be added
	 * @param ticket
	 *            the ticket which the field belongs to
	 * @throws ConsistencyException
	 *             if the ticket type doesn't know the field type
	 * @throws ForbiddenStateException
	 *             if the current state type of the ticket doesn't allow a field change
	 */
	public void addValue(final T value, final Ticket ticket) throws ConsistencyException, ForbiddenStateException {
		ticket.checkFieldChange(this);
		this.addValue(value);
	}

	/**
	 * removes a value from the list.
	 * 
	 * @param value
	 *            of the item to remove
	 */
	protected void removeValue(final T value) {
		this.values.remove(value);
	}

	/**
	 * proper client field changer. Removes the value from the list, if a change is allowed
	 * 
	 * @param value
	 *            the value to be removed
	 * @param ticket
	 *            the ticket which the field belongs to
	 * @throws ConsistencyException
	 *             if the ticket type doesn't know the field type
	 * @throws ForbiddenStateException
	 *             if the current state type if the ticket doesn't allow a field change)
	 */
	public void removeValue(final T value, final Ticket ticket) throws ConsistencyException, ForbiddenStateException {
		ticket.checkFieldChange(this);
		this.removeValue(value);
	}

	@Override
	public void accept(final FieldVisitor v) {
		v.handleListField(this);
	}
}
