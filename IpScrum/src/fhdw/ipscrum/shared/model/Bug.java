/**
 * 
 */
package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.model.interfaces.IBugState;
import fhdw.ipscrum.shared.model.interfaces.IProductBacklogItemState;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

/**
 * @author Niklas
 * 
 */
public class Bug extends ProductBacklogItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3237023915419793623L;

	private IRelease release;

	private IBugState state;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.shared.model.ProductBacklogItem#accept(fhdw.ipscrum.shared
	 * .model.visitor.IProductBacklogItemVisitor)
	 */
	@Override
	public void accept(final IProductBacklogItemVisitor visitor) { //
		visitor.handleBug(this);
	}

	@Override
	protected void doClose() {
		this.state = new BugClosedState();
	}

	public void doSetRelease(IRelease release) {
		this.release = release;
	}

	public IRelease getRelease() {
		return this.release;
	}

	@Override
	public IProductBacklogItemState getState() {
		return this.state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.model.ProductBacklogItem#initialize()
	 */
	@Override
	protected void initializeState() {
		this.state = new BugOpenState(this);
	}

	public void setRelease(IRelease release) throws ForbiddenStateException {
		this.state.setRelease(release);
	}

}
