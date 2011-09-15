package fhdw.ipscrum.shared.utils;

/**
 * ClosureWrapper.
 * 
 * @param <T>
 *            is the chosen type to wrap
 */
public class ClosureWrapper<T> {

	/**
	 * Represents the object to wrap.
	 */
	private T object;

	/**
	 * constructor without parameter. Needed for seialization.
	 */
	public ClosureWrapper() {
		super();
	}

	/**
	 * constructor of the ClosureWrapper.
	 * 
	 * @param object
	 *            to wrap
	 */
	public ClosureWrapper(final T object) {
		super();
		this.object = object;
	}

	/**
	 * Is need to get the object of the ClosureWrapper.
	 * 
	 * @return the current object
	 */
	public T get() {
		return this.object;
	}

	/**
	 * Is need to set the object of the ClosureWrapper.
	 * 
	 * @param objectToSet
	 *            is the object to set
	 */
	public void set(final T objectToSet) {
		this.object = objectToSet;
	}

	@Override
	public String toString() {
		return this.object.toString();
	}

	@Override
	public int hashCode() {
		return this.object.hashCode();
	}

}
