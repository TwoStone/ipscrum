package fhdw.ipscrum.client.view.widgets.charts;

import com.google.gwt.user.client.ui.Label;
import com.googlecode.gchart.client.GChart;
import com.googlecode.gchart.client.GChart.Curve.Point;
import com.googlecode.gchart.client.HoverUpdateable;

import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 * This is to display a velocity-chart for a specified team.
 */
public class VelocityChart extends GChart {

	private final VelocityChartData data;
	private Curve averageCurve;
	private Curve velocityCurve;
	private Curve worstAverageCurve;

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

		// SETUP VELOCITY CURVE
		addCurve();
		velocityCurve = getCurve();
		velocityCurve.setYAxis(GChart.Y_AXIS);
		velocityCurve.getSymbol().setSymbolType(SymbolType.VBAR_SOUTH);
		velocityCurve.getSymbol().setHoverWidget(new VelocityChartHoverWidget());
		velocityCurve.getSymbol().setBackgroundColor("Purple");
		velocityCurve.getSymbol().setBorderColor("Pink");
		velocityCurve.getSymbol().setBorderWidth(1);

		// SETUP AVERAGE CURVE
		addCurve();
		averageCurve = getCurve();
		averageCurve.setYAxis(GChart.Y_AXIS);
		averageCurve.getSymbol().setSymbolType(SymbolType.LINE);
		averageCurve.getSymbol().setHovertextTemplate(GChart.formatAsHovertext("Durchschnitt aller Sprints: ${y}"));
		averageCurve.getSymbol().setBorderColor("Firebrick");
		averageCurve.getSymbol().setBackgroundColor("White");

		// SETUP WORST AVERAGE CURVE
		addCurve();
		worstAverageCurve = getCurve();
		worstAverageCurve.setYAxis(GChart.Y_AXIS);
		worstAverageCurve.getSymbol().setSymbolType(SymbolType.LINE);
		worstAverageCurve.getSymbol().setHovertextTemplate(GChart.formatAsHovertext("Durchschnitt der unteren drei: ${y}"));
		worstAverageCurve.getSymbol().setBorderColor("Firebrick");
		worstAverageCurve.getSymbol().setBackgroundColor("White");

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
			averageCurve.addPoint(i, this.data.getAverageVelocity());
			worstAverageCurve.addPoint(i, this.data.getWorstAverageVelocity());
			velocityCurve.addPoint(i, currentSprint.getCumulatedManDayCostsOfClosedPbis());
			String annotationText = "Sprint " + currentSprint.getName() + ":<br />" + currentSprint.getCumulatedManDayCostsOfClosedPbis() + " geleistete Aufwände";
			velocityCurve.getPoint().setAnnotationText(GChart.formatAsHovertext(annotationText));
			velocityCurve.getPoint().setAnnotationVisible(false);
		}
	}
}

/**
 *	This is to control the annotation-behaviour.
 */
class VelocityChartHoverWidget extends Label implements HoverUpdateable {
	@Override
	public void hoverCleanup(Point hoveredAwayFrom) {
		hoveredAwayFrom.setAnnotationVisible(false);
	}

	@Override
	public void hoverUpdate(Point hoveredOver) {
		hoveredOver.setAnnotationVisible(true);
	}

}