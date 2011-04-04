package fhdw.ipscrum.client.view;

import java.util.Collection;
import java.util.HashSet;
import java.util.Vector;

import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
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
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PersonTeamArgs;
import fhdw.ipscrum.client.view.interfaces.ITeamView;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 * view class of the team interface. this composes the team management gui. this
 * view is used to inspect, create and modify teams as well as adding and
 * removing persons to teams.
 */
public class TeamView extends Composite implements ITeamView {

	private Tree tree;
	private final Event<EventArgs> newTeamEvent = new Event<EventArgs>();
	private final Event<PersonTeamArgs> modifyTeamEvent = new Event<PersonTeamArgs>();
	private final Event<PersonTeamArgs> removePersonFromTeamEvent = new Event<PersonTeamArgs>();
	private final Event<PersonTeamArgs> addPersonToTeamEvent = new Event<PersonTeamArgs>();
	private MultiSelectionModel<IPerson> selModelPersonTable;
	private ListDataProvider<IPerson> personDataProvider;
	private Collection<IPerson> originalPersonList;

	public TeamView() {

		personDataProvider = new ListDataProvider<IPerson>();

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		initWidget(horizontalPanel);

		VerticalPanel verticalPanelTeams = new VerticalPanel();
		horizontalPanel.add(verticalPanelTeams);

		Label lblTeams = new Label(TextConstants.TEAMVIEW_TEAMTABLEHEADER);
		verticalPanelTeams.add(lblTeams);

		ScrollPanel scrollPanelTeamTree = new ScrollPanel();
		scrollPanelTeamTree.setStyleName("tableBorder");
		verticalPanelTeams.add(scrollPanelTeamTree);
		scrollPanelTeamTree.setSize("256px", "400px");

		this.tree = new Tree();
		tree.addSelectionHandler(new SelectionHandler<TreeItem>() {
			@Override
			public void onSelection(SelectionEvent<TreeItem> event) {
				TeamView.this.updateGuiToSelectionChange();
			}
		});
		scrollPanelTeamTree.setWidget(this.tree);
		this.tree.setAnimationEnabled(true);
		this.tree.setSize("100%", "100%");

		HorizontalPanel horizontalPanelTeamButtons = new HorizontalPanel();
		verticalPanelTeams.add(horizontalPanelTeamButtons);
		horizontalPanelTeamButtons.setWidth("100%");

		Button btnNeuesTeamAnlegen = new Button(
				TextConstants.TEAMVIEW_BUTTONLABEL_CREATENEWTEAM);
		btnNeuesTeamAnlegen.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				TeamView.this.newTeamEvent.fire(TeamView.this, new EventArgs());
			}
		});
		horizontalPanelTeamButtons.add(btnNeuesTeamAnlegen);
		btnNeuesTeamAnlegen.setWidth("100%");

		Button btnTeamBearbeiten = new Button(
				TextConstants.TEAMVIEW_BUTTONLABEL_MODIFYTEAM);
		btnTeamBearbeiten.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (TeamView.this.getSelectedTeamOfTree() != null) {
					TeamView.this.modifyTeamEvent.fire(
							TeamView.this,
							new PersonTeamArgs(TeamView.this
									.getSelectedTeamOfTree()));
				}
			}
		});
		horizontalPanelTeamButtons.add(btnTeamBearbeiten);
		btnTeamBearbeiten.setWidth("100%");

		VerticalPanel verticalPanelAllocationButtons = new VerticalPanel();
		verticalPanelAllocationButtons.setStyleName("allocationButtonPanel");
		horizontalPanel.add(verticalPanelAllocationButtons);

		Button btnRemovePersonFromTeam = new Button(
				TextConstants.BUTTONLABEL_REMOVE);
		btnRemovePersonFromTeam.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (TeamView.this.getSelectedPersonOfTree() != null
						&& TeamView.this.getSelectedTeamOfTree() != null) { // does
																			// not
																			// work
																			// sometimes..
					TeamView.this.removePersonFromTeamEvent.fire(
							TeamView.this,
							new PersonTeamArgs(TeamView.this
									.getSelectedPersonOfTree(), TeamView.this
									.getSelectedTeamOfTree()));
				}
			}
		});
		verticalPanelAllocationButtons.add(btnRemovePersonFromTeam);

		Button btnAddPersonToTeam = new Button(TextConstants.BUTTONLABEL_ASSIGN);
		btnAddPersonToTeam.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				if (TeamView.this.selModelPersonTable.getSelectedSet().size() > 0
						&& TeamView.this.getSelectedTeamOfTree() != null) {
					TeamView.this.addPersonToTeamEvent.fire(
							TeamView.this,
							new PersonTeamArgs(
									TeamView.this.selModelPersonTable
											.getSelectedSet(), TeamView.this
											.getSelectedTeamOfTree()));
				} else {
					Window.alert(ExceptionConstants.GUI_TEAMVIEW_ASSIGNERROR);
				}
			}
		});
		verticalPanelAllocationButtons.add(btnAddPersonToTeam);

		VerticalPanel verticalPanelPersons = new VerticalPanel();
		horizontalPanel.add(verticalPanelPersons);

		Label lblVerfgbarePersonen = new Label(
				TextConstants.TEAMVIEW_PERSONTABLEHEADER);
		verticalPanelPersons.add(lblVerfgbarePersonen);

		ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setStyleName("tableBorder");
		verticalPanelPersons.add(scrollPanel);
		scrollPanel.setSize("450px", "425px");

		CellTable<IPerson> cellTablePersons = new CellTable<IPerson>();
		personDataProvider.addDataDisplay(cellTablePersons);
		scrollPanel.setWidget(cellTablePersons);
		cellTablePersons.setSize("100%", "100%");
		this.selModelPersonTable = new MultiSelectionModel<IPerson>(
				personDataProvider);
		cellTablePersons.setSelectionModel(this.selModelPersonTable);

		TextColumn<IPerson> colFirstname = new TextColumn<IPerson>() {
			@Override
			public String getValue(IPerson object) {
				return object.getFirstname();
			}
		};
		cellTablePersons.addColumn(colFirstname,
				TextConstants.TEAMVIEW_FIRSTNAMEHEADER);

		TextColumn<IPerson> colLastname = new TextColumn<IPerson>() {
			@Override
			public String getValue(IPerson object) {
				return object.getLastname();
			}
		};
		cellTablePersons.addColumn(colLastname,
				TextConstants.TEAMVIEW_LASTNAMEHEADER);

		TextColumn<IPerson> colRoles = new TextColumn<IPerson>() {
			@Override
			public void render(Context context, IPerson object,
					SafeHtmlBuilder sb) {
				for (IRole role : object.getRoles()) {
					sb.appendHtmlConstant(role.toString() + "<br />");
				}
			}

			@Override
			public String getValue(IPerson object) {
				return object.getRoles().toString();
			}
		};
		cellTablePersons
				.addColumn(colRoles, TextConstants.TEAMVIEW_ROLESHEADER);
	}

	/**
	 * This method is called when the team-selection changes. It updates the
	 * person-table to just show availabe persons.
	 */
	private void updateGuiToSelectionChange() {
		Vector<IPerson> personsToHide = this.getSelectedTeamOfTree()
				.getMembers();
		personDataProvider.getList().clear();
		personDataProvider.getList().addAll(originalPersonList);
		personDataProvider.getList().removeAll(personsToHide);
		// personsToShow.removeAll(personsToHide);
		//
		// this.cellTablePersons.setRowData(new
		// ArrayList<IPerson>(personsToShow));
	}

	/*
	 * (non-Javadoc)
	 * 
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.ITeamView#getSelectedTeamOfTree()
	 */
	@Override
	public ITeam getSelectedTeamOfTree() {
		if (this.tree.getSelectedItem() != null) {
			Object selItem = this.tree.getSelectedItem().getUserObject();
			if (selItem instanceof ITeam) {
				return (ITeam) selItem;
			} else if (selItem instanceof IPerson
					&& this.tree.getSelectedItem().getParentItem()
							.getUserObject() instanceof ITeam) {
				return (ITeam) this.tree.getSelectedItem().getParentItem()
						.getUserObject();
			}
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.ITeamView#updateTeamTreeData(java.util.HashSet)
	 */
	@Override
	public void updateTeamTreeData(HashSet<ITeam> teamSet) {
		this.tree.clear();
		for (ITeam team : teamSet) {
			TreeItem tItem = new TreeItem(team.toString());
			tItem.setUserObject(team);
			this.tree.addItem(tItem);
			for (IPerson person : team.getMembers()) {
				TreeItem pItem = new TreeItem(person.toString());
				pItem.setUserObject(person);
				pItem.setStyleName("TreeItem-leaf");
				tItem.addItem(pItem);
			}
			tItem.setState(true);

		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.ITeamView#updatePersonTableData(java.util.HashSet
	 * )
	 */
	@Override
	public void updatePersonTableData(HashSet<IPerson> personSet) {
		this.originalPersonList = personSet;
		this.personDataProvider.getList().clear();
		this.personDataProvider.getList().addAll(personSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.ITeamView#defineNewTeamEvent(fhdw.ipscrum.client
	 * .events.EventHandler)
	 */
	@Override
	public void defineNewTeamEvent(EventHandler<EventArgs> args) {
		this.newTeamEvent.add(args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.ITeamView#defineModifyTeamEvent(fhdw.ipscrum
	 * .client.events.EventHandler)
	 */
	@Override
	public void defineModifyTeamEvent(EventHandler<PersonTeamArgs> args) {
		this.modifyTeamEvent.add(args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.ITeamView#defineRemovePersonFromTeamEvent(fhdw
	 * .ipscrum.client.events.EventHandler)
	 */
	@Override
	public void defineRemovePersonFromTeamEvent(
			EventHandler<PersonTeamArgs> args) {
		this.removePersonFromTeamEvent.add(args);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.view.ITeamView#defineAddPersonToTeamEvent(fhdw.ipscrum
	 * .client.events.EventHandler)
	 */
	@Override
	public void defineAddPersonToTeamEvent(EventHandler<PersonTeamArgs> args) {
		this.addPersonToTeamEvent.add(args);
	}

}
