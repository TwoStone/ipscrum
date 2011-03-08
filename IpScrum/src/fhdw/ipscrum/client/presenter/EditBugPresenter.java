package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.presenter.interfaces.IBugPresenter;
import fhdw.ipscrum.client.view.EditBugView;
import fhdw.ipscrum.client.view.interfaces.IEditBugView;
import fhdw.ipscrum.shared.exceptions.NoPBISelectedException;
import fhdw.ipscrum.shared.model.Feature;

public class EditBugPresenter extends EditPBIPresenter implements IBugPresenter {
	private final IBugPresenter bugPresenter;

	public EditBugPresenter(Panel parent, Feature feature, Presenter<?> parentPresenter) throws NoPBISelectedException {
		super(parent, feature, parentPresenter);
		bugPresenter = null;// new BugPresenter(this.getView());
	}

	@Override
	protected EditBugView createView() {
		return new EditBugView();
	}

	@Override
	public void registerViewEvents() {
		super.registerViewEvents();
		bugPresenter.registerViewEvents();
	}
}
