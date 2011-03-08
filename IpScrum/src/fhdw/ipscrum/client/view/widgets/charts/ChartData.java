package fhdw.ipscrum.client.view.widgets.charts;

import java.util.List;

/**
 * This interface groups ChartData-Classes.
 */
public interface ChartData {

	/**
	 * This is to obtain a list of data-points for the trend-calculation.
	 * @return a list of data-points.
	 */
	abstract List<Double> getTickData();
}
