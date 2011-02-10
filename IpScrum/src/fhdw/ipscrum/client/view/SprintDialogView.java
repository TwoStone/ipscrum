package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.view.interfaces.ISprintDialogView;

import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.TextArea;

public class SprintDialogView extends Composite implements ISprintDialogView {

	private DateBox start;
	private DateBox end;
	private ListBox teams;
	private Button ok_button;
	private Button abb_button;
	
	private final Event<SprintArgs> okEvent = new Event<SprintArgs>();
	private final Event<EventArgs> cancelEvent = new Event<EventArgs>();
	private TextArea description;

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
		
		start = new DateBox();
		startDatePanel.add(start);
		
		VerticalPanel endDatePanel = new VerticalPanel();
		datePanel.add(endDatePanel);
		endDatePanel.setWidth("140px");
		
		Label lblEndtermin = new Label("Endtermin");
		endDatePanel.add(lblEndtermin);
		
		end = new DateBox();
		endDatePanel.add(end);
		
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
		
		teams = new ListBox();
		teamPanel.add(teams);
		teams.setSize("148px", "22px");
		
		VerticalPanel beschreibungPanel = new VerticalPanel();
		beschreibungPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		teamZuordnenPanel.add(beschreibungPanel);
		beschreibungPanel.setSize("140px", "60px");
		
		Label lblBeschreibung = new Label("Beschreibung:");
		beschreibungPanel.add(lblBeschreibung);
		
		description = new TextArea();
		beschreibungPanel.add(description);
		description.setWidth("140px");
		
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
		
		ok_button = new Button("New button");
		ok_button.setText("OK");
		buttonPanel.add(ok_button);
		ok_button.setSize("100px", "28px");
		ok_button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//okEvent.fire(SprintDialogView.this, new SprintArgs(SprintDialogView.this.getStart().getValue(),SprintDialogView.this.getEnd().getValue(),SprintDialogView.this.getDescription().getText(),));
			}
		});
		
		abb_button = new Button("New button");
		abb_button.setText("Abberchen");
		buttonPanel.add(abb_button);
		abb_button.setSize("100px", "28px");
		abb_button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				cancelEvent.fire(SprintDialogView.this, new EventArgs());
			}
		});
	}

	public HasText getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ISprintDialogView#getStart()
	 */
	@Override
	public DateBox getStart() {
		return start;
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ISprintDialogView#getEnd()
	 */
	@Override
	public DateBox getEnd() {
		return end;
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ISprintDialogView#getTeams()
	 */
	@Override
	public ListBox getTeams() {
		return teams;
	}


	@Override
	public void addOkHandler(EventHandler<SprintArgs> args) {
		okEvent.add(args);
	}

	@Override
	public void addCancelHandler(EventHandler<EventArgs> args) {
		cancelEvent.add(args);
	}

}
