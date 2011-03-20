package fhdw.ipscrum.client.view.widgets.charts;

import com.googlecode.gchart.client.GChart;

import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 * This is to display a velocity-chart for a specified team.
 */
public class VelocityChart extends GChart {

	private final VelocityChartData data;
	private Curve absVelocityCurve;
	private Curve relVelocityCurve;
	private Curve absAverageCurve;
	private Curve relAverageCurve;

	/**
	 * This is the default constructor.
	 * @param team ITeam to analyze
	 */
	public VelocityChart(ITeam team) {
		this.data = new VelocityChartData(team);
		this.createChart();
	}

	/**
	 * This is to generate and display the chart-display.
	 * @return chart
	 */
	private void createChart() {
		// GENERAL SETUP
		setChartTitle("<h2>Team " + this.data.getTeam().getDescription() + "</h2>");
		setChartSize(500, 500);

		// SETUP ABSOLUTE-VELOCITY CURVE
		addCurve();
		absVelocityCurve = getCurve();
		absVelocityCurve.setYAxis(GChart.Y_AXIS);
		absVelocityCurve.getSymbol().setSymbolType(SymbolType.VBAR_SOUTH);
		absVelocityCurve.getSymbol().setHovertextTemplate(GChart.formatAsHovertext("geleistete Aufwände: ${y}"));
		absVelocityCurve.getSymbol().setBackgroundColor("dodgerblue");
		absVelocityCurve.getSymbol().setBorderColor("papayawhip");
		absVelocityCurve.getSymbol().setBorderWidth(1);

		// SETUP RELATIVE-VELOCITY CURVE
		addCurve();
		relVelocityCurve = getCurve();
		relVelocityCurve.setYAxis(GChart.Y_AXIS);
		relVelocityCurve.getSymbol().setSymbolType(SymbolType.VBAR_SOUTH);
		relVelocityCurve.getSymbol().setHovertextTemplate(GChart.formatAsHovertext("relative Velocity: ${y}"));
		relVelocityCurve.getSymbol().setBackgroundColor("skyblue");
		relVelocityCurve.getSymbol().setBorderColor("papayawhip");
		relVelocityCurve.getSymbol().setBorderWidth(1);
		absVelocityCurve.getSymbol().setWidth(relVelocityCurve.getSymbol().getWidth()+8);

		// SETUP ABSOLUTE-AVERAGE CURVE
		addCurve();
		absAverageCurve = getCurve();
		absAverageCurve.setYAxis(GChart.Y_AXIS);
		absAverageCurve.getSymbol().setSymbolType(SymbolType.LINE);
		absAverageCurve.getSymbol().setHovertextTemplate(GChart.formatAsHovertext("Durchschnitt (absolut): ${y}"));
		absAverageCurve.getSymbol().setBorderColor("firebrick");
		absAverageCurve.getSymbol().setBackgroundColor("white");

		// SETUP RELATIVE-AVERAGE CURVE
		addCurve();
		relAverageCurve = getCurve();
		relAverageCurve.setYAxis(GChart.Y_AXIS);
		relAverageCurve.getSymbol().setSymbolType(SymbolType.LINE);
		relAverageCurve.getSymbol().setHovertextTemplate(GChart.formatAsHovertext("Durchschnitt (relativ): ${y}"));
		relAverageCurve.getSymbol().setBorderColor("firebrick");
		relAverageCurve.getSymbol().setBackgroundColor("white");

		getYAxis().setAxisLabel(TextConstants.CHART_VELOCITY_YAXIS_LABEL);
		getYAxis().getAxisLabel().setStyleName("rotated");
		getYAxis().setAxisLabelThickness(20);
		getYAxis().setHasGridlines(true);
		getYAxis().setTickLabelFormat("##.#"); // TODO solve this
		getYAxis().setTickLength(25);
		getYAxis().setAxisMin(0);

		this.populateChart();

		getXAxis().clearTicks();
		for (int i = 0; i < this.data.getTickData().size(); i++) { // TODO tickdata is useless right now
			ISprint currentSprint = this.data.getSprints().get(i);
			getXAxis().addTick(i, currentSprint.getName());
		}

		this.update();
	}

	/**
	 * This is to populate the chart with release-data.
	 */
	private void populateChart() {
		for (int i = 0; i < this.data.getSprints().size(); i++) {
			ISprint currentSprint = this.data.getSprints().get(i);
			absVelocityCurve.addPoint(i, currentSprint.getCumulatedManDayCostsOfClosedPbis());
			relVelocityCurve.addPoint(i, VelocityChartData.calculateRelativeVelocity(currentSprint));
			absAverageCurve.addPoint(i, this.data.getAbsAverageVelocity());
			relAverageCurve.addPoint(i, this.data.getRelAverageVelocity());
		}
	}
}