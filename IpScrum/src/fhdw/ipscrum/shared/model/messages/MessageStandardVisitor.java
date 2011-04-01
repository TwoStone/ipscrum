package fhdw.ipscrum.shared.model.messages;

public abstract class MessageStandardVisitor implements MessageVisitor {
	
	public abstract void standardHandling();
	
	@Override
	public void handleTaskCompletionMessage(TaskCompletionMessage message) {
		this.standardHandling();
	}

	@Override
	public void handlePBICompletionMessage(PBICompletionMessage message) {
		this.standardHandling();
	}

	@Override
	public void handleReleaseCompletionMessage(ReleaseCompletionMessage message) {
		this.standardHandling();
	}

	@Override
	public void handleSprintCompletionMessage(SprintCompletionMessage message) {
		this.standardHandling();
	}

	@Override
	public void handleAddGlobalIncidentMessage(AddGLobalIncidentMessage message) {
		this.standardHandling();
	}
	
	@Override
	public void handleRemoveGlobalIncidentMessage(RemoveGlobalIncidentMessage message){
		this.standardHandling();
	}

}
