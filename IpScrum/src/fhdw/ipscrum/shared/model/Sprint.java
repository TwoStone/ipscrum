package fhdw.ipscrum.shared.model;

import java.util.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

public class Sprint implements ISprint {
	private String name;
	private String description;
	private Date begin;
	private Date end;
	private ITeam team;
	private final ToReleaseAssoc toReleaseAssoc;
	private final ToPBIAssoc toPBIAssoc;

	public Sprint(String name, String description, Date begin, Date end, ITeam team) throws NoValidValueException {
		// TODO Christin: Patrick wg. Abhängigkeit Projekt fragen
		super();
		setName(name);
		setDescription(description);
		setBegin(begin);
		setEnd(end);
		setTeam(team);
		this.toReleaseAssoc = new ToReleaseAssoc(this);
		this.toPBIAssoc = new ToPBIAssoc(this);
	}

	@Override
	public ToReleaseAssoc getToReleaseAssoc() {
		return this.toReleaseAssoc;
	}

	@Override
	public ToPBIAssoc getToPBIAssoc() {
		return this.toPBIAssoc;
	}

	@Override
	public void setName(String name) throws NoValidValueException {
		if (name == null || name.length() == 0 || name.length() > 20) {
			throw new NoValidValueException(fhdw.ipscrum.shared.constants.ExceptionConstants.SPRINT_NAME_ERROR);
		} else {
			this.name = name;
		}
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public Date getBegin() {
		return this.begin;
	}

	@Override
	public void setBegin(Date begin) throws NoValidValueException {
		if (begin == null || begin.before(new Date())) {
			throw new NoValidValueException(fhdw.ipscrum.shared.constants.ExceptionConstants.NO_VALID_DATE_ERROR);
		} else {
			this.begin = begin;
		}
	}

	@Override
	public Date getEnd() {
		return this.end;
	}

	@Override
	public void setEnd(Date end) throws NoValidValueException {
		if (end == null || end.before(new Date())) {
			throw new NoValidValueException(fhdw.ipscrum.shared.constants.ExceptionConstants.NO_VALID_DATE_ERROR);
		} else {
			this.end = end;
		}
	}

	@Override
	public ITeam getTeam() {
		return this.team;
	}

	@Override
	public void setTeam(ITeam team) throws NoValidValueException {
		if (team == null) {
			throw new NoValidValueException(fhdw.ipscrum.shared.constants.ExceptionConstants.NO_TEAM_SELECTED_ERROR);
		} else {
			this.team = team;
		}
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
		for (ProductBacklogItem.ToSprintAssoc pbiAssocs : this.toPBIAssoc.getAssociations()) {
			ret.add(pbiAssocs.getElement());
		}
		return ret;
	}

	@Override
	public String getName() {
		return this.name;
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
		result = prime * result + ((this.begin == null) ? 0 : this.begin.hashCode());
		result = prime * result + ((this.description == null) ? 0 : this.description.hashCode());
		result = prime * result + ((this.end == null) ? 0 : this.end.hashCode());
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = indirectHashCode();
		result = prime * result + ((this.team == null) ? 0 : this.team.hashCode());
		result = prime * result + ((this.toPBIAssoc == null) ? 0 : this.toPBIAssoc.hashCode());
		result = prime * result + ((this.toReleaseAssoc == null) ? 0 : this.toReleaseAssoc.hashCode());
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
		if (this.begin == null) {
			if (other.begin != null)
				return false;
		} else if (!this.begin.equals(other.begin))
			return false;
		if (this.description == null) {
			if (other.description != null)
				return false;
		} else if (!this.description.equals(other.description))
			return false;
		if (this.end == null) {
			if (other.end != null)
				return false;
		} else if (!this.end.equals(other.end))
			return false;
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (!indirectEquals(obj))
			return false;
		Sprint other = (Sprint) obj;
		if (this.team == null) {
			if (other.team != null)
				return false;
		} else if (!this.team.equals(other.team))
			return false;
		if (this.toPBIAssoc == null) {
			if (other.toPBIAssoc != null)
				return false;
		} else if (!this.toPBIAssoc.equals(other.toPBIAssoc))
			return false;
		if (this.toReleaseAssoc == null) {
			if (other.toReleaseAssoc != null)
				return false;
		} else if (!this.toReleaseAssoc.equals(other.toReleaseAssoc))
			return false;
		return true;
	}
}
