package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.Collection;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.SearchView;
import fhdw.ipscrum.client.view.interfaces.ISearchView;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.search.And;
import fhdw.ipscrum.shared.model.search.Search;

/**
 * presenter class of the team interface. this interface is used to inspect, create and modify teams as well as adding and removing persons to teams.
 */
public class SearchPresenter extends Presenter<ISearchView> {

	private ISearchView concreteView;

	/**
	 * Constructor for TeamPresenter.
	 * 
	 * @param parent Panel
	 * @param parentPresenter
	 */
	public SearchPresenter(final Panel parent, final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
	}

	/**
	 * Method createView.
	 * 
	 * @return ITeamView
	 */
	@Override
	protected ISearchView createView() {
		this.concreteView = new SearchView();
		this.setupEventHandlers();
		return this.concreteView;
	}

	/**
	 * this is called to set up the behaviour of all interaction widgets of this view.
	 */
	private void setupEventHandlers() {
		this.concreteView.setSearch(new Search("test", new And(null)));
		this.concreteView.setProjects(this.getSessionManager().getModel().getProjects());
		this.concreteView.setSystems(this.getSessionManager().getModel().getSysManager().getSystems().getSystems());
		this.concreteView.setRelationTypes(this.getSessionManager().getModel().getRelationTypeManager().getRelationTypes());
		Collection<IPerson> persons = new ArrayList<IPerson>();
		for (IPerson person : this.getSessionManager().getModel().getPersons()) {
			persons.add(person);
		}
		this.concreteView.setPersons(persons);
	}
}
