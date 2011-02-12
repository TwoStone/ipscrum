package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasText;
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

/**
 */
public class RoleDialogView extends Composite implements IRoleDialogView {
	
	private final Event<OneStringArgs> okEvent = new Event<OneStringArgs>();
	private final Event<EventArgs> cancelEvent = new Event<EventArgs>();
	
	private TextBox role;
	private Button ok_button;
	private Button abb_button;

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
		
		Label label = new Label("Rollenbezeichnung");
		rolePanel.add(label);
		label.setSize("115px", "19px");
		
		role = new TextBox();
		rolePanel.add(role);
		role.setSize("261px", "16px");
		
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
		
		ok_button = new Button("OK");
		buttonPanel.add(ok_button);
		ok_button.setSize("100px", "28px");
		ok_button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				okEvent.fire(RoleDialogView.this, new OneStringArgs(RoleDialogView.this.getRole().getText()));
			}
		});
		
		abb_button = new Button("Abbrechen");
		buttonPanel.add(abb_button);
		abb_button.setSize("100px", "28px");
		abb_button.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				cancelEvent.fire(RoleDialogView.this, new EventArgs());
			}
		});
	}

	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IRoleDialogView#getRole()
	 */
	@Override
	public HasText getRole() {
		return role;
	}


	/**
	 * Method addOkEventHandler.
	 * @param args EventHandler<OneStringArgs>
	 * @see fhdw.ipscrum.client.view.interfaces.IRoleDialogView#addOkEventHandler(EventHandler<OneStringArgs>)
	 */
	@Override
	public void addOkEventHandler(EventHandler<OneStringArgs> args) {
		okEvent.add(args);
	}

	/**
	 * Method addCancelEventHandler.
	 * @param args EventHandler<EventArgs>
	 * @see fhdw.ipscrum.client.view.interfaces.IRoleDialogView#addCancelEventHandler(EventHandler<EventArgs>)
	 */
	@Override
	public void addCancelEventHandler(EventHandler<EventArgs> args) {
		cancelEvent.add(args);
	}
}
