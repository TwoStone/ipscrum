/**
 * 
 */
package fhdw.ipscrum.shared.commands.admin.personRoleAdministration;

import fhdw.ipscrum.shared.model.messages.ModelTestBase;
import fhdw.ipscrum.shared.model.nonMeta.Person;

/**
 * 
 */
public class PersonTestBase extends ModelTestBase {

	/**
	 * 
	 */
	protected static final String LASTNAME = "Stark";
	/**
	 * 
	 */
	protected static final String FIRSTNAME = "Tony";
	/**
	 * person for tests.
	 */
	private Person person;

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.model.messages.ModelTestBase#setUp()
	 */
	@Override
	public void setUp() throws Exception {
		super.setUp();
		this.person = new Person(this.getModel(), PersonTestBase.FIRSTNAME, PersonTestBase.LASTNAME);
	}

	/**
	 * @return the person
	 */
	public Person getPerson() {
		return this.person;
	}
}
