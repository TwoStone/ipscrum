package fhdw.ipscrum.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.RemoveCriterionEventArgs;
import fhdw.ipscrum.client.events.args.RemoveHintEventArgs;
import fhdw.ipscrum.client.events.args.RemoveRelationEventArgs;
import fhdw.ipscrum.client.view.FeatureView;
import fhdw.ipscrum.client.view.interfaces.IFeatureView;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Closed;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.Open;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.visitor.IFeatureVisitor;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.Observer;

public class FeaturePresenter extends Presenter<IFeatureView>  implements Observer{

	private final Feature myFeature;
	
	public Feature getFeature() {
		this.getFeatureValues();
		return myFeature;
	}

	/**
	 * Creates a new instance of {@link FeaturePresenter} with an empty feature.
	 * @param parent
	 * @param backlog
	 * @param release
	 */
	public FeaturePresenter(Panel parent, ProductBacklog backlog, Release release) {
		this(parent,new Feature("", "", 0, backlog, release));
	}
	
	/**
	 * Creates a new instance of {@link FeaturePresenter} to show the specified feature.
	 * @param parent
	 * @param feature
	 */
	public FeaturePresenter(Panel parent, Feature feature) {
		super(parent);
		this.myFeature = feature;
		this.updateView(this.myFeature);
		this.registerViewEvents();
	}

	private void registerViewEvents() {
		this.getView().getSave().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				save();
			}
		});
		
		this.getView().getAbort().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				abort();
			}
		});
		
		this.getView().getCloseFeature().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				closeFeature();
			}
		});
		
		this.getView().getCreateCriterion().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				createCriterion();
			}
		});
		
		this.getView().getCreateRelation().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				createRelation();
			}
		});
		
		this.getView().getCreateHint().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				createHint();
			}
		});
		
		this.getView().getRemoveCriterion().add(new EventHandler<RemoveCriterionEventArgs>() {
			
			@Override
			public void onUpdate(Object sender, RemoveCriterionEventArgs eventArgs) {
				removeCriterion(eventArgs.getCriterion());
			}
		});
		
		this.getView().getRemoveHint().add(new EventHandler<RemoveHintEventArgs>() {
			
			@Override
			public void onUpdate(Object sender, RemoveHintEventArgs eventArgs) {
				removeHint(eventArgs.getHint());
			}
		});
		
		this.getView().getRemoveRelation().add(new EventHandler<RemoveRelationEventArgs>() {
			
			@Override
			public void onUpdate(Object sender, RemoveRelationEventArgs eventArgs) {
				removeRelation(eventArgs.getRelation());
			}
		});
	}

	private void removeRelation(Relation relation) {
		
	}

	private void removeHint(Hint hint) {
	}

	private void removeCriterion(AcceptanceCriterion criterion) {
		// TODO Auto-generated method stub
		
	}

	private void createHint() {
		final HintPresenter presenter = new HintPresenter(this.getView().getAddHintPanel());
		presenter.getFinished().add(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				try {
					FeaturePresenter.this.getFeature().addHint(presenter.getHint());
					FeaturePresenter.this.getView().getAddHintPanel().clear();
				} catch (DoubleDefinitionException e) {
					Window.alert(e.getMessage());
				}
			}
		});
		
		presenter.getAborted().add(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				FeaturePresenter.this.getView().getAddHintPanel().clear();
			}
		});
	}

	private void createRelation() {
		// TODO Auto-generated method stub
		
	}

	private void createCriterion() {
		final AcceptanceCriterionPresenter presenter = new AcceptanceCriterionPresenter(this.getView().getAddCriterionPanel());
		presenter.getFinished().add(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				try {
					FeaturePresenter.this.myFeature.addAcceptanceCriterion(presenter.getCriterion());
					FeaturePresenter.this.getView().getAddCriterionPanel().clear();
				} catch (DoubleDefinitionException e) {
					Window.alert(e.getMessage());
				}
				
			}
		});
		
		presenter.getAborted().add(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				FeaturePresenter.this.getView().getAddCriterionPanel().clear();
			}
		});
	}

	private void closeFeature() {
		// TODO Auto-generated method stub
		
	}

	private void save() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected IFeatureView createView() {
		return new FeatureView();
	}

	private void updateView(Feature feature) {
		this.getView().getName().setText(feature.getName());
		
		this.getView().getComplexity().setValue(feature.getManDayCosts());
		this.getView().getDescription().setText(feature.getDescription());

		this.getView().getHints().setRowData(0, feature.getHints());
		this.getView().getRelations().setRowData(0, feature.getRelations());
		this.getView().getCriteria().setRowData(0, feature.getAcceptanceCriteria());
		
		feature.getState().accept(new IFeatureVisitor() {
			
			@Override
			public void handleOpen(Open open) {
				FeaturePresenter.this.getView().getState().setText("Offen");
			}
			
			@Override
			public void handleClosed(Closed closed) {
				FeaturePresenter.this.getView().getState().setText("Gechlossen");
			}
		});
		
	}
	
	private void getFeatureValues() {
		this.myFeature.setName(this.getView().getName().getText());
		this.myFeature.setManDayCosts(this.getView().getComplexity().getValue());
		this.myFeature.setDescription(this.getView().getDescription().getText());
	}
	
	private Boolean featureIsEditable() {
		class FeatureEditable implements IFeatureVisitor {

			private Boolean result;
			
			@Override
			public void handleOpen(Open open) {
				this.result = true;
			}

			@Override
			public void handleClosed(Closed closed) {
				this.result = false;
			}
			
			public Boolean getResult() {
				return result;
			}
			
		}

		FeatureEditable editableChecker = new FeatureEditable();
		this.myFeature.getState().accept(editableChecker);
		
		return editableChecker.getResult();
	}

	@Override
	public void update(Observable observable, Object argument) {
		// TODO Auto-generated method stub
		
	}

}
