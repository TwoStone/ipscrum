package fhdw.ipscrum.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

import fhdw.ipscrum.client.presenter.RootPresenter;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.ProductBacklog;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Project;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class IpScrum implements EntryPoint {
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		ProductBacklog bl = new ProductBacklog();
		Project p1 = new Project("Testprojekt 1",bl);
		bl.addItem(new ProductBacklogItem("Test",2,bl,null) {
		});
		bl.addItem(new ProductBacklogItem("Test 2",5,bl,null) {
		});
		p1.setBacklog(bl);
		
		SessionManager.getInstance().getModel().addProject(p1);
		SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 2",new ProductBacklog()));
		SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 3",new ProductBacklog()));
		SessionManager.getInstance().getModel().addProject(new Project("Testprojekt 4",new ProductBacklog()));
		new RootPresenter(RootPanel.get("mainPanel"));
	}
 }
	
