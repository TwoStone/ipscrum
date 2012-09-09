package fhdw.ipscrum.client.architecture.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.query.client.Function;
import com.google.gwt.query.client.GQuery;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.resources.MyResources;

/**
 * represents a question dialog which pops up if the user should be question if something is right or not.
 */
public class QuestionDialog extends PopupPanel {
	private final VerticalPanel buttonPanel;

	static {
		MyResources.INSTANCE.questionWidget().ensureInjected();
	}

	/**
	 * constructor of the QuestionDialog.
	 * 
	 * @param question
	 *            asked to the user
	 * @param actions
	 *            are the answers the user could give
	 */
	public QuestionDialog(final String question, final Answer... actions) {
		super(true);
		this.setAutoHideOnHistoryEventsEnabled(false);
		this.setStyleName(MyResources.INSTANCE.questionWidget().questionWidget());
		this.setModal(true);
		this.setAutoHideEnabled(false);
		this.setGlassEnabled(true);
		this.setGlassStyleName(MyResources.INSTANCE.questionWidget().getGlassStyle());

		final VerticalPanel verticalPanel = new VerticalPanel();
		this.setWidget(verticalPanel);
		verticalPanel.setSize("100%", "100px");

		final Label questionLabel = new Label(question);
		questionLabel.setStyleName(MyResources.INSTANCE.questionWidget().getLabel());
		verticalPanel.add(questionLabel);
		verticalPanel.setCellVerticalAlignment(questionLabel, HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel.setCellHorizontalAlignment(questionLabel, HasHorizontalAlignment.ALIGN_CENTER);

		this.buttonPanel = new VerticalPanel();
		this.buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		this.buttonPanel.setSpacing(3);
		this.buttonPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		verticalPanel.add(this.buttonPanel);
		verticalPanel.setCellHorizontalAlignment(this.buttonPanel, HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setCellWidth(this.buttonPanel, "100%");
		this.buttonPanel.setWidth("");
		verticalPanel.setCellVerticalAlignment(this.buttonPanel, HasVerticalAlignment.ALIGN_BOTTOM);

		for (final Answer action : actions) {
			final Button actionButton = new Button(action.getCaption());
			actionButton.setStyleName(MyResources.INSTANCE.questionWidget().getAnswerButton());
			actionButton.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(final ClickEvent event) {
					QuestionDialog.this.hide();
					action.onAction(QuestionDialog.this);
				}
			});
			this.buttonPanel.add(actionButton);
		}

	}

	@Override
	public void hide() {
		final GQuery widget = GQuery.$(this);
		final int height = widget.height();

		widget.animate("top: '-=" + height + "px' , visibility: hidden, opacity: '0'", 500, new Function() {
			@Override
			public void f() {
				QuestionDialog.super.hide();
			}
		});
	}

	@Override
	public void setPopupPositionAndShow(final PositionCallback callback) {
		super.setPopupPositionAndShow(callback);
		final GQuery element = GQuery.$(QuestionDialog.this);
		final int outerHeight = element.outerHeight();
		element.hide();
		final int popupTop = element.top();
		final int popupLeft = element.left();
		QuestionDialog.this.setPopupPosition(popupLeft, popupTop + outerHeight);
		element.css("opacity", "0.0");
		element.animate("top:'" + popupTop + "px', visibility:  visible , opacity: '1.0'", 500);

	}
}
