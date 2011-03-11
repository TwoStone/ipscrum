package fhdw.ipscrum.client.view.widgets;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.view.PBIView;
import fhdw.ipscrum.client.view.interfaces.IEditPBIView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.Effort;
import fhdw.ipscrum.shared.model.PBIClosedState;
import fhdw.ipscrum.shared.model.PBIOpenState;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IProductBacklogItemState;
import fhdw.ipscrum.shared.model.visitor.IPBIStateVisitor;

public class EditPBIWidget extends Composite implements IEditPBIView {

	private final PBIView pbiView;
	private final IntegerBox complexityBox = new IntegerBox();
	private final Label currentStateLbl = new Label("");
	private final Button toggleStateBtn = new Button();
	private final Label editorLabel = new Label("");
	private final Event<EventArgs> toggleStateEvent = new Event<EventArgs>();

	public EditPBIWidget(FlexTable grid, PBIView pbiView) {
		int rowCount = grid.getRowCount();
		final Label aufwandLbl = new Label(TextConstants.COMPLEXITY);
		grid.setWidget(rowCount, 0, aufwandLbl);

		final HorizontalPanel complPanel = new HorizontalPanel();
		complPanel.setSpacing(5);
		grid.setWidget(rowCount, 1, complPanel);

		this.complexityBox.setVisibleLength(3);
		complPanel.add(this.complexityBox);

		complPanel.add(new Label(TextConstants.COMPLEXITY_UNIT));

		final Label stateLbl = new Label(TextConstants.STATUS);
		grid.setWidget(rowCount + 1, 0, stateLbl);

		final HorizontalPanel statePanel = new HorizontalPanel();
		statePanel.setSpacing(5);
		grid.setWidget(rowCount + 1, 1, statePanel);

		this.toggleStateBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				EditPBIWidget.this.toggleStateEvent.fire(EditPBIWidget.this, new EventArgs());
			}
		});

		statePanel.add(this.currentStateLbl);
		statePanel.add(this.toggleStateBtn);

		final Label lblLastEditor = new Label("Zu letzt \r\nbearbeitet von:");
		grid.setWidget(rowCount + 2, 0, lblLastEditor);

		grid.setWidget(rowCount + 2, 1, this.editorLabel);

		this.pbiView = pbiView;
	}

	@Override
	public Integer getComplexity() {
		return this.complexityBox.getValue();
	}

	@Override
	public void setComplexity(final Effort complexity) {
		this.complexityBox.setValue(complexity.getValue());
	}

	/**
	 * Sets the enabled attribute of the editable view elements to <i>b</i>.
	 * 
	 * @param b
	 */
	public void setEditFieldsEnabled(final boolean b) {
		pbiView.setVisibleForEdit(b);
		this.complexityBox.setEnabled(b);
	}

	@Override
	public void setLastEditor(final IPerson editor) {
		// Da der Editor momentan nicht über die Business logik gesetzt
		// wird, kann er null sein.
		if (editor != null) {
			this.editorLabel.setText(editor.toString());
		}
	}

	@Override
	public void setState(final IProductBacklogItemState state) {
		state.accept(new IPBIStateVisitor() {

			@Override
			public void handleClosed(final PBIClosedState closed) {
				EditPBIWidget.this.currentStateLbl.setText(TextConstants.CLOSED);
				EditPBIWidget.this.toggleStateBtn.setText(TextConstants.OPEN_FEATURE);
				// Wenn Features wieder geöffnet werden können, hier
				// ändern.
				EditPBIWidget.this.toggleStateBtn.setVisible(false);
				EditPBIWidget.this.setEditFieldsEnabled(false);

			}

			@Override
			public void handleOpen(final PBIOpenState open) {
				EditPBIWidget.this.currentStateLbl.setText(TextConstants.OPEN);
				EditPBIWidget.this.toggleStateBtn.setText(TextConstants.CLOSE_PBI);
				// Wenn Features wieder geöffnet werden können, hier
				// ändern.
				EditPBIWidget.this.toggleStateBtn.setVisible(true);
				EditPBIWidget.this.setEditFieldsEnabled(true);
			}
		});
	}

	@Override
	public IEvent<EventArgs> toggleFeatureState() {
		return this.toggleStateEvent;
	}
}
