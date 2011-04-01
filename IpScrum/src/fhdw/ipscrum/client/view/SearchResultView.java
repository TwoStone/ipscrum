package fhdw.ipscrum.client.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.ActionCell.Delegate;
import com.google.gwt.cell.client.ImageCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ShowTicketEventArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.interfaces.ISearchResultView;
import fhdw.ipscrum.client.view.interfaces.IView;
import fhdw.ipscrum.shared.constants.TextConstants_FilePaths;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

/**
 * @author NW
 * 
 */
public class SearchResultView extends Composite implements ISearchResultView {
	private ListDataProvider<ProductBacklogItem> dataProvider;
	private final Event<ShowTicketEventArgs> showTicketEvent = new Event<ShowTicketEventArgs>();
	private DialogBox detailsDialog;
	private CellTable<ProductBacklogItem> cellTable;
	private Label statusLabel;

	public SearchResultView() {

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(10);
		verticalPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		initWidget(verticalPanel);

		dataProvider = new ListDataProvider<ProductBacklogItem>();
		ListHandler<ProductBacklogItem> sortHandler = new ListHandler<ProductBacklogItem>(
				dataProvider.getList());

		statusLabel = new Label();
		verticalPanel.add(statusLabel);

		cellTable = new CellTable<ProductBacklogItem>();
		verticalPanel.add(cellTable);

		cellTable.addColumnSortHandler(sortHandler);

		Column<ProductBacklogItem, String> imgColumn = new Column<ProductBacklogItem, String>(
				new ImageCell()) {

			@Override
			public String getValue(ProductBacklogItem object) {

				class ImageChooser implements IProductBacklogItemVisitor {
					String result;

					@Override
					public void handleFeature(Feature feature) {
						result = TextConstants_FilePaths.FEATURE_ICON;
					}

					@Override
					public void handleBug(Bug bug) {
						result = TextConstants_FilePaths.BUG_ICON;
					}
				}

				ImageChooser imageChooser = new ImageChooser();
				object.accept(imageChooser);

				return imageChooser.result;
			}
		};
		imgColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);

		cellTable.addColumn(imgColumn);

		TextColumn<ProductBacklogItem> nameColumn = new TextColumn<ProductBacklogItem>() {
			@Override
			public String getValue(ProductBacklogItem object) {
				return object.getName();
			}
		};
		nameColumn.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		nameColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		nameColumn.setSortable(true);
		cellTable.addColumn(nameColumn, "Bezeichnung");

		TextColumn<ProductBacklogItem> projectColumn = new TextColumn<ProductBacklogItem>() {
			@Override
			public String getValue(ProductBacklogItem object) {
				return object.getBacklog().getProject().getName();
			}
		};
		projectColumn.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		projectColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		projectColumn.setSortable(true);
		cellTable.addColumn(projectColumn, "Projekt");

		TextColumn<ProductBacklogItem> sprintColumn = new TextColumn<ProductBacklogItem>() {
			@Override
			public String getValue(ProductBacklogItem object) {
				if (object.getSprint() != null)
					return object.getSprint().getName();
				return "-";
			}
		};
		sprintColumn.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		sprintColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		sprintColumn.setSortable(true);
		cellTable.addColumn(sprintColumn, "Sprint");

		TextColumn<ProductBacklogItem> releaseColumn = new TextColumn<ProductBacklogItem>() {
			@Override
			public String getValue(ProductBacklogItem object) {
				if (object.getSprint() != null
						&& object.getSprint().getRelease() != null)
					return object.getSprint().getRelease().getVersion();
				return "-";
			}
		};
		releaseColumn.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		releaseColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		releaseColumn.setSortable(true);
		cellTable.addColumn(releaseColumn, "Release");

		sortHandler.setComparator(nameColumn,
				new Comparator<ProductBacklogItem>() {

					@Override
					public int compare(ProductBacklogItem arg0,
							ProductBacklogItem arg1) {
						return arg0.getName().compareToIgnoreCase(
								arg1.getName());
					}
				});
		sortHandler.setComparator(projectColumn,
				new Comparator<ProductBacklogItem>() {

					@Override
					public int compare(ProductBacklogItem o1,
							ProductBacklogItem o2) {

						return o1
								.getBacklog()
								.getProject()
								.getName()
								.compareToIgnoreCase(
										o2.getBacklog().getProject().getName());
					}
				});
		sortHandler.setComparator(sprintColumn,
				new Comparator<ProductBacklogItem>() {
					private String getSprintName(ProductBacklogItem item) {
						return item.getSprint() != null ? item.getSprint()
								.getName() : "";
					}

					@Override
					public int compare(ProductBacklogItem o1,
							ProductBacklogItem o2) {
						String o1Sprint = getSprintName(o1);
						String o2Sprint = getSprintName(o2);
						return o1Sprint.compareToIgnoreCase(o2Sprint);
					}
				});
		sortHandler.setComparator(releaseColumn,
				new Comparator<ProductBacklogItem>() {
					private String getReleaseName(ProductBacklogItem item) {
						return item.getSprint() != null ? item.getSprint()
								.getRelease() != null ? item.getSprint()
								.getRelease().getVersion() : "" : "";
					}

					@Override
					public int compare(ProductBacklogItem o1,
							ProductBacklogItem o2) {

						return getReleaseName(o1).compareToIgnoreCase(
								getReleaseName(o2));
					}
				});

		dataProvider.addDataDisplay(cellTable);

		ActionCell<ProductBacklogItem> actionCell = new ActionCell<ProductBacklogItem>(
				"Anzeigen", new Delegate<ProductBacklogItem>() {

					@Override
					public void execute(ProductBacklogItem object) {
						showTicketEvent.fire(SearchResultView.this,
								new ShowTicketEventArgs(object));
					}
				});

		Column<ProductBacklogItem, ProductBacklogItem> showColumn = new Column<ProductBacklogItem, ProductBacklogItem>(
				actionCell) {

			@Override
			public ProductBacklogItem getValue(ProductBacklogItem object) {
				return object;
			}
		};
		showColumn.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		showColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		cellTable.addColumn(showColumn);

		detailsDialog = GwtUtils.createDialog("Details");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.interfaces.ISearchResultView#setSearchResult
	 * (java.util.Collection)
	 */
	@Override
	public void setSearchResult(Collection<ProductBacklogItem> results) {
		if (results.isEmpty()) {
			this.cellTable.setVisible(false);
			this.statusLabel
					.setText("Leider keine passenden Tickets gefunden.");
		} else {
			this.cellTable.setVisible(true);
			this.statusLabel.setText(results.size() + " Tickets gefunden.");
		}
		dataProvider.setList(new ArrayList<ProductBacklogItem>(results));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.interfaces.ISearchResultView#registerShowTicket
	 * (fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void registerShowTicket(EventHandler<ShowTicketEventArgs> handler) {
		showTicketEvent.add(handler);
	}

	@Override
	public void displayDetails(IView view) {
		detailsDialog.clear();
		detailsDialog.add(view);
		detailsDialog.center();
	}

	@Override
	public void hideDetails() {
		detailsDialog.hide();
	}

}
