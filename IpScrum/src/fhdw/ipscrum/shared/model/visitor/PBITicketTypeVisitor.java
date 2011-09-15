package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;

/**
 * Represents the Visitor needed for handling PBITicketTypes.
 */
public interface PBITicketTypeVisitor {

	/**
	 * Needed for handling BugTicketTypes.
	 * 
	 * @param bugTicketType
	 *            current bugTicketType to handle
	 */
	void handleBugTicketType(BugTicketType bugTicketType);

	/**
	 * Needed for handling FeatureTicketTypes.
	 * 
	 * @param featureTicketType
	 *            current featureTicketType to handle
	 */
	void handleFeatureTicketType(FeatureTicketType featureTicketType);

}
