package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.view.interfaces.IEditFeatureView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.model.Closed;
import fhdw.ipscrum.shared.model.Open;
import fhdw.ipscrum.shared.model.interfaces.IFeatureState;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.visitor.IFeatureVisitor;

public class EditFeatureView extends CreateFeatureView implements
		IEditFeatureView {

	private final IntegerBox complexityBox = new IntegerBox();
	private final Label currentStateLbl = new Label("");
	private final Button toggleStateBtn = new Button();
	private final Label editorLabel = new Label("");
	private final Event<EventArgs> toggleStateEvent = new Event<EventArgs>();

	public EditFeatureView() {
		super();
		this.getBtnAbort().setVisible(false);

		final Label aufwandLbl = new Label(TextConstants.COMPLEXITY);
		this.getGrid().setWidget(2, 0, aufwandLbl);

		final HorizontalPanel complPanel = new HorizontalPanel();
		complPanel.setSpacing(5);
		this.getGrid().setWidget(2, 1, complPanel);

		this.complexityBox.setVisibleLength(3);
		complPanel.add(this.complexityBox);

		complPanel.add(new Label(TextConstants.COMPLEXITY_UNIT));

		final Label stateLbl = new Label(TextConstants.STATUS);
		this.getGrid().setWidget(3, 0, stateLbl);

		final HorizontalPanel statePanel = new HorizontalPanel();
		statePanel.setSpacing(5);
		this.getGrid().setWidget(3, 1, statePanel);

		this.toggleStateBtn.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {
				EditFeatureView.this.toggleStateEvent.fire(
						EditFeatureView.this, new EventArgs());
			}
		});

		statePanel.add(this.currentStateLbl);
		statePanel.add(this.toggleStateBtn);

		final Label lblLastEditor = new Label("Zu letzt \r\nbearbeitet von:");
		this.getGrid().setWidget(4, 0, lblLastEditor);

		this.getGrid().setWidget(4, 1, this.editorLabel);
	}

	@Override
	public Integer getComplexity() {
		return this.complexityBox.getValue();
	}

	@Override
	public void setComplexity(final Integer complexity) {
		this.complexityBox.setValue(complexity);
	}

	@Override
	public void setState(final IFeatureState state) {
		state.accept(new IFeatureVisitor() {

			@Override
			public void handleClosed(final Closed closed) {
				EditFeatureView.this.currentStateLbl
						.setText(TextConstants.CLOSED);
				EditFeatureView.this.toggleStateBtn
						.setText(TextConstants.OPEN_FEATURE);
				// TODO Wenn Features wieder geöffnet werden können, hier
				// ändern.
				EditFeatureView.this.toggleStateBtn.setVisible(false);
				EditFeatureView.this.getBtnAddCriterion().setEnabled(false);
				EditFeatureView.this.getBtnAddHint().setEnabled(false);
				EditFeatureView.this.getBtnAddRelation().setEnabled(false);
			}

			@Override
			public void handleOpen(final Open open) {
				EditFeatureView.this.currentStateLbl
						.setText(TextConstants.OPEN);
				EditFeatureView.this.toggleStateBtn
						.setText(TextConstants.CLOSE_FEATURE);
				// TODO Wenn Features wieder geöffnet werden können, hier
				// ändern.
				EditFeatureView.this.toggleStateBtn.setVisible(true);
				EditFeatureView.this.getBtnAddCriterion().setEnabled(true);
				EditFeatureView.this.getBtnAddHint().setEnabled(true);
				EditFeatureView.this.getBtnAddRelation().setEnabled(true);
			}
		});
	}

	@Override
	public IEvent<EventArgs> toggleFeatureState() {
		return this.toggleStateEvent;
	}

	@Override
	public void setLastEditor(final IPerson editor) {
		this.editorLabel.setText(editor.toString());
	}

}
