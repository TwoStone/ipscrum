package fhdw.ipscrum.shared.model.messages;

public interface MessageVisitor {
	public void handleTaskCompletionMessage(TaskCompletionMessage message);
	public void handlePBICompletionMessage(PBICompletionMessage message);
	public void handleReleaseCompletionMessage(ReleaseCompletionMessage message);
	public void handleSprintCompletionMessage(SprintCompletionMessage message);
	public void handleAddGlobalIncidentMessage(AddGLobalIncidentMessage message);
}
