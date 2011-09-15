package fhdw.ipscrum.shared.model.visitor;

import fhdw.ipscrum.shared.model.userRights.ProductBacklogRight;
import fhdw.ipscrum.shared.model.userRights.ProjectHistoryRight;
import fhdw.ipscrum.shared.model.userRights.ProjectRight;
import fhdw.ipscrum.shared.model.userRights.TaskboardRight;

/**
 * a visitor for user rights.
 */
public interface RightVisitor extends AdminRightVisitor {

	/**
	 * handles concrete right.
	 * 
	 * @param productBacklogRight
	 *            concrete right.
	 */
	void handleProductBacklogRight(ProductBacklogRight productBacklogRight);

	/**
	 * handles concrete right.
	 * 
	 * @param projectRight
	 *            concrete right.
	 */
	void handleProjectRight(ProjectRight projectRight);

	/**
	 * handles concrete right.
	 * 
	 * @param projectHistoryRight
	 *            concrete right.
	 */
	void handleProjectHistoryRight(ProjectHistoryRight projectHistoryRight);

	/**
	 * handles concrete right.
	 * 
	 * @param taskboardRight
	 *            concrete right.
	 */
	void handleTaskboardRight(TaskboardRight taskboardRight);

}
