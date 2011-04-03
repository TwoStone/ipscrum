package fhdw.ipscrum.client.presenter;

import java.util.Date;
import java.util.Vector;
import com.google.gwt.user.client.ui.Panel;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.IncidentDetailArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.ProjectHistoryView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.incidents.Incident;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public class ProjectHistoryPresenter extends Presenter<ProjectHistoryView> {

	Project project;

	public ProjectHistoryPresenter(Panel parent, Presenter<?> parentPresenter,
			Project project) {
		super(parent, parentPresenter);
		this.project = project;
		this.setupHandlers();
		this.initialize();
	}

	private void setupHandlers() {

		// Handler für das hinzufügen eines Incidents
		this.getView().addcreateIncidentHandler(
				new EventHandler<IncidentDetailArgs>() {

					@Override
					public void onUpdate(Object sender,
							IncidentDetailArgs eventArgs) {

						// Eigenschaften des Incidents aus der View ziehen
						String description = ProjectHistoryPresenter.this // Beschreibung
								.getView().getDescriptionText();
						Date endDate = ProjectHistoryPresenter.this.getView() // Ende
																				// Datum
								.getEndDate();
						Date startDate = ProjectHistoryPresenter.this.getView() // Start
																				// Datum
								.getStartDate();
						IPerson pers = ProjectHistoryPresenter.this.getView() // Person
								.getPerson();
						String name = ProjectHistoryPresenter.this.getView()
								.getName();

						// der neue incident wird initialisiert
						Incident newInci = null;

						// der durch die eventArgs übergebene Typ wird in eine
						// variable "type" gesepeichert
						String type = eventArgs.getTyp();

						try {
							// Typ des Incidents festlegen und Incident anlegen

							// urlaub
							if (type.equals(TextConstants.INCIDENT_VACATION_NAME)) {
								newInci = Incident.createVacationIncident(pers,
										startDate, endDate);
							}
							if (type.equals(TextConstants.INCIDENT_ILLNESS_NAME)) {
								newInci = Incident.createIllnessIncident(pers,
										startDate, endDate);
							}
							// if
							// (type.equals(TextConstants.INCIDENT_PBICOMPLETION_NAME1))
							// {
							// //newInci =
							// Incident.createPBICompletionIncident(pbi);
							// }
							// if
							// (type.equals(TextConstants.INCIDENT_PBICOMPLETION_NAME2))
							// {
							// newInci =
							// Incident.createPBICompletionIncident(project.getBacklog().getItems().firstElement());
							// } if
							// (type.equals(TextConstants.INCIDENT_RELEASECOMPLETION_NAME))
							// {
							// newInci =
							// Incident.createReleaseCompletionIncident(project.getReleasePlan().firstElement());
							// }if
							// (type.equals(TextConstants.INCIDENT_SPRINTCOMPLETION_NAME))
							// {
							// //newInci =
							// Incident.createSprintCompletionIncident(project.getSprints().get(0));
							// project.checkDeadlines();
							// Vector<Incident> vector =
							// project.getProjectIncidents();
							// //project.update(project, newInci);
							// newInci = vector.firstElement();
							//
							// }
							if (type.equals("Sonstiges Ereignis")) {
								newInci = Incident.createOtherIssueIncident(
										name, description, startDate, endDate);
							}

							// TODO: typabfragen für krankheit, task, pbi
							// usw........

						}
						// Fehlerbehandlung für ungültige Eingaben
						catch (NoValidValueException e) {
							GwtUtils.displayError(e);
						}

						// Methode für das hinzufügen eines Incidents in den
						// root aufrufen
						newInci.addProject(project);
						ProjectHistoryPresenter.this.addIncident(newInci);
						ProjectHistoryPresenter.this.initialize();
					}
				});

		// Handler für das hinzufügen eines Incidents
		this.getView().addchangeTypHandler(
				new EventHandler<IncidentDetailArgs>() {

					@Override
					public void onUpdate(Object sender,
							IncidentDetailArgs eventArgs) {

						// der durch die eventArgs übergebene Typ wird in eine
						// variable "type" gesepeichert
						String type = eventArgs.getTyp();

						if (type.equals("Sonstiges Ereignis")) {
							ProjectHistoryPresenter.this.getView()
									.getOtherIssueView();
						} else {
							ProjectHistoryPresenter.this.getView()
									.getNormalView();
						}
					}
				});
	}

	/**
	 * Use this Method to add a Incident to the session
	 * 
	 * @param Incident
	 *            newInci
	 */
	protected void addIncident(Incident newInci) {
		try {
			this.project.addIncident(newInci);
		} catch (DoubleDefinitionException e) {
			GwtUtils.displayError(e);
		}

	}

	/**
	 * This method fills the view with standard informations like persons or
	 * allready created incidents
	 */
	private void initialize() {
		this.getView().refreshProjectHistoryTable(
				this.project.getProjectIncidents());

		Vector<IPerson> persons = new Vector<IPerson>();
		persons.addAll(this.getSessionManager().getModel().getPersons());
		this.getView().refreshPersons(persons);
	}

	@Override
	protected ProjectHistoryView createView() {
		return new ProjectHistoryView();

	}

}
