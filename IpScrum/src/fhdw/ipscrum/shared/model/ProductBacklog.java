package fhdw.ipscrum.shared.model;

import java.io.Serializable;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.OneToMany;
import fhdw.ipscrum.shared.bdas.OneToOne;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.observer.Observable;

/**
 * Represents the ProductBacklog of a project. It manages the
 * ProductBacklogItems.
 */
public class ProductBacklog extends Observable implements BDACompare,
		Serializable {

	private static final long serialVersionUID = -5276089275386947750L;

	/**
	 * Bidirectional associations to the pbis.
	 */
	private ToPBIAssoc assoc;

	/**
	 * Bidirectional association to the project.
	 */
	private ToProjectAssoc projectAssoc;

	/**
	 * Class which represents the bidirectional part of the pbi association on
	 * the pbl side. See architecture documentation for BDAs!
	 */
	class ToPBIAssoc extends
			OneToMany<ProductBacklogItem.ToBacklogAssoc, ProductBacklog> {
		public ToPBIAssoc(final ProductBacklog element) {
			super(element);
		}
	}

	/**
	 * Class which represents the bidirectional part of the project association
	 * on the pbl side. See architecture documentation for BDAs!
	 */
	class ToProjectAssoc extends
			OneToOne<Project.ToBacklogAssoc, ProductBacklog> {
		public ToProjectAssoc(final ProductBacklog element) {
			super(element);
		}
	}

	/**
	 * Returns the bidirectional association to the pbis.
	 */
	protected ToPBIAssoc getAssoc() {
		return this.assoc;
	}

	/**
	 * Returns the bidirectional association to the related project.
	 */
	protected ToProjectAssoc getProjectAssoc() {
		return this.projectAssoc;
	}

	@SuppressWarnings("unused")
	/**
	 * Default Constructor for GWT serialization.
	 */
	private ProductBacklog() {
	}

	/**
	 * <b>It's not allowed</b> to create an PBL object out of the model because
	 * each project will create its own PBL. You will get inconsistency if you
	 * run this constructor!
	 * 
	 * @param project
	 *            Reverse association to the project!
	 */
	protected ProductBacklog(final Project project) {
		super();
		this.projectAssoc = new ToProjectAssoc(this);
		this.assoc = new ToPBIAssoc(this);
	}

	/**
	 * Checks if an pbi with the given name already exist in the product
	 * backlog.
	 * 
	 * @param pbiName
	 *            Name of the PBI
	 * @throws DoubleDefinitionException
	 */
	public void isDoubleDefined(final String pbiName)
			throws DoubleDefinitionException {
		for (final ProductBacklogItem current : this.getItems()) {
			if (current.getName() == pbiName) {
				throw new DoubleDefinitionException(
						TextConstants.DOUBLE_DEFINITION_PBI);
			}
		}
	}

	/**
	 * Returns all ProductBacklogItems of the this Backlog. <br />
	 * <b>Attention</b><br />
	 * For adding and removing Items to/from the list please use the methods of
	 * the Backlog. Else we cannot guarantee the consistency!
	 */
	public Vector<ProductBacklogItem> getItems() {
		final Vector<ProductBacklogItem> ret = new Vector<ProductBacklogItem>();
		for (final BDACompare current : this.getAssoc().getAssociations()) {
			ret.add((ProductBacklogItem) current);
		}
		return ret;
	}

	/**
	 * Move the given pbi to the top of the list.
	 * 
	 * @param item
	 *            pbi for moving.
	 */
	public void moveTop(final ProductBacklogItem item) {
		this.getAssoc().moveToTop(item.getBacklogAssoc());
		this.notifyObservers();
	}

	/**
	 * Move the given pbi to the end of the list.
	 * 
	 * @param item
	 *            pbi for moving.
	 */
	public void moveBottom(final ProductBacklogItem item) {
		this.getAssoc().moveToBottom(item.getBacklogAssoc());
		this.notifyObservers();
	}

	/**
	 * Move the given pbi one position in top direction of the list. Therefore
	 * another pbi will move one step down.
	 * 
	 * @param item
	 *            pbi for moving.
	 */
	public void moveUp(final ProductBacklogItem item) {
		this.getAssoc().moveUp(item.getBacklogAssoc());
	}

	/**
	 * Move the given pbi one position in bottom direction of the list.
	 * Therefore another pbi will move one step up.
	 * 
	 * @param item
	 *            pbi for moving.
	 */
	public void moveDown(final ProductBacklogItem item) {
		this.getAssoc().moveDown(item.getBacklogAssoc());
	}

	/**
	 * Adds the given pbi at the end of the list.
	 * 
	 * @param item
	 *            For adding.
	 */
	public void addItem(final ProductBacklogItem item)
			throws ConsistencyException {
		if (item != null) {
			if (item.getBacklog() == null) {
				this.getAssoc().add(item.getBacklogAssoc());
				this.notifyObservers();
			} else if (item.getBacklog() == this) {
				this.getAssoc().add(item.getBacklogAssoc());
				this.notifyObservers();
			} else {
				// Needed because in this case a change is not alowed.
				throw new ConsistencyException(TextConstants.PBI_ERROR);
			}
		}
	}

	/**
	 * Removes the given PBI from the product backlog and provides Consistency.
	 * 
	 * @param item
	 *            PBI which will be removed.
	 * @throws UserException
	 */
	public void removeItem(final ProductBacklogItem item) throws UserException {
		item.setSprint(null);// Providing Consistency
		this.getAssoc().remove(item.getBacklogAssoc());
		this.notifyObservers();
	}

	/**
	 * Returns the number of pbis within the product backlog.
	 */
	public Integer countItems() {
		return this.getItems().size();
	}

	/**
	 * Return the releated project.
	 */
	public Project getProject() {
		return (Project) this.getProjectAssoc().get();
	}

	@Override
	public String toString() {
		return TextConstants.PRODUCT_BACKLOG;
	}

	@Override
	public int indirectHashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result;
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((this.assoc == null) ? 0 : this.assoc.hashCode());
		result = prime
				* result
				+ ((this.projectAssoc == null) ? 0 : this.projectAssoc
						.hashCode());
		return result;
	}

	@Override
	public boolean indirectEquals(final Object obj) {
		return super.equals(obj);
	}

	@Override
	public boolean equals(final Object obj) {
		if (!this.indirectEquals(obj)) {
			return false;
		} else {
			final ProductBacklog other = (ProductBacklog) obj;
			if (this.assoc == null) {
				if (other.assoc != null) {
					return false;
				}
			} else if (!this.assoc.equals(other.assoc)) {
				return false;
			}
			if (this.projectAssoc == null) {
				if (other.projectAssoc != null) {
					return false;
				}
			} else if (!this.projectAssoc.equals(other.projectAssoc)) {
				return false;
			}
			return true;
		}
	}

	/**
	 * Returns the position of the ProductBacklogItem within the list.
	 * 
	 * @param item
	 * @return Values between 0 ... n are valid positions Value -1 means that
	 *         the element is not in the list;
	 */
	public Integer getItemPositionInList(final ProductBacklogItem item) {
		return this.getItems().indexOf(item);
	}
}
