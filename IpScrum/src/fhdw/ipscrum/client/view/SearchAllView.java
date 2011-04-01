package fhdw.ipscrum.client.view;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.DoScruumleSearchEventArgs;
import fhdw.ipscrum.client.view.interfaces.ISearchAllView;

public class SearchAllView extends Composite implements ISearchAllView {
	private final Event<DoScruumleSearchEventArgs> doScruumleSearchEvent;
	private final ScrollPanel bottomPanel;
	private final TextBox searchExpression;
	private final Event<EventArgs> toDetailedSearchEvent;
	private final Event<EventArgs> showSearches;

	public SearchAllView() {
		super();

		this.doScruumleSearchEvent = new Event<DoScruumleSearchEventArgs>();
		this.toDetailedSearchEvent = new Event<EventArgs>();
		this.showSearches = new Event<EventArgs>();

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.initWidget(verticalPanel);
		verticalPanel.setSize("100%", "100%");

		final VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setSpacing(10);
		verticalPanel_1
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.add(verticalPanel_1);
		verticalPanel_1.setSize("100%", "200px");

		final Image image = new Image((String) null);
		verticalPanel_1.add(image);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		verticalPanel_1.add(horizontalPanel);
		horizontalPanel.setWidth("");

		this.searchExpression = new TextBox();
		this.searchExpression.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {
				SearchAllView.this.doScruumleSearchEvent.fire(
						SearchAllView.this, new DoScruumleSearchEventArgs(
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
			public void onClick(ClickEvent event) {
				SearchAllView.this.doScruumleSearchEvent.fire(
						SearchAllView.this, new DoScruumleSearchEventArgs(
								SearchAllView.this.searchExpression.getText()));
			}
		});
		horizontalPanel.add(search);

		final HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(5);
		verticalPanel_1.add(horizontalPanel_1);

		final Button savedSearchesButton = new Button("Gespeicherte Suchen");
		savedSearchesButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SearchAllView.this.showSearches.fire(SearchAllView.this,
						new EventArgs());
			}
		});
		horizontalPanel_1.add(savedSearchesButton);

		final Button detailedSearch = new Button("Zur detailierten Suche");
		detailedSearch.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				SearchAllView.this.toDetailedSearchEvent.fire(
						SearchAllView.this, new EventArgs());
			}
		});
		horizontalPanel_1.add(detailedSearch);

		this.bottomPanel = new ScrollPanel();
		this.bottomPanel.setStyleName("searchBottom");
		verticalPanel.add(this.bottomPanel);
		this.bottomPanel.setSize("100%", "420px");

	}

	@Override
	public void registerDoScruumleSearch(
			EventHandler<DoScruumleSearchEventArgs> handler) {
		this.doScruumleSearchEvent.add(handler);
	}

	@Override
	public void registerDetailedSearch(EventHandler<EventArgs> handler) {
		this.toDetailedSearchEvent.add(handler);
	}

	@Override
	public Panel getDisplayPanel() {
		return this.bottomPanel;
	}

	@Override
	public void registerShowSearches(EventHandler<EventArgs> handler) {
		this.showSearches.add(handler);
	}

}
