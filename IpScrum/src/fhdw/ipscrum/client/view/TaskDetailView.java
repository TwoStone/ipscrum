package fhdw.ipscrum.client.view;

import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimpleCheckBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.MultiplePBIArgs;
import fhdw.ipscrum.client.view.interfaces.ITaskDetailView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Task;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITask;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * This class is used to represent generally details of {@link Task}
 * 
 * @author Phase III / Group I
 * 
 *         This is an abstract class who creates every view-element which is
 *         needed to show {@link Task} details. Independent by the state of the
 *         task. Template-Method pattern is used to specify the specialization
 *         view-classes
 */
public abstract class TaskDetailView extends Composite implements
		ITaskDetailView {

	// ####### Events ###############
	private final Event<EventArgs> okayEvent = new Event<EventArgs>();
	private final Event<EventArgs> cancelEvent = new Event<EventArgs>();
	private final Event<EventArgs> addPBIsEvent = new Event<EventArgs>();
	private final Event<MultiplePBIArgs> removePBIsEvent = new Event<MultiplePBIArgs>();
	// ##### Ende ##################

	// ########### View Elements ##########
	private Button btnAddPBIs;
	private CellList<ProductBacklogItem> cellListPBI;
	private TextBox txtBoxName;
	private Button btnCancel;
	private SimpleCheckBox simpleCheckBox;
	private TextArea txtAreaDescription;
	private Button btnOkay;
	private Button btnDeletePBIs;
	private CellList<IPerson> cellListPerson;
	private IntegerBox iBoxEffort;
	private Label lblTaskAbgeschlossen;
	private Label lblPBIs;
	private Label lblTaskFinished;

	// ########## Ende ###################

	public TaskDetailView() {

		// Creates concrete TaskDetailPanel
		AbsolutePanel concreteTaskDetailPanel = new AbsolutePanel();
		initWidget(concreteTaskDetailPanel);
		concreteTaskDetailPanel.setSize("430px", "482px");

		// Creates label for the name
		Label lblName = new Label(TextConstants.NAME);
		lblName.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		concreteTaskDetailPanel.add(lblName, 10, 10);
		lblName.setSize("41px", "16px");

		// Creates textBo for the name
		txtBoxName = new TextBox();
		concreteTaskDetailPanel.add(txtBoxName, 60, 10);
		txtBoxName.setSize("137px", "16px");

		// Creates label for the description
		Label lblDescription = new Label(TextConstants.DESCRIPTION);
		concreteTaskDetailPanel.add(lblDescription, 10, 50);

		// Creates a text area for the description
		txtAreaDescription = new TextArea();
		concreteTaskDetailPanel.add(txtAreaDescription, 10, 70);
		txtAreaDescription.setSize("187px", "125px");

		// creates a label for the person
		Label lblPerson = new Label(TextConstants.ASSIGNED_PERSON);
		concreteTaskDetailPanel.add(lblPerson, 10, 287);

		// creates a label for the effort
		Label lblAufwand = new Label(TextConstants.EFFORT);
		concreteTaskDetailPanel.add(lblAufwand, 10, 226);

		// creates a label for task finish
		lblTaskAbgeschlossen = new Label(TextConstants.TASK_FINISHED);
		concreteTaskDetailPanel.add(lblTaskAbgeschlossen, 226, 365);

		// creates a checkbox to finish a task
		simpleCheckBox = new SimpleCheckBox();
		concreteTaskDetailPanel.add(simpleCheckBox, 366, 365);

		// create label for pbis
		lblPBIs = new Label(TextConstants.PBIS);
		concreteTaskDetailPanel.add(lblPBIs, 226, 10);

		// create button for add pbis
		btnAddPBIs = new Button(TextConstants.NEW_ITEMS);
		concreteTaskDetailPanel.add(btnAddPBIs, 265, 273);
		btnAddPBIs.setSize("141px", "28px");
		btnAddPBIs.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// fire addPBIsEvent
				TaskDetailView.this.addPBIsEvent.fire(TaskDetailView.this,
						new MultiplePBIArgs(getSelectedPBIs()));
			}
		});
		// create button okay
		btnOkay = new Button(TextConstants.OKAY);
		concreteTaskDetailPanel.add(btnOkay, 10, 446);
		btnOkay.setSize("100px", "28px");
		btnOkay.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// fire okayEvent
				TaskDetailView.this.okayEvent.fire(TaskDetailView.this,
						new EventArgs());
			}
		});

		// create button for cancel
		btnCancel = new Button(TextConstants.DIALOGBOX_CANCEL);
		concreteTaskDetailPanel.add(btnCancel, 320, 446);
		btnCancel.setSize("100px", "28px");
		btnCancel.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// fire cancelEvent
				TaskDetailView.this.cancelEvent.fire(TaskDetailView.this,
						new EventArgs());
			}
		});

		// create button delete pbis
		btnDeletePBIs = new Button(TextConstants.DELETE_ITEMS);
		concreteTaskDetailPanel.add(btnDeletePBIs, 265, 308);
		btnDeletePBIs.setSize("142px", "28px");
		btnDeletePBIs.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// fire removePBIsEvent
				TaskDetailView.this.removePBIsEvent.fire(TaskDetailView.this,
						new MultiplePBIArgs(getSelectedPBIs()));
			}
		});

		// creates integerBox for effort
		iBoxEffort = new IntegerBox();
		concreteTaskDetailPanel.add(iBoxEffort, 10, 248);
		iBoxEffort.setSize("123px", "16px");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setStyleName("smallborder");
		concreteTaskDetailPanel.add(verticalPanel, 10, 311);
		verticalPanel.setSize("171px", "129px");
		
				// creates a cell list for all persons of the sprint of the task
				// with single selection modell
				cellListPerson = new CellList<IPerson>(new AbstractCell<IPerson>() {
					@Override
					public void render(Context context, IPerson value,
							SafeHtmlBuilder sb) {
						sb.appendEscaped(value.getFirstname() + " "
								+ value.getLastname());
					}
				});
				verticalPanel.add(cellListPerson);
				cellListPerson.setSize("100%", "100%");
				cellListPerson.setSelectionModel(new SingleSelectionModel<IPerson>());
				
				VerticalPanel verticalPanel_1 = new VerticalPanel();
				verticalPanel_1.setStyleName("smallborder");
				concreteTaskDetailPanel.add(verticalPanel_1, 226, 30);
				verticalPanel_1.setSize("180px", "237px");
				
						// creates a cell list for all related pbis
						// with multiselectionmodel
						cellListPBI = new CellList<ProductBacklogItem>(
								new AbstractCell<ProductBacklogItem>() {
									@Override
									public void render(Context context,
											ProductBacklogItem value, SafeHtmlBuilder sb) {
										sb.appendEscaped(value.getName());
									}
								});
						verticalPanel_1.add(cellListPBI);
						cellListPBI.setSize("100%", "100%");
						cellListPBI
								.setSelectionModel(new MultiSelectionModel<ProductBacklogItem>());
						
						lblTaskFinished = new Label(TextConstants.FINISHED_TASK);
						lblTaskFinished.setStyleName("LabelElement");
						lblTaskFinished.setVisible(false);
						concreteTaskDetailPanel.add(lblTaskFinished, 226, 399);
	}

	// ################## SETTER / GETTER for view elements
	// #############################
	// proteced cause only use in view classes

	/**
	 * @return the Button for adding PBIs
	 */
	protected Button getBtnAddPBIs() {
		return btnAddPBIs;
	}

	/**
	 * @return the CellList with all related PBIs
	 */
	protected CellList<ProductBacklogItem> getCellListPBI() {
		return cellListPBI;
	}

	/**
	 * @return the TextBox for the tasks name
	 */
	protected TextBox getTxtBoxName() {
		return txtBoxName;
	}

	/**
	 * @return the button for canceling
	 */
	protected Button getBtnCancel() {
		return btnCancel;
	}

	/**
	 * @return checkbox to finish a task
	 */
	protected SimpleCheckBox getSimpleCheckBox() {
		return simpleCheckBox;
	}

	/**
	 * @return textarea for description
	 */
	protected TextArea getTxtAreaDescription() {
		return txtAreaDescription;
	}

	/**
	 * @return button to save the task details
	 */
	protected Button getBtnOkay() {
		return btnOkay;
	}

	/**
	 * @return button to remove a selected pbi
	 */
	protected Button getBtnDeletePBI() {
		return btnDeletePBIs;
	}

	/**
	 * @return the CellList for all persons of sprint of the task
	 */
	protected CellList<IPerson> getCellListPerson() {
		return cellListPerson;
	}

	/**
	 * @return the IntegerBox for the effort
	 */
	protected IntegerBox getIBoxEffort() {
		return iBoxEffort;
	}

	/**
	 * @return the label for text of task finish
	 */
	protected Label getLblTaskAbgeschlossen() {
		return lblTaskAbgeschlossen;
	}

	/**
	 * @return the label for text PBIs
	 */
	protected Label getLblPBIs() {
		return lblPBIs;
	}
	
	/**
	 * 
	 * @return Label for for a 'Task is finished' text
	 */
	protected Label getLblTaskFinished() {
		return lblTaskFinished;
	}

	@SuppressWarnings("unchecked")
	protected Set<ProductBacklogItem> getSelectedPBIs() {
	return ((MultiSelectionModel<ProductBacklogItem>)this.getCellListPBI().getSelectionModel()).getSelectedSet();
	}

	// ################## Ende #############################

	// ######################## THIS METHODS ARE USED BY THE PRESENTATORS	// #####################
	@Override
	public String getName() {
		return this.getTxtBoxName().getValue();
	}

	@Override
	public String getDescription() {
		return this.getTxtAreaDescription().getValue();
	}

	@SuppressWarnings("unchecked")
	@Override
	public IPerson getPerson() {
		return ((SingleSelectionModel<IPerson>) this.getCellListPerson()
				.getSelectionModel()).getSelectedObject();
	}

	@Override
	public Integer getEffort() {
		return this.getIBoxEffort().getValue();
	}

	@Override
	public Boolean isFinished() {
		return this.getSimpleCheckBox().getValue();
	}

	@Override
	public void refreshPBIs(Vector<ProductBacklogItem> pbis) {
		this.getCellListPBI().setRowData(pbis);
		this.getCellListPBI().setSelectionModel(new MultiSelectionModel<ProductBacklogItem>());
	}

	@Override
	public void refreshPersons(Vector<IPerson> persons) {
		this.getCellListPerson().setRowData(persons);
	}

	@Override
	public void setName(String name) {
		this.getTxtBoxName().setValue(name);
	}

	@Override
	public void setDescription(String description) {
		this.getTxtAreaDescription().setValue(description);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setPerson(IPerson person) {
		((SingleSelectionModel<IPerson>) this.getCellListPerson()
				.getSelectionModel()).setSelected(person, true);
	}

	@Override
	public void setEffort(Integer effort) {
		this.getIBoxEffort().setValue(effort);
	}

	@Override
	public void setFinished(Boolean finish) {
		this.getSimpleCheckBox().setValue(finish);
	}

	@Override
	public void initTaskView(ITask task) {
		this.setName(task.getName());
		this.setDescription(task.getDescription());
		Iterator<ProductBacklogItem> pbiIt = task.getPBIIterator();

		this.setEffort(task.getPlanEffort());

		Vector<ProductBacklogItem> pbis = new Vector<ProductBacklogItem>();

		while (pbiIt.hasNext()) {
			pbis.add(pbiIt.next());
		}
		this.refreshPBIs(pbis);
		this.initSpecificTaskView(task);
	}

	@Override
	public void addOkayEventHandler(EventHandler<EventArgs> arg) {
		this.okayEvent.add(arg);
	}

	@Override
	public void addCancelEventHandler(EventHandler<EventArgs> arg) {
		this.cancelEvent.add(arg);
	}

	@Override
	public void addAddPBIsEventHandler(EventHandler<EventArgs> arg) {
		this.addPBIsEvent.add(arg);
	}

	@Override
	public void addRemovePBIsEventHandler(EventHandler<MultiplePBIArgs> arg) {
		this.removePBIsEvent.add(arg);
	}
	
}
