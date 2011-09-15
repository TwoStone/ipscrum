package fhdw.ipscrum.client.eventargs;

import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.shared.model.metamodel.search.ISearchExpression;
import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * represents an event argument which knows the release search criterion.
 */
public class ReleaseSearchCriterionArgs extends EventArgs {
	/**
	 * represents the search expression attached to the event argument.
	 */
	private final ISearchExpression se;

	/**
	 * represents the release attached to the event argument.
	 */
	private final Release release;

	/**
	 * constructor of the ReleaseSearchCriterionArgs.
	 * 
	 * @param se
	 *            is the related search expression
	 * @param release
	 *            is the related release
	 */
	public ReleaseSearchCriterionArgs(final ISearchExpression se, final Release release) {
		super();
		this.se = se;
		this.release = release;
	}

	/**
	 * getter of the search expression.
	 * 
	 * @return the search expression
	 */
	public ISearchExpression getSe() {
		return this.se;
	}

	/**
	 * getter of the release.
	 * 
	 * @return the release
	 */
	public Release getRelease() {
		return this.release;
	}

}
