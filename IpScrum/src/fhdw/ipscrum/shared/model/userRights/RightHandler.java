package fhdw.ipscrum.shared.model.userRights;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.commands.interfaces.ICommand;
import fhdw.ipscrum.shared.commands.search.SearchCreateCommand;
import fhdw.ipscrum.shared.commands.search.SearchDeleteCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor;
import fhdw.ipscrum.shared.model.Model;

/**
 * Handler (visitor) for user Rights. A right handler decides which user action is allowed. Each concrete right handler
 * belongs to a concrete Right.
 */
abstract class RightHandler extends CommandStandardVisitor implements IsSerializable {

	/**
	 * concrete user right.
	 */
	private final Right myRight;
	/**
	 * the model.
	 */
	private final Model model;

	/**
	 * Creates a new Right Handler.
	 * 
	 * @param myRight
	 *            the concrete Right.
	 * @param model
	 *            the model.
	 */
	protected RightHandler(final Right myRight, final Model model) {
		this.myRight = myRight;
		this.model = model;
	}

	@Override
	public void standardHandling(final ICommand command) {
		this.notAllowed();
	}

	/**
	 * Signal to the right that a command is allowed.
	 */
	protected void allowed() {
		this.myRight.allowed();
	}

	/**
	 * Signal to the right that a command is not allowed.
	 */
	protected void notAllowed() {
		this.myRight.notAllowed();
	}

	/**
	 * 
	 * @return the model.
	 */
	protected Model getModel() {
		return this.model;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor#handleSearchCreateCommand
	 * (fhdw.ipscrum.shared.commands.search.SearchCreateCommand)
	 */
	@Override
	public void handleSearchCreateCommand(final SearchCreateCommand searchCreateCommand) {
		this.myRight.allowed();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.shared.commands.visitor.CommandStandardVisitor#handleSearchDeleteCommand
	 * (fhdw.ipscrum.shared.commands.search.SearchDeleteCommand)
	 */
	@Override
	public void handleSearchDeleteCommand(final SearchDeleteCommand searchDeleteCommand) {
		this.myRight.allowed();
	}

}
