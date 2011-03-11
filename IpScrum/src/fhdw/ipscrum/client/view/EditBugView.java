package fhdw.ipscrum.client.view;

import java.util.List;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.view.interfaces.IEditBugView;
import fhdw.ipscrum.client.view.widgets.BugWidget;
import fhdw.ipscrum.client.view.widgets.EditPBIWidget;
import fhdw.ipscrum.shared.exceptions.NothingSelectedException;
import fhdw.ipscrum.shared.model.Effort;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IProductBacklogItemState;
import fhdw.ipscrum.shared.model.interfaces.IRelease;

public class EditBugView extends PBIView implements IEditBugView {
	private final EditPBIWidget editPBI;
	private final BugWidget bug;

	public BugWidget getBugWidget() {
		return bug;
	}

	public EditBugView() {
		super();
		editPBI = new EditPBIWidget(getGrid(), this);
		bug = new BugWidget(getGrid(), getVerticalPanel(), this);
	}

	@Override
	public Integer getComplexity() {
		return editPBI.getComplexity();
	}

	@Override
	public void setComplexity(final Effort complexity) {
		editPBI.setComplexity(complexity);
	}

	@Override
	public void setLastEditor(final IPerson editor) {
		editPBI.setLastEditor(editor);
	}

	@Override
	public void setState(final IProductBacklogItemState state) {
		editPBI.setState(state);
	}

	@Override
	public IEvent<EventArgs> toggleFeatureState() {
		return editPBI.toggleFeatureState();
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
