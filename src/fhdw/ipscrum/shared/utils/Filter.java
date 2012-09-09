package fhdw.ipscrum.shared.utils;

/**
 * Filter interface to filter elements in a list.
 * 
 * @author Niklas
 * 
 * @param <T>
 */
public interface Filter<T> {

	/**
	 * Returns true if the element should be contained in the result!
	 * 
	 * @param element
	 *            filtered element
	 * @return true if the element should be contained in the result.
	 */
	boolean test(T element);
}
