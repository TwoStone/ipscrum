package fhdw.ipscrum.shared.model;

import java.util.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

public class Sprint implements ISprint {
	private String description;
	private Date begin;
	private Date end;
	private ITeam team;
	private final ToReleaseAssoc toReleaseAssoc;
	private final ToPBIAssoc toPBIAssoc;

	public Sprint(String description, Date begin, Date end, ITeam team) {
		// TODO Christin: Patrick wg. Abhängigkeit Projekt fragen
		super();
		setDescription(description);
		setBegin(begin);
		setEnd(end);
		setTeam(team);
		this.toReleaseAssoc = new ToReleaseAssoc(this);
		this.toPBIAssoc = new ToPBIAssoc(this);
	}

	@Override
	public ToReleaseAssoc getToReleaseAssoc() {
		return toReleaseAssoc;
	}

	@Override
	public ToPBIAssoc getToPBIAssoc() {
		return toPBIAssoc;
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getDescription() {
		return description;
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
	public ITeam getTeam() {
		return team;
	}

	@Override
	public void setTeam(ITeam team) {
		this.team = team;
	}

	@Override
	public IRelease getRelease() {
		if (this.getToReleaseAssoc().get() != null) {
			return this.getToReleaseAssoc().get().getElement();
		}
		return null;
	}

	@Override
	public Vector<ProductBacklogItem> getPBIs() {
		Vector<ProductBacklogItem> ret = new Vector<ProductBacklogItem>();
		for (ProductBacklogItem.ToSprintAssoc pbiAssocs : toPBIAssoc.getAssociations()) {
			ret.add(pbiAssocs.getElement());
		}
		return ret;
	}

	@Override
	public String getName() {
		return this.toString();
	}

	@Override
	public String toString() {
		String ret = "Sprint";
		if (this.getDescription() != null) {
			ret += " mit " + this.getTeam();
		}
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
	public int indirectHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((begin == null) ? 0 : begin.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = indirectHashCode();
		result = prime * result + ((team == null) ? 0 : team.hashCode());
		result = prime * result + ((toPBIAssoc == null) ? 0 : toPBIAssoc.hashCode());
		result = prime * result + ((toReleaseAssoc == null) ? 0 : toReleaseAssoc.hashCode());
		return result;
	}

	@Override
	public boolean indirectEquals(Object obj) {
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (!indirectEquals(obj))
			return false;
		Sprint other = (Sprint) obj;
		if (team == null) {
			if (other.team != null)
				return false;
		} else if (!team.equals(other.team))
			return false;
		if (toPBIAssoc == null) {
			if (other.toPBIAssoc != null)
				return false;
		} else if (!toPBIAssoc.equals(other.toPBIAssoc))
			return false;
		if (toReleaseAssoc == null) {
			if (other.toReleaseAssoc != null)
				return false;
		} else if (!toReleaseAssoc.equals(other.toReleaseAssoc))
			return false;
		return true;
	}
}
