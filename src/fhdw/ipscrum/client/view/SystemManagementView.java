/**
 * 
 */
package fhdw.ipscrum.client.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.presenter.SystemManagementPresenter.ISystemManagementView;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.utils.SystemTreeItem;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.nonMeta.System;

/**
 * @author Niklas
 * 
 */
public class SystemManagementView extends MasterView implements ISystemManagementView {

	private final Event<NewSystemEventArgs> createSystemEvent = new Event<NewSystemEventArgs>();
	private List<System> possibleParents;
	private final Tree systemTree;
	private final ListBox parentComboBox;

	private final ClickHandler createSystemClickHandler = new ClickHandler() {
		@Override
		public void onClick(final ClickEvent event) {
			final String name = SystemManagementView.this.nameTextBox.getText();
			System parent = null;
			if (SystemManagementView.this.parentComboBox.getSelectedIndex() > 0) {
				parent =
						SystemManagementView.this.possibleParents.get(SystemManagementView.this.parentComboBox
								.getSelectedIndex() - 1);
			}
			SystemManagementView.this.createSystemEvent.fire(SystemManagementView.this, new NewSystemEventArgs(name,
					parent));
			SystemManagementView.this.nameTextBox.setText(TextConstants.EMPTY_TEXT);
		}
	};
	private final TextBox nameTextBox;
	private final Button btnNewSystem;

	/**
	 * constructor of the SystemManagementView.
	 */
	public SystemManagementView() {
		super();

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setStyleName("center");
		this.add(verticalPanel);
		verticalPanel.setSize("500px", "500px");

		final HTML htmlNewHtml = new HTML("<h3>" + TextConstants.SYSTEMEVERWALTUNG + "</h3>", true);
		verticalPanel.add(htmlNewHtml);

		final ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setStyleName("smallborder");
		verticalPanel.add(scrollPanel);
		scrollPanel.setSize("100%", "300px");

		this.systemTree = new Tree();
		this.systemTree.setAnimationEnabled(true);
		scrollPanel.setWidget(this.systemTree);
		this.systemTree.setSize("100%", "");

		final DisclosurePanel createSystemPanel = new DisclosurePanel(TextConstants.NEUES_SYSTEM_ANLEGEN);
		createSystemPanel.setOpen(true);
		createSystemPanel.setAnimationEnabled(true);
		verticalPanel.add(createSystemPanel);
		createSystemPanel.setWidth("100%");

		final Grid grid = new Grid(3, 2);
		grid.setStyleName("lightBackground");
		createSystemPanel.setContent(grid);
		grid.setSize("100%", "");

		final Label lblName = new Label(TextConstants.NAME);
		lblName.setWordWrap(false);
		grid.setWidget(0, 0, lblName);

		this.nameTextBox = new TextBox();
		this.nameTextBox.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(final KeyPressEvent event) {
				if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
					GwtUtils.setFocus(SystemManagementView.this.parentComboBox);
				}
			}
		});
		grid.setWidget(0, 1, this.nameTextBox);

		final Label lblbergeordnet = new Label(TextConstants.ÜBERGEORDNET);
		lblbergeordnet.setWordWrap(false);
		grid.setWidget(1, 0, lblbergeordnet);

		this.parentComboBox = new ListBox();
		this.parentComboBox.addKeyPressHandler(new KeyPressHandler() {
			@Override
			public void onKeyPress(final KeyPressEvent event) {
				if (GwtUtils.enterPressed(event)) {
					SystemManagementView.this.createSystemClickHandler.onClick(null);
				}

			}
		});
		grid.setWidget(1, 1, this.parentComboBox);

		this.btnNewSystem = new Button(TextConstants.NEUES_SYSTEM_HINZUFÜGEN);
		this.btnNewSystem.addClickHandler(this.createSystemClickHandler);
		grid.setWidget(2, 1, this.btnNewSystem);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.viewOLD.interfaces.ISystemManagementView# setRootSystemGroup
	 * (fhdw.ipscrum.shared.model.interfaces.IHasChildren)
	 */
	@Override
	public void setRootSystemGroup(final List<System> systems) {
		Collections.sort(systems, new Comparator<System>() {
			@Override
			public int compare(final System o1, final System o2) {
				return o1.getName().compareToIgnoreCase(o2.getName());
			}
		});
		this.systemTree.clear();
		for (final System system : systems) {
			this.systemTree.addItem(new SystemTreeItem(system));
		}
	}

	@Override
	public void setPossibleParents(final List<System> parents) {
		Collections.sort(parents, new Comparator<System>() {
			@Override
			public int compare(final System o1, final System o2) {
				final String o1Comp = this.getCompString(o1);
				final String o2Comp = this.getCompString(o2);

				return o1Comp.compareToIgnoreCase(o2Comp);
			}

			private String getCompString(final System system) {
				return system.getParent() == system.getRoot() ? system.getName() : system.getParent().getName();
			}
		});
		this.possibleParents = parents;
		this.parentComboBox.clear();
		this.parentComboBox.addItem("");
		final List<String> items = new ArrayList<String>();
		for (final System system : parents) {
			items.add(system.toDisplayWithParent());
		}
		for (final String string : items) {
			this.parentComboBox.addItem(string);
		}
	}

	@Override
	public void close() {
		this.createSystemEvent.removeAllHandler();
	}

	@Override
	public EventRegistration registerCreateSystemHandler(final EventHandler<NewSystemEventArgs> handler) {
		return this.createSystemEvent.add(handler);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		this.getBtnNewSystem().setEnabled(value);
	}

	protected Button getBtnNewSystem() {
		return this.btnNewSystem;
	}
}
