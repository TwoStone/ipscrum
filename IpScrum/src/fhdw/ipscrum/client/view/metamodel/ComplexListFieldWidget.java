package fhdw.ipscrum.client.view.metamodel;

import java.util.List;

import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.client.architecture.widgets.TypedListBox;
import fhdw.ipscrum.client.architecture.widgets.TypedListBox.TypeRendere;
import fhdw.ipscrum.shared.exceptions.model.NothingSelectedException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.utils.ListUtils;

public class ComplexListFieldWidget<T extends IdentifiableObject>
		extends ListFieldWidget<T> {

	private final TypedListBox<T> availableObjectsListBox;

	public ComplexListFieldWidget(final ListField<T> field,
			final TypeRendere<T> typeRendere) {
		super(field, typeRendere);

		this.availableObjectsListBox = new TypedListBox<T>(typeRendere);
		this.availableObjectsListBox.setVisibleItemCount(1);
		this.initialize();
	}

	@Override
	public Widget getValueInputWidget() {
		return this.availableObjectsListBox;
	}

	@Override
	public T getValue() throws NothingSelectedException {
		return this.availableObjectsListBox.getSelectedItem();
	}

	public void setAvailableItems(final List<T> availableItems) {
		this.availableObjectsListBox.clear();
		this.availableObjectsListBox.addItems(ListUtils.difference(availableItems,
				this.getReferencedObjects()));
	}

}
