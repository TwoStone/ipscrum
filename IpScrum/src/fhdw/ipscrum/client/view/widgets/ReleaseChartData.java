package fhdw.ipscrum.client.view.widgets;

import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * This class represents a data container for Release Burndown-Charts.
 */
public class ReleaseChartData {

	private final double number;
	private final ISprint sprint;
	private final int value;

	public ReleaseChartData(double number, ISprint sprint, int value) {
		this.number = number;
		this.sprint = sprint;
		this.value = value;
	}

	public double getNumber() {
		return number;
	}

	public ISprint getSprint() {
		return sprint;
	}

	public int getValue() {
		return value;
	}


}
