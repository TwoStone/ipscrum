package fhdw.ipscrum.client.view;

import java.util.ArrayList;
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
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.events.args.SystemArgs;
import fhdw.ipscrum.client.view.interfaces.ISelectSystemView;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.System;

/**
 * view class for systems. this view is used to select systems of an amount of
 * available systems.
 */
public class SelectSystemView extends Composite implements ISelectSystemView {

	private CellTable<System> cellTableAusgewaehlteSysteme;
	private Tree tree;
	private final Event<SystemArgs> removeSelectedSystem = new Event<SystemArgs>();
	private final Event<SystemArgs> addSelectedSystem = new Event<SystemArgs>();
	private final Event<EventArgs> save = new Event<EventArgs>();
	private final Event<EventArgs> abort = new Event<EventArgs>();
	private MultiSelectionModel<System> selModelSystemTable;
	private final Button btnOk;
	private final Button btnAbbrechen;

	public SelectSystemView() {

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

		this.cellTableAusgewaehlteSysteme = new CellTable<System>();
		scrollPanel.setWidget(this.cellTableAusgewaehlteSysteme);
		this.cellTableAusgewaehlteSysteme.setSize("100%", "100%");
		this.cellTableAusgewaehlteSysteme
				.setSelectionModel(new SingleSelectionModel<System>());

		final TextColumn<System> colSystemName = new TextColumn<System>() {
			@Override
			public String getValue(final System object) {
				return object.getName();
			}
		};
		this.cellTableAusgewaehlteSysteme
				.addColumn(colSystemName, "Systemname");

		final VerticalPanel verticalPanelAllocationButtons = new VerticalPanel();
		verticalPanelAllocationButtons.setStyleName("allocationButtonPanel");
		horizontalPanel.add(verticalPanelAllocationButtons);

		final Button btnRemoveSystem = new Button(
				TextConstants.BUTTONLABEL_REMOVE);
		btnRemoveSystem.addClickHandler(new ClickHandler() {
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

		final Button btnAddSystem = new Button(TextConstants.BUTTONLABEL_ASSIGN);
		btnAddSystem.addClickHandler(new ClickHandler() {
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
		verticalPanelAllocationButtons.add(btnAddSystem);
		verticalPanelAllocationButtons.add(btnRemoveSystem);

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
		horizontalPanel_1
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanelVerfuegbareSysteme.add(horizontalPanel_1);

		this.btnOk = new Button("OK");
		this.btnOk.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				SelectSystemView.this.save.fire(SelectSystemView.this,
						new EventArgs());
			}
		});
		horizontalPanel_1.add(this.btnOk);
		this.btnOk.setSize("100px", "28px");

		this.btnAbbrechen = new Button("Abbrechen");
		this.btnAbbrechen.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				SelectSystemView.this.abort.fire(SelectSystemView.this,
						new EventArgs());
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
		@SuppressWarnings("unchecked")
		final// TODO Christin: geht das nicht schöner?
		SingleSelectionModel<System> selSysModel = (SingleSelectionModel<System>) this.cellTableAusgewaehlteSysteme
				.getSelectionModel();
		final System selectedSystem = selSysModel.getSelectedObject();
		return selectedSystem;
	}

	@Override
	public IEvent<EventArgs> getAborted() {
		return this.abort;
	}

	@Override
	public IEvent<EventArgs> getSave() {
		return this.save;
	}

	@Override
	public void updateSelectedSystemData(
			final Collection<System> selectedSystems) {
		this.cellTableAusgewaehlteSysteme.setRowData(new ArrayList<System>(
				selectedSystems));
	}

	@Override
	public void updateAvailableSystemData(
			final Collection<System> availableSystems,
			final Collection<System> selectedSystems) {
		this.tree.clear();
		final Collection<System> displayedSystems = new ArrayList<System>();
		for (final System system : availableSystems) {
			this.buildTree(system, this.tree, selectedSystems);
			// if (!this.isSelectedSystem(system, selectedSystems)) {
			//
			// }
		}
		// this.fillTree(availableSystems, null);
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

	private void fillTree(final Collection<System> systems,
			final TreeItem parent) {
		for (final System system : systems) {
			final TreeItem tItem = new TreeItem(system.toString());
			tItem.setUserObject(system);
			if (parent == null) {
				this.tree.addItem(tItem);
			} else {
				parent.addItem(tItem);
			}
			tItem.setState(true);

			this.fillTree(system.getSystems(), tItem);
		}
	}

	@Override
	public void defineRemoveSelectedSystemEvent(
			final EventHandler<SystemArgs> args) {
		this.removeSelectedSystem.add(args);
	}

	@Override
	public void defineAddSelectedSystemEvent(final EventHandler<SystemArgs> args) {
		this.addSelectedSystem.add(args);
	}
}
