package fhdw.ipscrum.client.view.metamodel;

import java.util.List;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.client.architecture.widgets.TypedListBox;
import fhdw.ipscrum.client.architecture.widgets.TypedListBox.TypeRendere;

public class ComplexSingleFieldWidget<T> extends SingleFieldWidget<T> {

	private final TypedListBox<T> typedListBox;

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

	public void setItems(final List<T> items) {
		this.typedListBox.clear();
		this.typedListBox.addItems(items);
	}

}
