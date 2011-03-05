package fhdw.ipscrum.client.utils;

import java.util.List;

import com.google.gwt.user.client.ui.TreeItem;

import fhdw.ipscrum.shared.model.ConcreteSystem;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.Systemgroup;
import fhdw.ipscrum.shared.model.visitor.ISystemVisitor;

public class SystemTreeItem extends TreeItem implements ISystemVisitor {

	public SystemTreeItem(System system) {
		this.setText(system.getName());
		system.accept(this);
	}

	@Override
	public void handleConcreteSystem(ConcreteSystem concreteSystem) {

	}

	@Override
	public void handleSystemGroup(Systemgroup systemgroup) {
		final List<System> systems = systemgroup.getChilds();
		for (final System system : systems) {
			this.addItem(new SystemTreeItem(system));
		}
	}
}
