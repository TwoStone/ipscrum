package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PBIArgs;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.events.args.TaskArgs;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Task;

public interface ITaskboardView extends IView{

	void addSelectSprintHandler(EventHandler<SprintArgs> arg);

	void refreshPBIs(Vector<ProductBacklogItem> pbis);

	ProductBacklogItem getSelectedPBI();

	void addNewTaskEventHandler(EventHandler<PBIArgs> arg);

	void addDeleteTaskEventHandler(EventHandler<TaskArgs> arg);

	void addEditTaskEventHandler(EventHandler<TaskArgs> arg);

	void addPrioTopEventHandler(EventHandler<PBIArgs> arg);

	void addPrioUpEventHandler(EventHandler<PBIArgs> arg);

	void addPrioDownEventHandler(EventHandler<PBIArgs> arg);

	void addPrioBottomEventHandler(EventHandler<PBIArgs> arg);

	void refreshTodoTasks(Vector<Task> tasks);

	void refreshInProgressTasks(Vector<Task> tasks);

	void refreshDoneTasks(Vector<Task> tasks);

	Task getSelectedDoneTask();

	Task getSelectedInProgressTask();

	Task getSelectedTodoTask();

}