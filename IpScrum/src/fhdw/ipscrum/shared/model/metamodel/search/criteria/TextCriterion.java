package fhdw.ipscrum.shared.model.metamodel.search.criteria;

import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.search.ISearchExpression;
import fhdw.ipscrum.shared.model.metamodel.search.SearchCriteria;

/**
 * Represents the Search Criterion for TextCriteria.
 */
public abstract class TextCriterion extends SearchCriteria {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 2959273810129438739L;

	/**
	 * Represents the searched value of the TextCriterion.
	 */
	private String value;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected TextCriterion() {
		super();
	}

	/**
	 * Constructor of the TextCriterion.
	 * 
	 * @param model
	 *            is related to the TextCriterion
	 * @param value
	 *            which is searched with the criterion
	 */
	public TextCriterion(final Model model, final String value) {
		super(model);
		this.value = value;
	}

	/**
	 * Getter of the value.
	 * 
	 * @return the value of the search
	 */
	public String getValue() {
		return this.value;
	}

	/**
	 * Setter of the value.
	 * 
	 * @param value
	 *            which is searched
	 */
	public void setValue(final String value) {
		this.value = value;
		this.changed();
	}

	/**
	 * This method checks if arg1 contains the attribute value of this class. It differs
	 * from the String based contains because it's not case sensitive.
	 * 
	 * @param arg
	 *            Argument
	 * @return True if arg1 contains -value- and false if not.
	 */
	public boolean nonSensitiveContains(final String arg) {
		return arg.toLowerCase().contains(this.value.toLowerCase());
	}

	@Override
	public boolean contains(final ISearchExpression expression) {
		return this.equals(expression);
	}
}
