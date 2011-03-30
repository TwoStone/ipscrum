package fhdw.ipscrum.shared.model.messages;

import fhdw.ipscrum.shared.model.interfaces.IRelease;

public class ReleaseCompletionMessage implements Message {
	private final IRelease release;
	public ReleaseCompletionMessage(final IRelease release){
		this.release = release;
	}
	public final IRelease getRelease(){
		return this.release;
	}
	@Override
	public void accept(MessageVisitor v) {
		v.handleReleaseCompletionMessage(this);
	}
	@Override
	public void accept(MessageStandardVisitor v) {
		v.handleReleaseCompletionMessage(this);
	}

}
