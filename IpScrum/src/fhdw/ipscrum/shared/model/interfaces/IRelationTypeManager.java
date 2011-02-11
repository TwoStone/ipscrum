package fhdw.ipscrum.shared.model.interfaces;

import java.util.Collection;

import fhdw.ipscrum.shared.model.RelationType;

/**
 * Interface for persisting and accessing {@link RelationType} objects.
 * 
 */
public interface IRelationTypeManager {

	/**
	 * Adds a new type for relations.
	 * 
	 * @param type
	 */
	void addRelationType(final RelationType type);

	/**
	 * Returns all persisted {@link RelationType} objects.
	 * 
	 * @return
	 */
	Collection<RelationType> getRelationTypes();
}
