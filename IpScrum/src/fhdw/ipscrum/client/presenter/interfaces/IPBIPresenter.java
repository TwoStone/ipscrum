package fhdw.ipscrum.client.presenter.interfaces;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.ForbiddenStateException;
import fhdw.ipscrum.shared.exceptions.NoSprintDefinedException;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.exceptions.UserException;

public interface IPBIPresenter {
	/**
	 * Registers the presenter to all events of the view.
	 */
	void registerViewEvents();

	/**
	 * /** Sets the values of the loaded feature in the view.
	 */
	void setupView();

	/**
	 * Updates the view with the values of the feature. Does not set name and description. Call setupView to set them.
	 */
	void updateView();

	/**
	 * Updates the loaded feature with the values set in the view.
	 */
	void updatePBI() throws NoValidValueException, NoSprintDefinedException, ConsistencyException, DoubleDefinitionException, ForbiddenStateException, UserException;
}
