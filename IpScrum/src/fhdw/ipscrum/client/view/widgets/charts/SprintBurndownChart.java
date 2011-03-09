package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Date;

import com.googlecode.gchart.client.GChart;

import fhdw.ipscrum.client.view.widgets.charts.SprintChartData.SprintChartDataDetails;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.interfaces.ISprint;


/**
 * This is to display a detailed burndown-chart for releases.
 * While presenting actual burndown-data this also includes an ideal-line and a trend-estimation.
 */
public class SprintBurndownChart extends BurndownChart {

	private final SprintChartData data;

	public SprintBurndownChart(ISprint sprint) {
		this(sprint, 500, 500);
	}

	public SprintBurndownChart(ISprint sprint, int width, int height) {
		this.data = new SprintChartData(sprint);
		setChartWidth(width);
		setChartHeight(height);
		this.createChart();
	}

	private void createChart() {
		// GENERAL SETUP
		setChartTitle("<h2>" + this.data.getSprint().getName() + "</h2>");
		setChartSize(getChartWidth(), getChartWidth());


		// SETUP ACTUAL BURNDOWN CURVE
		addCurve();
		burndownCurve = this.getCurve();
		burndownCurve.setYAxis(Y_AXIS);
		burndownCurve.getSymbol().setSymbolType(SymbolType.VBAR_SOUTH);
		burndownCurve.getSymbol().setHovertextTemplate(GChart.formatAsHovertext("${y} ausstehende Aufwaende am ${x}"));
		burndownCurve.getSymbol().setBackgroundColor("orange");
		burndownCurve.getSymbol().setBorderColor("red");
		burndownCurve.getSymbol().setBorderWidth(1);
		burndownCurve.getSymbol().setModelWidth(50000000); // high value is caused by using a date as x-value. normally 0.5 would be sufficient.

		// SETUP IDEAL BURNDOWN CURVE
		addCurve();
		idealCurve = getCurve();
		idealCurve.setYAxis(Y_AXIS);
		idealCurve.getSymbol().setSymbolType(SymbolType.LINE);
		idealCurve.getSymbol().setHovertextTemplate(GChart.formatAsHovertext("Ideal-Burndown<br />(${y} ausstehende Aufwaende am ${x})"));
		idealCurve.getSymbol().setBorderColor("black");
		idealCurve.getSymbol().setBackgroundColor("yellow");

		// SETUP TREND LINE
		addCurve();
		trendCurve = getCurve();
		trendCurve.setYAxis(Y_AXIS);
		trendCurve.getSymbol().setSymbolType(SymbolType.LINE);
		trendCurve.getSymbol().setHoverAnnotationEnabled(false);
		trendCurve.getSymbol().setWidth(1);
		trendCurve.getSymbol().setHeight(1);
		trendCurve.getSymbol().setBorderColor("grey");
		trendCurve.getSymbol().setBackgroundColor("grey");

		getXAxis().setTickLabelFormat("=(Date)dd.");
		getXAxis().setAxisLabel(TextConstants.CHART_SPRINT_XAXIS_LABEL);
		getYAxis().setAxisLabel(TextConstants.CHART_SPRINT_YAXIS_LABEL);
		getYAxis().setTickLabelFormat("#");
		getYAxis().setTickLength(25);
		getYAxis().getAxisLabel().setStyleName("rotated");
		getYAxis().setAxisLabelThickness(20);
		getYAxis().setHasGridlines(true);

		this.populateChart();
		this.generateTrendcurve(this.data.getTickData());

		// set x-axis ticks
		if (getChartWidth() > 400) {
			getXAxis().setTickCount((this.data.getTickData().size()<26) ? this.data.getTickData().size() : 25);
		}

		this.update();
	}

	private void populateChart() {
		for (Date date : this.data.getData().keySet()) {
			SprintChartDataDetails currentData = data.getData().get(date);
			idealCurve.addPoint(date.getTime(), currentData.getIdealBurndownValue());
			if (currentData.getActualBurndownValue() != null) {
				burndownCurve.addPoint(date.getTime(), currentData.getActualBurndownValue());
			}
		}
	}
}