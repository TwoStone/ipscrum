package fhdw.ipscrum.shared.commands.ticketsGeneral;

import java.io.Serializable;

import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Changes the value (an identifiable object) of a SingleField.
 * 
 * @param <T>
 *            is the selected field type
 */
public class SingleFieldIdentifiableObjectChangeCommand<T extends Serializable>
		extends SingleFieldChangeCommand<T> {

	/**
	 * represents the value of the command.
	 */
	private String valueId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private SingleFieldIdentifiableObjectChangeCommand() {
		super();
	}

	/**
	 * constructor of the SingleFieldIdentifiableObjectChangeCommand.
	 * 
	 * @param field
	 *            related to the command
	 * @param value
	 *            of the command
	 * @param ticket
	 *            related to the command
	 */
	public SingleFieldIdentifiableObjectChangeCommand(final SingleField<T> field,
			final T value, final Ticket ticket) {
		super(field, ticket);
		this.valueId = ((IdentifiableObject) value).getId();

	}

	@SuppressWarnings("unchecked")
	@Override
	public T getValue(final Model model) throws NoObjectFindException {
		return (T) model.getObject(this.valueId);
	}

}
