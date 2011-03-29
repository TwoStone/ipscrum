package fhdw.ipscrum.shared.model.search.criterias;

import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.search.SearchCriteria;

public class PBIHintsCritera extends TextCriteria implements SearchCriteria {

	private static final long serialVersionUID = -4043249402031393640L;

	public PBIHintsCritera(final String value) {
		super(value);
	}

	@SuppressWarnings("unused")
	private PBIHintsCritera() {
		super();
	}

	@Override
	public boolean search(final ProductBacklogItem pbi) {
		for (final Hint current : pbi.getHints()) {
			if (current.getContent().contains(this.getValue())) {
				return true;
			}
		}

		return false;
	}

}
