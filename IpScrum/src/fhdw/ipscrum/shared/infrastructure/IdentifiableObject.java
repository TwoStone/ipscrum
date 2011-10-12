package fhdw.ipscrum.shared.infrastructure;

import java.io.Serializable;
import java.util.Date;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.utils.CalendarUtils;

/**
 * Represents the main class of all model objects.
 */
public abstract class IdentifiableObject extends Observable implements IsSerializable, Serializable {
	/**
	 * represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 6380110399272930173L;

	/**
	 * represents the id of the identifiable object.
	 */
	private String id;

	/**
	 * represents the fact if the identifiable object has been changed.
	 */
	private boolean changed = false;

	/**
	 * represents the revision date of the identifiable object.
	 */
	private Date revisionDate;

	/**
	 * represents the fact if the identifiable object has been deleted.
	 */
	private boolean deleted = false;

	/**
	 * represents the model the identifiable object is related to.
	 */
	private Model model;

	/**
	 * checks if the identifiable object has been deleted.
	 * 
	 * @return true if the identifiable object has been deleted
	 */
	public boolean isDeleted() {
		return this.deleted;
	}

	/**
	 * Sets deleted flag to true.
	 */
	public void setDeleted() {
		this.deleted = true;
		this.changed = true;
	}

	/**
	 * Sets changed flag to true.
	 */
	public void changed() {
		this.changed = true;
	}

	/**
	 * getter of the related model.
	 * 
	 * @return the current model
	 */
	protected Model getModel() {
		return this.model;
	}

	/**
	 * constructor of the identifiable object.
	 * 
	 * @param model
	 *            related to the identifiable object
	 */
	public IdentifiableObject(final Model model) {
		this();
		this.model = model;
		this.id = model.getUuidManager().nextID();
	}

	/**
	 * adds a identifiable Object to the ObjectStore.
	 */
	protected void putToObjectStore() {
		this.model.addNewObject(this);
		this.changed();
	}

	/**
	 * checks if the identifiable object has been changed.
	 * 
	 * @return true, if the object has been changed
	 */
	public boolean hasChanged() {
		return this.changed;
	}

	/**
	 * Sets the changed flag to false.
	 */
	public void undoChangeFlag() {
		this.changed = false;
	}

	/**
	 * sets the revision date of the identifiable object.
	 * 
	 * @param revisionDate
	 *            to set
	 */
	public void setRevisionDate(final Date revisionDate) {
		this.revisionDate = CalendarUtils.copy(revisionDate);
	}

	/**
	 * getter of the revision date.
	 * 
	 * @return the current revision date
	 */
	public Date getRevisionDate() {

		return CalendarUtils.copy(this.revisionDate);
	}

	/**
	 * constructor without parameters. needed for serialization.
	 */
	protected IdentifiableObject() {
		super();
	}

	/**
	 * getter of the id of the identifiable object.
	 * 
	 * @return the current id
	 */
	public String getId() {
		return this.id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (this.id == null ? 0 : this.id.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final IdentifiableObject other = (IdentifiableObject) obj;
		if (this.id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!this.id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
