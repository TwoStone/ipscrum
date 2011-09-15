package fhdw.ipscrum.shared.model.nonMeta.incidents;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;

/**
 * This class represents the abstract node for specific types of incidents (Knowledge
 * Layer). Users can create specific Incident-Types identified by the name.
 */
public class IncidentType extends IdentifiableObject implements IsSerializable {
	/**
	 * represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -9075240586079380217L;

	/**
	 * the name of the incidentType and identifier.
	 */
	private String name;

	/**
	 * constructor of the IncidentType.
	 * 
	 * @param model
	 *            : it is inserted in the model
	 * @param name
	 *            of the incident type
	 * @throws DoubleDefinitionException
	 *             if a incident type with the same name already exists
	 */
	public IncidentType(final Model model, final String name)
			throws DoubleDefinitionException {
		super(model);
		this.getModel().getConsistencyManager().checkForDoubleIncident(name);
		this.setName(name);
		this.putToObjectStore();
	}

	/**
	 * constructor without parameters. needed for serialization.
	 */
	@SuppressWarnings("unused")
	private IncidentType() {
	}

	/**
	 * sets the name of the incident type.
	 * 
	 * @param name
	 *            is the new name of the type
	 */
	private void setName(final String name) {
		this.name = name;
		this.changed();
	}

	/**
	 * getter of the name of the incident type.
	 * 
	 * @return the current name
	 */
	public final String getName() {
		return this.name;
	}
}
