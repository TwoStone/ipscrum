package fhdw.ipscrum.client.resources.css;

import com.google.gwt.resources.client.CssResource;

public interface QuestionWidget extends CssResource {

	@ClassName("question-widget")
	String questionWidget();

	@ClassName("answer-button")
	String getAnswerButton();

	@ClassName("question-label")
	String getLabel();

	@ClassName("question-widget-glass")
	String getGlassStyle();

}
