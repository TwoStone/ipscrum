package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.gchart.client.GChart;
import com.googlecode.gchart.client.GChart.Curve.Point;
import com.googlecode.gchart.client.HoverUpdateable;

import fhdw.ipscrum.client.view.widgets.charts.ReleaseChartData.ReleaseChartDataDetails;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.interfaces.IRelease;

/**
 * This is to display a detailed burndown-chart for releases.
 * While presenting actual burndown-data this also includes an ideal-line and a trend-estimation.
 *
 */
public class ReleaseBurndownChart extends BurndownChart {

	private final ReleaseChartData data;

	/**
	 * Simple constructor. This used the default chart-size of 500px x 250px.
	 * @param release IRelease to display
	 */
	public ReleaseBurndownChart(IRelease release) {
		this(release, 500, 250);
	}

	/**
	 * This is the default constructor.
	 * @param release IRelease to display
	 * @param width width of chart
	 * @param height height of chart
	 */
	public ReleaseBurndownChart(IRelease release, int width, int height) {
		this.data = new ReleaseChartData(release);
		setChartWidth(width);
		setChartHeight(height);
		this.createChart();
	}

	/**
	 * This is to generate and display the chart-display.
	 * @return chart
	 */
	@Override
	protected void createChart() {
		// GENERAL SETUP
		setChartTitle("<h2>Release " + this.getData().getRelease().getVersion() + "</h2>");
		setChartSize(getChartWidth(), getChartHeight());

		// SETUP ACTUAL BURNDOWN CURVE
		addCurve();
		burndownCurve = getCurve();
		burndownCurve.setYAxis(GChart.Y_AXIS);
		burndownCurve.getSymbol().setSymbolType(SymbolType.VBAR_SOUTH);
		burndownCurve.getSymbol().setHoverWidget(new ReleaseChartHoverWidget());
		burndownCurve.getSymbol().setBackgroundColor("GreenYellow");
		burndownCurve.getSymbol().setBorderColor("Green");
		burndownCurve.getSymbol().setBorderWidth(1);

		// SETUP IDEAL BURNDOWN CURVE
		addCurve();
		idealCurve = getCurve();
		idealCurve.setYAxis(GChart.Y_AXIS);
		idealCurve.getSymbol().setSymbolType(SymbolType.LINE);
		idealCurve.getSymbol().setHovertextTemplate(GChart.formatAsHovertext("Ideal-Burndown<br />(${y} ausstehende Aufwände)"));
		idealCurve.getSymbol().setBorderColor("black");
		idealCurve.getSymbol().setBackgroundColor("yellow");

		// SETUP TREND LINE
		addCurve();
		trendCurve = getCurve();
		trendCurve.setYAxis(GChart.Y_AXIS);
		trendCurve.getSymbol().setSymbolType(SymbolType.LINE);
		trendCurve.getSymbol().setHoverAnnotationEnabled(false);
		trendCurve.getSymbol().setWidth(1);
		trendCurve.getSymbol().setHeight(1);
		trendCurve.getSymbol().setBorderColor("grey");
		trendCurve.getSymbol().setBackgroundColor("grey");

		getXAxis().setAxisLabel(TextConstants.CHART_RELEASE_XAXIS_LABEL);
		getYAxis().setAxisLabel(TextConstants.CHART_RELEASE_YAXIS_LABEL);
		getYAxis().getAxisLabel().setStyleName("rotated");
		getYAxis().setAxisLabelThickness(20);
		getYAxis().setHasGridlines(true);
		getYAxis().setTickLabelFormat("#");
		getYAxis().setTickLength(25);
		getYAxis().setAxisMin(0);


		this.populateChart();
		this.generateTrendcurve(this.data.getConsiderableDatapoints());

		getXAxis().clearTicks();
		int counter = 0;
		DateTimeFormat xAxisDateFormatter = DateTimeFormat.getFormat("d.M.");
		for (Date endDate : this.getData().getData().keySet()) {
			getXAxis().addTick(counter, xAxisDateFormatter.format(endDate));
			counter++;
		}

		this.update();
	}

	/**
	 * This is to populate the chart with release-data.
	 */
	@Override
	protected void populateChart() {
		int counter = 0;
		for (Date endDate : this.getData().getData().keySet()) {
			ReleaseChartDataDetails currentData = getData().getData().get(endDate);
			idealCurve.addPoint(counter, currentData.getIdealBurndownValue());
			if (currentData.getActualBurndownValue() != null) {
				burndownCurve.addPoint(counter, currentData.getActualBurndownValue());

				String annotationText = currentData.getActualBurndownValue() + " ausstehende Aufwände<br />nach " + currentData.getSprints().toString();
				burndownCurve.getPoint().setAnnotationText(GChart.formatAsHovertext(annotationText));
				burndownCurve.getPoint().setAnnotationVisible(false);
			}
			counter++;
		}
	}

	public ReleaseChartData getData() {
		return this.data;
	}

	/**
	 *	This is to control the annotation-behaviour.
	 */
	class ReleaseChartHoverWidget extends Label implements HoverUpdateable {
		@Override
		public void hoverCleanup(Point hoveredAwayFrom) {
			hoveredAwayFrom.setAnnotationVisible(false);
		}

		@Override
		public void hoverUpdate(Point hoveredOver) {
			hoveredOver.setAnnotationVisible(true);
		}
	}
}