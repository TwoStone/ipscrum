package fhdw.ipscrum.client.architecture.widgets;

import java.util.Iterator;
import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;

import fhdw.ipscrum.client.resources.MyResources;

/**
 * represents the breadcrumb which shows where in the IPScrum you are and where you come
 * from.
 */
public class BreadcrumbView extends Composite implements IBreadcrumbView {

	private final HorizontalPanel lablePanel;

	static {
		MyResources.INSTANCE.architecture().ensureInjected();
	}

	/**
	 * constructor of the breadcrumView.
	 */
	public BreadcrumbView() {

		this.lablePanel = new HorizontalPanel();
		this.lablePanel.setSpacing(5);
		this.initWidget(this.lablePanel);
		this.setStyleName(MyResources.INSTANCE.architecture().breadcrumb());
	}

	@Override
	public void close() {
		// Does not close
	}

	@Override
	public void setContent(final List<BreadcrumbItem> breadcrumbItems) {
		this.lablePanel.clear();
		final Iterator<BreadcrumbItem> iterator = breadcrumbItems.iterator();
		while (iterator.hasNext()) {
			final IBreadcrumbView.BreadcrumbItem breadcrumbItem = iterator.next();
			final Label label = new Label(breadcrumbItem.getCaption());
			label.setStyleName(MyResources.INSTANCE.architecture().breadcrumbItem());
			label.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(final ClickEvent event) {
					breadcrumbItem.getCallback().callback();
				}
			});
			this.lablePanel.add(label);
			if (iterator.hasNext()) {
				this.lablePanel.add(new Label(">"));
			}
		}

	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}
}
