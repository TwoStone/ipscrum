package fhdw.ipscrum.client.presenter;

import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.ProjectHistoryView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.incidents.Incident;
import fhdw.ipscrum.shared.model.incidents.IncidentType;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

/**
 * Presenter for creating a Project History
 * 
 * @author Phase IV - Group Reporting II
 * 
 */
public class ProjectHistoryPresenter extends Presenter<ProjectHistoryView> {

	Project project;

	/**
	 * Creates a new instance of {@link ProjectHistoryPresenter}
	 * 
	 * @param parent
	 * @param parentPresenter
	 */
	public ProjectHistoryPresenter(Panel parent, Presenter<?> parentPresenter,
			Project project) {
		super(parent, parentPresenter);
		this.project = project;
		this.setupHandlers();
		this.initialize();
	}
	
	/**
	 * Adds the Handlers
	 */
	private void setupHandlers() {

		// Handler für das Hinzufügen eines neuen Typs
		this.getView().addcreateTypeHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				final DialogBox diaBox = GwtUtils
						.createDialog(TextConstants.CREATE_INCIDENT_ENG);
				CreateIncidentTypePresenter presenter = new CreateIncidentTypePresenter(
						diaBox, ProjectHistoryPresenter.this);
				diaBox.center();

				presenter.getFinished().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						initialize();
						diaBox.hide();
					}
				});
				presenter.getAborted().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {

						diaBox.hide();
					}
				});
			}
		});

		// Handler für das hinzufügen eines Incidents
		this.getView().addcreateIncidentHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				final DialogBox diaBox = GwtUtils
						.createDialog(TextConstants.CREATE_INCIDENT_ENG);

				CreateIncidentPresenter presenter = new CreateIncidentPresenter(
						diaBox, ProjectHistoryPresenter.this);

				diaBox.center();

				presenter.getAborted().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						diaBox.hide();
					}

				});

				presenter.getFinished().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						initialize();
						diaBox.hide();
					}
				});

			}
		});

		getView().addShowIncidentsHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				initialize();
			}
		});

	}

	/**
	 * This method fills the view with standard informations like persons or
	 * already created incidents
	 */
	private void initialize() {

		Vector<Incident> incidents = this.project.getProjectIncidents();
		incidents.addAll(this.getSessionManager().getModel()
				.getGlobalIncidents());

		Set<IncidentType> types = this.getView().getTypes();

		if (types.size() != 0) {

			incidents = filterIncidents();

		}

		this.getView().refreshProjectHistoryTable(incidents);

		Vector<IPerson> persons = new Vector<IPerson>();
		persons.addAll(this.getSessionManager().getModel().getPersons());
		Vector<IncidentType> incidentTypes = new Vector<IncidentType>();
		incidentTypes.addAll(this.getSessionManager().getModel()
				.getIncidentTypes());
		this.getView().refreshTypes(incidentTypes);
	}

	/**
	 * Use this method filter the created incidents
	 */
	private Vector<Incident> filterIncidents() {

		Set<IncidentType> types = this.getView().getTypes();

		Vector<Incident> incis = new Vector<Incident>();

		Iterator<Incident> globalIncisIt = this.getSessionManager().getModel()
				.getGlobalIncidentsIterator();

		while (globalIncisIt.hasNext()) {
			Incident currentIncident = globalIncisIt.next();

			if (types.contains(currentIncident.getIncidentType())) {
				incis.add(currentIncident);
			}
		}

		Iterator<Incident> projectIncis = this.project.getProjectIncidents()
				.iterator();

		while (projectIncis.hasNext()) {
			Incident currentIncident = projectIncis.next();

			if (types.contains(currentIncident.getIncidentType())) {
				incis.add(currentIncident);
			}
		}
		return incis;
	}

	@Override
	protected ProjectHistoryView createView() {
		return new ProjectHistoryView();

	}

}