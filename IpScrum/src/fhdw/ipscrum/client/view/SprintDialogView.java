package fhdw.ipscrum.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;

import fhdw.ipscrum.client.view.interfaces.ISprintDialogView;

public class SprintDialogView extends Composite implements ISprintDialogView {

	private DateBox start;
	private DateBox end;
	private ListBox teams;
	private Button zuordnen_button;
	private Button ok_button;
	private Button abb_button;

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
		teamZuordnenPanel.setSize("320px", "60px");
		
		VerticalPanel teamPanel = new VerticalPanel();
		teamZuordnenPanel.add(teamPanel);
		teamPanel.setSize("180px", "50px");
		
		Label label = new Label("Team:");
		teamPanel.add(label);
		
		teams = new ListBox();
		teamPanel.add(teams);
		teams.setSize("148px", "22px");
		
		VerticalPanel zuordnenPanel = new VerticalPanel();
		zuordnenPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		teamZuordnenPanel.add(zuordnenPanel);
		zuordnenPanel.setSize("140px", "40px");
		
		zuordnen_button = new Button("New button");
		zuordnen_button.setText("Zuordnen");
		zuordnenPanel.add(zuordnen_button);
		zuordnen_button.setSize("100px", "28px");
		
		VerticalPanel bottomPanel = new VerticalPanel();
		bottomPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		bottomPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel.add(bottomPanel);
		bottomPanel.setSize("320px", "90px");
		
		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		bottomPanel.add(buttonPanel);
		buttonPanel.setSize("219px", "36px");
		
		ok_button = new Button("New button");
		ok_button.setText("OK");
		buttonPanel.add(ok_button);
		ok_button.setSize("100px", "28px");
		
		abb_button = new Button("New button");
		abb_button.setText("Abberchen");
		buttonPanel.add(abb_button);
		abb_button.setSize("100px", "28px");
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

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ISprintDialogView#getZuordnen_button()
	 */
	@Override
	public Button getZuordnen_button() {
		return zuordnen_button;
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ISprintDialogView#getOk_button()
	 */
	@Override
	public Button getOk_button() {
		return ok_button;
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ISprintDialogView#getAbb_button()
	 */
	@Override
	public Button getAbb_button() {
		return abb_button;
	}

}
