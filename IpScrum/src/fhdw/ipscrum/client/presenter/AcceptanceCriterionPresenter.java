package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.TextView;
import fhdw.ipscrum.client.view.interfaces.ITextView;
import fhdw.ipscrum.client.view.widgets.AbortDialog;
import fhdw.ipscrum.client.view.widgets.AbortDialog.OnOkayCommand;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;

/**
 * Class for Presenting {@link AcceptanceCriterion} objects.
 * 
 * @author n.w.
 */
public class AcceptanceCriterionPresenter extends Presenter<ITextView> {

	final private AcceptanceCriterion criterion;

	/**
	 * Creates an instance of {@link AcceptanceCriterionPresenter}. Use this
	 * constructor to create a new {@link AcceptanceCriterion} object.
	 * 
	 * @param parent
	 *            {@link Panel}
	 */
	public AcceptanceCriterionPresenter(final Panel parent) {
		this(parent, new AcceptanceCriterion(TextConstants.EMPTY_TEXT));
	}

	/**
	 * Creates an instance of {@link AcceptanceCriterionPresenter}. Use this
	 * constructor to display an existing {@link AcceptanceCriterion} object.
	 * 
	 * @param parent
	 *            {@link Panel}
	 * @param criterion
	 *            {@link AcceptanceCriterion}
	 */
	public AcceptanceCriterionPresenter(final Panel parent,
			final AcceptanceCriterion criterion) {
		super(parent);
		this.criterion = criterion;
		this.updateView(criterion);
		this.registerViewEvents();
	}

	@Override
	protected ITextView createView() {
		return new TextView(TextConstants.NEW_CRITERION_LABEL);
	}

	/**
	 * Returns the currently displayed {@link AcceptanceCriterion}.
	 * 
	 * @return {@link AcceptanceCriterion}
	 */
	public AcceptanceCriterion getCriterion() {
		return this.criterion;
	}

	/**
	 * Registers the presenter to events fired by the view.
	 */
	private void registerViewEvents() {

		this.getView().save().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				AcceptanceCriterionPresenter.this.finish();
			}
		});
		this.getView().abort().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				new AbortDialog(new OnOkayCommand() {

					@Override
					public void onExecute() {
						AcceptanceCriterionPresenter.this.abort();
					}
				});
			}
		});
	}

	@Override
	protected boolean onFinish() {
		this.updateModel(this.criterion);
		return super.onFinish();
	}

	/**
	 * Updates the {@link AcceptanceCriterion} with values from the view.
	 * 
	 * @param criterion
	 *            {@link AcceptanceCriterion}
	 */
	private void updateModel(final AcceptanceCriterion criterion) {
		criterion.setContent(this.getView().getContent());
	}

	/**
	 * Updates the view with the values of the criterion.
	 * 
	 * @param criterion
	 *            {@link AcceptanceCriterion}
	 */
	private void updateView(final AcceptanceCriterion criterion) {
		this.getView().setContent(criterion.getContent());
	}

}
