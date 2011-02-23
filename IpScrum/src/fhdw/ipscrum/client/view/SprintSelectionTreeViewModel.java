package fhdw.ipscrum.client.view;
import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.Cell;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.text.client.DateTimeFormatRenderer;
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
public class SprintSelectionTreeViewModel implements TreeViewModel {

	private final SingleSelectionModel<ISprint> selectionModel;

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
			if (project.getSprints().size() == 0) {
				this.result = true;
			}
		}

		@Override
		public void handleRelease(IRelease release) {
			// NOT RELEVANT
		}

		@Override
		public void handleSprint(ISprint sprint) {
			this.result = true;
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
				sb.appendHtmlConstant("<span style='font-size:75%;'>");
				DateTimeFormatRenderer dtr = new DateTimeFormatRenderer(DateTimeFormat.getFormat("dd.MM.yy"));
				sb.appendEscaped(dtr.render(value.getBegin()) + " - " + dtr.render(value.getEnd()));
				sb.appendHtmlConstant("</span><br />");
				sb.appendEscaped(value.toString());
			}
		}
	};
}