/**
 * 
 */
package fhdw.ipscrum.shared.commands.admin.personRoleAdministration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.messages.ModelTestBase;
import fhdw.ipscrum.shared.model.nonMeta.Person;

/**
 * 
 */
public class PersonCreateCommandTest extends ModelTestBase {

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.model.messages.ModelTestBase#setUp()
	 */
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonCreateCommand#PersonCreateCommand(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testPersonCreateCommand() {
		final PersonCreateCommand command = new PersonCreateCommand("Xavier", "Charles Francis");
		Assert.assertNotNull(command);
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonCreateCommand#onExecute(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testOnExecuteModel() throws IPScrumGeneralException {
		final PersonCreateCommand command = new PersonCreateCommand("Xavier", "Charles Francis");
		final Person person = command.onExecute(this.getModel());
		Assert.assertEquals("Xavier", person.getLastname());
		Assert.assertEquals("Charles Francis", person.getFirstname());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonCreateCommand#accept(fhdw.ipscrum.shared.commands.visitor.CommandVisitor)}
	 * .
	 */
	@Test
	public final void testAccept() {
		final PersonCreateCommand command = new PersonCreateCommand("Xavier", "Charles Francis");
		command.accept(new CommandStandardVisitor() {

			@Override
			public void handlePersonCreateCommand(final PersonCreateCommand personCreateCommand) {

			}

			@Override
			public void standardHandling(final ICommand cmd) {
				Assert.fail();

			}
		});
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonCreateCommand#dependsOnProject()}.
	 */
	@Test
	public final void testDependsOnProject() {
		final PersonCreateCommand command = new PersonCreateCommand("Xavier", "Charles Francis");
		Assert.assertFalse(command.dependsOnProject());
	}

	/**
	 * Test method for
	 * {@link fhdw.ipscrum.shared.commands.admin.personRoleAdministration.PersonCreateCommand#getDependingProject(fhdw.ipscrum.shared.model.Model)}
	 * .
	 * 
	 * @throws NoObjectFindException
	 *             object not found
	 */
	@Test
	public final void testGetDependingProject() throws NoObjectFindException {
		final PersonCreateCommand command = new PersonCreateCommand("Xavier", "Charles Francis");
		Assert.assertNull(command.getDependingProject(this.getModel()));
	}

	/**
	 * Test method for {@link fhdw.ipscrum.shared.infrastructure.Command#execute(fhdw.ipscrum.shared.model.Model)}.
	 * 
	 * @throws IPScrumGeneralException
	 *             an error occurred
	 */
	@Test
	public final void testExecuteModel() throws IPScrumGeneralException {
		final PersonCreateCommand command = new PersonCreateCommand("Xavier", "Charles Francis");
		command.execute(this.getModel());
		final Person person = command.getResult();
		Assert.assertEquals("Xavier", person.getLastname());
		Assert.assertEquals("Charles Francis", person.getFirstname());
	}

}
