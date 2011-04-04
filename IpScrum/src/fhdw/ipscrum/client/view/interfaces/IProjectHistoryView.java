package fhdw.ipscrum.client.view.interfaces;


import java.util.Date;
import java.util.Set;
import java.util.Vector;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.shared.model.incidents.Incident;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public interface IProjectHistoryView extends IView {
	
	public void refreshPersons(Vector<IPerson> persons);

	public void refreshProjectHistoryTable(Vector<Incident> incidents);

	void addcreateIncidentHandler(EventHandler<EventArgs> args);

	public Date getStartDate();
	
	public Date getEndDate();
	
	public IPerson getPerson();

	void addchangeTypHandler(EventHandler<EventArgs> args);

	public String getDescriptionText();

	public void getOtherIssueView();

	public void getNormalView();

	public String getName();

	public Set<IPerson> getPersons();

	public void initializeView();

	public String getType();
	
	
	
}
