package fhdw.ipscrum.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.interfaces.ITextView;
import fhdw.ipscrum.client.view.widgets.QuestionDialog;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;

public class AcceptanceCriterionPresenter extends Presenter<ITextView> {

	final private AcceptanceCriterion criterion;
	
	public AcceptanceCriterion getCriterion() {
		return criterion;
	}

	public AcceptanceCriterionPresenter(Panel parent) {
		this(parent, new AcceptanceCriterion(""));
	}
	
	public AcceptanceCriterionPresenter(Panel parent, AcceptanceCriterion criterion) {
		super(parent);
		this.criterion = criterion;
		updateView(criterion);
		this.registerViewEvents();
	}

	private void updateView(AcceptanceCriterion criterion) {
		this.getView().getContent().setText(criterion.getContent());		
	}
	
	private void updateModel(AcceptanceCriterion criterion) {
		criterion.setContent(this.getView().getContent().getText());
	}
	
	private void registerViewEvents() {
		this.getView().getSave().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				save();
			}
		});
		
		this.getView().getAbort().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				QuestionDialog question = new QuestionDialog("Abbrechen?", "Wollen sie den Vorgang wirklich abbrechen?");
				question.getAbortButton().addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
					}
				});
				question.getOkayButton().addClickHandler(new ClickHandler() {
					
					@Override
					public void onClick(ClickEvent event) {
						AcceptanceCriterionPresenter.this.abort();
					}
				});
				question.center();
			}
		});
	}
	

	private void save() {
		updateModel(this.criterion);
		finish();
	}

	@Override
	protected ITextView createView() {
		return null;
	}

}
