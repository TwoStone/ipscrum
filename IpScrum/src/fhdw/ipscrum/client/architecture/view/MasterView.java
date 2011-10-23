package fhdw.ipscrum.client.architecture.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;

/**
 * represents all views in the IPScrum.
 */
public abstract class MasterView extends VerticalPanel implements IView {

	/**
	 * Event that is raised when a user requests assistance.
	 */
	private final DefaultEvent helpEvent = new DefaultEvent();

	/**
	 * Constructor.
	 */
	public MasterView() {

		final Image image = new Image("images/icon_hilfe.gif");
		this.add(image);
		image.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				MasterView.this.helpEvent.fire(MasterView.this);
			}
		});

		this.setCellHorizontalAlignment(image, HasHorizontalAlignment.ALIGN_RIGHT);
		image.setSize("20px", "22px");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * fhdw.ipscrum.client.architecture.view.IMasterView#registerHelpHandler(fhdw.ipscrum.client.architecture.events
	 * .DefaultEventHandler)
	 */
	@Override
	public EventRegistration registerHelpHandler(final DefaultEventHandler handler) {
		return this.helpEvent.add(handler);
	}

}
