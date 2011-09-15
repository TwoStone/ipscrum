package fhdw.ipscrum.shared.commands.search;

import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.search.Search;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Deletes a search.
 */
public class SearchDeleteCommand extends Command<Void> {

	/**
	 * Constructor of the Command without parameters.
	 */
	@SuppressWarnings("unused")
	private SearchDeleteCommand() {
		super();
	}

	/**
	 * Constructor of the SearchDeleteCommand.
	 * 
	 * @param search
	 *            that should be deleted
	 */
	public SearchDeleteCommand(final Search search) {
		super(search);
	}

	@Override
	protected Void onExecute(final Model model) throws IPScrumGeneralException {
		final Search search = (Search) model.getObject(this.getReceiverGuid());
		this.setStringValue(StringUtils.format("Suche '%s' entfernt.", search.getName()));
		model.removeSearch(search);
		return null;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleSearchDeleteCommand(this);
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
