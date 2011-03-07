package fhdw.ipscrum.client.view.widgets.charts;

import java.util.List;

public interface ChartData {

	abstract void calculateData();
	abstract List<Double> getConsiderableDatapoints();
}
