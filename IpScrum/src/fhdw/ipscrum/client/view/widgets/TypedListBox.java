package fhdw.ipscrum.client.view.widgets;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;

import fhdw.ipscrum.shared.exceptions.NothingSelectedException;

/**
 * Widget to show items of one type in a list box.
 * 
 * @author n.w.
 * 
 * @param <T>
 *            Type of the items to be added.
 */
public class TypedListBox<T> extends Composite {
	/**
	 * Interface for defining how an object is rendered to a string.
	 * 
	 * @author n.w.
	 * 
	 * @param <T>
	 *            Type of object that should be rendered.
	 */
	public static interface TypeRendere<T> {
		String render(T object);
	}

	private final ListBox internalListBox;

	private final List<T> internalObjectList;

	private final TypeRendere<T> renderer;

	public TypedListBox(final TypeRendere<T> renderer) {
		this.renderer = renderer;
		this.internalListBox = new ListBox();
		this.internalObjectList = new ArrayList<T>();

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
		return this.internalObjectList.get(this.internalListBox
				.getSelectedIndex());
	}

	@Override
	public void setStyleName(final String style, final boolean add) {
		this.internalListBox.setStyleName(style, add);
	}

	@Override
	public void setStylePrimaryName(final String style) {
		this.internalListBox.setStylePrimaryName(style);
	}

}