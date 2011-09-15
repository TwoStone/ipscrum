package fhdw.ipscrum.shared.commands.admin.ticketTypes;

import fhdw.ipscrum.shared.commands.interfaces.ITicketTypesCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Change the activity of a ticket type.
 */
public class TicketTypeSetFieldTypeActivityCommand extends Command<Void>
		implements ITicketTypesCommand {

	/**
	 * represents the visibility of the field.
	 */
	private Boolean visible;

	/**
	 * represents the related field type.
	 */
	private String fieldTypeId;

	/**
	 * represents the related state type.
	 */
	private String stateTypeId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private TicketTypeSetFieldTypeActivityCommand() {
		super();
	}

	/**
	 * constructor of the TicketTypeSetFieldTypeActivityCommand.
	 * 
	 * @param receiver
	 *            related to the command
	 * @param fieldType
	 *            related to the command
	 * @param stateType
	 *            related to the command
	 * @param visible
	 *            of the related field
	 */
	public TicketTypeSetFieldTypeActivityCommand(final TicketType receiver,
			final FieldType fieldType, final StateType stateType, final Boolean visible) {
		super(receiver);
		this.fieldTypeId = fieldType.getId();
		this.stateTypeId = stateType.getId();
		this.visible = visible;
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final TicketType tickettype =
				(TicketType) model.getObject(this.getReceiverGuid());
		final FieldType fieldType = (FieldType) model.getObject(this.fieldTypeId);
		final StateType stateType = (StateType) model.getObject(this.stateTypeId);

		String visibleString;
		if (this.visible.booleanValue()) {
			visibleString = TextConstants.FIELDTYPE_ACTIVE;
			tickettype.setActive(stateType, fieldType);
		} else {
			visibleString = TextConstants.FIELDTYPE_NONACTIVE;
			tickettype.setNonActive(stateType, fieldType);
		}

		this.setStringValue(StringUtils
				.format("Beim Tickettypen %s wurde die Aktivität des Feldtypen %s für den Status %s auf \"%s\" geänert.",
						tickettype.getTypeName(), fieldType.getName(),
						stateType.getName(), visibleString));

		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleTicketTypeSetFieldTypeActivityCommand(this);
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
