package fhdw.ipscrum.client.view.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

import fhdw.ipscrum.shared.constants.TextConstants;

public class AbortDialog {
	public static interface OnOkayCommand {
		void onExecute();
	}

	public AbortDialog(final OnOkayCommand command) {
		final QuestionDialog question = new QuestionDialog(TextConstants.ABORT_QUESTION,
				TextConstants.ABORT_QUESTION_LONG);
		question.getOkayButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				command.onExecute();
			}
		});
		question.center();
	}

}
