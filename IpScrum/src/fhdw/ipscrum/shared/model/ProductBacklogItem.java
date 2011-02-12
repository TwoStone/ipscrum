package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.bdas.BDAManyToMany;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * Represents the abstract Root Class for a ProductBacklogItem.
 */
public abstract class ProductBacklogItem extends Observable {

	private String name;
	private Integer manDayCosts;
	private IPerson lastEditor;
	
	private final ToBacklogAssoc backlogAssoc;
	private final ToSprintAssoc sprintAssoc;
	
	class ToBacklogAssoc extends BDAManyToMany<ProductBacklog.ToPBIAssoc, ProductBacklogItem>{
		public ToBacklogAssoc(ProductBacklogItem element) {
			super(element);
		}
	}
	
	public class ToSprintAssoc extends BDAManyToMany<BDAManyToMany, ProductBacklogItem>{
		public ToSprintAssoc(ProductBacklogItem element) {
			super(element);
		}
	}
	
	protected ToBacklogAssoc getBacklogAssoc() {
		return backlogAssoc;
	}

	protected ToSprintAssoc getSprintAssoc() {
		return sprintAssoc;
	}

	/**
	 * @param name
	 *            Name of the PBI.
	 * @param backlog
	 *            Backlog of the PBI.
	 * @throws NoValidValueException
	 *             If the name for the PBI is not valid. Valid names are not
	 *             null and have not only whitespace characters.
	 */
	public ProductBacklogItem(final String name, final ProductBacklog backlog)
			throws UserException {
		super();
		this.backlogAssoc = new ToBacklogAssoc(this);
		this.sprintAssoc = new ToSprintAssoc(this);
		this.getBacklogAssoc().set(backlog.getAssoc());
		try {
			this.setName(name);
		} catch (Exception e) {
			backlog.removeItem(this);
		}
		this.setManDayCosts(0);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final ProductBacklogItem other = (ProductBacklogItem) obj;
		if (this.getBacklog() == null) {
			if (other.getBacklog() != null) {
				return false;
			}
		} else if (!this.getBacklog().equals(other.getBacklog())) {
			return false;
		}
		if (this.lastEditor == null) {
			if (other.lastEditor != null) {
				return false;
			}
		} else if (!this.lastEditor.equals(other.lastEditor)) {
			return false;
		}
		if (this.manDayCosts == null) {
			if (other.manDayCosts != null) {
				return false;
			}
		} else if (!this.manDayCosts.equals(other.manDayCosts)) {
			return false;
		}
		if (this.name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!this.name.equals(other.name)) {
			return false;
		}
		if (this.getSprint() == null) {
			if (other.getSprint() != null) {
				return false;
			}
		} else if (!this.getSprint().equals(other.getSprint())) {
			return false;
		}
		return true;
	}

	public ProductBacklog getBacklog() {
		if(this.getBacklogAssoc().get()!=null){
			return this.getBacklogAssoc().get().getElement();
		}
		return null;
//		return this.backlog;
	}

	public IPerson getLastEditor() {
		return this.lastEditor;
	}

	public final Integer getManDayCosts() {
		return this.manDayCosts;
	}

	public final String getName() {
		return this.name;
	}

	public ISprint getSprint() {
		//TODO Implement
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((this.getBacklog() == null) ? 0 : this.getBacklog().hashCode());
		result = prime * result
				+ ((this.lastEditor == null) ? 0 : this.lastEditor.hashCode());
		result = prime
				* result
				+ ((this.manDayCosts == null) ? 0 : this.manDayCosts.hashCode());
		result = prime * result
				+ ((this.name == null) ? 0 : this.name.hashCode());
		result = prime * result
				+ ((this.getSprint() == null) ? 0 : this.getSprint().hashCode());
		return result;
	}

	public void setLastEditor(final IPerson lastEditor) {
		this.lastEditor = lastEditor;
		this.notifyObservers();
	}

	/**
	 * 
	 * @param manDayCosts
	 *            Values smaller 0 are not allow. 0 means not defined.
	 * @throws NoValidValueException
	 *             If the value is smaller 0!
	 */
	public final void setManDayCosts(final Integer manDayCosts)
			throws NoValidValueException {
		if (manDayCosts != null && manDayCosts >= 0) {
			this.manDayCosts = manDayCosts;
			this.notifyObservers();
		} else {
			// TODO Textkonstante bauen
			throw new NoValidValueException(
					"Es muss eine gültige Aufwandsschätzung in Manntagen (>=0) angegeben werden!");
		}
	}

	/**
	 * Changes the Name of the PBI.
	 * 
	 * @param name
	 *            New Name of the PBI.
	 * @throws NoValidValueException
	 *             If the name for the PBI is not valid. Valid names are not
	 *             null and have not only whitespace characters.
	 */
	public final void setName(final String name) throws NoValidValueException, DoubleDefinitionException {
		if (name != null && name.trim().length() > 0) {
			this.getBacklog().isDoubleDefined(name);//Can throw an DoubleDefinitionException
			this.name = name;
			this.notifyObservers();
		} else {
			// TODO Textkonstante bauen
			throw new NoValidValueException(
					"Es muss eine Bezeichnung angegeben werden!");
		}
	}

	/**
	 * TODO Kommentar schreiben
	 * 
	 * @param sprint
	 *            Null Value Means, that the PBI will be removed from the
	 *            Sprint!
	 * @throws NoSprintDefinedException
	 *             , ConsistencyException
	 */
	public void setSprint(final ISprint sprint)
			throws NoSprintDefinedException, ConsistencyException {
		//TODO setSprint
//		if (sprint != null) {
//			if (this.getBacklog().getProject().isSprintDefined(sprint)) {
//				sprint.addPBI(this);
//				this.sprint = sprint;
//				this.notifyObservers();
//			} else {
//				// TODO Textkonstante bauen
//				throw new NoSprintDefinedException(
//						"Es können nur bereits vorhandene Sprints zugeordnet werden!");
//			}
//		} else {
//			if (this.sprint != null) {
//				this.sprint.removePBI(this);
//				this.sprint = null;
//			}
//		}
	}

	@Override
	public String toString() {
		return "ProductBacklogItem [aufwand=" + this.manDayCosts + ", name="
				+ this.name + "]";
	}

}
