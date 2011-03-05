package fhdw.ipscrum.shared.model;

import java.util.Collections;
import java.util.List;

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

	private ConcreteSystem() {
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

	@Override
	public List<Systemgroup> getGroups() {
		return Collections.emptyList();
	}

}
