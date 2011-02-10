package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.RemoveCriterionEventArgs;
import fhdw.ipscrum.client.events.args.RemoveHintEventArgs;
import fhdw.ipscrum.client.events.args.RemoveRelationEventArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.CreateFeatureView;
import fhdw.ipscrum.client.view.interfaces.ICreateFeatureView;
import fhdw.ipscrum.client.view.widgets.AbortDialog;
import fhdw.ipscrum.client.view.widgets.AbortDialog.OnOkayCommand;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.Observer;

public class CreateFeaturePresenter extends Presenter<ICreateFeatureView>
		implements Observer {
	private final ProductBacklog productBacklog;
	private final List<Hint> hints;
	private final List<Relation> relations;
	private final List<AcceptanceCriterion> criterions;
	private Feature feature;

	/**
	 * Creates a new instance of {@link CreateFeaturePresenter} with an empty
	 * feature.
	 * 
	 * @param parent
	 * @param backlog
	 */
	public CreateFeaturePresenter(Panel parent, ProductBacklog backlog) {
		super(parent);
		this.productBacklog = backlog;
		this.hints = new ArrayList<Hint>();
		this.relations = new ArrayList<Relation>();
		this.criterions = new ArrayList<AcceptanceCriterion>();

		this.registerViewEvents();
		this.updateView();
	}

	private void createCriterion(final Panel panel) {
		final AcceptanceCriterionPresenter presenter = new AcceptanceCriterionPresenter(
				panel);
		presenter.getFinished().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				CreateFeaturePresenter.this.criterions.add(presenter
						.getCriterion());
				panel.clear();
				CreateFeaturePresenter.this.updateView();
			}
		});
		presenter.getAborted().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				panel.clear();
			}
		});
	}

	private Feature createFeature() throws NoValidValueException,
			DoubleDefinitionException, ForbiddenStateException,
			NoSprintDefinedException {
		final String name = this.getView().getName();
		final String desc = this.getView().getDescription();
		final ISprint sprint = this.getView().getSelectedSprint();
		final Feature feature = new Feature(name, desc, this.productBacklog);
		if (sprint != null) {
			feature.setSprint(sprint);
		}

		for (final AcceptanceCriterion criterion : this.criterions) {
			feature.addAcceptanceCriterion(criterion);
		}

		for (final Relation relation : this.relations) {
			feature.addRelation(relation);
		}

		for (final Hint hint : this.hints) {
			feature.addHint(hint);
		}
		return feature;
	}

	private void createHint(final Panel panel) {
		final HintPresenter presenter = new HintPresenter(panel);
		presenter.getFinished().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				CreateFeaturePresenter.this.hints.add(presenter.getHint());
				panel.clear();
				CreateFeaturePresenter.this.updateView();
			}
		});
		presenter.getAborted().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				panel.clear();
			}
		});
	}

	private void createRelation(Panel panel) {

	}

	@Override
	protected ICreateFeatureView createView() {
		return new CreateFeatureView();
	}

	public Feature getFeature() {
		return this.feature;
	}

	private void registerViewEvents() {

		this.getView().getSave().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				CreateFeaturePresenter.this.save();
			}
		});

		this.getView().getAbort().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				new AbortDialog(new OnOkayCommand() {

					@Override
					public void onExecute() {
						CreateFeaturePresenter.this.abort();
					}
				});
			}
		});

		this.getView().getCreateCriterion().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				CreateFeaturePresenter.this
						.createCriterion(CreateFeaturePresenter.this.getView()
								.addCriterionPanel());
			}
		});

		this.getView().getCreateHint().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				CreateFeaturePresenter.this
						.createHint(CreateFeaturePresenter.this.getView()
								.addHintPanel());
			}
		});

		this.getView().getCreateRelation().add(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				CreateFeaturePresenter.this.createRelation(GwtUtils
						.createDialog("Relationen anlegen"));
			}
		});

		this.getView().getRemoveCriterion()
				.add(new EventHandler<RemoveCriterionEventArgs>() {
					@Override
					public void onUpdate(Object sender,
							RemoveCriterionEventArgs eventArgs) {
						CreateFeaturePresenter.this.removeCriterion(eventArgs
								.getCriterion());
					}
				});

		this.getView().getRemoveHint()
				.add(new EventHandler<RemoveHintEventArgs>() {
					@Override
					public void onUpdate(Object sender,
							RemoveHintEventArgs eventArgs) {
						CreateFeaturePresenter.this.removeHint(eventArgs
								.getHint());
					}
				});

		this.getView().getRemoveRelation()
				.add(new EventHandler<RemoveRelationEventArgs>() {
					@Override
					public void onUpdate(Object sender,
							RemoveRelationEventArgs eventArgs) {
						CreateFeaturePresenter.this.removeRelation(eventArgs
								.getRelation());
					}
				});
	}

	private void removeCriterion(AcceptanceCriterion criterion) {
		this.criterions.remove(criterion);
		this.updateView();
	}

	private void removeHint(Hint hint) {
		this.hints.remove(hint);
		this.updateView();
	}

	private void removeRelation(Relation relation) {
		this.relations.remove(relation);
		this.updateView();
	}

	private void save() {
		try {
			this.feature = this.createFeature();
			this.finish();
		} catch (final NoValidValueException e) {
			Window.alert(e.getMessage());
		} catch (final DoubleDefinitionException e) {
			Window.alert(e.getMessage());
		} catch (final ForbiddenStateException e) {
			Window.alert(e.getMessage());
		} catch (final NoSprintDefinedException e) {
			Window.alert(e.getMessage());
		}
	}

	@Override
	public void update(Observable observable, Object argument) {
		this.updateView();
	}

	private void updateView() {
		this.getView().setHints(this.hints);
		this.getView().setRelations(this.relations);
		this.getView().setCriteria(this.criterions);
		final ArrayList<ISprint> sprints = new ArrayList<ISprint>(
				this.productBacklog.getProject().getSprints());
		this.getView().setSprints(sprints);
	}

}
