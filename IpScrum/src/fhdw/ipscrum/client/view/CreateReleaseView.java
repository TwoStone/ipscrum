package fhdw.ipscrum.client.view;

import java.util.Date;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DateBox;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.interfaces.ICreateReleaseView;
import fhdw.ipscrum.client.view.interfaces.IView;

public class CreateReleaseView extends Composite implements ICreateReleaseView{

	// ####### Events #######
	private final Event<EventArgs> saveEvent = new Event<EventArgs>();
	private final Event<EventArgs> cancelCreateReleaseEvent = new Event<EventArgs>();
	// ####### Ende ######

	private Button btnCreateRelease;
	private TextBox txtBoxVersion;
	private DateBox dateBox;
	private Button btnCancel;
	
	public static IView createView() {
		return new CreateReleaseView();
	}

	public CreateReleaseView() {

		AbsolutePanel concreteCreateProjectPanel = new AbsolutePanel();
		initWidget(concreteCreateProjectPanel);
		concreteCreateProjectPanel.setSize("285px", "182px");

		Label lblCreateRelease = new Label("Neues Release erstellen");
		lblCreateRelease.setStyleName("LabelElement");
		lblCreateRelease
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		concreteCreateProjectPanel.add(lblCreateRelease, 10, 2);
		lblCreateRelease.setSize("193px", "38px");

		btnCreateRelease = new Button("New button");
		btnCreateRelease.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				saveEvent.fire(CreateReleaseView.this, new EventArgs());
			}
		});
		btnCreateRelease.setText("Release erstellen");
		concreteCreateProjectPanel.add(btnCreateRelease, 10, 144);
		btnCreateRelease.setSize("148px", "28px");

		Label lblBezeichnung = new Label("Versionsbezeichnung:");
		lblBezeichnung.setStyleName("LabelElement");
		concreteCreateProjectPanel.add(lblBezeichnung, 10, 40);

		txtBoxVersion = new TextBox();
		concreteCreateProjectPanel.add(txtBoxVersion, 10, 62);
		
		btnCancel = new Button("New button");
		btnCancel.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				cancelCreateReleaseEvent.fire(CreateReleaseView.this, new EventArgs());
				
			}
		});
		
		btnCancel.setText("Abbrechen");
		concreteCreateProjectPanel.add(btnCancel, 175, 144);
		btnCancel.setSize("100px", "28px");
		
		Label lblDatum = new Label("Datum:");
		lblDatum.setStyleName("LabelElement");
		concreteCreateProjectPanel.add(lblDatum, 10, 92);
		
		dateBox = new DateBox();
		dateBox.setValue(new Date(1296664167187L));
		concreteCreateProjectPanel.add(dateBox, 10, 116);
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ICreateReleaseView#addSaveVersionHandler(fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void addSaveVersionHandler(EventHandler<EventArgs> args) {
		saveEvent.add(args);
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ICreateReleaseView#getReleaseVersion()
	 */
	@Override
	public String getReleaseVersion() {
		return txtBoxVersion.getText();
	}
	
	public void setReleaseVersion(String version) {
		txtBoxVersion.setText(version);
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ICreateReleaseView#addCancelCreateReleaseHandler(fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void addCancelCreateReleaseHandler(EventHandler<EventArgs> args) {
		cancelCreateReleaseEvent.add(args);
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ICreateReleaseView#getDateBox()
	 */
	@Override
	public DateBox getDateBox() {
		return dateBox;
	}
	public Button getBtnCreateRelease() {
		return btnCreateRelease;
	}
	public TextBox getTxtBoxVersion() {
		return txtBoxVersion;
	}
	public Button getBtnCancel() {
		return btnCancel;
	}
}
