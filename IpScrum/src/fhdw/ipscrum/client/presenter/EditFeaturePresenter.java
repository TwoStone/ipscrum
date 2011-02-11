package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.EditFeatureView;
import fhdw.ipscrum.client.view.interfaces.IEditFeatureView;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Closed;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Open;
import fhdw.ipscrum.shared.model.visitor.IFeatureVisitor;

public class EditFeaturePresenter extends FeaturePresenter<IEditFeatureView> {

	public EditFeaturePresenter(final Panel parent, final Feature feature) {
		super(parent, feature);

		this.updateView();
		this.registerViewEvents();
	}

	@Override
	protected IEditFeatureView createView() {
		return new EditFeatureView();
	}

	@Override
	protected void registerViewEvents() {
		super.registerViewEvents();
		this.getView().toggleFeatureState().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				EditFeaturePresenter.this.toggleFeatureState();
			}
		});
	}

	private void toggleFeatureState() {
		this.getFeature().getState().accept(new IFeatureVisitor() {

			@Override
			public void handleClosed(final Closed closed) {
			}

			@Override
			public void handleOpen(final Open open) {
				try {
					EditFeaturePresenter.this.getFeature().close();
				} catch (final ForbiddenStateException e) {
					GwtUtils.displayError(e.getMessage());
				}
			}
		});
	}

	@Override
	protected void updateFeature() throws NoValidValueException,
			NoSprintDefinedException, ConsistencyException {
		super.updateFeature();
		this.getFeature().setManDayCosts(this.getView().getComplexity());
	}

	@Override
	protected void updateView() {
		super.updateView();
		this.getView().setComplexity(this.getFeature().getManDayCosts());
		this.getView().setState(this.getFeature().getState());
	}
}
