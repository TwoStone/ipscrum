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
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITask;

public abstract class TaskDetailView extends Composite implements
		ITaskDetailView {

	// ####### Events ###############
	private final Event<EventArgs> okayEvent = new Event<EventArgs>();
	private final Event<EventArgs> cancelEvent = new Event<EventArgs>();
	private final Event<MultiplePBIArgs> addPBIsEvent = new Event<MultiplePBIArgs>();
	private final Event<MultiplePBIArgs> removePBIsEvent = new Event<MultiplePBIArgs>();
	// ##### Ende ##################

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

	public TaskDetailView() {

		AbsolutePanel concreteTaskDetailPanel = new AbsolutePanel();
		initWidget(concreteTaskDetailPanel);
		concreteTaskDetailPanel.setSize("430px", "430px");

		Label lblName = new Label("Name:");
		lblName.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		concreteTaskDetailPanel.add(lblName, 10, 10);
		lblName.setSize("41px", "16px");

		txtBoxName = new TextBox();
		concreteTaskDetailPanel.add(txtBoxName, 60, 10);
		txtBoxName.setSize("137px", "16px");

		Label lblDescription = new Label("Beschreibung");
		concreteTaskDetailPanel.add(lblDescription, 10, 40);

		txtAreaDescription = new TextArea();
		concreteTaskDetailPanel.add(txtAreaDescription, 10, 62);
		txtAreaDescription.setSize("187px", "125px");

		Label lblPerson = new Label("Person");
		concreteTaskDetailPanel.add(lblPerson, 10, 231);

		Label lblAufwand = new Label("Aufwand:");
		concreteTaskDetailPanel.add(lblAufwand, 10, 201);

		lblTaskAbgeschlossen = new Label("Task abgeschlossen:");
		concreteTaskDetailPanel.add(lblTaskAbgeschlossen, 10, 363);

		simpleCheckBox = new SimpleCheckBox();
		concreteTaskDetailPanel.add(simpleCheckBox, 146, 363);

		cellListPBI = new CellList<ProductBacklogItem>(
				new AbstractCell<ProductBacklogItem>() {
					@Override
					public void render(Context context,
							ProductBacklogItem value, SafeHtmlBuilder sb) {
						sb.appendEscaped(value.getName());
					}
				});
		cellListPBI.setStyleName("box");
		concreteTaskDetailPanel.add(cellListPBI, 226, 36);
		cellListPBI.setSize("182px", "173px");
		cellListPBI
				.setSelectionModel(new MultiSelectionModel<ProductBacklogItem>());

		lblPBIs = new Label("ProductBacklog Einträge");
		concreteTaskDetailPanel.add(lblPBIs, 226, 10);

		btnAddPBIs = new Button("Einträge hinzufügen");
		concreteTaskDetailPanel.add(btnAddPBIs, 277, 223);
		btnAddPBIs.setSize("141px", "28px");
		btnAddPBIs.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				TaskDetailView.this.addPBIsEvent.fire(TaskDetailView.this,
						new MultiplePBIArgs(getSelectedPBIs()));
			}
		});

		btnOkay = new Button("Okay");
		concreteTaskDetailPanel.add(btnOkay, 10, 392);
		btnOkay.setSize("100px", "28px");
		btnOkay.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				TaskDetailView.this.okayEvent.fire(TaskDetailView.this,
						new EventArgs());
			}
		});

		btnCancel = new Button("Abbrechen");
		concreteTaskDetailPanel.add(btnCancel, 318, 392);
		btnCancel.setSize("100px", "28px");
		btnCancel.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				TaskDetailView.this.cancelEvent.fire(TaskDetailView.this,
						new EventArgs());
			}
		});

		btnDeletePBIs = new Button("Eintraege entfernen");
		concreteTaskDetailPanel.add(btnDeletePBIs, 277, 257);
		btnDeletePBIs.setSize("142px", "28px");
		btnDeletePBIs.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				TaskDetailView.this.removePBIsEvent.fire(TaskDetailView.this,
						new MultiplePBIArgs(getSelectedPBIs()));
			}
		});

		cellListPerson = new CellList<IPerson>(new AbstractCell<IPerson>() {
			@Override
			public void render(Context context, IPerson value,
					SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getFirstname() + " "
						+ value.getLastname());
			}
		});
		cellListPerson.setStyleName("box");
		concreteTaskDetailPanel.add(cellListPerson, 10, 253);
		cellListPerson.setSize("193px", "102px");
		cellListPerson.setSelectionModel(new SingleSelectionModel<IPerson>());

		iBoxEffort = new IntegerBox();
		concreteTaskDetailPanel.add(iBoxEffort, 76, 201);
		iBoxEffort.setSize("123px", "16px");
	}

	protected Button getBtnAddPBIs() {
		return btnAddPBIs;
	}

	protected CellList<ProductBacklogItem> getCellListPBI() {
		return cellListPBI;
	}

	protected TextBox getTxtBoxName() {
		return txtBoxName;
	}

	protected Button getBtnCancel() {
		return btnCancel;
	}

	protected SimpleCheckBox getSimpleCheckBox() {
		return simpleCheckBox;
	}

	protected TextArea getTxtAreaDescription() {
		return txtAreaDescription;
	}

	protected Button getBtnOkay() {
		return btnOkay;
	}

	protected Button getBtnDeletePBI() {
		return btnDeletePBIs;
	}

	protected CellList<IPerson> getCellListPerson() {
		return cellListPerson;
	}

	protected IntegerBox getIBoxEffort() {
		return iBoxEffort;
	}

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

	private Set<ProductBacklogItem> getSelectedPBIs() {
		// TODO Auto-generated method stub
		return null;
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
	public void addAddPBIsEventHandler(EventHandler<MultiplePBIArgs> arg) {
		this.addPBIsEvent.add(arg);
	}

	@Override
	public void addRemovePBIsEventHandler(EventHandler<MultiplePBIArgs> arg) {
		this.removePBIsEvent.add(arg);
	}
	
	public Label getLblTaskAbgeschlossen() {
		return lblTaskAbgeschlossen;
	}
	public Label getLblPBIs() {
		return lblPBIs;
	}
}
