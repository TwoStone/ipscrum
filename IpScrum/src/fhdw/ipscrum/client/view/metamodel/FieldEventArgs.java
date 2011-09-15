package fhdw.ipscrum.client.view.metamodel;

import java.io.Serializable;

import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.shared.model.metamodel.fields.Field;

public class FieldEventArgs<T extends Serializable> extends TypedEventArg<T> {

	private final Field<T> field;

	public FieldEventArgs(final Field<T> field, final T object) {
		super(object);
		this.field = field;
	}

	public Field<T> getField() {
		return this.field;
	}

}
