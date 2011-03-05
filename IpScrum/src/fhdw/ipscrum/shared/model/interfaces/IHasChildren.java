package fhdw.ipscrum.shared.model.interfaces;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.System;

public interface IHasChildren {

	void addChild(System child) throws DoubleDefinitionException;
}
