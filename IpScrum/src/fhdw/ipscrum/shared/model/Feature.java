package fhdw.ipscrum.shared.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IFeatureState;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

/**
 * A feature is a {@link ProductBacklogItem}, which represents a user story.
 * A feature may contain relationships to other features. 
 * Furthermore, acceptance criteria and hints can be associated.
 * A feature can be editable in the state "open" and is read-only in the state "closed".
 */
public class Feature extends /*implements*/ ProductBacklogItem /*IProductBacklogItem*/ {

	private IFeatureState state;
	private List<Relation> relations;
	private List<Hint> hints;
	private List<AcceptanceCriterion> acceptanceCriteria;
	private IPerson editor;
	private String description;
	
	public Feature(String name, String description, ProductBacklog backlog) throws NoValidValueException{
		super(name, backlog);
		this.setDescription(description);
		this.state = new Open(this);
		this.relations = new ArrayList<Relation>();
		this.acceptanceCriteria = new ArrayList<AcceptanceCriterion>();
		this.hints = new ArrayList<Hint>();
	}

	/**
	 * adds a new {@link Hint} to a feature.
	 * @throws ForbiddenStateException will be thrown if the state does not allow this action
	 * @throws DoubleDefinitionException will be thrown if the hint already exists
	 *  
	 */
	public void addHint(Hint hint) throws DoubleDefinitionException, ForbiddenStateException{
		this.state.addHint(hint);
		this.setEditor();
		this.notifyObservers();
	}

	void doAddHint(Hint hint) throws DoubleDefinitionException{
		Iterator<Hint> iterator = this.hints.iterator();
		while (iterator.hasNext()){
			Hint current = iterator.next();
			if (current.equals(hint)){
				throw new DoubleDefinitionException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
		this.hints.add(hint);
	}
	/**
	 * adds a new {@link Relation} to a feature.
	 * @throws ForbiddenStateException will be thrown if the state does not allow this action
	 * @throws DoubleDefinitionException will be thrown if the relation already exists
	 */
	public void addRelation(Relation relation) throws DoubleDefinitionException, ForbiddenStateException{
		this.state.addRelation(relation);
		this.setEditor();
		this.notifyObservers();
	}	

	void doAddRelation(Relation relation) throws DoubleDefinitionException{
		Iterator<Relation> iterator = this.relations.iterator();
		while (iterator.hasNext()){
			Relation current = iterator.next();
			if (current.equals(relation)){
				throw new DoubleDefinitionException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
		this.relations.add(relation);
	}
	/**
	 * adds a new {@link AcceptanceCriterion} to a feature.
	 * @throws ForbiddenStateException will be thrown if the state does not allow this action
	 * @throws DoubleDefinitionException will be thrown if the acceptanceCriterion already exists
	 */
	public void addAcceptanceCriterion(AcceptanceCriterion acceptanceCriterion) throws DoubleDefinitionException, ForbiddenStateException{
		this.state.addAcceptanceCriterion(acceptanceCriterion);
		this.setEditor();
		this.notifyObservers();
	}
	
	void doAddAcceptanceCriterion(AcceptanceCriterion acceptanceCriterion) throws DoubleDefinitionException{
		Iterator<AcceptanceCriterion> iterator = this.acceptanceCriteria.iterator();
		while (iterator.hasNext()){
			AcceptanceCriterion current = iterator.next();
			if (current.equals(acceptanceCriterion)){
				throw new DoubleDefinitionException(
						fhdw.ipscrum.shared.constants.ExceptionConstants.DOUBLE_DEFINITION_ERROR);
			}
		}
		this.acceptanceCriteria.add(acceptanceCriterion);
	}

	/**
	 * counts the number of registred relations to other features.
	 * @return number of relations
	 */
	/* not needed 
	 * public int countRelations(){
	 * return this.getRelations().size();
	 * }
	 */
		
	/**
	 * Sets the state of the feature to "closed".
	 * @throws ForbiddenStateException will be thrown if the feature is already closed
	 */
	public void close() throws ForbiddenStateException{
		this.state.close();
		this.setEditor();
		this.notifyObservers();
	}
	
	void doClose(){
		this.setState(new Closed(this));
	}
	
	public IFeatureState getState() {
		return state;
	}

	protected void setState(IFeatureState state) {
		this.state = state;
	}

	public List<Relation> getRelations() {
		return relations;
	}

	public List<Hint> getHints() {
		return hints;
	}

	public List<AcceptanceCriterion> getAcceptanceCriteria() {
		return acceptanceCriteria;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	protected void setEditor(){
		this.editor = SessionManager.getInstance().getLoginUser();
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
