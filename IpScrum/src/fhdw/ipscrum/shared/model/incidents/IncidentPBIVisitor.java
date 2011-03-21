package fhdw.ipscrum.shared.model.incidents;

import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.Bug;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

final class IncidentPBIVisitor implements IProductBacklogItemVisitor {
	
	private String resultName;
	private String resultDescription;
	
	protected IncidentPBIVisitor(){
		super();
	}
	@Override
	public void handleBug(Bug bug) {
		this.resultName = TextConstants.INCIDENT_PBICOMPLETION_NAME2;
		this.resultDescription = TextConstants.INCIDENT_PBICOMPLETION_DESCR_PREFIX2
						  + bug.getName() 
						  + TextConstants.INCIDENT_PBICOMPLETION_DESCR_INFIX1
						  + SessionManager.getInstance().getLoginUser()
						  + TextConstants.INCIDENT_PBICOMPLETION_DESCR_SUFFIX2;
	}

	@Override
	public void handleFeature(Feature feature) {
		this.resultName = TextConstants.INCIDENT_PBICOMPLETION_NAME1;
		this.resultDescription = TextConstants.INCIDENT_PBICOMPLETION_DESCR_PREFIX1
						  + feature.getName() 
						  + TextConstants.INCIDENT_PBICOMPLETION_DESCR_INFIX1
						  + SessionManager.getInstance().getLoginUser()
						  + TextConstants.INCIDENT_PBICOMPLETION_DESCR_SUFFIX1;
	}
	
	public String getResultName(){
		return this.resultName;
	}
	public String getResultDescription(){
		return this.resultDescription;
	}

}
