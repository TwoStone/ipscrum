package fhdw.ipscrum.client.presenter;

import java.util.Vector;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.SearchView;
import fhdw.ipscrum.client.view.interfaces.ISearchView;
import fhdw.ipscrum.shared.model.search.And;
import fhdw.ipscrum.shared.model.search.Search;
import fhdw.ipscrum.shared.model.search.SearchExpression;
import fhdw.ipscrum.shared.model.search.criterias.PBINameCriteria;

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
		// SearchExpression se = new Not(new Not(new Not(new Not(new Not(new Not(new Not(new Not(new Not(new Not(new Not(new Not(new Not(new
		// PBINameCriteria("der zu suchende Name des PBIs"))))))))))))));
		Vector<SearchExpression> sev = new Vector<SearchExpression>();
		// sev.add(new Not(null));
		sev.add(new PBINameCriteria("der zu suchende Name des PBIs"));
		sev.add(new PBINameCriteria("der zu suchende Name des PBIs"));
		// sev.add(new NoSearchExpression());
		// this.concreteView.setSearch(new Search("test", new And(sev))); // TODO Suche: Testdaten durch korrekte ersetzen
		// this.concreteView.setSearch(new Search("test", new Not(new Not(new Not(new Not(new Not(new Not(new Not(new Not(new Not(new Not(new Not(new Not(new Not(new PBINameCriteria(
		// "der zu suchende Name des PBIs"))))))))))))))));
		this.concreteView.setSearch(new Search("test", new And(sev)));
	}

	/**
	 * this is called to update the guidata
	 */
	private void updateGuiData(SearchExpression searchPart) {
		this.concreteView.addSearchExpression(searchPart);
	}
}
