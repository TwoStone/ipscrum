package fhdw.ipscrum.client.view.widgets.charts;

import java.util.Date;

import com.googlecode.gchart.client.GChart;

import fhdw.ipscrum.client.view.widgets.charts.SprintChartData.SprintChartDataDetails;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;

/**
 * This is to display a detailed burndown-chart for releases. While presenting actual burndown-data this also includes
 * an ideal-line and a trend-estimation.
 */
public class SprintBurndownChart extends BurndownChart {

	private final SprintChartData data;

	/**
	 * Constructor of the SprintBurndwonChart.
	 * 
	 * @param sprint
	 *            related to the chart
	 */
	public SprintBurndownChart(final Sprint sprint) {
		this(sprint, 500, 300);
	}

	/**
	 * Constructor of the SprintBurndownChart.
	 * 
	 * @param sprint
	 *            related to the chart
	 * @param width
	 *            of the chart
	 * @param height
	 *            of the chart
	 */
	public SprintBurndownChart(final Sprint sprint, final int width, final int height) {
		this.data = new SprintChartData(sprint);
		this.setChartWidth(width);
		this.setChartHeight(height);
		this.createChart();
	}

	private void createChart() {
		// GENERAL SETUP
		this.setChartTitle("<h2>" + this.data.getSprint().getName() + "</h2>");
		this.setChartSize(this.getChartWidth(), this.getChartWidth());

		// SETUP ACTUAL BURNDOWN CURVE
		this.addCurve();
		this.setBurndownCurve(this.getCurve());
		this.getBurndownCurve().setYAxis(GChart.Y_AXIS);
		this.getBurndownCurve().getSymbol().setSymbolType(SymbolType.VBAR_SOUTH);
		this.getBurndownCurve().getSymbol()
				.setHovertextTemplate(GChart.formatAsHovertext("${y} ausstehende Aufwaende am ${x}"));
		this.getBurndownCurve().getSymbol().setBackgroundColor("orange");
		this.getBurndownCurve().getSymbol().setBorderColor("red");
		this.getBurndownCurve().getSymbol().setBorderWidth(1);
		this.getBurndownCurve().getSymbol().setModelWidth(50000000); // high value is
		// caused by
		// using a date
		// as x-value.
		// normally 0.5
		// would be
		// sufficient.

		// SETUP IDEAL BURNDOWN CURVE
		this.addCurve();
		this.setIdealCurve(this.getCurve());
		this.getIdealCurve().setYAxis(GChart.Y_AXIS);
		this.getIdealCurve().getSymbol().setSymbolType(SymbolType.LINE);
		this.getIdealCurve()
				.getSymbol()
				.setHovertextTemplate(
						GChart.formatAsHovertext("Ideal-Burndown<br />(${y} ausstehende Aufwaende am ${x})"));
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

		this.getXAxis().setTickLabelFormat("=(Date)dd.");
		this.getXAxis().setAxisLabel(TextConstants.CHART_SPRINT_XAXIS_LABEL);
		this.getYAxis().setAxisLabel(TextConstants.CHART_RELEASE_YAXIS_LABEL);
		this.getYAxis().setTickLabelFormat("#");
		this.getYAxis().setTickLength(25);
		this.getYAxis().getAxisLabel().setStyleName("rotated");
		this.getYAxis().setAxisLabelThickness(20);
		this.getYAxis().setHasGridlines(true);

		this.populateChart();
		this.generateTrendcurve(this.data.getTickData());

		// set x-axis ticks
		if (this.getChartWidth() > 400) {
			this.getXAxis().setTickCount(this.data.getTickData().size() < 26 ? this.data.getTickData().size() : 25);
		}

		this.update();
	}

	private void populateChart() {
		for (final Date date : this.data.getData().keySet()) {
			final SprintChartDataDetails currentData = this.data.getData().get(date);
			this.getIdealCurve().addPoint(date.getTime(), currentData.getIdealBurndownValue());
			if (currentData.getActualBurndownValue() != null) {
				this.getBurndownCurve().addPoint(date.getTime(), currentData.getActualBurndownValue());
			}
		}
	}

	@Override
	public void accept(final ChartWidgetVisitor visitor) {
		visitor.handleSprintBurndownChart(this);
	}
}
