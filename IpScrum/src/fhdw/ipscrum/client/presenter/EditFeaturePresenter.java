package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.EditFeatureView;
import fhdw.ipscrum.client.view.interfaces.IEditFeatureView;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoFeatureSelectedException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.PBIClosedState;
import fhdw.ipscrum.shared.model.PBIOpenState;
import fhdw.ipscrum.shared.model.visitor.IPBIStateVisitor;

/**
 * Presenter to edit a feature.
 */
public class EditFeaturePresenter extends FeaturePresenter<IEditFeatureView> {

	/**
	 * Constructor for EditFeaturePresenter.
	 * 
	 * @param parent
	 *            Panel
	 * @param feature
	 *            Feature
	 * @param parentPresenter
	 * @throws NoFeatureSelectedException
	 */
	public EditFeaturePresenter(final Panel parent, final Feature feature,
			final Presenter<?> parentPresenter)
			throws NoFeatureSelectedException {
		super(parent, feature, parentPresenter);
	}

	/**
	 * Method createView.
	 * 
	 * @return IEditFeatureView
	 */
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

	@Override
	protected void setupView() {
		super.setupView();
		this.getView().setComplexity(this.getFeature().getManDayCosts());
	}

	/**
	 * Closes the feature if its open. If feature is closed, nothing will be
	 * done.
	 */
	private void toggleFeatureState() {
		this.getFeature().getState().accept(new IPBIStateVisitor() {

			@Override
			public void handleClosed(final PBIClosedState closed) {
			}

			@Override
			public void handleOpen(final PBIOpenState open) {
				try {
					EditFeaturePresenter.this.getFeature().close();
					EditFeaturePresenter.this.finish();
				} catch (final ForbiddenStateException e) {
					GwtUtils.displayError(e.getMessage());
				}
			}
		});
	}

	@Override
	protected void updateFeature() throws NoValidValueException,
			NoSprintDefinedException, ConsistencyException,
			DoubleDefinitionException, ForbiddenStateException {
		super.updateFeature();
		this.getFeature().setManDayCosts(this.getView().getComplexity());
	}

	@Override
	protected void updateView() {
		super.updateView();
		this.getView().setLastEditor(this.getFeature().getLastEditor());
		this.getView().setState(this.getFeature().getState());
	}
}
