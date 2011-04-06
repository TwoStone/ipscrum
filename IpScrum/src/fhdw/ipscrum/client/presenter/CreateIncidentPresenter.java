package fhdw.ipscrum.client.presenter;

import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.CreateIncidentView;
import fhdw.ipscrum.client.view.interfaces.ICreateIncidentView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.incidents.Incident;
import fhdw.ipscrum.shared.model.incidents.IncidentType;
import fhdw.ipscrum.shared.model.incidents.MultipleParticipantIncident;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public class CreateIncidentPresenter extends Presenter<ICreateIncidentView> {

	public CreateIncidentPresenter(Panel parent, Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
		this.addHandler();
		this.initializeView();
	}

	private void initializeView() {
		getView()
				.refreshPersons(
						new Vector<IPerson>(getSessionManager().getModel()
								.getPersons()));
		getView().refreshProjects(
				new Vector<Project>(getSessionManager().getModel()
						.getProjects()));
		getView().refreshTypes(
				new Vector<IncidentType>(getSessionManager().getModel()
						.getIncidentTypes()));
	}

	private void addHandler() {
		this.getView().addCreateIncidentHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {

				Set<IPerson> persons = getView().getPersons();
				Set<Project> projects = getView().getProjects();
				IncidentType type = getView().getType();
				String description = getView().getDescription();
				Date startDate = getView().getStartDate();
				Date endeDate = getView().getEndDate();

				if (persons == null || type == null || startDate == null
						|| endeDate == null) {
					GwtUtils.displayError("Bitte Eingaben vervollständigen");
				} else {
					try {

						Incident newInci = null;

						if (type.equals(getSessionManager().getModel()
								.getIncidentTypeByName(
										TextConstants.INCIDENT_ILLNESS_NAME))) {
							newInci = Incident.createIllnessIncident(persons
									.iterator().next(), startDate, endeDate);
							getSessionManager().getModel().addIncident(newInci);
						} else if (type.equals(getSessionManager().getModel()
								.getIncidentTypeByName(
										TextConstants.INCIDENT_VACATION_NAME))) {
							newInci = Incident.createVacationIncident(persons
									.iterator().next(), startDate, endeDate);
							getSessionManager().getModel().addIncident(newInci);
						} else {
							newInci = Incident.createOtherIssueIncident(type,
									description, startDate, endeDate);
							Iterator<IPerson> persIt = persons.iterator();

							while (persIt.hasNext()) {
								((MultipleParticipantIncident) newInci)
										.addParticipant(persIt.next());
							}
							if (projects.size() == 0) {
								newInci.setGlobal(true);
								getSessionManager().getModel().addIncident(
										newInci);
							} else {

								Iterator<Project> it = projects.iterator();

								while (it.hasNext()) {
									it.next().addIncident(newInci);
								}
							}

						}

					} catch (DoubleDefinitionException e) {
						GwtUtils.displayError(e);
					} catch (NoValidValueException e) {
						GwtUtils.displayError(e);
					}

					CreateIncidentPresenter.this.finish();
				}

			}
		});

		this.getView().addCancelEventHandler(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				CreateIncidentPresenter.this.abort();
			}
		});
	}

	@Override
	protected ICreateIncidentView createView() {
		return new CreateIncidentView();
	}

}
