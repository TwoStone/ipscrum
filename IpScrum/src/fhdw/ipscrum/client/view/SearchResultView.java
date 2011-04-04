package fhdw.ipscrum.client.view;

import java.util.Collection;
import java.util.Comparator;

import com.google.gwt.cell.client.ActionCell;
import com.google.gwt.cell.client.ActionCell.Delegate;
import com.google.gwt.cell.client.ImageResourceCell;
import com.google.gwt.resources.client.ImageResource;
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
import fhdw.ipscrum.client.resources.MyResources;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.interfaces.ISearchResultView;
import fhdw.ipscrum.client.view.interfaces.IView;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.PBIClosedState;
import fhdw.ipscrum.shared.model.PBIOpenState;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.interfaces.IProductBacklogItemState;
import fhdw.ipscrum.shared.model.visitor.IPBIStateVisitor;
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
	private ListHandler<ProductBacklogItem> sortHandler;

	public SearchResultView() {

		final VerticalPanel verticalPanel = new VerticalPanel();

		verticalPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setWidth("100%");
		this.initWidget(verticalPanel);

		this.dataProvider = new ListDataProvider<ProductBacklogItem>();
		this.sortHandler = new ListHandler<ProductBacklogItem>(
				this.dataProvider.getList());

		this.statusLabel = new Label();
		verticalPanel.add(this.statusLabel);

		this.cellTable = new CellTable<ProductBacklogItem>();
		verticalPanel.add(this.cellTable);
		this.cellTable.setWidth("100%");

		this.cellTable.addColumnSortHandler(this.sortHandler);

		final Column<ProductBacklogItem, ImageResource> imgColumn = new Column<ProductBacklogItem, ImageResource>(
				new ImageResourceCell()) {

			@Override
			public ImageResource getValue(ProductBacklogItem object) {

				class ImageChooser implements IProductBacklogItemVisitor {
					ImageResource result;

					@Override
					public void handleFeature(Feature feature) {
						this.result = MyResources.INSTANCE.featureIcon();
					}

					@Override
					public void handleBug(Bug bug) {
						this.result = MyResources.INSTANCE.bugIcon();
					}
				}

				final ImageChooser imageChooser = new ImageChooser();
				object.accept(imageChooser);

				return imageChooser.result;
			}

		};
		imgColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		imgColumn.setSortable(true);
		this.cellTable.addColumn(imgColumn, "Typ");

		final TextColumn<ProductBacklogItem> nameColumn = new TextColumn<ProductBacklogItem>() {
			@Override
			public String getValue(ProductBacklogItem object) {
				return object.getName();
			}
		};
		nameColumn.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		nameColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		nameColumn.setSortable(true);
		this.cellTable.addColumn(nameColumn, "Bezeichnung");

		final TextColumn<ProductBacklogItem> projectColumn = new TextColumn<ProductBacklogItem>() {
			@Override
			public String getValue(ProductBacklogItem object) {
				return object.getBacklog().getProject().getName();
			}
		};
		final Column<ProductBacklogItem, ImageResource> stateColumn = new Column<ProductBacklogItem, ImageResource>(
				new ImageResourceCell()) {

			@Override
			public ImageResource getValue(ProductBacklogItem object) {
				class StateIconChooser implements IPBIStateVisitor {
					ImageResource result;

					@Override
					public void handleClosed(PBIClosedState closed) {
						this.result = MyResources.INSTANCE.lockIcon();
					}

					@Override
					public void handleOpen(PBIOpenState open) {
						this.result = MyResources.INSTANCE.unlockIcon();
					}

				}
				final StateIconChooser chooser = new StateIconChooser();
				object.getState().accept(chooser);
				return chooser.result;
			}
		};
		stateColumn.setSortable(true);
		this.cellTable.addColumn(stateColumn, "Status");

		projectColumn.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		projectColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		projectColumn.setSortable(true);
		this.cellTable.addColumn(projectColumn, "Projekt");

		final TextColumn<ProductBacklogItem> sprintColumn = new TextColumn<ProductBacklogItem>() {
			@Override
			public String getValue(ProductBacklogItem object) {
				if (object.getSprint() != null) {
					return object.getSprint().getName();
				}
				return "-";
			}
		};
		sprintColumn.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		sprintColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		sprintColumn.setSortable(true);
		this.cellTable.addColumn(sprintColumn, "Sprint");

		final TextColumn<ProductBacklogItem> releaseColumn = new TextColumn<ProductBacklogItem>() {
			@Override
			public String getValue(ProductBacklogItem object) {
				if (object.getSprint() != null
						&& object.getSprint().getRelease() != null) {
					return object.getSprint().getRelease().getVersion();
				}
				return "-";
			}
		};
		releaseColumn.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		releaseColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_LEFT);
		releaseColumn.setSortable(true);
		this.cellTable.addColumn(releaseColumn, "Release");

		this.sortHandler.setComparator(nameColumn,
				new Comparator<ProductBacklogItem>() {

					@Override
					public int compare(ProductBacklogItem arg0,
							ProductBacklogItem arg1) {
						return arg0.getName().compareToIgnoreCase(
								arg1.getName());
					}
				});
		this.sortHandler.setComparator(projectColumn,
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
		this.sortHandler.setComparator(sprintColumn,
				new Comparator<ProductBacklogItem>() {
					private String getSprintName(ProductBacklogItem item) {
						return item.getSprint() != null ? item.getSprint()
								.getName() : "";
					}

					@Override
					public int compare(ProductBacklogItem o1,
							ProductBacklogItem o2) {
						final String o1Sprint = this.getSprintName(o1);
						final String o2Sprint = this.getSprintName(o2);
						return o1Sprint.compareToIgnoreCase(o2Sprint);
					}
				});
		this.sortHandler.setComparator(releaseColumn,
				new Comparator<ProductBacklogItem>() {
					private String getReleaseName(ProductBacklogItem item) {
						return item.getSprint() != null ? item.getSprint()
								.getRelease() != null ? item.getSprint()
								.getRelease().getVersion() : "" : "";
					}

					@Override
					public int compare(ProductBacklogItem o1,
							ProductBacklogItem o2) {

						return this.getReleaseName(o1).compareToIgnoreCase(
								this.getReleaseName(o2));
					}
				});

		this.sortHandler.setComparator(stateColumn,
				new Comparator<ProductBacklogItem>() {

					@Override
					public int compare(ProductBacklogItem o1,
							ProductBacklogItem o2) {
						class StateComparator implements
								Comparator<IProductBacklogItemState> {

							@Override
							public int compare(IProductBacklogItemState o1,
									IProductBacklogItemState o2) {
								class StateTypeVisitor implements
										IPBIStateVisitor {
									Boolean isOpen;

									@Override
									public void handleClosed(
											PBIClosedState closed) {
										this.isOpen = false;
									}

									@Override
									public void handleOpen(PBIOpenState open) {
										this.isOpen = true;
									}

								}
								final StateTypeVisitor o1State = new StateTypeVisitor();
								o1.accept(o1State);
								final StateTypeVisitor o2State = new StateTypeVisitor();
								o2.accept(o2State);

								if (o1State.isOpen && !o2State.isOpen) {
									return 1;
								}
								if (!o1State.isOpen && o2State.isOpen) {
									return -1;
								}
								return 0;
							}

						}
						final StateComparator comp = new StateComparator();

						return comp.compare(o1.getState(), o2.getState());
					}
				});

		this.sortHandler.setComparator(imgColumn,
				new Comparator<ProductBacklogItem>() {

					@Override
					public int compare(ProductBacklogItem o1,
							ProductBacklogItem o2) {
						class PBITypeChecker implements
								IProductBacklogItemVisitor {

							public PBITypeChecker(ProductBacklogItem pbi) {
								super();
								pbi.accept(this);
							}

							Boolean isFeature = false;
							Boolean isBug = false;

							@Override
							public void handleBug(Bug bug) {
								this.isBug = true;
							}

							@Override
							public void handleFeature(Feature feature) {
								this.isFeature = true;
							}

						}
						final PBITypeChecker o1Type = new PBITypeChecker(o1);
						final PBITypeChecker o2Type = new PBITypeChecker(o2);

						if (o1Type.isFeature && o2Type.isBug) {
							return 1;
						}
						if (o1Type.isBug && o2Type.isFeature) {
							return -1;
						}

						return 0;
					}
				});

		this.dataProvider.addDataDisplay(this.cellTable);

		final ActionCell<ProductBacklogItem> actionCell = new ActionCell<ProductBacklogItem>(
				"Anzeigen", new Delegate<ProductBacklogItem>() {

					@Override
					public void execute(ProductBacklogItem object) {
						SearchResultView.this.showTicketEvent.fire(
								SearchResultView.this, new ShowTicketEventArgs(
										object));
					}
				});

		final Column<ProductBacklogItem, ProductBacklogItem> showColumn = new Column<ProductBacklogItem, ProductBacklogItem>(
				actionCell) {

			@Override
			public ProductBacklogItem getValue(ProductBacklogItem object) {
				return object;
			}
		};
		showColumn.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		showColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.cellTable.addColumn(showColumn);

		this.detailsDialog = GwtUtils.createDialog("Details");
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
		this.dataProvider.getList().clear();
		this.dataProvider.getList().addAll(results);
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
		this.showTicketEvent.add(handler);
	}

	@Override
	public void displayDetails(IView view) {
		this.detailsDialog.clear();
		this.detailsDialog.add(view);
		this.detailsDialog.center();
	}

	@Override
	public void hideDetails() {
		this.detailsDialog.hide();
	}

}
