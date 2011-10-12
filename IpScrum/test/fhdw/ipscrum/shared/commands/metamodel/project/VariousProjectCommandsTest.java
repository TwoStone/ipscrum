package fhdw.ipscrum.shared.commands.metamodel.project;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.commands.project.ProjectCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;

/**
 * Tests project commands.
 */
public class VariousProjectCommandsTest {

	/**
	 * inner Variable.
	 */
	private Model model;

	/**
	 * Perform pre-test initialization.
	 * 
	 * @throws Exception
	 *             if the initialization fails for some reason
	 */
	@Before
	public void setUp() throws Exception {
		TestUtils.deleteFolderContent(new File("output"));
		ServerContext.resetServerContext();
		this.model = ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		this.model.setUuidManager(new IDGenerator());
		try {
			new RelationType(this.model, "Abhängig von");
			new RelationType(this.model, "Siehe auch");

		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Set up test data.
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBefore() {

	}

	/**
	 * Testcase.
	 */
	@Test
	public void bugCreateCommandTest() {
		try {

			final ProjectCreateCommand command = new ProjectCreateCommand("wannabe");
			command.execute(this.model);
		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
			Assert.fail("Should not happen");
		}

	}

}
