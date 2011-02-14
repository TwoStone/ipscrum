package fhdw.ipscrum.shared.model;

import com.google.gwt.user.client.Window;

import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

/**
 * This class represents the administrator user and is realized as a singleton.
 * 
 */
public final class Admin extends Person implements IPerson {
	private static Admin instance;

	/**
	 * private constructor. prevents class from being instantiated externally.
	 * 
	 * @throws NoValidValueException
	 */
	private Admin() throws NoValidValueException {
		super("Admin", "Administrator");
	}

	/**
	 * static method "getInstance()" returns the single instance of this class.
	 * synchronized and therefore thread-safe.
	 */
	public synchronized static Admin getInstance() {
		if (instance == null) {
			try {
				instance = new Admin();
			} catch (NoValidValueException e) {
				Window.alert(e.getMessage());
			}
		}
		return instance;
	}

	@Override
	public String toString() {
		return this.getLastname();
	}
}
