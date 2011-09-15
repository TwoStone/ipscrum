package fhdw.ipscrum.client.view.widgets.charts;

import com.googlecode.gchart.client.GChart;

import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.Team;

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
	 * 
	 * @param team
	 *            ITeam to analyze
	 */
	public VelocityChart(final Team team) {
		this.data = new VelocityChartData(team);
		this.createChart();
	}

	/**
	 * This is to generate and display the chart-display.
	 * 
	 * @return chart
	 */
	private void createChart() {
		// GENERAL SETUP
		this.setChartTitle("<h2>Team '" + this.data.getTeam().getDescription()
				+ "'</h2>");
		this.setChartSize(500, 300);

		// SETUP ABSOLUTE-VELOCITY CURVE
		this.addCurve();
		this.absVelocityCurve = this.getCurve();
		this.absVelocityCurve.setYAxis(GChart.Y_AXIS);
		this.absVelocityCurve.getSymbol().setSymbolType(SymbolType.VBAR_SOUTH);
		this.absVelocityCurve.getSymbol().setHovertextTemplate(
				GChart.formatAsHovertext("geleistete Aufwände: ${y}"));
		this.absVelocityCurve.getSymbol().setBackgroundColor("dodgerblue");
		this.absVelocityCurve.getSymbol().setBorderColor("papayawhip");
		this.absVelocityCurve.getSymbol().setBorderWidth(1);

		// SETUP RELATIVE-VELOCITY CURVE
		this.addCurve();
		this.relVelocityCurve = this.getCurve();
		this.relVelocityCurve.setYAxis(GChart.Y_AXIS);
		this.relVelocityCurve.getSymbol().setSymbolType(SymbolType.VBAR_SOUTH);
		this.relVelocityCurve.getSymbol().setHovertextTemplate(
				GChart.formatAsHovertext("relative Velocity: ${y}"));
		this.relVelocityCurve.getSymbol().setBackgroundColor("skyblue");
		this.relVelocityCurve.getSymbol().setBorderColor("papayawhip");
		this.relVelocityCurve.getSymbol().setBorderWidth(1);
		this.absVelocityCurve.getSymbol().setWidth(
				this.relVelocityCurve.getSymbol().getWidth() + 8);

		// SETUP ABSOLUTE-AVERAGE CURVE
		this.addCurve();
		this.absAverageCurve = this.getCurve();
		this.absAverageCurve.setYAxis(GChart.Y_AXIS);
		this.absAverageCurve.getSymbol().setSymbolType(SymbolType.LINE);
		this.absAverageCurve.getSymbol().setHovertextTemplate(
				GChart.formatAsHovertext("Durchschnitt (absolut): ${y}"));
		this.absAverageCurve.getSymbol().setBorderColor("firebrick");
		this.absAverageCurve.getSymbol().setBackgroundColor("white");

		// SETUP RELATIVE-AVERAGE CURVE
		this.addCurve();
		this.relAverageCurve = this.getCurve();
		this.relAverageCurve.setYAxis(GChart.Y_AXIS);
		this.relAverageCurve.getSymbol().setSymbolType(SymbolType.LINE);
		this.relAverageCurve.getSymbol().setHovertextTemplate(
				GChart.formatAsHovertext("Durchschnitt (relativ): ${y}"));
		this.relAverageCurve.getSymbol().setBorderColor("firebrick");
		this.relAverageCurve.getSymbol().setBackgroundColor("white");

		this.getYAxis().setAxisLabel(TextConstants.CHART_VELOCITY_YAXIS_LABEL);
		this.getYAxis().getAxisLabel().setStyleName("rotated");
		this.getYAxis().setAxisLabelThickness(20);
		this.getYAxis().setHasGridlines(true);
		this.getYAxis().setTickLabelFormat("##.#");
		this.getYAxis().setTickLength(25);
		this.getYAxis().setAxisMin(0);

		this.populateChart();

		this.getXAxis().clearTicks();
		int xPosition = 0;
		for (final Sprint sprint : this.data.getData().keySet()) {
			this.getXAxis().addTick(xPosition, sprint.getName());
			xPosition++;
		}

		this.update();
	}

	/**
	 * This is to populate the chart with data.
	 */
	private void populateChart() {
		int xPosition = 0;
		for (final Sprint sprint : this.data.getData().keySet()) {
			this.absVelocityCurve.addPoint(xPosition, this.data.getData().get(sprint)
					.getAbsoluteVelocity());
			this.relVelocityCurve.addPoint(xPosition, this.data.getData().get(sprint)
					.getRelativeVelocity());
			this.absAverageCurve.addPoint(xPosition, this.data.getAbsAverageVelocity());
			this.relAverageCurve.addPoint(xPosition, this.data.getRelAverageVelocity());
			xPosition++;
		}
	}
}
