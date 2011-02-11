package fhdw.ipscrum.client.view;

import java.util.ArrayList;
import java.util.HashSet;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.MultiSelectionModel;

import fhdw.ipscrum.client.view.interfaces.ITeamView;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

public class TeamView extends Composite implements ITeamView {

	private CellTable<IPerson> cellTablePersons;
	private Tree tree;

	public TeamView() {

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		initWidget(horizontalPanel);

		VerticalPanel verticalPanelTeams = new VerticalPanel();
		horizontalPanel.add(verticalPanelTeams);

		Label lblTeams = new Label("Teams");
		verticalPanelTeams.add(lblTeams);
				
				ScrollPanel scrollPanelTeamTree = new ScrollPanel();
				scrollPanelTeamTree.setStyleName("tableBorder");
				verticalPanelTeams.add(scrollPanelTeamTree);
				scrollPanelTeamTree.setSize("300px", "400px");
				
				tree = new Tree();
				scrollPanelTeamTree.setWidget(tree);
				tree.setAnimationEnabled(true);
				tree.setSize("100%", "100%");
		
		HorizontalPanel horizontalPanelTeamButtons = new HorizontalPanel();
		verticalPanelTeams.add(horizontalPanelTeamButtons);
		horizontalPanelTeamButtons.setWidth("100%");
		
				Button btnNeuesTeamAnlegen = new Button("Neues Team anlegen");
				horizontalPanelTeamButtons.add(btnNeuesTeamAnlegen);
				btnNeuesTeamAnlegen.setWidth("100%");
				
				Button btnBearbeiten = new Button("Bearbeiten");
				btnBearbeiten.addClickHandler(new ClickHandler() {
					public void onClick(ClickEvent event) {
						Window.alert(TeamView.this.tree.getSelectedItem().getText());
						if (TeamView.this.tree.getSelectedItem().getParentItem() != null) {
							Window.alert(TeamView.this.tree.getSelectedItem().getParentItem().getText());
						}
					}
				});
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
			@Override
			public void render(Context context, IPerson object, SafeHtmlBuilder sb) {
				for (IRole role : object.getRoles()) {
					sb.appendHtmlConstant(role.toString() + "<br />");
				}
			} 
			
			public String getValue(IPerson object) {
				return object.getRoles().toString();
			}
		};
		cellTablePersons.addColumn(colRoles,"Rolle(n)");
	}

	public void updateTeamTreeData(HashSet<ITeam> teamSet) {
		this.tree.clear();
		TreeItem teamRoot = new TreeItem();
		for (ITeam iTeam : teamSet) {
			TreeItem item = teamRoot.addItem(iTeam.toString());
			tree.addItem(item);	
			for (IPerson iPerson : iTeam.getMembers()) {
				item.addItem(iPerson.toString());
			}
			
		}
		
	}

	@Override
	public void updatePersonTableData(ArrayList<IPerson> arrayList) {
		this.cellTablePersons.setRowData(arrayList);
	}

}
