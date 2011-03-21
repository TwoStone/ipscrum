package fhdw.ipscrum.shared.model.incidents;

import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.interfaces.IPerson;

public class PBICompletion extends PredefinedIssue {
	private static final long serialVersionUID = 1483695334229982692L;
	
	private ProductBacklogItem pbi;
	private IPerson participant;
	
	protected PBICompletion(ProductBacklogItem pbi){
		super();
		this.pbi = pbi;
		this.participant = SessionManager.getInstance().getLoginUser();
		this.setGlobal(false);
	}
	@SuppressWarnings("unused")
	private PBICompletion(){}

	public final ProductBacklogItem getPbi() {
		return pbi;
	}

	private final IPerson getParticipant() {
		return participant;
	}

	@Override
	public final Iterator<IPerson> getParticipants() {
		Vector<IPerson> result = new Vector<IPerson>();
		result.add(this.getParticipant());
		return result.iterator();
	}
	
	
}
