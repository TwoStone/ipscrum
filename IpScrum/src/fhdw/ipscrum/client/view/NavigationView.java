package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.PushButton;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.interfaces.INavigationView;
import fhdw.ipscrum.shared.constants.TextConstants;

/**
 * This class is used to compose the main navigation bar of the application.
 */
public class NavigationView extends Composite implements INavigationView {

	// ######## Events ############
	private final Event<EventArgs> projectEvent = new Event<EventArgs>();
	private final Event<EventArgs> tasksEvent = new Event<EventArgs>();
	private final Event<EventArgs> reportsEvent = new Event<EventArgs>();
	private final Event<EventArgs> personenEvent = new Event<EventArgs>();
	private final Event<EventArgs> teamEvent = new Event<EventArgs>();
	private final Event<EventArgs> saveEvent = new Event<EventArgs>();
	private final Event<EventArgs> systemManagement = new Event<EventArgs>();
	private final Event<EventArgs> searchEvent = new Event<EventArgs>();

	// ######## Ende Events #######

	private final MenuItem mntmProjekte;
	private final MenuItem mntmReports;
	private final MenuItem mntmPersonenstammdaten;
	private final MenuItem mntmTeamzuordnung;
	private final MenuItem mntmTaskBoard;
	private final FlowPanel masterMainPanel;
	private final FlowPanel innerMasterPanel;
	private final PushButton pshbtnSpeichern;
	private final MenuItem mntmSystemeverwaltung;
	private final MenuItem mntmSuche;
	private final MenuItem mntmVerwaltung;

	/**
	 * Method createView.
	 * 
	 * @return INavigationView
	 */
	public static INavigationView createView() {
		return new NavigationView();
	}

	private NavigationView() {
		this.innerMasterPanel = new FlowPanel();
		this.initWidget(this.innerMasterPanel);
		this.innerMasterPanel.setSize("1000px", "650px");

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		this.innerMasterPanel.add(horizontalPanel);
		horizontalPanel.setWidth("100%");

		final MenuBar menuBar = new MenuBar(false);
		horizontalPanel.add(menuBar);

		this.mntmProjekte = new MenuItem(TextConstants.NAV_PROJECTS, false,
				new Command() {
					@Override
					public void execute() {
						NavigationView.this.projectEvent.fire(
								NavigationView.this, new EventArgs());
					}
				});
		menuBar.addItem(this.mntmProjekte);

		this.mntmTaskBoard = new MenuItem(TextConstants.NAV_TASKBOARD, false,
				new Command() {
					@Override
					public void execute() {
						NavigationView.this.tasksEvent.fire(
								NavigationView.this, new EventArgs());
					}
				});
		this.mntmTaskBoard.setHTML(TextConstants.NAV_TASKBOARD);
		menuBar.addItem(this.mntmTaskBoard);

		this.mntmReports = new MenuItem(TextConstants.NAV_REPORTS, false,
				new Command() {
					@Override
					public void execute() {
						NavigationView.this.reportsEvent.fire(
								NavigationView.this, new EventArgs());
					}
				});
		menuBar.addItem(this.mntmReports);

		final MenuItemSeparator separator = new MenuItemSeparator();
		menuBar.addSeparator(separator);
		final MenuBar verwMenuBar = new MenuBar(true);

		this.mntmVerwaltung = new MenuItem("Verwaltung", false, verwMenuBar);

		this.mntmPersonenstammdaten = new MenuItem(
				TextConstants.NAV_PERSONROLEMANAGEMENT, false, new Command() {
					@Override
					public void execute() {
						NavigationView.this.personenEvent.fire(
								NavigationView.this, new EventArgs());
					}
				});
		verwMenuBar.addItem(this.mntmPersonenstammdaten);

		this.mntmTeamzuordnung = new MenuItem(TextConstants.NAV_TEAMMANAGEMENT,
				false, new Command() {
					@Override
					public void execute() {
						NavigationView.this.teamEvent.fire(NavigationView.this,
								new EventArgs());
					}
				});
		verwMenuBar.addItem(this.mntmTeamzuordnung);

		this.mntmSystemeverwaltung = new MenuItem("Systemeverwaltung", false,
				new Command() {
					@Override
					public void execute() {
						NavigationView.this.systemManagement.fire(
								NavigationView.this, new EventArgs());
					}
				});
		verwMenuBar.addItem(this.mntmSystemeverwaltung);
		menuBar.addItem(this.mntmVerwaltung);

		this.mntmSuche = new MenuItem("Suche", false, new Command() {
			@Override
			public void execute() {
				NavigationView.this.searchEvent.fire(NavigationView.this,
						new EventArgs());
			}
		});
		menuBar.addItem(this.mntmSuche);

		this.pshbtnSpeichern = new PushButton(TextConstants.NAV_SAVEMODELDATA);
		this.pshbtnSpeichern.setHeight("16px");
		horizontalPanel.add(this.pshbtnSpeichern);
		this.pshbtnSpeichern.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				NavigationView.this.saveEvent.fire(NavigationView.this,
						new EventArgs());
			}
		});

		this.masterMainPanel = new FlowPanel();
		this.innerMasterPanel.add(this.masterMainPanel);
		this.masterMainPanel.setSize("1000px", "600px");
	}

	@Override
	public void addProjectEventHandler(EventHandler<EventArgs> arg) {
		this.projectEvent.add(arg);
	}

	@Override
	public void addReportsEventHandler(EventHandler<EventArgs> arg) {
		this.reportsEvent.add(arg);
	}

	@Override
	public void addPersonEventHandler(EventHandler<EventArgs> arg) {
		this.personenEvent.add(arg);
	}

	@Override
	public void addTeamEventHandler(EventHandler<EventArgs> arg) {
		this.teamEvent.add(arg);
	}

	@Override
	public void addSaveEventHandler(EventHandler<EventArgs> arg) {
		this.saveEvent.add(arg);
	}

	@Override
	public void addTasksEventHandler(EventHandler<EventArgs> arg) {
		this.tasksEvent.add(arg);
	}

	@Override
	public FlowPanel getContentPanel() {
		return this.masterMainPanel;
	}

	@Override
	public void addSystemManagementHandler(EventHandler<EventArgs> handler) {
		this.systemManagement.add(handler);
	}

	@Override
	public void addSearchHandler(EventHandler<EventArgs> handler) {
		this.searchEvent.add(handler);

	}
}
