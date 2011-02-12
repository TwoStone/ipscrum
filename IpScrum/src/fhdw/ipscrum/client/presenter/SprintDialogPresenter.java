package fhdw.ipscrum.client.presenter;

import java.util.Iterator;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.view.SprintDialogView;
import fhdw.ipscrum.client.view.interfaces.ISprintDialogView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 */
public class SprintDialogPresenter extends Presenter<ISprintDialogView> {

	private ISprintDialogView concreteView;
	private ISprint sprint;

	/**
	 * Constructor for SprintDialogPresenter.
	 * @param parent Panel
	 */
	public SprintDialogPresenter(Panel parent) {
		this(parent, null);
	}

	/**
	 * Constructor for SprintDialogPresenter.
	 * @param parent Panel
	 * @param sprint ISprint
	 */
	public SprintDialogPresenter(Panel parent, ISprint sprint) {
		super(parent);
		this.sprint = sprint;
		this.initialize();
	}

	/**
	 * Method createView.
	 * @return ISprintDialogView
	 */
	@Override
	protected ISprintDialogView createView() {

		this.concreteView = new SprintDialogView();

		this.concreteView.addCancelHandler(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				abort();
			}
		});

		this.concreteView.addOkHandler(new EventHandler<SprintArgs>() {
			@Override
						
			public void onUpdate(Object sender, SprintArgs eventArgs) {
				if (SprintDialogPresenter.this.sprint == null) {
					SprintDialogPresenter.this.sprint = new Sprint(eventArgs.getSprint().getBegin(), eventArgs.getSprint().getEnd(), eventArgs.getSprint().getTeam());
					if (eventArgs.getSprint().getDescription() != null)
						SprintDialogPresenter.this.sprint.setDescription(eventArgs.getSprint().getDescription());
				} else {
					SprintDialogPresenter.this.sprint.setDescription(eventArgs.getSprint().getDescription());
					SprintDialogPresenter.this.sprint.setBegin(eventArgs.getSprint().getBegin());
					SprintDialogPresenter.this.sprint.setEnd(eventArgs.getSprint().getEnd());
					SprintDialogPresenter.this.sprint.setTeam(eventArgs.getSprint().getTeam());
				}

				finish();
			}
		});

		return this.concreteView;
	}

	private void initialize() {
		Iterator teamIterator = SessionManager.getInstance().getModel().getTeams().iterator();
		while(teamIterator.hasNext()){
			ITeam team = (ITeam) teamIterator.next();
			concreteView.getTeams().addItem(team.getDescription());
		}
		   
		
		if (this.sprint != null) {
			// TODO Hier Vorbelegungen anf�gen..
			this.concreteView.getDescription().setText(this.sprint.getDescription());
			this.concreteView.getStart().setValue(this.sprint.getBegin());
			this.concreteView.getEnd().setValue(this.sprint.getEnd());
			//this.concreteView.getTeams().setSelectedIndex();
		}
	}

	public ISprint getSprint() {
		return sprint;
	}
	
	
}
