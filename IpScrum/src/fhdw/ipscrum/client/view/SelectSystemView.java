package fhdw.ipscrum.client.view;

import java.util.Collection;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasTreeItems;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.eventargs.SystemArgs;
import fhdw.ipscrum.client.presenter.ProjectSelectSystemPresenter.ISelectSystemView;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.nonMeta.System;

/**
 * view class for systems. this view is used to select systems of an amount of available
 * systems.
 */
public class SelectSystemView extends Composite implements ISelectSystemView {

	private ListDataProvider<System> systemDataProvider;
	private SingleSelectionModel<System> systemSelectionModel;
	private Tree tree;
	private final Event<SystemArgs> removeSelectedSystem = new Event<SystemArgs>();
	private final Event<SystemArgs> addSelectedSystem = new Event<SystemArgs>();
	private final Event<EventArgs> save = new Event<EventArgs>();
	private final Event<EventArgs> abort = new Event<EventArgs>();
	private final Button btnOk;
	private final Button btnAbbrechen;
	private Button btnAddSystem;
	private Button btnRemoveSystem;

	/**
	 * constructor of the SelectSystemView.
	 */
	public SelectSystemView() {

		this.systemDataProvider = new ListDataProvider<System>();
		this.systemSelectionModel =
				new SingleSelectionModel<System>(this.systemDataProvider);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		this.initWidget(horizontalPanel);

		final VerticalPanel verticalPanelAusgewaehlteSysteme = new VerticalPanel();
		horizontalPanel.add(verticalPanelAusgewaehlteSysteme);

		final Label lblAusgewaehlteSysteme = new Label("Ausgewählte Systeme");
		verticalPanelAusgewaehlteSysteme.add(lblAusgewaehlteSysteme);

		final ScrollPanel scrollPanel = new ScrollPanel();
		verticalPanelAusgewaehlteSysteme.add(scrollPanel);
		scrollPanel.setStyleName("tableBorder");
		scrollPanel.setSize("250px", "425px");

		final CellTable<System> cellTableAusgewaehlteSysteme = new CellTable<System>();
		this.systemDataProvider.addDataDisplay(cellTableAusgewaehlteSysteme);
		scrollPanel.setWidget(cellTableAusgewaehlteSysteme);
		cellTableAusgewaehlteSysteme.setSize("100%", "100%");
		cellTableAusgewaehlteSysteme.setSelectionModel(this.systemSelectionModel);

		final TextColumn<System> colSystemName = new TextColumn<System>() {
			@Override
			public String getValue(final System object) {
				return object.getName();
			}
		};
		cellTableAusgewaehlteSysteme.addColumn(colSystemName, "Systemname");

		final VerticalPanel verticalPanelAllocationButtons = new VerticalPanel();
		verticalPanelAllocationButtons.setStyleName("allocationButtonPanel");
		horizontalPanel.add(verticalPanelAllocationButtons);

		this.btnRemoveSystem = new Button(TextConstants.BUTTONLABEL_REMOVE);
		this.btnRemoveSystem.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				if (SelectSystemView.this.getSelectedOfSelectedSystems() != null) {
					SelectSystemView.this.removeSelectedSystem.fire(
							SelectSystemView.this,
							new SystemArgs(SelectSystemView.this
									.getSelectedOfSelectedSystems()));
				}
			}
		});

		this.btnAddSystem = new Button(TextConstants.BUTTONLABEL_ASSIGN);
		this.btnAddSystem.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				if (SelectSystemView.this.getSelectedOfAvailableSystems() != null) {
					SelectSystemView.this.addSelectedSystem.fire(
							SelectSystemView.this,
							new SystemArgs(SelectSystemView.this
									.getSelectedOfAvailableSystems()));
				} else {
					Window.alert(ExceptionConstants.GUI_SYSTEMVIEW_ASSIGNERROR);
				}
			}
		});
		verticalPanelAllocationButtons.add(this.btnAddSystem);
		verticalPanelAllocationButtons.add(this.btnRemoveSystem);

		final VerticalPanel verticalPanelVerfuegbareSysteme = new VerticalPanel();
		horizontalPanel.add(verticalPanelVerfuegbareSysteme);

		final Label lblVerfgbareSysteme = new Label("Verfügbare Systeme");
		verticalPanelVerfuegbareSysteme.add(lblVerfgbareSysteme);

		final ScrollPanel scrollPanelSystemTree = new ScrollPanel();
		verticalPanelVerfuegbareSysteme.add(scrollPanelSystemTree);
		scrollPanelSystemTree.setStyleName("tableBorder");
		scrollPanelSystemTree.setSize("350px", "425px");

		this.tree = new Tree();
		scrollPanelSystemTree.setWidget(this.tree);
		this.tree.setAnimationEnabled(true);
		this.tree.setSize("100%", "100%");

		final HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanelVerfuegbareSysteme.add(horizontalPanel_1);

		this.btnOk = new Button("OK");
		this.btnOk.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				SelectSystemView.this.save.fire(SelectSystemView.this, new EventArgs());
			}
		});
		horizontalPanel_1.add(this.btnOk);
		this.btnOk.setSize("100px", "28px");

		this.btnAbbrechen = new Button("Abbrechen");
		this.btnAbbrechen.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				SelectSystemView.this.abort
						.fire(SelectSystemView.this, new EventArgs());
			}
		});
		horizontalPanel_1.add(this.btnAbbrechen);
		this.btnAbbrechen.setSize("100px", "28px");
	}

	@Override
	public System getSelectedOfAvailableSystems() {
		if (this.tree.getSelectedItem() != null) {
			final Object selItem = this.tree.getSelectedItem().getUserObject();
			if (selItem instanceof System) {
				return (System) selItem;
			}
		}
		return null;
	}

	@Override
	public System getSelectedOfSelectedSystems() {
		return this.systemSelectionModel.getSelectedObject();
	}

	@Override
	public void updateSelectedSystemData(final Collection<System> selectedSystems) {
		this.systemDataProvider.getList().clear();
		this.systemDataProvider.getList().addAll(selectedSystems);
	}

	@Override
	public void updateAvailableSystemData(final Collection<System> availableSystems,
			final Collection<System> selectedSystems) {
		this.tree.clear();
		for (final System system : availableSystems) {
			this.buildTree(system, this.tree, selectedSystems);
		}
	}

	private void buildTree(final System system, final HasTreeItems parent,
			final Collection<System> selectedSystems) {
		if (!this.isSelectedSystem(system, selectedSystems)) {
			final TreeItem item = new TreeItem();
			item.setUserObject(system);
			item.setText(system.getName());
			parent.addItem(item);
			for (final System system2 : system.getSystems()) {
				this.buildTree(system2, item, selectedSystems);
			}
		}
	}

	/**
	 * checks if a system is selected.
	 * 
	 * @param system
	 *            to check
	 * @param selectedSystems
	 *            are the selected systems
	 * @return true id the system is selected
	 */
	private boolean isSelectedSystem(final System system,
			final Collection<System> selectedSystems) {
		if (selectedSystems.contains(system)) {
			return true;
		}
		for (final System system2 : selectedSystems) {
			if (system2.containsAction(system)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void close() {
		this.save.removeAllHandler();
		this.abort.removeAllHandler();
		this.addSelectedSystem.removeAllHandler();
		this.removeSelectedSystem.removeAllHandler();
	}

	@Override
	public EventRegistration registerAbortHandler(final DefaultEventHandler handler) {
		return this.abort.add(handler);
	}

	@Override
	public EventRegistration registerSaveHandler(final DefaultEventHandler handler) {
		return this.save.add(handler);
	}

	@Override
	public EventRegistration removeRemoveSelectedSystemHandler(
			final EventHandler<SystemArgs> handler) {
		return this.removeSelectedSystem.add(handler);
	}

	@Override
	public EventRegistration registerAddSelectedSystemHandler(
			final EventHandler<SystemArgs> handler) {
		return this.addSelectedSystem.add(handler);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		this.getBtnAddSystem().setEnabled(value);
		this.getBtnRemoveSystem().setEnabled(value);
	}

	protected Button getBtnAddSystem() {
		return this.btnAddSystem;
	}

	protected Button getBtnRemoveSystem() {
		return this.btnRemoveSystem;
	}
}
