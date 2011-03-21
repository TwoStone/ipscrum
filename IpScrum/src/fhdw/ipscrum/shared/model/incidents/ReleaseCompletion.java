package fhdw.ipscrum.shared.model.incidents;

import java.util.Iterator;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRelease;

public class ReleaseCompletion extends PredefinedIssue {
	private static final long serialVersionUID = 2063913228231619689L;
	
	private IRelease release;
	
	protected ReleaseCompletion(IRelease release){
		super();
		this.release = release;
		this.setGlobal(false);
	}
	
	@SuppressWarnings("unused")
	private ReleaseCompletion(){}
	
	public final IRelease getRelease(){
		return this.release;
	}

	@Override
	public Iterator<IPerson> getParticipants() {
		// TODO Auto-generated method stub
		return null;
	}
}
