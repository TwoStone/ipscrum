package fhdw.ipscrum.shared.utils;

/**
 * Represents the ClassUtils.
 */
public final class ClassUtils {

	/**
	 * constructor of this class.
	 */
	private ClassUtils() {

	}

	/**
	 * Checks if two classes are identical.
	 * 
	 * @param clazz1
	 *            first class to check
	 * @param clazz2
	 *            second class to check
	 * @return true, if the classes are identical
	 */
	public static boolean
			isAssignableFrom(final Class<?> clazz1, final Class<?> clazz2) {
		if (clazz2 == null) {
			return false;
		}

		if (clazz2.equals(clazz1)) {
			return true;
		}

		Class<?> currentSuperClass = clazz1.getSuperclass();
		while (currentSuperClass != null) {
			if (currentSuperClass.equals(clazz2)) {
				return true;
			}
			currentSuperClass = currentSuperClass.getSuperclass();
		}
		return false;
	}
}
