package fhdw.ipscrum.shared.model.incidents;

import java.util.Iterator;
import java.util.Vector;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRelease;

public class ReleaseCompletion extends PredefinedIssue {
	private static final long serialVersionUID = 2063913228231619689L;
	
	private IRelease release;
	
	protected ReleaseCompletion(String name, String description,IRelease release){
		super(name, description);
		this.release = release;
		this.setGlobal(false);
	}
	
	protected final IRelease getRelease(){
		return this.release;
	}

	@Override
	protected Iterator<IPerson> getParticipantsIterator() {
		return new Vector<IPerson>().iterator();
	}

	@Override
	protected Vector<IPerson> getParticipants() {
		return new Vector<IPerson>();
	}
	
}
