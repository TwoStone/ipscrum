package fhdw.ipscrum.shared.model.interfaces;

import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.System;

public interface IHasChildren extends BDACompare {

	/**
	 * DO NOT USE! Adds the child. INSTEAD USE: Constructor of {@link System}
	 * 
	 * @param child
	 * @throws DoubleDefinitionException
	 */
	void addChild(System child) throws DoubleDefinitionException;

	Vector<System> getChilds();

}
