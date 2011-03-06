package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.gchart.client.GChart;
import com.googlecode.gchart.client.GChart.Curve;
import com.googlecode.gchart.client.GChart.Curve.Point;
import com.googlecode.gchart.client.GChart.SymbolType;
import com.googlecode.gchart.client.HoverUpdateable;

import fhdw.ipscrum.client.view.widgets.charts.ReleaseChartData.ReleaseChartDataDetails;
import fhdw.ipscrum.shared.model.interfaces.IRelease;

/**
 * This is to display a detailed burndown-chart for releases.
 * While presenting actual burndown-data this also includes an ideal-line and a trend-estimation.
 *
 */
public abstract class ReleaseBurndownChart extends Composite {

	private final ReleaseChartData data;
	private final int width;
	private final int height;

	private Curve burndownCurve;
	private Curve idealCurve;
	private Curve trendCurve;

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
		this.width = width;
		this.height = height;
	}

	/**
	 * This is to generate and display the chart-display.
	 * @return chart
	 */
	GChart createChart() {
		// GENERAL SETUP
		GChart rbdChart = new GChart(width, height);
		rbdChart.setChartTitle("<h2>Release " + this.getData().getRelease().getVersion() + "</h2>");

		// SETUP ACTUAL BURNDOWN CURVE
		rbdChart.addCurve();
		burndownCurve = rbdChart.getCurve();
		burndownCurve.setYAxis(GChart.Y_AXIS);
		burndownCurve.getSymbol().setSymbolType(SymbolType.VBAR_SOUTH);
		burndownCurve.getSymbol().setHoverWidget(new ReleaseChartHoverWidget());
		burndownCurve.getSymbol().setBackgroundColor("GreenYellow");
		burndownCurve.getSymbol().setBorderColor("Green");
		burndownCurve.getSymbol().setBorderWidth(1);

		// SETUP IDEAL BURNDOWN CURVE
		rbdChart.addCurve();
		idealCurve = rbdChart.getCurve();
		idealCurve.setYAxis(GChart.Y_AXIS);
		idealCurve.getSymbol().setSymbolType(SymbolType.LINE);
		idealCurve.getSymbol().setHovertextTemplate(GChart.formatAsHovertext("Ideal-Burndown<br />(${y} ausstehende Aufwände)"));
		idealCurve.getSymbol().setBorderColor("black");
		idealCurve.getSymbol().setBackgroundColor("yellow");

		// SETUP TREND LINE
		rbdChart.addCurve();
		trendCurve = rbdChart.getCurve();
		trendCurve.setYAxis(GChart.Y_AXIS);
		trendCurve.getSymbol().setSymbolType(SymbolType.LINE);
		trendCurve.getSymbol().setHoverAnnotationEnabled(false);
		trendCurve.getSymbol().setWidth(1);
		trendCurve.getSymbol().setHeight(1);
		trendCurve.getSymbol().setBorderColor("grey");
		trendCurve.getSymbol().setBackgroundColor("grey");

		rbdChart.getXAxis().setAxisLabel("<i>E n d t e r m i n e&nbsp;&nbsp;&nbsp;d e r&nbsp;&nbsp;&nbsp;S p r i n t s</i>");
		rbdChart.getYAxis().setAxisLabel("<i>o f f e n e&nbsp;&nbsp;&nbsp;A u f w ä n d e</i>");
		rbdChart.getYAxis().getAxisLabel().setStyleName("rotated");
		rbdChart.getYAxis().setAxisLabelThickness(20);
		rbdChart.getYAxis().setHasGridlines(true);
		rbdChart.getYAxis().setTickLabelFormat("#");
		rbdChart.getYAxis().setTickLength(25);
		rbdChart.getYAxis().setAxisMin(0);


		this.populateChart();
		this.generateTrendcurve();

		rbdChart.getXAxis().clearTicks();
		int counter = 0;
		DateTimeFormat xAxisDateFormatter = DateTimeFormat.getFormat("d.M.");
		for (Date endDate : this.getData().getData().keySet()) {
			rbdChart.getXAxis().addTick(counter, xAxisDateFormatter.format(endDate));
			counter++;
		}

		rbdChart.update();

		return rbdChart;
	}

	/**
	 * This is to populate the chart with release-data.
	 */
	private void populateChart() {
		int counter = 0;
		for (Date endDate : this.getData().getData().keySet()) {
			ReleaseChartDataDetails currentData = getData().getData().get(endDate);
			burndownCurve.addPoint(counter, currentData.getActualBurndownValue());
			idealCurve.addPoint(counter, currentData.getIdealBurndownValue());

			String annotationText = currentData.getActualBurndownValue() + " ausstehende Aufwände<br />nach " + currentData.getSprints().toString();
			burndownCurve.getPoint().setAnnotationText(GChart.formatAsHovertext(annotationText));
			burndownCurve.getPoint().setAnnotationVisible(false);
			counter++;
		}
	}

	/**
	 * This is to analyze the chart-data an draw the trend-line.
	 */
	private void generateTrendcurve() {
		/* calculate averages */
		double xAvg = 0d; double yAvg = 0d;
		for (int i = 0; i < burndownCurve.getNPoints(); i++) {
			xAvg += i;
			yAvg += burndownCurve.getPoint(i).getY();
		}
		xAvg = xAvg/burndownCurve.getNPoints();
		yAvg = yAvg/burndownCurve.getNPoints();

		/* calculate m (slope or gradient) */
		double calcVar1 = 0d; double calcVar2 = 0d;
		for (int i = 0; i < burndownCurve.getNPoints(); i++) {
			calcVar1 += (i-xAvg)*(burndownCurve.getPoint(i).getY()-yAvg);
			calcVar2 += Math.pow(i-xAvg, 2);
		}
		double m = calcVar1 / calcVar2;

		/* calculate q (y-intercept) */
		double q = yAvg - m * xAvg;

		/* draw trend curve */
		for (int i = 0; i < burndownCurve.getNPoints(); i++) {
			double value = m * i + q;
			if (value>=0) {
				trendCurve.addPoint(burndownCurve.getPoint(i).getX(), value);
			}
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