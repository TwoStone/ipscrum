package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PBIArgs;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

public interface ITaskboardView extends IView{

	void addSelectSprintHandler(EventHandler<SprintArgs> arg);

	void refreshPBIs(Vector<ProductBacklogItem> pbis);

	ProductBacklogItem getSelectedPBI();

	void addNewTaskEventHandler(EventHandler<PBIArgs> arg);

}