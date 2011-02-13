package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.RemoveCriterionEventArgs;
import fhdw.ipscrum.client.events.args.RemoveHintEventArgs;
import fhdw.ipscrum.client.events.args.RemoveRelationEventArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.interfaces.ICreateFeatureView;
import fhdw.ipscrum.client.view.widgets.AbortDialog;
import fhdw.ipscrum.client.view.widgets.AbortDialog.OnOkayCommand;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoFeatureSelectedException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.NothingSelectedException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.Observer;

/**
 * Base class for presenting {@link Feature}s.
 */
public abstract class FeaturePresenter<T extends ICreateFeatureView> extends
		Presenter<T> implements Observer {
	protected static final String NEWFTRNAME = "###empty###";

	private final Feature feature;

	/**
	 * Constructor for FeaturePresenter.
	 * 
	 * @param parent
	 *            Panel
	 * @param feature
	 *            Feature
	 * @throws NoFeatureSelectedException
	 */
	public FeaturePresenter(final Panel parent, final Feature feature)
			throws NoFeatureSelectedException {
		super(parent);
		if (feature == null) {
			this.abort();
			throw new NoFeatureSelectedException(
					"Kein Feature ausgew�hlt zur Bearbeitung!");
		}
		this.feature = feature;
		this.feature.addObserver(this);
		this.setupView();
		this.registerViewEvents();
	}

	/**
	 * Creates a new presenter to create a new {@link AcceptanceCriterion}
	 * 
	 * @param panel
	 *            Panel where the widget should be added.
	 */
	private void createCriterion(final Panel panel) {
		final AcceptanceCriterionPresenter presenter = new AcceptanceCriterionPresenter(
				panel);
		this.getView().setNewCriterionEnabled(false);
		presenter.getFinished().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				try {
					FeaturePresenter.this.feature
							.addAcceptanceCriterion(presenter.getCriterion());
					panel.clear();
					FeaturePresenter.this.getView()
							.setNewCriterionEnabled(true);
				} catch (final DoubleDefinitionException e) {
					GwtUtils.displayError(e.getMessage());
				} catch (final ForbiddenStateException e) {
					GwtUtils.displayError(e.getMessage());
				}

			}
		});
		presenter.getAborted().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				panel.clear();
				FeaturePresenter.this.getView().setNewCriterionEnabled(true);
			}
		});
	}

	/**
	 * Creates a new presenter to create a new {@link Hint}
	 * 
	 * @param panel
	 *            Panel where the widget should be added.
	 */
	private void createHint(final Panel panel) {
		final HintPresenter presenter = new HintPresenter(panel);
		this.getView().setNewHintEnabled(false);
		presenter.getFinished().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				try {
					FeaturePresenter.this.feature.addHint(presenter.getHint());
				} catch (final DoubleDefinitionException e) {
					GwtUtils.displayError(e.getMessage());
				} catch (final ForbiddenStateException e) {
					GwtUtils.displayError(e.getMessage());
				}
				panel.clear();
				FeaturePresenter.this.getView().setNewHintEnabled(true);
			}
		});
		presenter.getAborted().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				panel.clear();
				FeaturePresenter.this.getView().setNewHintEnabled(true);
			}
		});
	}

	/**
	 * Creates a presenter to create a new {@link Relation}
	 * 
	 * @param createDialog
	 *            DialogBox
	 */
	private void createRelation() {
		final DialogBox box = GwtUtils.createDialog("Beziehung anlegen");
		box.center();
		final CreateRelationPresenter presenter = new CreateRelationPresenter(
				box, this.getFeature());

		presenter.getFinished().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				try {
					FeaturePresenter.this.getFeature().addRelation(
							presenter.getRelation());
					box.hide();
				} catch (final UserException e) {
					GwtUtils.displayError(e.getMessage());
				}
			}
		});

		presenter.getAborted().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				new AbortDialog(new OnOkayCommand() {

					@Override
					public void onExecute() {
						box.hide();
					}
				});
			}
		});
	}

	/**
	 * Returns the currently loaded feature.
	 * 
	 * @return Feature
	 */
	public Feature getFeature() {
		return this.feature;
	}

	/**
	 * Registers the presenter to all events of the view.
	 */
	protected void registerViewEvents() {

		this.getView().getSave().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				FeaturePresenter.this.finish();
			}
		});

		this.getView().getAbort().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				new AbortDialog(new OnOkayCommand() {

					@Override
					public void onExecute() {
						FeaturePresenter.this.abort();
					}
				});
			}
		});

		this.getView().getCreateCriterion().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				FeaturePresenter.this.createCriterion(FeaturePresenter.this
						.getView().addCriterionPanel());
			}
		});

		this.getView().getCreateHint().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				FeaturePresenter.this.createHint(FeaturePresenter.this
						.getView().addHintPanel());
			}
		});

		this.getView().getCreateRelation().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				FeaturePresenter.this.createRelation();
			}
		});

		this.getView().getRemoveCriterion()
				.add(new EventHandler<RemoveCriterionEventArgs>() {
					@Override
					public void onUpdate(final Object sender,
							final RemoveCriterionEventArgs eventArgs) {
						FeaturePresenter.this.removeCriterion(eventArgs
								.getCriterion());
					}
				});

		this.getView().getRemoveHint()
				.add(new EventHandler<RemoveHintEventArgs>() {
					@Override
					public void onUpdate(final Object sender,
							final RemoveHintEventArgs eventArgs) {
						FeaturePresenter.this.removeHint(eventArgs.getHint());
					}
				});

		this.getView().getRemoveRelation()
				.add(new EventHandler<RemoveRelationEventArgs>() {
					@Override
					public void onUpdate(final Object sender,
							final RemoveRelationEventArgs eventArgs) {
						FeaturePresenter.this.removeRelation(eventArgs
								.getRelation());
					}
				});
	}

	/**
	 * Removes the {@link AcceptanceCriterion} from the {@link Feature}.
	 * 
	 * @param criterion
	 *            AcceptanceCriterion
	 */
	private void removeCriterion(final AcceptanceCriterion criterion) {
		try {
			this.feature.removeAcceptanceCriterion(criterion);
		} catch (final ForbiddenStateException e) {
			GwtUtils.displayError(e.getMessage());
		}
	}

	/**
	 * Removes the {@link Hint} from the {@link Feature}.
	 * 
	 * @param hint
	 *            Hint
	 */
	private void removeHint(final Hint hint) {
		try {
			this.feature.removeHint(hint);
		} catch (final ForbiddenStateException e) {
			GwtUtils.displayError(e.getMessage());
		}
	}

	/**
	 * Removes the {@link Relation} from the {@link Feature}.
	 * 
	 * @param relation
	 *            Relation
	 */
	private void removeRelation(final Relation relation) {
		try {
			this.feature.removeRelation(relation);
		} catch (final ForbiddenStateException e) {
			GwtUtils.displayError(e.getMessage());
		}
	}

	@Override
	protected boolean onFinish() {
		try {
			FeaturePresenter.this.updateFeature();
		} catch (final DoubleDefinitionException e) {
			this.abort();
			return false;
		} catch (final UserException e) {
			GwtUtils.displayError(e.getMessage());
			return false;
		}
		return super.onFinish();

	}

	/**
	 * Sets the values of the loaded feature in the view.
	 */
	protected void setupView() {
		this.getView().setName(
				this.feature.getName().replaceAll(NEWFTRNAME, ""));
		this.getView().setDescription(this.feature.getDescription());
		final ArrayList<ISprint> sprints = new ArrayList<ISprint>(this.feature
				.getBacklog().getProject().getSprints());
		this.getView().setSprints(sprints, this.getFeature().getSprint());
		this.updateView();
	}

	/**
	 * Method update.
	 * 
	 * @param observable
	 *            Observable
	 * @param argument
	 *            Object
	 * @see fhdw.ipscrum.shared.observer.Observer#update(Observable, Object)
	 */
	@Override
	public void update(final Observable observable, final Object argument) {
		this.updateView();

	}

	/**
	 * Updates the loaded feature with the values set in the view.
	 * 
	 * @throws NoValidValueException
	 * @throws NoSprintDefinedException
	 * @throws ConsistencyException
	 * @throws DoubleDefinitionException
	 * @throws ForbiddenStateException
	 */
	protected void updateFeature() throws NoValidValueException,
			NoSprintDefinedException, ConsistencyException,
			DoubleDefinitionException, ForbiddenStateException {
		this.feature.setName(this.getView().getName());
		this.feature.setDescription(this.getView().getDescription());

		try {
			this.feature.setSprint(this.getView().getSelectedSprint());
		} catch (final NothingSelectedException e) {
			// Kein Sprint ausgewählt, also setzen wir den Sprint auf null.
			// TODO NoObject Pattern wäre besser, gibt es für Sprint aber zZ
			// nicht.
			this.feature.setSprint(null);
		}
	}

	/**
	 * Updates the view with the values of the feature. Does not set name and
	 * description. Call setupView to set them.
	 */
	protected void updateView() {
		this.getView().setHints(this.feature.getHints());
		this.getView().setRelations(this.feature.getRelations());
		this.getView().setCriteria(this.feature.getAcceptanceCriteria());

	}
}