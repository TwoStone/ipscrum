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
	
	protected IncidentType(String name){
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

}
