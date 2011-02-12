package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.datepicker.client.DateBox;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;

/**
 */
public interface ISprintDialogView extends IView{

	/**
	 * Method getStart.
	 * @return DateBox
	 */
	public abstract DateBox getStart();

	/**
	 * Method getEnd.
	 * @return DateBox
	 */
	public abstract DateBox getEnd();

	/**
	 * Method getTeams.
	 * @return ListBox
	 */
	public abstract ListBox getTeams();
	
	/**
	 * Method getDescription.
	 * @return HasText
	 */
	public abstract HasText getDescription();

	/**
	 * Method addOkHandler.
	 * @param args EventHandler<SprintArgs>
	 */
	public abstract void addOkHandler(EventHandler<SprintArgs> args);

	/**
	 * Method addCancelHandler.
	 * @param args EventHandler<EventArgs>
	 */
	public abstract void addCancelHandler(EventHandler<EventArgs> args);

}