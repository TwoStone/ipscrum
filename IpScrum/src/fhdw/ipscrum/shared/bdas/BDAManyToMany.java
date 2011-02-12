package fhdw.ipscrum.shared.bdas;

import java.util.Vector;

@SuppressWarnings("unchecked")
/**
 * <p>This class represents a bidirectional association between 2
 * classes.</p>
 * <p>This association can be 1:1, 1:n oder m:n.<br/>
 * Therefor you have helper methods like set/get and add/remove who
 * can be used by the specific Model classes.<br/><br />
 * <b>This class provides fully synchronization between the connected
 * classes.</b></p>
 */
public abstract class BDAManyToMany<T extends BDAManyToMany, E> {

	/**
	 * Base Element of the association.
	 */
	private final E element;
	
	/**
	 * List of all connected associations to other classes of
	 * Type T.
	 */
	private Vector<T> connectTo;

	public BDAManyToMany(E element) {
		super();
		this.element = element;
		this.connectTo = new Vector<T>();
	}

	/**
	 * This method connects two associations to each other.<br/>
	 * Therefore synchronization will be ensured.
	 * @param bda
	 * Association Object which will be connected to this association.
	 */
	private void connect(T bda) {
		if (!this.getConnectTo().contains(bda)) {
			this.getConnectTo().add(bda);
			if (bda.isNotConnected(this)) {
				bda.connect(this);
			}
		}
	}

	/**
	 * This method releases a connection between two associations
	 * objects. Therefore synchronization will be ensured.
	 * @param bda
	 * Association Object which will be disconnected.
	 */
	private void release(T bda) {
		if (this.getConnectTo().contains(bda)) {
			this.getConnectTo().remove(bda);
			bda.release(this);
		}
	}

	/**
	 * Return the base element of this association object.
	 */
	public E getElement() {
		return element;
	}

	/**
	 * Helper method to validate if a association is already
	 * set or not.
	 * @return
	 * Returns true if the given association in not connected
	 * else it will return false.
	 */
	private boolean isNotConnected(BDAManyToMany<T, E> bda) {
		if (this.getConnectTo().size() == 0) {
			return true;
		} else if (this.getConnectTo().contains(bda)) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Returns all association objects which are connected with
	 * this association.
	 */
	private Vector<T> getConnectTo() {
		if(this.connectTo==null){
			this.connectTo = new Vector<T>();
		}
		return this.connectTo;
	}

	/**
	 * Use this method within a 1:1 or 1:n for the 1 side of
	 * the association if you want to set one/null association.<br/>
	 */
	public void set(T arg) {
		if (arg == null) {
			if (this.getConnectTo().size() > 0) {
				T dummy = this.getConnectTo().get(0);
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
	 * This method returns the 1/null association in a 1:n or 1:1
	 * scenario.
	 * @return
	 * It returns null if nothing was set set else it returns the
	 * association object.
	 */
	public T get(){
		if(this.getConnectTo().size()>0){
			return this.getConnectTo().get(0);
		}else{
			return null;
		}
	}
	
	/**
	 * Add method in a 1:n (n-Side) or m:n scenario for
	 * adding associations.
	 */
	public void add(T arg){
		if(arg!=null){
			this.connect(arg);
		}
	}
	
	/**
	 * Remove method in a 1:n (n-Side) or m:n scenario for
	 * removing associations.
	 */
	public void remove(T arg){
		if(arg!=null){
			this.release(arg);
		}
	}
	
	/**
	 * Returns a copy of all listed association objects.
	 * Use this within a 1:n or m:n scenario for getting
	 * all elements.
	 */
	public Vector<T> getAssociations(){
		// Returns a copy of the list else it's possible
		// to change the list!
		Vector<T> copy = new Vector<T>();
		for (T current : this.getConnectTo()) {
			copy.add(current);
		}
		return copy;
	}
	
	public void moveToBottom(T bda){
		this.getConnectTo().remove(bda);
		this.getConnectTo().insertElementAt(bda, this.getConnectTo().size());
	}

	public void moveToTop(T bda){
		this.getConnectTo().remove(bda);
		this.getConnectTo().insertElementAt(bda, 0);
	}
	
	public void moveUp(T bda){
		Integer position = this.getConnectTo().indexOf(bda);
		if (position > 0) {
			this.getConnectTo().remove(bda);
			this.getConnectTo().insertElementAt(bda, position - 1);
		}
	}
	
	public void moveDown(T bda){
		Integer position = this.getConnectTo().indexOf(bda);
		if (position > -1 && position < (this.getConnectTo().size() - 1)) {
			this.getConnectTo().remove(bda);
			this.getConnectTo().insertElementAt(bda, position + 1);
		}
	}
}
