package fhdw.ipscrum.client.view;

import java.util.Vector;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.ReleaseArgs;
import fhdw.ipscrum.client.view.interfaces.IReleaseView;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.interfaces.IRelease;

/**
 * This view class is used to represent releases.
 * 
 * @author Phase II / Gruppe I
 */
public class ReleaseView extends Composite implements IReleaseView {

	// ########## Events #############
	private final Event<EventArgs> newReleaseEvent = new Event<EventArgs>();
	private final Event<ReleaseArgs> deleteSelectedReleaseEvent = new Event<ReleaseArgs>();
	private final Event<ReleaseArgs> detailsSelectedReleaseEvent = new Event<ReleaseArgs>();
	private final Event<ReleaseArgs> releaseSelectedEvent = new Event<ReleaseArgs>();
	// ###### Ende Events ###########

	private Release currentlySelected;

	private Image imgNewFile;
	private Image imgDetails;
	private Image imgDelete;
	private CellTable<IRelease> tableRelease;
	private ScrollPanel scrollPanel;
	private Label lblReleaseuebersicht;

	public static IReleaseView createView() {
		return new ReleaseView();
	}

	public ReleaseView() {

		AbsolutePanel concreteReleasePanel = new AbsolutePanel();
		initWidget(concreteReleasePanel);
		concreteReleasePanel.setSize("400px", "300px");

		lblReleaseuebersicht = new Label("Release\u00FCbersicht");
		lblReleaseuebersicht.setStyleName("LabelElement");
		concreteReleasePanel.add(lblReleaseuebersicht, 10, 5);
		lblReleaseuebersicht.setSize("126px", "19px");

		FlowPanel ReleaseMenuPanel = new FlowPanel();
		concreteReleasePanel.add(ReleaseMenuPanel, 10, 34);
		ReleaseMenuPanel.setSize("256px", "25px");

		imgNewFile = new Image("images/newfile.png");

		imgNewFile.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				newReleaseEvent.fire(ReleaseView.this, new ReleaseArgs(
						currentlySelected));
			}
		});
		ReleaseMenuPanel.add(imgNewFile);

		imgDetails = new Image("images/details.png");
		imgDetails.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				detailsSelectedReleaseEvent.fire(ReleaseView.this,
						new ReleaseArgs(currentlySelected));
			}
		});
		ReleaseMenuPanel.add(imgDetails);

		imgDelete = new Image("images/delete.png");
		imgDelete.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				deleteSelectedReleaseEvent.fire(ReleaseView.this,
						new ReleaseArgs(currentlySelected));
			}
		});
		ReleaseMenuPanel.add(imgDelete);

		scrollPanel = new ScrollPanel();
		concreteReleasePanel.add(scrollPanel, 10, 72);
		scrollPanel.setSize("375px", "215px");

		tableRelease = new CellTable<IRelease>();

		tableRelease.setSelectionModel(new SingleSelectionModel<IRelease>());

		tableRelease.getSelectionModel().addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				@SuppressWarnings("unchecked")
				SingleSelectionModel<IRelease> model = (SingleSelectionModel<IRelease>) tableRelease.getSelectionModel();
				currentlySelected = (Release) model.getSelectedObject();
			}
		});
		
		TextColumn<IRelease> version = new TextColumn<IRelease>() {
			@Override
			public String getValue(IRelease release) {
				return release.getVersion();
			}
		};
		tableRelease.addColumn(version, "Version");

		TextColumn<IRelease> date = new TextColumn<IRelease>() {
			@Override
			public String getValue(IRelease release) {
				
				DateTimeFormat fmt = DateTimeFormat.getFormat("EEEE, dd.MM.yyyy");	
				return fmt.format(release.getReleaseDate());
			}
		};
		tableRelease.addColumn(date, "Releasedatum");
		scrollPanel.setWidget(tableRelease);
		tableRelease.setSize("100%", "100%");
	}

	@Override
	public void addReleaseDetailsEventHandler(EventHandler<ReleaseArgs> arg) {
		detailsSelectedReleaseEvent.add(arg);

	}

	@Override
	public void addDeleteReleaseEventHandler(EventHandler<ReleaseArgs> arg) {
		deleteSelectedReleaseEvent.add(arg);

	}

	private CellTable<IRelease> getTableRelease() {
		return this.tableRelease;
	}

	@Override
	public void addNewReleaseEventHandler(EventHandler<EventArgs> arg) {
		newReleaseEvent.add(arg);
	}

	@Override
	public void refreshReleases(Vector<IRelease> release) {
		this.getTableRelease().setRowData(release);
	}

	@Override
	public void addReleaseSelectedEventHandler(EventHandler<ReleaseArgs> arg) {
		releaseSelectedEvent.add(arg);
	}
	
}
