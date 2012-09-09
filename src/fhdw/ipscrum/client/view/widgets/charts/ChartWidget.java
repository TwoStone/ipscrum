package fhdw.ipscrum.client.view.widgets.charts;

/**
 * This supertype represents Burndown- and Velocity-Charts.
 */
public interface ChartWidget {
	/**
	 * Accepts a visitor.
	 * 
	 * @param visitor
	 *            {@link ChartWidgetVisitor}
	 */
	void accept(ChartWidgetVisitor visitor);
}
