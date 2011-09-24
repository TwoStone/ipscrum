package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.viewinterfaces.ITaskCreateView;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;

/**
 * this is a simple gui for creating tasks.
 */
public class TaskCreateView extends MasterView implements ITaskCreateView {

	/**
	 * Inner class for event-argument transmission (MVC).
	 */
	public static class TaskCreateArgs extends EventArgs {

		private final String name;
		private final String description;
		private final String selectedTaskTicketType;

		/**
		 * constructor of the TaskCreateArgs.
		 * 
		 * @param name
		 *            of the task
		 * @param description
		 *            of the task
		 * @param selectedTaskTicketType
		 *            of the task
		 */
		public TaskCreateArgs(final String name, final String description, final String selectedTaskTicketType) {
			super();
			this.name = name;
			this.description = description;
			this.selectedTaskTicketType = selectedTaskTicketType;
		}

		/**
		 * getter of the name.
		 * 
		 * @return the name
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * getter of the description.
		 * 
		 * @return the description
		 */
		public String getDescription() {
			return this.description;
		}

		/**
		 * getter of the ticket type.
		 * 
		 * @return the ticket type
		 */
		public String getSelectedTaskTicketType() {
			return this.selectedTaskTicketType;
		}

	}

	private final Event<TaskCreateView.TaskCreateArgs> saveEvent = new Event<TaskCreateView.TaskCreateArgs>();
	private final DefaultEvent cancelEvent = new DefaultEvent();

	private final TextBox textBoxName;
	private final TextArea textAreaDescription;
	private final ListBox comboBoxTypes;

	/**
	 * constructor of the TaskCreateView.
	 */
	public TaskCreateView() {
		super();

		final VerticalPanel verticalPanel = new VerticalPanel();
		this.add(verticalPanel);

		final HTML htmlHeader = new HTML("<h3>Neuen Task erstellen</h3>", true);
		verticalPanel.add(htmlHeader);
		verticalPanel.setCellHorizontalAlignment(htmlHeader, HasHorizontalAlignment.ALIGN_CENTER);

		final Grid grid = new Grid(3, 4);
		grid.setCellPadding(10);
		verticalPanel.add(grid);
		verticalPanel.setCellHorizontalAlignment(grid, HasHorizontalAlignment.ALIGN_CENTER);

		final Label lblName = new Label("Bezeichnung:");
		grid.setWidget(0, 0, lblName);

		this.textBoxName = new TextBox();
		grid.setWidget(0, 3, this.textBoxName);

		final Label lblDescription = new Label("Beschreibung:");
		grid.setWidget(1, 0, lblDescription);

		this.textAreaDescription = new TextArea();
		grid.setWidget(1, 3, this.textAreaDescription);

		final Label lblTypes = new Label("Tickettyp:");
		grid.setWidget(2, 0, lblTypes);

		this.comboBoxTypes = new ListBox();
		grid.setWidget(2, 3, this.comboBoxTypes);
		this.comboBoxTypes.setWidth("100%");

		final HorizontalPanel pnlButton = new HorizontalPanel();
		pnlButton.setSpacing(5);
		verticalPanel.add(pnlButton);
		verticalPanel.setCellHorizontalAlignment(pnlButton, HasHorizontalAlignment.ALIGN_RIGHT);

		final Button btnSave = new Button("Speichern");
		btnSave.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				final TaskCreateArgs args =
						new TaskCreateArgs(TaskCreateView.this.textBoxName.getValue(),
								TaskCreateView.this.textAreaDescription.getValue(), TaskCreateView.this.comboBoxTypes
										.getValue(TaskCreateView.this.comboBoxTypes.getSelectedIndex()));
				TaskCreateView.this.saveEvent.fire(TaskCreateView.this, args);
			}
		});
		pnlButton.add(btnSave);

		final Button btnCancel = new Button("Abbrechen");
		btnCancel.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				TaskCreateView.this.cancelEvent.fire(TaskCreateView.this);

			}
		});
		pnlButton.add(btnCancel);
	}

	@Override
	public void close() {
		this.saveEvent.removeAllHandler();
		this.cancelEvent.removeAllHandler();
	}

	@Override
	public EventRegistration registerSaveEvent(final EventHandler<TaskCreateView.TaskCreateArgs> handler) {
		return this.saveEvent.add(handler);
	}

	@Override
	public EventRegistration registerCancelEvent(final DefaultEventHandler handler) {
		return this.cancelEvent.add(handler);
	}

	@Override
	public void fillComboBoxTypes(final List<TaskTicketType> list) {
		for (final TaskTicketType taskTicketType : list) {
			this.comboBoxTypes.addItem(taskTicketType.getTypeName());
		}
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}

}
