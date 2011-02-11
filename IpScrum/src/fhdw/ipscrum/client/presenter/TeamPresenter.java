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
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

public class TeamPresenter extends Presenter<ITeamView> {

	private ITeamView concreteView;

	public TeamPresenter(Panel parent) {
		super(parent);
	}


	@Override
	protected ITeamView createView() {
		this.concreteView = new TeamView();
		this.updateGuiData();
		this.setupEventHandlers();
		return this.concreteView;
	}


	private void updateGuiData() {
		HashSet<IPerson> personSet = SessionManager.getInstance().getModel().getPersons();
		this.concreteView.updatePersonTableData(personSet);

		HashSet<ITeam> teamSet = SessionManager.getInstance().getModel().getTeams();
		this.concreteView.updateTeamTreeData(teamSet);

	}

	private void setupEventHandlers() {

		this.concreteView.defineNewTeamEvent(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				final DialogBox box = new DialogBox();
				final TeamDialogPresenter presenter = new TeamDialogPresenter(box);
				box.setAnimationEnabled(true);
				box.setAutoHideEnabled(true);
				box.setGlassEnabled(true);
				box.setText("Neues Team anlegen");

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
				box.setText(eventArgs.getTeam().getDescription() + " bearbeiten");

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
					eventArgs.getTeam().removeMember(person);
					TeamPresenter.this.updateGuiData();
				}
			}
		});

		this.concreteView.defineAddPersonToTeamEvent(new EventHandler<PersonTeamArgs>() {
			@Override
			public void onUpdate(Object sender, PersonTeamArgs eventArgs) {
				for (IPerson person : eventArgs.getPersons()) {
					eventArgs.getTeam().addMember(person);
					TeamPresenter.this.updateGuiData();
				}
			}
		});


	}


}
