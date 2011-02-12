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

/**
 */
public class TeamDialogView extends Composite implements ITeamDialogView {
	
	private final Event<OneStringArgs> okEvent = new Event<OneStringArgs>();
	private final Event<EventArgs> cancelEvent = new Event<EventArgs>();
	
	private TextBox teamDescription;
	private Button ok_button;
	private Button abb_button;

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
		
		Label lblTeambezeichnung = new Label("Teambezeichnung");
		teamDescriptionPanel.add(lblTeambezeichnung);
		lblTeambezeichnung.setSize("115px", "19px");
		
		teamDescription = new TextBox();
		teamDescriptionPanel.add(teamDescription);
		teamDescription.setSize("261px", "16px");
		
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
		
		ok_button = new Button("OK");
		buttonPanel.add(ok_button);
		ok_button.setSize("100px", "28px");
		ok_button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				okEvent.fire(TeamDialogView.this, new OneStringArgs(TeamDialogView.this.getTeamDescription().getText()));
			}
		});
		
		abb_button = new Button("Abbrechen");
		buttonPanel.add(abb_button);
		abb_button.setSize("100px", "28px");
		abb_button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				cancelEvent.fire(TeamDialogView.this, new EventArgs());
			}
		});
	}




	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ITeamDialogView#getTeamDescription()
	 */
	@Override
	public TextBox getTeamDescription() {
		return teamDescription;
	}
	
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ITeamDialogView#addOkEventHandler(fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void addOkEventHandler(EventHandler<OneStringArgs> args) {
		okEvent.add(args);
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ITeamDialogView#addCancelEventHandler(fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void addCancelEventHandler(EventHandler<EventArgs> args) {
		cancelEvent.add(args);
	}
}
