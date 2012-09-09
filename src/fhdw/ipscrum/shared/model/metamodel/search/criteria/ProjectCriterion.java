package fhdw.ipscrum.shared.model.metamodel.search.criteria;

import fhdw.ipscrum.shared.model.metamodel.search.SearchCriteria;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Represents the SearchCriterion for the Project.
 */
@SuppressWarnings("serial")
public class ProjectCriterion extends SearchCriteria {

	@Override
	public boolean search(final Ticket ticket) {
		// TODO return ticket.getProject.equals(this.project);
		return false;
	}

}
