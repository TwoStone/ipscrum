package fhdw.ipscrum.shared.model.incidents;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

/**
 * This class represents the abstract node for specific types of incidents
 */
public class IncidentType implements Serializable {
	private static final long serialVersionUID = -9075240586079380217L;

	/**
	 * the name of the incident
	 */
	private String name;
	
	public IncidentType(String name){
		this.name = name;
		
	}
	@SuppressWarnings("unused")
	private IncidentType(){}
	
	public void setName(String name){
		this.name=name;
	}

	public String getName(){
		return this.name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IncidentType other = (IncidentType) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
