package fhdw.ipscrum.client.view;

import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.view.interfaces.IAddSprintToReleaseView;
import fhdw.ipscrum.client.view.widgets.SprintTableView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * @author Phase II / Gruppe I
 *
 */
public class AddSprintToReleaseView extends Composite implements IAddSprintToReleaseView {
	private Button btnSave;
	private Button btnAbort;
	private Label lblRelease;
	private SprintTableView spTable;
	
	// ########## Events #############
	private final Event<SprintArgs> saveSprintsEvent = new Event<SprintArgs>();
	private final Event<EventArgs> cancelAddSprintViewEvent = new Event<EventArgs>();
	// ###### Ende Events ###########
	
	public AddSprintToReleaseView() {
		
		AbsolutePanel absolutePanel = new AbsolutePanel();
		initWidget(absolutePanel);
		absolutePanel.setSize("600px", "345px");
		
		Label lblAddSprint = new Label(TextConstants.SPRINT_TO_RELEASE);
		lblAddSprint.setStyleName(TextConstants.LABELELEMENT);
		lblAddSprint.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		absolutePanel.add(lblAddSprint, 10, 10);
		lblAddSprint.setSize("300px", "28px");
		
		btnSave = new Button(TextConstants.NEW_BUTTON);
		btnSave.setText(TextConstants.SAVE);
		absolutePanel.add(btnSave, 10, 307);
		btnSave.setSize("100px", "28px");
		btnSave.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				AddSprintToReleaseView.this.saveSprintsEvent.fire(AddSprintToReleaseView.this, new SprintArgs(AddSprintToReleaseView.this.spTable.getCurrentlySelected()));
			}
		});
		
		lblRelease = new Label(TextConstants.EMPTY_TEXT);
		lblRelease.setStyleName(TextConstants.LABELELEMENT);
		lblRelease.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		absolutePanel.add(lblRelease, 253, 10);
		lblRelease.setSize("250px", "25px");
		
		btnAbort = new Button(TextConstants.NEW_BUTTON);
		btnAbort.setText(TextConstants.ABORT);
		absolutePanel.add(btnAbort, 465, 307);
		btnAbort.setSize("100px", "28px");
		
		AbsolutePanel masterSprintTableViewPanel = new AbsolutePanel();
		absolutePanel.add(masterSprintTableViewPanel, 10, 44);
		
		masterSprintTableViewPanel.setSize("580px", "235px");
		
		this.spTable = new SprintTableView();
		masterSprintTableViewPanel.add(this.spTable);
		
		btnAbort.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
			AddSprintToReleaseView.this.cancelAddSprintViewEvent.fire(AddSprintToReleaseView.this, new EventArgs());	
			}
		});
		
	}

	
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IAddSprintToReleaseView#getBtnSave()
	 */
	@Override
	public Button getBtnSave() {
		return btnSave;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IAddSprintToReleaseView#getBtnAbort()
	 */
	@Override
	public Button getBtnAbort() {
		return btnAbort;
	}
	
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IAddSprintToReleaseView#getLblRelease()
	 */
	@Override
	public Label getLblRelease() {
		return lblRelease;
	}
	
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IAddSprintToReleaseView#addSaveSprintsEventHandler(fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void addSaveSprintsEventHandler(EventHandler<SprintArgs> arg) {
		saveSprintsEvent.add(arg);
	}
	
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IAddSprintToReleaseView#addCancelAddSprintViewEventHandler(fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void addCancelAddSprintViewEventHandler(EventHandler<EventArgs> arg) {
		cancelAddSprintViewEvent.add(arg);
	}
	
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IAddSprintToReleaseView#refreshSprints(java.util.Vector)
	 */
	@Override
	public void refreshSprints(Vector<ISprint> sprints) {
	this.spTable.getTableSprint().setRowData(sprints);
	}
}
