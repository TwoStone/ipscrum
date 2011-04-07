package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

/**
 * Represents the search criteria for a concrete Release.
 * 
 * @author wolf
 * 
 */
public class PBIConcreteReleaseCriterion extends SearchCriteria implements
		PBIReleaseCriterion {

	private static final long serialVersionUID = 6486898536244872011L;
	private IRelease release;

	/**
	 * Constructor for GWT
	 */
	@SuppressWarnings("unused")
	private PBIConcreteReleaseCriterion() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param release
	 *            Search criterion release
	 */
	public PBIConcreteReleaseCriterion(final IRelease release) {
		super();
		this.release = release;
	}

	public IRelease getRelease() {
		return this.release;
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBIConcreteReleaseCriterion(this);
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		if (pbi.getSprint() != null && pbi.getSprint().getRelease() != null) {
			return pbi.getSprint().getRelease().equals(this.release);
		}
		return false;
	}

	@Override
	public String toString() {
		return "Release Kriterium [ " + this.release + " ]";
	}

}