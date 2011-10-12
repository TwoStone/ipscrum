package fhdw.ipscrum.client.view.metamodel;

import java.io.Serializable;

import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.client.architecture.widgets.TypedListBox.TypeRendere;
import fhdw.ipscrum.shared.exceptions.model.NothingSelectedException;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;

/**
 * Represents the Widget for ComplexNumberListFields.
 * 
 * @param <T>
 */
public class ComplexNumberListFieldWidget<T extends Serializable> extends ListFieldWidget<T> {

	/**
	 * Represents the Box on the GUI containing the number.
	 */
	private IntegerBox longBox;
	private final TypeParser<T, Integer> parser;

	/**
	 * Constructor of the ComplexNumberListFieldWidget.
	 * 
	 * @param field
	 *            related to the widget
	 * @param typeRendere
	 *            needed to render the field for the chosen type
	 * @param parser
	 *            is the parser to pare the type
	 */
	public ComplexNumberListFieldWidget(final ListField<T> field, final TypeRendere<T> typeRendere,
			final TypeParser<T, Integer> parser) {
		super(field, typeRendere);
		this.parser = parser;
		this.initialize();
	}

	@Override
	public Widget getValueInputWidget() {
		if (this.longBox == null) {
			this.longBox = new IntegerBox();

		}

		return this.longBox;
	}

	@Override
	public T getValue() throws NothingSelectedException {
		return this.parser.parse(this.longBox.getValue());
	}
}
