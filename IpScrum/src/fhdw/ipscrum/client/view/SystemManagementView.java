/**
 * 
 */
package fhdw.ipscrum.client.view;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
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
	private final Event<NewSystemEventArgs> createSystemEvent = new Event<NewSystemEventArgs>();
	private List<Systemgroup> possibleParents;
	final Tree systemTree;
	final RadioButton rdbtnSystem;
	final RadioButton rdbtnGruppe;
	final ListBox parentComboBox;

	public SystemManagementView() {

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setStyleName("center");
		this.initWidget(verticalPanel);
		verticalPanel.setSize("50%", "");

		final HTML htmlNewHtml = new HTML("<h1>Systemeverwaltung</h1>", true);
		verticalPanel.add(htmlNewHtml);

		final ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setStyleName("smallborder");
		verticalPanel.add(scrollPanel);
		scrollPanel.setSize("100%", "300px");

		this.systemTree = new Tree();
		this.systemTree.setAnimationEnabled(true);
		scrollPanel.setWidget(this.systemTree);
		this.systemTree.setSize("100%", "");

		final DisclosurePanel createSystemPanel = new DisclosurePanel(
				"Neues System anlegen");
		createSystemPanel.setAnimationEnabled(true);
		verticalPanel.add(createSystemPanel);
		createSystemPanel.setWidth("100%");

		final Grid grid = new Grid(4, 2);
		grid.setStyleName("lightBackground");
		createSystemPanel.setContent(grid);
		grid.setSize("100%", "");

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

		this.rdbtnSystem = new RadioButton("new name", "System");
		this.rdbtnSystem.setValue(true);
		grid.setWidget(2, 0, this.rdbtnSystem);

		this.rdbtnGruppe = new RadioButton("new name", "Gruppe");
		grid.setWidget(2, 1, this.rdbtnGruppe);

		final Button btnNewSystem = new Button("Neues System hinzufügen");
		btnNewSystem.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				final String name = nameTextBox.getText();
				Systemgroup parent = null;
				if (SystemManagementView.this.parentComboBox.getSelectedIndex() > 0) {
					parent = SystemManagementView.this.possibleParents
							.get(SystemManagementView.this.parentComboBox
									.getSelectedIndex() - 1);
				}
				final Boolean asGroup = SystemManagementView.this.rdbtnGruppe
						.getValue();
				SystemManagementView.this.createSystemEvent.fire(
						SystemManagementView.this, new NewSystemEventArgs(name,
								parent, asGroup));
			}
		});
		grid.setWidget(3, 1, btnNewSystem);
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
	public void setRootSystemGroup(List<System> systems) {
		Collections.sort(systems, new Comparator<System>() {
			@Override
			public int compare(System o1, System o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
		this.systemTree.clear();
		for (final System system : systems) {
			this.systemTree.addItem(new SystemTreeItem(system));
		}
	}

	@Override
	public void setPossibleParents(List<Systemgroup> parents) {
		Collections.sort(parents, new Comparator<Systemgroup>() {

			@Override
			public int compare(Systemgroup o1, Systemgroup o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
		this.possibleParents = parents;
		this.parentComboBox.clear();
		this.parentComboBox.addItem("");
		for (final Systemgroup systemgroup : parents) {
			this.parentComboBox.addItem(systemgroup.getName());
		}
	}
}
