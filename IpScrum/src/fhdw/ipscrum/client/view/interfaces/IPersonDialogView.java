package fhdw.ipscrum.client.view.interfaces;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.TwoStringArgs;

/**
 * This view is used as a dialog to create or modify persons.
 */
public interface IPersonDialogView extends IView {

	/**
	 * Preset the firstname-field.
	 * @param vorname firstname as String
	 */
	public abstract void setVorname(String vorname);

	/**
	 * Preset the lastname-field.
	 * @param nachname lastname as String
	 */
	public abstract void setNachname(String nachname);

	/**
	 * Use this to define what happens when the user pushes "ok".
	 * @param args EventHandler<TwoStringArgs> two Strings: firstname, lastname
	 */
	public abstract void defineCommitEventHandler(EventHandler<TwoStringArgs> args);

	/**
	 * Use this to define what happens when the user pushes "cancel".
	 * @param args EventHandler<EventArgs> empty arguments
	 */
	public abstract void defineCancelEventHandler(EventHandler<EventArgs> args);

}