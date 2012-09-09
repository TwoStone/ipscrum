package fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes;

/**
 * Represents a Visitor needed for handling TicketTypes.
 */
public interface TicketTypeVisitor {

	/**
	 * Needed for handling TaskTicketTypes.
	 * 
	 * @param taskTicketType
	 *            current taskTicketType
	 */
	void handleTaskTicketType(TaskTicketType taskTicketType);

	/**
	 * Needed for handling FeatureTicketTypes.
	 * 
	 * @param featureTicketType
	 *            current featureTicketType
	 */
	void handleFeatureTicketType(FeatureTicketType featureTicketType);

	/**
	 * Needed for handling BugTicketTypes.
	 * 
	 * @param bugTicketType
	 *            current bugTicketType
	 */
	void handleBugTicketType(BugTicketType bugTicketType);
}
