package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.OneStringArgs;
import fhdw.ipscrum.client.view.TeamDialogView;
import fhdw.ipscrum.client.view.interfaces.ITeamDialogView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.ITeam;


/**
 */
public class TeamDialogPresenter extends Presenter<ITeamDialogView> {

	private ITeamDialogView concreteView;
	private final ITeam team;

	/**
	 * Constructor for TeamDialogPresenter.
	 * @param parent Panel
	 * 
	 * Required for making new teams.
	 */
	public TeamDialogPresenter(Panel parent) {
		this(parent, null);
	}

	/**
	 * Constructor for TeamDialogPresenter.
	 * @param parent Panel
	 * @param selectedTeam ITeam
	 * 
	 * Required for changing teams.
	 */
	public TeamDialogPresenter(Panel parent, ITeam selectedTeam) {
		super(parent);
		this.team = selectedTeam;
		initialize();
	}

	/**
	 * Method createView.
	 * @return ITeamDialogView
	 * 
	 * Creates the view in which the user could make a new team or change a team 
	 * and defines what happens when the user pushes the cancel- or OK-button.
	 * 
	 */
	@Override
	protected ITeamDialogView createView() {
		this.concreteView = new TeamDialogView();

		this.concreteView.addCancelEventHandler(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				abort();
			}
		});

		this.concreteView.addOkEventHandler(new EventHandler<OneStringArgs>() {
			@Override
			public void onUpdate(Object sender, OneStringArgs eventArgs) {
				if (TeamDialogPresenter.this.team == null) {
					SessionManager.getInstance().getModel().addTeam(new Team(eventArgs.getString()));
				} else {
					TeamDialogPresenter.this.team.setDescription(eventArgs.getString());
				}

				finish();
			}
		});
		return this.concreteView;
	}

	/**
	 * Initializes the view with the values of the team chosen to change.
	 */
	private void initialize() {
		if (this.team != null) {
			this.concreteView.getTeamDescription().setText(this.team.getDescription());
		}
	}

}
