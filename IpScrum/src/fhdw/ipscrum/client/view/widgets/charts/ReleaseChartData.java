package fhdw.ipscrum.client.view.widgets.charts;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeMap;

import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * This class represents a data container for Release Burndown-Charts.
 */
public class ReleaseChartData {

	private final IRelease release;
	private final TreeMap<Date,ReleaseChartDataDetails> data;

	public ReleaseChartData(IRelease release) {
		this.release = release;
		this.data = new TreeMap<Date,ReleaseChartDataDetails>();
		this.calculateData();
	}

	public IRelease getRelease() {
		return this.release;
	}

	public TreeMap<Date, ReleaseChartDataDetails> getData() {
		return this.data;
	}

	private void calculateData() {
		for (ISprint sprint : this.release.getSprints()) {

			int value = (int) (Math.random() * 10 + 20); // TODO calculate real values here!

			if (this.data.containsKey(sprint.getEnd())) {
				ReleaseChartDataDetails details = this.data.get(sprint.getEnd());
				details.getSprints().add(sprint);
				details.setValue(value);
				this.data.put(sprint.getEnd(), details);
			} else {
				ReleaseChartDataDetails details = new ReleaseChartDataDetails(new ArrayList<ISprint>(), value);
				details.getSprints().add(sprint);
				this.data.put(sprint.getEnd(), details);
			}
		}
	}


	class ReleaseChartDataDetails {
		private final ArrayList<ISprint> sprints;
		private int value;

		public ReleaseChartDataDetails(ArrayList<ISprint> sprints, int value) {
			this.sprints = sprints;
			this.value = value;
		}

		public ArrayList<ISprint> getSprints() {
			return this.sprints;
		}

		public int getValue() {
			return this.value;
		}

		void setValue(int value) {
			this.value = value;
		}
	}


	public Date getFirstDate() {
		Date firstDate = this.release.getReleaseDate();
		Iterator<ReleaseChartDataDetails> i = this.data.values().iterator();
		while (i.hasNext()) {
			ReleaseChartDataDetails current = i.next();
			for (ISprint sprint : current.getSprints()) {
				if (sprint.getBegin().before(firstDate)) {
					firstDate = sprint.getBegin();
				}
			}
		}
		return firstDate;
	}
}
