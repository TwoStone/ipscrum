package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.OneStringArgs;
import fhdw.ipscrum.client.view.interfaces.ITeamDialogView;
import fhdw.ipscrum.shared.constants.TextConstants;

/**
 * This view is used to create or modify teams.
 */
public class TeamDialogView extends Composite implements ITeamDialogView {

	private final Event<OneStringArgs> okEvent = new Event<OneStringArgs>();
	private final Event<EventArgs> cancelEvent = new Event<EventArgs>();

	private final TextBox teamDescription;
	private final Button ok_button;
	private final Button abb_button;

	public TeamDialogView() {

		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("320px", "120px");

		VerticalPanel topPanel = new VerticalPanel();
		verticalPanel.add(topPanel);
		topPanel.setSize("320px", "76px");

		VerticalPanel teamDescriptionPanel = new VerticalPanel();
		topPanel.add(teamDescriptionPanel);
		teamDescriptionPanel.setWidth("320px");

		Label lblTeambezeichnung = new Label(TextConstants.TEAMDIALOG_TEAMNAME);
		teamDescriptionPanel.add(lblTeambezeichnung);
		lblTeambezeichnung.setSize("115px", "19px");

		this.teamDescription = new TextBox();
		teamDescriptionPanel.add(this.teamDescription);
		this.teamDescription.setSize("261px", "16px");

		VerticalPanel bottomPanel = new VerticalPanel();
		bottomPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		bottomPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		verticalPanel.add(bottomPanel);
		bottomPanel.setSize("320px", "64px");

		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		bottomPanel.add(buttonPanel);
		buttonPanel.setSize("219px", "36px");

		this.ok_button = new Button(TextConstants.DIALOGBOX_OK);
		buttonPanel.add(this.ok_button);
		this.ok_button.setSize("100px", "28px");
		this.ok_button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				TeamDialogView.this.okEvent.fire(TeamDialogView.this, new OneStringArgs(TeamDialogView.this.teamDescription.getText()));
			}
		});

		this.abb_button = new Button(TextConstants.DIALOGBOX_CANCEL);
		buttonPanel.add(this.abb_button);
		this.abb_button.setSize("100px", "28px");
		this.abb_button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				TeamDialogView.this.cancelEvent.fire(TeamDialogView.this, new EventArgs());
			}
		});
	}




	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ITeamDialogView#getTeamDescription()
	 */
	@Override
	public void setTeamDescription(String description) {
		this.teamDescription.setText(description);
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ITeamDialogView#addOkEventHandler(fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void addOkEventHandler(EventHandler<OneStringArgs> args) {
		this.okEvent.add(args);
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ITeamDialogView#addCancelEventHandler(fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void addCancelEventHandler(EventHandler<EventArgs> args) {
		this.cancelEvent.add(args);
	}
}
