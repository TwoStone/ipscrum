package fhdw.ipscrum.client.view;

import java.util.List;

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
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * This view class is used to add a {@link Sprint} to a {@link Release}.
 * 
 * @author Phase II / Gruppe I
 */
public class AddSprintToReleaseView extends Composite implements
		IAddSprintToReleaseView {
	private final Button btnSave;
	private final Button btnAbort;
	private final Label lblRelease;
	private final SprintTableView spTable;

	// ########## Events #############
	private final Event<SprintArgs> saveSprintsEvent = new Event<SprintArgs>();
	private final Event<EventArgs> cancelAddSprintViewEvent = new Event<EventArgs>();

	// ###### Ende Events ###########

	public AddSprintToReleaseView() {

		final AbsolutePanel absolutePanel = new AbsolutePanel();
		this.initWidget(absolutePanel);
		absolutePanel.setSize("600px", "345px");

		final Label lblAddSprint = new Label(TextConstants.SPRINT_TO_RELEASE);
		lblAddSprint.setStyleName(TextConstants.LABELELEMENT);
		lblAddSprint.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		absolutePanel.add(lblAddSprint, 10, 10);
		lblAddSprint.setSize("300px", "28px");

		this.btnSave = new Button(TextConstants.NEW_BUTTON);
		this.btnSave.setText(TextConstants.SAVE);
		absolutePanel.add(this.btnSave, 10, 307);
		this.btnSave.setSize("100px", "28px");
		this.btnSave.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				AddSprintToReleaseView.this.saveSprintsEvent.fire(
						AddSprintToReleaseView.this,
						new SprintArgs(AddSprintToReleaseView.this.spTable
								.getCurrentlySelected()));
			}
		});

		this.lblRelease = new Label(TextConstants.EMPTY_TEXT);
		this.lblRelease.setStyleName(TextConstants.LABELELEMENT);
		this.lblRelease
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		absolutePanel.add(this.lblRelease, 253, 10);
		this.lblRelease.setSize("250px", "25px");

		this.btnAbort = new Button(TextConstants.NEW_BUTTON);
		this.btnAbort.setText(TextConstants.ABORT);
		absolutePanel.add(this.btnAbort, 465, 307);
		this.btnAbort.setSize("100px", "28px");

		final AbsolutePanel masterSprintTableViewPanel = new AbsolutePanel();
		absolutePanel.add(masterSprintTableViewPanel, 10, 44);

		masterSprintTableViewPanel.setSize("580px", "235px");

		this.spTable = new SprintTableView();
		masterSprintTableViewPanel.add(this.spTable);

		this.btnAbort.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				AddSprintToReleaseView.this.cancelAddSprintViewEvent.fire(
						AddSprintToReleaseView.this, new EventArgs());
			}
		});

	}

	@Override
	public void addCancelAddSprintViewEventHandler(EventHandler<EventArgs> arg) {
		this.cancelAddSprintViewEvent.add(arg);
	}

	@Override
	public void addSaveSprintsEventHandler(EventHandler<SprintArgs> arg) {
		this.saveSprintsEvent.add(arg);
	}

	@Override
	public Button getBtnAbort() {
		return this.btnAbort;
	}

	@Override
	public Button getBtnSave() {
		return this.btnSave;
	}

	@Override
	public Label getLblRelease() {
		return this.lblRelease;
	}

	@Override
	public void refreshSprints(List<ISprint> sprints) {
		this.spTable.getTableSprint().setRowData(sprints);
	}
}
