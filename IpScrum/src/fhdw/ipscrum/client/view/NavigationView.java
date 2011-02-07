package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.interfaces.INavigationView;

public class NavigationView extends Composite implements INavigationView {
	private Button btnVerwaltung;
	private Button btnProjekte;
	private FlowPanel masterMainPanel;
	private final FlowPanel innerMasterPanel;

	public static INavigationView createView(){
		return new NavigationView();
	}
	
	private NavigationView() {
		innerMasterPanel = new FlowPanel();
		initWidget(innerMasterPanel);
		innerMasterPanel.setSize("800", "650");

		AbsolutePanel concreteMenuPanel = new AbsolutePanel();
		innerMasterPanel.add(concreteMenuPanel);
		concreteMenuPanel.setSize("800", "50");

		btnProjekte = new Button("New button");
		btnProjekte.setText("Projekte");
		concreteMenuPanel.add(btnProjekte, 10, 10);
		btnProjekte.setSize("110px", "30px");

		btnVerwaltung = new Button("New button");
		btnVerwaltung.setText("Personalverwaltung");
		concreteMenuPanel.add(btnVerwaltung, 126, 10);
		btnVerwaltung.setSize("163px", "30px");

		masterMainPanel = new FlowPanel();
		innerMasterPanel.add(masterMainPanel);
		masterMainPanel.setSize("1000", "600");
	}

	public HasClickHandlers getBtnVerwaltung() {
		return btnVerwaltung;
	}

	public HasClickHandlers getBtnProjekte() {
		return btnProjekte;
	}

	public FlowPanel getContentPanel() {
		return masterMainPanel;
	}
}
