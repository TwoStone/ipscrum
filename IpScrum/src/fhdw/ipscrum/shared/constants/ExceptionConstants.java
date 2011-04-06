package fhdw.ipscrum.shared.constants;

/**
 * This class contains all constants for exceptions in the ticket system framework
 */
public abstract class ExceptionConstants {
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
	public static final String NO_VERSION_SELECTED = "Keine Version ausgewählt.";
	public static final String NO_PBITYP_SELECTED = "Kein Typ ausgewählt.";
	public static final String NO_TEAM_SELECTED_ERROR = "Es muss ein Team zugeordnet werden.";
	public static final String NO_VALID_DATE_ERROR = "Es wurde ein ungültiges Datum angegeben.";
	public static final String NO_VALID_NAME = "Es muss eine Bezeichnung angegeben werden";
	public static final String END_BEFORE_BEGIN_ERROR = "Das Enddatum darf nicht vor dem Beginndatum liegen.";
	public static final String EMPTY_NAME_ERROR = "Es muss ein vollständiger Name angegeben werden.";
	public static final String SPRINT_NAME_ERROR = "Der Name des Sprints muß eine Länge zwischen 1 und 20 besitzen.";
	public static final String CONCISTENCY_BASE = "Konsistenzverletzung:\n";
	public static final String SYSTEM_ALREADY_KNOWN = "System bereits vorhanden";

	public static final String GUI_PERSROLEMNGMT_ASSIGNERROR = "Keine Zuordnung durchgeführt.\nBitte wählen Sie zur Zuordnung von Rollen zu einer Person eine (oder mehrere) Rollen aus der rechten Liste, sowie eine Person aus der linken Tabelle aus.";
	public static final String GUI_TEAMVIEW_ASSIGNERROR = "Keine Zuordnung durchgeführt.\nBitte wählen Sie zur Teamzuordnung eine (oder mehrere) Personen aus der rechten Tabelle, sowie ein Team aus der linken Liste aus.";
	public static final String GUI_SYSTEMVIEW_ASSIGNERROR = "Keine Zuordnung durchgeführt.\nBitte wählen Sie zur Systemzuordnung ein System aus den verfügbaren Systemen aus.";

	public static final String TASK_INITIAL_STATE_ERROR = "INTERNAL ERROR! - The initial State does not allow initializing attributes";
	public static final String PERSON_NOT_IN_SPRINT_TEAM_ERROR = "Diese Person ist nicht Teil des Teams für diesen Sprint";
	public static final String PBI_NOT_IN_SPRINT_ERROR = "Dieses PBI wird in diesem Sprint nicht in das Produktinkrement eingehen";
	public static final String SYSTEM_IS_NOT_POSSIBLE = "System ist nicht als mögliches System im Projekt definiert.";
	public static final String RELEASE_NOT_IN_PROJECT = "Release gehört nicht zum übergeordneten Projekt!";
	public static final String EFFORT_MIN_VALUE = "Aufwand darf nicht weniger als 0 betragen!";

	public static final String SEARCH_NOT_UPDATEABLE = "Suche darf nicht bearbeitet werden";
	public static final String SEARCH_DOUBLE_DEFINITION_ERROR = "Es existiert bereits eine Suche mit diesem Namen. Bitte einen anderen Namen wählen.";
}
