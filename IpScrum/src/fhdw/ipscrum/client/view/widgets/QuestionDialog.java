package fhdw.ipscrum.client.view.widgets;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class QuestionDialog extends DialogBox {
	private Button okayButton;
	private Button abortButton;
	
	public QuestionDialog(String title, String message) {
		super();
		setSize("", "");
		setAnimationEnabled(true);
		setGlassEnabled(true);
		this.setTitle(title);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		setWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");
		
		Label label = new Label(message);
		verticalPanel.add(label);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel.add(horizontalPanel);
		
		okayButton = new Button("New button");
		okayButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				QuestionDialog.this.hide();
			}
		});
		okayButton.setText("Okay");
		horizontalPanel.add(okayButton);
		
		abortButton = new Button("New button");
		abortButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				QuestionDialog.this.hide();
			}
		});
		abortButton.setText("Abort");
		horizontalPanel.add(abortButton);
	}
	
	public HasClickHandlers getOkayButton() {
		return okayButton;
	}
	public HasClickHandlers getAbortButton() {
		return abortButton;
	}
}
