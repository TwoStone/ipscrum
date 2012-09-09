package fhdw.ipscrum.client.view;

import java.util.List;
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
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.MultiSelectionModel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.eventargs.PersonTeamArgs;
import fhdw.ipscrum.client.viewinterfaces.ITeamView;
import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.Role;
import fhdw.ipscrum.shared.model.nonMeta.Team;

/**
 * view class of the team interface. this composes the team management gui. this view is used to inspect, create and
 * modify teams as well as adding and removing persons to teams.
 */
public class TeamView extends MasterView implements ITeamView {

	private Tree tree;
	private final DefaultEvent newTeamEvent = new DefaultEvent();
	private final Event<PersonTeamArgs> modifyTeamEvent = new Event<PersonTeamArgs>();
	private final Event<TypedEventArg<Team>> velocityChartEvent = new Event<TypedEventArg<Team>>();
	private final Event<PersonTeamArgs> addPersonToTeamEvent = new Event<PersonTeamArgs>();
	private final Event<PersonTeamArgs> removePersonFromTeamEvent = new Event<PersonTeamArgs>();
	private final Event<TypedEventArg<Team>> addProjects = new Event<TypedEventArg<Team>>();

	private MultiSelectionModel<Person> selModelPersonTable;

	private ListDataProvider<Person> personDataProvider;
	private List<Person> originalPersonList;
	private Button btnTeamBearbeiten;
	private Button btnNeuesTeamAnlegen;
	private Button btnProjects;

	/**
	 * constructor of the TeamView.
	 */
	public TeamView() {
		super();

		this.personDataProvider = new ListDataProvider<Person>();

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		this.add(horizontalPanel);

		final VerticalPanel verticalPanelTeams = new VerticalPanel();
		horizontalPanel.add(verticalPanelTeams);

		final Label lblTeams = new Label(TextConstants.TEAMVIEW_TEAMTABLEHEADER);
		verticalPanelTeams.add(lblTeams);

		final ScrollPanel scrollPanelTeamTree = new ScrollPanel();
		scrollPanelTeamTree.setStyleName("tableBorder");
		verticalPanelTeams.add(scrollPanelTeamTree);
		scrollPanelTeamTree.setSize("256px", "400px");

		this.tree = new Tree();
		this.tree.addSelectionHandler(new SelectionHandler<TreeItem>() {
			@Override
			public void onSelection(final SelectionEvent<TreeItem> event) {
				TeamView.this.updateGuiToSelectionChange();
			}
		});
		scrollPanelTeamTree.setWidget(this.tree);
		this.tree.setAnimationEnabled(true);
		this.tree.setSize("100%", "100%");

		final HorizontalPanel horizontalPanelTeamButtons = new HorizontalPanel();
		verticalPanelTeams.add(horizontalPanelTeamButtons);
		horizontalPanelTeamButtons.setWidth("100%");

		this.btnNeuesTeamAnlegen = new Button(TextConstants.TEAMVIEW_BUTTONLABEL_CREATENEWTEAM);
		this.btnNeuesTeamAnlegen.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				TeamView.this.newTeamEvent.fire(TeamView.this, new EventArgs());
			}
		});
		horizontalPanelTeamButtons.add(this.btnNeuesTeamAnlegen);
		this.btnNeuesTeamAnlegen.setWidth("100%");

		this.btnTeamBearbeiten = new Button(TextConstants.TEAMVIEW_BUTTONLABEL_MODIFYTEAM);
		this.btnTeamBearbeiten.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				if (TeamView.this.getSelectedTeamOfTree() != null) {
					TeamView.this.modifyTeamEvent.fire(TeamView.this,
							new PersonTeamArgs(TeamView.this.getSelectedTeamOfTree()));
				}
			}
		});
		horizontalPanelTeamButtons.add(this.btnTeamBearbeiten);
		this.btnTeamBearbeiten.setWidth("100%");

		final HorizontalPanel team2Buttons = new HorizontalPanel();
		verticalPanelTeams.add(team2Buttons);
		team2Buttons.setWidth("100%");

		final Button btnVelocity = new Button("Velocity-Analyse");
		team2Buttons.add(btnVelocity);
		btnVelocity.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				if (TeamView.this.getSelectedTeamOfTree() != null) {
					TeamView.this.velocityChartEvent.fire(TeamView.this,
							new TypedEventArg<Team>(TeamView.this.getSelectedTeamOfTree()));
				}
			}
		});
		btnVelocity.setWidth("100%");

		this.btnProjects = new Button("Projekte zuordnen");
		team2Buttons.add(this.btnProjects);
		this.btnProjects.setWidth("100%");
		this.btnProjects.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {

				TeamView.this.addProjects.fire(TeamView.this,
						new TypedEventArg<Team>(TeamView.this.getSelectedTeamOfTree()));

			}
		});

		final VerticalPanel verticalPanelAllocationButtons = new VerticalPanel();
		verticalPanelAllocationButtons.setStyleName("allocationButtonPanel");
		horizontalPanel.add(verticalPanelAllocationButtons);

		final Button btnRemovePersonFromTeam = new Button(TextConstants.BUTTONLABEL_REMOVE);
		btnRemovePersonFromTeam.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				if (TeamView.this.getSelectedPersonOfTree() != null && TeamView.this.getSelectedTeamOfTree() != null) { // does
																														// not
																														// work
																														// sometimes..
					TeamView.this.removePersonFromTeamEvent.fire(
							TeamView.this,
							new PersonTeamArgs(TeamView.this.getSelectedPersonOfTree(), TeamView.this
									.getSelectedTeamOfTree()));
				}
			}
		});
		verticalPanelAllocationButtons.add(btnRemovePersonFromTeam);

		final Button btnAddPersonToTeam = new Button(TextConstants.BUTTONLABEL_ASSIGN);
		btnAddPersonToTeam.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				if (TeamView.this.selModelPersonTable.getSelectedSet().size() > 0
						&& TeamView.this.getSelectedTeamOfTree() != null) {
					TeamView.this.addPersonToTeamEvent.fire(TeamView.this, new PersonTeamArgs(
							TeamView.this.selModelPersonTable.getSelectedSet(), TeamView.this.getSelectedTeamOfTree()));
				} else {
					Window.alert(ExceptionConstants.GUI_TEAMVIEW_ASSIGNERROR);
				}
			}
		});
		verticalPanelAllocationButtons.add(btnAddPersonToTeam);

		final VerticalPanel verticalPanelPersons = new VerticalPanel();
		horizontalPanel.add(verticalPanelPersons);

		final Label lblVerfgbarePersonen = new Label(TextConstants.TEAMVIEW_PERSONTABLEHEADER);
		verticalPanelPersons.add(lblVerfgbarePersonen);

		final ScrollPanel scrollPanel = new ScrollPanel();
		scrollPanel.setStyleName("tableBorder");
		verticalPanelPersons.add(scrollPanel);
		scrollPanel.setSize("450px", "456px");

		final CellTable<Person> cellTablePersons = new CellTable<Person>();
		this.personDataProvider.addDataDisplay(cellTablePersons);
		scrollPanel.setWidget(cellTablePersons);
		cellTablePersons.setSize("100%", "100%");
		this.selModelPersonTable = new MultiSelectionModel<Person>(this.personDataProvider);
		cellTablePersons.setSelectionModel(this.selModelPersonTable);

		final TextColumn<Person> colFirstname = new TextColumn<Person>() {
			@Override
			public String getValue(final Person object) {
				return object.getFirstname();
			}
		};
		cellTablePersons.addColumn(colFirstname, TextConstants.PERSROLEMNGMT_PERSONTABLE_COL_FIRSTNAME);

		final TextColumn<Person> colLastname = new TextColumn<Person>() {
			@Override
			public String getValue(final Person object) {
				return object.getLastname();
			}
		};
		cellTablePersons.addColumn(colLastname, TextConstants.PERSROLEMNGMT_PERSONTABLE_COL_LASTNAME);

		final TextColumn<Person> colRoles = new TextColumn<Person>() {
			@Override
			public void render(final Context context, final Person object, final SafeHtmlBuilder sb) {
				for (final Role role : object.getRoles()) {
					sb.appendHtmlConstant(role.toString() + "<br />");
				}
			}

			@Override
			public String getValue(final Person object) {
				return object.getRoles().toString();
			}
		};
		cellTablePersons.addColumn(colRoles, TextConstants.TEAMVIEW_ROLESHEADER);
	}

	/**
	 * This method is called when the team-selection changes. It updates the person-table to just show availabe persons.
	 */
	private void updateGuiToSelectionChange() {
		final Vector<Person> personsToHide = this.getSelectedTeamOfTree().getMembers();
		this.personDataProvider.getList().clear();
		this.personDataProvider.getList().addAll(this.originalPersonList);
		this.personDataProvider.getList().removeAll(personsToHide);
		// personsToShow.removeAll(personsToHide);
		//
		// this.cellTablePersons.setRowData(new
		// ArrayList<Person>(personsToShow));
	}

	@Override
	public Person getSelectedPersonOfTree() {
		if (this.tree.getSelectedItem() != null) {
			final Object selItem = this.tree.getSelectedItem().getUserObject();
			if (selItem instanceof Person) {
				return (Person) selItem;
			}
		}
		return null;
	}

	@Override
	public Team getSelectedTeamOfTree() {
		if (this.tree.getSelectedItem() != null) {
			final Object selItem = this.tree.getSelectedItem().getUserObject();
			Team result = null;
			if (selItem instanceof Team) {
				result = (Team) selItem;
			} else if (selItem instanceof Person
					&& this.tree.getSelectedItem().getParentItem().getUserObject() instanceof Team) {
				result = (Team) this.tree.getSelectedItem().getParentItem().getUserObject();
			}
			return result;
		}
		return null;
	}

	@Override
	public void updateTeamTreeData(final List<Team> teamSet) {
		this.tree.clear();
		for (final Team team : teamSet) {
			final TreeItem tItem = new TreeItem(team.toString());
			tItem.setUserObject(team);
			this.tree.addItem(tItem);
			for (final Person person : team.getMembers()) {
				final TreeItem pItem = new TreeItem(person.toString());
				pItem.setUserObject(person);
				pItem.setStyleName("TreeItem-leaf");
				tItem.addItem(pItem);
			}
			tItem.setState(true);

		}
	}

	@Override
	public void updatePersonTableData(final List<Person> personSet) {
		this.originalPersonList = personSet;
		this.personDataProvider.getList().clear();
		this.personDataProvider.getList().addAll(personSet);
	}

	@Override
	public void defineNewTeamEvent(final DefaultEventHandler handler) {
		this.newTeamEvent.add(handler);
	}

	@Override
	public void defineModifyTeamEvent(final EventHandler<PersonTeamArgs> args) {
		this.modifyTeamEvent.add(args);
	}

	@Override
	public void defineVelocityChartEvent(final EventHandler<TypedEventArg<Team>> handler) {
		this.velocityChartEvent.add(handler);
	}

	@Override
	public void defineAddPersonToTeamEvent(final EventHandler<PersonTeamArgs> args) {
		this.addPersonToTeamEvent.add(args);
	}

	@Override
	public void defineRemovePersonFromTeamEvent(final EventHandler<PersonTeamArgs> args) {
		this.removePersonFromTeamEvent.add(args);
	}

	@Override
	public void close() {
		this.addPersonToTeamEvent.removeAllHandler();
		this.modifyTeamEvent.removeAllHandler();
		this.newTeamEvent.removeAllHandler();
		this.removePersonFromTeamEvent.removeAllHandler();

	}

	@Override
	public void defineAddProjectsEvent(final EventHandler<TypedEventArg<Team>> handler) {
		this.addProjects.add(handler);

	}

	@Override
	public void setRightVisibility(final Boolean value) {
		this.getBtnNeuesTeamAnlegen().setEnabled(value);
		this.getBtnTeamBearbeiten().setEnabled(value);
		this.getBtnProjects().setEnabled(value);

	}

	protected Button getBtnTeamBearbeiten() {
		return this.btnTeamBearbeiten;
	}

	protected Button getBtnNeuesTeamAnlegen() {
		return this.btnNeuesTeamAnlegen;
	}

	protected Button getBtnProjects() {
		return this.btnProjects;
	}
}
