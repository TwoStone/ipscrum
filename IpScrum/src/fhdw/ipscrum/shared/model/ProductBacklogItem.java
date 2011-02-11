package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * Represents the abstract Root Class for a ProductBacklogItem.
 */
public abstract class ProductBacklogItem extends Observable{

	private String name;
	private Integer manDayCosts;
	private final ProductBacklog backlog;
	private IPerson lastEditor;
	private ISprint sprint;
	
	/**
	 * @param name
	 * Name of the PBI.
	 * @param backlog
	 * Backlog of the PBI.
	 * @throws NoValidValueException
	 * If the name for the PBI is not valid.
	 * Valid names are not null and have not only
	 * whitespace characters.
	 */
	public ProductBacklogItem(String name, ProductBacklog backlog) throws NoValidValueException, ConsistencyException{
		super();
		this.setName(name);
		backlog.addItem(this);
		this.backlog = backlog;
		this.setManDayCosts(0);
	}
	
	public ProductBacklog getBacklog() {
		return backlog;
	}
	
	public final String getName() {
		return name;
	}

	/**
	 * Changes the Name of the PBI.
	 * @param name
	 * New Name of the PBI.
	 * @throws NoValidValueException
	 * If the name for the PBI is not valid.
	 * Valid names are not null and have not only
	 * whitespace characters.
	 */
	public final void setName(String name) throws NoValidValueException{
		if(name!=null && name.trim().length()>0){
			this.name = name;
			this.notifyObservers();
		}else{
			//TODO Textkonstante bauen
			throw new NoValidValueException("Es muss eine Bezeichnung angegeben werden!");
		}
	}

	public final Integer getManDayCosts() {
		return manDayCosts;
	}

	/**
	 * 
	 * @param manDayCosts
	 * Values smaller 0 are not allow.
	 * 0 means not defined.
	 * @throws NoValidValueException
	 * If the value is smaller 0!
	 */
	public final void setManDayCosts(Integer manDayCosts) throws NoValidValueException{
		if(manDayCosts != null && manDayCosts >= 0){
			this.manDayCosts = manDayCosts;
			this.notifyObservers();
		}else{
			//TODO Textkonstante bauen
			throw new NoValidValueException("Es muss eine gültige Aufwandsschätzung in Manntagen (>=0) angegeben werden!");
		}
	}
	
	public IPerson getLastEditor() {
		return lastEditor;
	}
	
	public void setLastEditor(IPerson lastEditor) {
		this.lastEditor = lastEditor;
		this.notifyObservers();
	}
	
	public ISprint getSprint() {
		return sprint;
	}
	
	/**
	 * TODO Kommentar schreiben
	 * @param sprint
	 * Null Value Means, that the PBI will be removed from the Sprint!
	 * @throws NoSprintDefinedException, ConsistencyException
	 */
	public void setSprint(ISprint sprint) throws NoSprintDefinedException, ConsistencyException {
		if(sprint!=null){
			if(this.backlog.getProject().isSprintDefined(sprint)){
				sprint.addPBI(this);
				this.sprint = sprint;
				this.notifyObservers();
			}else{
				//TODO Textkonstante bauen
				throw new NoSprintDefinedException("Es können nur bereits vorhandene Sprints zugeordnet werden!");
			}
		}else{
			if(this.sprint!=null){
				this.sprint.removePBI(this);
				this.sprint=null;
			}
		}
	}

	@Override
	public String toString() {
		return "ProductBacklogItem [aufwand=" + manDayCosts + ", name=" + name
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((backlog == null) ? 0 : backlog.hashCode());
		result = prime * result
				+ ((lastEditor == null) ? 0 : lastEditor.hashCode());
		result = prime * result
				+ ((manDayCosts == null) ? 0 : manDayCosts.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sprint == null) ? 0 : sprint.hashCode());
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
		ProductBacklogItem other = (ProductBacklogItem) obj;
		if (backlog == null) {
			if (other.backlog != null)
				return false;
		} else if (!backlog.equals(other.backlog))
			return false;
		if (lastEditor == null) {
			if (other.lastEditor != null)
				return false;
		} else if (!lastEditor.equals(other.lastEditor))
			return false;
		if (manDayCosts == null) {
			if (other.manDayCosts != null)
				return false;
		} else if (!manDayCosts.equals(other.manDayCosts))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sprint == null) {
			if (other.sprint != null)
				return false;
		} else if (!sprint.equals(other.sprint))
			return false;
		return true;
	}

	
}
