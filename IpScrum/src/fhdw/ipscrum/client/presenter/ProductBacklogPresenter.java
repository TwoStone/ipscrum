package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.ProductBacklogView;
import fhdw.ipscrum.client.view.interfaces.IProductBacklogView;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;

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
		final DialogBox newBox = new DialogBox();
		newBox.setGlassEnabled(true);
		
		view.addNewPBIEventHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				FeaturePresenter presenter = new FeaturePresenter(newBox, project.getBacklog(), new Release());
				
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
		
		return view;
	}
	
	private void initialize(){
		if(project.getBacklog()!=null){
			this.getView().refreshProductBacklog(project.getBacklog().getItems());
		}
	}
}
