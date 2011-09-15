package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.presenter.UserCreatePresenter.IUserCreateView;
import fhdw.ipscrum.shared.model.nonMeta.Person;

/**
 * represents the view to create Users.
 */
public class UserCreateView extends Composite implements IUserCreateView {
	/**
	 * constructor of the UserCreateView.
	 */
	public UserCreateView() {

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);

		this.initWidget(verticalPanel);
		verticalPanel.setSize("500px", "500px");

		final FlexTable flexTable = new FlexTable();
		flexTable.setCellPadding(5);
		verticalPanel.add(flexTable);

		final Label lblAnmeldename = new Label("Anmeldename");
		flexTable.setWidget(0, 0, lblAnmeldename);

		this.nameTextBox = new TextBox();
		flexTable.setWidget(0, 1, this.nameTextBox);

		final Label lblPasswort = new Label("Passwort");
		flexTable.setWidget(1, 0, lblPasswort);

		this.passwordTextBox = new PasswordTextBox();
		flexTable.setWidget(1, 1, this.passwordTextBox);

		final Label lblPasswortWiederholen = new Label("Passwort wiederholen");
		flexTable.setWidget(2, 0, lblPasswortWiederholen);

		this.passwordRepeatTextBox = new PasswordTextBox();

		flexTable.setWidget(2, 1, this.passwordRepeatTextBox);

		final Label lblNeuePersonAnlegen = new Label("Neue Person anlegen");
		flexTable.setWidget(3, 0, lblNeuePersonAnlegen);

		this.simpleCheckBox = new SimpleCheckBox();
		this.simpleCheckBox.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				if (UserCreateView.this.simpleCheckBox.getValue()) {
					UserCreateView.this.lblNachname.setVisible(true);
					UserCreateView.this.lblVorname.setVisible(true);
					UserCreateView.this.personFirstName.setVisible(true);
					UserCreateView.this.personLastName.setVisible(true);
					UserCreateView.this.scrollPanel.setVisible(false);
					UserCreateView.this.personList.setVisible(false);
				} else {
					UserCreateView.this.lblNachname.setVisible(false);
					UserCreateView.this.lblVorname.setVisible(false);
					UserCreateView.this.personFirstName.setVisible(false);
					UserCreateView.this.personLastName.setVisible(false);
					UserCreateView.this.personList.setVisible(true);
					UserCreateView.this.scrollPanel.setVisible(true);
				}
			}
		});
		flexTable.setWidget(3, 1, this.simpleCheckBox);

		this.scrollPanel = new ScrollPanel();
		this.scrollPanel.setStyleName("box");
		flexTable.setWidget(4, 0, this.scrollPanel);
		this.scrollPanel.setHeight("150px");

		this.personList = new CellList<Person>(new AbstractCell<Person>() {
			@Override
			public void render(final Context context, final Person value,
					final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getFirstname() + " " + value.getLastname());
			}
		});
		this.scrollPanel.setWidget(this.personList);
		this.personList.setSize("100%", "100%");
		this.personList.setSelectionModel(this.selectionModel);

		this.lblVorname = new Label("Vorname");
		flexTable.setWidget(5, 0, this.lblVorname);
		this.lblVorname.setVisible(false);

		this.personFirstName = new TextBox();
		flexTable.setWidget(5, 1, this.personFirstName);
		this.personFirstName.setVisible(false);

		this.lblNachname = new Label("Nachname");
		flexTable.setWidget(6, 0, this.lblNachname);
		this.lblNachname.setVisible(false);

		this.personLastName = new TextBox();
		flexTable.setWidget(6, 1, this.personLastName);
		flexTable.getFlexCellFormatter().setColSpan(4, 0, 2);
		this.personLastName.setVisible(false);

		this.horizontalPanel = new HorizontalPanel();
		this.horizontalPanel.setSpacing(5);
		verticalPanel.add(this.horizontalPanel);
		verticalPanel.setCellVerticalAlignment(this.horizontalPanel,
				HasVerticalAlignment.ALIGN_BOTTOM);
		verticalPanel.setCellHorizontalAlignment(this.horizontalPanel,
				HasHorizontalAlignment.ALIGN_RIGHT);

		this.btnSpeichern = new Button("Speichern");
		this.btnSpeichern.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				if (UserCreateView.this.checkPasswords()) {
					if (UserCreateView.this.simpleCheckBox.getValue()) {
						UserCreateView.this.createUserAndPersonEvent.fire(
								UserCreateView.this, new NewUserAndPersonEventArgs(
										UserCreateView.this.nameTextBox.getText(),
										UserCreateView.this.passwordTextBox.getText(),
										UserCreateView.this.personFirstName.getText(),
										UserCreateView.this.personLastName.getText()));
					} else {
						UserCreateView.this.createUserEvent.fire(
								UserCreateView.this,
								new NewUserEventArgs(UserCreateView.this.nameTextBox
										.getText(), UserCreateView.this.passwordTextBox
										.getText(), UserCreateView.this.selectionModel
										.getSelectedObject()));
					}
				}
			}

		});
		this.horizontalPanel.add(this.btnSpeichern);

		this.btnAbbrechen = new Button("Abbrechen");
		this.btnAbbrechen.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				UserCreateView.this.abortEvent.fire(UserCreateView.this);
			}
		});
		this.horizontalPanel.add(this.btnAbbrechen);
	}

	private final Event<NewUserEventArgs> createUserEvent =
			new Event<NewUserEventArgs>();
	private final Event<NewUserAndPersonEventArgs> createUserAndPersonEvent =
			new Event<NewUserAndPersonEventArgs>();
	private final DefaultEvent abortEvent = new DefaultEvent();
	private final Label lblVorname;
	private final Label lblNachname;
	private final TextBox personFirstName;
	private final TextBox personLastName;
	private final CellList<Person> personList;
	private final PasswordTextBox passwordTextBox;
	private final TextBox nameTextBox;
	private final PasswordTextBox passwordRepeatTextBox;
	private final SimpleCheckBox simpleCheckBox;
	private final HorizontalPanel horizontalPanel;
	private final Button btnSpeichern;
	private final Button btnAbbrechen;
	private final SingleSelectionModel<Person> selectionModel =
			new SingleSelectionModel<Person>();
	private final ScrollPanel scrollPanel;

	@Override
	public void close() {
		this.createUserEvent.removeAllHandler();
		this.createUserAndPersonEvent.removeAllHandler();
		this.abortEvent.removeAllHandler();
	}

	@Override
	public void setPersons(final List<Person> person) {
		this.personList.setRowData(person);
	}

	@Override
	public EventRegistration registerCreateNewUser(
			final EventHandler<NewUserEventArgs> handler) {
		return this.createUserEvent.add(handler);
	}

	@Override
	public EventRegistration registerCreateNewUserAndPerson(
			final EventHandler<NewUserAndPersonEventArgs> handler) {
		return this.createUserAndPersonEvent.add(handler);
	}

	private boolean checkPasswords() {
		return this.passwordTextBox.getText().equals(
				this.passwordRepeatTextBox.getText());
	}

	@Override
	public EventRegistration registerAbortHandler(final DefaultEventHandler handler) {
		return this.abortEvent.add(handler);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}

}
