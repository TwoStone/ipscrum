package fhdw.ipscrum.client.view.interfaces;

import java.util.List;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.shared.model.System;

public interface ISystemManagementView extends IView {

	static class NewSystemEventArgs extends EventArgs {

		public final String Name;
		public final System Parent;

		public NewSystemEventArgs(final String name, final System parent) {
			super();
			Name = name;
			Parent = parent;
		}

	}

	IEvent<NewSystemEventArgs> getCreateSystemEvent();

	void setRootSystemGroup(List<System> group);

	void setPossibleParents(List<System> parents);
}
