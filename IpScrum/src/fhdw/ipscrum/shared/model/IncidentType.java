package fhdw.ipscrum.shared.model;

import java.io.Serializable;

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
}
