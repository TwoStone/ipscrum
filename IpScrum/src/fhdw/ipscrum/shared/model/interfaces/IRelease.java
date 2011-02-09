package fhdw.ipscrum.shared.model.interfaces;

import java.util.Vector;

import fhdw.ipscrum.shared.model.Project;

public interface IRelease {

	public abstract Vector<ISprint> getSprints();

	public abstract void addSprint(ISprint sprint);

	public abstract void removeSprint(ISprint sprint);

	public abstract Project getProject();

	public abstract Integer countSprints();

}