package fhdw.ipscrum.client.view;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.view.client.TreeViewModel;

import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.Project;
import fhdw.ipscrum.shared.model.interfaces.IRelease;

/**
 * The model that defines the nodes in the tree.
 */
public class ReleaseSelectionTreeViewModel implements TreeViewModel {

	private final SingleSelectionModel<IRelease> selectionModel;

	@Override
	public boolean isLeaf(Object value) {
		if (value instanceof Project) {
			if (((Project) value).getReleasePlan().size() == 0) {
				return true;
			}
		}
		if (value instanceof IRelease) {
			return true;
		}

		return false;
	}

	public ReleaseSelectionTreeViewModel(SingleSelectionModel<IRelease> selectionModel) {
		this.selectionModel = selectionModel;
	}

	@Override
	public <T> NodeInfo<?> getNodeInfo(T value) {

		if (value == null) {
			ListDataProvider<Project> projectDataProvider = new ListDataProvider<Project>();
			projectDataProvider.getList().addAll(SessionManager.getInstance().getModel().getProjects());

			return new DefaultNodeInfo<Project>(projectDataProvider, pCell);

		} else if (value instanceof Project) {
			ListDataProvider<IRelease> releaseDataProvider = new ListDataProvider<IRelease>();
			releaseDataProvider.getList().addAll(((Project) value).getReleasePlan());

			return new DefaultNodeInfo<IRelease>(releaseDataProvider, rCell, this.selectionModel, null);
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

	Cell<IRelease> rCell = new AbstractCell<IRelease>() {
		@Override
		public void render(Context context, IRelease value, SafeHtmlBuilder sb) {
			if (value != null) {
				sb.appendEscaped("Release " + value.getVersion());
			}
		}
	};
}