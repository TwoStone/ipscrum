package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.presenter.interfaces.IBugPresenter;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.CreateBugView;
import fhdw.ipscrum.client.view.interfaces.ICreateBugView;
import fhdw.ipscrum.shared.exceptions.NoPBISelectedException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.ProductBacklog;

public class CreateBugPresenter extends CreatePBIPresenter implements IBugPresenter {
	private IBugPresenter bugPresenter;

	public CreateBugPresenter(Panel parent, ProductBacklog backlog, Presenter<?> parentPresenter) throws NoPBISelectedException {
		super(parent, createNewBug(backlog), parentPresenter);
	}

	@Override
	protected ICreateBugView createView() {
		ICreateBugView view = new CreateBugView();
		bugPresenter = new BugPresenter(view, this);
		return view;
	}

	@Override
	public void registerViewEvents() {
		super.registerViewEvents();
		bugPresenter.registerViewEvents();
	}

	@Override
	public void updateView() {
		super.updateView();
		this.bugPresenter.updateView();
	}

	/**
	 * Creates a new feature. Only for internal use because catching exceptions in constructor does not work.
	 * 
	 * @return Bug A new {@link Bug} with dummy name.
	 */
	private static Bug createNewBug(final ProductBacklog backlog) {
		try {
			// Übergeben eines Platzhalters als Namen, da erstellen mit leerem Namen nicht funktioniert.
			return new Bug(NEWPBINAME, "", backlog.getProject().getReleasePlan().get(0), backlog);
		} catch (final UserException e) {
			GwtUtils.displayError(e);
		}
		return null;
	}

	@Override
	public void setupView() {
		super.setupView();
		this.bugPresenter.setupView();
	}

	@Override
	public void updatePBI() throws UserException {
		super.updatePBI();
		this.bugPresenter.updatePBI();
	}
}
