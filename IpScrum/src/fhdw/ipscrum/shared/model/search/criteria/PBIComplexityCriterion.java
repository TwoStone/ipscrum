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

	// /**
	// * If from an to value are equal then this value defines if from/to is
	// * Minimum or Maximum -> true means Minimum -> false means Maximum
	// */
	// private boolean isMin;

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

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		if (this.from == null && this.to >= 0) {
			// Maximum
			return (pbi.getManDayCosts().getValue() <= this.to);
		} else if (this.from >= 0 && this.to == null) {
			// Minimum
			return (pbi.getManDayCosts().getValue() >= this.from);
		} else {
			// Range
			return (pbi.getManDayCosts().getValue() >= this.from && pbi
					.getManDayCosts().getValue() <= this.to);
		}
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
		final String exc = "Es muss ein gültiger Bereich angegeben werden!";

		if (from == null && to == null) {
			throw new NoValidValueException(exc);
		}

		if (from == null && to != null && to < 0) {
			throw new NoValidValueException(exc);
		}

		if (from != null && from < 0 && to == null) {
			throw new NoValidValueException(exc);
		}

		if (from != null && from < 0 && to != null && to < 0) {
			throw new NoValidValueException(exc);
		}
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBIComplexityCriteria(this);
	}

	@Override
	public String toString() {
		return "Komplexität [von=" + this.from + ", bis=" + this.to + "]";
	}

	public Integer getFrom() {
		return this.from;
	}

	public Integer getTo() {
		return this.to;
	}
}
