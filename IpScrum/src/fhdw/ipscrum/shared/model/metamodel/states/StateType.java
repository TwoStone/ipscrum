package fhdw.ipscrum.shared.model.metamodel.states;

import java.util.Iterator;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;

/**
 * Represents the StateType.
 */
public class StateType extends IdentifiableObject {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 5718056036164183486L;

	/**
	 * Represents the name of the stateType.
	 */
	private String name;

	/**
	 * Represents the description of the stateType.
	 */
	private String description;

	/**
	 * Constructor of the stateType.
	 * 
	 * @param model
	 *            : it is inserted in the model
	 * @param name
	 *            of the stateType
	 * @param description
	 *            of the stateType
	 * @throws DoubleDefinitionException
	 *             if the stateType with the same parameters already exists
	 */
	public StateType(final Model model, final String name, final String description) throws DoubleDefinitionException {
		super(model);
		this.checkStateTypeDoublets(name);
		this.name = name;
		this.description = description;
		this.putToObjectStore();
	}

	/**
	 * Checks if there are doublets of stateTypes.
	 * 
	 * @param nameToCheck
	 *            of the stateType
	 * @throws DoubleDefinitionException
	 *             if the stateType already exists
	 */
	private void checkStateTypeDoublets(final String nameToCheck) throws DoubleDefinitionException {
		final Iterator<StateType> stateTypesIterator = this.getModel().getTypeManager().getStateTypes().iterator();
		while (stateTypesIterator.hasNext()) {
			final StateType current = stateTypesIterator.next();
			if (current.getName().equals(nameToCheck)) {
				throw new DoubleDefinitionException("Fehler: Ein Zustandstyp mit diesem Namen existiert bereits!");
			}
		}
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected StateType() {
		super();
	}

	/**
	 * Getter of the name of the stateType.
	 * 
	 * @return the name of the stateType
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter of the description of the stateType.
	 * 
	 * @return the description of the stateType
	 */
	public String getDescription() {
		return this.description;
	}
}
