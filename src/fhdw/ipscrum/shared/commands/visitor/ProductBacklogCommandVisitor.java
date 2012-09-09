package fhdw.ipscrum.shared.commands.visitor;

import fhdw.ipscrum.shared.commands.productBacklog.BugCreateCommand;
import fhdw.ipscrum.shared.commands.productBacklog.FeatureCreateCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIAddRelationCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIPriorityDecreaseCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIPriorityIncreaseCommand;
import fhdw.ipscrum.shared.commands.productBacklog.PBIRemoveRelationCommand;
import fhdw.ipscrum.shared.commands.productBacklog.RelationTypeCreateCommand;

/**
 * A visitor class for visiting product backlog commands.
 */
public interface ProductBacklogCommandVisitor {

	/**
	 * specific visitor action.
	 * 
	 * @param bugCreateCommand
	 *            concrete command.
	 */
	void handleBugCreateCommand(BugCreateCommand bugCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param featureCreateCommand
	 *            concrete command.
	 */
	void handleFeatureCreateCommand(FeatureCreateCommand featureCreateCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param pBIAddRelationCommand
	 *            concrete command.
	 */
	void handlePBIAddRelationCommand(PBIAddRelationCommand pBIAddRelationCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param pBIPriorityDecreaseCommand
	 *            concrete command.
	 */
	void handlePBIPriorityDecreaseCommand(PBIPriorityDecreaseCommand pBIPriorityDecreaseCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param pBIPriorityIncreaseCommand
	 *            concrete command.
	 */
	void handlePBIPriorityIncreaseCommand(PBIPriorityIncreaseCommand pBIPriorityIncreaseCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param pBIRemoveRelationCommand
	 *            concrete command.
	 */
	void handlePBIRemoveRelationCommand(PBIRemoveRelationCommand pBIRemoveRelationCommand);

	/**
	 * specific visitor action.
	 * 
	 * @param relationTypeCreateCommand
	 *            concrete command.
	 */
	void handleRelationTypeCreateCommand(RelationTypeCreateCommand relationTypeCreateCommand);
}
