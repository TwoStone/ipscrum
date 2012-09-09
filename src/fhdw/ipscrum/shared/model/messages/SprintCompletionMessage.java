package fhdw.ipscrum.shared.model.messages;

import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * A sprint, which is completed, will invoke this message.
 * 
 * @see Message
 * @author Stefan
 * 
 */
public class SprintCompletionMessage implements Message {

	/**
	 * Represents the sprint related to the message.
	 */
	private final Sprint sprint;

	/**
	 * Constructor of the SprintCompletionMessage.
	 * 
	 * @param sprint
	 *            is the related sprint
	 */
	public SprintCompletionMessage(final Sprint sprint) {
		this.sprint = sprint;
	}

	/**
	 * Getter of the related sprint.
	 * 
	 * @return the related Sprint
	 */
	public final Sprint getSprint() {
		return this.sprint;
	}

	@Override
	public void accept(final MessageVisitor v) {
		v.handleSprintCompletionMessage(this);
	}

}
