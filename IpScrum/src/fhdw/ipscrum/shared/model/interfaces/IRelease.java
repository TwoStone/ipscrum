package fhdw.ipscrum.shared.model.interfaces;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.BDAManyToMany;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.exceptions.UserException;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Sprint;

public interface IRelease extends BDACompare, Serializable {

	public abstract Vector<ISprint> getSprints();

	public abstract void addSprint(ISprint sprint) throws UserException;

	public abstract void removeSprint(ISprint sprint);

	public abstract Project getProject() throws ConsistencyException;

	public abstract Integer countSprints();

	public abstract String getVersion();

	public abstract void setVersion(String version);

	public abstract Date getReleaseDate();

	public abstract void setReleaseDate(Date releaseDate);

	public abstract Release.ToProjectAssoc getProjectAssoc();

	public abstract Release.ToSprintAssoc getSprintAssoc();

	public abstract void removeAllSprints();

	public class ToSprintAssoc extends
			BDAManyToMany<Sprint.ToReleaseAssoc, Release> {
		public ToSprintAssoc(final Release element) {
			super(element);
		}
	}

	public class ToProjectAssoc extends
			BDAManyToMany<Project.ToReleaseAssoc, IRelease> {
		public ToProjectAssoc(final Release element) {
			super(element);
		}
	}
}