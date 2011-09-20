package fhdw.ipscrum.client.resources.css;

import com.google.gwt.resources.client.CssResource;

/**
 * Represents the css resource of the questionWidget.
 */
public interface QuestionWidget extends CssResource {

	/**
	 * @return the css of the question widget.
	 */
	@ClassName("question-widget")
	String questionWidget();

	/**
	 * @return the css of the answer button.
	 */
	@ClassName("answer-button")
	String getAnswerButton();

	/**
	 * @return the css of the question label.
	 */
	@ClassName("question-label")
	String getLabel();

	/**
	 * @return the css of the question widget glass.
	 */
	@ClassName("question-widget-glass")
	String getGlassStyle();

}
