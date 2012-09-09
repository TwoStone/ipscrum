package fhdw.ipscrum.client.view.metamodel;

/**
 * Represents the interface of the TypeParser.
 * 
 * @param <T>
 *            is the type to parse in
 * @param <I>
 *            is the type of the value to parse from
 */
public interface TypeParser<T, I> {
	/**
	 * Parses the value from the type I to the type T.
	 * 
	 * @param value
	 *            to parse
	 * @return the value in the type it is parsed in
	 */
	T parse(I value);
}
