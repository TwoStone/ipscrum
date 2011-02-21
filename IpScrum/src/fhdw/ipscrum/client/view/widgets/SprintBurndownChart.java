package fhdw.ipscrum.client.view.widgets;

import com.googlecode.gchart.client.GChart;

import fhdw.ipscrum.shared.model.interfaces.ISprint;


public class SprintBurndownChart extends GChart {

	private final ISprint sprint;

	// these will be constants
	private final String idealHoverTextTemplate = "<div id='chartToolTip'>Ideal-Burndown (Tag ${x}: ${y} ausstehende Aufwaende)</div>";
	private final String actualHoverTextTemplate = "<div id='chartToolTip'>Tag ${x}: ${y} ausstehende Aufwaende</div>";


	public SprintBurndownChart(ISprint sprint) {
		this.sprint = sprint;
		this.createChart();
	}

	private void createChart() {
		// GENERAL SETUP
		setChartTitle("<h2>" + this.sprint.getName() + "</h2>");
		setChartSize(500, 500);


		// SETUP ACTUAL BURNDOWN CURVE
		addCurve();
		getCurve().setYAxis(Y_AXIS);
		getCurve().getSymbol().setSymbolType(SymbolType.VBAR_SOUTH);
		getCurve().getSymbol().setHovertextTemplate(actualHoverTextTemplate);
		getCurve().getSymbol().setBackgroundColor("orange");
		getCurve().getSymbol().setBorderColor("red");
		getCurve().getSymbol().setBorderWidth(1);
		getCurve().getSymbol().setModelWidth(0.5);




		// GENERATE DEMO BURNDOWN DATA
		int dayCount = (int) (Math.random() * 21 + 5);
		int dayInSprint = (int) (Math.random()*dayCount + dayCount*0.5);
		int taskCount = (int) (Math.random() * 100 + 50);

		for (int i = 0; i < dayCount; i++) {
			if (i < dayInSprint) {
				int ideal = taskCount / (dayCount-1) * (dayCount-1 - i);
				double deviation = Math.random() * 0.4 + 0.8;

				getCurve().addPoint(i, ideal*deviation);
			} else {
				getCurve().addPoint(i, 0);
			}
		}




		// SETUP IDEAL BURNDOWN CURVE
		addCurve();
		getCurve().setYAxis(Y_AXIS);
		getCurve().getSymbol().setSymbolType(SymbolType.LINE);
		getCurve().getSymbol().setHovertextTemplate(this.idealHoverTextTemplate);
		getCurve().getSymbol().setBorderColor("black");
		getCurve().getSymbol().setBackgroundColor("yellow");

		int dataCount = getCurve(0).getNPoints() - 1;
		double startingPoint = getCurve(0).getPoint(0).getY();
		for (int i=0; i < getCurve(0).getNPoints(); i++) {
			getCurve().addPoint(i, startingPoint / dataCount * (dataCount - i));
		}


		// SETUP X- AND Y-AXIS
		getXAxis().setAxisLabel("<i>A r b e i t s t a g e</i>");
		getXAxis().setTickCount(getCurve(0).getNPoints());

		getYAxis().setAxisLabel("<i>A<br />u<br />f<br />w<br />a<br />e<br />n<br />d<br />e</i>");
		getYAxis().setHasGridlines(true);
		getYAxis().setTickLength(25);

		// UPDATE - THIS IS NECESSARY FOR SOME REASON
		this.update();
	}
}