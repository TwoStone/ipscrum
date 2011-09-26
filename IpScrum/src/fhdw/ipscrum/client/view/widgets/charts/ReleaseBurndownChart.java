package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.gchart.client.GChart;
import com.googlecode.gchart.client.GChart.Curve.Point;
import com.googlecode.gchart.client.HoverUpdateable;

import fhdw.ipscrum.client.view.widgets.charts.ReleaseChartData.ReleaseChartDataDetails;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * This is to display a detailed burndown-chart for releases. While presenting actual
 * burndown-data this also includes an ideal-line and a trend-estimation.
 */
public class ReleaseBurndownChart extends BurndownChart {

	private final ReleaseChartData data;

	/**
	 * Simple constructor. This used the default chart-size of 500px x 250px.
	 * 
	 * @param release
	 *            IRelease to display
	 */
	public ReleaseBurndownChart(final Release release) {
		this(release, 500, 300);
	}

	/**
	 * This is the default constructor.
	 * 
	 * @param release
	 *            IRelease to display
	 * @param width
	 *            width of chart
	 * @param height
	 *            height of chart
	 */
	public ReleaseBurndownChart(final Release release, final int width, final int height) {
		this.data = new ReleaseChartData(release);
		this.setChartWidth(width);
		this.setChartHeight(height);
		this.createChart();
	}

	/**
	 * This is to generate and display the chart-display.
	 * 
	 * @return chart
	 */
	private void createChart() {
		// GENERAL SETUP
		this.setChartTitle("<h2>Release " + this.getData().getRelease().getVersion()
				+ "</h2>");
		this.setChartSize(this.getChartWidth(), this.getChartHeight());

		// SETUP ACTUAL BURNDOWN CURVE
		this.addCurve();
		this.setBurndownCurve(this.getCurve());
		this.getBurndownCurve().setYAxis(GChart.Y_AXIS);
		this.getBurndownCurve().getSymbol().setSymbolType(SymbolType.VBAR_SOUTH);
		this.getBurndownCurve().getSymbol().setHoverWidget(new ReleaseChartHoverWidget());
		this.getBurndownCurve().getSymbol().setBackgroundColor("GreenYellow");
		this.getBurndownCurve().getSymbol().setBorderColor("Green");
		this.getBurndownCurve().getSymbol().setBorderWidth(1);

		// SETUP IDEAL BURNDOWN CURVE
		this.addCurve();
		this.setIdealCurve(this.getCurve());
		this.getIdealCurve().setYAxis(GChart.Y_AXIS);
		this.getIdealCurve().getSymbol().setSymbolType(SymbolType.LINE);
		this.getIdealCurve()
				.getSymbol()
				.setHovertextTemplate(
						GChart.formatAsHovertext("Ideal-Burndown<br />(${y} ausstehende Aufwände)"));
		this.getIdealCurve().getSymbol().setBorderColor("black");
		this.getIdealCurve().getSymbol().setBackgroundColor("yellow");

		// SETUP TREND LINE
		this.addCurve();
		this.setTrendCurve(this.getCurve());
		this.getTrendCurve().setYAxis(GChart.Y_AXIS);
		this.getTrendCurve().getSymbol().setSymbolType(SymbolType.LINE);
		this.getTrendCurve().getSymbol().setHoverAnnotationEnabled(false);
		this.getTrendCurve().getSymbol().setWidth(1);
		this.getTrendCurve().getSymbol().setHeight(1);
		this.getTrendCurve().getSymbol().setBorderColor("grey");
		this.getTrendCurve().getSymbol().setBackgroundColor("grey");

		this.getXAxis().setAxisLabel(TextConstants.CHART_VELOCITY_XAXIS_LABEL);
		this.getYAxis().setAxisLabel(TextConstants.CHART_RELEASE_YAXIS_LABEL);
		this.getYAxis().getAxisLabel().setStyleName("rotated");
		this.getYAxis().setAxisLabelThickness(20);
		this.getYAxis().setHasGridlines(true);
		this.getYAxis().setTickLabelFormat("#");
		this.getYAxis().setTickLength(25);
		this.getYAxis().setAxisMin(0);

		this.populateChart();
		this.generateTrendcurve(this.data.getTickData());

		this.getXAxis().clearTicks();
		int counter = 0;
		final DateTimeFormat xAxisDateFormatter = DateTimeFormat.getFormat("d.M.");
		for (final Date endDate : this.getData().getData().keySet()) {
			this.getXAxis().addTick(counter, xAxisDateFormatter.format(endDate));
			counter++;
		}

		this.update();
	}

	/**
	 * This is to populate the chart with release-data.
	 */
	private void populateChart() {
		int counter = 0;
		for (final Date endDate : this.getData().getData().keySet()) {
			final ReleaseChartDataDetails currentData =
					this.getData().getData().get(endDate);
			this.getIdealCurve().addPoint(counter, currentData.getIdealBurndownValue());
			if (currentData.getActualBurndownValue() != null) {
				this.getBurndownCurve().addPoint(counter,
						currentData.getActualBurndownValue());

				final String annotationText =
						currentData.getActualBurndownValue().intValue()
								+ " ausstehende Aufwände<br />nach "
								+ currentData.getSprints().toString();
				this.getBurndownCurve().getPoint().setAnnotationText(
						GChart.formatAsHovertext(annotationText));
				this.getBurndownCurve().getPoint().setAnnotationVisible(false);
			}
			counter++;
		}
	}

	/**
	 * Getter of the data needed to fill the chart.
	 * 
	 * @return the releaseChartData
	 */
	public ReleaseChartData getData() {
		return this.data;
	}

	/**
	 * This is to control the annotation-behaviour.
	 */
	private static class ReleaseChartHoverWidget extends Label
			implements HoverUpdateable {
		@Override
		public void hoverCleanup(final Point hoveredAwayFrom) {
			hoveredAwayFrom.setAnnotationVisible(false);
		}

		@Override
		public void hoverUpdate(final Point hoveredOver) {
			hoveredOver.setAnnotationVisible(true);
		}
	}
}
