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
	private final ISprint sprint;

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
					// TODO neuen Sprint (eventArgs.getSprint()) anfügen.
				} else {
					// TODO bestehenden Sprint (this.sprint) mit Wetten aus temporärem Sprint (eventArgs.getSprint()) überschreiben.
				}

				finish();
			}
		});

		return this.concreteView;
	}

	private void initialize() {
		if (this.sprint != null) {
			// TODO Hier Vorbelegungen anfügen..
			this.concreteView.getDescription().setText(this.sprint.getName());
			// ...
		}
	}
}
