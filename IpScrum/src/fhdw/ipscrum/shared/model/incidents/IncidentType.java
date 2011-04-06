package fhdw.ipscrum.shared.model.incidents;

import java.io.Serializable;

/**
 * This class represents the abstract node for specific types of incidents
 * (Knowledge Layer). Users can create specific Incident-Types identified by
 * the name.
 */
public class IncidentType implements Serializable {
	private static final long serialVersionUID = -9075240586079380217L;

	/**
	 * the name of the incidentType and identifier
	 */
	private String name;
	
	public IncidentType(String name){
		this.setName(name);		
	}
	@SuppressWarnings("unused")
	private IncidentType(){}
	
	private void setName(String name){
		this.name=name;
	}

	public final String getName(){
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
