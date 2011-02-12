package fhdw.ipscrum.shared.model;

import java.util.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDAManyToMany;
import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class Sprint implements ISprint {
	private String description;
	private Date begin;
	private Date end;
	private Team team;
	private final ToReleaseAssoc toReleaseAssoc;

	class ToReleaseAssoc extends BDAManyToMany<Release.ToSprintAssoc, Sprint> {

		public ToReleaseAssoc(Sprint element) {
			super(element);
		}
	}

	public Sprint(Date begin, Date end, Team team) {
		super();
		this.begin = begin;
		this.end = end;
		this.team = team;
		this.toReleaseAssoc = new ToReleaseAssoc(this);
	}

	public ToReleaseAssoc getToReleaseAssoc() {
		return toReleaseAssoc;
	}

	@Override
	public Date getBegin() {
		return begin;
	}

	@Override
	public void setBegin(Date begin) {
		this.begin = begin;
	}

	@Override
	public Date getEnd() {
		return end;
	}

	@Override
	public void setEnd(Date end) {
		this.end = end;
	}

	@Override
	public Team getTeam() {
		return team;
	}

	@Override
	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((begin == null) ? 0 : begin.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sprint other = (Sprint) obj;
		if (begin == null) {
			if (other.begin != null)
				return false;
		} else if (!begin.equals(other.begin))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String ret = "Sprint";
		if (this.getTeam() != null) {
			ret += " mit " + this.getTeam();
		}
		if (this.getBegin() != null) {
			ret += " beginnt am " + this.getBegin();
		}
		if (this.getEnd() != null) {
			ret += " endet am " + this.getEnd();
		}
		return ret;
	}

	@Override
	public void setRelease(IRelease release) {
		// TODO Auto-generated method stub

	}

	@Override
	public IRelease getRelease() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector<ProductBacklogItem> getPBIs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return this.toString();
	}

	@Override
	public void addPBI(ProductBacklogItem pbi) throws ConsistencyException {
		// TODO Auto-generated method stub

	} 

	@Override
	public void removePBI(ProductBacklogItem pbi) throws ConsistencyException {
		// TODO Auto-generated method stub

	}
	@Override
	public void setDescription(String description) {
		this.description = description; 
	}
	@Override
	public String getDescription() {
		return description; 
	}
}
