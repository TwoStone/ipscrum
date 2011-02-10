package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PersonArgs;
import fhdw.ipscrum.client.view.interfaces.IPersonDialogView;
import fhdw.ipscrum.shared.model.Person;


public class PersonDialogView extends Composite implements IPersonDialogView {

	private Button abb_button;
	private VerticalPanel verticalPanel;
	private VerticalPanel topPanel;
	private VerticalPanel vNamePanel;
	private Label lblVorname;
	private TextBox vorname;
	private VerticalPanel nNamePanel;
	private Label lblNachname;
	private TextBox nachname;
	private VerticalPanel bottomPanel;
	private HorizontalPanel buttonPanel;
	private Button ok_button;
	private Event<EventArgs> cancelEvent = new Event<EventArgs>();
	private Event<PersonArgs> commitEvent = new Event<PersonArgs>();

	public PersonDialogView() {
		
		verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("320px", "170px");
		
		topPanel = new VerticalPanel();
		verticalPanel.add(topPanel);
		topPanel.setSize("320px", "100px");
		
		vNamePanel = new VerticalPanel();
		topPanel.add(vNamePanel);
		vNamePanel.setSize("185px", "50px");
		
		lblVorname = new Label("Vorname");
		vNamePanel.add(lblVorname);
		
		vorname = new TextBox();
		vorname.setFocus(true); // TODO does not work - how to do this?
		vNamePanel.add(vorname);
		
		nNamePanel = new VerticalPanel();
		topPanel.add(nNamePanel);
		nNamePanel.setSize("185px", "50px");
		
		lblNachname = new Label("Nachname");
		nNamePanel.add(lblNachname);
		
		nachname = new TextBox();
		nNamePanel.add(nachname);
		
		bottomPanel = new VerticalPanel();
		bottomPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		bottomPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		verticalPanel.add(bottomPanel);
		bottomPanel.setSize("320px", "70px");
		
		buttonPanel = new HorizontalPanel();
		buttonPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		bottomPanel.add(buttonPanel);
		buttonPanel.setSize("219px", "36px");
		
		ok_button = new Button("OK");
		ok_button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Person person = new Person(PersonDialogView.this.getVorname().getText(), PersonDialogView.this.getNachname().getText());
				PersonDialogView.this.commitEvent.fire(PersonDialogView.this, new PersonArgs(person));
			}
		});
		buttonPanel.add(ok_button);
		ok_button.setSize("100px", "28px");
		
		abb_button = new Button("Abbrechen");
		abb_button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				PersonDialogView.this.cancelEvent.fire(PersonDialogView.this, new EventArgs());
			}
		});
		buttonPanel.add(abb_button);
		abb_button.setSize("100px", "28px");
	}

	@Override
	public void defineCancelEventHandler(EventHandler<EventArgs> args) {
		this.cancelEvent.add(args);
	}
	
	@Override
	public void defineCommitEventHandler(EventHandler<PersonArgs> args) {
		this.commitEvent.add(args);
	}

	@Override
	public HasText getVorname() {
		return vorname;
	}

	@Override
	public HasText getNachname() {
		return nachname;
	}	
}
