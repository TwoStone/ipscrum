package fhdw.ipscrum.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;
import com.googlecode.gchart.client.GChart;

import fhdw.ipscrum.client.presenter.RootPresenter;
import fhdw.ipscrum.client.view.widgets.charts.GWTCanvasBasedCanvasFactory;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.SessionManager.LoadCallback;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class IpScrum implements EntryPoint {

	// This line "teaches" GChart how to create the canvas
	// widgets it needs to render any continuous,
	// non-rectangular, chart aspects (solid fill pie slices,
	// continously connected lines, etc.) clearly and
	// efficiently.  It's generally best to do this exactly once,
	// when your entire GWT application loads.
	static {
		GChart.setCanvasFactory(new GWTCanvasBasedCanvasFactory());
	}

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {

		SessionManager.getInstance().load(new LoadCallback() {

			@Override
			public void onLoaded() {
				new RootPresenter(RootPanel.get("mainPanel"));
			}
		});
	}
}
