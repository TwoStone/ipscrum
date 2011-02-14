package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public interface IAddSprintToReleaseView extends IView{

	public abstract Button getBtnSave();

	public abstract Button getBtnAbort();

	public abstract Label getLblRelease();

	public abstract void addSaveSprintsEventHandler(EventHandler<SprintArgs> arg);

	public abstract void addCancelAddSprintViewEventHandler(
			EventHandler<EventArgs> arg);

	public abstract void refreshSprints(Vector<ISprint> sprints);

}