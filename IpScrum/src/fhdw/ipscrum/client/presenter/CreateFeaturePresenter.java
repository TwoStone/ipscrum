package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.CreateFeatureView;
import fhdw.ipscrum.client.view.interfaces.ICreateFeatureView;
import fhdw.ipscrum.shared.exceptions.NoFeatureSelectedException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.observer.Observer;

/**
 * Presenter for creating new features.
 * 
 * @author Niklas
 */
public class CreateFeaturePresenter extends
		FeaturePresenter<ICreateFeatureView> implements Observer {

	/**
	 * Creates a new feature. Only for internal use because catching exceptions
	 * in constructor does not work.
	 * 
	 * @return Feature A new {@link Feature} with dummy name.
	 */
	private static Feature createNewFeature(final ProductBacklog backlog) {
		try {
			// Übergeben eines Platzhalters als Namen, da erstellen mit leerem
			// Namen nicht funktioniert.
			return new Feature(NEWFTRNAME, "", backlog);
		} catch (final UserException e) {
			GwtUtils.displayError(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a new instance of {@link CreateFeaturePresenter} with an empty
	 * feature.
	 * 
	 * @param parent
	 * @param backlog
	 * @throws NoFeatureSelectedException
	 */
	public CreateFeaturePresenter(final Panel parent,
			final ProductBacklog backlog) throws NoFeatureSelectedException {
		super(parent, createNewFeature(backlog));
	}

	@Override
	protected ICreateFeatureView createView() {
		return new CreateFeatureView();
	}

	@Override
	protected boolean onAbort() {
		final ProductBacklog backlog = this.getFeature().getBacklog();
		try {
			backlog.removeItem(this.getFeature());
			return super.onAbort();
		} catch (final UserException e) {
			return false;
		}
	}

}
