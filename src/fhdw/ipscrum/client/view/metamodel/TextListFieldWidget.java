package fhdw.ipscrum.client.view.metamodel;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.shared.exceptions.model.NothingSelectedException;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;

/**
 * Represents the Widget of the TextListField.
 */
public class TextListFieldWidget extends ListFieldWidget<String> {

	private final TextBox textBox;

	/**
	 * Constructor of the TextListFieldWidget.
	 * 
	 * @param field
	 *            is the field related to the widget
	 */
	public TextListFieldWidget(final ListField<String> field) {
		super(field, TypeRenderes.STRINGRENDERER);
		this.textBox = new TextBox();
		this.initialize();
	}

	@Override
	public Widget getValueInputWidget() {
		return this.textBox;
	}

	@Override
	public String getValue() throws NothingSelectedException {
		return this.textBox.getValue();
	}

	@Override
	protected void clearValue() {
		this.textBox.setText("");
	}

}
