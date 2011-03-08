package fhdw.ipscrum.client.view.widgets.charts;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import fhdw.ipscrum.shared.model.SetUpTestData;
import fhdw.ipscrum.shared.model.Sprint;

public class BurndownChartTest extends SetUpTestData {

	private static SprintBurndownChart sbdc;


	@Test
	public void testGenerateTrendcurve() {
		ArrayList<Double> pointList = new ArrayList<Double>();
		pointList.add(5d);
		pointList.add(4d);
		pointList.add(3d);
		pointList.add(2d);

		sbdc.generateTrendcurve(pointList);
		assertTrue(sbdc.trendCurve.getPoint(0).getY() == 0d);
	}

}
