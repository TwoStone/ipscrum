package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;

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
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.Observer;

/**
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
					"Kein Feature ausgewählt zur Bearbeitung!");
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
	private void createRelation(final Panel panel) {
		GwtUtils.displayError("Not yet implemented!");
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
				FeaturePresenter.this.save();
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
				FeaturePresenter.this.createRelation(GwtUtils
						.createDialog("Relationen anlegen"));
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
		this.feature.removeAcceptanceCriterion(criterion);
	}

	/**
	 * Removes the {@link Hint} from the {@link Feature}.
	 * 
	 * @param hint
	 *            Hint
	 */
	private void removeHint(final Hint hint) {
		this.feature.removeHint(hint);
	}

	/**
	 * Removes the {@link Relation} from the {@link Feature}.
	 * 
	 * @param relation
	 *            Relation
	 */
	private void removeRelation(final Relation relation) {
		this.feature.removeRelation(relation);
	}

	/**
	 * Saves the made changes to the model.
	 */
	private void save() {
		try {
			this.updateFeature();
			this.finish();
		} catch (final NoValidValueException e) {
			GwtUtils.displayError(e.getMessage());
		} catch (final NoSprintDefinedException e) {
			GwtUtils.displayError(e.getMessage());
		} catch (final ConsistencyException e) {
			GwtUtils.displayError(e.getMessage());
		}
	}

	/**
	 * Sets the values of the loaded feature in the view.
	 */
	protected void setupView() {
		this.getView().setName(
				this.feature.getName().replaceAll(NEWFTRNAME, ""));
		this.getView().setDescription(this.feature.getDescription());
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
	 */
	protected void updateFeature() throws NoValidValueException,
			NoSprintDefinedException, ConsistencyException {
		this.feature.setName(this.getView().getName());
		this.feature.setDescription(this.getView().getDescription());
		this.feature.setSprint(this.getView().getSelectedSprint());
	}

	/**
	 * Updates the view with the values of the feature. Does not set name and
	 * description. Call setupView to set them.
	 */
	protected void updateView() {
		this.getView().setHints(this.feature.getHints());
		this.getView().setRelations(this.feature.getRelations());
		this.getView().setCriteria(this.feature.getAcceptanceCriteria());
		final ArrayList<ISprint> sprints = new ArrayList<ISprint>(this.feature
				.getBacklog().getProject().getSprints());
		this.getView().setSprints(sprints, this.getFeature().getSprint());
	}
}