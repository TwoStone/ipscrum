package fhdw.ipscrum.client.view.widgets;

import java.util.ArrayList;
import java.util.Date;

import com.googlecode.gchart.client.GChart;

import fhdw.ipscrum.client.utils.CalendarUtils;
import fhdw.ipscrum.shared.model.interfaces.ISprint;


/**
 * This is a widget. It shows statistical data about the progress of a sprint.
 *
 */
public class SprintBurndownChart extends GChart {

	private final ISprint sprint;

	// these will be constants
	private final String idealHoverTextTemplate = "<html><div class='chartToolTip'>Ideal-Burndown (${y} ausstehende Aufwaende am ${x})</div>";
	private final String actualHoverTextTemplate = "<html><div class='chartToolTip'>${y} ausstehende Aufwaende am ${x}</div>";


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
		getCurve().getSymbol().setModelWidth(50000000); // high value is caused by using a date as x-value. normally 0.5 would be sufficient.

		this.addBurndownData(generateDemoData()); // TODO update to use real data here.


		// SETUP IDEAL BURNDOWN CURVE
		addCurve();
		getCurve().setYAxis(Y_AXIS);
		getCurve().getSymbol().setSymbolType(SymbolType.LINE);
		getCurve().getSymbol().setHovertextTemplate(this.idealHoverTextTemplate);
		getCurve().getSymbol().setBorderColor("black");
		getCurve().getSymbol().setBackgroundColor("yellow");

		ArrayList<Date> daysInvolved = CalendarUtils.getAListOfDatesFromParam1ToParam2(this.sprint.getBegin(), this.sprint.getEnd());
		int dayCount = daysInvolved.size();
		double taskSum = getCurve(0).getPoint(0).getY(); // TODO maybe use actual sum of efforts later
		for (int i = 0; i < dayCount; i++) {
			getCurve().addPoint(daysInvolved.get(i).getTime(), taskSum / (dayCount-1) * (dayCount-1 - i));
		}


		// SETUP TREND LINE
		addCurve();
		getCurve().setYAxis(Y_AXIS);
		getCurve().getSymbol().setSymbolType(SymbolType.LINE);
		getCurve().getSymbol().setHoverAnnotationEnabled(false);
		getCurve().getSymbol().setWidth(1);
		getCurve().getSymbol().setHeight(1);
		getCurve().getSymbol().setBorderColor("grey");
		getCurve().getSymbol().setBackgroundColor("grey");

		Double deltaAvg = 0d;
		for (int i = 1; i < getCurve(0).getNPoints(); i++) {
			deltaAvg += getCurve(0).getPoint(i-1).getY() - getCurve(0).getPoint(i).getY();
		}
		deltaAvg = deltaAvg / (getCurve(0).getNPoints() - 1);

		getCurve().addPoint(daysInvolved.get(0).getTime(), getCurve(0).getPoint(0).getY());
		for (int i = 1; i < dayCount; i++) {
			double value = getCurve().getPoint().getY() - deltaAvg;
			if (value>=0) {
				getCurve().addPoint(daysInvolved.get(i).getTime(), value);
			}
		}


		// SETUP X- AND Y-AXIS
		getXAxis().setAxisLabel("<i>A r b e i t s t a g e</i>");
		getXAxis().setTickCount(dayCount);
		getXAxis().setTickLabelFormat("=(Date)dd.");

		getYAxis().setAxisLabel("<i>A<br />u<br />f<br />w<br />a<br />e<br />n<br />d<br />e</i>");
		getYAxis().setHasGridlines(true);
		getYAxis().setTickLabelFormat("#");
		getYAxis().setTickLength(25);

		// UPDATE - THIS IS NECESSARY FOR SOME REASON
		this.update();
	}

	/**
	 * This is used to initialize the chart with data.
	 * @param chartData a list of SprintChartData. SCD is a container format with a data and a value.
	 */
	private void addBurndownData(ArrayList<SprintChartData> chartData) {
		for (SprintChartData data : chartData) {
			this.getCurve(0).addPoint(data.getDate().getTime(), data.getValue());
		}
	}

	/**
	 * This is to generate realistic demonstration data.
	 * @return a list of SprintChartData. SCD is a container format with a data and a value.
	 */
	private ArrayList<SprintChartData> generateDemoData() {

		ArrayList<SprintChartData> resultList = new ArrayList<SprintChartData>();

		ArrayList<Date> daysInvolved = CalendarUtils.getAListOfDatesFromParam1ToParam2(this.sprint.getBegin(), this.sprint.getEnd());
		int dayCount = daysInvolved.size();
		Date today = new Date();
		int taskCount = (int) (Math.random() * 100 + 50);

		for (int i = 0; i < dayCount; i++) {
			if (daysInvolved.get(i).before(today)) {
				int ideal = taskCount / (dayCount-1) * (dayCount-1 - i);
				double deviation = Math.random() * 0.4 + 0.8;

				resultList.add(new SprintChartData(daysInvolved.get(i), (int) (ideal*deviation)));
			}
		}
		return resultList;
	}
}