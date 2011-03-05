package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.interfaces.IHasChildren;
import fhdw.ipscrum.shared.model.visitor.ISystemVisitor;

public class ConcreteSystem extends System {

	private static final long serialVersionUID = 6315896002098835977L;

	public ConcreteSystem(final String name, final IHasChildren parent)
			throws DoubleDefinitionException {
		super(name, parent);
		parent.addChild(this);
	}

	@Override
	public void accept(final ISystemVisitor visitor) {
		visitor.handleConcreteSystem(this);
	}

	public boolean contains(final System child) {
		return this.equals(child);
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
