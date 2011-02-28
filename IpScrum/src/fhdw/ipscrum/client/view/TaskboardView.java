package fhdw.ipscrum.client.view;

import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.view.interfaces.ITaskboardView;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class TaskboardView extends Composite implements ITaskboardView {
	
	//####### Events ###############
	private final Event<SprintArgs> selectSprint = new Event<SprintArgs>();
	//##### Ende ##################
	
	private SingleSelectionModel<ISprint> sprintSelectionModel;
	private HorizontalPanel contentPanel;
	
	public TaskboardView() {
		
		this.initSelectionModel();
		
		contentPanel = new HorizontalPanel();
		initWidget(contentPanel);
		contentPanel.setSize("900px", "600px");
		
		ScrollPanel scrollPanel = new ScrollPanel();
		contentPanel.add(scrollPanel);
		scrollPanel.setSize("225px", "600px");
		
		StackPanel stackPanel = new StackPanel();
		scrollPanel.setWidget(stackPanel);
		stackPanel.setSize("100%", "100%");
		
		CellTree projectCellTree = new CellTree(new SprintSelectionTreeViewModel(sprintSelectionModel), null);
	
		
		stackPanel.add(projectCellTree, "Sprintauswahl", false);
		projectCellTree.setSize("100%", "100%");
	}
	
	private void initSelectionModel() {
		this.sprintSelectionModel = new SingleSelectionModel<ISprint>();
		this.sprintSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				TaskboardView.this.selectSprint.fire(TaskboardView.this, new SprintArgs(TaskboardView.this.sprintSelectionModel.getSelectedObject()));
			}
		});
	}
	
	@Override
	public void addSelectSprintHandler(EventHandler<SprintArgs> arg) {
		selectSprint.add(arg);
	}
}
