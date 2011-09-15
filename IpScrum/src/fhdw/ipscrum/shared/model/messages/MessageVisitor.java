package fhdw.ipscrum.shared.model.messages;

/**
 * Represents the visitor for handling all messages.
 * 
 */
public interface MessageVisitor {

	/**
	 * Needed for handling TaskCompletionMessages.
	 * 
	 * @param message
	 *            that is affected.
	 */
	void handleTaskCompletionMessage(TaskCompletionMessage message);

	/**
	 * Needed for handling PBICompletionMessages.
	 * 
	 * @param message
	 *            that is affected
	 */
	void handlePBICompletionMessage(PBICompletionMessage message);

	/**
	 * Needed for handling ReleaseCompletionMessages.
	 * 
	 * @param message
	 *            that is affected
	 */
	void handleReleaseCompletionMessage(ReleaseCompletionMessage message);

	/**
	 * Needed for handling SprintCompletionMessages.
	 * 
	 * @param message
	 *            that is affected
	 */
	void handleSprintCompletionMessage(SprintCompletionMessage message);

	/**
	 * Needed for handling AddGlobalIncidentMessages.
	 * 
	 * @param message
	 *            that is affected
	 */
	void handleAddGlobalIncidentMessage(AddGLobalIncidentMessage message);

	/**
	 * Needed for handling RemoveGlobalIncidentMessages.
	 * 
	 * @param message
	 *            That is affected
	 */
	void handleRemoveGlobalIncidentMessage(RemoveGlobalIncidentMessage message);
}
