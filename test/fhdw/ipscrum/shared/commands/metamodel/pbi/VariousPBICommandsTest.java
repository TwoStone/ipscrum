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
import fhdw.ipscrum.shared.commands.productBacklog.PBIAddRelationCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIPriorityDecreaseCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIPriorityIncreaseCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIRemoveRelationCommand;
import fhdw.ipscrum.shared.commands.productBacklog.RelationTypeCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.nonMeta.Bug;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Relation;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;
import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * various test cases for general pbi purposes.
 */
public class VariousPBICommandsTest {

	/**
	 * inner Variable.
	 */
	private Model model;
	/**
	 * inner Variable.
	 */
	private Bug bug;
	/**
	 * inner Variable.
	 */
	private Feature feature;
	/**
	 * inner Variable.
	 */
	private Release release;
	/**
	 * inner Variable.
	 */
	private Project project;
	/**
	 * inner Variable.
	 */
	private Relation relation;

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

			this.project = new Project(this.model, "test");
			this.release = new Release(this.model, "version", new Date(), this.project);
			final BugTicketType ticketType = new BugTicketType(this.model, "Bugtype 1", "description");
			this.bug = new Bug(this.model, ticketType, "Bug 1", "description", this.project.getBacklog(), this.release);

			final FeatureTicketType type = new FeatureTicketType(this.model, "Featuertype 1", "description");
			this.feature = new Feature(this.model, type, "feature 1", "description", this.project.getBacklog());
			this.relation = new Relation(this.model, this.model.getAllRelationTypes().get(0), this.feature);

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
	 * test case to add a relation to a feature.
	 */
	@Test
	public void executePBIAddRelationCommandTest() {
		try {
			final PBIAddRelationCommand command = new PBIAddRelationCommand(this.bug, this.relation);
			command.execute(this.model);
		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
			Assert.fail("Should not happen");
		}
	}

	/**
	 * test case to decrease priority.
	 */
	@Test
	public void executePBIPriorityDecreaseCommandTest() {
		try {

			final PBIPriorityDecreaseCommand command = new PBIPriorityDecreaseCommand(this.bug);
			command.execute(this.model);
		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
			Assert.fail("Should not happen");
		}
	}

	/**
	 * test case to increase priority.
	 */
	@Test
	public void executePBIPriorityIncreaseCommandTest() {
		try {

			final PBIPriorityIncreaseCommand command = new PBIPriorityIncreaseCommand(this.bug);
			command.execute(this.model);
		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
			Assert.fail("Should not happen");
		}
	}

	/**
	 * test case to remove relation. need execution of executePBIAddRelationCommandTest before
	 */
	@Test
	public void executePBIRemoveRelationCommandTest() {
		try {
			final PBIRemoveRelationCommand command = new PBIRemoveRelationCommand(this.bug, this.relation);
			command.execute(this.model);
		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
			Assert.fail("Should not happen, check if test case executePBIAddRelationCommandTest was executed");
		}
	}

	/**
	 * test case to set sprint relation.
	 */
	@Test
	public void executeRelationTypeCreateCommandTest() {
		try {
			final RelationTypeCreateCommand command = new RelationTypeCreateCommand("title");
			command.execute(this.model);
		} catch (final IPScrumGeneralException e) {
			e.printStackTrace();
			Assert.fail("Should not happen");
		}
	}
}
