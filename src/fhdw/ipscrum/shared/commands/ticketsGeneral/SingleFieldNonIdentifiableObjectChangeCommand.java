package fhdw.ipscrum.shared.commands.ticketsGeneral;

import java.io.Serializable;

import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Changes the value (not an identifiable object) of a SingleField.
 * 
 * @param <T>
 *            is the field Type
 */
public class SingleFieldNonIdentifiableObjectChangeCommand<T extends Serializable> extends SingleFieldChangeCommand<T> {

	/**
	 * represents the value of the command in the chosen field type.
	 */
	private T value;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private SingleFieldNonIdentifiableObjectChangeCommand() {
		super();
	}

	/**
	 * constructor of the SingleFieldNonIdentifiableObjectChangeCommand.
	 * 
	 * @param field
	 *            related to the Command
	 * @param value
	 *            of the command
	 * @param ticket
	 *            related to the command
	 */
	public SingleFieldNonIdentifiableObjectChangeCommand(final SingleField<T> field, final T value, final Ticket ticket) {
		super(field, ticket);
		this.value = value;
	}

	@Override
	public T getValue(final Model model) throws NoObjectFindException {
		return this.value;
	}

}
