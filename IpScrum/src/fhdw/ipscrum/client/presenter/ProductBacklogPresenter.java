package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.ProductBacklogView;
import fhdw.ipscrum.client.view.interfaces.IProductBacklogView;
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
		IProductBacklogView view = new ProductBacklogView();
		
		return view;
	}
	
	private void initialize(){
		if(project.getBacklog()!=null){
			this.getView().refreshProductBacklog(project.getBacklog().getItems());
		}
	}
}
