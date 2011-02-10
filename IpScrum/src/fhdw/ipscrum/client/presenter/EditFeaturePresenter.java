package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.EditFeatureView;
import fhdw.ipscrum.client.view.interfaces.IEditFeatureView;
import fhdw.ipscrum.shared.model.Feature;

public class EditFeaturePresenter extends Presenter<IEditFeatureView> {
	private final Feature feature;

	public EditFeaturePresenter(Panel parent, Feature feature) {
		super(parent);
		this.feature = feature;
		Window.alert("Sorry, not yet implemented!");
		this.abort();
	}

	@Override
	protected IEditFeatureView createView() {
		return new EditFeatureView();
	}

	public Feature getFeature() {
		return this.feature;
	}

}
