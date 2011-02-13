package fhdw.ipscrum.client.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintDetailArgs;
import fhdw.ipscrum.client.view.interfaces.ISprintDialogView;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 */
public class SprintDialogView extends Composite implements ISprintDialogView {

	private final DateBox start;
	private final DateBox end;
	private final ListBox teams;
	private final Button ok_button;
	private final Button abb_button;

	private final Event<SprintDetailArgs> okEvent = new Event<SprintDetailArgs>();
	private final Event<EventArgs> cancelEvent = new Event<EventArgs>();
	private final TextArea description;
	private final HashMap<Integer,ITeam> indexToTeamMap = new HashMap<Integer,ITeam>();
	private final HashMap<ITeam,Integer> teamToIndexMap = new HashMap<ITeam,Integer>();

	public SprintDialogView() {

		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("320px", "200px");

		VerticalPanel topPanel = new VerticalPanel();
		verticalPanel.add(topPanel);
		topPanel.setSize("320px", "50px");

		HorizontalPanel datePanel = new HorizontalPanel();
		topPanel.add(datePanel);
		datePanel.setWidth("320px");

		VerticalPanel startDatePanel = new VerticalPanel();
		datePanel.add(startDatePanel);
		startDatePanel.setSize("180px", "");

		Label lblStarttermin = new Label("Starttermin");
		startDatePanel.add(lblStarttermin);

		this.start = new DateBox();
		startDatePanel.add(this.start);

		VerticalPanel endDatePanel = new VerticalPanel();
		datePanel.add(endDatePanel);
		endDatePanel.setWidth("140px");

		Label lblEndtermin = new Label("Endtermin");
		endDatePanel.add(lblEndtermin);

		this.end = new DateBox();
		endDatePanel.add(this.end);

		VerticalPanel middlePanel = new VerticalPanel();
		verticalPanel.add(middlePanel);
		middlePanel.setSize("320px", "60px");

		HorizontalPanel teamZuordnenPanel = new HorizontalPanel();
		middlePanel.add(teamZuordnenPanel);
		teamZuordnenPanel.setSize("320px", "40px");

		VerticalPanel teamPanel = new VerticalPanel();
		teamZuordnenPanel.add(teamPanel);
		teamPanel.setSize("180px", "60px");

		Label lblZugeordnetesTeam = new Label("Zugeordnetes Team:");
		teamPanel.add(lblZugeordnetesTeam);

		this.teams = new ListBox();
		teamPanel.add(this.teams);
		this.teams.setSize("148px", "22px");

		VerticalPanel beschreibungPanel = new VerticalPanel();
		beschreibungPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		teamZuordnenPanel.add(beschreibungPanel);
		beschreibungPanel.setSize("140px", "60px");

		Label lblBeschreibung = new Label("Beschreibung:");
		beschreibungPanel.add(lblBeschreibung);

		this.description = new TextArea();
		beschreibungPanel.add(this.description);
		this.description.setWidth("140px");

		VerticalPanel bottomPanel = new VerticalPanel();
		bottomPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		bottomPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel.add(bottomPanel);
		bottomPanel.setSize("320px", "80px");

		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		bottomPanel.add(buttonPanel);
		buttonPanel.setSize("219px", "36px");

		this.ok_button = new Button("OK");
		buttonPanel.add(this.ok_button);
		this.ok_button.setSize("100px", "28px");
		this.ok_button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SprintDetailArgs sprintDetails = new SprintDetailArgs(SprintDialogView.this.start.getValue(), SprintDialogView.this.end.getValue(), SprintDialogView.this.getSelectedTeam(), SprintDialogView.this.description.getText());
				SprintDialogView.this.okEvent.fire(SprintDialogView.this, sprintDetails);
			}
		});

		this.abb_button = new Button("Abbrechen");
		buttonPanel.add(this.abb_button);
		this.abb_button.setSize("100px", "28px");
		this.abb_button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SprintDialogView.this.cancelEvent.fire(SprintDialogView.this, new EventArgs());
			}
		});
	}


	@Override
	public ITeam getSelectedTeam() {
		return this.indexToTeamMap.get(this.teams.getSelectedIndex());
	}

	@Override
	public void setSelectedTeam(ITeam team) {
		this.teams.setSelectedIndex(this.teamToIndexMap.get(team));
	}

	@Override
	public void fillComboBoxTeams(ArrayList<ITeam> teamList) {
		this.teams.clear();
		for (int i = 0; i < teamList.size(); i++) {
			this.teams.addItem(teamList.get(i).toString());
			this.teamToIndexMap.put(teamList.get(i), i);
			this.indexToTeamMap.put(i, teamList.get(i));
		}
	}

	/**
	 * Method addOkHandler.
	 * @param args EventHandler<SprintArgs>
	 * @see fhdw.ipscrum.client.view.interfaces.ISprintDialogView#addOkHandler(EventHandler<SprintArgs>)
	 */
	@Override
	public void addOkHandler(EventHandler<SprintDetailArgs> args) {
		this.okEvent.add(args);
	}

	/**
	 * Method addCancelHandler.
	 * @param args EventHandler<EventArgs>
	 * @see fhdw.ipscrum.client.view.interfaces.ISprintDialogView#addCancelHandler(EventHandler<EventArgs>)
	 */
	@Override
	public void addCancelHandler(EventHandler<EventArgs> args) {
		this.cancelEvent.add(args);
	}

	@Override
	public void setStart(Date startDate) {
		this.start.setValue(startDate);
	}

	@Override
	public void setEnd(Date endDate) {
		this.end.setValue(endDate);
	}

	@Override
	public void setDescription(String description) {
		this.description.setText(description);
	}


}
