package fhdw.ipscrum.client.view.widgets.charts;

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
	private Curve burndownCurve;
	private final int width;
	private final int height;


	public SprintBurndownChart(ISprint sprint) {
		this(sprint, 500, 500);
	}

	public SprintBurndownChart(ISprint sprint, int width, int height) {
		this.sprint = sprint;
		this.width = width;
		this.height = height;
		this.createChart();
	}

	private void createChart() {
		// GENERAL SETUP
		setChartTitle("<h2>" + this.sprint.getName() + "</h2>");
		setChartSize(this.width, this.height);


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

		this.addBurndownData(generateDemoData()); // TODO update to use real data here.

		if (burndownCurve.getNPoints() > 0) {

			// SETUP IDEAL BURNDOWN CURVE
			addCurve();
			Curve idealCurve = getCurve();
			idealCurve.setYAxis(Y_AXIS);
			idealCurve.getSymbol().setSymbolType(SymbolType.LINE);
			idealCurve.getSymbol().setHovertextTemplate(GChart.formatAsHovertext("Ideal-Burndown<br />(${y} ausstehende Aufwaende am ${x})"));
			idealCurve.getSymbol().setBorderColor("black");
			idealCurve.getSymbol().setBackgroundColor("yellow");

			ArrayList<Date> daysInvolved = CalendarUtils.getAListOfDatesFromParam1ToParam2(this.sprint.getBegin(), this.sprint.getEnd());
			int dayCount = daysInvolved.size();
			double taskSum = burndownCurve.getPoint(0).getY(); // TODO maybe use actual sum of efforts later
			for (int i = 0; i < dayCount; i++) {
				idealCurve.addPoint(daysInvolved.get(i).getTime(), taskSum / (dayCount-1) * (dayCount-1 - i));
			}


			// SETUP TREND LINE
			/* formatting */
			addCurve();
			Curve trendCurve = getCurve();
			trendCurve.setYAxis(Y_AXIS);
			trendCurve.getSymbol().setSymbolType(SymbolType.LINE);
			trendCurve.getSymbol().setHoverAnnotationEnabled(false);
			trendCurve.getSymbol().setWidth(1);
			trendCurve.getSymbol().setHeight(1);
			trendCurve.getSymbol().setBorderColor("grey");
			trendCurve.getSymbol().setBackgroundColor("grey");

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
			for (int i = 0; i < dayCount; i++) {
				double value = m * i + q;
				if (value>=0) {
					trendCurve.addPoint(daysInvolved.get(i).getTime(), value);
				}
			}


			// set x-axis ticks
			if (this.width > 400) {
				getXAxis().setTickCount((dayCount<26) ? dayCount : 25);
			}
		}

		getXAxis().setAxisLabel("<i>A r b e i t s t a g e</i>");
		getXAxis().setTickLabelFormat("=(Date)dd.");

		getYAxis().setAxisLabel("<i>A<br />u<br />f<br />w<br />a<br />e<br />n<br />d<br />e</i>");
		getYAxis().setHasGridlines(true);
		getYAxis().setTickLabelFormat("#");
		getYAxis().setTickLength(25);

		this.update();
	}

	/**
	 * This is used to initialize the chart with data.
	 * @param chartData a list of SprintChartData. SCD is a container format with a data and a value.
	 */
	private void addBurndownData(ArrayList<SprintChartData> chartData) {
		for (SprintChartData data : chartData) {
			this.burndownCurve.addPoint(data.getDate().getTime(), data.getValue());
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