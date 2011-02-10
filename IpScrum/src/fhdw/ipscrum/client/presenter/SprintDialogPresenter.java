package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.view.SprintDialogView;
import fhdw.ipscrum.client.view.interfaces.ISprintDialogView;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class SprintDialogPresenter extends Presenter<ISprintDialogView> {
	private ISprintDialogView concreteView;
	private ISprint sprint;

	public SprintDialogPresenter(Panel parent) {
		this(parent, null);
	}

	public SprintDialogPresenter(Panel parent, ISprint sprint) {
		super(parent);
		this.sprint = sprint;
		initialize();
	}

	@Override
	protected ISprintDialogView createView() {

		this.concreteView = new SprintDialogView();
		
		concreteView.addCancelHandler(new EventHandler<EventArgs>() {
			public void onUpdate(Object sender, EventArgs eventArgs) {
				abort();
			}
		});

		concreteView.addOkHandler(new EventHandler<SprintArgs>() {
			public void onUpdate(Object sender, SprintArgs eventArgs) {
				if (SprintDialogPresenter.this.sprint == null) {
					// TODO Neuen Sprint erstellen
				} else {
					// TODO bestehenden Sprint bearbeiten
					//SprintDialogPresenter.this.sprint.setBegin(eventArgs.getStart());
					//SprintDialogPresenter.this.sprint.setEnd(eventArgs.getEnd());
					///SprintDialogPresenter.this.sprint.setDescription(eventArgs.getDescription());
					SprintDialogPresenter.this.sprint.setTeam(eventArgs.getTeam());
				}

				finish();
			}
		});

		return concreteView;
	}
	
	private void initialize() {
		if (this.sprint != null) {
			// Editieren. Hier Vorbelegungen anfügen..
			this.concreteView.getDescription().setText(this.sprint.getName());
			// ...
		}
	}
}
