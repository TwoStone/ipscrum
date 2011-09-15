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

public abstract class SingleFieldWidget<T> extends Composite {

	private final Event<TypedEventArg<T>> selectionChangedEvent =
			new Event<TypedEventArg<T>>();

	public SingleFieldWidget() {

	}

	protected void initialize() {
		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		this.initWidget(horizontalPanel);

		this.getValues().addValueChangeHandler(new ValueChangeHandler<T>() {

			@Override
			public void onValueChange(final ValueChangeEvent<T> event) {
				SingleFieldWidget.this.selectionChangedEvent.fire(
						SingleFieldWidget.this, new TypedEventArg<T>(
								SingleFieldWidget.this.getValues().getValue()));
			}
		});

		horizontalPanel.add(this.getValueInputWidget());
	}

	public EventRegistration registerChangeHandler(
			final EventHandler<TypedEventArg<T>> handler) {
		return this.selectionChangedEvent.add(handler);
	}

	public void setValue(final T value) {
		this.getValues().setValue(value);
	}

	public abstract HasValue<T> getValues();

	public abstract Widget getValueInputWidget();
}
