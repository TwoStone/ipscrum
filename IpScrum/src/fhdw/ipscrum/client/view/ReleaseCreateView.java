package fhdw.ipscrum.client.view;

import java.util.Date;

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
import com.google.gwt.user.datepicker.client.DateBox;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.presenter.ReleaseCreatePresenter.IReleaseCreateView;

/**
 * represents the view to create releases.
 */
public class ReleaseCreateView extends MasterView implements IReleaseCreateView {

	private final DefaultEvent saveEvent = new DefaultEvent();
	private final DefaultEvent abortEvent = new DefaultEvent();
	private final TextBox descriptionTextBox;
	private final DateBox releaseDateBox;

	/**
	 * constructor of the ReleaseCreateView.
	 */
	public ReleaseCreateView() {
		super();

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(10);
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.add(verticalPanel);

		final HTML header = new HTML("<h3Neues Release erstellen</h3>", true);
		verticalPanel.add(header);
		verticalPanel.setCellHorizontalAlignment(header, HasHorizontalAlignment.ALIGN_CENTER);

		final Grid grid = new Grid(2, 2);
		grid.setCellPadding(5);
		verticalPanel.add(grid);
		verticalPanel.setCellHorizontalAlignment(grid, HasHorizontalAlignment.ALIGN_CENTER);

		final Label firstNameLabel = new Label("Beschreibung");
		grid.setWidget(0, 0, firstNameLabel);

		this.descriptionTextBox = new TextBox();
		grid.setWidget(0, 1, this.descriptionTextBox);

		final Label lastNameLabel = new Label("Releasedatum");
		grid.setWidget(1, 0, lastNameLabel);

		this.releaseDateBox = new DateBox();
		grid.setWidget(1, 1, this.releaseDateBox);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		verticalPanel.add(horizontalPanel);
		verticalPanel.setCellHorizontalAlignment(horizontalPanel, HasHorizontalAlignment.ALIGN_RIGHT);

		final Button saveButton = new Button("Speichern");
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ReleaseCreateView.this.saveEvent.fire(ReleaseCreateView.this);
			}
		});
		horizontalPanel.add(saveButton);

		final Button abortButton = new Button("Abbrechen");
		abortButton.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				ReleaseCreateView.this.abortEvent.fire(ReleaseCreateView.this);
			}
		});
		horizontalPanel.add(abortButton);

	}

	@Override
	public void close() {
		this.saveEvent.removeAllHandler();
		this.abortEvent.removeAllHandler();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IReleaseCreateView#registerSave(fhdw.ipscrum.client.
	 * architecture.events.DefaultEventHandler)
	 */
	@Override
	public EventRegistration registerSave(final DefaultEventHandler handler) {
		return this.saveEvent.add(handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IReleaseCreateView#registetAbort(fhdw.ipscrum.client.
	 * architecture.events.DefaultEventHandler)
	 */
	@Override
	public EventRegistration registetAbort(final DefaultEventHandler handler) {
		return this.abortEvent.add(handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IReleaseCreateView#getFirstName()
	 */
	@Override
	public String getDescription() {
		return this.descriptionTextBox.getText();
	}

	@Override
	public Date getReleaseDateBox() {
		return this.releaseDateBox.getValue();
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}

}
