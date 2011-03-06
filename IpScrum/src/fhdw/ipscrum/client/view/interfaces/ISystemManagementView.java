package fhdw.ipscrum.client.view.interfaces;

import java.util.List;
import java.util.Vector;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.shared.model.System;

public interface ISystemManagementView extends IView {

	static class NewSystemEventArgs extends EventArgs {

		public final String Name;
		public final System Parent;
		public final Boolean AsGroup;

		public NewSystemEventArgs(final String name, final System parent,
				final Boolean asGroup) {
			super();
			Name = name;
			Parent = parent;
			AsGroup = asGroup;
		}

	}

	IEvent<NewSystemEventArgs> getCreateSystemEvent();

	void setRootSystemGroup(List<System> group);

	void setPossibleParents(Vector<System> parents);
}
