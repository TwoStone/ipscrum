package fhdw.ipscrum.shared.model;
/**
 * An acceptance criterion is a textual description of a condition,
 * under that a product owner accepts a implemented feature.
 */
public class AcceptanceCriterion {
	private String content;
	
	public AcceptanceCriterion(){
	}
	public AcceptanceCriterion(String content){
		this.content = content;
	}

}
