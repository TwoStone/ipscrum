package fhdw.ipscrum.client.view.widgets.charts;

import java.util.List;

import com.googlecode.gchart.client.GChart;

public abstract class BurndownChart extends GChart {

	Curve burndownCurve;
	Curve idealCurve;
	Curve trendCurve;
	protected int width;
	protected int height;

	protected abstract void createChart();
	protected abstract void populateChart();

	/**
	 * This is to analyze the chart-data an draw the trend-line.
	 */
	protected void generateTrendcurve(List<Double> considerableDatapoints) {
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
		for (int i = 0; i < considerableDatapoints.size(); i++) {
			double value = m * i + q;
			if (value>=0) {
				trendCurve.addPoint(considerableDatapoints.get(i), value);
			}
		}
	}
}
