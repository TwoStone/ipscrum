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
import fhdw.ipscrum.client.events.args.TwoStringArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.interfaces.IPersonDialogView;
import fhdw.ipscrum.shared.constants.TextConstants;

/**
 * This view is used as a dialogbox to create or modify persons.
 */
public class PersonDialogView extends Composite implements IPersonDialogView {

	private final Button abb_button;
	private final VerticalPanel verticalPanel;
	private final VerticalPanel topPanel;
	private final VerticalPanel vNamePanel;
	private final Label lblVorname;
	private final TextBox vorname;
	private final VerticalPanel nNamePanel;
	private final Label lblNachname;
	private final TextBox nachname;
	private final VerticalPanel bottomPanel;
	private final HorizontalPanel buttonPanel;
	private final Button ok_button;
	private final Event<EventArgs> cancelEvent = new Event<EventArgs>();
	private final Event<TwoStringArgs> commitEvent = new Event<TwoStringArgs>();

	public PersonDialogView() {

		this.verticalPanel = new VerticalPanel();
		initWidget(this.verticalPanel);
		this.verticalPanel.setSize("320px", "170px");

		this.topPanel = new VerticalPanel();
		this.verticalPanel.add(this.topPanel);
		this.topPanel.setSize("320px", "100px");

		this.vNamePanel = new VerticalPanel();
		this.topPanel.add(this.vNamePanel);
		this.vNamePanel.setSize("185px", "50px");

		this.lblVorname = new Label(TextConstants.PERSONDIALOG_FIRSTNAME);
		this.vNamePanel.add(this.lblVorname);

		this.vorname = new TextBox();
		// this.vorname.setFocus(true); // TODO does not work - how to set focus
		// to
		// the textbox when the dialog opens?
		GwtUtils.setFocus(vorname);
		this.vNamePanel.add(this.vorname);

		this.nNamePanel = new VerticalPanel();
		this.topPanel.add(this.nNamePanel);
		this.nNamePanel.setSize("185px", "50px");

		this.lblNachname = new Label(TextConstants.PERSONDIALOG_LASTNAME);
		this.nNamePanel.add(this.lblNachname);

		this.nachname = new TextBox();
		this.nNamePanel.add(this.nachname);

		this.bottomPanel = new VerticalPanel();
		this.bottomPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		this.bottomPanel
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		this.verticalPanel.add(this.bottomPanel);
		this.bottomPanel.setSize("320px", "70px");

		this.buttonPanel = new HorizontalPanel();
		this.buttonPanel
				.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		this.buttonPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		this.bottomPanel.add(this.buttonPanel);
		this.buttonPanel.setSize("219px", "36px");

		this.ok_button = new Button("OK");
		this.ok_button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PersonDialogView.this.commitEvent.fire(
						PersonDialogView.this,
						new TwoStringArgs(PersonDialogView.this.vorname
								.getText(), PersonDialogView.this.nachname
								.getText()));
			}
		});
		this.buttonPanel.add(this.ok_button);
		this.ok_button.setSize("100px", "28px");

		this.abb_button = new Button("Abbrechen");
		this.abb_button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				PersonDialogView.this.cancelEvent.fire(PersonDialogView.this,
						new EventArgs());
			}
		});
		this.buttonPanel.add(this.abb_button);
		this.abb_button.setSize("100px", "28px");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.interfaces.IPersonDialogView#
	 * defineCancelEventHandler(fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void defineCancelEventHandler(EventHandler<EventArgs> args) {
		this.cancelEvent.add(args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.interfaces.IPersonDialogView#
	 * defineCommitEventHandler(fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void defineCommitEventHandler(EventHandler<TwoStringArgs> args) {
		this.commitEvent.add(args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.interfaces.IPersonDialogView#setVorname(java
	 * .lang.String)
	 */
	@Override
	public void setVorname(String vorname) {
		this.vorname.setText(vorname);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.interfaces.IPersonDialogView#setNachname(java
	 * .lang.String)
	 */
	@Override
	public void setNachname(String nachname) {
		this.nachname.setText(nachname);
	}

}
