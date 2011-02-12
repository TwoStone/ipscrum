package fhdw.ipscrum.shared.model.interfaces;

import java.util.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.bdas.BDAManyToMany;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Release;
import fhdw.ipscrum.shared.model.Sprint;

public interface ISprint {

	public Date getBegin();

	public void setBegin(Date begin);

	public Date getEnd();

	public void setEnd(Date end);

	public ITeam getTeam();

	public void setTeam(ITeam team);

	public void setDescription(String description);

	public String getDescription();

	public IRelease getRelease();

	public Vector<ProductBacklogItem> getPBIs();

	public String getName();

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
