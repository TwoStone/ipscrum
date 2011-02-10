package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.view.SprintDialogView;
import fhdw.ipscrum.client.view.interfaces.ISprintDialogView;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class SprintDialogPresenter extends Presenter<ISprintDialogView> {
	final ISprintDialogView view = new SprintDialogView();
	private ISprint sprint;

	public SprintDialogPresenter(Panel parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}

	public SprintDialogPresenter(Panel parent, ISprint sprint) {
		super(parent);
		this.sprint = sprint;
	}

	@Override
	protected ISprintDialogView createView() {

		view.addCancelHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				abort();
			}
		});

		view.addOkHandler(new EventHandler<SprintArgs>() {

			@Override
			public void onUpdate(Object sender, SprintArgs eventArgs) {
				
				if (SprintDialogPresenter.this.sprint == null) {
					
				} else {
					//SprintDialogPresenter.this.sprint.setBegin(eventArgs.getStart());
					//SprintDialogPresenter.this.sprint.setEnd(eventArgs.getEnd());
					///SprintDialogPresenter.this.sprint.setDescription(eventArgs.getDescription());
					SprintDialogPresenter.this.sprint.setTeam(eventArgs.getTeam());
				}
				
				

				// Sprint sprint = new Sprint(startdate, enddate, team);
				finish();
			}
		});

		return view;
	}

}
