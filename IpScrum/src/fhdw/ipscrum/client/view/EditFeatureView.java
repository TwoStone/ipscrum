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
import fhdw.ipscrum.shared.model.Closed;
import fhdw.ipscrum.shared.model.Open;
import fhdw.ipscrum.shared.model.interfaces.IFeatureState;
import fhdw.ipscrum.shared.model.visitor.IFeatureVisitor;

public class EditFeatureView extends CreateFeatureView implements
		IEditFeatureView {
	
	private final IntegerBox integerBox = new IntegerBox();
	private final Label currentStateLbl = new Label("");
	private final Button toggleStateBtn = new Button();
	private Event<EventArgs> toggleStateEvent = new Event<EventArgs>();
	
	public EditFeatureView() {
		
		Label aufwandLbl = new Label("Aufwand:");
		getGrid().setWidget(2, 0, aufwandLbl);
		
		HorizontalPanel complPanel = new HorizontalPanel();
		complPanel.setSpacing(5);
		getGrid().setWidget(2, 1, complPanel);
		
		complPanel.add(integerBox);
		complPanel.add(new Label("MT"));
		
		Label stateLbl =  new Label("Status:");
		getGrid().setWidget(3,	0, stateLbl);
		
		HorizontalPanel statePanel = new HorizontalPanel();
		statePanel.setSpacing(5);
		getGrid().setWidget(3, 1, statePanel);
		
		this.toggleStateBtn.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				EditFeatureView.this.toggleStateEvent.fire(EditFeatureView.this, new EventArgs());
			}
		});
		
		statePanel.add(currentStateLbl);
		statePanel.add(toggleStateBtn);
	}

	@Override
	public void setComplexity(Integer complexity) {
		this.integerBox.setValue(complexity);
	}

	@Override
	public Integer getComplexity() {
		return this.integerBox.getValue();
	}

	@Override
	public void setState(IFeatureState state) {
		state.accept(new IFeatureVisitor() {
			
			@Override
			public void handleOpen(Open open) {
				EditFeatureView.this.currentStateLbl.setText("Offen");
				EditFeatureView.this.toggleStateBtn.setText("Feature schließen");
				EditFeatureView.this.getBtnAddCriterion().setEnabled(true);
				EditFeatureView.this.getBtnAddHint().setEnabled(true);
				EditFeatureView.this.getBtnAddRelation().setEnabled(true);
			}
			
			@Override
			public void handleClosed(Closed closed) {
				EditFeatureView.this.currentStateLbl.setText("Geschlossen");
				EditFeatureView.this.toggleStateBtn.setText("Feature öffnen");
				EditFeatureView.this.getBtnAddCriterion().setEnabled(false);
				EditFeatureView.this.getBtnAddHint().setEnabled(false);
				EditFeatureView.this.getBtnAddRelation().setEnabled(false);
			}
		});
	}

	@Override
	public IEvent<EventArgs> toggleFeatureState() {
		return this.toggleStateEvent;
	}
	
	

}
