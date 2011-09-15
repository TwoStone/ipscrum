package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.nonMeta.Rootsystem;

/**
 * Represents the Visitor needed for handling the Systems.
 */
public interface ISystemVisitor {

	/**
	 * Needed for handling rootSystems.
	 * 
	 * @param rootsystem
	 *            to handle
	 */
	void handleRoot(Rootsystem rootsystem);

	/**
	 * Needed for handling Systems.
	 * 
	 * @param system
	 *            to handle
	 */
	void handleSystem(fhdw.ipscrum.shared.model.nonMeta.System system);
}
