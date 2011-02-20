package fhdw.ipscrum.client.view;

import com.google.gwt.user.cellview.client.CellTree;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.view.interfaces.IView;
import fhdw.ipscrum.shared.model.interfaces.IRelease;
import fhdw.ipscrum.shared.model.interfaces.ISprint;


/**
 * view class of the report interface. this interface is to inspect
 * statistical data regarding the sprint-/release progress (burn-down-charts)
 */

// TODO extract interface when base-implementation is done
public class ReportView extends Composite implements IView {
	private final Label lblVariable;
	private SingleSelectionModel<IRelease> releaseSelectionModel;
	private SingleSelectionModel<ISprint> sprintSelectionModel;

	public ReportView() {
		this.initSelectionModels();

		HorizontalPanel horizontalPanelLayout = new HorizontalPanel();
		horizontalPanelLayout.setSpacing(5);
		initWidget(horizontalPanelLayout);
		horizontalPanelLayout.setSize("700px", "600px");

		DecoratedStackPanel decoratedStackPanel = new DecoratedStackPanel();
		horizontalPanelLayout.add(decoratedStackPanel);
		decoratedStackPanel.setWidth("225px");

		CellTree cellTreeReleases = new CellTree(new ReleaseSelectionTreeViewModel(releaseSelectionModel), null);
		decoratedStackPanel.add(cellTreeReleases, "Releaseauswahl", false);
		cellTreeReleases.setSize("100%", "100%");
		cellTreeReleases.setAnimationEnabled(true);

		CellTree cellTreeSprints = new CellTree(new SprintSelectionTreeViewModel(sprintSelectionModel), null);
		cellTreeSprints.setAnimationEnabled(true);
		decoratedStackPanel.add(cellTreeSprints, "Sprintauswahl", false);
		cellTreeSprints.setSize("100%", "100%");

		VerticalPanel verticalPanel = new VerticalPanel();
		horizontalPanelLayout.add(verticalPanel);

		Image image = new Image("images/demoChart.jpg");
		verticalPanel.add(image);

		lblVariable = new Label("variable");
		lblVariable.setStyleName("header3");
		verticalPanel.add(lblVariable);

	}

	private void initSelectionModels() {
		this.releaseSelectionModel = new SingleSelectionModel<IRelease>();
		this.releaseSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				ReportView.this.lblVariable.setText(releaseSelectionModel.getSelectedObject().toString());
			}
		});

		this.sprintSelectionModel = new SingleSelectionModel<ISprint>();
		this.sprintSelectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
			@Override
			public void onSelectionChange(SelectionChangeEvent event) {
				ReportView.this.lblVariable.setText(sprintSelectionModel.getSelectedObject().toString());
			}
		});
	}
}
