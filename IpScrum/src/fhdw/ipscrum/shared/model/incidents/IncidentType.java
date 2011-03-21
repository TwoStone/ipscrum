package fhdw.ipscrum.shared.model.incidents;

import java.io.Serializable;
import java.util.Iterator;

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
	
	public  void setGlobal(boolean isGlobal){
		this.setGlobal(isGlobal);
	}
	
	public boolean isGlobal(){
		return this.isGlobal;
	}
	
	public abstract Iterator<IPerson> getParticipants();
}
