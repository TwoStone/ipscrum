package fhdw.ipscrum.client.view.widgets;

import java.util.ArrayList;

import com.googlecode.gchart.client.GChart;

import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;


/**
 * This is a widget. It shows statistical data about the progress of a release.
 *
 */
public class ReleaseBurndownChart extends GChart {

	private final IRelease release;

	// these will be constants
	private final String idealHoverTextTemplate = "<html><div class='chartToolTip'>Ideal-Burndown (${y} ausstehende Aufwaende nach Sprint ${x})</div>";
	private final String actualHoverTextTemplate = "<html><div class='chartToolTip'>${y} ausstehende Aufwaende nach Sprint ${x}</div>";


	public ReleaseBurndownChart(IRelease release) {
		this.release = release;
		this.createChart();
	}

	private void createChart() {
		// GENERAL SETUP
		setChartTitle("<h2>Release " + this.release.getVersion() + "</h2>");
		setChartSize(500, 500);


		// SETUP ACTUAL BURNDOWN CURVE
		addCurve();
		getCurve().setYAxis(Y_AXIS);
		getCurve().getSymbol().setSymbolType(SymbolType.VBAR_SOUTH);
		getCurve().getSymbol().setHovertextTemplate(actualHoverTextTemplate);
		getCurve().getSymbol().setBackgroundColor("lime");
		getCurve().getSymbol().setBorderColor("teal");
		getCurve().getSymbol().setBorderWidth(1);
		//		getCurve().getSymbol().setModelWidth(0.5);

		this.addBurndownData(generateDemoData()); // TODO update to use real data here.

		// SETUP IDEAL BURNDOWN CURVE
		addCurve();
		getCurve().setYAxis(Y_AXIS);
		getCurve().getSymbol().setSymbolType(SymbolType.LINE);
		getCurve().getSymbol().setHovertextTemplate(this.idealHoverTextTemplate);
		getCurve().getSymbol().setBorderColor("black");
		getCurve().getSymbol().setBackgroundColor("yellow");

		int sprintCount = this.release.getSprints().size();
		double taskSum = getCurve(0).getPoint(0).getY(); // TODO maybe use actual sum of efforts later
		for (int i = 0; i < sprintCount; i++) {
			getCurve().addPoint(i, taskSum / (sprintCount-1) * (sprintCount-1 - i));
		}

		// SETUP X- AND Y-AXIS
		getXAxis().setAxisLabel("<i>S p r i n t s</i>");
		getXAxis().setTickCount(sprintCount);

		getYAxis().setAxisLabel("<i>P<br />B<br />I<br />s</i>");
		getYAxis().setHasGridlines(true);

		// UPDATE - THIS IS NECESSARY FOR SOME REASON
		this.update();
	}

	/**
	 * This is used to initialize the chart with data.
	 * @param chartData a list of ReleaseChartData. RCD is a container format for chart data.
	 */
	private void addBurndownData(ArrayList<ReleaseChartData> chartData) {
		for (ReleaseChartData data : chartData) {
			this.getCurve(0).addPoint(data.getNumber(), data.getValue());
		}
	}

	/**
	 * This is to generate realistic demonstration data.
	 * @return a list of ReleaseChartData. RCD is a container format for chart data.
	 */
	private ArrayList<ReleaseChartData> generateDemoData() {

		ArrayList<ReleaseChartData> resultList = new ArrayList<ReleaseChartData>();

		//		ArrayList<Date> daysInvolved = CalendarUtils.getAListOfDatesFromParam1ToParam2(this.sprint.getBegin(), this.sprint.getEnd());
		//		int dayCount = daysInvolved.size();
		//		Date today = new Date();
		//		int taskCount = (int) (Math.random() * 100 + 50);
		//
		//		for (int i = 0; i < dayCount; i++) {
		//			if (daysInvolved.get(i).before(today)) {
		//				int ideal = taskCount / (dayCount-1) * (dayCount-1 - i);
		//				double deviation = Math.random() * 0.4 + 0.8;
		//
		//				resultList.add(new SprintChartData(daysInvolved.get(i), (int) (ideal*deviation)));
		//			} else {
		//				resultList.add(new SprintChartData(daysInvolved.get(i), 0));
		//			}
		//		}

		for (ISprint sprint : this.release.getSprints()) {
			for (int i = 0; i < this.release.getSprints().size(); i++) {
				resultList.add(new ReleaseChartData(i, sprint, (int) (Math.random() * 100 + 50)));
			}
		}
		return resultList;
	}
}