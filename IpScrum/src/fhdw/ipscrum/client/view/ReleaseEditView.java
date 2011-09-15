package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.view.widgets.SprintTable;
import fhdw.ipscrum.client.viewinterfaces.IReleaseEditView;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * represents the view to edit releases.
 */
public class ReleaseEditView extends Composite implements IReleaseEditView {

	private final SingleSelectionModel<Sprint> selModelAssignedSprints =
			new SingleSelectionModel<Sprint>();
	private final SingleSelectionModel<Sprint> selModelAvailableSprints =
			new SingleSelectionModel<Sprint>();
	private final SprintTable sprintTableAssigned;
	private final SprintTable sprintTableAvailable;

	private final Event<TypedEventArg<Sprint>> assignEvent =
			new Event<TypedEventArg<Sprint>>();
	private final Event<TypedEventArg<Sprint>> removeEvent =
			new Event<TypedEventArg<Sprint>>();
	private final DefaultEvent closeEvent = new DefaultEvent();

	/**
	 * constructor of the ReleaseEditView.
	 */
	public ReleaseEditView() {

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(5);
		this.initWidget(verticalPanel);
		verticalPanel.setSize("900px", "350px");

		final Label lblHeader = new Label("Sprintzuordnung");
		lblHeader.setStyleName("header3");
		verticalPanel.add(lblHeader);
		verticalPanel.setCellHorizontalAlignment(lblHeader,
				HasHorizontalAlignment.ALIGN_CENTER);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(10);
		verticalPanel.add(horizontalPanel);
		verticalPanel.setCellHorizontalAlignment(horizontalPanel,
				HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setCellHeight(horizontalPanel, "100%");
		horizontalPanel.setHeight("100%");

		final VerticalPanel pnlAssignedSprints = new VerticalPanel();
		horizontalPanel.add(pnlAssignedSprints);

		final Label lblAsssigned = new Label("Zugeordnete Sprints");
		lblAsssigned.setStyleName("bold");
		pnlAssignedSprints.add(lblAsssigned);

		final ScrollPanel scrollPanel = new ScrollPanel();
		pnlAssignedSprints.add(scrollPanel);
		scrollPanel.setHeight("250px");
		pnlAssignedSprints.setCellHeight(scrollPanel, "250px");

		this.sprintTableAssigned = new SprintTable();
		scrollPanel.setWidget(this.sprintTableAssigned);
		this.sprintTableAssigned.setSize("100%", "100%");
		this.sprintTableAssigned.setSelectionModel(this.selModelAssignedSprints);

		final VerticalPanel pnlButtons = new VerticalPanel();
		horizontalPanel.add(pnlButtons);
		horizontalPanel.setCellVerticalAlignment(pnlButtons,
				HasVerticalAlignment.ALIGN_MIDDLE);

		final Button button = new Button("<-");
		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				if (ReleaseEditView.this.getSelectedSprintAvailableSprints() != null) {
					ReleaseEditView.this.assignEvent.fire(
							ReleaseEditView.this,
							new TypedEventArg<Sprint>(ReleaseEditView.this
									.getSelectedSprintAvailableSprints()));
				}
			}
		});
		pnlButtons.add(button);

		final Button button2 = new Button("->");
		button2.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				if (ReleaseEditView.this.getSelectedSprintAssignedSprints() != null) {
					ReleaseEditView.this.removeEvent.fire(
							ReleaseEditView.this,
							new TypedEventArg<Sprint>(ReleaseEditView.this
									.getSelectedSprintAssignedSprints()));
				}
			}
		});
		pnlButtons.add(button2);

		final VerticalPanel pnlAvailableSprints = new VerticalPanel();
		horizontalPanel.add(pnlAvailableSprints);
		horizontalPanel.setCellHeight(pnlAvailableSprints, "100%");
		pnlAvailableSprints.setHeight("100");

		final Label lblVefgbareSprints = new Label("Vefügbare Sprints");
		lblVefgbareSprints.setStyleName("bold");
		pnlAvailableSprints.add(lblVefgbareSprints);

		final ScrollPanel scrollPanel_1 = new ScrollPanel();
		pnlAvailableSprints.add(scrollPanel_1);
		scrollPanel_1.setHeight("250px");
		pnlAvailableSprints.setCellHeight(scrollPanel_1, "250px");

		this.sprintTableAvailable = new SprintTable();
		scrollPanel_1.setWidget(this.sprintTableAvailable);
		this.sprintTableAvailable.setSize("100%", "100%");
		this.sprintTableAvailable.setSelectionModel(this.selModelAvailableSprints);

		final Button btnClose = new Button("Schließen");
		btnClose.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ReleaseEditView.this.closeEvent.fire(ReleaseEditView.this);
			}
		});
		verticalPanel.add(btnClose);
		verticalPanel.setCellHorizontalAlignment(btnClose,
				HasHorizontalAlignment.ALIGN_RIGHT);
	}

	@Override
	public void close() {
		this.assignEvent.removeAllHandler();
		this.removeEvent.removeAllHandler();
		this.closeEvent.removeAllHandler();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.IReleaseView#registerAssignEventHandler(fhdw.ipscrum.client
	 * .architecture.events.EventHandler)
	 */
	@Override
	public EventRegistration registerAssignEventHandler(
			final EventHandler<TypedEventArg<Sprint>> handler) {
		return this.assignEvent.add(handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.IReleaseView#registerRemoveEventHandler(fhdw.ipscrum.client
	 * .architecture.events.EventHandler)
	 */
	@Override
	public EventRegistration registerRemoveEventHandler(
			final EventHandler<TypedEventArg<Sprint>> handler) {
		return this.removeEvent.add(handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.IReleaseView#registerCloseEventHandler(fhdw.ipscrum.client
	 * .architecture.events.DefaultEventHandler)
	 */
	@Override
	public EventRegistration
			registerCloseEventHandler(final DefaultEventHandler handler) {
		return this.closeEvent.add(handler);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IReleaseView#getSelectedSprintAssignedSprints()
	 */
	@Override
	public Sprint getSelectedSprintAssignedSprints() {
		return this.selModelAssignedSprints.getSelectedObject();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IReleaseView#getSelectedSprintAvailableSprints()
	 */
	@Override
	public Sprint getSelectedSprintAvailableSprints() {
		return this.selModelAvailableSprints.getSelectedObject();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.IReleaseView#updateAssignedSprintTable(java.util.List)
	 */
	@Override
	public void updateAssignedSprintTable(final List<Sprint> sprints) {
		this.sprintTableAssigned.setRowData(sprints);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.IReleaseView#updateAvailableSprintsTable(java.util.List)
	 */
	@Override
	public void updateAvailableSprintsTable(final List<Sprint> sprints) {
		this.sprintTableAvailable.setRowData(sprints);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}
}
