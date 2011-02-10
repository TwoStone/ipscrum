package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.TextView;
import fhdw.ipscrum.client.view.interfaces.ITextView;
import fhdw.ipscrum.client.view.widgets.AbortDialog;
import fhdw.ipscrum.client.view.widgets.AbortDialog.OnOkayCommand;
import fhdw.ipscrum.shared.model.Hint;

public class HintPresenter extends Presenter<ITextView> {

	private final Hint hint;

	public HintPresenter(Panel parent) {
		this(parent, new Hint(""));
	}

	public HintPresenter(Panel parent, Hint hint) {
		super(parent);
		this.hint = hint;
		this.updateView(this.hint);
		this.registerViewEvents();
	}

	@Override
	protected ITextView createView() {
		final ITextView view = new TextView("Neuer Hinweis:");
		return view;
	}

	public Hint getHint() {
		return this.hint;
	}

	private void registerViewEvents() {
		this.getView().save().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				HintPresenter.this.save();
			}
		});

		this.getView().abort().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				new AbortDialog(new OnOkayCommand() {

					@Override
					public void onExecute() {
						HintPresenter.this.abort();
					}
				});
			}
		});
	}

	protected void save() {
		this.updateModel(this.hint);
		this.finish();
	}

	private void updateModel(Hint hint) {
		hint.setContent(this.getView().getContent());
	}

	private void updateView(Hint hint) {
		this.getView().setContent(hint.getContent());
	}

}
