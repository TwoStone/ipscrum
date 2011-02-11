package fhdw.ipscrum.client.view.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class QuestionDialog extends DialogBox {

	private final Button okayButton;
	private final Button abortButton;

	public QuestionDialog(String title, String message) {
		super();
		this.setSize("", "");
		this.setAnimationEnabled(true);
		this.setGlassEnabled(true);
		this.setHTML("<b>" + title + "</b>");

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(5);
		verticalPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		this.setWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");

		final Label label = new Label(message);
		verticalPanel.add(label);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		horizontalPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel.add(horizontalPanel);

		this.okayButton = new Button("Okay");
		this.okayButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				QuestionDialog.this.hide();
			}
		});
		horizontalPanel.add(this.okayButton);

		this.abortButton = new Button("Abbrechen");
		this.abortButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				QuestionDialog.this.hide();
			}
		});
		horizontalPanel.add(this.abortButton);
	}

	public HasClickHandlers getAbortButton() {
		return this.abortButton;
	}

	public HasClickHandlers getOkayButton() {
		return this.okayButton;
	}
}
