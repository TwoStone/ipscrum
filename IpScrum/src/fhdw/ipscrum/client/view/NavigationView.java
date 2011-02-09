package fhdw.ipscrum.client.view;

import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.view.interfaces.INavigationView;

public class NavigationView extends Composite implements INavigationView {

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
		
		mntmProjekte = new MenuItem("Projekte", false, (Command) null);
		menuBar.addItem(mntmProjekte);
		
		MenuItemSeparator separator = new MenuItemSeparator();
		menuBar.addSeparator(separator);
		
		mntmPersonenstammdaten = new MenuItem("Personen-Stammdaten", false, (Command) null);
		menuBar.addItem(mntmPersonenstammdaten);
		
		mntmTeamzuordnung = new MenuItem("Teamzuordnung", false, (Command) null);
		menuBar.addItem(mntmTeamzuordnung);

		masterMainPanel = new FlowPanel();
		innerMasterPanel.add(masterMainPanel);
		masterMainPanel.setSize("1000px", "600px");
	}

	public MenuItem getMntmProjekte() {
		return this.mntmProjekte;
	}

	public MenuItem getMntmPersonenstammdaten() {
		return this.mntmPersonenstammdaten;
	}

	public MenuItem getMntmTeamzuordnung() {
		return this.mntmTeamzuordnung;
	}

	public FlowPanel getContentPanel() {
		return this.masterMainPanel;
	}
}
