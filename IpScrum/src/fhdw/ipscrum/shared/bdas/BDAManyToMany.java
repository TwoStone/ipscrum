package fhdw.ipscrum.shared.bdas;

import java.util.Vector;

/**
 * <p>
 * This class represents a bidirectional association between 2 classes.
 * </p>
 * <p>
 * This association can be 1:1, 1:n oder m:n.<br/>
 * Therefore you have helper methods like set/get and add/remove who can be used
 * by the specific Model classes.<br/>
 * <br />
 * <b>This class provides fully synchronization between the connected
 * classes.</b>
 * </p>
 * <p>
 * <b><u>Equals/Hashcode Customization</u></b> Because of the bi-direction of
 * the association you have to ensure that no cycle will appear. Therefore you
 * have to implement {@link BDACompare} in your model class which is owner of
 * the association.<br />
 * <br />
 * The methods indirectEqual/indirectHashcode will called by this Framework on
 * processing an equals/hashcode request to ensure no cycle.<br />
 * Therefore you have to implement both operations like the common
 * equals/hashcode but without any attributes which link to other objects. Only
 * base attributes like String, Integer etc. are allowed.<br />
 * <br />
 * <b>Example: 1:1 Scenario between ClassA and ClassB</b><br />
 * TODO Example will Follow
 *</p>
 */
@SuppressWarnings("unchecked")
public abstract class BDAManyToMany<T extends BDAManyToMany, E extends BDACompare> {

	/**
	 * Base Element of the association.
	 */
	private final E element;

	/**
	 * List of all connected associations to other classes with an association
	 * of type T.
	 */
	private Vector<T> connectTo;

	public BDAManyToMany(final E element) {
		super();
		this.element = element;
		this.connectTo = new Vector<T>();
	}

	/**
	 * This method connects two associations to each other.<br/>
	 * Therefore synchronization will be ensured.
	 * 
	 * @param bda
	 *            Association Object which will be connected to this
	 *            association.
	 */
	private void connect(final T bda) {
		if (!this.getConnectTo().contains(bda)) {
			this.getConnectTo().add(bda);
			if (bda.isNotConnected(this)) {
				bda.connect(this);
			}
		}
	}

	/**
	 * TODO Kommentar For single Values (to 1)
	 * 
	 * @param bda
	 */
	private void changeConnect(final T bda) {
		if (!this.getConnectTo().contains(bda)) {
			if (this.getConnectTo().size() > 0) {
				this.getConnectTo().get(0).release(this);
			}
			this.getConnectTo().removeAllElements();
			this.getConnectTo().add(bda);
			if (bda.isNotConnected(this)) {
				bda.changeConnect(this);
			}
		}
	}

	/**
	 * This method releases a connection between two associations objects.
	 * Therefore synchronization will be ensured.
	 * 
	 * @param bda
	 *            Association Object which will be disconnected.
	 */
	private void release(final T bda) {
		if (this.getConnectTo().contains(bda)) {
			this.getConnectTo().remove(bda);
			bda.release(this);
		}
	}

	/**
	 * Return the base element of this association object.
	 */
	public E getElement() {
		return this.element;
	}

	/**
	 * Helper method to validate if a association is already set or not.
	 * 
	 * @return Returns true if the given association in not connected else it
	 *         will return false.
	 */
	private boolean isNotConnected(final BDAManyToMany<T, E> bda) {
		if (this.getConnectTo().size() == 0) {
			return true;
		} else if (this.getConnectTo().contains(bda)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Returns all association objects which are connected with this
	 * association.
	 */
	private Vector<T> getConnectTo() {
		if (this.connectTo == null) {
			this.connectTo = new Vector<T>();
		}
		return this.connectTo;
	}

	/**
	 * Use this method within a 1:1 or 1:n for the 1 side of the association if
	 * you want to set one/null association.<br/>
	 */
	public void set(final T arg) {
		if (arg == null) {
			if (this.getConnectTo().size() > 0) {
				final T dummy = this.getConnectTo().get(0);
				this.release(dummy);
			}
		} else {
			if (this.getConnectTo().size() > 0) {
				this.getConnectTo().get(0).release(this);
			}
			this.changeConnect(arg);
		}
	}

	/**
	 * TODO
	 */
	public void setNotChange(final T arg) {
		if (arg == null) {
			if (this.getConnectTo().size() > 0) {
				final T dummy = this.getConnectTo().get(0);
				this.release(dummy);
			}
		} else {
			if (this.getConnectTo().size() > 0) {
				this.getConnectTo().get(0).release(this);
			}
			this.connect(arg);
		}
	}

	/**
	 * TODO Kommentar FinalSet für zu 1 Assoziation! Setzen erfolgt i.d.R im
	 * Konstruktor TODO Exception dazu machen und vielleicht noch einen Status,
	 * ob diese Assoziation final ist oder nicht!
	 * 
	 * @param arg
	 */
	public void finalSet(final T arg) {
		if (arg != null) {
			this.connect(arg);
		} else {
			// TODO Exception schmeißen;
		}
	}

	/**
	 * This method returns the 1/null association in a 1:n or 1:1 scenario.
	 * 
	 * @return It returns null if nothing was set set else it returns the
	 *         association object.
	 */
	public T get() {
		if (this.getConnectTo().size() > 0) {
			return this.getConnectTo().get(0);
		} else {
			return null;
		}
	}

	/**
	 * Add method in a 1:n (n-Side) or m:n scenario for adding associations.
	 */
	public void add(final T arg) {
		if (arg != null) {
			this.connect(arg);
		}
	}

	/**
	 * Remove method in a 1:n (n-Side) or m:n scenario for removing
	 * associations.
	 */
	public void remove(final T arg) {
		if (arg != null) {
			this.release(arg);
		}
	}

	/**
	 * Returns a copy of all listed association objects. Use this within a 1:n
	 * or m:n scenario for getting all elements.
	 */
	public Vector<T> getAssociations() {
		final Vector<T> copy = new Vector<T>();
		for (final T current : this.getConnectTo()) {
			copy.add(current);
		}
		return copy;
	}

	/**
	 * Changes the position of the given association within the list.
	 * Association will move to bottom, that means the new position = size-1
	 */
	public void moveToBottom(final T bda) {
		this.getConnectTo().remove(bda);
		this.getConnectTo().insertElementAt(bda, this.getConnectTo().size());
	}

	/**
	 * Changes the position of the given association within the list.
	 * Association will move to top, that means the new position = 0
	 */
	public void moveToTop(final T bda) {
		this.getConnectTo().remove(bda);
		this.getConnectTo().insertElementAt(bda, 0);
	}

	/**
	 * Changes the position of the given association within the list.
	 * Association will move up, that means the new position = current position
	 * + 1!
	 */
	public void moveUp(final T bda) {
		final Integer position = this.getConnectTo().indexOf(bda);
		if (position > 0) {
			this.getConnectTo().remove(bda);
			this.getConnectTo().insertElementAt(bda, position - 1);
		}
	}

	/**
	 * Changes the position of the given association within the list.
	 * Association will move down, that means the new position = current
	 * position - 1!
	 */
	public void moveDown(final T bda) {
		final Integer position = this.getConnectTo().indexOf(bda);
		if (position > -1 && position < (this.getConnectTo().size() - 1)) {
			this.getConnectTo().remove(bda);
			this.getConnectTo().insertElementAt(bda, position + 1);
		}
	}

	/**
	 * Helper for hashCode() to ensure that no cycles will appear.
	 */
	private int indirectHashcode() {
		int result = 0;
		for (final T current : this.getConnectTo()) {
			result = result + current.getElement().indirectHashCode();
		}
		return result;
	}

	@Override
	/**
	 * TODO Anpassen, laüft so noch nicht korekt!
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.connectTo == null) ? 0 : this.indirectHashcode());
		return result;
	}

	/**
	 * Helper for equals to ensure that no cycles will appear.
	 */
	private boolean indirectEquals(final BDAManyToMany current,
			final BDAManyToMany object) {
		return current.getElement().indirectEquals(object.getElement());
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
		final BDAManyToMany other = (BDAManyToMany) obj;
		// Haben beide das gleiche Basiselement?
		if (!this.indirectEquals(this, other)) {
			return false;
		}
		if (this.connectTo == null) {
			if (other.connectTo != null) {
				return false;
				// } else if (!indirectEquals(other))
				// Sind alle Verbindungen equals?
			}
		} else if (!this.equalsForAll(other)) {
			return false;
		}
		return true;
	}

	/**
	 * Returns the association at the specific position.
	 * 
	 * @param i
	 *            Position of the association in the list.
	 */
	private T getAssociation(final int i) {
		return this.getConnectTo().get(i);
	}

	/**
	 * Compares the list of connected associations.<br />
	 * Returns true if both lists are equal an in same order.
	 */
	private boolean equalsForAll(final BDAManyToMany other) {
		// Meine eigenen
		if (this.getConnectTo().size() == other.getConnectTo().size()) {
			for (int i = 0; i <= this.getConnectTo().size() - 1; i++) {
				if (!this.indirectEquals(this.getAssociation(i), other
						.getAssociation(i))) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}
}
