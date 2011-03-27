package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ProjectEventArgs;


/**
 * view class of the report interface. this interface is to inspect
 * statistical data regarding the sprint-/release progress (burn-down-charts)
 */
public interface IReportView extends IView{

	/**
	 * Use this method to add a handler for the selectProjectEvent
	 * 
	 * @param EventHandler
	 *            <ProjectEventArgs> arg
	 */
	void addSelectProjectEventHandler(EventHandler<ProjectEventArgs> arg);

	
	//TODO Kommentar schreiben
	Panel getContentPanel();
	
	
}