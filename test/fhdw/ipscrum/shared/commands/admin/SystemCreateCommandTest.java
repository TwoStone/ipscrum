package fhdw.ipscrum.shared.commands.admin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.model.messages.ModelTestBase;
import fhdw.ipscrum.shared.model.nonMeta.AbstractSystem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Rootsystem;
import fhdw.ipscrum.shared.model.nonMeta.System;

/**
 * The class <code>SystemCreateCommandTest</code> contains tests for the class <code>{@link SystemCreateCommand}</code>.
 */
public class SystemCreateCommandTest extends ModelTestBase {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	/**
	 * Run the SystemCreateCommand(String,Model) constructor test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testSystemCreateCommand1() throws Exception {
		final String name = "";
		final SystemCreateCommand result = new SystemCreateCommand(name, this.getModel());
		Assert.assertNotNull(result);
	}

	/**
	 * Run the SystemCreateCommand(String,AbstractSystem) constructor test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testSystemCreateCommand2() throws Exception {
		final String name = "";
		final AbstractSystem parent = new Rootsystem(this.getModel());

		final SystemCreateCommand result = new SystemCreateCommand(name, parent);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the void accept(CommandVisitor) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testAccept1() throws Exception {
		final SystemCreateCommand fixture = new SystemCreateCommand("", new Rootsystem(this.getModel()));
		final CommandVisitor v = new CommandStandardVisitor() {

			@Override
			public void standardHandling(final ICommand command) {

			}
		};

		fixture.accept(v);
	}

	/**
	 * Run the boolean dependsOnProject() method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testDependsOnProject1() throws Exception {
		final SystemCreateCommand fixture = new SystemCreateCommand("", new Rootsystem(this.getModel()));

		final boolean result = fixture.dependsOnProject();
		Assert.assertFalse(result);
	}

	/**
	 * Run the Project getDependingProject(Model) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testGetDependingProject1() throws Exception {
		final SystemCreateCommand fixture = new SystemCreateCommand("", new Rootsystem(this.getModel()));

		final Project result = fixture.getDependingProject(this.getModel());
		Assert.assertNull(result);
	}

	/**
	 * Run the System onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testOnExecute1() throws Exception {
		final SystemCreateCommand fixture = new SystemCreateCommand("Test", new Rootsystem(this.getModel()));

		final System result = fixture.onExecute(this.getModel());
		Assert.assertEquals("Test", result.getName());
	}

	/**
	 * Run the System onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testExecute() throws Exception {
		final SystemCreateCommand fixture =
				new SystemCreateCommand("ExecuteTestSystem", new Rootsystem(this.getModel()));

		fixture.execute(this.getModel());
		final System result = fixture.getResult();
		Assert.assertEquals("ExecuteTestSystem", result.getName());
	}
}
