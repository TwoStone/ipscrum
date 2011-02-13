package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.TextView;
import fhdw.ipscrum.client.view.interfaces.ITextView;
import fhdw.ipscrum.client.view.widgets.AbortDialog;
import fhdw.ipscrum.client.view.widgets.AbortDialog.OnOkayCommand;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.Hint;

/**
 * Class for presenting {@link Hint} objects.
 * 
 * @author n.w.
 * 
 */
public class HintPresenter extends Presenter<ITextView> {

	private final Hint hint;

	/**
	 * Creates a new instance of {@link HintPresenter}. Use this constructor to
	 * create a new {@link Hint} object.
	 * 
	 * @param parent
	 */
	public HintPresenter(final Panel parent) {
		this(parent, new Hint(""));
	}

	/**
	 * Creates a new instance of {@link HintPresenter}. Use this constructor to
	 * display an existing {@link Hint} object.
	 * 
	 * @param parent
	 * @param hint
	 */
	public HintPresenter(final Panel parent, final Hint hint) {
		super(parent);
		this.hint = hint;
		this.updateView(this.hint);
		this.registerViewEvents();
	}

	@Override
	protected ITextView createView() {
		final ITextView view = new TextView(TextConstants.NEW_HINT_LABEL);
		return view;
	}

	/**
	 * Returns the current displayed {@link Hint} object.
	 * 
	 * @return
	 */
	public Hint getHint() {
		return this.hint;
	}

	private void registerViewEvents() {
		this.getView().save().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				HintPresenter.this.save();
			}
		});

		this.getView().abort().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
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

	private void updateModel(final Hint hint) {
		hint.setContent(this.getView().getContent());
	}

	private void updateView(final Hint hint) {
		this.getView().setContent(hint.getContent());
	}

}
