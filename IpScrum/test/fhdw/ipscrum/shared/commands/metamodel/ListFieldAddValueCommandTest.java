package fhdw.ipscrum.shared.commands.metamodel;

import java.io.File;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.commands.ticketsGeneral.ListFieldAddValueCommand;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.fields.TextFieldType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;

/**
 * Tests the ListFieldAddvalueCommand.
 */
public class ListFieldAddValueCommandTest {

	/**
	 * Represents the model needed to use the IPScrum.
	 */
	private Model model;

	/**
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Before
	public void setUpBefore() throws Exception {
		TestUtils.deleteFolderContent(new File("output"));
		ServerContext.resetServerContext();
		this.model = ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		this.model.setUuidManager(new IDGenerator());
		new RelationType(this.model, "Abhängig von");
		new RelationType(this.model, "Siehe auch");
	}

	/**
	 * @return the model related to the test.
	 */
	public Model getModel() {
		return this.model;
	}

	/**
	 * Tests the command.
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@Test
	public void test() throws Exception {
		final FeatureTicketType type = new FeatureTicketType(this.model, "ExtendedFeature", "");
		final FieldType ft = new TextFieldType(this.model, "name", this.model.getTypeManager().getMany());
		type.addFieldType(ft);
		type.setActive(this.model.getTypeManager().getOpen(), ft);
		final ListField<String> field = new ListField<String>(this.getModel(), ft);
		final Project project = new Project(this.model, "Das tolle Projekt");
		final Ticket ticket = new Feature(this.model, type, "neuer Bug", "", project.getBacklog());

		final String value = "abc";
		final ListFieldAddValueCommand<String> command =
				ListFieldAddValueCommand.<String> createCommand(field, value, ticket);
		command.execute(this.model);
		Assert.assertEquals(1, field.getValues().size());
		Assert.assertEquals(value, field.getValues().get(0));

	}
}
