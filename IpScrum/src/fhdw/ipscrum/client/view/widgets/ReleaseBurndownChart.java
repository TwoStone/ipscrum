package fhdw.ipscrum.client.view.widgets;

import java.util.ArrayList;
import java.util.Vector;

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
	private final String idealHoverTextTemplate = "<html><div class='chartToolTip'>Ideal-Burndown<br />(${y} ausstehende Aufwaende nach Sprint ${x})</div>";
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
		getCurve().getSymbol().setBackgroundColor("GreenYellow ");
		getCurve().getSymbol().setBorderColor("Green");
		getCurve().getSymbol().setBorderWidth(1);
		getCurve().getSymbol().setModelWidth(0.05);

		if (this.release.getSprints().size() > 0) {

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

			// SETUP TREND LINE
			/* formatting */
			addCurve();
			getCurve().setYAxis(Y_AXIS);
			getCurve().getSymbol().setSymbolType(SymbolType.LINE);
			getCurve().getSymbol().setHoverAnnotationEnabled(false);
			getCurve().getSymbol().setWidth(1);
			getCurve().getSymbol().setHeight(1);
			getCurve().getSymbol().setBorderColor("grey");
			getCurve().getSymbol().setBackgroundColor("grey");

			/* calculate averages */
			double xAvg = 0d; double yAvg = 0d;
			for (int i = 0; i < getCurve(0).getNPoints(); i++) {
				xAvg += i;
				yAvg += getCurve(0).getPoint(i).getY();
			}
			xAvg = xAvg/getCurve(0).getNPoints();
			yAvg = yAvg/getCurve(0).getNPoints();

			/* calculate m (slope or gradient) */
			double calcVar1 = 0d; double calcVar2 = 0d;
			for (int i = 0; i < getCurve(0).getNPoints(); i++) {
				calcVar1 += (i-xAvg)*(getCurve(0).getPoint(i).getY()-yAvg);
				calcVar2 += Math.pow(i-xAvg, 2);
			}
			double m = calcVar1 / calcVar2;

			/* calculate q (y-intercept) */
			double q = yAvg - m * xAvg;

			/* draw trend curve */
			for (int i = 0; i < getCurve(0).getNPoints(); i++) {
				double value = m * i + q;
				if (value>=0) {
					getCurve().addPoint(getCurve(0).getPoint(i).getX(), value);
				}
			}
		}

		// SETUP X- AND Y-AXIS
		getXAxis().setAxisLabel("<i>S p r i n t s</i>");
		getXAxis().setTickCount(getCurve(0).getNPoints());

		getYAxis().setAxisLabel("<i>P<br />B<br />I<br />s</i>");
		getYAxis().setHasGridlines(true);
		//		getYAxis().setTickLabelFormat("#");
		getYAxis().setTickLength(25);

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
		Vector<ISprint> sprints = this.release.getSprints();

		int pbiCount = (int) (Math.random() * 5 + 3);

		for (int i = 0; i < sprints.size(); i++) {
			int ideal = pbiCount / sprints.size() * (sprints.size() - i);
			double deviation = Math.random() * 0.3 + 0.85;
			resultList.add(new ReleaseChartData(i, sprints.get(i), (int) (ideal * deviation)));
		}
		return resultList;
	}
}