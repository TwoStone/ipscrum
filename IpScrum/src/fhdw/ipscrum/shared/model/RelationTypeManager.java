package fhdw.ipscrum.shared.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;

/**
 * Class for persisting and accessing {@link RelationType} objects.
 * 
 * @author n.w.
 */
public class RelationTypeManager {

	private final List<RelationType> relationTypes;

	/**
	 * Creates a new instance of {@link RelationTypeManager}.
	 */
	public RelationTypeManager() {
		this.relationTypes = new ArrayList<RelationType>();
	}

	/**
	 * Adds the {@link RelationType} type to the collection.
	 * 
	 * @param type
	 * @throws DoubleDefinitionException
	 *             Is thrown if there is already an equal type in the
	 *             collection.
	 */
	public void addRelationType(final RelationType type)
			throws DoubleDefinitionException {
		if (this.relationTypes.contains(type)) {
			throw new DoubleDefinitionException("Beziehungstyp "
					+ type.getDescription() + " bereits vorhanden.");
		}
		this.relationTypes.add(type);
	}

	/**
	 * Returns all collected {@link RelationType} objects.
	 * 
	 * @return Read-only collection of {@link RelationType}s.
	 */
	public Collection<RelationType> getRelationTypes() {
		return java.util.Collections.unmodifiableCollection(this.relationTypes);
	}
}
