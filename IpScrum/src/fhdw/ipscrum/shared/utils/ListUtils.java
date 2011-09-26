package fhdw.ipscrum.shared.utils;

import java.util.ArrayList;
import java.util.List;

import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;

/**
 * represents the utils needed for the lists.
 */
public final class ListUtils {

	/**
	 * constructor of this class.
	 */
	private ListUtils() {

	}

	/**
	 * this method is used for creating the intersection of two lists if only the elements contained in both lists are
	 * needed.
	 * 
	 * @param <T>
	 *            is the type of the elements in the list
	 * @param list1
	 *            is the one list to intersect with the second
	 * @param list2
	 *            is the second list to intersect with the first
	 * @return the list with the elements contained in both lists
	 */
	public static <T> List<T> intersection(final List<T> list1, final List<T> list2) {
		return ListUtils.filter(list1, new Predicate<T>() {

			@Override
			public boolean test(final T element) {
				return list2.contains(element);
			}
		});
	}

	/**
	 * Is needed to search items of a list related to a predicate searched.
	 * 
	 * @param <T>
	 *            is the type of objects in the lists
	 * @param list
	 *            is the list that should be filtered
	 * @param predicate
	 *            is the object to filter
	 * @return the list only contains the items which are equal to the predicate
	 */
	public static <T> List<T> filter(final List<T> list, final Predicate<T> predicate) {
		final List<T> result = new ArrayList<T>();
		for (final T t : list) {
			if (predicate.test(t)) {
				result.add(t);
			}
		}
		return result;
	}

	/**
	 * represents the interface of the predicate which contains a method which tests the predicate.
	 * 
	 * @param <T>
	 *            is the type of the predicate
	 */
	public interface Predicate<T> {
		/**
		 * is needed for testing predicates to filter lists.
		 * 
		 * @param element
		 *            to test
		 * @return true, if the element is the right one.
		 */
		boolean test(T element);
	}

	/**
	 * This is an assistance method for getting complete lists of modelobjects from their ids.
	 * 
	 * @param <T>
	 *            is the type of the items in the list
	 * @param ids
	 *            list of uuids
	 * @param model
	 *            the model
	 * @return a list of modelobjects
	 * @throws NoObjectFindException
	 *             if the objects are not found
	 */
	@SuppressWarnings("unchecked")
	public static <T extends IdentifiableObject> List<T> convertIdListToObjList(final List<String> ids,
			final Model model) throws NoObjectFindException {
		final List<T> result = new ArrayList<T>();
		for (final String id : ids) {
			result.add((T) model.getObject(id));
		}
		return result;
	}

	/**
	 * Converts a given List of modelobjects to a list of ID's.
	 * 
	 * @param <T>
	 *            is the type of the elements in the list
	 * 
	 * @param persons
	 *            list of modelobjects
	 * @return list of corresponding id's
	 */
	public static <T extends IdentifiableObject> List<String> convertObjListToIdList(final List<T> persons) {
		final List<String> result = new ArrayList<String>();
		for (final IdentifiableObject obj : persons) {
			result.add(obj.getId());
		}
		return result;
	}

	/**
	 * alternate contains method.
	 * 
	 * @param <T>
	 *            is the type of the elements in the list
	 * @param list
	 *            list of identifiable obj
	 * @param obj
	 *            object to check if it is in the list
	 * @return boolean is true, if the object is in the list
	 */
	public static <T extends IdentifiableObject> boolean containsAlternate(final List<T> list, final T obj) {
		for (final T current : list) {
			if (current.getId().equals(obj.getId())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Needed for creating the difference of to lists if only the elements contained in one list but not in the other
	 * are needed.
	 * 
	 * @param <T>
	 *            is the type of the elements in the list
	 * @param minuend
	 *            is the list to reduce
	 * @param subtrahend
	 *            is the reducing list
	 * @return the list only containing the elements which are only contained in the minuend
	 */
	public static <T> List<T> difference(final List<T> minuend, final List<T> subtrahend) {
		final List<T> result = new ArrayList<T>();
		for (final T item : minuend) {
			if (!subtrahend.contains(item)) {
				result.add(item);
			}
		}
		return result;
	}
}
