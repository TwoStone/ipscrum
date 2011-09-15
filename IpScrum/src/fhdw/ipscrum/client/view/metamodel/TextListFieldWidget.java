package fhdw.ipscrum.client.view.metamodel;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.shared.exceptions.model.NothingSelectedException;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;

public class TextListFieldWidget extends ListFieldWidget<String> {

	private final TextBox textBox;

	public TextListFieldWidget(final ListField<String> field) {
		super(field, TypeRenderes.StringRenderer);
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
