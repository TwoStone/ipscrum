package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.interfaces.IPBIView;
import fhdw.ipscrum.shared.exceptions.NoPBISelectedException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.ProductBacklogItem;

/**
 * Presenter for creating new ProductBacklogItems.
 * 
 * @author Niklas
 */
public abstract class CreatePBIPresenter extends PBIPresenter<IPBIView> {

	/**
	 * Creates a new instance of {@link CreatePBIPresenter} with an empty feature.
	 * 
	 * @param parent
	 * @param backlog
	 * @param parentPresenter
	 * @throws NoPBISelectedException
	 */
	public CreatePBIPresenter(final Panel parent, final ProductBacklogItem pbi, final Presenter<?> parentPresenter) throws NoPBISelectedException {
		super(parent, pbi, parentPresenter);
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
