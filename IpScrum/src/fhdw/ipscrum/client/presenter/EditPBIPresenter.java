package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.interfaces.IEditPBIView;
import fhdw.ipscrum.client.view.interfaces.IPBIView;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoPBISelectedException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.PBIClosedState;
import fhdw.ipscrum.shared.model.PBIOpenState;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.visitor.IPBIStateVisitor;

/**
 * Presenter to edit a feature.
 */
public abstract class EditPBIPresenter extends PBIPresenter<IPBIView> {

	/**
	 * Constructor for EditFeaturePresenter.
	 * 
	 * @param parent Panel
	 * @param pbi Feature
	 * @param parentPresenter
	 * @throws NoPBISelectedException
	 */
	public EditPBIPresenter(final Panel parent, final ProductBacklogItem pbi, final Presenter<?> parentPresenter) throws NoPBISelectedException {
		super(parent, pbi, parentPresenter);
	}

	@Override
	public void registerViewEvents() {
		super.registerViewEvents();
		((IEditPBIView) this.getView()).toggleFeatureState().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				EditPBIPresenter.this.toggleFeatureState();
			}
		});
	}

	/**
	 * Closes the pbi if its open. If pbi is closed, nothing will be done.
	 */
	private void toggleFeatureState() {
		this.getPbi().getState().accept(new IPBIStateVisitor() {

			@Override
			public void handleClosed(final PBIClosedState closed) {
			}

			@Override
			public void handleOpen(final PBIOpenState open) {
				try {
					EditPBIPresenter.this.getPbi().close();
					EditPBIPresenter.this.finish();
				} catch (final ForbiddenStateException e) {
					GwtUtils.displayError(e);
				}
			}
		});
	}

	@Override
	public void updatePBI() throws NoValidValueException, NoSprintDefinedException, ConsistencyException, DoubleDefinitionException, ForbiddenStateException, UserException {
		super.updatePBI();
		this.getPbi().setManDayCosts(((IEditPBIView) this.getView()).getComplexity());
	}

	@Override
	public void updateView() {
		super.updateView();
		((IEditPBIView) this.getView()).setLastEditor(this.getPbi().getLastEditor());
		((IEditPBIView) this.getView()).setComplexity(this.getPbi().getManDayCosts());
		((IEditPBIView) this.getView()).setState(this.getPbi().getState());
	}
}
