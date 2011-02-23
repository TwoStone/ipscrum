package fhdw.ipscrum.client.view.widgets;

import java.util.Date;

/**
 * This class represents a data container for Sprint Burndown-Charts.
 */
public class SprintChartData {

	private final Date date;
	private final int value;



	public SprintChartData(Date date, int value) {
		this.date = date;
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public int getValue() {
		return value;
	}

}
