package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Date;

import com.googlecode.gchart.client.GChart;

import fhdw.ipscrum.client.view.widgets.charts.SprintChartData.SprintChartDataDetails;
import fhdw.ipscrum.shared.model.interfaces.ISprint;


/**
 * This is a widget. It shows statistical data about the progress of a sprint.
 *
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

	@Override
	protected void createChart() {
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

		getXAxis().setAxisLabel("<i>A r b e i t s t a g e</i>");
		getXAxis().setTickLabelFormat("=(Date)dd.");
		getYAxis().setAxisLabel("<i>o f f e n e&nbsp;&nbsp;&nbsp;A u f w ä n d e</i>");
		getYAxis().setTickLabelFormat("#");
		getYAxis().setTickLength(25);
		getYAxis().getAxisLabel().setStyleName("rotated");
		getYAxis().setAxisLabelThickness(20);
		getYAxis().setHasGridlines(true);

		this.populateChart();
		this.generateTrendcurve(this.data.getConsiderableDatapoints());

		// set x-axis ticks
		if (getChartWidth() > 400) {
			getXAxis().setTickCount((this.data.getConsiderableDatapoints().size()<26) ? this.data.getConsiderableDatapoints().size() : 25);
		}

		this.update();
	}

	@Override
	protected void populateChart() {
		for (Date date : this.data.getData().keySet()) {
			SprintChartDataDetails currentData = data.getData().get(date);
			idealCurve.addPoint(date.getTime(), currentData.getIdealBurndownValue());
			if (currentData.getActualBurndownValue() != null) {
				burndownCurve.addPoint(date.getTime(), currentData.getActualBurndownValue());
			}
		}
	}
}