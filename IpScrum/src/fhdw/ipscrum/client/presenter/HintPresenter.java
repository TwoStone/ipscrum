package fhdw.ipscrum.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.interfaces.ITextView;
import fhdw.ipscrum.shared.model.Hint;

public class HintPresenter extends Presenter<ITextView> {

	private final Hint hint;
	
	public Hint getHint() {
		return hint;
	}

	public HintPresenter(Panel parent, Hint hint) {
		super(parent);
		this.hint = hint;
		this.updateView(this.hint);
		this.registerViewEvents();
	}
	
	private void updateView(Hint hint) {
		this.getView().getContent().setText(hint.getContent());
	}
	
	private void updateModel(Hint hint) {
		hint.setContent(this.getView().getContent().getText());
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
				abort();
			}
		});
	}

	protected void save() {
		updateModel(this.hint);
		finish();
	}

	public HintPresenter(Panel parent) {
		this(parent, new Hint(""));
	}

	@Override
	protected ITextView createView() {
		// TODO Auto-generated method stub
		return null;
	}



}
