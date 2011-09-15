package fhdw.ipscrum.shared.model.metamodel.search;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Manages a list of stored SearchExpressions and initiates a search.
 */
public class SearchManager implements Serializable {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 1309138599428533013L;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	public SearchManager() {
	}

	/**
	 * Initiate a search for a given list of PBIs based on a specific search expression.
	 * 
	 * @param elements
	 *            Elements for search.
	 * @param expression
	 *            Search Expression
	 * @return Returns a list of PBIs where the compare of each pbi with the search
	 *         expression was successful.
	 */
	public List<Ticket> search(final Collection<Ticket> elements,
			final ISearchExpression expression) {

		final Vector<Ticket> resultList = new Vector<Ticket>();
		for (final Ticket current : elements) {
			if (expression.search(current)) {
				resultList.add(current);
			}
		}

		return resultList;
	}
}
