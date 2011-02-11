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
import fhdw.ipscrum.client.view.EditFeatureView;
import fhdw.ipscrum.client.view.interfaces.IEditFeatureView;
import fhdw.ipscrum.client.view.widgets.AbortDialog;
import fhdw.ipscrum.client.view.widgets.AbortDialog.OnOkayCommand;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Closed;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.Open;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.visitor.IFeatureVisitor;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.Observer;

public class EditFeaturePresenter extends Presenter<IEditFeatureView> implements
		Observer {
	private final Feature feature;

	public EditFeaturePresenter(Panel parent, Feature feature) {
		super(parent);
		if (feature == null) {
			throw new IllegalArgumentException("Kein Feature angegeben!");
		}
		this.feature = feature;
		this.feature.addObserver(this);

		this.updateView();
		this.registerViewEvents();
	}

	private void createCriterion(final Panel panel) {
		final AcceptanceCriterionPresenter presenter = new AcceptanceCriterionPresenter(
				panel);
		presenter.getFinished().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				try {
					EditFeaturePresenter.this.feature
							.addAcceptanceCriterion(presenter.getCriterion());
					panel.clear();
				} catch (final DoubleDefinitionException e) {
					GwtUtils.displayError(e.getMessage());
				} catch (final ForbiddenStateException e) {
					GwtUtils.displayError(e.getMessage());
				}

			}
		});
		presenter.getAborted().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				panel.clear();
			}
		});
	}

	private void createHint(final Panel panel) {
		final HintPresenter presenter = new HintPresenter(panel);
		presenter.getFinished().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				try {
					EditFeaturePresenter.this.feature.addHint(presenter
							.getHint());
				} catch (final DoubleDefinitionException e) {
					GwtUtils.displayError(e.getMessage());
				} catch (final ForbiddenStateException e) {
					GwtUtils.displayError(e.getMessage());
				}
				panel.clear();
			}
		});
		presenter.getAborted().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				panel.clear();
			}
		});
	}

	private void createRelation(DialogBox createDialog) {
		GwtUtils.displayError("Not yet implemented!");
	}

	@Override
	protected IEditFeatureView createView() {
		return new EditFeatureView();
	}

	public Feature getFeature() {
		return this.feature;
	}

	private void registerViewEvents() {

		this.getView().getSave().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				EditFeaturePresenter.this.save();
			}
		});

		this.getView().getAbort().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				new AbortDialog(new OnOkayCommand() {

					@Override
					public void onExecute() {
						EditFeaturePresenter.this.abort();
					}
				});
			}
		});

		this.getView().getCreateCriterion().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				EditFeaturePresenter.this
						.createCriterion(EditFeaturePresenter.this.getView()
								.addCriterionPanel());
			}
		});

		this.getView().getCreateHint().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				EditFeaturePresenter.this.createHint(EditFeaturePresenter.this
						.getView().addHintPanel());
			}
		});

		this.getView().getCreateRelation().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				EditFeaturePresenter.this.createRelation(GwtUtils
						.createDialog("Relationen anlegen"));
			}
		});

		this.getView().getRemoveCriterion()
				.add(new EventHandler<RemoveCriterionEventArgs>() {
					@Override
					public void onUpdate(Object sender,
							RemoveCriterionEventArgs eventArgs) {
						EditFeaturePresenter.this.removeCriterion(eventArgs
								.getCriterion());
					}
				});

		this.getView().getRemoveHint()
				.add(new EventHandler<RemoveHintEventArgs>() {
					@Override
					public void onUpdate(Object sender,
							RemoveHintEventArgs eventArgs) {
						EditFeaturePresenter.this.removeHint(eventArgs
								.getHint());
					}
				});

		this.getView().getRemoveRelation()
				.add(new EventHandler<RemoveRelationEventArgs>() {
					@Override
					public void onUpdate(Object sender,
							RemoveRelationEventArgs eventArgs) {
						EditFeaturePresenter.this.removeRelation(eventArgs
								.getRelation());
					}
				});
		this.getView().toggleFeatureState().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				EditFeaturePresenter.this.toggleFeatureState();
			}
		});
	}

	private void removeCriterion(AcceptanceCriterion criterion) {
		this.feature.removeAcceptanceCriterion(criterion);
	}

	private void removeHint(Hint hint) {
		this.feature.removeHint(hint);
	}

	private void removeRelation(Relation relation) {
		this.feature.removeRelation(relation);
	}

	private void save() {
		try {
			this.updateFeature();
		} catch (final NoValidValueException e) {
			GwtUtils.displayError(e.getMessage());
		} catch (final NoSprintDefinedException e) {
			GwtUtils.displayError(e.getMessage());
		}
	}

	private void toggleFeatureState() {
		this.feature.getState().accept(new IFeatureVisitor() {

			@Override
			public void handleClosed(Closed closed) {
			}

			@Override
			public void handleOpen(Open open) {
				try {
					EditFeaturePresenter.this.feature.close();
				} catch (final ForbiddenStateException e) {
					GwtUtils.displayError(e.getMessage());
				}
			}
		});
	}

	@Override
	public void update(Observable observable, Object argument) {
		this.updateView();
	}

	private void updateFeature() throws NoValidValueException,
			NoSprintDefinedException {
		this.feature.setName(this.getView().getName());
		this.feature.setDescription(this.getView().getDescription());
		this.feature.setSprint(this.getView().getSelectedSprint());
		this.feature.setLastEditor(SessionManager.getInstance().getLoginUser());
	}

	private void updateView() {
		this.getView().setName(this.feature.getName());
		this.getView().setDescription(this.feature.getDescription());
		this.getView().setState(this.feature.getState());
		this.getView().setSprints(
				new ArrayList<ISprint>(this.feature.getBacklog().getProject()
						.getSprints()));
		this.getView().setCriteria(this.feature.getAcceptanceCriteria());
		this.getView().setHints(this.feature.getHints());
		this.getView().setRelations(this.feature.getRelations());
	}
}
