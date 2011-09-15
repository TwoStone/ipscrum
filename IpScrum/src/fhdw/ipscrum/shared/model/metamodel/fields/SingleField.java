package fhdw.ipscrum.shared.model.metamodel.fields;

import java.io.Serializable;

import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.ForbiddenStateException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * A single field contains one element of type T.
 * 
 * @author Stefan
 * 
 * @param <T>
 *            type of the wrapped object.
 */
public class SingleField<T extends Serializable> extends Field<T> {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 2971898626023171965L;

	/**
	 * concrete value is specified by the FieldType.
	 */
	private T value;

	/**
	 * Constructor of the SingleField.
	 * 
	 * @param model
	 *            is related to the singleField
	 * @param type
	 *            of the singelField
	 */
	public SingleField(final Model model, final FieldType type) {
		super(model, type);
		this.value = null;
		this.putToObjectStore();
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected SingleField() {
		super();
	}

	/**
	 * returns the wrapped value.
	 * 
	 * @return the value with the type T
	 */
	public T getValue() {
		return this.value;
	}

	/**
	 * set a new value.
	 * 
	 * @param value
	 *            with the type T
	 */
	protected void setValue(final T value) {
		this.value = value;
	}

	/**
	 * proper client field changer. modifies the value of this field, if a change is
	 * allowed.
	 * 
	 * @param valueNew
	 *            new value
	 * @param ticket
	 *            the ticket which the field belongs to
	 * @throws ConsistencyException
	 *             if the ticket type doesn't know the field type
	 * @throws ForbiddenStateException
	 *             if the current state type of the ticket doesn't allow a field change
	 */
	public void setValue(final T valueNew, final Ticket ticket)
			throws ConsistencyException, ForbiddenStateException {
		ticket.checkFieldChange(this);
		this.setValue(valueNew);
	}

	@Override
	public void accept(final FieldVisitor v) {
		v.handleSingleField(this);
	}
}
