package fhdw.ipscrum.shared.commands.metamodel.pbi;

import java.io.File;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.BugTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.productBacklog.BugCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;
import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * VariousBugCommandsTest.
 */
public class VariousBugCommandsTest {

	/**
	 * inner Variable.
	 */
	private Model model;
	/**
	 * inner Variable.
	 */
	private Release release;
	/**
	 * inner Variable.
	 */
	private Project project;

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
	 * Testcase.
	 */
	@Test
	public void bugCreateCommandTest() {
		try {
			this.project = new Project(this.model, "test");

			this.release = new Release(this.model, "version", new Date(), this.project);
			final BugTicketType type =
					new BugTicketType(this.model, "type", "type text");

			final BugCreateCommand command =
					new BugCreateCommand("Bug 1", "description", type,
							this.project.getBacklog(), this.release);
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
	public void bugTicketTypeCreateCommand() {
		try {
			final BugTicketTypeCreateCommand command =
					new BugTicketTypeCreateCommand("Bugtype 2", "description");
			command.execute(this.model);
		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
			Assert.fail("Should not happen");
		}

	}

}
