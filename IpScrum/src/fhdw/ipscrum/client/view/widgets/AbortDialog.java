package fhdw.ipscrum.client.view.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class AbortDialog {
	public static interface OnOkayCommand {
		void onExecute();
	}

	public AbortDialog(final OnOkayCommand command) {
		final QuestionDialog question = new QuestionDialog("Abbrechen?",
				"Wollen sie den Vorgang wirklich abbrechen?");
		question.getOkayButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				command.onExecute();
			}
		});
		question.center();
	}

}
