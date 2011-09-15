package fhdw.ipscrum.shared.commands.admin;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.AbstractSystem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Rootsystem;
import fhdw.ipscrum.shared.model.nonMeta.System;

/**
 * The class <code>SystemCreateCommandTest</code> contains tests for the class
 * <code>{@link SystemCreateCommand}</code>.
 */
public class SystemCreateCommandTest {

	/**
	 * represents the model needed for the use of the IPScrum.
	 */
	private Model model;

	/**
	 * sets up the date before evey test.
	 * 
	 * @throws Exception
	 *             if the use of one of the methods fails
	 */
	@Before
	public void setUp() throws Exception {
		TestUtils.deleteFolderContent(new File("output"));
		ServerContext.resetServerContext();
		this.model =
				ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		this.model.setUuidManager(new IDGenerator());
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
		final SystemCreateCommand result = new SystemCreateCommand(name, this.model);
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
		final AbstractSystem parent = new Rootsystem(this.model);

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
		final SystemCreateCommand fixture =
				new SystemCreateCommand("", new Rootsystem(this.model));
		final CommandVisitor v = null;

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
		final SystemCreateCommand fixture =
				new SystemCreateCommand("", new Rootsystem(this.model));

		final boolean result = fixture.dependsOnProject();
		Assert.assertTrue(result);
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
		final SystemCreateCommand fixture =
				new SystemCreateCommand("", new Rootsystem(this.model));

		final Project result = fixture.getDependingProject(this.model);
		Assert.assertNotNull(result);
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
		final SystemCreateCommand fixture =
				new SystemCreateCommand("", new Rootsystem(this.model));

		final System result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the System onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testOnExecute2() throws Exception {
		final SystemCreateCommand fixture =
				new SystemCreateCommand("", new Rootsystem(this.model));

		final System result = fixture.onExecute(this.model);
		Assert.assertNotNull(result);
	}

	/**
	 * Run the System onExecute(Model) method test.
	 * 
	 * @throws Exception
	 *             Exception
	 * 
	 */
	@Test
	public void testOnExecute3() throws Exception {
		final SystemCreateCommand fixture =
				new SystemCreateCommand("", new Rootsystem(this.model));

		final System result = fixture.onExecute(this.model);

		// add additional test code here
		// An unexpected exception was thrown in user code while executing this test:
		// java.lang.NullPointerException
		// at
		// fhdw.ipscrum.shared.infrastructure.IdentifiableObject.<init>(IdentifiableObject.java:89)
		// at
		// fhdw.ipscrum.shared.model.nonMeta.AbstractSystem.<init>(AbstractSystem.java:33)
		// at fhdw.ipscrum.shared.model.nonMeta.Rootsystem.<init>(Rootsystem.java:37)
		Assert.assertNotNull(result);
	}
}
