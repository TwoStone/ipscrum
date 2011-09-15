package fhdw.ipscrum.client.view.metamodel;

import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.shared.exceptions.model.NothingSelectedException;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;

public class NumberListFieldWidget extends ListFieldWidget<Long> {

	private final LongBox longBox;

	public NumberListFieldWidget(final ListField<Long> field) {
		super(field, TypeRenderes.LongRenderer);
		this.longBox = new LongBox();
		this.initialize();
	}

	@Override
	public Widget getValueInputWidget() {
		return this.longBox;
	}

	@Override
	public Long getValue() throws NothingSelectedException {
		return this.longBox.getValue();
	}

}
