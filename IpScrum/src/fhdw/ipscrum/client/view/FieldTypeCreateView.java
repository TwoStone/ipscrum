package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.presenter.FieldTypeCreatePresenter.IFieldTypeCreateView;
import fhdw.ipscrum.shared.constants.TextConstants;

/**
 * represents the view in which a field type could be created.
 */
public class FieldTypeCreateView extends Composite implements IFieldTypeCreateView {

	private final DefaultEvent saveEvent = new DefaultEvent();
	private final DefaultEvent abortEvent = new DefaultEvent();
	private final TextBox descriptionTextBox;
	private final ListBox comboBoxType;
	private final ListBox comboBoxMultiplicity;

	/**
	 * constructor of the FieldTypeCreateView.
	 */
	public FieldTypeCreateView() {

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(10);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.initWidget(verticalPanel);

		final HTML header = new HTML("<h3>Neues Feld erzeugen</h3>", true);
		verticalPanel.add(header);
		verticalPanel.setCellHorizontalAlignment(header,
				HasHorizontalAlignment.ALIGN_CENTER);

		final Grid grid = new Grid(3, 2);
		grid.setCellPadding(5);
		verticalPanel.add(grid);
		verticalPanel.setCellHorizontalAlignment(grid,
				HasHorizontalAlignment.ALIGN_CENTER);

		final Label firstNameLabel = new Label("Bezeichnung");
		grid.setWidget(0, 0, firstNameLabel);

		this.descriptionTextBox = new TextBox();
		grid.setWidget(0, 1, this.descriptionTextBox);

		final Label lastNameLabel = new Label("Typ");
		grid.setWidget(1, 0, lastNameLabel);

		this.comboBoxType = new ListBox();
		grid.setWidget(1, 1, this.comboBoxType);
		this.comboBoxType.setWidth("100%");
		this.fillComboBoxType();

		final Label lblMultiplicity = new Label("Multiplizitat");
		grid.setWidget(2, 0, lblMultiplicity);

		this.comboBoxMultiplicity = new ListBox();
		grid.setWidget(2, 1, this.comboBoxMultiplicity);
		this.comboBoxMultiplicity.setWidth("100%");
		this.fillComboBoxMultiplicity();

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		verticalPanel.add(horizontalPanel);
		verticalPanel.setCellHorizontalAlignment(horizontalPanel,
				HasHorizontalAlignment.ALIGN_RIGHT);

		final Button saveButton = new Button("Save");
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				FieldTypeCreateView.this.saveEvent.fire(FieldTypeCreateView.this);
			}
		});
		horizontalPanel.add(saveButton);

		final Button abortButton = new Button("Abort");
		abortButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				FieldTypeCreateView.this.abortEvent.fire(FieldTypeCreateView.this);
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
	public EventRegistration registerSave(final DefaultEventHandler handler) {
		return this.saveEvent.add(handler);
	}

	@Override
	public EventRegistration registetAbort(final DefaultEventHandler handler) {
		return this.abortEvent.add(handler);
	}

	@Override
	public String getDescription() {
		return this.descriptionTextBox.getText();
	}

	@Override
	public String getType() {
		return this.comboBoxType.getItemText(this.comboBoxType.getSelectedIndex());
	}

	@Override
	public String getMultiplicity() {
		return this.comboBoxMultiplicity.getItemText(this.comboBoxMultiplicity
				.getSelectedIndex());
	}

	private void fillComboBoxType() {
		this.comboBoxType.addItem(TextConstants.FIELDTYPE_ACCEPTANCECRITERIAL);
		this.comboBoxType.addItem(TextConstants.FIELDTYPE_DATE);
		this.comboBoxType.addItem(TextConstants.FIELDTYPE_EFFORD);
		this.comboBoxType.addItem(TextConstants.FIELDTYPE_HINT);
		this.comboBoxType.addItem(TextConstants.FIELDTYPE_NUMBER);
		this.comboBoxType.addItem(TextConstants.FIELDTYPE_PBI);
		this.comboBoxType.addItem(TextConstants.FIELDTYPE_PERSON);
		this.comboBoxType.addItem(TextConstants.FIELDTYPE_RELEASE);
		this.comboBoxType.addItem(TextConstants.FIELDTYPE_SPRINT);
		this.comboBoxType.addItem(TextConstants.FIELDTYPE_SYSTEM);
		this.comboBoxType.addItem(TextConstants.FIELDTYPE_TEXT);
	}

	private void fillComboBoxMultiplicity() {
		this.comboBoxMultiplicity.addItem(TextConstants.FIELDTYPE_ONE);
		this.comboBoxMultiplicity.addItem(TextConstants.FIELDTYPE_MANY);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide
	}

}
