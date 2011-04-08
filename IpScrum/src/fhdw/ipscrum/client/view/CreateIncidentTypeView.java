package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.interfaces.ICreateIncidentTypeView;
import fhdw.ipscrum.shared.constants.TextConstants;

import com.google.gwt.user.client.ui.HorizontalPanel;

/**
 * This class is used to create the {@link CreateIncidentTypeView}.
 * 
 * @author Phase IV - Group Reporting II
 */
public class CreateIncidentTypeView extends Composite implements
		ICreateIncidentTypeView {
	private TextBox nameTextBox;
	private Button createBtn;

	// EVENTS
	private final Event<EventArgs> createIncidentType = new Event<EventArgs>();
	private final Event<EventArgs> cancelEvent = new Event<EventArgs>();

	// ENDE EVENTS

	public CreateIncidentTypeView() {

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setStyleName("createFeatureTable");
		verticalPanel.setSpacing(2);
		initWidget(verticalPanel);
		verticalPanel.setSize("238px", "134px");

		Label lblNeuenEreignistypAnlegen = new Label(TextConstants.CREATE_NEW_INCIDENTTYPE);
		lblNeuenEreignistypAnlegen.setStyleName("bold");
		verticalPanel.add(lblNeuenEreignistypAnlegen);
		lblNeuenEreignistypAnlegen.setSize("201px", "24px");

		Label label_1 = new Label(TextConstants.NAME);
		label_1.setWordWrap(false);
		label_1.setStyleName("TreeItem-leaf");
		verticalPanel.add(label_1);
		label_1.setSize("95%", "22px");

		nameTextBox = new TextBox();
		verticalPanel.add(nameTextBox);

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(3);
		verticalPanel.add(horizontalPanel);
		horizontalPanel.setWidth("231px");

		createBtn = new Button(TextConstants.CREATE);
		horizontalPanel.add(createBtn);
		createBtn.setText(TextConstants.CREATE_TYPE);
		createBtn.setStyleName("taskboardButton");
		createBtn.setWidth("102px");

		Button btnAbbrechen = new Button(TextConstants.ABORT);
		btnAbbrechen.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				CreateIncidentTypeView.this.cancelEvent.fire(
						CreateIncidentTypeView.this, new EventArgs());
			}
		});
		btnAbbrechen.setStyleName("taskboardButton");
		horizontalPanel.add(btnAbbrechen);
		btnAbbrechen.setWidth("102");
		createBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				createIncidentType.fire(CreateIncidentTypeView.this,
						new EventArgs());
			}
		});
	}

	public TextBox getNameTextBox() {
		return nameTextBox;
	}

	public Button getCreateBtn() {
		return createBtn;
	}

	@Override
	public String getName() {
		return this.getNameTextBox().getValue();
	}

	@Override
	public void addCreateTypeHandler(EventHandler<EventArgs> args) {
		this.createIncidentType.add(args);
	}

	@Override
	public void addCancelEventHandler(EventHandler<EventArgs> args) {
		this.cancelEvent.add(args);
	}
}
