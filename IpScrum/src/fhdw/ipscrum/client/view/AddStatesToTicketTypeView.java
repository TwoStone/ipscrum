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
import fhdw.ipscrum.client.presenter.AddStatesToTicketTypePresenter.IAddStatesToTicketTypeView;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;

/**
 * represents the view in which states could be added to a ticket type.
 */
public class AddStatesToTicketTypeView extends Composite
		implements IAddStatesToTicketTypeView {

	private final DefaultEvent saveEvent = new DefaultEvent();
	private final DefaultEvent abortEvent = new DefaultEvent();
	private final CellList<StateType> cellList;

	/**
	 * constructor of the AddStatesToTicketTypeView.
	 */
	public AddStatesToTicketTypeView() {

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(10);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.initWidget(verticalPanel);
		verticalPanel.setHeight("283px");

		final HTML header = new HTML("<h3Zustände zu Tickettyp hinzufügen</h3>", true);
		verticalPanel.add(header);
		verticalPanel.setCellHorizontalAlignment(header,
				HasHorizontalAlignment.ALIGN_CENTER);

		final Label firstNameLabel = new Label("Wählbare Zustände");
		verticalPanel.add(firstNameLabel);

		final ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setStyleName("smallborderWithWhiteBG");
		verticalPanel.add(scrollPanel);

		this.cellList = new CellList<StateType>(new AbstractCell<StateType>() {
			@Override
			public void render(final Context context, final StateType value,
					final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());
			}
		});

		scrollPanel.add(this.cellList);

		this.cellList.setSelectionModel(new SingleSelectionModel<StateType>());

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		verticalPanel.add(horizontalPanel);
		verticalPanel.setCellHorizontalAlignment(horizontalPanel,
				HasHorizontalAlignment.ALIGN_RIGHT);

		final Button saveButton = new Button("Speichern");
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				AddStatesToTicketTypeView.this.saveEvent
						.fire(AddStatesToTicketTypeView.this);
			}
		});
		horizontalPanel.add(saveButton);

		final Button abortButton = new Button("Abbrechen");
		abortButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				AddStatesToTicketTypeView.this.abortEvent
						.fire(AddStatesToTicketTypeView.this);
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
	public StateType getSelectedStateType() {
		return ((SingleSelectionModel<StateType>) this.cellList.getSelectionModel())
				.getSelectedObject();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.ICreateIncidentView#refreshProjects(java.util.List)
	 */
	@Override
	public void refreshStates(final List<StateType> states) {
		this.cellList.setRowData(states);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}

}
