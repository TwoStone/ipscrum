package fhdw.ipscrum.client.view.interfaces;


import java.util.Date;
import java.util.Vector;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.IncidentDetailArgs;
import fhdw.ipscrum.shared.model.incidents.Incident;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public interface IProjectHistoryView extends IView {
	
	public void refreshPersons(Vector<IPerson> persons);

	public void refreshProjectHistoryTable(Vector<Incident> incidents);

	void addcreateIncidentHandler(EventHandler<IncidentDetailArgs> args);

	public Date getStartDate();
	
	public Date getEndDate();
	
	public IPerson getPerson();

	void addchangeTypHandler(EventHandler<IncidentDetailArgs> args);

	public String getDescriptionText();

	public void getOtherIssueView();

	public void getNormalView();

	public String getName();
	
	
	
}
