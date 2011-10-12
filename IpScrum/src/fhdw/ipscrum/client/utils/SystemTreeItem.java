package fhdw.ipscrum.client.utils;

import java.util.List;

import com.google.gwt.user.client.ui.TreeItem;

import fhdw.ipscrum.shared.model.nonMeta.System;

/**
 * this class represents a system tree item, needed for the tree on the systemManagementView.
 */
public class SystemTreeItem extends TreeItem {

	/**
	 * constructor of a systemTreeItem.
	 * 
	 * @param system
	 *            is the the system which represents the treeItem
	 */
	public SystemTreeItem(final System system) {
		this.setText(system.getName());
		this.addChildren(system.getSystems());
	}

	/**
	 * Adds the SystemTreeItem to the Tree.
	 * 
	 * @param systems
	 *            is the system to add
	 */
	private void addChildren(final List<System> systems) {
		for (final System current : systems) {
			this.addItem(new SystemTreeItem(current));
		}
	}
}
