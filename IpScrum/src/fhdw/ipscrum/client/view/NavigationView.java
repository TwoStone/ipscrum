package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.AbsolutePanel;

import fhdw.ipscrum.client.view.interfaces.INavigationView;

public class NavigationView extends Composite implements INavigationView{
	private Button personalverwaltung;
	private Button projekte;
	private FlowPanel masterMainPanel;
	public NavigationView() {
		
		FlowPanel innerMasterPanel = new FlowPanel();
		initWidget(innerMasterPanel);
		innerMasterPanel.setSize("800", "650");
		
		AbsolutePanel concreteMenuPanel = new AbsolutePanel();
		innerMasterPanel.add(concreteMenuPanel);
		concreteMenuPanel.setSize("800", "50");
		
		projekte = new Button("New button");
		projekte.setText("Projekte");
		concreteMenuPanel.add(projekte, 10, 10);
		projekte.setSize("110px", "30px");
		
		personalverwaltung = new Button("New button");
		personalverwaltung.setText("Personalverwaltung");
		concreteMenuPanel.add(personalverwaltung, 126, 10);
		personalverwaltung.setSize("163px", "30px");
		
		masterMainPanel = new FlowPanel();
		innerMasterPanel.add(masterMainPanel);
		masterMainPanel.setSize("1000", "600");
	}
	public HasClickHandlers getPersonalverwaltung() {
		return personalverwaltung;
	}
	public HasClickHandlers getProjekte() {
		return projekte;
	}
	public FlowPanel getMasterMainPanel() {
		return masterMainPanel;
	}
}
