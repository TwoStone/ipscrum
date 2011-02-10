package fhdw.ipscrum.shared.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
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
	private List<Relation> relations;
	private List<Hint> hints;
	private List<AcceptanceCriterion> acceptanceCriteria;
	private IPerson editor;
	private String description;
/* End of attribute section*/
	
	
	
/* Start of constructor section */
	public Feature(){	
		//TODO: Define the way of initializing a Feature
	}
	
	public Feature(String name, String description, Integer manDayCosts, ProductBacklog backlog) {
		super(name, manDayCosts, backlog);
		this.setDescription(description);
		this.state = new Open(this);
		this.relations = new ArrayList<Relation>();
		this.acceptanceCriteria = new ArrayList<AcceptanceCriterion>();
		this.hints = new ArrayList<Hint>();
	}
/* End of constructor section */
	
	
	
/* Start of business logic section */
	/**
	 * this method adds a hint to a feature
	 * @param hint 
	 * @throws ForbiddenStateException 
	 *  
	 */
	public void addHint(Hint hint) throws DoubleDefinitionException, ForbiddenStateException{
		this.state.addHint(hint);
	}
	/**
	 * this method adds a relation to a feature
	 * @param relation
	 * @throws ForbiddenStateException 
	 */
	public void addRelation(Relation relation) throws DoubleDefinitionException, ForbiddenStateException{
		this.state.addRelation(relation);
	}
	/**
	 * this method adds an acceptance criterion to a feature
	 * @param acceptanceCriterion
	 * @throws ForbiddenStateException 
	 */
	public void addAcceptanceCriterion(AcceptanceCriterion acceptanceCriterion) throws DoubleDefinitionException, ForbiddenStateException{
		this.state.addAcceptanceCriterion(acceptanceCriterion);
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
	 * @throws ForbiddenStateException 
	 */
	public void close() throws ForbiddenStateException{
		this.state.close();
	}
	
	void doClose(){
		this.setState(new Closed(this));
	}
	void doAddAcceptanceCriterion(AcceptanceCriterion acceptanceCriterion) throws DoubleDefinitionException{
		Iterator<AcceptanceCriterion> iterator = this.getAcceptanceCriteria().iterator();
		while (iterator.hasNext()){
			AcceptanceCriterion current = iterator.next();
			if (current.equals(acceptanceCriterion)){
				throw new DoubleDefinitionException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
		this.getAcceptanceCriteria().add(acceptanceCriterion);
	}
	void doAddRelation(Relation relation) throws DoubleDefinitionException{
		Iterator<Relation> iterator = this.getRelations().iterator();
		while (iterator.hasNext()){
			Relation current = iterator.next();
			if (current.equals(relation)){
				throw new DoubleDefinitionException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
		this.getRelations().add(relation);
	}
	void doAddHint(Hint hint) throws DoubleDefinitionException{
		Iterator<Hint> iterator = this.getHints().iterator();
		while (iterator.hasNext()){
			Hint current = iterator.next();
			if (current.equals(hint)){
				throw new DoubleDefinitionException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
		this.getHints().add(hint);
	}
/* End of business logic section */

/* Start of getter / setter section */
	public IFeatureState getState() {
		return state;
	}

	public void setState(IFeatureState state) {
		this.state = state;
	}

	public List<Relation> getRelations() {
		return relations;
	}

	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}

	public List<Hint> getHints() {
		return hints;
	}

	public void setHints(List<Hint> hints) {
		this.hints = hints;
	}

	public List<AcceptanceCriterion> getAcceptanceCriteria() {
		return acceptanceCriteria;
	}

	public void setAcceptanceCriteria(
			List<AcceptanceCriterion> acceptanceCriteria) {
		this.acceptanceCriteria = acceptanceCriteria;
	}

	public IPerson getEditor() {
		return editor;
	}

	public void setEditor(IPerson editor) {
		this.editor = editor;
	}
/* End of getter / setter section */
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((acceptanceCriteria == null) ? 0 : acceptanceCriteria
						.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
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
	if (description == null) {
		if (other.description != null)
			return false;
	} else if (!description.equals(other.description))
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
