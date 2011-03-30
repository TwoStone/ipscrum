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
	
	protected PBICompletion(String name, String description,ProductBacklogItem pbi){
		super(name, description);
		this.pbi = pbi;
		this.participant = SessionManager.getInstance().getLoginUser();
		this.setGlobal(false);
	}

	protected final ProductBacklogItem getPbi() {
		return pbi;
	}

	protected final IPerson getParticipant() {
		return participant;
	}

	@Override
	protected Iterator<IPerson> getParticipantsIterator() {
		Vector<IPerson> result = new Vector<IPerson>();
		result.add(this.getParticipant());
		return result.iterator();
	}

	@Override
	protected Vector<IPerson> getParticipants() {
		Vector<IPerson> result = new Vector<IPerson>();
		result.add(this.getParticipant());
		return result;
	}

	
	
}
