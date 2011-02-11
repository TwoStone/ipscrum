package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.CreateFeatureView;
import fhdw.ipscrum.client.view.interfaces.ICreateFeatureView;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.observer.Observer;

/**
 */
public class CreateFeaturePresenter extends
		FeaturePresenter<ICreateFeatureView> implements Observer {
	private static final String NEWFTRNAME = "###empty###";

	/**
	 * Method createNewFeature.
	 * 
	 * @param backlog
	 *            ProductBacklog
	 * 
	 * @return Feature
	 */
	private static Feature createNewFeature(final ProductBacklog backlog) {
		try {
			return new Feature(NEWFTRNAME, "", backlog);
		} catch (final NoValidValueException e) {
			GwtUtils.displayError(e.getMessage());
		} catch (final ConsistencyException e) {
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
	 */
	public CreateFeaturePresenter(final Panel parent,
			final ProductBacklog backlog) {
		super(parent, createNewFeature(backlog));
	}

	/**
	 * Method createView.
	 * 
	 * @return ICreateFeatureView
	 */
	@Override
	protected ICreateFeatureView createView() {
		return new CreateFeatureView();
	}

}
