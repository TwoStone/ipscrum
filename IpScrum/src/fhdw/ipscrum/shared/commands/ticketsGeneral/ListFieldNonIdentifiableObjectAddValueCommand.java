package fhdw.ipscrum.shared.commands.ticketsGeneral;

import java.io.Serializable;

import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Adds a value (not an identifiable object) to a ListField.
 * 
 * @param <T>
 *            is the attached field type
 */

public class ListFieldNonIdentifiableObjectAddValueCommand<T extends Serializable>
		extends ListFieldAddValueCommand<T> {

	/**
	 * represents the value of the command.
	 */
	private T value;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private ListFieldNonIdentifiableObjectAddValueCommand() {
		super();
	}

	/**
	 * constructor of the ListFieldNonIdentifiableObjectAddValueCommand.
	 * 
	 * @param field
	 *            related to the command
	 * @param value
	 *            of the command
	 * @param ticket
	 *            related to the command
	 */
	protected ListFieldNonIdentifiableObjectAddValueCommand(final ListField<T> field,
			final T value, final Ticket ticket) {
		super(field, ticket);
		this.value = value;
	}

	@Override
	public T getValue(final Model model) throws NoObjectFindException {
		return this.value;
	}

}
