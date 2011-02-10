package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.observer.Observable;

public abstract class ProductBacklogItem extends Observable{

	private String name;
	private Integer manDayCosts;
	private final ProductBacklog backlog;
	private IRelease release;
	private IPerson lastEditor;
	private ISprint sprint;
	
	public ProductBacklogItem(String name, ProductBacklog backlog) {
		super();
		this.name = name;
		this.backlog = backlog;
	}
	
	public void setRelease(IRelease release) {
		this.release = release;
	}
	
	public IRelease getRelease() {
		return release;
	}
	
	public ProductBacklog getBacklog() {
		return backlog;
	}
	
	public final String getName() {
		return name;
	}

	public final void setName(String name) throws NoValidValueException{
		if(name!=null && name.trim().length()>0){
			this.name = name;
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
		if(manDayCosts != null && manDayCosts > 0){
			this.manDayCosts = manDayCosts;
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
	}
	
	public ISprint getSprint() {
		return sprint;
	}
	
	public void setSprint(ISprint sprint) throws NoSprintDefinedException {
		if(this.backlog.getProject().isSprintDefined(sprint)){
				this.sprint = sprint;
		}else{
			//TODO Textkonstante bauen
			throw new NoSprintDefinedException("Es können nur bereits vorhandene Sprints zugeordnet werden!");
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
		result = prime * result + ((release == null) ? 0 : release.hashCode());
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
		if (release == null) {
			if (other.release != null)
				return false;
		} else if (!release.equals(other.release))
			return false;
		if (sprint == null) {
			if (other.sprint != null)
				return false;
		} else if (!sprint.equals(other.sprint))
			return false;
		return true;
	}
}
