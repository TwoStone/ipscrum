package fhdw.ipscrum.shared.constants;

/**
 * This class contains all constants for exceptions in the ticket system framework.
 */
public abstract class ExceptionConstants {
	// TODO: All Exception Constants here!
	/**
	 * Represents the text of the DoubleDefinitionException.
	 */
	public static final String DOUBLE_DEFINITION_ERROR = "Doppelte Einträge sind nicht erlaubt! Bitte überprüfen!";
	/**
	 * Represents the text of the ForbiddenStateException.
	 */
	public static final String FORBIDDEN_STATE_ERROR = "Der aktuelle Status des Tickets erlaubt diese Aktion nicht";

	/**
	 * Represents the text of the Exception thrown if the description is the empty word.
	 */
	public static final String EMPTY_DESCRIPTION_ERROR = "Es muss ein Beschreibung angegeben werden.";

	/**
	 * Represents the text of the Exception thrown if a selected role isn't related to a person.
	 */
	public static final String ROLE_NOT_FOUND_ERROR = "Diese Rolle ist dieser Person nicht zugewiesen.";

	/**
	 * Represents the text of the Exception thrown if a selected person doesn't exist in the team.
	 */
	public static final String PERSON_NOT_FOUND_ERROR = "Diese Person ist dem Team nicht zugewiesen.";

	/**
	 * Represents the text of the Exception thrown if a role is already related to a person.
	 */
	public static final String ROLE_ALREADY_ASSIGNED_ERROR = "Diese Rolle wurde der Person bereits zugeordnet.";

	/**
	 * Represents the text of the Exception thrown if a person is already related to a team.
	 */
	public static final String PERSON_ALREADY_ASSIGNED_ERROR = "Diese Person wurde dem Team bereits zugeordnet.";

	/**
	 * Represents the text of the Exception thrown if a role should be deleted that is still related to one or more
	 * persons.
	 */
	public static final String ROLE_STILL_IN_USE_ERROR =
			"Diese Rolle ist noch einer oder mehreren Personen zugeordnet und kann nicht gelöscht werden.";

	/**
	 * Represents the text if the Exception thrown if no sprint is selected.
	 */
	public static final String NO_SPRINT_SELECTED = "Kein Sprint ausgewählt.";

	/**
	 * Represents the text of the Exception thrown if no version is selected.
	 */
	public static final String NO_VERSION_SELECTED = "Keine Version ausgewählt.";

	/**
	 * Represents the text of the Exception thrown if no PBIType is selected.
	 */
	public static final String NO_PBITYP_SELECTED = "Kein Typ ausgewählt.";

	/**
	 * Represents the text of the Exception thrown if no team is selected.
	 */
	public static final String NO_TEAM_SELECTED_ERROR = "Es muss ein Team zugeordnet werden.";

	/**
	 * Represents the text of the Exception thrown if the date chosen is not valid.
	 */
	public static final String NO_VALID_DATE_ERROR = "Es wurde ein ungültiges Datum angegeben.";

	/**
	 * Represents the text of the Exception thrown if the description is not valid.
	 */
	public static final String NO_VALID_NAME = "Es muss eine Bezeichnung angegeben werden";

	/**
	 * Represents the text of the Exception thrown if the date representing the end is before the date representing the
	 * start.
	 */
	public static final String END_BEFORE_BEGIN_ERROR = "Das Enddatum darf nicht vor dem Beginndatum liegen.";

	/**
	 * Represents the text of the Exception thrown if a name is the empty word.
	 */
	public static final String EMPTY_NAME_ERROR = "Es muss ein vollständiger Name angegeben werden.";

	/**
	 * Represents the text of the Exception thrown if the name of a sprint is to short or to long.
	 */
	public static final String SPRINT_NAME_ERROR = "Der Name des Sprints muß eine Länge zwischen 1 und 20 besitzen.";

	/**
	 * Represents the Text of the Exception thrown if the consistency is hurt.
	 */
	public static final String CONCISTENCY_BASE = "Konsistenzverletzung:\n";

	/**
	 * Represents the text of the Exception if a system already exists in a project.
	 */
	public static final String SYSTEM_ALREADY_KNOWN = "System bereits vorhanden";

	/**
	 * Represents the text of the Exception if no role or person is chosen.
	 */
	public static final String GUI_PERSROLEMNGMT_ASSIGNERROR =
			"Keine Zuordnung durchgeführt.\nBitte wählen Sie zur Zuordnung von Rollen zu einer Person eine (oder mehrere) Rollen aus der rechten Liste, sowie eine Person aus der linken Tabelle aus.";

	/**
	 * Represents the text of the Exception if no person or team is chosen.
	 */
	public static final String GUI_TEAMVIEW_ASSIGNERROR =
			"Keine Zuordnung durchgeführt.\nBitte wählen Sie zur Teamzuordnung eine (oder mehrere) Personen aus der rechten Tabelle, sowie ein Team aus der linken Liste aus.";

	/**
	 * Represents the text of the Exception thrown if no system chosen.
	 */
	public static final String GUI_SYSTEMVIEW_ASSIGNERROR =
			"Keine Zuordnung durchgeführt.\nBitte wählen Sie zur Systemzuordnung ein System aus den verfügbaren Systemen aus.";

	/**
	 * Represents the text of the Exception thrown if the state of a task doesn't allow initializing attributes.
	 */
	public static final String TASK_INITIAL_STATE_ERROR =
			"INTERNAL ERROR! - The initial State does not allow initializing attributes";

	/**
	 * Represents the text of the Exception thrown if the chosen person isn't in the team.
	 */
	public static final String PERSON_NOT_IN_SPRINT_TEAM_ERROR =
			"Diese Person ist nicht Teil des Teams für diesen Sprint";

	/**
	 * Represents the text of the Exception thrown if the chosen PBI doesn't exist in the sprint.
	 */
	public static final String PBI_NOT_IN_SPRINT_ERROR =
			"Dieses PBI wird in diesem Sprint nicht in das Produktinkrement eingehen";

	/**
	 * Represents the text of the Exception thrown if the chosen system doesn't exist in the project.
	 */
	public static final String SYSTEM_IS_NOT_POSSIBLE = "System ist nicht als mögliches System im Projekt definiert.";

	/**
	 * Represents the text of the Exception thrown if a release doesn't belong to the chosen project.
	 */
	public static final String RELEASE_NOT_IN_PROJECT = "Release gehört nicht zum übergeordneten Projekt!";

	/**
	 * Represents the text of the Exception thrown if a effort is less than 0.
	 */
	public static final String EFFORT_MIN_VALUE = "Aufwand darf nicht weniger als 0 betragen!";

	/**
	 * Represents the text of the Exception thrown if a search criterion couldn't be created.
	 */
	public static final String SEARCH_NOT_POSSIBLE = "Suchkriterium kann nicht erstellt werden";

	/**
	 * Represents the text of the Exception thrown if a search mussn't be updated.
	 */
	public static final String SEARCH_NOT_UPDATEABLE = "Suche darf nicht bearbeitet werden";

	/**
	 * Represents the text of the Exception thrown if a cycle would be created.
	 */
	public static final String CYCLE_EXCEPTION = "Zyklus entdeckt!";

	/**
	 * Represents the text of the SearchDoubleDefinitonexception.
	 */
	public static final String SEARCH_DOUBLE_DEFINITION_ERROR =
			"Es existiert bereits eine Suche mit diesem Namen. Bitte einen anderen Namen wählen.";

	/**
	 * Represents a general notfication for the lack of a release-selection.
	 */
	public static final String NO_RELEASE_SELECTED = "Kein Release ausgewählt.";

	/**
	 * represents one version of consystency exception text.
	 */
	public static final String NO_CHANGE_ON_STANDARDS = "Änderungen am Standard sind nicht erlaubt!";
	/**
	 * represents an error message when you try to assign a team to a sprint, but the team does not contain the project.
	 */
	public static final String TEAM_NOT_ASSIGNED_ERROR = "Team ist diesem Projekt nicht zugeordnet!";
	/**
	 * represents an error message when you try to set the active role of a person that is not contained in
	 * person.getRoles().
	 */
	public static final String NO_SUCH_ROLE_ERROR = "Diese Rolle gehört nicht zu diesem Benutzer!";
	/**
	 * represents an error message when the authority check for a command fails.
	 */
	public static final String NOT_AUTHORIZED_ERROR =
			"Für diese Aktion fehlt ihnen entweder die Berechtigung oder sie sind dem falschen Projekt zugeordnet!";

	/**
	 * represents if a state is not defined in a state profile.
	 */
	public static final String STATE_NOT_DEFINDED = "Dieser Zustand ist in diesem Zustandsprofil nicht definiert!";

}
