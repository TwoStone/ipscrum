package fhdw.ipscrum.shared.model;
/**
 * An acceptance criterion is a textual description of a condition,
 * under that a product owner accepts a implemented feature.
 */
public class AcceptanceCriterion {
	private String content;
	
/* Start of constructor section */
	public AcceptanceCriterion(){
	}
	public AcceptanceCriterion(String content){
		this.content = content;
	}
/* End of constructor section */

	
/* Start of getter / setter section */
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
/* End of getter / setter section */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
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
		AcceptanceCriterion other = (AcceptanceCriterion) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		return true;
	}

}
