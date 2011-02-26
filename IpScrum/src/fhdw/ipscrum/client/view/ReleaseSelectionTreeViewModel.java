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
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;
import fhdw.ipscrum.shared.model.interfaces.ITeam;
import fhdw.ipscrum.shared.model.visitor.ITreeConstructionVisitor;
import fhdw.ipscrum.shared.model.visitor.ITreeVisitorRelevantElement;

/**
 * The model that defines the nodes in the tree.
 */
public class ReleaseSelectionTreeViewModel implements TreeViewModel {

	private final SingleSelectionModel<IRelease> selectionModel;

	private class LeafCheckVisitor implements ITreeConstructionVisitor {
		private boolean result = false;

		@Override
		public void handlePerson(IPerson person) {
			// NOT RELEVANT
		}

		@Override
		public void handleTeam(ITeam team) {
			// NOT RELEVANT
		}

		@Override
		public void handleProject(Project project) {
			if (project.getReleasePlan().size() == 0) {
				this.result = true;
			}
		}

		@Override
		public void handleRelease(IRelease release) {
			this.result = true;
		}

		@Override
		public void handleSprint(ISprint sprint) {
			// NOT RELEVANT
		}

		public boolean getResult() {
			return this.result;
		}
	}

	@Override
	public boolean isLeaf(Object value) {
		if (value == null) return false;
		LeafCheckVisitor lcVisitor = new LeafCheckVisitor();
		((ITreeVisitorRelevantElement) value).accept(lcVisitor);
		return lcVisitor.getResult();
	}

	public ReleaseSelectionTreeViewModel(SingleSelectionModel<IRelease> selectionModel) {
		this.selectionModel = selectionModel;
	}

	@Override
	public <T> NodeInfo<?> getNodeInfo(T value) {

		if (value == null) {
			ListDataProvider<Project> projectDataProvider = new ListDataProvider<Project>();
			projectDataProvider.getList().addAll(SessionManager.getInstance().getModel().getProjects());
			Collections.reverse(projectDataProvider.getList());

			return new DefaultNodeInfo<Project>(projectDataProvider, pCell);

		} else if (value instanceof Project) {
			ListDataProvider<IRelease> releaseDataProvider = new ListDataProvider<IRelease>();
			releaseDataProvider.getList().addAll(((Project) value).getReleasePlan());
			Collections.reverse(releaseDataProvider.getList());

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