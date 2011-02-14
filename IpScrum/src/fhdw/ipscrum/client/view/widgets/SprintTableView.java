package fhdw.ipscrum.client.view.widgets;

import java.util.Vector;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.view.interfaces.ISprintTableView;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class SprintTableView extends Composite implements ISprintTableView {
	
private Sprint currentlySelected;
private CellTable<ISprint> tableSprint;
	
	public SprintTableView() {
		
		ScrollPanel scrollPanel = new ScrollPanel();
		initWidget(scrollPanel);
		scrollPanel.setSize("100%", "100%");
		
		this.tableSprint = new CellTable<ISprint>();
		
		this.tableSprint.setSelectionModel(new SingleSelectionModel<ISprint>());

		this.tableSprint.getSelectionModel().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				@SuppressWarnings("unchecked")
				SingleSelectionModel<ISprint> model = (SingleSelectionModel<ISprint>) SprintTableView.this.tableSprint.getSelectionModel();
				SprintTableView.this.currentlySelected = (Sprint) model.getSelectedObject();
			}
		
		
		});
		
		TextColumn<ISprint> descriptionColumn = new TextColumn<ISprint>() {
			@Override
			public String getValue(ISprint sprint) {
				return sprint.getName();
			}
		};
		tableSprint.addColumn(descriptionColumn, "Kurzbeschreibung");
		
		TextColumn<ISprint> teamColumn = new TextColumn<ISprint>() {
			@Override
			public String getValue(ISprint sprint) {
				return sprint.getTeam().getDescription();
			}
		};
		tableSprint.addColumn(teamColumn, "Team");
		
		TextColumn<ISprint> beginColumn = new TextColumn<ISprint>() {
			@Override
			public String getValue(ISprint sprint) {
				DateTimeFormat fmt = DateTimeFormat.getFormat("dd.MM.yyyy");	
				return fmt.format(sprint.getBegin());
			}
		};
		tableSprint.addColumn(beginColumn, "Beginn");
		
		TextColumn<ISprint> endColumn = new TextColumn<ISprint>() {
			@Override
			public String getValue(ISprint sprint) {
				DateTimeFormat fmt = DateTimeFormat.getFormat("dd.MM.yyyy");	
				return fmt.format(sprint.getEnd());
			}
		};
		tableSprint.addColumn(endColumn, "Ende");
		scrollPanel.setWidget(tableSprint);
		tableSprint.setSize("100%", "100%");
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ISprintTableView#getCurrentlySelected()
	 */
	@Override
	public Sprint getCurrentlySelected(){
		return this.currentlySelected;
	}
	
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ISprintTableView#refreshSprints(java.util.Vector)
	 */
	@Override
	public void refreshSprints(Vector<ISprint> sprints) {
		this.tableSprint.setRowData(sprints);
	}
	
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ISprintTableView#getTableSprint()
	 */
	@Override
	public CellTable<ISprint >getTableSprint(){
		return this.tableSprint;
	}
	
}
