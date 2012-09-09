package fhdw.ipscrum.client.view;

import java.io.Serializable;
import java.util.List;

import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.architecture.widgets.TypedListBox;
import fhdw.ipscrum.client.architecture.widgets.TypedListBox.TypeRendere;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.metamodel.controller.FieldTypeController;
import fhdw.ipscrum.client.view.widgets.EditLabel;
import fhdw.ipscrum.client.viewinterfaces.IGenericTicketView;
import fhdw.ipscrum.shared.exceptions.model.NothingSelectedException;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;

/**
 * represents the view to edit a ticket.
 */
public class GenericTicketView extends MasterView implements IGenericTicketView {

	private final DefaultEvent saveEvent = new DefaultEvent();
	private final DefaultEvent abortEvent = new DefaultEvent();
	private FlexTable flexTable;
	private Label statusLabel;
	private TypedListBox<StateType> possibleStateComboBox;
	private EditLabel nameLabel;
	private TextArea descriptionTextBox;
	private final Event<TypedEventArg<String>> changeNameEvent = new Event<TypedEventArg<String>>();
	private final Event<TypedEventArg<String>> changeDescriptionEvent = new Event<TypedEventArg<String>>();
	private final Event<TypedEventArg<StateType>> changeStateEvent = new Event<TypedEventArg<StateType>>();

	/**
	 * constructor of the GenericTicketView.
	 */
	public GenericTicketView() {
		super();

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(5);
		verticalPanel.setWidth("600px");
		this.add(verticalPanel);

		final HorizontalPanel headPanel = new HorizontalPanel();
		verticalPanel.add(headPanel);
		headPanel.setWidth("100%");

		final VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setSpacing(5);
		headPanel.add(verticalPanel_1);

		this.nameLabel = new EditLabel();
		this.nameLabel.addValueChangeHandler(new ValueChangeHandler<String>() {
			@Override
			public void onValueChange(final ValueChangeEvent<String> event) {
				GenericTicketView.this.changeNameEvent.fire(GenericTicketView.this,
						new TypedEventArg<String>(event.getValue()));
			}
		});
		verticalPanel_1.add(this.nameLabel);
		this.nameLabel.setStyleName("nameField");
		this.nameLabel.setText("name");

		final Label lblBeschreibung = new Label("Beschreibung");
		verticalPanel_1.add(lblBeschreibung);

		this.descriptionTextBox = new TextArea();
		this.descriptionTextBox.setCharacterWidth(30);
		this.descriptionTextBox.setVisibleLines(4);
		this.descriptionTextBox.addChangeHandler(new ChangeHandler() {
			@Override
			public void onChange(final ChangeEvent event) {
				GenericTicketView.this.changeDescriptionEvent.fire(GenericTicketView.this, new TypedEventArg<String>(
						GenericTicketView.this.descriptionTextBox.getText()));
			}
		});
		verticalPanel_1.add(this.descriptionTextBox);

		final Grid stateGrid = new Grid(3, 2);
		stateGrid.setCellSpacing(10);
		headPanel.add(stateGrid);
		headPanel.setCellVerticalAlignment(stateGrid, HasVerticalAlignment.ALIGN_BOTTOM);
		headPanel.setCellHorizontalAlignment(stateGrid, HasHorizontalAlignment.ALIGN_RIGHT);

		final Label lblStatus = new Label("Status");
		stateGrid.setWidget(0, 0, lblStatus);

		this.statusLabel = new Label("New label");
		stateGrid.setWidget(0, 1, this.statusLabel);

		final Label lblWechselnZu = new Label("Wechseln zu");
		stateGrid.setWidget(1, 0, lblWechselnZu);

		this.possibleStateComboBox = new TypedListBox<StateType>(new TypeRendere<StateType>() {

			@Override
			public String render(final StateType object) {
				return object.getName();
			}
		});
		this.possibleStateComboBox.setVisibleItemCount(1);
		stateGrid.setWidget(1, 1, this.possibleStateComboBox);
		this.possibleStateComboBox.setWidth("150px");

		final Button btnStatusWechseln = new Button("Status wechseln");
		btnStatusWechseln.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				try {
					final StateType selectedItem = GenericTicketView.this.possibleStateComboBox.getSelectedItem();
					GenericTicketView.this.changeStateEvent.fire(GenericTicketView.this, new TypedEventArg<StateType>(
							selectedItem));
				} catch (final NothingSelectedException e) {
					GwtUtils.setFocus(GenericTicketView.this.possibleStateComboBox);
				}
			}
		});
		stateGrid.setWidget(2, 1, btnStatusWechseln);
		stateGrid.getCellFormatter().setHorizontalAlignment(2, 1, HasHorizontalAlignment.ALIGN_RIGHT);

		final HTML html = new HTML("<hr/>", true);
		verticalPanel.add(html);
		html.setHeight("15px");

		this.flexTable = new FlexTable();
		verticalPanel.add(this.flexTable);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		verticalPanel.add(horizontalPanel);
		verticalPanel.setCellVerticalAlignment(horizontalPanel, HasVerticalAlignment.ALIGN_BOTTOM);
		verticalPanel.setCellHorizontalAlignment(horizontalPanel, HasHorizontalAlignment.ALIGN_RIGHT);

		final Button saveButton = new Button("Speichern");
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				GenericTicketView.this.saveEvent.fire(GenericTicketView.this);
			}
		});
		horizontalPanel.add(saveButton);

		final Button abortButton = new Button("Abbrechen");
		abortButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				GenericTicketView.this.abortEvent.fire(GenericTicketView.this);
			}
		});
		horizontalPanel.add(abortButton);
	}

	@Override
	public void close() {
		this.saveEvent.removeAllHandler();
		this.abortEvent.removeAllHandler();
	}

	@Override
	public EventRegistration registerSaveHandler(final DefaultEventHandler handler) {
		return this.saveEvent.add(handler);
	}

	@Override
	public EventRegistration registerAbortHandler(final DefaultEventHandler handler) {
		return this.abortEvent.add(handler);
	}

	@Override
	public <T extends Serializable> void add(final FieldTypeController<T> controller) {
		final int rowCount = this.flexTable.getRowCount();
		this.flexTable.setWidget(rowCount, 0, new Label(controller.getField().getType().getName()));
		this.flexTable.setWidget(rowCount, 1, controller.getWidget());
	}

	@Override
	public EventRegistration registerNameChangedHandler(final EventHandler<TypedEventArg<String>> handler) {
		return this.changeNameEvent.add(handler);
	}

	@Override
	public EventRegistration registerDescriptionChangeHandler(final EventHandler<TypedEventArg<String>> handler) {
		return this.changeDescriptionEvent.add(handler);
	}

	@Override
	public void setName(final String name) {
		this.nameLabel.setText(name);
	}

	@Override
	public void setDescription(final String description) {
		this.descriptionTextBox.setText(description);
	}

	@Override
	public void setPossibleStates(final List<StateType> stateTypes) {
		this.possibleStateComboBox.clear();
		this.possibleStateComboBox.addItems(stateTypes);
	}

	@Override
	public void setCurrentState(final StateType stateType) {
		this.statusLabel.setText(stateType.getName());
	}

	@Override
	public EventRegistration regsiterChangeStateHandler(final EventHandler<TypedEventArg<StateType>> handler) {
		return this.changeStateEvent.add(handler);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// TODO Auto-generated method stub

	}

}
