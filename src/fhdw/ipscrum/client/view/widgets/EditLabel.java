package fhdw.ipscrum.client.view.widgets;

import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;

import fhdw.ipscrum.client.utils.GwtUtils;

/**
 * Represents the EditLable Widget.
 */
public class EditLabel extends Composite implements HasText, HasValueChangeHandlers<String> {

	/**
	 * Represents the interface which represents the state.
	 */
	private interface State {
		void setWidget(SimplePanel panel);
	}

	/**
	 * Represents the view state.
	 */
	private class ViewState implements EditLabel.State {

		@Override
		public void setWidget(final SimplePanel simplePanel) {
			simplePanel.clear();
			simplePanel.setWidget(EditLabel.this.label);
		}
	}

	/**
	 * represents the edit state.
	 */
	private class EditState implements EditLabel.State {

		@Override
		public void setWidget(final SimplePanel simplePanel) {
			simplePanel.clear();
			simplePanel.setWidget(EditLabel.this.textBox);
		}

	}

	private final TextBox textBox = new TextBox();
	private final Label label = new Label();
	private final SimplePanel panel;
	private String text;
	private State state;
	private final ClickHandler clickHandler = new ClickHandler() {

		@Override
		public void onClick(final ClickEvent event) {
			EditLabel.this.enterEditMode();
		}
	};
	private final BlurHandler blurHandler = new BlurHandler() {

		@Override
		public void onBlur(final BlurEvent event) {
			EditLabel.this.leaveEditMode();
		}
	};
	private final KeyPressHandler keyPressHandler = new KeyPressHandler() {

		@Override
		public void onKeyPress(final KeyPressEvent event) {
			if (event.getNativeEvent().getKeyCode() == KeyCodes.KEY_ENTER) {
				EditLabel.this.leaveEditMode();
			}
		}
	};

	/**
	 * Constructor of the EditLabel.
	 */
	public EditLabel() {
		this.state = new ViewState();
		this.panel = new SimplePanel();

		this.initWidget(this.panel);
		this.state.setWidget(this.panel);

		this.label.addClickHandler(this.clickHandler);
		this.textBox.addBlurHandler(this.blurHandler);
		this.textBox.addKeyPressHandler(this.keyPressHandler);
		this.label.setStyleName("");
		this.textBox.setStyleName("");
	}

	private void leaveEditMode() {
		final String newText = this.textBox.getText();
		final String oldText = this.text;
		this.setText(newText);
		ValueChangeEvent.fireIfNotEqual(this, oldText, newText);
		this.state = new ViewState();
		this.state.setWidget(this.panel);
	}

	private void enterEditMode() {
		this.textBox.setText(this.text);
		this.state = new EditState();
		this.state.setWidget(this.panel);
		GwtUtils.setFocus(this.textBox);
	}

	@Override
	public String getText() {
		return this.text;
	}

	@Override
	public void setText(final String text) {

		this.text = text;
		this.label.setText(text);
	}

	@Override
	public HandlerRegistration addValueChangeHandler(final ValueChangeHandler<String> handler) {
		return this.addHandler(handler, ValueChangeEvent.getType());
	}

	@Override
	public void setStyleName(final String style) {
		super.setStyleName(style);
		this.textBox.setStyleName(style);
		this.label.setStyleName(style);
	}

	@Override
	public void setSize(final String width, final String height) {
		this.textBox.setSize(width, height);
		this.label.setSize(width, height);
		super.setSize(width, height);
	}

}
