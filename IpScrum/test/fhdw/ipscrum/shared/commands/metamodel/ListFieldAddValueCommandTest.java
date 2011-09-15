package fhdw.ipscrum.shared.commands.metamodel;

import java.io.File;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.client.IDGenerator;
import fhdw.ipscrum.server.ServerContext;
import fhdw.ipscrum.server.TestUtils;
import fhdw.ipscrum.shared.exceptions.model.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldTypeVisitor;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.RelationType;
import fhdw.ipscrum.shared.model.visitor.TicketVisitor;

public class ListFieldAddValueCommandTest {

	protected Model model;

	/**
	 * 
	 * @throws Exception
	 *             if one of the used methods fails
	 */
	@BeforeClass
	public void setUpBeforeClass() throws Exception {
		TestUtils.deleteFolderContent(new File("output"));
		ServerContext.resetServerContext();
		this.model =
				ServerContext.getInstance().getPersistenceManager().getCurrentModel();
		this.model.setUuidManager(new IDGenerator());
		new RelationType(this.model, "Abhängig von");
		new RelationType(this.model, "Siehe auch");
	}

	public Model getModel() {
		return this.model;
	}

	@Test
	public void test() {
		@SuppressWarnings("serial")
		final FieldType type = new FieldType() {

			@Override
			protected SingleField<?> createSingleField() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			protected ListField<?> createListField() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void accept(final FieldTypeVisitor v) {
				// TODO Auto-generated method stub

			}

		};

		@SuppressWarnings("rawtypes")
		final ListField field = new ListField(this.getModel(), type);
		@SuppressWarnings("serial")
		final Ticket ticket = new Ticket() {

			@Override
			public Project getProject() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			protected void checkNameValidity(final String name)
					throws NoValidValueException, DoubleDefinitionException,
					ConsistencyException {
				// TODO Auto-generated method stub

			}

			@Override
			protected void checkDescriptionValidity(final String description)
					throws NoValidValueException {
				// TODO Auto-generated method stub

			}

			@Override
			public void accept(final TicketVisitor visitor) {
				// TODO Auto-generated method stub

			}
		};
		// final ListFieldAddValueCommand command =
		// ListFieldAddValueCommand.createCommand(field, value, ticket);
		// command.execute(model);
		Assert.assertNotNull(ticket);
		Assert.assertNotNull(field);
		Assert.assertNotNull(type);
		Assert.fail("Not yet implemented");

	}

}
