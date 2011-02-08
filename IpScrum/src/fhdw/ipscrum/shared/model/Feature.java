package fhdw.ipscrum.shared.model;

import java.util.Collection;


import fhdw.ipscrum.shared.model.interfaces.IFeatureState;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

/**
 * A feature is a product backlog item, which represents a user story.
 * A feature may contain relationships to other features. 
 * Furthermore, acceptance criteria and hints can be associated.
 * A feature can be editable in the state "open" and is read-only in the state "closed".
 */
public class Feature extends /*implements*/ ProductBacklogItem /*IProductBacklogItem*/ {
/* Start of attribute section */
	private IFeatureState state;
	private Collection<Relation> relations;
	private Collection<Hint> hints;
	private Collection<AcceptanceCriterion> acceptanceCriteria;
	private IPerson editor;
/* End of attribute section*/
	
	
	
/* Start of constructor section */
	public Feature(){	
		//TODO: Define the way of initializing a Feature
	}
/* End of constructor section */
	

/* Start of business logic section */
	/**
	 * this method adds a hint to a feature
	 * @param hint 
	 *  
	 */
	public void addHint(Hint hint){
		this.getHints().add(hint);
	}
	/**
	 * this method adds a relation to a feature
	 * @param relation
	 */
	public void addRelation(Relation relation){
		this.getRelations().add(relation);
	}
	/**
	 * this method adds an acceptance criterion to a feature
	 * @param acceptanceCriterion
	 */
	public void addAcceptanceCriterion(AcceptanceCriterion acceptanceCriterion){
		this.getAcceptanceCriteria().add(acceptanceCriterion);
	}
	/**
	 * this method counts the number of registred relations to other features.
	 * @return number of relations
	 */
	public int countRelations(){
		return this.getRelations().size();
	}
	/**
	 * Sets the state of the feature to "closed".
	 */
	public void close(){
		this.setState(new Closed());
	}
/* End of business logic section */

/* Start of getter / setter section */
	public IFeatureState getState() {
		return state;
	}

	public void setState(IFeatureState state) {
		this.state = state;
	}

	public Collection<Relation> getRelations() {
		return relations;
	}

	public void setRelations(Collection<Relation> relations) {
		this.relations = relations;
	}

	public Collection<Hint> getHints() {
		return hints;
	}

	public void setHints(Collection<Hint> hints) {
		this.hints = hints;
	}

	public Collection<AcceptanceCriterion> getAcceptanceCriteria() {
		return acceptanceCriteria;
	}

	public void setAcceptanceCriteria(
			Collection<AcceptanceCriterion> acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}

	public IPerson getEditor() {
		return editor;
	}

	public void setEditor(IPerson editor) {
		this.editor = editor;
	}
/* End of getter / setter section */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((acceptanceCriteria == null) ? 0 : acceptanceCriteria
						.hashCode());
		result = prime * result + ((editor == null) ? 0 : editor.hashCode());
		result = prime * result + ((hints == null) ? 0 : hints.hashCode());
		result = prime * result
				+ ((relations == null) ? 0 : relations.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		return result;
	}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (!super.equals(obj))
		return false;
	if (getClass() != obj.getClass())
		return false;
	Feature other = (Feature) obj;
	if (acceptanceCriteria == null) {
		if (other.acceptanceCriteria != null)
			return false;
	} else if (!acceptanceCriteria.equals(other.acceptanceCriteria))
		return false;
	if (editor == null) {
		if (other.editor != null)
			return false;
	} else if (!editor.equals(other.editor))
		return false;
	if (hints == null) {
		if (other.hints != null)
			return false;
	} else if (!hints.equals(other.hints))
		return false;
	if (relations == null) {
		if (other.relations != null)
			return false;
	} else if (!relations.equals(other.relations))
		return false;
	if (state == null) {
		if (other.state != null)
			return false;
	} else if (!state.equals(other.state))
		return false;
	return true;
}

	

}
