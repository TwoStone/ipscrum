package fhdw.ipscrum.shared.observer;

import java.util.Vector;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * <p>
 * This class represents an observable object, or "data" in the model-view paradigm. It can be subclassed to represent
 * an object that the application wants to have observed.
 * </p>
 * <p>
 * An observable object can have one or more observers. An observer may be any object that implements interface
 * Observer. After an observable instance changes, an application calling the Observable's notifyObservers method causes
 * all of its observers to be notified of the change by a call to their update method.
 * </p>
 * <p>
 * The order in which notifications will be delivered is unspecified. The default implementation provided in the
 * Observable class will notify Observers in the order in which they registered interest, but subclasses may change this
 * order, use no guaranteed order, deliver notifications on separate threads, or may guarantee that their subclass
 * follows this order, as they choose.
 * </p>
 * <p>
 * Note that this notification mechanism is has nothing to do with threads and is completely separate from the wait and
 * notify mechanism of class Object.
 * </p>
 * <p>
 * When an observable object is newly created, its set of observers is empty. Two observers are considered the same if
 * and only if the equals method returns true for them.
 * </p>
 * <p>
 * <b>Attention</b> The functioning of this class is nearly the same as java.util.Observable! <br/>
 * Differences are:
 * <ul>
 * <li>No use of the <i>changed</i> attribute</li>
 * <li>list of observers is a vector and it is transient. Because of the transient modifier the observer list will not
 * be serialized by XStream-library</li>
 * </ul>
 * </p>
 */
public abstract class Observable implements IsSerializable, IObservable {

	/**
	 * Each Observer is only one time in the list.
	 */
	private transient Vector<TransientObserver> observers;

	/**
	 * Represents the persistentObservers.
	 */
	private Vector<PersistentObserver> persistentObservers;

	/**
	 * Construct an Observable with zero Observers.
	 */
	public Observable() {
		this.observers = new Vector<TransientObserver>();
		this.persistentObservers = new Vector<PersistentObserver>();
	}

	/**
	 * Getter of the persistentObservers.
	 * 
	 * @return all persistentObservers
	 */
	private Vector<PersistentObserver> getPersistentObservers() {
		if (this.persistentObservers == null) {
			this.persistentObservers = new Vector<PersistentObserver>();
		}
		return this.persistentObservers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.observer.IObservable#addObserver(fhdw.ipscrum.shared .observer.TransientObserver)
	 */
	@Override
	public void addObserver(final TransientObserver observer) {
		this.getTransientObservers().add(observer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.observer.IObservable#addObserver(fhdw.ipscrum.shared .observer.PersistentObserver)
	 */
	@Override
	public void addObserver(final PersistentObserver observer) {
		this.getPersistentObservers().add(observer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.observer.IObservable#countObservers()
	 */
	@Override
	public int countObservers() {
		return this.countTransientObservers() + this.countPersistentObservers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.observer.IObservable#countTransientObservers()
	 */
	@Override
	public int countTransientObservers() {
		return this.getTransientObservers().size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.observer.IObservable#countPersistentObservers()
	 */
	@Override
	public int countPersistentObservers() {
		return this.getPersistentObservers().size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.observer.IObservable#deleteObserver(fhdw.ipscrum. shared.observer.TransientObserver)
	 */
	@Override
	public void deleteObserver(final TransientObserver observer) {
		this.getTransientObservers().remove(observer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.observer.IObservable#deleteObserver(fhdw.ipscrum. shared.observer.PersistentObserver)
	 */
	@Override
	public void deleteObserver(final PersistentObserver observer) {
		this.getPersistentObservers().remove(observer);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.observer.IObservable#deleteObservers()
	 */
	@Override
	public void deleteObservers() {
		this.getTransientObservers().removeAllElements();
		this.getPersistentObservers().removeAllElements();
	}

	/**
	 * Getter of the transientObservers.
	 * 
	 * @return all transientObservers
	 */
	private Vector<TransientObserver> getTransientObservers() {
		if (this.observers == null) {
			this.observers = new Vector<TransientObserver>();
		}
		return this.observers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.observer.IObservable#notifyObservers()
	 */
	@Override
	public void notifyObservers() {
		this.notifyObservers(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.observer.IObservable#notifyObservers(java.lang.Object )
	 */
	@Override
	public void notifyObservers(final Object argument) {
		for (final TransientObserver current : this.getTransientObservers()) {
			current.update(this, argument);
		}
		for (final PersistentObserver current : this.getPersistentObservers()) {
			current.update(this, argument);
		}
	}

	@Override
	public String toString() {
		return "Observable [observers=" + this.getTransientObservers() + "]";
	}
}
