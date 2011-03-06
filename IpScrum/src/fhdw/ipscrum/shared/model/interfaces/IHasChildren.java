package fhdw.ipscrum.shared.model.interfaces;

import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.visitor.HasChildVisitor;

public interface IHasChildren extends BDACompare {

	Vector<System> getSystems();

	void accept(HasChildVisitor visitor);

	OneToMany<ManyToOne, IHasChildren> getToSystemAssoc();

	abstract IHasChildren getRoot();

	public abstract boolean contains(System system);

	public abstract boolean containsAction(System system);
}
