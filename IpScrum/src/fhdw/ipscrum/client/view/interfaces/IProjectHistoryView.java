package fhdw.ipscrum.client.view.interfaces;

import java.util.Vector;

import fhdw.ipscrum.shared.model.incidents.Incident;

public interface IProjectHistoryView extends IView {

	public void refreshProjectHistoryTable(Vector<Incident> incidents);
	
}
