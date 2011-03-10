package fhdw.ipscrum.client.view;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;

import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.interfaces.ITeam;

/**
 * The model that defines the nodes in the tree.
 */
public class TeamSelectionTreeViewModel implements TreeViewModel {

	private final SingleSelectionModel<ITeam> selectionModel;

	@Override
	public boolean isLeaf(Object value) {
		if (value == null) return false;
		return value instanceof ITeam;
	}

	public TeamSelectionTreeViewModel(SingleSelectionModel<ITeam> selectionModel) {
		this.selectionModel = selectionModel;
	}

	@Override
	public <T> NodeInfo<?> getNodeInfo(T value) {

		if (value == null) {
			ListDataProvider<ITeam> teamDataProvider = new ListDataProvider<ITeam>();
			teamDataProvider.getList().addAll(SessionManager.getInstance().getModel().getTeams());

			return new DefaultNodeInfo<ITeam>(teamDataProvider, tCell, selectionModel, null);
		}

		return null;
	}

	Cell<ITeam> tCell = new AbstractCell<ITeam>() {
		@Override
		public void render(Context context, ITeam value, SafeHtmlBuilder sb) {
			if (value != null) {
				sb.appendEscaped("Team " + value.getDescription());
			}
		}
	};
}