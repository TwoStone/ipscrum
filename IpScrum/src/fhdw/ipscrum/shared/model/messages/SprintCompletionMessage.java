package fhdw.ipscrum.shared.model.messages;

import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * A sprint, which is completed, will invoke this message.
 * @see Message
 * @author Stefan
 *
 */
public class SprintCompletionMessage implements Message {

	private final ISprint sprint;
	
	public SprintCompletionMessage(final ISprint sprint){
		this.sprint = sprint;
	}
	public final ISprint getSprint(){
		return this.sprint;
	}
	@Override
	public void accept(MessageVisitor v) {
		v.handleSprintCompletionMessage(this);
	}
	@Override
	public void accept(MessageStandardVisitor v) {
		v.handleSprintCompletionMessage(this);
	}
}
