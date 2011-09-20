package fhdw.ipscrum.client.view.widgets.charts;

import java.util.List;

import com.googlecode.gchart.client.GChart;

/**
 * This is to display a detailed burndown-chart. While presenting actual burndown-data
 * this also includes an ideal-line and a trend-estimation.
 */
public abstract class BurndownChart extends GChart {

	/**
	 * Represents the burndown curve.
	 */
	Curve burndownCurve;
	/**
	 * Represents the ideal burndown curve.
	 */
	Curve idealCurve;
	/**
	 * Represents the trend curve of the burndown.
	 */
	Curve trendCurve;
	private int chartWidth;
	private int chartHeight;

	/**
	 * This is to analyze the chart-data an draw the trend-line.
	 */
	protected void generateTrendcurve(final List<Double> tickData) {
		/* calculate averages */
		double xAvg = 0d;
		double yAvg = 0d;
		for (int i = 0; i < this.burndownCurve.getNPoints(); i++) {
			xAvg += i;
			yAvg += this.burndownCurve.getPoint(i).getY();
		}
		xAvg = xAvg / this.burndownCurve.getNPoints();
		yAvg = yAvg / this.burndownCurve.getNPoints();

		/* calculate m (slope or gradient) */
		double calcVar1 = 0d;
		double calcVar2 = 0d;
		for (int i = 0; i < this.burndownCurve.getNPoints(); i++) {
			calcVar1 += (i - xAvg) * (this.burndownCurve.getPoint(i).getY() - yAvg);
			calcVar2 += Math.pow(i - xAvg, 2);
		}
		final double m = calcVar1 / calcVar2;

		/* calculate q (y-intercept) */
		final double q = yAvg - m * xAvg;

		/* draw trend curve */
		for (int i = 0; i < tickData.size(); i++) {
			final double value = m * i + q;
			if (value >= 0) {
				this.trendCurve.addPoint(tickData.get(i), value);
			}
		}
	}

	/**
	 * Getter of the width of the chart.
	 * 
	 * @return the width
	 */
	public int getChartWidth() {
		return this.chartWidth;
	}

	/**
	 * Setter of the width of the chart.
	 * 
	 * @param chartWidth
	 *            to set
	 */
	public void setChartWidth(final int chartWidth) {
		this.chartWidth = chartWidth;
	}

	/**
	 * Getter of the height of the chart.
	 * 
	 * @return the height of the chart
	 */
	public int getChartHeight() {
		return this.chartHeight;
	}

	/**
	 * Setter of the height of the chart.
	 * 
	 * @param chartHeight
	 *            to set
	 */
	public void setChartHeight(final int chartHeight) {
		this.chartHeight = chartHeight;
	}
}
