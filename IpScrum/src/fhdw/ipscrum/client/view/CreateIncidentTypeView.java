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
import com.google.gwt.user.client.ui.HorizontalPanel;

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

		Label label = new Label("Neuen Ereignis-Typ anlegen:");
		label.setStyleName("LabelElement");
		verticalPanel.add(label);
		label.setSize("201px", "24px");

		Label label_1 = new Label("Name:");
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

		createBtn = new Button("Anlegen");
		horizontalPanel.add(createBtn);
		createBtn.setText("Typ Anlegen");
		createBtn.setStyleName("taskboardButton");
		createBtn.setWidth("102px");

		Button btnAbbrechen = new Button("Abbrechen");
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
