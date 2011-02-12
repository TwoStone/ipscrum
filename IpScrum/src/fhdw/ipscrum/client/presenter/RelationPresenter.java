package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.interfaces.IRelationView;
import fhdw.ipscrum.shared.model.Feature;

/**
 */
public class RelationPresenter extends Presenter<IRelationView> {
	private final Feature source;

	/**
	 * Constructor for RelationPresenter.
	 * 
	 * @param parent
	 *            Panel
	 * @param backlog
	 *            ProductBacklog
	 */
	public RelationPresenter(final Panel parent, final Feature source) {
		super(parent);
		this.source = source;
	}

	/**
	 * Method createView.
	 * 
	 * @return IRelationView
	 */
	@Override
	protected IRelationView createView() {
		// TODO Create View
		return null;
	}

	private void updateView() {

	}

}
