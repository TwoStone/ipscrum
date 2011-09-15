package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.presenter.AddFieldsToTicketTypePresenter.IAddFieldsToTicketTypeView;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;

/**
 * represents the view in which field types could be added to a ticket type.
 */
public class AddFieldsToTicketTypeView extends Composite
		implements IAddFieldsToTicketTypeView {

	/**
	 * represents the save event which is fired to save.
	 */
	private final DefaultEvent saveEvent = new DefaultEvent();
	/**
	 * represents the abort event which is fired to abort.
	 */
	private final DefaultEvent abortEvent = new DefaultEvent();
	/**
	 * represents the cell list containing the field types.
	 */
	private final CellList<FieldType> cellList;
	/**
	 * represents the selection of one field type from the field type table.
	 */
	private final SingleSelectionModel<FieldType> selModelFieldType;

	/**
	 * constructor of the AddFieldsToTicketView.
	 */
	public AddFieldsToTicketTypeView() {

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(10);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.initWidget(verticalPanel);
		verticalPanel.setHeight("361px");

		final HTML header = new HTML("<Felder zu Tickettyp hinzufügen</h3>", true);
		verticalPanel.add(header);
		verticalPanel.setCellHorizontalAlignment(header,
				HasHorizontalAlignment.ALIGN_CENTER);

		final Label firstNameLabel = new Label("Wählbare Felder");
		verticalPanel.add(firstNameLabel);

		final ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setStyleName("smallborderWithWhiteBG");
		verticalPanel.add(scrollPanel);

		this.cellList = new CellList<FieldType>(new AbstractCell<FieldType>() {
			@Override
			public void render(final Context context, final FieldType value,
					final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});
		scrollPanel.add(this.cellList);
		this.selModelFieldType = new SingleSelectionModel<FieldType>();

		this.cellList.setSelectionModel(this.selModelFieldType);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		verticalPanel.add(horizontalPanel);
		verticalPanel.setCellHorizontalAlignment(horizontalPanel,
				HasHorizontalAlignment.ALIGN_RIGHT);

		final Button saveButton = new Button("Speichern");
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				AddFieldsToTicketTypeView.this.saveEvent
						.fire(AddFieldsToTicketTypeView.this);
			}
		});
		horizontalPanel.add(saveButton);

		final Button abortButton = new Button("Abbrechen");
		abortButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				AddFieldsToTicketTypeView.this.abortEvent
						.fire(AddFieldsToTicketTypeView.this);
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
	@SuppressWarnings("unchecked")
	public FieldType getSelectedFieldType() {
		return ((SingleSelectionModel<FieldType>) this.cellList.getSelectionModel())
				.getSelectedObject();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.ICreateIncidentView#refreshProjects(java.util.List)
	 */
	@Override
	public void refreshFields(final List<FieldType> fields) {
		this.cellList.setRowData(fields);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}

}
