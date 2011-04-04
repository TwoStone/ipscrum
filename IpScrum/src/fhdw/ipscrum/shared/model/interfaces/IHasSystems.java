package fhdw.ipscrum.shared.model.interfaces;

import java.util.Collection;

import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.System;

public interface IHasSystems {

	/**
	 * Adds a {@link System} to the local list of systems
	 * 
	 * @param system
	 *            {@link System}
	 * @throws UserException
	 */
	public void addSystem(final System system) throws UserException;

	/**
	 * Method getPossibleSystems.
	 * 
	 * @return {@link List<System>}
	 */
	public Collection<System> getSystems();

	public void removeSystem(System system) throws UserException;

}