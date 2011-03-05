package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.CreatePBIView;
import fhdw.ipscrum.client.view.interfaces.ICreatePBIView;
import fhdw.ipscrum.shared.exceptions.NoFeatureSelectedException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklog;

/**
 * Presenter for creating new ProductBacklogItems.
 * 
 * @author Niklas
 */
public class CreatePBIPresenter extends PBIPresenter<ICreatePBIView> {

	/**
	 * Creates a new instance of {@link CreatePBIPresenter} with an empty feature.
	 * 
	 * @param parent
	 * @param backlog
	 * @param parentPresenter
	 * @throws NoFeatureSelectedException
	 */
	public CreatePBIPresenter(final Panel parent, final ProductBacklog backlog, final Presenter<?> parentPresenter) throws NoFeatureSelectedException {
		super(parent, createNewBug(backlog), parentPresenter);
	}

	/**
	 * Creates a new feature. Only for internal use because catching exceptions in constructor does not work.
	 * 
	 * @return Feature A new {@link Feature} with dummy name.
	 */
	private static Feature createNewFeature(final ProductBacklog backlog) {
		try {
			// Übergeben eines Platzhalters als Namen, da erstellen mit leerem
			// Namen nicht funktioniert.
			return new Feature(NEWPBINAME, "", backlog);
		} catch (final UserException e) {
			GwtUtils.displayError(e.getMessage());
		}
		return null;
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
			GwtUtils.displayError(e.getMessage());
		}
		return null;
	}

	@Override
	protected ICreatePBIView createView() {
		return new CreatePBIView();
	}

	@Override
	protected boolean onAbort() {
		final ProductBacklog backlog = this.getPbi().getBacklog();
		try {
			backlog.removeItem(this.getPbi());
			return super.onAbort();
		} catch (final UserException e) {
			return false;
		}
	}

}
