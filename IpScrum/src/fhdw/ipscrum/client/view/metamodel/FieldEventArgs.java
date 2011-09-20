package fhdw.ipscrum.client.view.metamodel;

import java.io.Serializable;

import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.shared.model.metamodel.fields.Field;

/**
 * Represents the FieldEventArgs needed for the different fieldTypes.
 * 
 * @param <T>
 *            type of the field
 */
public class FieldEventArgs<T extends Serializable> extends TypedEventArg<T> {

	private final Field<T> field;

	/**
	 * Constructor of the FieldEventArgs.
	 * 
	 * @param field
	 *            related to the argument
	 * @param object
	 *            related to the argument
	 */
	public FieldEventArgs(final Field<T> field, final T object) {
		super(object);
		this.field = field;
	}

	/**
	 * Getter of the field related to the argument.
	 * 
	 * @return the related field
	 */
	public Field<T> getField() {
		return this.field;
	}

}
