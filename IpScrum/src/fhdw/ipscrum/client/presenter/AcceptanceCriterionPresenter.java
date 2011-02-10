package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.TextView;
import fhdw.ipscrum.client.view.interfaces.ITextView;
import fhdw.ipscrum.client.view.widgets.AbortDialog;
import fhdw.ipscrum.client.view.widgets.AbortDialog.OnOkayCommand;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;

public class AcceptanceCriterionPresenter extends Presenter<ITextView> {

	final private AcceptanceCriterion criterion;

	public AcceptanceCriterionPresenter(Panel parent) {
		this(parent, new AcceptanceCriterion(""));
	}

	public AcceptanceCriterionPresenter(Panel parent,
			AcceptanceCriterion criterion) {
		super(parent);
		this.criterion = criterion;
		this.updateView(criterion);
		this.registerViewEvents();
	}

	@Override
	protected ITextView createView() {
		return new TextView("Neues \n Akzeptanzkriterium:");
	}

	public AcceptanceCriterion getCriterion() {
		return this.criterion;
	}

	private void registerViewEvents() {

		this.getView().save().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				AcceptanceCriterionPresenter.this.save();
			}
		});
		this.getView().abort().add(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				new AbortDialog(new OnOkayCommand() {

					@Override
					public void onExecute() {
						AcceptanceCriterionPresenter.this.abort();
					}
				});
			}
		});
	}

	private void save() {
		this.updateModel(this.criterion);
		this.finish();
	}

	private void updateModel(AcceptanceCriterion criterion) {
		criterion.setContent(this.getView().getContent());
	}

	private void updateView(AcceptanceCriterion criterion) {
		this.getView().setContent(criterion.getContent());
	}

}
