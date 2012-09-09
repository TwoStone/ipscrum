package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.nonMeta.Bug;
import fhdw.ipscrum.shared.model.nonMeta.Feature;

/**
 * Represents the Visior needed to handle the different kinds of PBIs.
 */
public interface IProductBacklogItemVisitor {

	/**
	 * Needed for handling the PBI Bug.
	 * 
	 * @param bug
	 *            to handle
	 */
	void handleBug(Bug bug);

	/**
	 * Needed for handling the PBI Feature.
	 * 
	 * @param feature
	 *            to handle
	 */
	void handleFeature(Feature feature);

}
