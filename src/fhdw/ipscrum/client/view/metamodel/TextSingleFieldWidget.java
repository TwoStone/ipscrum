package fhdw.ipscrum.client.view.metamodel;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * Represents the Widget of the TextSingleField.
 */
public class TextSingleFieldWidget extends SingleFieldWidget<String> {

	private final TextBox textBox;

	/**
	 * Constructor of the TextSingleFieldWidget.
	 */
	public TextSingleFieldWidget() {
		this.textBox = new TextBox();
		this.initialize();
	}

	@Override
	public HasValue<String> getValues() {
		return this.textBox;
	}

	@Override
	public Widget getValueInputWidget() {
		return this.textBox;
	}

}
