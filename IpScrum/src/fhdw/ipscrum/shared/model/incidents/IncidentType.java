package fhdw.ipscrum.shared.model.incidents;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

/**
 * This class represents the abstract node for specific types of incidents
 */
public abstract class IncidentType implements Serializable {
	private static final long serialVersionUID = -9075240586079380217L;
	/**
	 * logical value, which declares, if the incident has global validity
	 */
	private boolean isGlobal;
	/**
	 * the name of the incident
	 */
	private String name;
	/**
	 * further detail description
	 */
	private String description;
	protected IncidentType(String name, String description){
		this.name = name;
		this.description = description;
	}
	@SuppressWarnings("unused")
	private IncidentType(){}
	protected void setGlobal(boolean isGlobal){
		this.isGlobal = isGlobal;
	}
	
	protected boolean isGlobal(){
		return this.isGlobal;
	}
	
	protected abstract Iterator<IPerson> getParticipantsIterator();
	protected abstract Vector<IPerson> getParticipants();
	protected abstract void addParticipant(IPerson participant) throws DoubleDefinitionException;
	protected abstract void removeParticipant(IPerson participant);
	protected abstract void setName(String name);
	protected abstract void setDescription(String description);
	protected String getName(){
		return this.name;
	}
	protected String getDescription(){
		return this.description;
	}
}
