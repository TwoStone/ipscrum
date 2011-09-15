package fhdw.ipscrum.client.utils;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.ui.UIObject;

/**
 * Utility for grouping ui objects to modify their visibility properties at once.
 * 
 * 
 */
public class ViewGroup {

	/**
	 * the list of grouped objects.
	 */
	private final List<UIObject> uiObjects;

	/**
	 * Creates a new group.
	 */
	public ViewGroup() {
		this.uiObjects = new ArrayList<UIObject>();
	}

	/**
	 * Adds an element to the group.
	 * 
	 * @param uiObject
	 *            the element
	 */
	public void add(final UIObject uiObject) {
		this.uiObjects.add(uiObject);
	}

	/**
	 * Sets the visibility of a group members.
	 * 
	 * @param visible
	 *            Visibility of the elements
	 */
	public void setVisible(final boolean visible) {
		for (final UIObject object : this.uiObjects) {
			object.setVisible(true);
		}
	}
}
