package fhdw.ipscrum.shared.commands.ticketsGeneral;

import java.io.Serializable;

import fhdw.ipscrum.shared.commands.interfaces.IProductBacklogCommand;
import fhdw.ipscrum.shared.commands.interfaces.ITaskboardCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.model.visitor.TicketVisitor;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Changes a single field.
 * 
 * @param <T>
 *            is the selected field type
 */
public abstract class SingleFieldChangeCommand<T extends Serializable> extends Command<Void>
		implements ITaskboardCommand, IProductBacklogCommand {

	/**
	 * creates the command.
	 * 
	 * @param <T>
	 *            is the attached field type
	 * @param field
	 *            related to the command
	 * @param value
	 *            of the command
	 * @param ticket
	 *            related to the command
	 * @return a SingleFieldChangeCommand of the selected type
	 */
	public static <T extends Serializable> SingleFieldChangeCommand<T> createCommand(final SingleField<T> field,
			final T value, final Ticket ticket) {
		if (value instanceof IdentifiableObject) {
			return new SingleFieldIdentifiableObjectChangeCommand<T>(field, value, ticket);
		} else {
			return new SingleFieldNonIdentifiableObjectChangeCommand<T>(field, value, ticket);
		}
	}

	/**
	 * crates the command.
	 * 
	 * @param <T>
	 *            is the selected field type
	 * @param field
	 *            related to the command
	 * @param value
	 *            of the command
	 * @param ticket
	 *            related to the command
	 * @return a SingleFieldChangeCommand with the attached field type
	 */
	public static <T extends IdentifiableObject> SingleFieldChangeCommand<T> createCommand(final SingleField<T> field,
			final T value, final Ticket ticket) {

		return new SingleFieldIdentifiableObjectChangeCommand<T>(field, value, ticket);

	}

	/**
	 * represents the related ticket.
	 */
	private String ticketId;
	/**
	 * result for getDependingProject-call.
	 */
	private Project result;

	/**
	 * Constructor of the Command without parameters.
	 */
	protected SingleFieldChangeCommand() {
		super();
	}

	/**
	 * constructor of the SingleFieldChangeCommand.
	 * 
	 * @param receiver
	 *            related to the command
	 * @param ticket
	 *            related to the command
	 */
	protected SingleFieldChangeCommand(final IdentifiableObject receiver, final Ticket ticket) {
		super(receiver);
		this.ticketId = ticket.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final SingleField<T> singleField = (SingleField<T>) model.getObject(this.getReceiverGuid());
		final Ticket ticket = (Ticket) model.getObject(this.ticketId);
		final T value = this.getValue(model);
		this.setStringValue(StringUtils.format("Wertänderung im Ticket '%s': %s -> %s.", ticket.getName(),
				singleField.getValue(), value));
		singleField.setValue(value, ticket);
		return null;
	}

	/**
	 * getter of the value.
	 * 
	 * @param model
	 *            related to the command
	 * @return the value in the chosen type
	 * @throws NoObjectFindException
	 *             if no object is found
	 */
	public abstract T getValue(Model model) throws NoObjectFindException;

	@Override
	public boolean dependsOnProject() {
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.interfaces.ICommand#getDependingProject(fhdw.ipscrum .shared.model.Model)
	 */
	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		final Ticket ticket = (Ticket) model.getObject(this.ticketId);
		ticket.accept(new TicketVisitor() {

			@Override
			public void handleTask(final Task task) {
				SingleFieldChangeCommand.this.setResult(task.getProject());
			}

			@Override
			public void handlePBI(final ProductBacklogItem pbi) {
				SingleFieldChangeCommand.this.setResult(pbi.getProject());

			}
		});
		return this.result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.interfaces.ICommand#accept(fhdw.ipscrum.shared.commands
	 * .visitor.CommandVisitor)
	 */
	@Override
	public void accept(final CommandVisitor visitor) throws NoObjectFindException {
		visitor.handleSingleFieldChangeCommand(this);
	}

	/**
	 * sets the project as result of a visitor-call.
	 * 
	 * @param result
	 *            {@link Project}
	 */
	private void setResult(final Project result) {
		this.result = result;
	}

	/**
	 * returns the receiver ticket.
	 * 
	 * @param model
	 *            the model.
	 * @return ticket that belongs to the field.
	 * @throws NoObjectFindException
	 *             if no ticket was found.
	 */
	public Ticket getTicket(final Model model) throws NoObjectFindException {
		return (Ticket) model.getObject(this.ticketId);
	}

}
