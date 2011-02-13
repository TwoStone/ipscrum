package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.OneStringArgs;
import fhdw.ipscrum.client.view.interfaces.IRoleDialogView;
import fhdw.ipscrum.shared.constants.TextConstants;

/**
 * This view is used to create or modify roles.
 */
public class RoleDialogView extends Composite implements IRoleDialogView {

	private final Event<OneStringArgs> okEvent = new Event<OneStringArgs>();
	private final Event<EventArgs> cancelEvent = new Event<EventArgs>();

	private final TextBox role;
	private final Button ok_button;
	private final Button abb_button;

	public RoleDialogView() {

		VerticalPanel verticalPanel = new VerticalPanel();
		initWidget(verticalPanel);
		verticalPanel.setSize("320px", "120px");

		VerticalPanel topPanel = new VerticalPanel();
		verticalPanel.add(topPanel);
		topPanel.setSize("320px", "76px");

		VerticalPanel rolePanel = new VerticalPanel();
		topPanel.add(rolePanel);
		rolePanel.setWidth("320px");

		Label label = new Label(TextConstants.ROLEDIALOG_DESCRIPTION);
		rolePanel.add(label);
		label.setSize("115px", "19px");

		this.role = new TextBox();
		rolePanel.add(this.role);
		this.role.setSize("261px", "16px");

		VerticalPanel bottomPanel = new VerticalPanel();
		bottomPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		bottomPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		verticalPanel.add(bottomPanel);
		bottomPanel.setSize("320px", "64px");

		HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_BOTTOM);
		buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		bottomPanel.add(buttonPanel);
		buttonPanel.setSize("219px", "36px");

		this.ok_button = new Button(TextConstants.DIALOGBOX_OK);
		buttonPanel.add(this.ok_button);
		this.ok_button.setSize("100px", "28px");
		this.ok_button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				RoleDialogView.this.okEvent.fire(RoleDialogView.this, new OneStringArgs(RoleDialogView.this.role.getText()));
			}
		});

		this.abb_button = new Button(TextConstants.DIALOGBOX_CANCEL);
		buttonPanel.add(this.abb_button);
		this.abb_button.setSize("100px", "28px");
		this.abb_button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				RoleDialogView.this.cancelEvent.fire(RoleDialogView.this, new EventArgs());
			}
		});
	}


	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.interfaces.IRoleDialogView#setRole(java.lang.String)
	 */
	@Override
	public void setRole(String role) {
		this.role.setText(role);
	}



	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.interfaces.IRoleDialogView#addOkEventHandler(fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void addOkEventHandler(EventHandler<OneStringArgs> args) {
		this.okEvent.add(args);
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.interfaces.IRoleDialogView#addCancelEventHandler(fhdw.ipscrum.client.events.EventHandler)
	 */
	@Override
	public void addCancelEventHandler(EventHandler<EventArgs> args) {
		this.cancelEvent.add(args);
	}
}
