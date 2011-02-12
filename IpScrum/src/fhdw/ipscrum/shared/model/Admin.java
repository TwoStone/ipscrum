package fhdw.ipscrum.shared.model;

import fhdw.ipscrum.shared.model.interfaces.IPerson;


/**
 * This class represents the administrator user and is realized as a singleton.
 *
 */
public final class Admin extends Person implements IPerson {
	private static Admin instance;

	/** private constructor. prevents class from being instantiated externally. */
	private Admin() {
		super("Admin", "Administrator");
	}

	/**
	 * static method "getInstance()" returns the single instance of this class.
	 * synchronized and therefore thread-safe.
	 */
	public synchronized static Admin getInstance() {
		if (instance == null) {
			instance = new Admin();
		}
		return instance;
	}
}
