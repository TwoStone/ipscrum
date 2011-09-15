package fhdw.ipscrum.shared.commands.search;

import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.search.Search;
import fhdw.ipscrum.shared.model.metamodel.search.SearchExpression;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a new search.
 */
public class SearchCreateCommand extends Command<Search> {

	/**
	 * Represents the name of the Search.
	 */
	private String name;

	/**
	 * Represents the expression of the Search.
	 */
	private String expressionId;

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private SearchCreateCommand() {
		super();
	}

	/**
	 * Constructor of the SearchCreateCommand.
	 * 
	 * @param name
	 *            of the new Search
	 * @param expression
	 *            of the new Search
	 */
	public SearchCreateCommand(final String name, final SearchExpression expression) {
		super();
		this.name = name;
		this.expressionId = expression.getId();
	}

	@Override
	protected Search onExecute(final Model model) throws IPScrumGeneralException {
		this.setStringValue(StringUtils.format("Suche '%s' wurde gespeichert.",
				this.name));

		final SearchExpression expression =
				(SearchExpression) model.getObject(this.expressionId);
		final Search search = new Search(model, this.name, expression);
		return search;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleSearchCreateCommand(this);
	}

	@Override
	public boolean dependsOnProject() {
		return false;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		return null;
	}

}
