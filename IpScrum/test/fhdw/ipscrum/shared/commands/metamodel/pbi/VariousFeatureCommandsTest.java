package fhdw.ipscrum.shared.commands.metamodel.pbi;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.BugTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.productBacklog.FeatureCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;

/**
 * VariousFeatureCommandsTest.
 */
public class VariousFeatureCommandsTest {

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
		this.model =
				ServerContext.getInstance().getPersistenceManager().getCurrentModel();
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
	 * Testcase for creating.
	 */
	@Test
	public void featureCreateCommandTest() {
		Project project;
		try {
			project = new Project(this.model, "test");

			final String name = "name";
			final String description = "text";
			final FeatureTicketType type =
					new FeatureTicketType(this.model, "type", "type testtext");
			final FeatureCreateCommand command =
					new FeatureCreateCommand(name, description, type,
							project.getBacklog());

			command.execute(this.model);
		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
			Assert.fail("Should not happen");
		}

	}

	/**
	 * Testcase to create Tickettype.
	 */
	@Test
	public void featureTicketTypeCreateCommandTest() {
		try {
			final BugTicketTypeCreateCommand command =
					new BugTicketTypeCreateCommand("Tickettype", "description");
			command.execute(this.model);
		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
			Assert.fail("Should not happen");
		}

	}

}
