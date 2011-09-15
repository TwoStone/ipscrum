package fhdw.ipscrum.client.view.metamodel;

import java.util.Date;

import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

public class DateSingleFieldWidget extends SingleFieldWidget<Date> {

	private final DateBox dateBox;

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
