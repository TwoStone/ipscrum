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
	private ToReleaseAssoc toReleaseAssoc;
	private ToPBIAssoc toPBIAssoc;

	@SuppressWarnings("unused")
	private Sprint() {
	}

	public Sprint(String name, String description, Date begin, Date end, ITeam team) throws NoValidValueException {
		super();
		setName(name);
		setDescription(description);
		setTimeFrame(begin, end);
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
	public void setTimeFrame(Date begin, Date end) throws NoValidValueException {
		if (begin == null || end == null) {
			throw new NoValidValueException(fhdw.ipscrum.shared.constants.ExceptionConstants.NO_VALID_DATE_ERROR);
		} else if (end.before(begin)) {
			throw new NoValidValueException(fhdw.ipscrum.shared.constants.ExceptionConstants.END_BEFORE_BEGIN_ERROR);
		} else {
			this.begin = begin;
		}
	}

	@Override
	public Date getEnd() {
		return this.end;
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
		return this.getName();
	}

	@Override
	public int indirectHashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public int hashCode() {
		return indirectHashCode();
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		return indirectEquals(obj);
	}
}
