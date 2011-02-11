package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.interfaces.IRelationView;
import fhdw.ipscrum.shared.model.ProductBacklog;

public class RelationPresenter extends Presenter<IRelationView> {
	private final ProductBacklog backlog;

	public RelationPresenter(final Panel parent, final ProductBacklog backlog) {
		super(parent);
		this.backlog = backlog;
	}

	@Override
	protected IRelationView createView() {
		// TODO Create View
		return null;
	}

	private void updateView() {

	}

}
