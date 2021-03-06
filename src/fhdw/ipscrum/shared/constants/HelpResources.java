package fhdw.ipscrum.shared.constants;

import java.util.HashMap;

import fhdw.ipscrum.client.architecture.presenter.Presenter;
import fhdw.ipscrum.shared.utils.ClassUtils;

/**
 * This provides paths to all documentation files.
 */
public abstract class HelpResources {

	/**
	 * IP-Scrum Documentation Index.
	 */
	public static final String HELPINDEX = "IP-Scrum Hilfe.html";

	/**
	 * Topic: "Willkommen".
	 */
	public static final String WILLKOMMEN = "Willkommen.html";

	/**
	 * Topic: "Allgemeine Einführung".
	 */
	public static final String ALLGEMEINEEINFHRUNG = "AllgemeineEinfhrung.html";

	/**
	 * Topic: "Start der Anwendung".
	 */
	public static final String STARTDERANWENDUNG = "StartderAnwendung.html";

	/**
	 * Topic: "Anmeldung am System".
	 */
	public static final String LOGIN = "Login.html";

	/**
	 * Topic: "Login", Anchor 1: "Rollenauswahl".
	 */
	public static final String LOGIN_ROLLENAUSWAHL = "Login.html#Rollenauswahl";

	/**
	 * Topic: "Programmoberfläche".
	 */
	public static final String PROGRAMMOBERFLCHE = "Programmoberflche.html";

	/**
	 * Topic: "Handhabung".
	 */
	public static final String HANDHABUNG = "Handhabung.html";

	/**
	 * Topic: "Projekt".
	 */
	public static final String PROJEKT = "Projekt.html";

	/**
	 * Topic: "Projektübersicht".
	 */
	public static final String PROJECTSELECTIONPRESENTER = "ProjectSelectionPresenter.html";

	/**
	 * Topic: "Projekt anlegen".
	 */
	public static final String PROJECTCREATEPRESENTER = "ProjectCreatePresenter.html";

	/**
	 * Topic: "Projekt bearbeiten".
	 */
	public static final String PROJECTDISPLAYPRESENTER = "ProjectDisplayPresenter.html";

	/**
	 * Topic: "ProjectDisplayPresenter", Anchor 1: "RenameProject".
	 */
	public static final String PROJECTDISPLAYPRESENTER_RENAMEPROJECT = "ProjectDisplayPresenter.html#RenameProject";

	/**
	 * Topic: "ProjectDisplayPresenter", Anchor 2: "ValidateProjectName".
	 */
	public static final String PROJECTDISPLAYPRESENTER_VALIDATEPROJECTNAME =
			"ProjectDisplayPresenter.html#ValidateProjectName";

	/**
	 * Topic: "ProjectDisplayPresenter", Anchor 3: "DeleteRelease".
	 */
	public static final String PROJECTDISPLAYPRESENTER_DELETERELEASE = "ProjectDisplayPresenter.html#DeleteRelease";

	/**
	 * Topic: "ProjectDisplayPresenter", Anchor 4: "DeleteSprint".
	 */
	public static final String PROJECTDISPLAYPRESENTER_DELETESPRINT = "ProjectDisplayPresenter.html#DeleteSprint";

	/**
	 * Topic: "Projektsysteme verwalten".
	 */
	public static final String PROJECTSELECTSYSTEMPRESENTER = "ProjectSelectSystemPresenter.html";

	/**
	 * Topic: "Projekthistorie".
	 */
	public static final String PROJECTHISTORYPRESENTER = "ProjectHistoryPresenter.html";

	/**
	 * Topic: "Ereignistyp anlegen".
	 */
	public static final String INCIDENTTYPECREATEPRESENTER = "IncidentTypeCreatePresenter.html";

	/**
	 * Topic: "IncidentTypeCreatePresenter", Anchor 1: "Description".
	 */
	public static final String INCIDENTTYPECREATEPRESENTER_DESCRIPTION = "IncidentTypeCreatePresenter.html#Description";

	/**
	 * Topic: "Ereignis anlegen".
	 */
	public static final String CREATEINCIDENTPRESENTER = "CreateIncidentPresenter.html";

	/**
	 * Topic: "Projektreleases verwalten".
	 */
	public static final String PROJEKTRELEASESVERWALTEN = "Projektreleasesverwalten.html";

	/**
	 * Topic: "Release anlegen".
	 */
	public static final String RELEASECREATEPRESENTER = "ReleaseCreatePresenter.html";

	/**
	 * Topic: "Release bearbeiten".
	 */
	public static final String RELEASEEDITPRESENTER = "ReleaseEditPresenter.html";

	/**
	 * Topic: "Burndown Chart anzeigen".
	 */
	public static final String RELEASEBURNDOWNCHART = "ReleaseBurndownChart.html";

	/**
	 * Topic: "Projektsprints verwalten".
	 */
	public static final String PROJEKTSPRINTSVERWALTEN = "Projektsprintsverwalten.html";

	/**
	 * Topic: "Sprint anlegen".
	 */
	public static final String CREATESPRINTPRESENTER = "CreateSprintPresenter.html";

	/**
	 * Topic: "CreateSprintPresenter", Anchor 1: "NameOfSprint".
	 */
	public static final String CREATESPRINTPRESENTER_NAMEOFSPRINT = "CreateSprintPresenter.html#NameOfSprint";

	/**
	 * Topic: "CreateSprintPresenter", Anchor 2: "StartEndDateOfSprint".
	 */
	public static final String CREATESPRINTPRESENTER_STARTENDDATEOFSPRINT =
			"CreateSprintPresenter.html#StartEndDateOfSprint";

	/**
	 * Topic: "CreateSprintPresenter", Anchor 3: "TeamOfSprint".
	 */
	public static final String CREATESPRINTPRESENTER_TEAMOFSPRINT = "CreateSprintPresenter.html#TeamOfSprint";

	/**
	 * Topic: "CreateSprintPresenter", Anchor 4: "SprintDescription".
	 */
	public static final String CREATESPRINTPRESENTER_SPRINTDESCRIPTION = "CreateSprintPresenter.html#SprintDescription";

	/**
	 * Topic: "Sprint bearbeiten".
	 */
	public static final String EDITSPRINTPRESENTER = "EditSprintPresenter.html";

	/**
	 * Topic: "Burndown Chart anzeigen".
	 */
	public static final String SPRINTBURNDOWNCHART = "SprintBurndownChart.html";

	/**
	 * Topic: "Taskboard verwalten".
	 */
	public static final String TASKBOARDPRESENTER = "TaskboardPresenter.html";

	/**
	 * Topic: "Task anlegen".
	 */
	public static final String TASKCREATEPRESENTER = "TaskCreatePresenter.html";

	/**
	 * Topic: "TaskCreatePresenter", Anchor 1: "NameAndDescription".
	 */
	public static final String TASKCREATEPRESENTER_NAMEANDDESCRIPTION = "TaskCreatePresenter.html#NameAndDescription";

	/**
	 * Topic: "TaskCreatePresenter", Anchor 2: "TicketType".
	 */
	public static final String TASKCREATEPRESENTER_TICKETTYPE = "TaskCreatePresenter.html#TicketType";

	/**
	 * Topic: "Task bearbeiten".
	 */
	public static final String TASKTICKET = "TaskTicket.html";

	/**
	 * Topic: "TaskTicket", Anchor 1: "ChangeDescAndName".
	 */
	public static final String TASKTICKET_CHANGEDESCANDNAME = "TaskTicket.html#ChangeDescAndName";

	/**
	 * Topic: "TaskTicket", Anchor 2: "ChangeState".
	 */
	public static final String TASKTICKET_CHANGESTATE = "TaskTicket.html#ChangeState";

	/**
	 * Topic: "TaskTicket", Anchor 3: "Enddate".
	 */
	public static final String TASKTICKET_ENDDATE = "TaskTicket.html#Enddate";

	/**
	 * Topic: "TaskTicket", Anchor 4: "Backlog".
	 */
	public static final String TASKTICKET_BACKLOG = "TaskTicket.html#Backlog";

	/**
	 * Topic: "TaskTicket", Anchor 5: "Editor".
	 */
	public static final String TASKTICKET_EDITOR = "TaskTicket.html#Editor";

	/**
	 * Topic: "TaskTicket", Anchor 6: "Effort".
	 */
	public static final String TASKTICKET_EFFORT = "TaskTicket.html#Effort";

	/**
	 * Topic: "Product Backlog".
	 */
	public static final String PRODUCTBACKLOG_TOPIC = "ProductBacklog_Topic.html";

	/**
	 * Topic: "Product Backlog bearbeiten".
	 */
	public static final String PRODUCTBACKLOGPRESENTER = "ProductBacklogPresenter.html";

	/**
	 * Topic: "ProductBacklogPresenter", Anchor 1: "PrioritaetVeraendern".
	 */
	public static final String PRODUCTBACKLOGPRESENTER_PRIORITAETVERAENDERN =
			"ProductBacklogPresenter.html#PrioritaetVeraendern";

	/**
	 * Topic: "ProductBacklogPresenter", Anchor 2: "ProductBacklogItemEntfernen".
	 */
	public static final String PRODUCTBACKLOGPRESENTER_PRODUCTBACKLOGITEMENTFERNEN =
			"ProductBacklogPresenter.html#ProductBacklogItemEntfernen";

	/**
	 * Topic: "Product-Backlog-Item erstellen".
	 */
	public static final String PRODUCTBACKLOGITEMCREATEPRESENTE = "ProductBacklogItemCreatePresente.html";

	/**
	 * Topic: "Product-Backlog-Item - Detailsicht".
	 */
	public static final String PBITICKET = "PbiTicket.html";

	/**
	 * Topic: "PbiTicket", Anchor 1: "Bezeichnung".
	 */
	public static final String PBITICKET_BEZEICHNUNG = "PbiTicket.html#Bezeichnung";

	/**
	 * Topic: "PbiTicket", Anchor 2: "Beschreibung".
	 */
	public static final String PBITICKET_BESCHREIBUNG = "PbiTicket.html#Beschreibung";

	/**
	 * Topic: "PbiTicket", Anchor 3: "Status".
	 */
	public static final String PBITICKET_STATUS = "PbiTicket.html#Status";

	/**
	 * Topic: "PbiTicket", Anchor 4: "Akzeptanzkriterien".
	 */
	public static final String PBITICKET_AKZEPTANZKRITERIEN = "PbiTicket.html#Akzeptanzkriterien";

	/**
	 * Topic: "PbiTicket", Anchor 5: "Hinweise".
	 */
	public static final String PBITICKET_HINWEISE = "PbiTicket.html#Hinweise";

	/**
	 * Topic: "PbiTicket", Anchor 6: "Aufwand".
	 */
	public static final String PBITICKET_AUFWAND = "PbiTicket.html#Aufwand";

	/**
	 * Topic: "PbiTicket", Anchor 7: "Sprint".
	 */
	public static final String PBITICKET_SPRINT = "PbiTicket.html#Sprint";

	/**
	 * Topic: "Verwaltung".
	 */
	public static final String VERWALTUNG = "Verwaltung.html";

	/**
	 * Topic: "Personen- und Rollenverwaltung".
	 */
	public static final String PERSONROLEPRESENTER = "PersonRolePresenter.html";

	/**
	 * Topic: "PersonRolePresenter", Anchor 1: "RolleEntfernen".
	 */
	public static final String PERSONROLEPRESENTER_ROLLEENTFERNEN = "PersonRolePresenter.html#RolleEntfernen";

	/**
	 * Topic: "PersonRolePresenter", Anchor 2: "ZuordnungHinzufuegen".
	 */
	public static final String PERSONROLEPRESENTER_ZUORDNUNGHINZUFUEGEN =
			"PersonRolePresenter.html#ZuordnungHinzufuegen";

	/**
	 * Topic: "PersonRolePresenter", Anchor 3: "ZuordnungEntfernen".
	 */
	public static final String PERSONROLEPRESENTER_ZUORDNUNGENTFERNEN = "PersonRolePresenter.html#ZuordnungEntfernen";

	/**
	 * Topic: "Person anlegen".
	 */
	public static final String PERSONCREATEPRESENTER = "PersonCreatePresenter.html";

	/**
	 * Topic: "Person bearbeiten".
	 */
	public static final String PERSONEDITPRESENTER = "PersonEditPresenter.html";

	/**
	 * Topic: "Rolle anlegen".
	 */
	public static final String ROLECREATEPRESENTER = "RoleCreatePresenter.html";

	/**
	 * Topic: "Berechtigungen zuordnen".
	 */
	public static final String ADDRIGHTSTOROLEPRESENTER = "AddRightsToRolePresenter.html";

	/**
	 * Topic: "Teams".
	 */
	public static final String TEAMPRESENTER = "TeamPresenter.html";

	/**
	 * Topic: "TeamPresenter", Anchor 1: "PersonHinzufuegenBzwEntfernen".
	 */
	public static final String TEAMPRESENTER_PERSONHINZUFUEGENBZWENTFERNEN =
			"TeamPresenter.html#PersonHinzufuegenBzwEntfernen";

	/**
	 * Topic: "Team erstellen".
	 */
	public static final String TEAMCREATEPRESENTER = "TeamCreatePresenter.html";

	/**
	 * Topic: "Team bearbeiten".
	 */
	public static final String TEAMEDITPRESENTER = "TeamEditPresenter.html";

	/**
	 * Topic: "Velocity-Analyse".
	 */
	public static final String VELOCITYANALYSE = "VelocityAnalyse.html";

	/**
	 * Topic: "Projekte zuordnen".
	 */
	public static final String ADDPROJECTTOTEAMPRESENTER = "AddProjectToTeamPresenter.html";

	/**
	 * Topic: "Revisionsverwaltung".
	 */
	public static final String REVISIONCONTROLPRESENTER = "RevisionControlPresenter.html";

	/**
	 * Topic: "RevisionControlPresenter", Anchor 1: "Filter".
	 */
	public static final String REVISIONCONTROLPRESENTER_FILTER = "RevisionControlPresenter.html#Filter";

	/**
	 * Topic: "RevisionControlPresenter", Anchor 2: "LadenAlterRevisionsstaende".
	 */
	public static final String REVISIONCONTROLPRESENTER_LADENALTERREVISIONSSTAENDE =
			"RevisionControlPresenter.html#LadenAlterRevisionsstaende";

	/**
	 * Topic: "Feldtypen-, Zustands- und Tickettypen-Erzeugung".
	 */
	public static final String STATEFIELDANDTICKETTYPEADMINISTR = "StateFieldAndTickettypeAdministr.html";

	/**
	 * Topic: "Tickettyp erstellen".
	 */
	public static final String TICKETTYPECREATEPRESENTER = "TicketTypeCreatePresenter.html";

	/**
	 * Topic: "Zustandtyp erstellen".
	 */
	public static final String STATETYPECREATEPRESENTER = "StateTypeCreatePresenter.html";

	/**
	 * Topic: "Feld erstellen".
	 */
	public static final String FIELDTYPECREATEPRESENTER = "FieldTypeCreatePresenter.html";

	/**
	 * Topic: "Tickettypen-Administration".
	 */
	public static final String TICKETTYPESELECTIONPRESENTER = "TicketTypeSelectionPresenter.html";

	/**
	 * Topic: "Tickettypen bearbeiten".
	 */
	public static final String TYPEEDITPRESENTER = "TypeEditPresenter.html";

	/**
	 * Topic: "TypeEditPresenter", Anchor 1: "ZustandEntfernen".
	 */
	public static final String TYPEEDITPRESENTER_ZUSTANDENTFERNEN = "TypeEditPresenter.html#ZustandEntfernen";

	/**
	 * Topic: "TypeEditPresenter", Anchor 2: "ZustandAlsStartzustand".
	 */
	public static final String TYPEEDITPRESENTER_ZUSTANDALSSTARTZUSTAND =
			"TypeEditPresenter.html#ZustandAlsStartzustand";

	/**
	 * Topic: "TypeEditPresenter", Anchor 3: "ZustandAlsEndzustand".
	 */
	public static final String TYPEEDITPRESENTER_ZUSTANDALSENDZUSTAND = "TypeEditPresenter.html#ZustandAlsEndzustand";

	/**
	 * Topic: "TypeEditPresenter", Anchor 4: "FeldEntfernen".
	 */
	public static final String TYPEEDITPRESENTER_FELDENTFERNEN = "TypeEditPresenter.html#FeldEntfernen";

	/**
	 * Topic: "TypeEditPresenter", Anchor 5: "FeldAktivieren".
	 */
	public static final String TYPEEDITPRESENTER_FELDAKTIVIEREN = "TypeEditPresenter.html#FeldAktivieren";

	/**
	 * Topic: "TypeEditPresenter", Anchor 6: "ZustandsuebergangEntfernen".
	 */
	public static final String TYPEEDITPRESENTER_ZUSTANDSUEBERGANGENTFERNEN =
			"TypeEditPresenter.html#ZustandsuebergangEntfernen";

	/**
	 * Topic: "Zustand hinzufügen".
	 */
	public static final String ADDSTATESTOTICKETTYPEPRESENTER = "AddStatesToTicketTypePresenter.html";

	/**
	 * Topic: "Feld hinzufügen".
	 */
	public static final String ADDFIELDSTOTICKETTYPEPRESENTER = "AddFieldsToTicketTypePresenter.html";

	/**
	 * Topic: "Zustandsübergang hinzufügen".
	 */
	public static final String STATETRANSISTIONCREATEPRESENTER = "StateTransistionCreatePresenter.html";

	/**
	 * Topic: "Systeme verwalten".
	 */
	public static final String SYSTEMMANAGEMENTPRESENTER = "SystemManagementPresenter.html";

	/**
	 * Topic: "Benutzerverwaltung".
	 */
	public static final String USERMANAGEMENTPRESENTER = "UserManagementPresenter.html";

	/**
	 * Topic: "neuen Benutzer anlegen".
	 */
	public static final String USERCREATEPRESENTER = "UserCreatePresenter.html";

	/**
	 * Topic: "Suche".
	 */
	public static final String SUCHE = "Suche.html";

	/**
	 * Topic: "Scruumle".
	 */
	public static final String SEARCHALLPRESENTER = "SearchAllPresenter.html";

	/**
	 * Topic: "Suchergebnisse".
	 */
	public static final String SEARCHRESULTPRESENTER = "SearchResultPresenter.html";

	/**
	 * Topic: "Detailsuche".
	 */
	public static final String SEARCHPRESENTER = "SearchPresenter.html";

	/**
	 * Topic: "Gespeicherte Suchen".
	 */
	public static final String SEARCHESPRESENTER = "SearchesPresenter.html";

	/**
	 * Path storage for presenter-specific documentation.
	 */
	private static final HashMap<String, String> PRESENTER_HELP = new HashMap<String, String>();

	/**
	 * File names of generate HTML-Docs are limited to be only 32 characters long.
	 */
	private static final int HNDMAXIDLENGTH = 32;

	/**
	 * This document is displayed to the user when there is no help available.
	 */
	public static final String NO_PRESENTER_HELP_AVAILABLE = "_NoPresenterHelp.html";

	static {
		HelpResources.PRESENTER_HELP.put("Willkommen", HelpResources.WILLKOMMEN);
		HelpResources.PRESENTER_HELP.put("AllgemeineEinfhrung", HelpResources.ALLGEMEINEEINFHRUNG);
		HelpResources.PRESENTER_HELP.put("StartderAnwendung", HelpResources.STARTDERANWENDUNG);
		HelpResources.PRESENTER_HELP.put("Login", HelpResources.LOGIN);
		HelpResources.PRESENTER_HELP.put("Programmoberflche", HelpResources.PROGRAMMOBERFLCHE);
		HelpResources.PRESENTER_HELP.put("Handhabung", HelpResources.HANDHABUNG);
		HelpResources.PRESENTER_HELP.put("Projekt", HelpResources.PROJEKT);
		HelpResources.PRESENTER_HELP.put("ProjectSelectionPresenter", HelpResources.PROJECTSELECTIONPRESENTER);
		HelpResources.PRESENTER_HELP.put("ProjectCreatePresenter", HelpResources.PROJECTCREATEPRESENTER);
		HelpResources.PRESENTER_HELP.put("ProjectDisplayPresenter", HelpResources.PROJECTDISPLAYPRESENTER);
		HelpResources.PRESENTER_HELP.put("ProjectSelectSystemPresenter", HelpResources.PROJECTSELECTSYSTEMPRESENTER);
		HelpResources.PRESENTER_HELP.put("ProjectHistoryPresenter", HelpResources.PROJECTHISTORYPRESENTER);
		HelpResources.PRESENTER_HELP.put("IncidentTypeCreatePresenter", HelpResources.INCIDENTTYPECREATEPRESENTER);
		HelpResources.PRESENTER_HELP.put("CreateIncidentPresenter", HelpResources.CREATEINCIDENTPRESENTER);
		HelpResources.PRESENTER_HELP.put("Projektreleasesverwalten", HelpResources.PROJEKTRELEASESVERWALTEN);
		HelpResources.PRESENTER_HELP.put("ReleaseCreatePresenter", HelpResources.RELEASECREATEPRESENTER);
		HelpResources.PRESENTER_HELP.put("ReleaseEditPresenter", HelpResources.RELEASEEDITPRESENTER);
		HelpResources.PRESENTER_HELP.put("ReleaseBurndownChart", HelpResources.RELEASEBURNDOWNCHART);
		HelpResources.PRESENTER_HELP.put("Projektsprintsverwalten", HelpResources.PROJEKTSPRINTSVERWALTEN);
		HelpResources.PRESENTER_HELP.put("CreateSprintPresenter", HelpResources.CREATESPRINTPRESENTER);
		HelpResources.PRESENTER_HELP.put("EditSprintPresenter", HelpResources.EDITSPRINTPRESENTER);
		HelpResources.PRESENTER_HELP.put("SprintBurndownChart", HelpResources.SPRINTBURNDOWNCHART);
		HelpResources.PRESENTER_HELP.put("TaskboardPresenter", HelpResources.TASKBOARDPRESENTER);
		HelpResources.PRESENTER_HELP.put("TaskCreatePresenter", HelpResources.TASKCREATEPRESENTER);
		HelpResources.PRESENTER_HELP.put("TaskTicket", HelpResources.TASKTICKET);
		HelpResources.PRESENTER_HELP.put("ProductBacklog_Topic", HelpResources.PRODUCTBACKLOG_TOPIC);
		HelpResources.PRESENTER_HELP.put("ProductBacklogPresenter", HelpResources.PRODUCTBACKLOGPRESENTER);
		HelpResources.PRESENTER_HELP.put("ProductBacklogItemCreatePresente",
				HelpResources.PRODUCTBACKLOGITEMCREATEPRESENTE);
		HelpResources.PRESENTER_HELP.put("PbiTicket", HelpResources.PBITICKET);
		HelpResources.PRESENTER_HELP.put("Verwaltung", HelpResources.VERWALTUNG);
		HelpResources.PRESENTER_HELP.put("PersonRolePresenter", HelpResources.PERSONROLEPRESENTER);
		HelpResources.PRESENTER_HELP.put("PersonCreatePresenter", HelpResources.PERSONCREATEPRESENTER);
		HelpResources.PRESENTER_HELP.put("PersonEditPresenter", HelpResources.PERSONEDITPRESENTER);
		HelpResources.PRESENTER_HELP.put("RoleCreatePresenter", HelpResources.ROLECREATEPRESENTER);
		HelpResources.PRESENTER_HELP.put("AddRightsToRolePresenter", HelpResources.ADDRIGHTSTOROLEPRESENTER);
		HelpResources.PRESENTER_HELP.put("TeamPresenter", HelpResources.TEAMPRESENTER);
		HelpResources.PRESENTER_HELP.put("TeamCreatePresenter", HelpResources.TEAMCREATEPRESENTER);
		HelpResources.PRESENTER_HELP.put("TeamEditPresenter", HelpResources.TEAMEDITPRESENTER);
		HelpResources.PRESENTER_HELP.put("VelocityAnalyse", HelpResources.VELOCITYANALYSE);
		HelpResources.PRESENTER_HELP.put("AddProjectToTeamPresenter", HelpResources.ADDPROJECTTOTEAMPRESENTER);
		HelpResources.PRESENTER_HELP.put("RevisionControlPresenter", HelpResources.REVISIONCONTROLPRESENTER);
		HelpResources.PRESENTER_HELP.put("StateFieldAndTickettypeAdministr",
				HelpResources.STATEFIELDANDTICKETTYPEADMINISTR);
		HelpResources.PRESENTER_HELP.put("TicketTypeCreatePresenter", HelpResources.TICKETTYPECREATEPRESENTER);
		HelpResources.PRESENTER_HELP.put("StateTypeCreatePresenter", HelpResources.STATETYPECREATEPRESENTER);
		HelpResources.PRESENTER_HELP.put("FieldTypeCreatePresenter", HelpResources.FIELDTYPECREATEPRESENTER);
		HelpResources.PRESENTER_HELP.put("TicketTypeSelectionPresenter", HelpResources.TICKETTYPESELECTIONPRESENTER);
		HelpResources.PRESENTER_HELP.put("TypeEditPresenter", HelpResources.TYPEEDITPRESENTER);
		HelpResources.PRESENTER_HELP
				.put("AddStatesToTicketTypePresenter", HelpResources.ADDSTATESTOTICKETTYPEPRESENTER);
		HelpResources.PRESENTER_HELP
				.put("AddFieldsToTicketTypePresenter", HelpResources.ADDFIELDSTOTICKETTYPEPRESENTER);
		HelpResources.PRESENTER_HELP.put("StateTransistionCreatePresenter",
				HelpResources.STATETRANSISTIONCREATEPRESENTER);
		HelpResources.PRESENTER_HELP.put("SystemManagementPresenter", HelpResources.SYSTEMMANAGEMENTPRESENTER);
		HelpResources.PRESENTER_HELP.put("UserManagementPresenter", HelpResources.USERMANAGEMENTPRESENTER);
		HelpResources.PRESENTER_HELP.put("UserCreatePresenter", HelpResources.USERCREATEPRESENTER);
		HelpResources.PRESENTER_HELP.put("Suche", HelpResources.SUCHE);
		HelpResources.PRESENTER_HELP.put("SearchAllPresenter", HelpResources.SEARCHALLPRESENTER);
		HelpResources.PRESENTER_HELP.put("SearchResultPresenter", HelpResources.SEARCHRESULTPRESENTER);
		HelpResources.PRESENTER_HELP.put("SearchPresenter", HelpResources.SEARCHPRESENTER);
		HelpResources.PRESENTER_HELP.put("SearchesPresenter", HelpResources.SEARCHESPRESENTER);
	}

	/**
	 * This is to obtain presenter-specific documentation.
	 * 
	 * @param presenter
	 *            Presenter
	 * @return Path to presenter-specific documentation
	 */
	public static String getPresenterHelp(final Presenter presenter) {
		final String result;
		final String classname = ClassUtils.getClassName(presenter.getClass());

		// This is to comply with very long presenter-names which are shortened by HNDs export.
		if (classname.length() > HelpResources.HNDMAXIDLENGTH) {
			result = HelpResources.PRESENTER_HELP.get(classname.substring(0, HelpResources.HNDMAXIDLENGTH));
		} else {
			result = HelpResources.PRESENTER_HELP.get(classname);
		}

		// If no help-document could be found a static message is displayed to the user.
		if (result != null) {
			return result;
		} else {
			return HelpResources.NO_PRESENTER_HELP_AVAILABLE;
		}
	}

}
