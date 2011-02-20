package fhdw.ipscrum.client.view;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;

import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

/**
 * The model that defines the nodes in the tree.
 */
public class SprintSelectionTreeViewModel implements TreeViewModel {

	private final SingleSelectionModel<ISprint> selectionModel;

	@Override
	public boolean isLeaf(Object value) {
		if (value instanceof Project) {
			if (((Project) value).getSprints().size() == 0) {
				return true;
			}
		}
		if (value instanceof ISprint) {
			return true;
		}

		return false;
	}

	public SprintSelectionTreeViewModel(SingleSelectionModel<ISprint> selectionModel) {
		this.selectionModel = selectionModel;
	}

	@Override
	public <T> NodeInfo<?> getNodeInfo(T value) {

		if (value == null) {
			ListDataProvider<Project> projectDataProvider = new ListDataProvider<Project>();
			projectDataProvider.getList().addAll(SessionManager.getInstance().getModel().getProjects());

			return new DefaultNodeInfo<Project>(projectDataProvider, pCell);

		} else if (value instanceof Project) {
			ListDataProvider<ISprint> sprintDataProvider = new ListDataProvider<ISprint>();
			sprintDataProvider.getList().addAll(((Project) value).getSprints());

			return new DefaultNodeInfo<ISprint>(sprintDataProvider, sCell, this.selectionModel, null);
		}

		return null;
	}


	Cell<Project> pCell = new AbstractCell<Project>() {
		@Override
		public void render(Context context, Project value, SafeHtmlBuilder sb) {
			if (value != null) {
				sb.appendEscaped(value.getName());
			}
		}
	};

	Cell<ISprint> sCell = new AbstractCell<ISprint>() {
		@Override
		public void render(Context context, ISprint value, SafeHtmlBuilder sb) {
			if (value != null) {
				sb.appendEscaped(value.toString());
			}
		}
	};
}