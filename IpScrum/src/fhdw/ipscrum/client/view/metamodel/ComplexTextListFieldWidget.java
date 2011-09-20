package fhdw.ipscrum.client.view.metamodel;

import java.io.Serializable;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.client.architecture.widgets.TypedListBox.TypeRendere;
import fhdw.ipscrum.shared.exceptions.model.NothingSelectedException;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;

/**
 * Represents the ComplexTextListFieldWidget.
 * 
 * @param <T>
 *            is the chosen type of the widget
 */
public class ComplexTextListFieldWidget<T extends Serializable>
		extends ListFieldWidget<T> {

	private TextBox textBox;
	private final TypeParser<T, String> parser;

	/**
	 * Constructor of the ComplexTextListFieldWidget.
	 * 
	 * @param field
	 *            related to the widget
	 * @param typeRendere
	 *            needed to render the field for the chosen type
	 * @param parser
	 *            is the parser to pare the type
	 */
	public ComplexTextListFieldWidget(final ListField<T> field,
			final TypeRendere<T> typeRendere, final TypeParser<T, String> parser) {
		super(field, typeRendere);
		this.parser = parser;
		this.textBox = new TextBox();
		this.initialize();
	}

	@Override
	public Widget getValueInputWidget() {
		if (this.textBox == null) {
			this.textBox = new TextBox();
		}
		return this.textBox;
	}

	@Override
	public T getValue() throws NothingSelectedException {
		return this.parser.parse(this.textBox.getText());
	}
}
