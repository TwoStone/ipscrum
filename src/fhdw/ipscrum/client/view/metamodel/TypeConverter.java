package fhdw.ipscrum.client.view.metamodel;

/**
 * Converter for types from one type in the other.
 * 
 * @param <T>
 *            is the one type to convert to or from
 * @param <R>
 *            is the second type to convert to or from
 */
public interface TypeConverter<T, R> {

	/**
	 * Converts a value from the type R to the type T.
	 * 
	 * @param value
	 *            to convert
	 * @return the converted value
	 */
	T parse(R value);

	/**
	 * Converts a value from the type T to the type R.
	 * 
	 * @param value
	 *            to convert
	 * @return the converted value
	 */
	R render(T value);

}
