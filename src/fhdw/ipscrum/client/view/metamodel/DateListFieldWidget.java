package fhdw.ipscrum.client.view.metamodel;

import java.util.Date;

import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;

import fhdw.ipscrum.shared.exceptions.model.NothingSelectedException;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;

/**
 * Represents the DateListFieldWidget.
 */
public class DateListFieldWidget extends ListFieldWidget<Date> {

	private final DateBox dateBox;

	/**
	 * Constructor of the DateListFieldWidget.
	 * 
	 * @param field
	 *            related to the widget
	 */
	public DateListFieldWidget(final ListField<Date> field) {
		super(field, TypeRenderes.DATERENDERER);

		this.dateBox = new DateBox();
		this.initialize();
	}

	@Override
	public Widget getValueInputWidget() {
		return this.dateBox;
	}

	@Override
	public Date getValue() throws NothingSelectedException {
		return this.dateBox.getValue();
	}

}
