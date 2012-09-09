package fhdw.ipscrum.client.view.metamodel;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * Represents the Widget of the NumberSingleField.
 */
public class NumberSingleFieldWidget extends SingleFieldWidget<Long> {
	private final LongBox longBox = new LongBox();

	/**
	 * Constructor of the NumberSingleFieldWidget.
	 */
	public NumberSingleFieldWidget() {
		super();
		this.initialize();
	}

	@Override
	public HasValue<Long> getValues() {
		return this.longBox;
	}

	@Override
	public Widget getValueInputWidget() {
		return this.longBox;
	}
}
