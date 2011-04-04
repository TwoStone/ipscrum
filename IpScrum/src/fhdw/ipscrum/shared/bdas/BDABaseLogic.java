package fhdw.ipscrum.shared.bdas;

import java.io.Serializable;
import java.util.Vector;

/**
 * <p>
 * This class represents the base logic for a bidirectional association between
 * 2 classes.
 * </p>
 * <p>
 * This association can be 1:1, 1:n oder m:n.<br/>
 * Therefore you have helper methods like set/get and add/remove who can be used
 * by the concrete association type.<br/>
 * <br />
 * <b>This class provides fully synchronization between the connected
 * classes.</b>
 * </p>
 * <p>
 * <b><u>Equals/Hashcode Customization</u></b> Because of the bidirection of the
 * association you have to ensure that no cycle will appear. Therefore you have
 * to implement {@link BDACompare} in your model class which is owner of the
 * association.<br />
 * <br />
 * The methods indirectEqual/indirectHashcode will called by this Framework on
 * processing an equals/hashcode request to ensure no cycle.<br />
 * Therefore you have to implement both operations like the common
 * equals/hashcode but without any attributes which link to other objects. Only
 * base attributes like String, Integer etc. are allowed.<br />
 * <br />
 * <b>Example: 1:1 Scenario between ClassA and ClassB</b><br />
 * TODO Example will Follow
 * </p>
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class BDABaseLogic<T extends BDABaseLogic, E extends BDACompare>
		implements Serializable {

	private static final long serialVersionUID = 1325822695842459160L;

	/**
	 * Base Element of the association.
	 */
	private E element;

	/**
	 * List of all connected associations to other classes with an association
	 * of type T.
	 */
	private Vector<T> connectTo;

	/**
	 * Only for Serialization
	 */
	protected BDABaseLogic() {
	}

	public BDABaseLogic(final E element) {
		super();
		this.element = element;
		this.connectTo = new Vector<T>();
	}

	/**
	 * This method connects the given associations.<br/>
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
	private E getElement() {
		return this.element;
	}

	/**
	 * Helper method to validate if a association is already set or not.
	 * 
	 * @return Returns true if the given association in not connected else it
	 *         will return false.
	 */
	private boolean isNotConnected(final BDABaseLogic<T, E> bda) {
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
	protected Vector<T> getConnectTo() {
		if (this.connectTo == null) {
			this.connectTo = new Vector<T>();
		}
		return this.connectTo;
	}

	/**
	 * Changes the position of the given association within the list.
	 * Association will move to bottom, that means the new position = size-1
	 */
	protected void moveToBottom(final T bda) {
		this.getConnectTo().remove(bda);
		this.getConnectTo().insertElementAt(bda, this.getConnectTo().size());
	}

	/**
	 * Changes the position of the given association within the list.
	 * Association will move to top, that means the new position = 0
	 */
	protected void moveToTop(final T bda) {
		this.getConnectTo().remove(bda);
		this.getConnectTo().insertElementAt(bda, 0);
	}

	/**
	 * Changes the position of the given association within the list.
	 * Association will move up, that means the new position = current position
	 * + 1!
	 */
	protected void moveUp(final T bda) {
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
	protected void moveDown(final T bda) {
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
	 * TODO Anpassen, la�ft so noch nicht korekt!
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
	private boolean indirectEquals(final BDABaseLogic<?, ?> current,
			final BDABaseLogic<?, ?> object) {
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
		final BDABaseLogic<?, ?> other = (BDABaseLogic<?, ?>) obj;
		// Haben beide das gleiche Basiselement?
		if (!this.indirectEquals(this, other)) {
			return false;
		}
		if (this.connectTo == null) {
			if (other.connectTo != null) {
				return false;
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
	private boolean equalsForAll(final BDABaseLogic<?, ?> other) {
		if (this.getConnectTo().size() == other.getConnectTo().size()) {
			for (int i = 0; i <= this.getConnectTo().size() - 1; i++) {
				if (!this.indirectEquals(this.getAssociation(i),
						other.getAssociation(i))) {
					return false;
				}
			}
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Returns the the Base Element of the first association in the list of
	 * connected associations. If no association was connected null will return.
	 */
	protected BDACompare get() {
		if (this.getConnectTo().size() > 0) {
			return this.getConnectTo().get(0).getElement();
		} else {
			return null;
		}
	}

	/**
	 * Use this method within a 1:1 or 1:n for the 1 side of the association if
	 * you want to set one/null association.<br/>
	 * Processes also a change if another association was set before.
	 */
	protected void set(final T arg) {
		// Initiate a release
		if (arg == null) {
			if (this.getConnectTo().size() > 0) {
				final T dummy = this.getConnectTo().get(0);
				this.release(dummy);
			}
		} else {
			// Release current connection
			if (this.getConnectTo().size() > 0) {
				this.getConnectTo().get(0).release(this);
			}

			this.connect(arg);
		}
	}

	/**
	 * Add method in a 1:n (n-Side) or m:n scenario for adding associations.
	 */
	protected void add(final T arg) {
		if (arg != null) {
			this.connect(arg);
		}
	}

	/**
	 * Remove method in a 1:n (n-Side) or m:n scenario for removing
	 * associations.
	 */
	protected void remove(final T arg) {
		if (arg != null) {
			this.release(arg);
		}
	}

	/**
	 * Returns a list of all base elements from all connected associations.
	 */
	protected Vector<BDACompare> getAssociations() {
		final Vector<BDACompare> copy = new Vector<BDACompare>();
		for (final T current : this.getConnectTo()) {
			copy.add(current.getElement());
		}
		return copy;
	}
}
