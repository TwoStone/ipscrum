/**
 * 
 */
package fhdw.ipscrum.shared.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IBugState;
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

	private Collection<System> systems;

	@SuppressWarnings("unused")
	private Bug() {
	}

	public Bug(final String name, final String description,
			final ProductBacklog backlog) throws NoValidValueException,
			DoubleDefinitionException, ConsistencyException,
			ForbiddenStateException {
		super(name, description, backlog);
		this.systems = new ArrayList<System>();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.shared.model.ProductBacklogItem#accept(fhdw.ipscrum.shared
	 * .model.visitor.IProductBacklogItemVisitor)
	 */
	@Override
	public void accept(final IProductBacklogItemVisitor visitor) {
		visitor.handleBug(this);
	}

	public void addSystem(final System system) throws ForbiddenStateException {
		this.getState().addSystem(system);
	}

	public void doAddSystem(final System system) {
		this.systems.add(system);
	}

	@Override
	protected void doClose() {
		this.state = new BugClosedState();
	}

	public void doSetRelease(final IRelease release) {
		this.release = release;
	}

	public IRelease getRelease() {
		return this.release;
	}

	@Override
	public IBugState getState() {
		return this.state;
	}

	public Collection<System> getSystems() {
		return Collections.unmodifiableCollection(this.systems);
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

	public void setRelease(final IRelease release)
			throws ForbiddenStateException {
		this.state.setRelease(release);
	}

}
