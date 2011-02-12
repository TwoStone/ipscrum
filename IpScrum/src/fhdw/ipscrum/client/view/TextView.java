package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.view.interfaces.ITextView;

public class TextView extends Composite implements ITextView {
	private final Label nameLabel = new Label("New label");
	private final TextBox contentText = new TextBox();
	private final Button okayButton = new Button("New button");
	private final Button cancelButton = new Button("New button");
	private final Event<EventArgs> save = new Event<EventArgs>();
	private final Event<EventArgs> abort = new Event<EventArgs>();

	public TextView(final String label) {

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(10);
		this.initWidget(verticalPanel);

		final HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(5);
		verticalPanel.add(horizontalPanel_1);

		this.nameLabel.setText(label);
		horizontalPanel_1.add(this.nameLabel);

		horizontalPanel_1.add(this.contentText);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		verticalPanel.add(horizontalPanel);
		this.okayButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				TextView.this.save.fire(TextView.this, new EventArgs());
			}
		});

		this.okayButton.setText("Okay");
		horizontalPanel.add(this.okayButton);
		this.cancelButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				TextView.this.abort.fire(TextView.this, new EventArgs());
			}
		});

		this.cancelButton.setText("Abbrechen");
		horizontalPanel.add(this.cancelButton);

		// Set focus in text box.
		this.contentText.setFocus(true);
	}

	@Override
	public IEvent<EventArgs> abort() {
		return this.abort;
	}

	@Override
	public String getContent() {
		return this.contentText.getText();
	}

	@Override
	public IEvent<EventArgs> save() {
		return this.save;
	}

	@Override
	public void setContent(final String content) {
		this.contentText.setText(content);
	}

}
