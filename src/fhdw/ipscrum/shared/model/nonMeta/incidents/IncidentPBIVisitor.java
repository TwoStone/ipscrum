package fhdw.ipscrum.shared.model.nonMeta.incidents;

import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.nonMeta.Bug;
import fhdw.ipscrum.shared.model.nonMeta.Feature;
import fhdw.ipscrum.shared.model.visitor.IProductBacklogItemVisitor;

/**
 * represents the visitor for handling PBIIncidents.
 */
final class IncidentPBIVisitor implements IProductBacklogItemVisitor {

	/**
	 * represents the name of the incident.
	 */
	private String resultName;

	/**
	 * represents the description of the incident.
	 */
	private String resultDescription;

	/**
	 * constructor without parameters. needed for serialization.
	 */
	protected IncidentPBIVisitor() {
		super();
	}

	@Override
	public void handleBug(final Bug bug) {
		this.resultName = TextConstants.INCIDENT_PBICOMPLETION_NAME2;
		this.resultDescription =
				TextConstants.INCIDENT_PBICOMPLETION_DESCR_PREFIX2 + bug.getName()
						+ TextConstants.INCIDENT_PBICOMPLETION_DESCR_INFIX1
						+ TextConstants.INCIDENT_PBICOMPLETION_DESCR_SUFFIX2;
	}

	@Override
	public void handleFeature(final Feature feature) {
		this.resultName = TextConstants.INCIDENT_PBICOMPLETION_NAME1;
		this.resultDescription =
				TextConstants.INCIDENT_PBICOMPLETION_DESCR_PREFIX1 + feature.getName()
						+ TextConstants.INCIDENT_PBICOMPLETION_DESCR_INFIX1
						+ TextConstants.INCIDENT_PBICOMPLETION_DESCR_SUFFIX1;
	}

	/**
	 * getter of the result name.
	 * 
	 * @return the current result name
	 */
	public String getResultName() {
		return this.resultName;
	}

	/**
	 * getter of the result description.
	 * 
	 * @return the current result description
	 */
	public String getResultDescription() {
		return this.resultDescription;
	}

}
