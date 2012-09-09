package fhdw.ipscrum.client.view.metamodel;

import java.util.List;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.client.architecture.widgets.TypedListBox;
import fhdw.ipscrum.client.architecture.widgets.TypedListBox.TypeRendere;

/**
 * Represents the ComplexSingleFieldWidget needed for complex single fields.
 * 
 * @param <T>
 *            is the type if the widget
 */
public class ComplexSingleFieldWidget<T> extends SingleFieldWidget<T> {

	private final TypedListBox<T> typedListBox;

	/**
	 * Constructor of the ComplexSingleFieldWidget.
	 * 
	 * @param typeRendere
	 *            needed to render the field for the chosen type
	 */
	public ComplexSingleFieldWidget(final TypeRendere<T> typeRendere) {
		super();
		this.typedListBox = new TypedListBox<T>(typeRendere);
		this.typedListBox.setVisibleItemCount(1);
		this.initialize();
	}

	@Override
	public HasValue<T> getValues() {
		return this.typedListBox;
	}

	@Override
	public Widget getValueInputWidget() {
		return this.typedListBox;
	}

	/**
	 * Sets the items of the Widget.
	 * 
	 * @param items
	 *            to set
	 */
	public void setItems(final List<T> items) {
		this.typedListBox.clear();
		this.typedListBox.addItems(items);
	}

}
