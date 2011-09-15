package fhdw.ipscrum.shared.commands.ticketsGeneral;

import java.io.Serializable;

import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Removes a value (an identifiable object) from a ListField.
 * 
 * @param <T>
 *            is the attached field type
 */
public class ListFieldIdentifiableObjectRemoveValueCommand<T extends Serializable>
		extends ListFieldRemoveValueCommand<T> {

	/**
	 * represents the value of the command.
	 */
	private String valueId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private ListFieldIdentifiableObjectRemoveValueCommand() {
		super();
	}

	/**
	 * constructor of the ListFieldIdentifiableObjectRemoveValueCommand.
	 * 
	 * @param field
	 *            related to the command
	 * @param value
	 *            of the command
	 * @param ticket
	 *            related to the command
	 */
	protected ListFieldIdentifiableObjectRemoveValueCommand(final ListField<T> field,
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
