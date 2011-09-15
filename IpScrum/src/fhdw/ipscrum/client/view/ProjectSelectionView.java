package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.cell.client.ImageResourceCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.presenter.ProjectSelectionPresenter.IProjectSelectionView;
import fhdw.ipscrum.client.resources.MyResources;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * View for selecting a project.
 */
public class ProjectSelectionView extends Composite implements IProjectSelectionView {

	private final Event<TypedEventArg<Project>> gotoProjectEvent =
			new Event<TypedEventArg<Project>>();
	private SingleSelectionModel<Project> selectionModel;
	private CellTable<Project> cellTable;
	private final DefaultEvent newProjectEvent = new DefaultEvent();
	private Button newProjectButton;

	/**
	 * Creates a new {@link ProjectSelectionView} object.
	 */
	public ProjectSelectionView() {
		this.selectionModel = new SingleSelectionModel<Project>();

		this.selectionModel
				.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {

					@Override
					public void onSelectionChange(final SelectionChangeEvent event) {
						final Project selectedObject =
								ProjectSelectionView.this.selectionModel
										.getSelectedObject();
						if (selectedObject != null) {
							ProjectSelectionView.this.gotoProjectEvent.fire(
									ProjectSelectionView.this,
									new TypedEventArg<Project>(selectedObject));
						}
					}
				});

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setSpacing(10);
		this.initWidget(verticalPanel);
		verticalPanel.setSize("", "");

		final Label lblNewLabel = new Label("Bitte wählen Sie ein Projekt aus!");
		verticalPanel.add(lblNewLabel);

		this.newProjectButton = new Button("Neues Projekt erstellen");
		this.newProjectButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				ProjectSelectionView.this.newProjectEvent
						.fire(ProjectSelectionView.this);
			}
		});
		verticalPanel.add(this.newProjectButton);
		verticalPanel.setCellHorizontalAlignment(this.newProjectButton,
				HasHorizontalAlignment.ALIGN_RIGHT);

		final ScrollPanel scrollPanel = new ScrollPanel();
		verticalPanel.add(scrollPanel);
		scrollPanel.setSize("500px", "500px");

		this.cellTable = new CellTable<Project>();
		this.cellTable.setSelectionModel(this.selectionModel);
		scrollPanel.setWidget(this.cellTable);
		this.cellTable.setPageSize(0);
		this.cellTable.setSize("100%", "");

		final Column<Project, ImageResource> iconColumn =
				new Column<Project, ImageResource>(new ImageResourceCell()) {

					@Override
					public ImageResource getValue(final Project object) {
						return MyResources.INSTANCE.product();
					}
				};
		this.cellTable.addColumn(iconColumn);
		this.cellTable.setColumnWidth(iconColumn, "30%");

		final TextColumn<Project> nameColumn = new TextColumn<Project>() {
			@Override
			public String getValue(final Project object) {
				return object.getName();
			}
		};
		this.cellTable.addColumn(nameColumn);
		this.cellTable.setColumnWidth(nameColumn, "30%");

		final TextColumn<Project> ticketNumColumn = new TextColumn<Project>() {

			@Override
			public String getValue(final Project object) {
				return object.getBacklog().countItems() + " Tickets";
			}
		};
		this.cellTable.addColumn(ticketNumColumn);
		this.cellTable.setColumnWidth(ticketNumColumn, "30%");

	}

	@Override
	public void close() {

	}

	@Override
	public void setProjects(final List<Project> projects) {
		final Project selectedObject = this.selectionModel.getSelectedObject();
		this.selectionModel.setSelected(selectedObject, false);
		this.cellTable.setRowData(projects);
	}

	@Override
	public EventRegistration registerGotoProjectHandler(
			final EventHandler<TypedEventArg<Project>> handler) {
		return this.gotoProjectEvent.add(handler);
	}

	@Override
	public EventRegistration
			registerNewProjectHandler(final DefaultEventHandler handler) {
		return this.newProjectEvent.add(handler);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		this.getNewProjectButton().setEnabled(value);

	}

	protected Button getNewProjectButton() {
		return this.newProjectButton;
	}
}
