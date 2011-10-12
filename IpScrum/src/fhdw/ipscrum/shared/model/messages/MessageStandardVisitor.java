package fhdw.ipscrum.shared.model.messages;

/**
 * Represents the Visitor for standard messages.
 * 
 */
public abstract class MessageStandardVisitor implements MessageVisitor {

	/**
	 * Represents the standard handling of the visitor.
	 */
	public abstract void standardHandling();

	@Override
	public void handleTaskCompletionMessage(final TaskCompletionMessage message) {
		this.standardHandling();
	}

	@Override
	public void handlePBICompletionMessage(final PBICompletionMessage message) {
		this.standardHandling();
	}

	@Override
	public void handleReleaseCompletionMessage(final ReleaseCompletionMessage message) {
		this.standardHandling();
	}

	@Override
	public void handleSprintCompletionMessage(final SprintCompletionMessage message) {
		this.standardHandling();
	}

	@Override
	public void handleAddGlobalIncidentMessage(final AddGLobalIncidentMessage message) {
		this.standardHandling();
	}

	@Override
	public void handleRemoveGlobalIncidentMessage(final RemoveGlobalIncidentMessage message) {
		this.standardHandling();
	}

}
