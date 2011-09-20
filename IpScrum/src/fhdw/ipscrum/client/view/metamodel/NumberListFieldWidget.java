package fhdw.ipscrum.client.view.metamodel;

import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.shared.exceptions.model.NothingSelectedException;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;

/**
 * Represents the Widget of the NumberListField.
 */
public class NumberListFieldWidget extends ListFieldWidget<Long> {

	private final LongBox longBox;

	/**
	 * Constructor of the NumberListFieldWidget.
	 * 
	 * @param field
	 *            related to the widget
	 */
	public NumberListFieldWidget(final ListField<Long> field) {
		super(field, TypeRenderes.LONGRENDERER);
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
