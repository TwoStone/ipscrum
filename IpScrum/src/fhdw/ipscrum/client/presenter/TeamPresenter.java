package fhdw.ipscrum.client.presenter;

import java.util.HashSet;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.PersonTeamArgs;
import fhdw.ipscrum.client.view.TeamView;
import fhdw.ipscrum.client.view.interfaces.ITeamView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 * presenter class of the team interface. this interface is used to inspect,
 * create and modify teams as well as adding and removing persons to teams.
 */
public class TeamPresenter extends Presenter<ITeamView> {

	private ITeamView concreteView;

	/**
	 * Constructor for TeamPresenter.
	 * 
	 * @param parent
	 *            Panel
	 */
	public TeamPresenter(Panel parent) {
		super(parent);
	}

	/**
	 * Method createView.
	 * 
	 * @return ITeamView
	 */
	@Override
	protected ITeamView createView() {
		this.concreteView = new TeamView();
		this.updateGuiData();
		this.setupEventHandlers();
		return this.concreteView;
	}

	/**
	 * this is called to update or fill the entries in the
	 * gui-tables/tree-display.
	 */
	private void updateGuiData() {
		HashSet<IPerson> personSet = SessionManager.getInstance().getModel().getPersons();
		this.concreteView.updatePersonTableData(personSet);

		HashSet<ITeam> teamSet = SessionManager.getInstance().getModel().getTeams();
		this.concreteView.updateTeamTreeData(teamSet);

	}

	/**
	 * this is called to set up the behaviour of all interaction widgets of this
	 * view.
	 */
	private void setupEventHandlers() {

		this.concreteView.defineNewTeamEvent(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				final DialogBox box = new DialogBox();
				final TeamDialogPresenter presenter = new TeamDialogPresenter(box);
				box.setAnimationEnabled(true);
				box.setAutoHideEnabled(true);
				box.setGlassEnabled(true);
				box.setText(TextConstants.TEAMDIALOG_TITLE_CREATE);

				presenter.getFinished().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						TeamPresenter.this.updateGuiData();
						box.hide();
					}
				});

				presenter.getAborted().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						box.hide();
					}
				});
				box.center();
			}
		});

		this.concreteView.defineModifyTeamEvent(new EventHandler<PersonTeamArgs>() {
			@Override
			public void onUpdate(Object sender, PersonTeamArgs eventArgs) {
				final DialogBox box = new DialogBox();
				final TeamDialogPresenter presenter = new TeamDialogPresenter(box, eventArgs.getTeam());
				box.setAnimationEnabled(true);
				box.setAutoHideEnabled(true);
				box.setGlassEnabled(true);
				box.setText("Team " + eventArgs.getTeam().getDescription() + " bearbeiten");

				presenter.getFinished().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						TeamPresenter.this.updateGuiData();
						box.hide();
					}
				});

				presenter.getAborted().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						box.hide();
					}
				});
				box.center();
			}
		});

		this.concreteView.defineRemovePersonFromTeamEvent(new EventHandler<PersonTeamArgs>() {
			@Override
			public void onUpdate(Object sender, PersonTeamArgs eventArgs) {
				for (IPerson person : eventArgs.getPersons()) {
					try {
						eventArgs.getTeam().removeMember(person);
					} catch (ConsistencyException e) {
						abort();
					}
					TeamPresenter.this.updateGuiData();
				}
			}
		});

		this.concreteView.defineAddPersonToTeamEvent(new EventHandler<PersonTeamArgs>() {
			@Override
			public void onUpdate(Object sender, PersonTeamArgs eventArgs) {
				for (IPerson person : eventArgs.getPersons()) {
					try {
						eventArgs.getTeam().addMember(person);
					} catch (ConsistencyException e) {
						abort();
					}
					TeamPresenter.this.updateGuiData();
				}
			}
		});
	}
}
