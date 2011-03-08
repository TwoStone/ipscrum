package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.CreateFeatureView;
import fhdw.ipscrum.client.view.interfaces.ICreateFeatureView;
import fhdw.ipscrum.shared.exceptions.NoPBISelectedException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklog;

public class CreateFeaturePresenter extends CreatePBIPresenter {

	public CreateFeaturePresenter(Panel parent, ProductBacklog backlog, Presenter<?> parentPresenter) throws NoPBISelectedException {
		super(parent, createNewFeature(backlog), parentPresenter);
	}

	@Override
	protected ICreateFeatureView createView() {
		return new CreateFeatureView();
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
			GwtUtils.displayError(e);
		}
		return null;
	}
}
