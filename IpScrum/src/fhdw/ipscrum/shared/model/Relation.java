package fhdw.ipscrum.shared.model;

/**
 * Objects of this class describe relations to one 
 * target object. The relation has one type, which can be customized by a
 * user of the ticket system.
 */
public class Relation {
	
	private RelationType type;
	private Feature target;

	public Relation(){
	}
}
