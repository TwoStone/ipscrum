package fhdw.ipscrum.shared.model.messages;

import fhdw.ipscrum.shared.model.interfaces.ITask;

public class TaskCompletionMessage implements Message {
	
	private final ITask task;
	
	public TaskCompletionMessage(ITask task){
		this.task = task;
	}
	
	public final ITask getTask(){
		return this.task;
	}
	
	public void accept(MessageVisitor v){
		v.handleTaskCompletionMessage(this);
	}

	@Override
	public void accept(MessageStandardVisitor v) {
		v.handleTaskCompletionMessage(this);
	}
}
