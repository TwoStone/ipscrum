package fhdw.ipscrum.shared.commands.admin.ticketTypes;

import fhdw.ipscrum.shared.commands.interfaces.ITicketTypesCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Adds a field type to a ticket type.
 */
public class TicketTypeAddFieldTypeCommand extends Command<Void> implements ITicketTypesCommand {

	/**
	 * represents the related field type.
	 */
	private String fieldTypeId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private TicketTypeAddFieldTypeCommand() {
		super();
	}

	/**
	 * constructor of the TicketTypeAddFieldCommand.
	 * 
	 * @param receiver
	 *            : ticket type related to the command
	 * @param fieldType
	 *            : field type related to the command
	 */
	public TicketTypeAddFieldTypeCommand(final TicketType receiver, final FieldType fieldType) {
		super(receiver);
		this.fieldTypeId = fieldType.getId();
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final TicketType tickettype = (TicketType) model.getObject(this.getReceiverGuid());
		final FieldType fieldType = (FieldType) model.getObject(this.fieldTypeId);

		this.setStringValue(StringUtils.format("Dem Tickettypen %s wurde der Feldtyp %s hinzugefügt.",
				tickettype.getTypeName(), fieldType.getName()));

		tickettype.addFieldType(fieldType);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleTicketTypeAddFieldTypeCommand(this);
	}

	@Override
	public boolean dependsOnProject() {
		return false;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		return null;
	}

}
