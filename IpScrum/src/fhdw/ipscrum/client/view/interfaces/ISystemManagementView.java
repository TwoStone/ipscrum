package fhdw.ipscrum.client.view.interfaces;

import java.util.Collection;
import java.util.List;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.Systemgroup;

public interface ISystemManagementView extends IView {

	static class NewSystemEventArgs extends EventArgs {

		public final String Name;
		public final Systemgroup Parent;
		public final Boolean AsGroup;

		public NewSystemEventArgs(String name, Systemgroup parent,
				Boolean asGroup) {
			super();
			Name = name;
			Parent = parent;
			AsGroup = asGroup;
		}

	}

	IEvent<NewSystemEventArgs> getCreateSystemEvent();

	void setRootSystemGroup(Collection<System> group);

	void setPossibleParents(List<Systemgroup> parents);
}
