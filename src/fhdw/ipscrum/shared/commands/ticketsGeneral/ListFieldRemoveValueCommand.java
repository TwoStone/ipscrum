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
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.model.visitor.TicketVisitor;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * removes a value from a list field.
 * 
 * @param <T>
 *            is the attached field type
 */
public abstract class ListFieldRemoveValueCommand<T extends Serializable> extends Command<Void>
		implements ITaskboardCommand, IProductBacklogCommand {

	/**
	 * creates a command.
	 * 
	 * @param <T>
	 *            field type attached to the command
	 * @param field
	 *            related to the command
	 * @param value
	 *            of the command
	 * @param ticket
	 *            related to the command
	 * @return a ListFieldRemoveCommand with the attached type
	 */
	public static <T extends Serializable> ListFieldRemoveValueCommand<T> createCommand(final ListField<T> field,
			final T value, final Ticket ticket) {
		if (value instanceof IdentifiableObject) {
			return new ListFieldIdentifiableObjectRemoveValueCommand<T>(field, value, ticket);
		} else {
			return new ListFieldNonIdentifiableObjectRemoveValueCommand<T>(field, value, ticket);
		}
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
	protected ListFieldRemoveValueCommand() {
		super();
	}

	/**
	 * constructor of the ListFieldRemoveValueCommand.
	 * 
	 * @param receiver
	 *            related to the command
	 * @param ticket
	 *            related to the command
	 */
	protected ListFieldRemoveValueCommand(final IdentifiableObject receiver, final Ticket ticket) {
		super(receiver);
		this.ticketId = ticket.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final ListField<T> listField = (ListField<T>) model.getObject(this.getReceiverGuid());
		final T value = this.getValue(model);
		final Ticket ticket = (Ticket) model.getObject(this.ticketId);
		this.setStringValue(StringUtils.format("Wertänderung im Ticket '%s': %s entfernt.", ticket.getName(), value));
		listField.removeValue(value, ticket);
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
				ListFieldRemoveValueCommand.this.setResult(task.getProject());
			}

			@Override
			public void handlePBI(final ProductBacklogItem pbi) {
				ListFieldRemoveValueCommand.this.setResult(pbi.getProject());

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
		visitor.handleListFieldRemoveValueCommand(this);
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
	 * Returns the ticket that belongs to the field-change-command.
	 * 
	 * @param model
	 *            the model.
	 * @return {@link Ticket}
	 * @throws NoObjectFindException
	 *             if no ticket can be found.
	 */
	public Ticket getTicket(final Model model) throws NoObjectFindException {
		return (Ticket) model.getObject(this.ticketId);
	}

}
