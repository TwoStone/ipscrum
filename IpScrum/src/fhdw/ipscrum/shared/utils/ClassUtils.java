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
		boolean result = false;
		if (clazz2 == null) {
			result = false;
		}

		if (clazz2.equals(clazz1)) {
			result = true;
		}

		Class<?> currentSuperClass = clazz1.getSuperclass();
		while (currentSuperClass != null) {
			if (currentSuperClass.equals(clazz2)) {
				result = true;
			}
			currentSuperClass = currentSuperClass.getSuperclass();
		}
		return result;
	}
}
