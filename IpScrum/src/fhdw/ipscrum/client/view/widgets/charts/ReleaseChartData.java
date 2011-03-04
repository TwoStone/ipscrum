package fhdw.ipscrum.client.view.widgets.charts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		//		this.calculateDemoData();
		this.calculateData();
	}

	public IRelease getRelease() {
		return this.release;
	}

	public TreeMap<Date, ReleaseChartDataDetails> getData() {
		return this.data;
	}

	private void calculateDemoData() {
		for (ISprint sprint : this.release.getSprints()) {

			int value = (int) (Math.random() * 10 + 20);

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

	private void calculateData() {
		// obaining a sorted list of sprints associated with the release
		ArrayList<ISprint> sortedSprints = new ArrayList<ISprint>(this.getRelease().getSprints());
		Collections.sort(sortedSprints, new Comparator<ISprint>() {
			@Override
			public int compare(ISprint o1, ISprint o2) {
				return o1.getEnd().compareTo(o2.getEnd());
			}
		});


		int overallEfforts = this.getRelease().getOverallEfforts();
		int runningValue = overallEfforts;

		for (ISprint sprint : sortedSprints) {
			
			runningValue -= sprint.getCumulatedManDayCostsOfClosedPbis();

			if (this.data.containsKey(sprint.getEnd())) {
				ReleaseChartDataDetails details = this.data.get(sprint.getEnd());
				details.getSprints().add(sprint);
				details.setValue(runningValue);
				this.data.put(sprint.getEnd(), details);
			} else {
				ReleaseChartDataDetails details = new ReleaseChartDataDetails(new ArrayList<ISprint>(), runningValue);
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


	public Date getStartDateofFirstSprint() {
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

	//	public Date getEndeDateofFirstSprint() {
	//		Date firstDate = this.release.getReleaseDate();
	//		Iterator<ReleaseChartDataDetails> i = this.data.values().iterator();
	//		while (i.hasNext()) {
	//			ReleaseChartDataDetails current = i.next();
	//			for (ISprint sprint : current.getSprints()) {
	//				if (sprint.getBegin().before(firstDate)) {
	//					firstDate = sprint.getBegin();
	//				}
	//			}
	//		}
	//		return firstDate;
	//	}
	//
	//	public Date getEndDateofLastSprint() {
	//		Date firstDate = this.release.getReleaseDate();
	//		Iterator<ReleaseChartDataDetails> i = this.data.values().iterator();
	//		while (i.hasNext()) {
	//			ReleaseChartDataDetails current = i.next();
	//			for (ISprint sprint : current.getSprints()) {
	//				if (sprint.getBegin().before(firstDate)) {
	//					firstDate = sprint.getBegin();
	//				}
	//			}
	//		}
	//		return firstDate;
	//	}
}
