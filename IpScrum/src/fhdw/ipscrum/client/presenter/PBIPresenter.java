package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.RemoveCriterionEventArgs;
import fhdw.ipscrum.client.events.args.RemoveHintEventArgs;
import fhdw.ipscrum.client.events.args.RemoveRelationEventArgs;
import fhdw.ipscrum.client.presenter.interfaces.IPBIPresenter;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.interfaces.IPBIView;
import fhdw.ipscrum.client.view.widgets.AbortDialog;
import fhdw.ipscrum.client.view.widgets.AbortDialog.OnOkayCommand;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoPBISelectedException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.NothingSelectedException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.Observer;

/**
 * Base class for presenting {@link Feature}s.
 */
public abstract class PBIPresenter<T extends IPBIView> extends Presenter<T> implements Observer, IPBIPresenter {
	protected static final String NEWPBINAME = "###empty###";

	private final ProductBacklogItem pbi;

	/**
	 * Constructor for PBIPresenter.
	 * 
	 * @param parent Panel
	 * @param feature Feature
	 * @param parentPresenter
	 * @throws NoPBISelectedException
	 */
	public PBIPresenter(final Panel parent, final ProductBacklogItem pbi, final Presenter<?> parentPresenter) throws NoPBISelectedException {
		super(parent, parentPresenter);

		// TODO Christin sollte das nicht in den Edit-Konsturktor?
		if (pbi == null) {
			this.abort();
			throw new NoPBISelectedException("Es wurde kein ProductBacklogItem zur Bearbeitung ausgewählt");
		}
		this.pbi = pbi;
		this.pbi.addObserver(this);
		this.setupView();
		this.registerViewEvents();
	}

	/**
	 * Creates a new presenter to create a new {@link AcceptanceCriterion}
	 */
	private void createCriterion() {
		final DialogBox box = GwtUtils.createDialog("Kriterium erstellen");

		final AcceptanceCriterionPresenter presenter = new AcceptanceCriterionPresenter(box, this);
		box.center();
		presenter.getFinished().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				try {
					PBIPresenter.this.pbi.addAcceptanceCriterion(presenter.getCriterion());
					box.hide();
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
				box.hide();
			}
		});
	}

	/**
	 * Creates a new presenter to create a new {@link Hint}
	 */
	private void createHint() {
		final DialogBox box = GwtUtils.createDialog("Hinweis erstellen");

		final HintPresenter presenter = new HintPresenter(box, this);

		box.center();
		presenter.getFinished().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				try {
					PBIPresenter.this.pbi.addHint(presenter.getHint());
					box.hide();
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
				box.hide();
			}
		});
	}

	/**
	 * Creates a presenter to create a new {@link Relation}
	 * 
	 * @param createDialog DialogBox
	 */
	private void createRelation() {
		final DialogBox box = GwtUtils.createDialog("Beziehung anlegen");
		box.center();
		final CreateRelationPresenter presenter = new CreateRelationPresenter(box, this.getView().getName(), this.pbi.getBacklog(), this);

		presenter.getFinished().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				try {
					PBIPresenter.this.getPbi().addRelation(presenter.getRelation());
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
	public ProductBacklogItem getPbi() {
		return this.pbi;
	}

	@Override
	protected boolean onFinish() {
		try {
			PBIPresenter.this.updatePBI();
		} catch (final ForbiddenStateException e) {
			// Wenn das Feature nicht bearbeitbar ist, speichern wir an dieser
			// Stelle auch nichts.
			return true;
		} catch (final UserException e) {
			GwtUtils.displayError(e.getMessage());
			return false;
		}
		return super.onFinish();

	}

	@Override
	public void registerViewEvents() {

		this.getView().getSave().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				PBIPresenter.this.finish();
			}
		});

		this.getView().getAbort().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				new AbortDialog(new OnOkayCommand() {

					@Override
					public void onExecute() {
						PBIPresenter.this.abort();
					}
				});
			}
		});

		this.getView().getCreateCriterion().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				PBIPresenter.this.createCriterion();
			}
		});

		this.getView().getCreateHint().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				PBIPresenter.this.createHint();
			}
		});

		this.getView().getCreateRelation().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				PBIPresenter.this.createRelation();
			}
		});

		this.getView().getRemoveCriterion().add(new EventHandler<RemoveCriterionEventArgs>() {
			@Override
			public void onUpdate(final Object sender, final RemoveCriterionEventArgs eventArgs) {
				PBIPresenter.this.removeCriterion(eventArgs.getCriterion());
			}
		});

		this.getView().getRemoveHint().add(new EventHandler<RemoveHintEventArgs>() {
			@Override
			public void onUpdate(final Object sender, final RemoveHintEventArgs eventArgs) {
				PBIPresenter.this.removeHint(eventArgs.getHint());
			}
		});

		this.getView().getRemoveRelation().add(new EventHandler<RemoveRelationEventArgs>() {
			@Override
			public void onUpdate(final Object sender, final RemoveRelationEventArgs eventArgs) {
				PBIPresenter.this.removeRelation(eventArgs.getRelation());
			}
		});
	}

	/**
	 * Removes the {@link AcceptanceCriterion} from the {@link Feature}.
	 * 
	 * @param criterion AcceptanceCriterion
	 */
	private void removeCriterion(final AcceptanceCriterion criterion) {
		try {
			this.pbi.removeAcceptanceCriterion(criterion);
		} catch (final ForbiddenStateException e) {
			GwtUtils.displayError(e.getMessage());
		}
	}

	/**
	 * Removes the {@link Hint} from the {@link Feature}.
	 * 
	 * @param hint Hint
	 */
	private void removeHint(final Hint hint) {
		try {
			this.pbi.removeHint(hint);
		} catch (final ForbiddenStateException e) {
			GwtUtils.displayError(e.getMessage());
		}
	}

	/**
	 * Removes the {@link Relation} from the {@link Feature}.
	 * 
	 * @param relation Relation
	 */
	private void removeRelation(final Relation relation) {
		try {
			this.pbi.removeRelation(relation);
		} catch (final ForbiddenStateException e) {
			GwtUtils.displayError(e);
		}
	}

	@Override
	public void setupView() {
		this.getView().setName(this.pbi.getName().replaceAll(NEWPBINAME, ""));
		this.getView().setDescription(this.pbi.getDescription());
		final ArrayList<ISprint> sprints = new ArrayList<ISprint>(this.pbi.getBacklog().getProject().getSprints());
		this.getView().setSprints(sprints, this.getPbi().getSprint());
		this.updateView();
	}

	/**
	 * Method update.
	 * 
	 * @param observable Observable
	 * @param argument Object
	 * @see fhdw.ipscrum.shared.observer.Observer#update(Observable, Object)
	 */
	@Override
	public void update(final Observable observable, final Object argument) {
		this.updateView();

	}

	@Override
	public void updatePBI() throws NoValidValueException, NoSprintDefinedException, ConsistencyException, DoubleDefinitionException, ForbiddenStateException, UserException {
		this.pbi.setName(this.getView().getName());
		this.pbi.setDescription(this.getView().getDescription());
		this.pbi.setLastEditor(SessionManager.getInstance().getLoginUser());
		try {
			this.pbi.setSprint(this.getView().getSelectedSprint());
		} catch (final NothingSelectedException e) {
			// Kein Sprint ausgewählt, also setzen wir den Sprint auf null.
			// TODO NoObject Pattern wäre besser, gibt es für Sprint aber zZ
			// nicht.
			this.pbi.setSprint(null);
		}
	}

	@Override
	public void updateView() {
		this.getView().setHints(this.pbi.getHints());
		this.getView().setRelations(this.pbi.getRelations());
		this.getView().setCriteria(this.pbi.getAcceptanceCriteria());
	}
}