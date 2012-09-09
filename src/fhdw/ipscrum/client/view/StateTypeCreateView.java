package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.presenter.StateTypeCreatePresenter.IStateCreateView;

/**
 * represents the view to create state types.
 */
public class StateTypeCreateView extends MasterView implements IStateCreateView {

	private final DefaultEvent saveEvent = new DefaultEvent();
	private final DefaultEvent abortEvent = new DefaultEvent();
	private final TextBox nameTextBox;
	private final TextArea descriptionArea;

	/**
	 * constructor of the StateTypeCreateView.
	 */
	public StateTypeCreateView() {
		super();

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(10);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.add(verticalPanel);

		final HTML header = new HTML("<h3>Neuen Zustandstypen erstellen</h3>", true);
		verticalPanel.add(header);
		verticalPanel.setCellHorizontalAlignment(header, HasHorizontalAlignment.ALIGN_CENTER);

		final Grid grid = new Grid(2, 2);
		grid.setCellPadding(5);
		verticalPanel.add(grid);
		verticalPanel.setCellHorizontalAlignment(grid, HasHorizontalAlignment.ALIGN_CENTER);

		final Label nameLabel = new Label("Name");
		grid.setWidget(0, 0, nameLabel);

		this.nameTextBox = new TextBox();
		grid.setWidget(0, 1, this.nameTextBox);
		this.nameTextBox.setWidth("100%");

		final Label descriptionLabel = new Label("Beschreibung");
		grid.setWidget(1, 0, descriptionLabel);

		this.descriptionArea = new TextArea();
		this.descriptionArea.setText("");
		grid.setWidget(1, 1, this.descriptionArea);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		verticalPanel.add(horizontalPanel);
		verticalPanel.setCellHorizontalAlignment(horizontalPanel, HasHorizontalAlignment.ALIGN_RIGHT);

		final Button saveButton = new Button("Save");
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				StateTypeCreateView.this.saveEvent.fire(StateTypeCreateView.this);
			}
		});
		horizontalPanel.add(saveButton);

		final Button abortButton = new Button("Abort");
		abortButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				StateTypeCreateView.this.abortEvent.fire(StateTypeCreateView.this);
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
	public String getName() {
		return this.nameTextBox.getText();
	}

	@Override
	public String getDescription() {
		return this.descriptionArea.getText();
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}
}
