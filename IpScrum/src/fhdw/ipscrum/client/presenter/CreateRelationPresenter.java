package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.CreateRelationView;
import fhdw.ipscrum.client.view.interfaces.ICreateRelationView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.NothingSelectedException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.RelationType;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;
import fhdw.ipscrum.shared.observer.Observable;
import fhdw.ipscrum.shared.observer.Observer;

/**
 */
public class CreateRelationPresenter extends Presenter<ICreateRelationView>
		implements Observer {
	private final Feature source;
	private Relation relation;

	/**
	 * Constructor for RelationPresenter.
	 * 
	 * @param parent
	 *            Panel
	 * @param backlog
	 *            ProductBacklog
	 */
	public CreateRelationPresenter(final Panel parent, final Feature source) {
		super(parent);

		this.source = source;
		this.setupView();
		this.registerViewEvents();
	}

	private void registerViewEvents() {
		this.getView().getSave().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				CreateRelationPresenter.this.finish();
			}
		});

		this.getView().getAbort().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				CreateRelationPresenter.this.abort();
			}
		});

		this.getView().getCreateNewType().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				CreateRelationPresenter.this
						.createNewType(CreateRelationPresenter.this.getView()
								.getCreateNewTypePanel());
			}
		});
	}

	protected void createNewType(final Panel createNewTypePanel) {
		GwtUtils.displayError("Not yet implemented!");
	}

	/**
	 * Method createView.
	 * 
	 * @return IRelationView
	 */
	@Override
	protected ICreateRelationView createView() {
		return new CreateRelationView();
	}

	private void setupView() {
		this.getView()
				.setRelationTypes(
						new ArrayList<RelationType>(SessionManager
								.getInstance().getModel()
								.getRelationTypeManager().getRelationTypes()));
		this.getView().setOwningFeature(this.source);
		this.getView().setTargetFeatures(
				this.getFeatures(this.source.getBacklog().getItems()));
	}

	private List<Feature> getFeatures(
			final List<ProductBacklogItem> backlogItems) {
		final List<Feature> result = new Vector<Feature>();
		for (final ProductBacklogItem productBacklogItem : backlogItems) {
			productBacklogItem.accept(new IProductBacklogItemVisitor() {

				@Override
				public void handleFeature(final Feature feature) {
					result.add(feature);
				}
			});
		}
		return result;
	}

	@Override
	public void update(final Observable observable, final Object argument) {

	}

	@Override
	protected boolean onFinish() {
		try {
			this.relation = new Relation(this.getView().getSelectedType(), this
					.getView().getSelectedTarget());
		} catch (final NothingSelectedException e) {
			return false;
		}
		return super.onFinish();
	}

	public Relation getRelation() {
		return this.relation;
	}
}
