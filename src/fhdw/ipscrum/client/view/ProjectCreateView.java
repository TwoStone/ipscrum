package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.presenter.ProjectCreatePresenter.IProjectCreateView;

/**
 * represents the view to create projects.
 */
public class ProjectCreateView extends MasterView implements IProjectCreateView {

	private final DefaultEvent saveEvent = new DefaultEvent();
	private final DefaultEvent abortEvent = new DefaultEvent();
	private final TextBox descriptionTextBox;

	/**
	 * constructor of the ProjectCreateView.
	 */
	public ProjectCreateView() {
		super(); // ADDED SUPER-CALL
		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(10);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.add(verticalPanel); // CHANGED FROM INITWIDGET()

		final HTML header = new HTML("<h3>Neues Projekt erstellen</h3>", true);
		verticalPanel.add(header);
		verticalPanel.setCellHorizontalAlignment(header, HasHorizontalAlignment.ALIGN_CENTER);

		final Grid grid = new Grid(1, 2);
		grid.setCellPadding(10);
		verticalPanel.add(grid);
		verticalPanel.setCellHorizontalAlignment(grid, HasHorizontalAlignment.ALIGN_CENTER);

		final Label descriptionLabel = new Label("Beschreibung");
		grid.setWidget(0, 0, descriptionLabel);

		this.descriptionTextBox = new TextBox();
		grid.setWidget(0, 1, this.descriptionTextBox);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		verticalPanel.add(horizontalPanel);
		verticalPanel.setCellHorizontalAlignment(horizontalPanel, HasHorizontalAlignment.ALIGN_RIGHT);

		final Button saveButton = new Button("Speichern");
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ProjectCreateView.this.saveEvent.fire(ProjectCreateView.this);
			}
		});
		horizontalPanel.add(saveButton);

		final Button abortButton = new Button("Abbrechen");
		abortButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				ProjectCreateView.this.abortEvent.fire(ProjectCreateView.this);
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
		return this.descriptionTextBox.getText();
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}

}
