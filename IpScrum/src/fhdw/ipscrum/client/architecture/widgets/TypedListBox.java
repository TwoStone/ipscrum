package fhdw.ipscrum.client.architecture.widgets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.HasChangeHandlers;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Focusable;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.ListBox;

import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.shared.exceptions.model.NothingSelectedException;

/**
 * Widget to show items of one type in a list box.
 * 
 * @author n.w.
 * 
 * @param <T>
 *            Type of the items to be added.
 */
public class TypedListBox<T> extends Composite implements Focusable, HasChangeHandlers, HasValue<T> {
	/**
	 * Interface for defining how an object is rendered to a string.
	 * 
	 * @author n.w.
	 * 
	 * @param <T>
	 *            Type of object that should be rendered.
	 */
	public interface TypeRendere<T> {

		/**
		 * Converts the object to its string representation.
		 * 
		 * @param object
		 *            the object that should get rendered
		 * @return a string representation of the object
		 */
		String render(T object);
	}

	private final Event<TypedEventArg<T>> selectionChange = new Event<TypedEventArg<T>>();

	/**
	 * Registers a handler for the selectionChangeEvent.
	 * 
	 * @param handler
	 *            handler that will get notified
	 */
	public void registerSelectionChangeHandler(final EventHandler<TypedEventArg<T>> handler) {
		this.selectionChange.add(handler);
	}

	private final ListBox internalListBox;

	private final List<T> internalObjectList;

	private final TypeRendere<T> renderer;

	/**
	 * Creates a new ListBox that uses the {@link TypeRendere} for displaying the items.
	 * 
	 * @param renderer
	 *            {@link TypeRendere} for displaying the items
	 */
	public TypedListBox(final TypeRendere<T> renderer) {
		this.renderer = renderer;
		this.internalListBox = new ListBox(false);
		this.internalListBox.setVisibleItemCount(3);
		this.internalObjectList = new ArrayList<T>();

		this.internalListBox.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(final ChangeEvent event) {
				try {
					TypedListBox.this.selectionChange.fire(TypedListBox.this,
							new TypedEventArg<T>(TypedListBox.this.getSelectedItem()));
					ValueChangeEvent.fire(TypedListBox.this, TypedListBox.this.getValue());
				} catch (final NothingSelectedException e) {
					System.out.println("");
				}
			}
		});
		this.initWidget(this.internalListBox);
	}

	@Override
	public HandlerRegistration addAttachHandler(final Handler handler) {
		return this.internalListBox.addAttachHandler(handler);
	}

	/**
	 * Adds a new item to the list box.
	 * 
	 * @param item
	 *            Object to add.
	 */
	public void addItem(final T item) {
		this.internalObjectList.add(item);
		this.internalListBox.addItem(this.renderer.render(item));
	}

	/**
	 * Adds a range of items to the list box.
	 * 
	 * @param items
	 *            Objects to add.
	 */
	public void addItems(final Collection<T> items) {
		for (final T current : items) {
			this.internalObjectList.add(current);
			this.internalListBox.addItem(this.renderer.render(current));
		}
	}

	@Override
	public void addStyleName(final String style) {
		this.internalListBox.addStyleName(style);
	}

	/**
	 * Returns the currently selected item.
	 * 
	 * @return Currently selected item.
	 * @throws NothingSelectedException
	 *             Is thrown if nothing is selected.
	 */
	public T getSelectedItem() throws NothingSelectedException {
		if (this.internalListBox.getSelectedIndex() == -1) {
			throw new NothingSelectedException("Kein Wert ausgewählt!");
		}
		return this.internalObjectList.get(this.internalListBox.getSelectedIndex());
	}

	/**
	 * Returns the currently selected item.
	 * 
	 * @return Currently selected item or null if nothing is selected.
	 */
	public T getSelectedItemOrNull() {
		if (this.internalListBox.getSelectedIndex() == -1) {
			return null;
		}
		return this.internalObjectList.get(this.internalListBox.getSelectedIndex());
	}

	@Override
	public void setStyleName(final String style, final boolean add) {
		this.internalListBox.setStyleName(style, add);
	}

	@Override
	public void setStylePrimaryName(final String style) {
		this.internalListBox.setStylePrimaryName(style);
	}

	/**
	 * Clears the items of the list box.
	 */
	public void clear() {
		this.internalObjectList.clear();
		this.internalListBox.clear();
	}

	/**
	 * Sets count of visible items.
	 * 
	 * @param visibleItems
	 *            count of visible items
	 */
	public void setVisibleItemCount(final int visibleItems) {
		this.internalListBox.setVisibleItemCount(visibleItems);
	}

	@Override
	public int getTabIndex() {
		return this.internalListBox.getTabIndex();
	}

	@Override
	public void setAccessKey(final char key) {
		this.internalListBox.setAccessKey(key);
	}

	@Override
	public void setFocus(final boolean focused) {
		this.internalListBox.setFocus(focused);
	}

	@Override
	public void setTabIndex(final int index) {
		this.internalListBox.setTabIndex(index);
	}

	@Override
	public HandlerRegistration addChangeHandler(final ChangeHandler handler) {
		return this.internalListBox.addChangeHandler(handler);
	}

	/**
	 * Returns the list of displayed objects.
	 * 
	 * @return list of displayed object
	 */
	public List<T> getList() {
		return this.internalObjectList;
	}

	@Override
	public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<T> handler) {
		return this.addHandler(handler, ValueChangeEvent.getType());
	}

	@Override
	public T getValue() {
		final int index = this.internalListBox.getSelectedIndex();
		if (index == -1) {
			return null;
		} else {
			return this.internalObjectList.get(index);
		}
	}

	@Override
	public void setValue(final T value) {
		final int index = this.internalObjectList.indexOf(value);
		try {
			this.internalListBox.setItemSelected(index, true);
		} catch (final IndexOutOfBoundsException e) {
			System.out.println("");
		}
	}

	@Override
	public void setValue(final T value, final boolean fireEvents) {
		this.setValue(value);
		if (fireEvents) {
			ValueChangeEvent.fire(this, value);
		}
	}

}
