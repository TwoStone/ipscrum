package fhdw.ipscrum.client.view.widgets.charts;

/**
 * Visitor for type differentiation of Chart widgets.
 */
public interface ChartWidgetVisitor {

	/**
	 * specific visitor action.
	 * 
	 * @param velocityChart
	 *            concrete chart widget.
	 */
	void handleVelocityChart(VelocityChart velocityChart);

	/**
	 * specific visitor action.
	 * 
	 * @param releaseBurndownChart
	 *            chart widget.
	 */
	void handleReleaseBurndownChart(ReleaseBurndownChart releaseBurndownChart);

	/**
	 * specific visitor action.
	 * 
	 * @param sprintBurndownChart
	 *            chart widget.
	 */
	void handleSprintBurndownChart(SprintBurndownChart sprintBurndownChart);
}
