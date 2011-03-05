package fhdw.ipscrum.shared.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.interfaces.IHasChildren;
import fhdw.ipscrum.shared.model.visitor.HasChildVisitor;
import fhdw.ipscrum.shared.model.visitor.ISystemVisitor;

public class Systemgroup extends System implements IHasChildren {

	private static final long serialVersionUID = -319562480100341293L;
	private Vector<System> childs;
	private OneToMany<ManyToOne, IHasChildren> toSystemAssoc;

	public Systemgroup(final String name, final IHasChildren parent)
			throws DoubleDefinitionException {
		super(name, parent);
		this.toSystemAssoc = new OneToMany<ManyToOne, IHasChildren>(this);
	}

	private Systemgroup() {

	}

	@Override
	public OneToMany<ManyToOne, IHasChildren> getToSystemAssoc() {
		return this.toSystemAssoc;
	}

	@Override
	public void addChild(final System child) throws DoubleDefinitionException {
		if (this.contains(child)) {
			throw new DoubleDefinitionException(
					fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
		} else {
			this.toSystemAssoc.add(child.getToIHasChildAssoc());
			this.notifyObservers();
		}
	}

	@Override
	public Vector<System> getChilds() {
		final Vector<System> ret = new Vector<System>();
		for (final BDACompare current : this.toSystemAssoc.getAssociations()) {
			ret.add((System) current);
		}
		return ret;
	}

	public boolean contains(final System child) {
		return this.getChilds().contains(child);
	}

	@Override
	public String toString() {
		return "Systemgruppe " + this.getName();
	}

	@Override
	public void accept(final ISystemVisitor visitor) {
		visitor.handleSystemGroup(this);
	}

	@Override
	public void accept(HasChildVisitor visitor) {
		visitor.handleSystemGroup(this);
	}

	@Override
	public List<Systemgroup> getGroups() {
		final List<Systemgroup> result = new ArrayList<Systemgroup>();
		result.add(this);
		for (final System system : this.getChilds()) {
			result.addAll(system.getGroups());
		}
		return result;
	}

}
