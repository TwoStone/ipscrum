package fhdw.ipscrum.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ScrollPanel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.events.args.SearchArgs;
import fhdw.ipscrum.client.view.interfaces.ISearchOverviewView;

public class SearchOverviewView extends Composite implements ISearchOverviewView {

	private final Event<EventArgs> freeTextSearch = new Event<EventArgs>();
	private final Event<EventArgs> createSearch = new Event<EventArgs>();
	private final Event<SearchArgs> editSearch = new Event<SearchArgs>();
	private final Event<SearchArgs> deleteSearch = new Event<SearchArgs>();

	public SearchOverviewView() {

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		initWidget(horizontalPanel);

		ScrollPanel scrollPanelSearch = new ScrollPanel();
		horizontalPanel.add(scrollPanelSearch);
		scrollPanelSearch.setSize("256px", "400px");
	}

	@Override
	public IEvent<EventArgs> getFreeTextSearch() {
		return this.freeTextSearch;
	}

	@Override
	public IEvent<EventArgs> getCreateSearch() {
		return this.createSearch;
	}

	@Override
	public IEvent<SearchArgs> getEditSearch() {
		return this.editSearch;
	}

	@Override
	public IEvent<SearchArgs> getDeleteSearch() {
		return this.deleteSearch;
	}

}
