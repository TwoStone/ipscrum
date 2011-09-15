package fhdw.ipscrum.client.view;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.eventargs.SprintDetailArgs;
import fhdw.ipscrum.client.viewinterfaces.IEditSprintView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * This view is used as a dialog box for creating or modifying sprints.
 */
public class EditSprintView extends Composite implements IEditSprintView {

	/**
	 * Box for Sprint start.
	 */
	private final DateBox start;

	/**
	 * Box for Sprint end.
	 */
	private final DateBox end;

	/**
	 * List of teams.
	 */
	private final ListBox teams;

	/**
	 * Okay-button.
	 */
	private final Button okButton;

	/**
	 * Abort-button.
	 */
	private final Button abbButton;

	/**
	 * Event for okay button clicked.
	 */
	private final Event<EventArgs> okEvent = new Event<EventArgs>();
	/**
	 * Event for abort button clicked.
	 */
	private final Event<EventArgs> cancelEvent = new Event<EventArgs>();

	/**
	 * Textarea for Sprint description.
	 */
	private final TextArea description;

	/**
	 * Map of indexes and teams.
	 */
	private final HashMap<Integer, Team> indexToTeamMap = new HashMap<Integer, Team>();

	/**
	 * Map of teams and indexes.
	 */
	private final HashMap<Team, Integer> teamToIndexMap = new HashMap<Team, Integer>();

	/**
	 * Name of sprint.
	 */
	private final TextBox name;

	/**
	 * Creates a new instance.
	 */
	public EditSprintView() {

		final VerticalPanel verticalPanel = new VerticalPanel();
		this.initWidget(verticalPanel);
		verticalPanel.setSize("320px", "200px");

		final VerticalPanel topPanel = new VerticalPanel();
		verticalPanel.add(topPanel);
		topPanel.setSize("320px", "50px");

		final VerticalPanel namePanel = new VerticalPanel();
		topPanel.add(namePanel);

		final Label lblName = new Label("Name");
		namePanel.add(lblName);

		this.name = new TextBox();
		this.name.setMaxLength(20);
		namePanel.add(this.name);

		final HorizontalPanel datePanel = new HorizontalPanel();
		topPanel.add(datePanel);
		datePanel.setWidth("320px");

		final VerticalPanel startDatePanel = new VerticalPanel();
		datePanel.add(startDatePanel);
		startDatePanel.setSize("180px", "");

		final Label lblStarttermin = new Label(TextConstants.SPRINTDIALOG_STARTDATE);
		startDatePanel.add(lblStarttermin);

		this.start = new DateBox();
		startDatePanel.add(this.start);

		final VerticalPanel endDatePanel = new VerticalPanel();
		datePanel.add(endDatePanel);
		endDatePanel.setWidth("140px");

		final Label lblEndtermin = new Label(TextConstants.SPRINTDIALOG_ENDDATE);
		endDatePanel.add(lblEndtermin);

		this.end = new DateBox();
		endDatePanel.add(this.end);

		final VerticalPanel middlePanel = new VerticalPanel();
		verticalPanel.add(middlePanel);
		middlePanel.setSize("320px", "60px");

		final HorizontalPanel teamZuordnenPanel = new HorizontalPanel();
		middlePanel.add(teamZuordnenPanel);
		teamZuordnenPanel.setSize("320px", "40px");

		final VerticalPanel teamPanel = new VerticalPanel();
		teamZuordnenPanel.add(teamPanel);
		teamPanel.setSize("180px", "60px");

		final Label lblZugeordnetesTeam =
				new Label(TextConstants.SPRINTDIALOG_CHOSENTEAM);
		teamPanel.add(lblZugeordnetesTeam);

		this.teams = new ListBox();
		teamPanel.add(this.teams);
		this.teams.setSize("148px", "22px");

		final VerticalPanel beschreibungPanel = new VerticalPanel();
		beschreibungPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		teamZuordnenPanel.add(beschreibungPanel);
		beschreibungPanel.setSize("140px", "60px");

		final Label lblBeschreibung = new Label(TextConstants.SPRINTDIALOG_DESCRIPTION);
		beschreibungPanel.add(lblBeschreibung);

		this.description = new TextArea();
		beschreibungPanel.add(this.description);
		this.description.setWidth("140px");

		final VerticalPanel bottomPanel = new VerticalPanel();
		bottomPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		bottomPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel.add(bottomPanel);
		bottomPanel.setSize("320px", "80px");

		final HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		bottomPanel.add(buttonPanel);
		buttonPanel.setSize("219px", "36px");

		this.okButton = new Button("OK");
		buttonPanel.add(this.okButton);
		this.okButton.setSize("100px", "28px");
		this.okButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				final SprintDetailArgs sprintDetails =
						new SprintDetailArgs(EditSprintView.this.name.getText(),
								EditSprintView.this.start.getValue(),
								EditSprintView.this.end.getValue(), EditSprintView.this
										.getSelectedTeam(),
								EditSprintView.this.description.getText());
				EditSprintView.this.okEvent.fire(EditSprintView.this, sprintDetails);
			}
		});

		this.abbButton = new Button("Abbrechen");
		buttonPanel.add(this.abbButton);
		this.abbButton.setSize("100px", "28px");
		this.abbButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				EditSprintView.this.cancelEvent.fire(EditSprintView.this,
						new EventArgs());
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IEditSprintView#getSelectedTeam()
	 */
	@Override
	public Team getSelectedTeam() {
		return this.indexToTeamMap.get(this.teams.getSelectedIndex());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.IEditSprintView#setSelectedTeam(fhdw.ipscrum.shared.model
	 * .nonMeta.Team)
	 */
	@Override
	public void setSelectedTeam(final Team team) {
		this.teams.setSelectedIndex(this.teamToIndexMap.get(team));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IEditSprintView#fillComboBoxTeams(java.util.List)
	 */
	@Override
	public void fillComboBoxTeams(final List<Team> teamList) {
		this.teams.clear();
		for (int i = 0; i < teamList.size(); i++) {
			this.teams.addItem(teamList.get(i).getDescription());
			this.teamToIndexMap.put(teamList.get(i), i);
			this.indexToTeamMap.put(i, teamList.get(i));
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.IEditSprintView#registerSave(fhdw.ipscrum.client.architecture
	 * .events.DefaultEventHandler)
	 */
	@Override
	public void registerSave(final DefaultEventHandler handler) {
		this.okEvent.add(handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.IEditSprintView#registetAbort(fhdw.ipscrum.client.architecture
	 * .events.DefaultEventHandler)
	 */
	@Override
	public void registetAbort(final DefaultEventHandler handler) {
		this.cancelEvent.add(handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IEditSprintView#getStart()
	 */
	@Override
	public Date getStart() {
		return this.start.getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IEditSprintView#getEnd()
	 */
	@Override
	public Date getEnd() {
		return this.end.getValue();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IEditSprintView#getDescription()
	 */
	@Override
	public String getDescription() {
		return this.description.getText();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IEditSprintView#getName()
	 */
	@Override
	public String getName() {
		return this.name.getText();
	}

	@Override
	public void close() {
		this.cancelEvent.removeAllHandler();
		this.okEvent.removeAllHandler();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.IEditSprintView#updateFields(fhdw.ipscrum.shared.model
	 * .nonMeta.Sprint)
	 */
	@Override
	public void updateFields(final Sprint sprint) {
		this.name.setText(sprint.getName());
		this.description.setText(sprint.getDescription());
		this.start.setValue(sprint.getBegin());
		this.end.setValue(sprint.getEnd());
		this.teams.setSelectedIndex(this.teamToIndexMap.get(sprint.getTeam()));
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}

}
