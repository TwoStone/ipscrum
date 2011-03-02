package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.OneStringArgs;
import fhdw.ipscrum.client.view.TeamDialogView;
import fhdw.ipscrum.client.view.interfaces.ITeamDialogView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Team;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 * Represents the presenter of the view which is used to modify or create new
 * teams.
 */
public class TeamDialogPresenter extends Presenter<ITeamDialogView> {

	private ITeamDialogView concreteView;
	private final ITeam team;

	/**
	 * Constructor for TeamDialogPresenter.
	 * 
	 * Used for changing teams.
	 * 
	 * @param parent
	 *            Panel
	 * @param selectedTeam
	 *            ITeam
	 * @param parentPresenter
	 * 
	 */
	public TeamDialogPresenter(final Panel parent, final ITeam selectedTeam,
			final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
		this.team = selectedTeam;
		this.initialize();
	}

	/**
	 * Constructor for TeamDialogPresenter.
	 * 
	 * Used for making new teams.
	 * 
	 * @param parent
	 *            Panel
	 * @param parentPresenter
	 * 
	 */
	public TeamDialogPresenter(final Panel parent,
			final Presenter<?> parentPresenter) {
		this(parent, null, parentPresenter);
	}

	/**
	 * Method createView.
	 * 
	 * Creates the view in which the user could make a new team or change a team
	 * and defines what happens when the user pushes the cancel- or OK-button.
	 * 
	 * @return ITeamDialogView
	 * 
	 * 
	 */
	@Override
	protected ITeamDialogView createView() {
		this.concreteView = new TeamDialogView();

		this.concreteView.addCancelEventHandler(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				TeamDialogPresenter.this.abort();
			}
		});

		this.concreteView.addOkEventHandler(new EventHandler<OneStringArgs>() {
			@Override
			public void onUpdate(final Object sender,
					final OneStringArgs eventArgs) {
				try {
					if (TeamDialogPresenter.this.team == null) {
						SessionManager.getInstance().getModel()
								.addTeam(new Team(eventArgs.getString()));

					} else {
						TeamDialogPresenter.this.team.setDescription(eventArgs
								.getString());
					}
					TeamDialogPresenter.this.finish();
				} catch (final NoValidValueException e) {
					Window.alert(e.getMessage());
				} catch (final DoubleDefinitionException e) {
					Window.alert(e.getMessage());
				}

			}
		});
		return this.concreteView;
	}

	/**
	 * Initializes the view with the values of the team chosen to change.
	 */
	private void initialize() {
		if (this.team != null) {
			this.concreteView.setTeamDescription(this.team.getDescription());
		}
	}

}
