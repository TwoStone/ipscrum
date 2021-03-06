package fhdw.ipscrum.client.view.metamodel;

import java.io.Serializable;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.widgets.TypedListBox;
import fhdw.ipscrum.client.architecture.widgets.TypedListBox.TypeRendere;
import fhdw.ipscrum.shared.exceptions.model.NothingSelectedException;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;

/**
 * Represents the Widget of the ListFields.
 * 
 * @param <T>
 *            is the type if the widget
 */
public abstract class ListFieldWidget<T extends Serializable> extends Composite {

	private final Event<FieldEventArgs<T>> addEvent = new Event<FieldEventArgs<T>>();
	private final Event<FieldEventArgs<T>> removeEvent = new Event<FieldEventArgs<T>>();
	private TypedListBox<T> currentObjectsListBox;
	private final ListField<T> field;
	private final TypeRendere<T> typeRendere;

	/**
	 * Constructor of the ListFieldWidget.
	 * 
	 * @param field
	 *            related to the widget
	 * @param typeRendere
	 *            needed to render the field for the chosen type
	 */
	public ListFieldWidget(final ListField<T> field, final TypeRendere<T> typeRendere) {

		this.field = field;
		this.typeRendere = typeRendere;
	}

	protected void initialize() {
		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		this.initWidget(horizontalPanel);

		this.currentObjectsListBox = new TypedListBox<T>(this.typeRendere);
		this.currentObjectsListBox.setVisibleItemCount(3);
		this.currentObjectsListBox.setWidth("100px");
		horizontalPanel.add(this.currentObjectsListBox);

		final VerticalPanel verticalPanel = new VerticalPanel();
		horizontalPanel.add(verticalPanel);
		verticalPanel.setHeight("");

		verticalPanel.add(this.getValueInputWidget());

		final Button addButton = new Button("Hinzufügen");
		addButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {

				try {
					ListFieldWidget.this.addEvent.fire(ListFieldWidget.this, new FieldEventArgs<T>(
							ListFieldWidget.this.field, ListFieldWidget.this.getValue()));
					ListFieldWidget.this.clearValue();
				} catch (final NothingSelectedException e) {
					System.out.println("");
				}

			}
		});
		verticalPanel.add(addButton);

		final Button removeButton = new Button("Löschen");
		removeButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				try {
					// final T item = ListFieldWidget.this.currentObjectsListBox.getSelectedItem();
					ListFieldWidget.this.removeEvent.fire(ListFieldWidget.this, new FieldEventArgs<T>(
							ListFieldWidget.this.field, ListFieldWidget.this.currentObjectsListBox.getSelectedItem()));
				} catch (final NothingSelectedException e) {
					System.out.println("");
				}
			}
		});
		verticalPanel.add(removeButton);
	}

	/**
	 * Represents the event needed for handling the add event.
	 * 
	 * @param handler
	 *            the handle the event
	 * @return the event needed for handling the add event
	 */
	public EventRegistration registerAddHandler(final EventHandler<FieldEventArgs<T>> handler) {
		return this.addEvent.add(handler);
	}

	/**
	 * Represents the event needed for handling the remove event.
	 * 
	 * @param handler
	 *            the handle the event
	 * @return the event needed for handling the remove event
	 */
	public EventRegistration registerRemoveHandler(final EventHandler<FieldEventArgs<T>> handler) {
		return this.removeEvent.add(handler);
	}

	/**
	 * Sets the items of the widget.
	 * 
	 * @param referencedItems
	 *            to set in the widget
	 */
	public void setItems(final List<T> referencedItems) {
		this.currentObjectsListBox.clear();
		this.currentObjectsListBox.addItems(referencedItems);
	}

	/**
	 * Getter of the valueInputWidget.
	 * 
	 * @return the widget
	 */
	public abstract Widget getValueInputWidget();

	/**
	 * Getter of the value related to the widget.
	 * 
	 * @return the related value
	 * @throws NothingSelectedException
	 *             if no value is selected
	 */
	public abstract T getValue() throws NothingSelectedException;

	protected List<T> getReferencedObjects() {
		return this.currentObjectsListBox.getList();
	}

	protected void clearValue() {

	}
}
