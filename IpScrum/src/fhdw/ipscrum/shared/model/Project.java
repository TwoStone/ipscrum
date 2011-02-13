package fhdw.ipscrum.shared.model;

import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.BDAManyToMany;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * Represents a Scrum Project.
 */
public class Project extends Observable implements BDACompare{

	private String name;
	private final ProductBacklog backlog;
	private Vector<ISprint> sprints;//Not-bidirectional

	private final ToReleaseAssoc releaseAssoc;
	
	public class ToReleaseAssoc extends BDAManyToMany<Release.ToProjectAssoc, Project>{
		public ToReleaseAssoc(Project element) {
			super(element);
		}
	}
	
	protected ToReleaseAssoc getReleaseAssoc() {
		return releaseAssoc;
	}
	
	/**
	 * @param name
	 * Name of the Project
	 * @throws NoValidValueException
	 * If the name for the Project is not valid.
	 * Valid names are not null and have not only
	 * whitespace characters.
	 */
	public Project(String name) throws NoValidValueException, ConsistencyException{
		super();
		this.setName(name);
		this.releaseAssoc = new ToReleaseAssoc(this);
		this.backlog = new ProductBacklog(this);
	}
	
	public Vector<IRelease> getReleasePlan() {
		Vector<IRelease> ret = new Vector<IRelease>();
		for(Release.ToProjectAssoc current : this.getReleaseAssoc().getAssociations()){
			ret.add(current.getElement());
		}
		return ret;
	}

	public String getName() {
		return name;
	}

	/**
	 * Set a new Project name!
	 * @param name
	 * Name of the Project
	 * @throws NoValidValueException
	 * If the name for the Project is not valid.
	 * Valid names are not null and have not only
	 * whitespace characters.
	 */
	public void setName(String name) throws NoValidValueException {
		if(name!=null && name.trim().length()>0){
			this.name = name;
			this.notifyObservers();
		}else{
			//TODO Textkonstante bauen
			throw new NoValidValueException("Es muss ein Projektname angegeben werden!");
		}
	}
	
	public ProductBacklog getBacklog() {
		return backlog;
	}

	/**
	 * Check if the sprint is defined within the project!
	 * Throws an SprintNotDefinedException if not!
	 * @param sprint
	 * Sprint for check!
	 */
	public void isSprintDefined(ISprint sprint) throws NoSprintDefinedException{
		Iterator<ISprint> i = this.getSprints().iterator();
		while(i.hasNext()){
			if(i.next().equals(sprint)){
				return;
			}
		}
		throw new NoSprintDefinedException("Der angegebene Sprint ist nicht im Projekt definiert!");
	}
	
	

	/**
	 * Returns the defined Sprints for this project.
	 * <br />
	 * <b>Attention</b><br />
	 * For adding and removing a sprint use the functionalities
	 * of the Project, else we cannot guarantee the consistency!
	 */
	public Vector<ISprint> getSprints() {
		if(this.sprints==null){
			this.sprints = new Vector<ISprint>();
		}
		return sprints;
	}
	
	/**
	 * TODO Kommentar
	 * @param sprint
	 */
	public void addSprint(ISprint sprint){
		this.getSprints().add(sprint);
		this.notifyObservers();
	}
	
	public void isReleaseDoubleDefined(String version, Date releaseDate) throws DoubleDefinitionException{
		for(IRelease current : this.getReleasePlan()){
			if(current.getVersion().equals(version) && current.getReleaseDate().equals(releaseDate)){
				//TODO Textkonstante bauen!
				throw new DoubleDefinitionException("Release existiert bereits und kann nicht hinzugef�gt werden!");
			}
		}
	}
	
//	public void removeSprint(ISprint sprint){
//		this.getSprints().remove(sprint);
//		this.notifyObservers();
//	}
	
	public void addRelease(IRelease release){
		this.getReleaseAssoc().add(release.getProjectAssoc());
		this.notifyObservers();
	}
	
//	public void removeRelease(IRelease release){
//		this.getReleaseAssoc().remove(release.getProjectAssoc());
//	}
	
	/**
	 * Returns the number of defined Sprints within the
	 * project!
	 */
	public Integer countSprints(){
		return this.getSprints().size();
	}
	
	@Override
	public String toString() {
		return "Project [name=" + name + "]";
	}

	@Override
	public int indirectHashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((backlog == null) ? 0 : backlog.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sprints == null) ? 0 : sprints.hashCode());
		return result;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((backlog == null) ? 0 : backlog.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((releaseAssoc == null) ? 0 : releaseAssoc.hashCode());
		result = prime * result + ((sprints == null) ? 0 : sprints.hashCode());
		return result;
	}

	@Override
	public boolean indirectEquals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!super.equals(obj))
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Project other = (Project) obj;
//		if (backlog == null) {
//			if (other.backlog != null)
//				return false;
//		} else if (!backlog.equals(other.backlog))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (sprints == null) {
//			if (other.sprints != null)
//				return false;
//		} else if (!sprints.equals(other.sprints))
//			return false;
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!super.equals(obj))
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Project other = (Project) obj;
//		if (backlog == null) {
//			if (other.backlog != null)
//				return false;
//		} else if (!backlog.equals(other.backlog))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (releaseAssoc == null) {
//			if (other.releaseAssoc != null)
//				return false;
//		} else if (!releaseAssoc.equals(other.releaseAssoc))
//			return false;
//		if (sprints == null) {
//			if (other.sprints != null)
//				return false;
//		} else if (!sprints.equals(other.sprints))
//			return false;
		return true;
	}
}
