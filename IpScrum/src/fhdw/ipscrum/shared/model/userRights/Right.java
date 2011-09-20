package fhdw.ipscrum.shared.model.userRights;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.visitor.RightVisitor;

/**
 * Rights defines allowed actions (commands) that a user can execute. Rights are contained
 * in roles, which can be assigned to persons.
 */
public abstract class Right extends IdentifiableObject {
	/**
	 * serial version uid.
	 */
	private static final long serialVersionUID = 8345351822949921032L;

	/**
	 * concrete handler. It is a visitor for commands and decides if an action is allowed
	 * or not.
	 */
	private transient RightHandler handler;
	/**
	 * this boolean attribute is the result of an authority check. the default is false,
	 * but it can be true after a successful authority check.
	 */
	private transient boolean allowed = false;

	/**
	 * default constructor for serialization.
	 */
	protected Right() {
		super();
	}

	/**
	 * Creates a new Right-Object.
	 * 
	 * @param model
	 *            {@link Model}
	 */
	public Right(final Model model) {
		super(model);
		this.allowed = false;
		this.handler = this.specifyHandler();
		this.putToObjectStore();
	}

	/**
	 * template method. specifies a concrete handler (visitor) for the concrete right.
	 * 
	 * @return a concrete right handler.
	 */
	protected abstract RightHandler specifyHandler();

	/**
	 * 
	 * @return the concrete handler.
	 */
	private RightHandler getHandler() {
		if (this.handler == null) {
			this.handler = this.specifyHandler();
		}
		return this.handler;
	}

	/**
	 * determine that an authority check failed.
	 */
	protected void notAllowed() {
		this.allowed = false;
	}

	/**
	 * determines that an authority check was successful.
	 */
	protected void allowed() {
		this.allowed = true;
	}

	/**
	 * Checks if the command can be executed.
	 * 
	 * @param command
	 *            Command which is asked to be executed
	 * @return true if the action is allowed
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public boolean canBeExecuted(final ICommand command) throws IPScrumGeneralException {
		this.notAllowed();
		command.accept(this.getHandler());
		return this.allowed;
	}

	/**
	 * Accepting a visitor.
	 * 
	 * @param visitor
	 *            {@link RightVisitor}
	 */
	public abstract void accept(RightVisitor visitor);

}
