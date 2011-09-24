package fhdw.ipscrum.client.view;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.eventargs.DoScruumleSearchEventArgs;
import fhdw.ipscrum.client.viewinterfaces.ISearchAllView;

/**
 * Represents the view for the scruumle search.
 */
public class SearchAllView extends MasterView implements ISearchAllView {
	private final Event<DoScruumleSearchEventArgs> doScruumleSearchEvent;
	private final TextBox searchExpression;

	/**
	 * constructor of the SearchAllView.
	 */
	public SearchAllView() {
		super();

		this.doScruumleSearchEvent = new Event<DoScruumleSearchEventArgs>();

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.add(verticalPanel);
		verticalPanel.setSize("750px", "200px");

		final VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setSpacing(10);
		verticalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(verticalPanel_1);
		verticalPanel_1.setSize("100%", "200px");

		final Image imgScruumle = new Image("images/Scruumle.png");
		verticalPanel_1.add(imgScruumle);
		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		verticalPanel_1.add(horizontalPanel);
		horizontalPanel.setWidth("");

		this.searchExpression = new TextBox();
		this.searchExpression.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(final ChangeEvent event) {
				SearchAllView.this.doScruumleSearchEvent.fire(SearchAllView.this,
						new DoScruumleSearchEventArgs(
								SearchAllView.this.searchExpression.getText()));
			}
		});
		horizontalPanel.add(this.searchExpression);
		this.searchExpression.setWidth("250px");
		this.searchExpression.setFocus(true);
		Scheduler.get().scheduleDeferred(new ScheduledCommand() {

			@Override
			public void execute() {
				SearchAllView.this.searchExpression.setFocus(true);
			}
		});

		final Button search = new Button("Suchen");
		search.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				SearchAllView.this.doScruumleSearchEvent.fire(SearchAllView.this,
						new DoScruumleSearchEventArgs(
								SearchAllView.this.searchExpression.getText()));
			}
		});
		horizontalPanel.add(search);

	}

	@Override
	public void registerDoScruumleSearch(
			final EventHandler<DoScruumleSearchEventArgs> handler) {
		this.doScruumleSearchEvent.add(handler);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}

}
