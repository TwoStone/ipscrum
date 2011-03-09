package fhdw.ipscrum.client.view.widgets.charts;

import java.util.List;

import com.googlecode.gchart.client.GChart;

/**
 * This is to display a detailed burndown-chart.
 * While presenting actual burndown-data this also includes an ideal-line and a trend-estimation.
 */
public abstract class BurndownChart extends GChart {

	Curve burndownCurve;
	Curve idealCurve;
	Curve trendCurve;
	private int chartWidth;
	private int chartHeight;

	/**
	 * This is to analyze the chart-data an draw the trend-line.
	 */
	protected void generateTrendcurve(List<Double> tickData) {
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
		for (int i = 0; i < tickData.size(); i++) {
			double value = m * i + q;
			if (value>=0) {
				trendCurve.addPoint(tickData.get(i), value);
			}
		}
	}

	public int getChartWidth() {
		return this.chartWidth;
	}

	public void setChartWidth(int chartWidth) {
		this.chartWidth = chartWidth;
	}

	public int getChartHeight() {
		return this.chartHeight;
	}

	public void setChartHeight(int chartHeight) {
		this.chartHeight = chartHeight;
	}
}
