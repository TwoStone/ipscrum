package fhdw.ipscrum.shared.model.interfaces;

import java.util.List;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.ManyToOne;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.Systemgroup;
import fhdw.ipscrum.shared.model.visitor.HasChildVisitor;

public interface IHasChildren extends BDACompare {

	/**
	 * DO NOT USE! Adds the child. INSTEAD USE: Constructor of {@link System}
	 * 
	 * @param child
	 * @throws DoubleDefinitionException
	 */
	void addChild(System child) throws DoubleDefinitionException;

	Vector<System> getChilds();

	void accept(HasChildVisitor visitor);

	OneToMany<ManyToOne, IHasChildren> getToSystemAssoc();

	/**
	 * Returns all systemgroups in the hierarchy. TODO PW: Hinterfragen warum
	 * benötigt!!!
	 * 
	 * @return
	 */
	List<Systemgroup> getGroups();
}
