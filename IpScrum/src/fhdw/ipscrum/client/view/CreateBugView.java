package fhdw.ipscrum.client.view;

import java.util.List;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.view.interfaces.ICreateBugView;
import fhdw.ipscrum.client.view.widgets.BugWidget;
import fhdw.ipscrum.shared.exceptions.NothingSelectedException;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.interfaces.IRelease;

public class CreateBugView extends PBIView implements ICreateBugView {
	private final BugWidget bug;

	public CreateBugView() {
		super();
		this.getBtnAbort().setVisible(false);
		bug = new BugWidget(getGrid(), getVerticalPanel(), this);
	}

	public BugWidget getBugWidget() {
		return bug;
	}

	@Override
	public IRelease getSelectedVersion() throws NothingSelectedException {
		return bug.getSelectedVersion();
	}

	@Override
	public void setVersion(List<IRelease> releases, IRelease selected) {
		bug.setVersion(releases, selected);
	}

	@Override
	public IEvent<EventArgs> getChangeSystems() {
		return bug.getChangeSystems();
	}

	@Override
	public void setSystems(List<System> systems) {
		bug.setSystems(systems);
	}
}
