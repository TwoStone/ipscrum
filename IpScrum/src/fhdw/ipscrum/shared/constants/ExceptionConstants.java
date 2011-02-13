package fhdw.ipscrum.shared.constants;

/**
 * This class contains all constants for exceptions in the ticket system
 * framework
 */
public class ExceptionConstants {
	// TODO: All Exception Constants here!
	public static final String DOUBLE_DEFINITION_ERROR = "Doppelte Einträge sind nicht erlaubt! Bitte überprüfen!";
	public static final String FORBIDDEN_STATE_ERROR = "Der aktuelle Status des Tickets erlaubt diese Aktion nicht";
	public static final String EMPTY_ROLE_DESCRIPTION_ERROR = "Es muss ein Rollenname angegeben werden.";
	public static final String ROLE_NOT_FOUND_ERROR = "Diese Rolle ist dieser Person nicht zugewiesen.";
	public static final String ROLE_ALREADY_ASSIGNED_ERROR = "Diese Rolle wurde der Person bereits zugeordnet.";
	public static final String NO_SPRINT_SELECTED = "Kein Sprint ausgewählt.";
}
