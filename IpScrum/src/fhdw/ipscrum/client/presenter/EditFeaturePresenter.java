package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.EditFeatureView;
import fhdw.ipscrum.client.view.interfaces.IEditFeatureView;
import fhdw.ipscrum.shared.exceptions.NoPBISelectedException;
import fhdw.ipscrum.shared.model.Feature;

public class EditFeaturePresenter extends EditPBIPresenter {

	public EditFeaturePresenter(Panel parent, Feature feature,
			Presenter<?> parentPresenter) throws NoPBISelectedException {
		super(parent, feature, parentPresenter);
	}

	@Override
	protected IEditFeatureView createView() {
		return new EditFeatureView();
	}
}
