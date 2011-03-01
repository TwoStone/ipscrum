package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.interfaces.IProductBacklogItemState;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

/**
 * A feature is a {@link ProductBacklogItem}, which represents a user story. A
 * feature may contain relationships to other features. Furthermore, acceptance
 * criteria and hints can be associated. A feature can be editable in the state
 * "open" and is read-only in the state "closed".
 */
public class Feature extends ProductBacklogItem {

	private static final long serialVersionUID = 5167167800573928995L;
	private IProductBacklogItemState state;

	@SuppressWarnings("unused")
	private Feature() {
	}

	public Feature(final String name, final String description,
			final ProductBacklog backlog) throws UserException {
		super(name, description, backlog);
	}

	@Override
	public void accept(final IProductBacklogItemVisitor visitor) {
		visitor.handleFeature(this);
	}

	@Override
	protected void doClose() {
		this.state = new FeatureClosedState();
		this.notifyObservers();
	}

	@Override
	public IProductBacklogItemState getState() {
		return this.state;
	}

	@Override
	protected void initializeState() {
		this.state = new FeatureOpenState(this);
	}

}
