package fhdw.ipscrum.client.view.metamodel;

import com.google.gwt.text.shared.Parser;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.client.view.widgets.ValueTextBox;

public class ComplexSingleValueFieldWidget<T> extends SingleFieldWidget<T> {

	private final ValueTextBox<T> textBox;

	public ComplexSingleValueFieldWidget(final Parser<T> parser,
			final Renderer<T> renderer) {
		this.textBox = new ValueTextBox<T>(renderer, parser);
		this.initialize();
	}

	@Override
	public HasValue<T> getValues() {
		return this.textBox;
	}

	@Override
	public Widget getValueInputWidget() {
		return this.textBox;
	}

}
