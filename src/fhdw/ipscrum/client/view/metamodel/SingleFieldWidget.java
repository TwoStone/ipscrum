package fhdw.ipscrum.client.view.metamodel;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;

/**
 * Represents the Widget of the SingleField.
 * 
 * @param <T>
 *            is the type related to the widget
 */
public abstract class SingleFieldWidget<T> extends Composite {

	private final Event<TypedEventArg<T>> selectionChangedEvent = new Event<TypedEventArg<T>>();

	/**
	 * Constructor of the SingleFieldWidget.
	 */
	public SingleFieldWidget() {

	}

	protected void initialize() {
		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		this.initWidget(horizontalPanel);

		this.getValues().addValueChangeHandler(new ValueChangeHandler<T>() {

			@Override
			public void onValueChange(final ValueChangeEvent<T> event) {
				SingleFieldWidget.this.selectionChangedEvent.fire(SingleFieldWidget.this, new TypedEventArg<T>(
						SingleFieldWidget.this.getValues().getValue()));
			}
		});

		horizontalPanel.add(this.getValueInputWidget());
	}

	/**
	 * Represents the event to handle the change.
	 * 
	 * @param handler
	 *            needed for handling the event
	 * @return the event to handle the change
	 */
	public EventRegistration registerChangeHandler(final EventHandler<TypedEventArg<T>> handler) {
		return this.selectionChangedEvent.add(handler);
	}

	/**
	 * sets the value of the widget.
	 * 
	 * @param value
	 *            to set
	 */
	public void setValue(final T value) {
		this.getValues().setValue(value);
	}

	/**
	 * Getter of the values in the widgets.
	 * 
	 * @return the values
	 */
	public abstract HasValue<T> getValues();

	/**
	 * Getter of the value input widget.
	 * 
	 * @return the Widget
	 */
	public abstract Widget getValueInputWidget();
}
