package fhdw.ipscrum.shared.model;

import java.io.Serializable;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.BDAManyToMany;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * Represents the abstract Root Class for a ProductBacklogItem.
 */
public abstract class ProductBacklogItem extends Observable implements
		BDACompare, Serializable {

	private static final long serialVersionUID = 1599696800942615676L;

	/**
	 * Class which represents the bidirectional part of the backlog association
	 * on the PBI side. See architecture documentation for BDAs!
	 */
	class ToBacklogAssoc extends
			BDAManyToMany<ProductBacklog.ToPBIAssoc, ProductBacklogItem> {
		public ToBacklogAssoc(final ProductBacklogItem element) {
			super(element);
		}
	}

	/**
	 * Class which represents the bidirectional part of the sprint association
	 * on the PBI side. See architecture documentation for BDAs!
	 */
	public class ToSprintAssoc extends
			BDAManyToMany<ISprint.ToPBIAssoc, ProductBacklogItem> {
		public ToSprintAssoc(final ProductBacklogItem element) {
			super(element);
		}
	}

	/**
	 * Name of the sprint.
	 */
	private String name;

	/**
	 * Complexity of the PBI.
	 */
	private Integer manDayCosts;

	/**
	 * Last Editor of the PBI.
	 */
	private IPerson lastEditor;

	/**
	 * Returns the bidirectional association to the backlog.
	 */
	private ToBacklogAssoc backlogAssoc;

	/**
	 * Returns the bidirectional association to the sprint.
	 */
	private ToSprintAssoc sprintAssoc;

	/**
	 * Default Constructor for GWT serialization.
	 */
	protected ProductBacklogItem() {
	}

	/**
	 * @param name
	 *            Name of the PBI.
	 * @param backlog
	 *            Backlog of the PBI.
	 * @throws NoValidValueException
	 *             If the name for the PBI is not valid. Valid names are not
	 *             null and have not only whitespace characters.
	 * @throws DoubleDefinitionException
	 *             If the name of the PBI already exist within the product
	 *             backlog
	 */
	public ProductBacklogItem(final String name, final ProductBacklog backlog)
			throws UserException {
		super();
		this.initialize();
		this.backlogAssoc = new ToBacklogAssoc(this);
		this.sprintAssoc = new ToSprintAssoc(this);
		this.checkName(backlog, name); // Initiale Prüfung
		this.setManDayCosts(0);
		this.getBacklogAssoc().finalSet(backlog.getAssoc());
	}

	/**
	 * @author stefan pietsch group 2 in phase 2 optional operation for
	 *         subclasses to initialize before super call, for example
	 *         initialize new attributes.
	 */
	protected abstract void initialize();

	/**
	 * Visitor Entry Point for group 2 in phase 2.
	 */
	public abstract void accept(IProductBacklogItemVisitor visitor);

	/**
	 * Checks if a pbi with a same name already exist within the given backlog.
	 * 
	 * @param backlog
	 *            Product Backlog
	 * @param name
	 *            Name of the PBI.
	 * @throws NoValidValueException
	 *             If name is not valid (see constructor).
	 * @throws DoubleDefinitionException
	 *             If name already exist.
	 */
	private void checkName(final ProductBacklog backlog, final String name)
			throws NoValidValueException, DoubleDefinitionException {
		if (name != null && name.trim().length() > 0) {
			if (backlog != null) {
				for (final ProductBacklogItem item : backlog.getItems()) {
					if (!item.equals(this) && item.getName().equals(name)) {
						throw new DoubleDefinitionException(
								TextConstants.DOUBLE_DEFINITION_PBI);
					}
				}
			}
			this.name = name;
		} else {
			throw new NoValidValueException(TextConstants.MISSING_TEXT_ERROR);
		}
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
		if (this.backlogAssoc == null) {
			if (other.backlogAssoc != null) {
				return false;
			}
		} else if (!this.backlogAssoc.equals(other.backlogAssoc)) {
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
		if (this.sprintAssoc == null) {
			if (other.sprintAssoc != null) {
				return false;
			}
		} else if (!this.sprintAssoc.equals(other.sprintAssoc)) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the backlog of the pbi.
	 */
	public ProductBacklog getBacklog() {
		if (this.getBacklogAssoc().get() != null) {
			return this.getBacklogAssoc().get().getElement();
		}
		return null;
	}

	/**
	 * Returns the bidirectional association to the backlog.
	 */
	protected ToBacklogAssoc getBacklogAssoc() {
		return this.backlogAssoc;
	}

	/**
	 * Returns the last editor of the pbi.
	 */
	public IPerson getLastEditor() {
		return this.lastEditor;
	}

	/**
	 * Returns the complexity of the pbi.
	 */
	public Integer getManDayCosts() {
		return this.manDayCosts;
	}

	/**
	 * Returns the name of the pbi.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the sprint if it was set else null will be returned.
	 */
	public ISprint getSprint() {
		if (this.getSprintAssoc().get() != null) {
			return this.getSprintAssoc().get().getElement();
		} else {
			return null;
		}
	}

	/**
	 * Returns the bidirectional association to the sprint.
	 */
	protected ToSprintAssoc getSprintAssoc() {
		return this.sprintAssoc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = this.indirectHashCode();
		result = prime
				* result
				+ ((this.backlogAssoc == null) ? 0 : this.backlogAssoc
						.hashCode());
		result = prime * result
				+ ((this.lastEditor == null) ? 0 : this.lastEditor.hashCode());
		result = prime
				* result
				+ ((this.sprintAssoc == null) ? 0 : this.sprintAssoc.hashCode());
		return result;
	}

	@Override
	public boolean indirectEquals(final Object obj) {
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
		return true;
	}

	@Override
	public int indirectHashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime
				* result
				+ ((this.manDayCosts == null) ? 0 : this.manDayCosts.hashCode());
		result = prime * result
				+ ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	public void setLastEditor(final IPerson lastEditor)
			throws ForbiddenStateException {
		this.lastEditor = lastEditor;
		this.notifyObservers();
	}

	/**
	 * Changes the Complexity of the pbi.
	 * 
	 * @param manDayCosts
	 *            Values smaller 0 are not allow. 0 means not defined.
	 * @throws NoValidValueException
	 *             If the value is smaller 0!
	 * @throws ForbiddenStateException
	 *             If the pbi was closed.
	 */
	public void setManDayCosts(final Integer manDayCosts)
			throws NoValidValueException, ForbiddenStateException {
		if (manDayCosts != null && manDayCosts >= 0) {
			this.manDayCosts = manDayCosts;
			this.notifyObservers();
		} else {
			throw new NoValidValueException(TextConstants.MANDAYS_ERROR);
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
	 * @throws ForbiddenStateException
	 *             if the pbi was closed. * @throws DoubleDefinitionException if
	 *             a pbi with the same name already exist within the product
	 *             backlog
	 */
	public void setName(final String name) throws NoValidValueException,
			DoubleDefinitionException, ConsistencyException,
			ForbiddenStateException {
		if (this.getBacklog() != null) {
			this.checkName(this.getBacklog(), name);
		} else {
			throw new ConsistencyException(TextConstants.PBL_PBI_ERROR);
		}
	}

	/**
	 * Changes the sprint of a pbi.
	 * 
	 * @param sprint
	 *            Null Value Means, that the PBI will be removed from the
	 *            sprint!
	 * @throws NoSprintDefinedException
	 *             If the sprint is not defined within the project the pbi
	 *             belongs to.
	 * @throws ForbiddenStateException
	 *             The pbi was closed.
	 */
	public void setSprint(final ISprint sprint)
			throws NoSprintDefinedException, ConsistencyException,
			ForbiddenStateException {
		if (sprint != null) {
			this.getBacklog().getProject().isSprintDefined(sprint);
			this.getSprintAssoc().set(sprint.getToPBIAssoc());
		} else {
			this.getSprintAssoc().set(null);
		}
		this.notifyObservers();
	}

	@Override
	public String toString() {
		return "ProductBacklogItem [aufwand=" + this.manDayCosts + ", name="
				+ this.name + "]";
	}
}
