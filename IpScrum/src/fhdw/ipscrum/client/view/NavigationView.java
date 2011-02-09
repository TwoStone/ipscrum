package fhdw.ipscrum.client.view;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.interfaces.INavigationView;

public class NavigationView extends Composite implements INavigationView {

	// ######## Events ############
	private final Event<EventArgs> projectEvent = new Event<EventArgs>();
	private final Event<EventArgs> personenEvent = new Event<EventArgs>();
	private final Event<EventArgs> teamEvent = new Event<EventArgs>();

	// ######## Ende Events #######

	private MenuItem mntmProjekte;
	private MenuItem mntmPersonenstammdaten;
	private MenuItem mntmTeamzuordnung;
	private FlowPanel masterMainPanel;
	private final FlowPanel innerMasterPanel;

	public static INavigationView createView() {
		return new NavigationView();
	}

	private NavigationView() {
		innerMasterPanel = new FlowPanel();
		initWidget(innerMasterPanel);
		innerMasterPanel.setSize("1000px", "650px");

		VerticalPanel verticalPanel = new VerticalPanel();
		innerMasterPanel.add(verticalPanel);
		verticalPanel.setWidth("100%");

		MenuBar menuBar = new MenuBar(false);
		verticalPanel.add(menuBar);

		mntmProjekte = new MenuItem("Projekte", false, new Command() {
			public void execute() {
				projectEvent.fire(NavigationView.this, new EventArgs());
			}
		});
		menuBar.addItem(mntmProjekte);

		MenuItemSeparator separator = new MenuItemSeparator();
		menuBar.addSeparator(separator);

		mntmPersonenstammdaten = new MenuItem("Personen-Stammdaten", false,
				new Command() {
			public void execute() {
				personenEvent.fire(NavigationView.this, new EventArgs());
			}
		});
		menuBar.addItem(mntmPersonenstammdaten);

		mntmTeamzuordnung = new MenuItem("Teamzuordnung", false, new Command() {
			public void execute() {
				teamEvent.fire(NavigationView.this, new EventArgs());
			}
		});
		menuBar.addItem(mntmTeamzuordnung);

		masterMainPanel = new FlowPanel();
		innerMasterPanel.add(masterMainPanel);
		masterMainPanel.setSize("1000px", "600px");
	}

	@Override
	public void addPersonEventHandler(EventHandler<EventArgs> arg) {
		personenEvent.add(arg);
	}
	
	@Override
	public void addProjectEventHandler(EventHandler<EventArgs> arg) {
		projectEvent.add(arg);
	}
	
	@Override
	public void addTeamEventHandler(EventHandler<EventArgs> arg) {
		teamEvent.add(arg);
	}

	public FlowPanel getContentPanel() {
		return this.masterMainPanel;
	}
}
