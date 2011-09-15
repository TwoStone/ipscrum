package fhdw.ipscrum.shared.commands.interfaces;

import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.nonMeta.Project;

/**
 * Type Interface for all Commands. Command Interfaces are neccessary for the
 * Visitor-Pattern. The Command-Interfaces do not specify any operations but accept().
 */
public interface ICommand {
	/**
	 * Accept a visitor.
	 * 
	 * @param visitor
	 *            the visitor
	 * @throws IPScrumGeneralException
	 *             if one of the used methods fails
	 */
	void accept(CommandVisitor visitor) throws IPScrumGeneralException;

	/**
	 * Necessary for authority checks.
	 * 
	 * @return true, if the command is project specific.
	 */
	boolean dependsOnProject();

	/**
	 * @param model
	 *            the model
	 * @return the project that a command belongs to, if it depends on a specific project.
	 * @throws NoObjectFindException
	 *             if NoProject was found
	 */
	Project getDependingProject(final Model model) throws NoObjectFindException;
}
