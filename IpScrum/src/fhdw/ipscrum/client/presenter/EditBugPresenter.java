package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.presenter.interfaces.IBugPresenter;
import fhdw.ipscrum.client.view.EditBugView;
import fhdw.ipscrum.client.view.interfaces.IEditBugView;
import fhdw.ipscrum.shared.exceptions.NoPBISelectedException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Bug;

public class EditBugPresenter extends EditPBIPresenter implements IBugPresenter {
	private IBugPresenter bugPresenter;

	public EditBugPresenter(Panel parent, Bug bug, Presenter<?> parentPresenter) throws NoPBISelectedException {
		super(parent, bug, parentPresenter);
	}

	@Override
	protected IEditBugView createView() {
		IEditBugView view = new EditBugView();
		bugPresenter = new BugPresenter(view, this);
		return view;
	}

	@Override
	public void registerViewEvents() {
		super.registerViewEvents();
		bugPresenter.registerViewEvents();
	}

	@Override
	public void setupView() {
		super.setupView();
		this.bugPresenter.setupView();
	}

	@Override
	public void updateView() {
		super.updateView();
		this.bugPresenter.updateView();
	}

	@Override
	public void updatePBI() throws UserException {
		super.updatePBI();
		this.bugPresenter.updatePBI();
	}
}
