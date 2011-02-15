package fhdw.ipscrum.shared.model.interfaces;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDACompare;
import fhdw.ipscrum.shared.bdas.BDAManyToMany;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Sprint;

public interface ISprint extends BDACompare, Serializable {
	public String getDescription();

	public void setDescription(String description);

	public String getName();

	public void setName(String description) throws NoValidValueException;

	public Date getBegin();

	public Date getEnd();

	public void setTimeFrame(Date begin, Date end) throws NoValidValueException;

	public ITeam getTeam();

	public void setTeam(ITeam team) throws NoValidValueException;

	public IRelease getRelease();

	public Vector<ProductBacklogItem> getPBIs();

	public ToReleaseAssoc getToReleaseAssoc();

	public ToPBIAssoc getToPBIAssoc();

	class ToReleaseAssoc extends BDAManyToMany<Release.ToSprintAssoc, Sprint> {
		public ToReleaseAssoc(Sprint element) {
			super(element);
		}
	}

	class ToPBIAssoc extends BDAManyToMany<ProductBacklogItem.ToSprintAssoc, Sprint> {
		public ToPBIAssoc(Sprint element) {
			super(element);
		}
	}
}
