package fhdw.ipscrum.client.architecture.events;

/**
 * represents an eventArg revering to a special type.
 * 
 * @param <T>
 *            the eventArg reveres to
 */
public class TypedEventArg<T> extends EventArgs {

	/**
	 * the concrete object the argument reveres to.
	 */
	private final T object;

	/**
	 * constructor of the TypedEventArgument.
	 * 
	 * @param object
	 *            it reveres to
	 */
	public TypedEventArg(final T object) {
		super();
		this.object = object;
	}

	/**
	 * getter of the object of the event argument.
	 * 
	 * @return the current object
	 */
	public T getObject() {
		return this.object;
	}
}
