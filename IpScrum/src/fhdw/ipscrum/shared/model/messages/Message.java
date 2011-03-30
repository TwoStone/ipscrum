package fhdw.ipscrum.shared.model.messages;

/**
 * Messages represent the most basic events
 * which can befall an object. You can pass a message-instance of 
 * a class which implements this interface 
 * to a notifyObservers call, such as
 * {@code notifyObservers(new ConcreteMessage(someData));}
 * All observers are able to react to this messages.
 * See also {@link MessageVisitor}.
 * @author Stefan
 * @date 30.03.2011
 */
public interface Message {
	public void accept(MessageVisitor v);
	public void accept(MessageStandardVisitor v);
}
