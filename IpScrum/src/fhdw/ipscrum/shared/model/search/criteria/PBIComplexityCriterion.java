package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

/**
 * Represents the criterion for PBI complexity.
 */
public class PBIComplexityCriterion extends SearchCriteria {

	private static final long serialVersionUID = -3726369254746420491L;
	private Integer from;
	private Integer to;

	@SuppressWarnings("unused")
	private PBIComplexityCriterion() {
		super();
	}

	/**
	 * Constructor
	 * 
	 * @param from
	 *            Range start (inclusive)
	 * @param to
	 *            Range end (inclusive)
	 * @throws NoValidValueException
	 */
	public PBIComplexityCriterion(final Integer from, final Integer to)
			throws NoValidValueException {
		super();
		this.checkRange(from, to);
		this.from = from;
		this.to = to;
	}

	/**
	 * Constructor - No Range!
	 * 
	 * @param fromTo
	 *            Fix value for complexity
	 * @throws NoValidValueException
	 */
	public PBIComplexityCriterion(final Integer fromTo)
			throws NoValidValueException {
		super();
		this.checkRange(fromTo, fromTo);
		this.from = fromTo;
		this.to = fromTo;
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		return (pbi.getManDayCosts().getValue() >= this.from && pbi
				.getManDayCosts().getValue() <= this.to);
	}

	/**
	 * Helper method for validating the from-to range.
	 * 
	 * @param from
	 * @param to
	 * @throws NoValidValueException
	 */
	private void checkRange(final Integer from, final Integer to)
			throws NoValidValueException {
		// TODO Textkonstante bauen
		if (from <= 0 || to <= 0 || to < from) {
			throw new NoValidValueException(
					"Es muss ein gültiger Bereich angegeben werden!");
		}
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBIComplexityCriteria(this);
	}

	@Override
	public String toString() {
		return "Komplexität [from=" + this.from + ", to=" + this.to + "]";
	}

	public Integer getFrom() {
		return this.from;
	}

	public Integer getTo() {
		return this.to;
	}
}
