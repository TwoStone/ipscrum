package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.exceptions.NoValidValueException;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

public class PBIComplexityCriteria implements SearchCriteria {

	private static final long serialVersionUID = -3726369254746420491L;
	private Integer from;
	private Integer to;

	@SuppressWarnings("unused")
	private PBIComplexityCriteria() {
		super();
	}

	public PBIComplexityCriteria(final Integer from, final Integer to)
			throws NoValidValueException {
		super();
		this.checkRange(from, to);
		this.from = from;
		this.to = to;
	}

	public PBIComplexityCriteria(final Integer fromTo)
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

	private void checkRange(final Integer from, final Integer to)
			throws NoValidValueException {
		// TODO Textkonstante bauen
		if (from <= 0 || to <= 0 || to < from) {
			throw new NoValidValueException(
					"Es muss ein gültiger Bereich angegeben werden!");
		}
	}

}
