package fhdw.ipscrum.shared.session;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.model.nonMeta.Person;

/**
 * Represents the User that could login at IPScrum.
 * 
 */
public class User implements IsSerializable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7603071641972585095L;

	/**
	 * Represents the name of the user.
	 */
	private String name;

	/**
	 * Represents the person related to the user.
	 */
	private Person person;

	/**
	 * Constructor of the user without parameters.
	 */
	private User() {
		super();
	}

	/**
	 * Constructor of the user.
	 * 
	 * @param name
	 *            of the user
	 * @param person
	 *            related to the user
	 */
	public User(final String name, final Person person) {
		this();
		this.name = name;
		this.person = person;
	}

	/**
	 * Getter for the name of the user.
	 * 
	 * @return name of the user
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getter for the person related to the user.
	 * 
	 * @return person related to the user
	 */
	public Person getPerson() {
		return this.person;
	}

	/**
	 * Updates the person object.
	 * 
	 * @param object
	 *            the new person from the actual model
	 */
	public void updatePerson(final Person object) {
		this.person = object;
	}
}
