package fhdw.ipscrum.client.view;

import java.util.ArrayList;

import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.cellview.client.TreeNode;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;

import fhdw.ipscrum.client.view.interfaces.ITeamView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public class TeamView extends Composite implements ITeamView {

	private CellTable<IPerson> cellTablePersons;
	private SingleSelectionModel selectionModel;

	public TeamView() {

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		initWidget(horizontalPanel);

		VerticalPanel verticalPanelTeams = new VerticalPanel();
		horizontalPanel.add(verticalPanelTeams);

		Label lblTeams = new Label("Teams");
		verticalPanelTeams.add(lblTeams);

		selectionModel = new SingleSelectionModel();
	    TreeViewModel model = new TeamTreeViewModel(selectionModel);
	    CellTree cellTree = new CellTree(model, null);
	    cellTree.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);
		
		cellTree.setAnimationEnabled(true);
		cellTree.setStyleName("tableBorder");
		verticalPanelTeams.add(cellTree);
		cellTree.setSize("300px", "400px");
				
		HorizontalPanel horizontalPanelTeamButtons = new HorizontalPanel();
		verticalPanelTeams.add(horizontalPanelTeamButtons);
		horizontalPanelTeamButtons.setWidth("100%");
		
				Button btnNeuesTeamAnlegen = new Button("Neues Team anlegen");
				horizontalPanelTeamButtons.add(btnNeuesTeamAnlegen);
				btnNeuesTeamAnlegen.setWidth("100%");
				
				Button btnBearbeiten = new Button("Bearbeiten");
				horizontalPanelTeamButtons.add(btnBearbeiten);
				btnBearbeiten.setWidth("100%");

		VerticalPanel verticalPanelAllocationButtons = new VerticalPanel();
		verticalPanelAllocationButtons.setStyleName("allocationButtonPanel");
		horizontalPanel.add(verticalPanelAllocationButtons);

		Button btnRemovePersonFromTeam = new Button("->");
		verticalPanelAllocationButtons.add(btnRemovePersonFromTeam);

		Button btnAddPersonToTeam = new Button("<-");
		verticalPanelAllocationButtons.add(btnAddPersonToTeam);

		VerticalPanel verticalPanelPersons = new VerticalPanel();
		horizontalPanel.add(verticalPanelPersons);

		Label lblVerfgbarePersonen = new Label("Verf\u00FCgbare Personen");
		verticalPanelPersons.add(lblVerfgbarePersonen);
		
		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setStyleName("tableBorder");
		verticalPanelPersons.add(scrollPanel);
		scrollPanel.setSize("450px", "425px");

		cellTablePersons = new CellTable<IPerson>();
		scrollPanel.setWidget(cellTablePersons);
		cellTablePersons.setSize("100%", "100%");
		final MultiSelectionModel<IPerson> selModelPersons = new MultiSelectionModel<IPerson>();
		cellTablePersons.setSelectionModel(selModelPersons);
		
		TextColumn<IPerson> colFirstname = new TextColumn<IPerson>() {
			public String getValue(IPerson object) {
				return object.getFirstname();
			}
		};
		cellTablePersons.addColumn(colFirstname, "Vorname");
		
		TextColumn<IPerson> colLastname = new TextColumn<IPerson>() {
			public String getValue(IPerson object) {
				return object.getLastname();
			}
		};
		cellTablePersons.addColumn(colLastname, "Nachname");
		
		TextColumn<IPerson> colRoles = new TextColumn<IPerson>() {
			public String getValue(IPerson object) {
				return object.getRoles().toString();
			}
		};
		cellTablePersons.addColumn(colRoles,"Rolle(n)");
	}

	@Override
	public void updatePersonTableData(ArrayList<IPerson> arrayList) {
		this.cellTablePersons.setRowData(arrayList);
	}

}
