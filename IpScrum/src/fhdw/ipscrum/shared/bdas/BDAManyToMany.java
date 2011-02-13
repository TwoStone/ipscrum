package fhdw.ipscrum.shared.bdas;

import java.util.Vector;

@SuppressWarnings("unchecked")
/**
 * <p>This class represents a bidirectional association between 2
 * classes.</p>
 * <p>This association can be 1:1, 1:n oder m:n.<br/>
 * Therefore you have helper methods like set/get and add/remove who
 * can be used by the specific Model classes.<br/><br />
 * <b>This class provides fully synchronization between the connected
 * classes.</b></p>
 */
public abstract class BDAManyToMany<T extends BDAManyToMany, E extends BDACompare> {

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
	 * TODO Kommentar
	 * For single Values (to 1) 
	 * @param bda
	 */
	private void changeConnect(T bda) {
		if (!this.getConnectTo().contains(bda)) {
			if(this.getConnectTo().size()>0){
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
			this.changeConnect(arg);
		}
	}

	/**
	 * TODO Kommentar
	 * FinalSet für zu 1 Assoziation! Setzen erfolgt i.d.R im
	 * Konstruktor
	 * TODO Exception dazu machen und vielleicht noch einen
	 * Status, ob diese Assoziation final ist oder nicht!
	 * @param arg
	 */
	public void finalSet(T arg) {
		if (arg != null) {
			this.connect(arg);
		} else {
			//TODO Exception schmeißen;
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

	
	private int indirectHashcode() {
		int result = 0;
		for(T current : this.getConnectTo()){
			result = result + current.getElement().indirectHashCode();
		}
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((connectTo == null) ? 0 : indirectHashcode());
		return result;
	}
	
	private boolean indirectEquals(BDAManyToMany object){
		return this.getElement().indirectEquals(object.getElement());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BDAManyToMany other = (BDAManyToMany) obj;
		if (connectTo == null) {
			if (other.connectTo != null)
				return false;
		} else if (!indirectEquals(other))
			return false;
		return true;
	}
}
