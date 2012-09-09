package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
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
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.presenter.StateTransitionCreatePresenter.IStateTransitionCreateView;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;

/**
 * represents the view to create state transitions.
 */
public class StateTransitionCreateView extends MasterView implements IStateTransitionCreateView {

	private final DefaultEvent saveEvent = new DefaultEvent();
	private final DefaultEvent abortEvent = new DefaultEvent();
	private final CellList<StateType> cellList;
	/**
	 * represents the selection of one field type from the field type table.
	 */
	private final SingleSelectionModel<StateType> selModelFieldType;
	private final SingleSelectionModel<StateType> selModelStateType;
	private final CellList<StateType> cellList2;

	/**
	 * constructor of the StateTransitionCreateView.
	 */
	public StateTransitionCreateView() {
		super();

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(10);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.add(verticalPanel);
		verticalPanel.setSize("598px", "325px");

		final HTML header = new HTML("<h3>Neuen Zustandsübergang erzeugen</h3>", true);
		verticalPanel.add(header);
		verticalPanel.setCellHorizontalAlignment(header, HasHorizontalAlignment.ALIGN_CENTER);

		final HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		verticalPanel.add(horizontalPanel_1);

		final Label lblNewLabel = new Label("Ausgangszustand");
		horizontalPanel_1.add(lblNewLabel);

		final ScrollPanel scrollPanel = new ScrollPanel();
		horizontalPanel_1.add(scrollPanel);
		scrollPanel.setStyleName("smallborderWithWhiteBG");

		this.cellList = new CellList<StateType>(new AbstractCell<StateType>() {

			@Override
			public void render(final com.google.gwt.cell.client.Cell.Context context, final StateType value,
					final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());

			}
		});
		scrollPanel.add(this.cellList);

		final Label lblNewLabel_1 = new Label("Folgezustand");
		horizontalPanel_1.add(lblNewLabel_1);

		final ScrollPanel scrollPanel_1 = new ScrollPanel();
		horizontalPanel_1.add(scrollPanel_1);
		scrollPanel_1.setStyleName("smallborderWithWhiteBG");
		this.cellList2 = new CellList<StateType>(new AbstractCell<StateType>() {

			@Override
			public void render(final com.google.gwt.cell.client.Cell.Context context, final StateType value,
					final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getName());

			}
		});
		scrollPanel_1.add(this.cellList2);

		this.selModelStateType = new SingleSelectionModel<StateType>();
		this.selModelFieldType = new SingleSelectionModel<StateType>();
		this.cellList2.setSelectionModel(this.selModelStateType);
		this.cellList.setSelectionModel(this.selModelFieldType);
		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		verticalPanel.add(horizontalPanel);
		verticalPanel.setCellHorizontalAlignment(horizontalPanel, HasHorizontalAlignment.ALIGN_RIGHT);

		final Button saveButton = new Button("Speichern");
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				StateTransitionCreateView.this.saveEvent.fire(StateTransitionCreateView.this);
			}
		});
		horizontalPanel.add(saveButton);

		final Button abortButton = new Button("Abbrechen");
		abortButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				StateTransitionCreateView.this.abortEvent.fire(StateTransitionCreateView.this);
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

	@SuppressWarnings("unchecked")
	@Override
	public StateType getOriginalState() {
		return ((SingleSelectionModel<StateType>) this.cellList.getSelectionModel()).getSelectedObject();
	}

	@SuppressWarnings("unchecked")
	@Override
	public StateType getSubSequentState() {
		return ((SingleSelectionModel<StateType>) this.cellList2.getSelectionModel()).getSelectedObject();
	}

	@Override
	public void updateComboBoxType(final List<StateType> statetype) {
		this.cellList.setRowData(statetype);
	}

	@Override
	public void updateComboBoxMultiplicity(final List<StateType> stattype) {
		this.cellList2.setRowData(stattype);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}

}
