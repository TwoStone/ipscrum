package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.CreateRelationView;
import fhdw.ipscrum.client.view.interfaces.ICreateRelationView;
import fhdw.ipscrum.client.view.widgets.AbortDialog;
import fhdw.ipscrum.client.view.widgets.AbortDialog.OnOkayCommand;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.NothingSelectedException;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklog;
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
	private Relation relation;
	private final String sourceName;
	private final ProductBacklog backlog;

	/**
	 * Constructor for RelationPresenter.
	 * 
	 * @param parent
	 *            Panel
	 * @param backlog
	 *            ProductBacklog
	 * @param parentPresenter
	 */
	public CreateRelationPresenter(final Panel parent, final String sourceName,
			final ProductBacklog backlog, final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);

		this.sourceName = sourceName;
		this.backlog = backlog;
		this.setupView();
		this.registerViewEvents();
	}

	protected void createNewType() {
		final DialogBox box = GwtUtils.createDialog("Neuer Beziehungstyp");

		final CreateRelationTypePresenter presenter = new CreateRelationTypePresenter(
				box, this);
		box.center();
		presenter.getFinished().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				CreateRelationPresenter.this.getView().setRelationTypes(
						new ArrayList<RelationType>(SessionManager
								.getInstance().getModel()
								.getRelationTypeManager().getRelationTypes()));
				box.hide();
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
	 * Method createView.
	 * 
	 * @return IRelationView
	 */
	@Override
	protected ICreateRelationView createView() {
		return new CreateRelationView();
	}

	private List<Feature> getFeatures(
			final List<ProductBacklogItem> backlogItems) {
		final List<Feature> result = new Vector<Feature>();
		for (final ProductBacklogItem productBacklogItem : backlogItems) {
			productBacklogItem.accept(new IProductBacklogItemVisitor() {

				@Override
				public void handleBug(final Bug bug) {
					// TODO Sollten Features und Bugs untereinander in Beziehung
					// stehen?
				}

				@Override
				public void handleFeature(final Feature feature) {
					result.add(feature);
				}
			});
		}
		return result;
	}

	public Relation getRelation() {
		return this.relation;
	}

	@Override
	protected boolean onAbort() {
		this.getView().asWidget().removeFromParent();
		return super.onAbort();
	}

	@Override
	protected boolean onFinish() {
		try {
			this.relation = new Relation(this.getView().getSelectedType(), this
					.getView().getSelectedTarget());
		} catch (final NothingSelectedException e) {
			return false;
		}
		this.getView().asWidget().removeFromParent();
		return super.onFinish();
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
				CreateRelationPresenter.this.createNewType();
			}
		});
	}

	private void setupView() {
		this.getView()
				.setRelationTypes(
						new ArrayList<RelationType>(SessionManager
								.getInstance().getModel()
								.getRelationTypeManager().getRelationTypes()));
		this.getView().setOwningFeatureName(this.sourceName);
		this.getView().setTargetFeatures(this.backlog.getItems());
	}

	@Override
	public void update(final Observable observable, final Object argument) {

	}
}
