package fhdw.ipscrum.client.utils;

import java.util.List;

import com.google.gwt.user.client.ui.TreeItem;

import fhdw.ipscrum.shared.model.System;

public class SystemTreeItem extends TreeItem {

	public SystemTreeItem(final System system) {
		this.setText(system.getName());
		this.addChildren(system.getSystems());
	}

	private void addChildren(final List<System> systems) {
		for (final System current : systems) {
			this.addItem(new SystemTreeItem(current));
		}
	}
}
