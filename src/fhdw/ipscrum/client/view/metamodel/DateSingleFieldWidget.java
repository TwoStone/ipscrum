package fhdw.ipscrum.client.view.metamodel;

import java.util.Date;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

/**
 * Represents the DateSingleFieldWidget.
 */
public class DateSingleFieldWidget extends SingleFieldWidget<Date> {

	private final DateBox dateBox;

	/**
	 * Constructor of the DateSingleFieldWidget.
	 */
	public DateSingleFieldWidget() {
		super();
		this.dateBox = new DateBox();
		this.initialize();
	}

	@Override
	public HasValue<Date> getValues() {
		return this.dateBox;
	}

	@Override
	public Widget getValueInputWidget() {
		return this.dateBox;
	}

}
