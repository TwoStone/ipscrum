package fhdw.ipscrum.client.view;

import java.util.ArrayList;
import java.util.HashSet;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.MultiSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PersonTeamArgs;
import fhdw.ipscrum.client.view.interfaces.ITeamView;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

public class TeamView extends Composite implements ITeamView {

	private CellTable<IPerson> cellTablePersons;
	private Tree tree;
	private final Event<EventArgs> newTeamEvent = new Event<EventArgs>();
	private final Event<PersonTeamArgs> modifyTeamEvent = new Event<PersonTeamArgs>();
	private final Event<PersonTeamArgs> removePersonFromTeamEvent = new Event<PersonTeamArgs>();
	private final Event<PersonTeamArgs> addPersonToTeamEvent = new Event<PersonTeamArgs>();
	private MultiSelectionModel<IPerson> selModelPersonTable;

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
		scrollPanelTeamTree.setSize("256px", "400px");

		tree = new Tree();
		scrollPanelTeamTree.setWidget(tree);
		tree.setAnimationEnabled(true);
		tree.setSize("100%", "100%");

		HorizontalPanel horizontalPanelTeamButtons = new HorizontalPanel();
		verticalPanelTeams.add(horizontalPanelTeamButtons);
		horizontalPanelTeamButtons.setWidth("100%");

		Button btnNeuesTeamAnlegen = new Button("Neues Team anlegen");
		btnNeuesTeamAnlegen.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				newTeamEvent.fire(TeamView.this, new EventArgs());
			}
		});
		horizontalPanelTeamButtons.add(btnNeuesTeamAnlegen);
		btnNeuesTeamAnlegen.setWidth("100%");

		Button btnTeamBearbeiten = new Button("Team Bearbeiten");
		btnTeamBearbeiten.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (TeamView.this.getSelectedTeamOfTree() != null) {
					modifyTeamEvent.fire(TeamView.this, new PersonTeamArgs(TeamView.this.getSelectedTeamOfTree()));
				}
			}
		});
		horizontalPanelTeamButtons.add(btnTeamBearbeiten);
		btnTeamBearbeiten.setWidth("100%");

		VerticalPanel verticalPanelAllocationButtons = new VerticalPanel();
		verticalPanelAllocationButtons.setStyleName("allocationButtonPanel");
		horizontalPanel.add(verticalPanelAllocationButtons);

		Button btnRemovePersonFromTeam = new Button("->");
		btnRemovePersonFromTeam.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (TeamView.this.getSelectedPersonOfTree() != null && TeamView.this.getSelectedTeamOfTree() != null) { // TODO does not work
					removePersonFromTeamEvent.fire(TeamView.this, new PersonTeamArgs(TeamView.this.getSelectedPersonOfTree(), TeamView.this.getSelectedTeamOfTree()));
				}
			}
		});
		verticalPanelAllocationButtons.add(btnRemovePersonFromTeam);

		Button btnAddPersonToTeam = new Button("<-");
		btnAddPersonToTeam.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (TeamView.this.selModelPersonTable.getSelectedSet().size()>0 && TeamView.this.getSelectedTeamOfTree() != null) {
					addPersonToTeamEvent.fire(TeamView.this, new PersonTeamArgs(TeamView.this.selModelPersonTable.getSelectedSet(), TeamView.this.getSelectedTeamOfTree()));
				}
			}
		});
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
		selModelPersonTable = new MultiSelectionModel<IPerson>();
		cellTablePersons.setSelectionModel(selModelPersonTable);

		TextColumn<IPerson> colFirstname = new TextColumn<IPerson>() {
			@Override
			public String getValue(IPerson object) {
				return object.getFirstname();
			}
		};
		cellTablePersons.addColumn(colFirstname, "Vorname");

		TextColumn<IPerson> colLastname = new TextColumn<IPerson>() {
			@Override
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

			@Override
			public String getValue(IPerson object) {
				return object.getRoles().toString();
			}
		};
		cellTablePersons.addColumn(colRoles,"Rolle(n)");
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ITeamView#getSelectedPersonOfTree()
	 */
	@Override
	public IPerson getSelectedPersonOfTree() {
		if (this.tree.getSelectedItem() != null) {
			Object selItem = this.tree.getSelectedItem().getUserObject();
			if (selItem instanceof IPerson) {
				return (IPerson) selItem;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ITeamView#getSelectedTeamOfTree()
	 */
	@Override
	public ITeam getSelectedTeamOfTree() {
		if (this.tree.getSelectedItem() != null) {
			Object selItem = this.tree.getSelectedItem().getUserObject();
			if (selItem instanceof ITeam) {
				return (ITeam) selItem;
			} else if (selItem instanceof IPerson && this.tree.getSelectedItem().getParentItem().getUserObject() instanceof ITeam) {
				return (ITeam) this.tree.getSelectedItem().getParentItem().getUserObject();
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ITeamView#updateTeamTreeData(java.util.HashSet)
	 */
	@Override
	public void updateTeamTreeData(HashSet<ITeam> teamSet) {
		this.tree.clear();
		for (ITeam team : teamSet) {
			TreeItem tItem = new TreeItem(team.toString());
			tItem.setUserObject(team);
			tree.addItem(tItem);
			for (IPerson person : team.getMembers()) {
				TreeItem pItem = new TreeItem(person.toString());
				pItem.setUserObject(person);
				pItem.setStyleName("TreeItem-leaf");
				tItem.addItem(pItem);
			}
			tItem.setState(true);

		}
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ITeamView#updatePersonTableData(java.util.HashSet)
	 */
	@Override
	public void updatePersonTableData(HashSet<IPerson> personSet) {
		this.cellTablePersons.setRowData(new ArrayList<IPerson>(personSet));
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ITeamView#defineNewTeamEvent(fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void defineNewTeamEvent(EventHandler<EventArgs> args) {
		this.newTeamEvent.add(args);
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ITeamView#defineModifyTeamEvent(fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void defineModifyTeamEvent(EventHandler<PersonTeamArgs> args) {
		this.modifyTeamEvent.add(args);
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ITeamView#defineRemovePersonFromTeamEvent(fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void defineRemovePersonFromTeamEvent(EventHandler<PersonTeamArgs> args) {
		this.removePersonFromTeamEvent.add(args);
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.ITeamView#defineAddPersonToTeamEvent(fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void defineAddPersonToTeamEvent(EventHandler<PersonTeamArgs> args) {
		this.addPersonToTeamEvent.add(args);
	}

}
