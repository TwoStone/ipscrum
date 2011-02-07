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
	
@Override
	public boolean equals(Object obj) {
		// TODO Implement method equals in class Feature!
		return super.equals(obj);
	}

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
	

}
