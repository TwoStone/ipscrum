package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.HashSet;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintDetailArgs;
import fhdw.ipscrum.client.view.SprintDialogView;
import fhdw.ipscrum.client.view.interfaces.ISprintDialogView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 * Represents the presenter of the view with which the user could make new
 * sprints or change sprints.
 */
public class SprintDialogPresenter extends Presenter<ISprintDialogView> {

	private ISprintDialogView concreteView;
	private ISprint sprint;

	/**
	 * Constructor for SprintDialogPresenter.
	 * 
	 * Required for changing sprints
	 * 
	 * @param parent
	 *            Panel
	 * @param sprint
	 *            ISprint
	 * @param parentPresenter
	 */
	public SprintDialogPresenter(final Panel parent, final ISprint sprint,
			final Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
		this.sprint = sprint;
		this.initialize();
	}

	/**
	 * Constructor for SprintDialogPresenter.
	 * 
	 * Required for making new sprints
	 * 
	 * @param parent
	 *            Panel
	 * @param parentPresenter
	 */
	public SprintDialogPresenter(final Panel parent,
			final Presenter<?> parentPresenter) {
		this(parent, null, parentPresenter);
	}

	/**
	 * Method createView.
	 * 
	 * Creates the view in which the user could make a new sprint or change a
	 * sprint and defines what happens when the user pushes the cancel- or
	 * OK-button.
	 * 
	 * @return ISprintDialogView
	 */
	@Override
	protected ISprintDialogView createView() {

		this.concreteView = new SprintDialogView();

		this.concreteView.addCancelHandler(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				SprintDialogPresenter.this.abort();
			}
		});

		this.concreteView.addOkHandler(new EventHandler<SprintDetailArgs>() {
			@Override
			public void onUpdate(final Object sender,
					final SprintDetailArgs eventArgs) {
				try {
					if (SprintDialogPresenter.this.sprint == null) {
						SprintDialogPresenter.this.sprint = new Sprint(
								eventArgs.getName(),
								eventArgs.getDescription(), eventArgs
										.getBeginDate(),
								eventArgs.getEndDate(), eventArgs.getTeam());
					} else {
						SprintDialogPresenter.this.sprint.setName(eventArgs
								.getName());
						SprintDialogPresenter.this.sprint
								.setDescription(eventArgs.getDescription());
						SprintDialogPresenter.this.sprint.setTimeFrame(
								eventArgs.getBeginDate(),
								eventArgs.getEndDate());
						SprintDialogPresenter.this.sprint.setTeam(eventArgs
								.getTeam());
					}
					SprintDialogPresenter.this.finish();
				} catch (final NoValidValueException e) {
					Window.alert(e.getMessage());
				}
			}
		});

		return this.concreteView;
	}

	public ISprint getSprint() {
		return this.sprint;
	}

	/**
	 * Method initialize.
	 * 
	 * Initializes the view with the values of the sprint chosen to change It
	 * also initializes the teams for the view.
	 */
	private void initialize() {
		final HashSet<ITeam> teamSet = SessionManager.getInstance().getModel()
				.getTeams();
		if (teamSet != null) {
			this.concreteView.fillComboBoxTeams(new ArrayList<ITeam>(teamSet));
		}

		if (this.sprint != null) {
			// Hier Vorbelegungen anfügen..
			this.concreteView.setName(this.sprint.getName());
			this.concreteView.setDescription(this.sprint.getDescription());
			this.concreteView.setStart(this.sprint.getBegin());
			this.concreteView.setEnd(this.sprint.getEnd());
			this.concreteView.setSelectedTeam(this.sprint.getTeam());
		}
	}
}
