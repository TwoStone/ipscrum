package fhdw.ipscrum.client.architecture.controller;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.PopupPanel.PositionCallback;

import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;

/**
 * Controls the display of questions from the presenters.
 */
public class QuestionController {

	/**
	 * Displays a question with the specified text and answers.
	 * 
	 * @param question
	 *            the question text
	 * @param answers
	 *            the possible answers
	 */
	public void askQuestion(final String question, final Answer... answers) {
		GWT.log("[QuestionController] Showing question: " + question);
		final QuestionDialog questionWidget = new QuestionDialog(question, answers);
		questionWidget.setPopupPositionAndShow(new PositionCallback() {

			@Override
			public void setPosition(final int offsetWidth, final int offsetHeight) {
				final int clientWidth = Window.getClientWidth();
				final int clientHeight = Window.getClientHeight();

				final int topPosition = (clientHeight - offsetHeight) / 2;
				final int leftPosition = (clientWidth - offsetWidth) / 2;

				questionWidget.setPopupPosition(leftPosition, topPosition);
			}
		});
	}

}
