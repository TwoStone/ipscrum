package fhdw.ipscrum.shared.constants;

/**
 * This class contains all constants for exceptions in the ticket system
 * framework
 */
public class ExceptionConstants {
	// TODO: All Exception Constants here!
	public static final String DOUBLE_DEFINITION_ERROR = "Doppelte Einträge sind nicht erlaubt! Bitte überprüfen!";
	public static final String FORBIDDEN_STATE_ERROR = "Der aktuelle Status des Tickets erlaubt diese Aktion nicht";
	public static final String EMPTY_DESCRIPTION_ERROR = "Es muss ein Beschreibung angegeben werden.";
	public static final String ROLE_NOT_FOUND_ERROR = "Diese Rolle ist dieser Person nicht zugewiesen.";
	public static final String PERSON_NOT_FOUND_ERROR = "Diese Person ist dem Team nicht zugewiesen.";
	public static final String ROLE_ALREADY_ASSIGNED_ERROR = "Diese Rolle wurde der Person bereits zugeordnet.";
	public static final String PERSON_ALREADY_ASSIGNED_ERROR = "Diese Person wurde dem Team bereits zugeordnet.";
	public static final String ROLE_STILL_IN_USE_ERROR = "Diese Rolle ist noch einer oder mehreren Personen zugeordnet und kann nicht gelöscht werden.";
	public static final String NO_SPRINT_SELECTED = "Kein Sprint ausgewählt.";
	public static final String NO_TEAM_SELECTED_ERROR = "Es muss ein Team zugeordnet werden.";
	public static final String NO_VALID_DATE_ERROR = "Es wurde ein ungültiges Datum angegeben.";
	public static final String END_BEFORE_BEGIN_ERROR = "Das Enddatum darf nicht vor dem Beginndatum liegen.";
	public static final String EMPTY_NAME_ERROR = "Es muss ein vollständiger Name angegeben werden.";
	public static final String SPRINT_NAME_ERROR = "Der Name des Sprints darf muß eine Länge zwischen 1 und 20 besitzen.";
}
