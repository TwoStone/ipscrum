package fhdw.ipscrum.client.view.interfaces;

import java.util.Collection;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SystemArgs;
import fhdw.ipscrum.shared.model.System;

/**
 * interface of the view class for systems. this view is used to select systems of an amount of available systems.
 */
public interface ISelectSystemView extends IView {

	/**
	 * @return the currently selected System of the available Systems
	 */
	public abstract System getSelectedOfAvailableSystems();

	/**
	 * This method is used to update or fill the entries of the team display.
	 * 
	 * @param selectedSystems a collection of the selected systems to be displayed.
	 */
	public abstract void updateSelectedSystemData(Collection<System> selectedSystems);

	/**
	 * This method is used to update or fill the entries of the person display.
	 * 
	 * @param availableSystems a collection of the available systems to be displayed.
	 */
	public abstract void updateAvailableSystemData(Collection<System> availableSystems);

	/**
	 * use this method to define the action of the remove-system-from-selected-systems-button.
	 * 
	 * @param args empty arguments
	 */
	public abstract void defineRemoveSelectedSystemEvent(EventHandler<SystemArgs> args);

	/**
	 * use this method to define the action of the add-system-from-selected-systems-button.
	 * 
	 * @param args empty arguments
	 */
	public abstract void defineAddSelectedSystemEvent(EventHandler<SystemArgs> args);
}