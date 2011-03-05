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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.MultiSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SystemArgs;
import fhdw.ipscrum.client.view.interfaces.ISelectSystemView;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

/**
 * view class for systems. this view is used to select systems of an amount of available systems.
 */
public class SelectSystemView extends Composite implements ISelectSystemView {

	private CellTable<System> cellTableAusgewaehlteSysteme;
	private Tree tree;
	private final Event<SystemArgs> removeSelectedSystem = new Event<SystemArgs>();
	private final Event<SystemArgs> addSelectedSystem = new Event<SystemArgs>();
	private MultiSelectionModel<System> selModelSystemTable;

	public SelectSystemView() {

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		initWidget(horizontalPanel);

		VerticalPanel verticalPanelAusgewaehlteSysteme = new VerticalPanel();
		horizontalPanel.add(verticalPanelAusgewaehlteSysteme);

		Label lblAusgewaehlteSysteme = new Label("Ausgewählte Systeme");
		verticalPanelAusgewaehlteSysteme.add(lblAusgewaehlteSysteme);

		ScrollPanel scrollPanel = new ScrollPanel();
		verticalPanelAusgewaehlteSysteme.add(scrollPanel);
		scrollPanel.setStyleName("tableBorder");
		scrollPanel.setSize("250px", "425px");

		this.cellTableAusgewaehlteSysteme = new CellTable<System>();
		scrollPanel.setWidget(this.cellTableAusgewaehlteSysteme);
		this.cellTableAusgewaehlteSysteme.setSize("100%", "100%");
		this.cellTableAusgewaehlteSysteme.setSelectionModel(this.selModelSystemTable);

		TextColumn<System> colSystemName = new TextColumn<System>() {
			@Override
			public String getValue(System object) {
				return object.getName();
			}
		};
		this.cellTableAusgewaehlteSysteme.addColumn(colSystemName, "Systemname");

		VerticalPanel verticalPanelAllocationButtons = new VerticalPanel();
		verticalPanelAllocationButtons.setStyleName("allocationButtonPanel");
		horizontalPanel.add(verticalPanelAllocationButtons);

		Button btnRemoveSystem = new Button(TextConstants.TEAMVIEW_BUTTONLABEL_REMOVE);
		btnRemoveSystem.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (SelectSystemView.this.getSelectedOfAvailableSystems() != null) {
					SelectSystemView.this.removeSelectedSystem.fire(SelectSystemView.this, new SystemArgs(SelectSystemView.this.getSelectedOfAvailableSystems()));
				}
			}
		});

		Button btnAddSystem = new Button(TextConstants.TEAMVIEW_BUTTONLABEL_ASSIGN);
		btnAddSystem.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (SelectSystemView.this.selModelSystemTable.getSelectedSet().size() > 0 && SelectSystemView.this.getSelectedOfAvailableSystems() != null) {
					SelectSystemView.this.addSelectedSystem.fire(SelectSystemView.this, new SystemArgs(SelectSystemView.this.getSelectedOfAvailableSystems()));
				} else {
					Window.alert(ExceptionConstants.GUI_SYSTEMIEW_ASSIGNERROR);
				}
			}
		});
		verticalPanelAllocationButtons.add(btnAddSystem);
		verticalPanelAllocationButtons.add(btnRemoveSystem);

		VerticalPanel verticalPanelVerfuegbareSysteme = new VerticalPanel();
		horizontalPanel.add(verticalPanelVerfuegbareSysteme);

		Label lblVerfgbareSysteme = new Label("Verfügbare Systeme");
		verticalPanelVerfuegbareSysteme.add(lblVerfgbareSysteme);

		ScrollPanel scrollPanelTeamTree = new ScrollPanel();
		verticalPanelVerfuegbareSysteme.add(scrollPanelTeamTree);
		scrollPanelTeamTree.setStyleName("tableBorder");
		scrollPanelTeamTree.setSize("350px", "425px");

		this.tree = new Tree();
		scrollPanelTeamTree.setWidget(this.tree);
		this.tree.setAnimationEnabled(true);
		this.tree.setSize("100%", "100%");

		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanelVerfuegbareSysteme.add(horizontalPanel_1);

		Button btnOk = new Button("OK");
		horizontalPanel_1.add(btnOk);
		btnOk.setSize("100px", "28px");

		Button btnAbbrechen = new Button("Abbrechen");
		horizontalPanel_1.add(btnAbbrechen);
		btnAbbrechen.setSize("100px", "28px");
		this.selModelSystemTable = new MultiSelectionModel<System>();
	}

	@Override
	public System getSelectedOfAvailableSystems() {
		if (this.tree.getSelectedItem() != null) {
			Object selItem = this.tree.getSelectedItem().getUserObject();
			if (selItem instanceof IPerson) {
				return (System) selItem;
			}
		}
		return null;
	}

	@Override
	public void updateSelectedSystemData(Collection<System> selectedSystems) {
		this.cellTableAusgewaehlteSysteme.setRowData(new ArrayList<System>(selectedSystems));
	}

	@Override
	public void updateAvailableSystemData(Collection<System> availableSystems) {
		this.cellTableAusgewaehlteSysteme.setRowData(new ArrayList<System>(availableSystems));
		// TODO Christin: bereits selektierte ausblenden
	}

	@Override
	public void defineRemoveSelectedSystemEvent(EventHandler<SystemArgs> args) {
		this.removeSelectedSystem.add(args);
	}

	@Override
	public void defineAddSelectedSystemEvent(EventHandler<SystemArgs> args) {
		this.addSelectedSystem.add(args);
	}

}
