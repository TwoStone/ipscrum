package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PBIArgs;
import fhdw.ipscrum.client.view.ProductBacklogView;
import fhdw.ipscrum.client.view.interfaces.IProductBacklogView;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;

public class ProductBacklogPresenter extends Presenter<IProductBacklogView> {

	private final Project project;
	
	public ProductBacklogPresenter(Panel parent, Project project) {
		super(parent);
		this.project = project;
		this.initialize();
	}

	@Override
	protected IProductBacklogView createView() {
		final IProductBacklogView view = new ProductBacklogView();
		
		view.addNewPBIEventHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				
				final DialogBox newBox = new DialogBox();
				final FeaturePresenter presenter = new FeaturePresenter(newBox, project.getBacklog());
				newBox.setGlassEnabled(true);
				
				presenter.getFinished().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						project.getBacklog().addItem(presenter.getFeature());
						view.refreshProductBacklog(project.getBacklog().getItems());
						newBox.hide();
					}
					
				});
				
				presenter.getAborted().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						newBox.hide();
					}
				});
				
				newBox.center();
			}
		});
		
		view.addPBIDetailsEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(Object sender, PBIArgs eventArgs) {
				final DialogBox newBox = new DialogBox();
				//TODO !!!! WENN ES NEBEN FEATURES NOCH BUGS GIBT, MUSS erst der Typ SICHERGESTELLT WERDEN
				final FeaturePresenter presenter = new FeaturePresenter(newBox, (Feature)eventArgs.getPbi());
				newBox.setGlassEnabled(true);
				
				presenter.getFinished().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						view.refreshProductBacklog(project.getBacklog().getItems());
						newBox.hide();
					}
					
				});
				
				presenter.getAborted().add(new EventHandler<EventArgs>() {

					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						newBox.hide();
					}
				});
				
				newBox.center();
			}
		});
		
		view.addDeletePBIEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(Object sender, PBIArgs eventArgs) {
				if(eventArgs.getPbi()!=null){
					project.getBacklog().removeItem(eventArgs.getPbi());
					view.refreshProductBacklog(project.getBacklog().getItems());
				}
			}
			
		});
		
		view.addPBIDownEventHandler(new EventHandler<PBIArgs>() {

			@Override
			public void onUpdate(Object sender, PBIArgs eventArgs) {
				ProductBacklogItem pbi = eventArgs.getPbi();
				if(pbi!=null){
					project.getBacklog().moveUp(pbi);
					view.refreshProductBacklog(project.getBacklog().getItems());
				}
			}
		});
		
		return view;
	}
	
	private void initialize(){
		if(project.getBacklog()!=null){
			this.getView().refreshProductBacklog(project.getBacklog().getItems());
		}
	}
}
