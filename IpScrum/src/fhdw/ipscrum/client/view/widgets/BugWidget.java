package fhdw.ipscrum.client.view.widgets;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.view.PBIView;
import fhdw.ipscrum.client.view.interfaces.IBugView;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.NothingSelectedException;
import fhdw.ipscrum.shared.model.interfaces.IRelease;

public class BugWidget extends Composite implements IBugView {
	PBIView pbiView;
	private final ListBox listBoxVersion = new ListBox();
	private List<IRelease> releases;
	private final Button btnChangeSystems;
	private final Event<EventArgs> changeSystems = new Event<EventArgs>();

	public BugWidget(FlexTable grid, VerticalPanel verticalPanel, PBIView pbiView) {
		this.pbiView = pbiView;
		Label lblVersion = new Label("Version:");

		grid.setWidget(2, 0, lblVersion);
		grid.setWidget(2, 1, listBoxVersion);

		Label label = new Label("Akzptanzkriterien:");
		verticalPanel.add(label);
		label.setWidth("300px");

		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setStyleName("createFeatureTable");
		verticalPanel.add(scrollPanel);
		scrollPanel.setSize("300px", "150px");

		CellTable<IRelease> cellTable = new CellTable();
		scrollPanel.setWidget(cellTable);
		cellTable.setSize("100%", "100%");
		this.btnChangeSystems = new Button(TextConstants.CHANGE_SYSTEM);
		this.btnChangeSystems.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				BugWidget.this.changeSystems.fire(BugWidget.this, new EventArgs());
			}
		});
		verticalPanel.add(btnChangeSystems);
	}

	@Override
	public IRelease getSelectedVersion() throws NothingSelectedException {
		final Integer index = this.listBoxVersion.getSelectedIndex();
		if (index.equals(0) || index.equals(-1)) {
			throw new NothingSelectedException(ExceptionConstants.NO_VERSION_SELECTED);
		} else {
			return this.releases.get(index - 1);
		}
	}

	@Override
	public void setVersion(List<IRelease> releases, IRelease selected) {
		this.releases = releases;

		if (!this.releases.contains(selected) && selected != null) {
			this.releases.add(selected);
		}

		this.listBoxVersion.clear();
		this.listBoxVersion.addItem(""); // Adding an empty item!
		for (final IRelease iRelease : releases) {
			final String text = iRelease.toString();
			this.listBoxVersion.addItem(text);
		}
		if (selected != null) {
			final int index = releases.indexOf(selected);
			this.listBoxVersion.setSelectedIndex(index + 1);
		} else {
			this.listBoxVersion.setSelectedIndex(0);
		}

	}

	protected Button getBtnChangeSystems() {
		return this.btnChangeSystems;
	}

	@Override
	public IEvent<EventArgs> getChangeSystems() {
		return this.changeSystems;
	}
}
