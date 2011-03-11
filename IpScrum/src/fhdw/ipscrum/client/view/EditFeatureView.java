package fhdw.ipscrum.client.view;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.view.interfaces.IEditFeatureView;
import fhdw.ipscrum.client.view.widgets.EditPBIWidget;
import fhdw.ipscrum.shared.model.Effort;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IProductBacklogItemState;

public class EditFeatureView extends PBIView implements IEditFeatureView {
	private final EditPBIWidget editPBI;

	public EditFeatureView() {
		super();
		editPBI = new EditPBIWidget(getGrid(), this);
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

	// @Override
	// public IEvent<EventArgs> getChangeSystems() {
	//
	// return editPBI.getc;
	// }
}
