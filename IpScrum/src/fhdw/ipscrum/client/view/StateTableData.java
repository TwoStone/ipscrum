package fhdw.ipscrum.client.view;

import fhdw.ipscrum.shared.model.metamodel.states.StateType;

/**
 * represents the data of the stateTable on the ticketType edit view.
 */
public class StateTableData {

	private final StateType state;
	private final Boolean startState;
	private final Boolean endState;

	/**
	 * constructor of the StateTableData.
	 * 
	 * @param state
	 *            is the related state
	 * @param startState
	 *            is the field if the state is the start state, than it is true
	 * @param endState
	 *            is the field if the state is an end state, than it is true
	 */
	public StateTableData(final StateType state, final Boolean startState, final Boolean endState) {
		super();
		this.state = state;
		this.startState = startState;
		this.endState = endState;
	}

	/**
	 * getter of the state.
	 * 
	 * @return the state
	 */
	public StateType getState() {
		return this.state;
	}

	/**
	 * getter of the boolean to say if it is the startState.
	 * 
	 * @return true if it is the startState
	 */
	public Boolean getStartState() {
		return this.startState;
	}

	/**
	 * getter of the boolean to say if it is an endState.
	 * 
	 * @return true if it is an endState
	 */
	public Boolean getEndState() {
		return this.endState;
	}

}
