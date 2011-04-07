package fhdw.ipscrum.shared.model.search.criteria;

import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.ISearchExpressionVisitor;
import fhdw.ipscrum.shared.model.search.Operator;
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
	public PBIComplexityCriterion(final Integer from, final Integer to,
			final Operator parent) throws NoValidValueException {
		super(parent);
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

		if (from != null && to != null && from > to) {
			throw new NoValidValueException(exc);
		}
	}

	@Override
	public void accept(final ISearchExpressionVisitor visitor) {
		visitor.handlePBIComplexityCriteria(this);
	}

	@Override
	public String toString() {
		final String cons = "Komplexität";
		if (this.from == null) {
			return cons + " [Max. <= " + this.to + " ]";
		}
		if (this.to == null) {
			return cons + " [Min. >= " + this.to + " ]";
		}

		return "Komplexität [von=" + this.from + ", bis=" + this.to + "]";
	}

	public Integer getFrom() {
		return this.from;
	}

	public Integer getTo() {
		return this.to;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.from == null) ? 0 : this.from.hashCode());
		result = prime * result + ((this.to == null) ? 0 : this.to.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final PBIComplexityCriterion other = (PBIComplexityCriterion) obj;
		if (this.from == null) {
			if (other.from != null) {
				return false;
			}
		} else if (!this.from.equals(other.from)) {
			return false;
		}
		if (this.to == null) {
			if (other.to != null) {
				return false;
			}
		} else if (!this.to.equals(other.to)) {
			return false;
		}
		return true;
	}

}
