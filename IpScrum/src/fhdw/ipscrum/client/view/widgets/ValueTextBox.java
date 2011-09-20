package fhdw.ipscrum.client.view.widgets;

import java.text.ParseException;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.text.shared.Parser;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.TextBox;

/**
 * Represents the ValueTextBox.
 * 
 * @param <T>
 *            is the type of the box
 */
public class ValueTextBox<T> extends Composite implements HasValue<T> {

	private final TextBox textBox;
	private T oldValue;
	private final Renderer<T> renderer;
	private final Parser<T> parser;

	/**
	 * Constructor of the ValueTextBox.
	 * 
	 * @param renderer
	 *            of the box
	 * @param parser
	 *            of the box
	 */
	public ValueTextBox(final Renderer<T> renderer, final Parser<T> parser) {
		super();
		this.renderer = renderer;
		this.parser = parser;
		this.textBox = new TextBox();
		this.textBox.setWidth("100%");
		this.textBox.setHeight("100%");
		this.textBox.addValueChangeHandler(new ValueChangeHandler<String>() {

			@Override
			public void onValueChange(final ValueChangeEvent<String> event) {
				ValueChangeEvent.fireIfNotEqual(ValueTextBox.this,
						ValueTextBox.this.oldValue, ValueTextBox.this.getValue());
			}
		});
		this.initWidget(this.textBox);
	}

	@Override
	public HandlerRegistration
			addValueChangeHandler(final ValueChangeHandler<T> handler) {
		return this.addHandler(handler, ValueChangeEvent.getType());
	}

	@Override
	public T getValue() {
		try {
			return this.parser.parse(this.textBox.getText());
		} catch (final ParseException e) {
			return null;
		}
	}

	@Override
	public void setValue(final T value) {
		this.setValue(value, false);
	}

	@Override
	public void setValue(final T value, final boolean fireEvents) {
		this.textBox.setText(this.renderer.render(value));
		if (fireEvents) {
			ValueChangeEvent.fireIfNotEqual(this, this.oldValue, value);
		}
		this.oldValue = value;
	}

	@Override
	public void setStyleName(final String style) {
		this.textBox.setStyleName(style);
	}

	@Override
	public void setStyleName(final String style, final boolean add) {
		this.textBox.setStyleName(style, add);
	}

	@Override
	public void setStylePrimaryName(final String style) {
		this.textBox.setStylePrimaryName(style);
	}

}
