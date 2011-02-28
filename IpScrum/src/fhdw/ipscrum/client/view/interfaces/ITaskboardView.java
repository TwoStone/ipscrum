package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;

public interface ITaskboardView extends IView{

	void addSelectSprintHandler(EventHandler<SprintArgs> arg);

}