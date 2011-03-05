/**
 * 
 */
package fhdw.ipscrum.client.view;

import java.util.Collection;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CaptionPanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.utils.SystemTreeItem;
import fhdw.ipscrum.client.view.interfaces.ISystemManagementView;
import fhdw.ipscrum.shared.model.System;
import fhdw.ipscrum.shared.model.Systemgroup;

/**
 * @author Niklas
 * 
 */
public class SystemManagementView extends Composite implements
		ISystemManagementView {
	private Event<NewSystemEventArgs> createSystemEvent;
	private List<Systemgroup> possibleParents;
	final Tree systemTree;
	final RadioButton rdbtnSystem;
	final RadioButton rdbtnGruppe;
	final ListBox parentComboBox;

	public SystemManagementView() {

		final CaptionPanel cptnpnlNewPanel = new CaptionPanel(
				"Systemverwaltung");
		cptnpnlNewPanel.setCaptionHTML("Systemverwaltung");
		this.initWidget(cptnpnlNewPanel);

		final VerticalPanel verticalPanel = new VerticalPanel();
		cptnpnlNewPanel.setContentWidget(verticalPanel);
		verticalPanel.setSize("100%", "");

		final ScrollPanel scrollPanel = new ScrollPanel();
		verticalPanel.add(scrollPanel);

		this.systemTree = new Tree();
		scrollPanel.setWidget(this.systemTree);
		this.systemTree.setSize("100%", "100%");

		final DisclosurePanel createSystemPanel = new DisclosurePanel(
				"Neues System anlegen");
		createSystemPanel.setOpen(true);
		createSystemPanel.setAnimationEnabled(true);
		verticalPanel.add(createSystemPanel);

		final Grid grid = new Grid(3, 3);
		createSystemPanel.setContent(grid);
		grid.setSize("", "");

		final Label lblName = new Label("Name:");
		lblName.setWordWrap(false);
		grid.setWidget(0, 0, lblName);

		final TextBox nameTextBox = new TextBox();
		grid.setWidget(0, 1, nameTextBox);

		final Label lblbergeordnet = new Label("Übergeordnet");
		lblbergeordnet.setWordWrap(false);
		grid.setWidget(1, 0, lblbergeordnet);

		this.parentComboBox = new ListBox();
		grid.setWidget(1, 1, this.parentComboBox);

		final Button btnNewSystem = new Button("Neues System hinzufügen");
		btnNewSystem.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final String name = nameTextBox.getText();
				final Systemgroup parent = SystemManagementView.this.possibleParents
						.get(SystemManagementView.this.parentComboBox
								.getSelectedIndex());
				final Boolean asGroup = SystemManagementView.this.rdbtnGruppe
						.getValue();
				SystemManagementView.this.createSystemEvent.fire(
						SystemManagementView.this, new NewSystemEventArgs(name,
								parent, asGroup));
			}
		});

		this.rdbtnSystem = new RadioButton("new name", "System");
		this.rdbtnSystem.setValue(true);
		grid.setWidget(2, 0, this.rdbtnSystem);

		this.rdbtnGruppe = new RadioButton("new name", "Gruppe");
		grid.setWidget(2, 1, this.rdbtnGruppe);
		grid.setWidget(2, 2, btnNewSystem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.interfaces.ISystemManagementView#
	 * getCreateSystemEvent()
	 */
	@Override
	public IEvent<NewSystemEventArgs> getCreateSystemEvent() {
		return this.createSystemEvent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.interfaces.ISystemManagementView#setRootSystemGroup
	 * (fhdw.ipscrum.shared.model.interfaces.IHasChildren)
	 */
	@Override
	public void setRootSystemGroup(Collection<System> systems) {
		this.systemTree.clear();
		for (final System system : systems) {
			this.systemTree.addItem(new SystemTreeItem(system));
		}
	}

	@Override
	public void setPossibleParents(List<Systemgroup> parents) {
		this.possibleParents = parents;

	}
}
