package fhdw.ipscrum.client.view;
import java.util.Collections;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;

import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.Project;

/**
 * The model that defines the nodes in the tree.
 */
public class ProjectSelectionTreeViewModel implements TreeViewModel {

	private final SingleSelectionModel<Project> selectionModel;

	@Override
	public boolean isLeaf(Object value) {
		return value instanceof Project;
	}

	public ProjectSelectionTreeViewModel(SingleSelectionModel<Project> selectionModel) {
		this.selectionModel = selectionModel;
	}

	@Override
	public <T> NodeInfo<?> getNodeInfo(T value) {

		if (value == null) {
			ListDataProvider<Project> projectDataProvider = new ListDataProvider<Project>();
			projectDataProvider.getList().addAll(SessionManager.getInstance().getModel().getProjects());
			Collections.reverse(projectDataProvider.getList());

			return new DefaultNodeInfo<Project>(projectDataProvider, pCell, this.selectionModel, null);
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
}