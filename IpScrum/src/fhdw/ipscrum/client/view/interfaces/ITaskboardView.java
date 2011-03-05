package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.MultiplePBIArgs;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.events.args.TaskArgs;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public interface ITaskboardView extends IView{


	void refreshPBIs(Vector<ProductBacklogItem> pbis);

	void refreshTodoTasks(Vector<ITask> tasks);

	void refreshInProgressTasks(Vector<ITask> tasks);

	void refreshDoneTasks(Vector<ITask> tasks);

	public void setTaskboardVisibility(Boolean visible);

	void addNewTaskEventHandler(EventHandler<MultiplePBIArgs> arg);

	void addDeleteTaskEventHandler(EventHandler<TaskArgs> arg);

	void addEditToDoTaskEventHandler(EventHandler<TaskArgs> arg);

	void addSelectSprintEventHandler(EventHandler<SprintArgs> arg);

	void addEditInProgressTaskEventHandler(EventHandler<TaskArgs> arg);

	void addDetailsFinishEventHandler(EventHandler<TaskArgs> arg);

	
}