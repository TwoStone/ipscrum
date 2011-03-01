package fhdw.ipscrum.client.view.widgets.charts;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.googlecode.gchart.client.GChart;
import com.googlecode.gchart.client.GChart.Curve;
import com.googlecode.gchart.client.GChart.Curve.Point;
import com.googlecode.gchart.client.GChart.SymbolType;
import com.googlecode.gchart.client.HoverUpdateable;

import fhdw.ipscrum.client.utils.CalendarUtils;
import fhdw.ipscrum.shared.model.interfaces.IRelease;

public abstract class ReleaseBurndownChart extends Composite {

	IRelease release;
	private final ReleaseChartData data;
	int width = 500;
	int height = 250;

	private Curve burndownCurve;

	public ReleaseBurndownChart(IRelease release) {
		super();
		this.release = release;
		this.data = new ReleaseChartData(this.release);
	}

	GChart createChart() {
		// GENERAL SETUP
		GChart rbdChart = new GChart(width, height);
		rbdChart.setChartTitle("<h2>Release " + this.release.getVersion() + "</h2>");


		// SETUP ACTUAL BURNDOWN CURVE
		rbdChart.addCurve();
		burndownCurve = rbdChart.getCurve();
		burndownCurve.setYAxis(GChart.Y_AXIS);
		burndownCurve.getSymbol().setSymbolType(SymbolType.VBAR_SOUTH);
		burndownCurve.getSymbol().setHoverWidget(new ReleaseChartHoverWidget());
		burndownCurve.getSymbol().setBackgroundColor("GreenYellow");
		burndownCurve.getSymbol().setBorderColor("Green");
		burndownCurve.getSymbol().setBorderWidth(1);
		burndownCurve.getSymbol().setModelWidth(50000000); // high value is caused by using a date as x-value. normally 0.5 would be sufficient.

		this.populateChart();

		if (burndownCurve.getNPoints() > 0) {

			// SETUP IDEAL BURNDOWN CURVE
			rbdChart.addCurve();
			Curve idealCurve = rbdChart.getCurve();
			idealCurve.setYAxis(GChart.Y_AXIS);
			idealCurve.getSymbol().setSymbolType(SymbolType.LINE);
			idealCurve.getSymbol().setHovertextTemplate(GChart.formatAsHovertext("Ideal-Burndown<br />(${y} ausstehende Aufwaende am ${x})"));
			idealCurve.getSymbol().setBorderColor("black");
			idealCurve.getSymbol().setBackgroundColor("yellow");

			ArrayList<Date> daysInvolved = CalendarUtils.getAListOfDatesFromParam1ToParam2(data.getFirstDate(), release.getReleaseDate());
			int dayCount = daysInvolved.size();
			double taskSum = burndownCurve.getPoint(0).getY(); // TODO maybe use actual sum of efforts later
			for (int i = 0; i < dayCount; i++) {
				idealCurve.addPoint(daysInvolved.get(i).getTime(), taskSum / (dayCount-1) * (dayCount-1 - i));
			}


			// SETUP TREND LINE
			/* formatting */
			rbdChart.addCurve();
			Curve trendCurve = rbdChart.getCurve();
			trendCurve.setYAxis(GChart.Y_AXIS);
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
			for (int i = 0; i < burndownCurve.getNPoints(); i++) {
				double value = m * i + q;
				if (value>=0) {
					trendCurve.addPoint(burndownCurve.getPoint(i).getX(), value);
				}
			}


			// set x-axis ticks
			if (this.width > 400) {
				rbdChart.getXAxis().setTickCount((dayCount<26) ? dayCount : 25);
			}
		}

		rbdChart.getXAxis().setAxisLabel("<i>S p r i n t s</i>");
		rbdChart.getXAxis().setTickLabelFormat("=(Date)dd.");

		rbdChart.getYAxis().setAxisLabel("<i>A<br />u<br />f<br />w<br />a<br />e<br />n<br />d<br />e</i>");
		rbdChart.getYAxis().setHasGridlines(true);
		rbdChart.getYAxis().setTickLabelFormat("#");
		rbdChart.getYAxis().setTickLength(25);
		rbdChart.getYAxis().setAxisMin(0);

		// UPDATE - THIS IS NECESSARY FOR SOME REASON
		rbdChart.update();

		return rbdChart;
	}

	/**
	 * This is to populate the chart with release-data.
	 */
	private void populateChart() {
		Iterator<Date> i = data.getData().keySet().iterator();
		while (i.hasNext()) {
			Date current = i.next();
			burndownCurve.addPoint(current.getTime(), data.getData().get(current).getValue());
			burndownCurve.getPoint().setAnnotationText(GChart.formatAsHovertext(data.getData().get(current).getValue() + " ausstehende Aufwände nach " + data.getData().get(current).getSprints().toString())); // TODO stylize and extract constants
			burndownCurve.getPoint().setAnnotationVisible(false);
		}
	}

	class ReleaseChartHoverWidget extends Label implements HoverUpdateable {
		@Override
		public void hoverCleanup(Point hoveredAwayFrom) {
			hoveredAwayFrom.setAnnotationVisible(false);
		}

		@Override
		public void hoverUpdate(Point hoveredOver) {
			hoveredOver.setAnnotationVisible(true);
		}
	}
}