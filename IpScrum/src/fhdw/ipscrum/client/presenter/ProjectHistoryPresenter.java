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

						// Eigenschaften des Incidents aus der View holen:
						// Beschreibung
						String description = ProjectHistoryPresenter.this 
								.getView().getDescriptionText();
						// Ende-Datum
						Date endDate = ProjectHistoryPresenter.this.getView() 
								.getEndDate();
						// Start-Datum
						Date startDate = ProjectHistoryPresenter.this.getView() 
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
				
							// Urlaub
							if (type.equals(TextConstants.INCIDENT_VACATION_NAME)) {
								if (startDate == null || endDate == null || pers == null) {
									GwtUtils.displayWarning("Bitte ein Start- und Ende-Datum und eine Person auswählen!");
								}else{
								newInci = Incident.createVacationIncident(pers,
										startDate, endDate);
								ProjectHistoryPresenter.this.getSessionManager().getModel().getGlobalIncidents().add(newInci);
								ProjectHistoryPresenter.this.initialize();}
							}
							//Krankheit
							if (type.equals(TextConstants.INCIDENT_ILLNESS_NAME)) {
								if (startDate == null || endDate == null || pers == null) {
									GwtUtils.displayWarning("Bitte ein Start- und Ende-Datum und eine Person auswählen!");
								}else{
								newInci = Incident.createIllnessIncident(pers,
										startDate, endDate);
								ProjectHistoryPresenter.this.getSessionManager().getModel().getGlobalIncidents().add(newInci);
								ProjectHistoryPresenter.this.initialize();}
							}
							//Sonstiges Ereignis
							if (type.equals("Sonstiges Ereignis")) {
								if (startDate == null || endDate == null || description.equals("") || name.equals("")) {
									GwtUtils.displayWarning("Bitte Start-, Ende-Datum, Namen und Beschreibung eingeben!");
								}else{
								newInci = Incident.createOtherIssueIncident(
										name, description, startDate, endDate);
								ProjectHistoryPresenter.this.addIncident(newInci);
								ProjectHistoryPresenter.this.initialize();}
							}

						}
						// Fehlerbehandlung für ungültige Eingaben
						catch (NoValidValueException e) {
							GwtUtils.displayError(e);
						}

						// Methode für das hinzufügen eines Incidents in den
						// root aufrufen
//						if (newInci != null){
//						newInci.addProject(project);
//						ProjectHistoryPresenter.this.addIncident(newInci);
//						ProjectHistoryPresenter.this.initialize();
					}
					//	}
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
//			newInci.addProject(this.project);
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
		Vector<Incident> incidents = this.project.getProjectIncidents();
		incidents.addAll(this.getSessionManager().getModel().getGlobalIncidents());
		this.getView().refreshProjectHistoryTable(incidents);

		Vector<IPerson> persons = new Vector<IPerson>();
		persons.addAll(this.getSessionManager().getModel().getPersons());
		this.getView().refreshPersons(persons);
	}

	@Override
	protected ProjectHistoryView createView() {
		return new ProjectHistoryView();

	}

}
