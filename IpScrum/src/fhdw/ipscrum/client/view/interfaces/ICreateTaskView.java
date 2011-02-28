package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public interface ICreateTaskView extends IView{

	public abstract Button getBtnOK();

	public abstract ListBox getComboBox();

	public abstract Button getBtnAbort();

	public abstract TextBox getTextBox();

	public abstract void refreshNameBox(Vector<IPerson> vector);

	void addSaveNewTaskEventHandler(EventHandler<EventArgs> arg);

	void addCancelNewTaskEventHandler(EventHandler<EventArgs> arg);

}