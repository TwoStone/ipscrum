package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.view.interfaces.IView;

public abstract class Presenter<T extends IView>{
	
	private final Panel parent;
	private final T myView;
	private final Event<EventArgs> finished = new Event<EventArgs>();

	public IEvent<EventArgs> getFinished() {
		return finished;
	}
	
	public Presenter(Panel parent) {
		super();
		this.parent = parent;
		this.myView = this.createView();
		this.parent.add(myView);
	}
	
	protected void finish(){
		this.finished.fire(this, new EventArgs());
	}

	protected abstract T createView();
	
	protected T getView(){
		return myView;
	}

}
