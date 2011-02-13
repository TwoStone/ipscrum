package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.view.interfaces.ICreateRelationView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.NothingSelectedException;
import fhdw.ipscrum.shared.model.Feature;
import fhdw.ipscrum.shared.model.RelationType;

public class CreateRelationView extends Composite implements
		ICreateRelationView {

	private final ListBox featureList = new ListBox();
	private final Label currentFeatureLabel = new Label();

	private final Event<EventArgs> abortEvent = new Event<EventArgs>();

	private final Event<EventArgs> createNewTypeEvent = new Event<EventArgs>();
	private final Event<EventArgs> saveEvent = new Event<EventArgs>();
	private List<Feature> targets;
	private final ListBox typeComboBox;
	private List<RelationType> types;

	public CreateRelationView() {

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setSpacing(5);
		this.initWidget(verticalPanel);
		verticalPanel.setWidth("250px");

		final Grid grid = new Grid(2, 2);
		grid.setCellSpacing(5);
		grid.setCellPadding(5);
		verticalPanel.add(grid);
		grid.setWidth("100%");

		final Label lblNewLabel = new Label("Feature:");
		grid.setWidget(0, 0, lblNewLabel);

		grid.setWidget(0, 1, this.currentFeatureLabel);
		this.currentFeatureLabel.setWidth("100%");

		final Label lblNewLabel_2 = new Label("Beziehungstyp:");
		grid.setWidget(1, 0, lblNewLabel_2);

		this.typeComboBox = new ListBox();
		grid.setWidget(1, 1, this.typeComboBox);
		this.typeComboBox.setWidth("100%");

		final Label lblEintragAuswhlen = new Label("Eintrag auswählen:");
		verticalPanel.add(lblEintragAuswhlen);

		verticalPanel.add(this.featureList);
		this.featureList.setWidth("80%");
		this.featureList.setVisibleItemCount(5);

		final HorizontalPanel flowButtonPanel = new HorizontalPanel();
		verticalPanel.add(flowButtonPanel);
		flowButtonPanel
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		flowButtonPanel.setSpacing(10);

		final Button saveButton = new Button(TextConstants.SAVE);
		saveButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				CreateRelationView.this.saveEvent.fire(CreateRelationView.this,
						new EventArgs());
			}
		});
		flowButtonPanel.add(saveButton);

		final Button abortButton = new Button(TextConstants.ABORT);
		abortButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				CreateRelationView.this.abortEvent.fire(
						CreateRelationView.this, new EventArgs());
			}
		});
		flowButtonPanel.add(abortButton);
	}

	@Override
	public IEvent<EventArgs> getAbort() {
		return this.abortEvent;
	}

	@Override
	public IEvent<EventArgs> getCreateNewType() {
		return this.createNewTypeEvent;
	}

	@Override
	public Panel getCreateNewTypePanel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEvent<EventArgs> getSave() {
		return this.saveEvent;
	}

	@Override
	public Feature getSelectedTarget() throws NothingSelectedException {
		if (this.featureList.getSelectedIndex() == -1) {
			throw new NothingSelectedException(TextConstants.EMPTY_TEXT);
		}
		return this.targets.get(this.featureList.getSelectedIndex());
	}

	@Override
	public RelationType getSelectedType() throws NothingSelectedException {
		if (this.typeComboBox.getSelectedIndex() == -1) {
			throw new NothingSelectedException(TextConstants.EMPTY_TEXT);
		}
		return this.types.get(this.typeComboBox.getSelectedIndex());
	}

	@Override
	public void setOwningFeature(final Feature feature) {
		this.currentFeatureLabel.setText(feature.toString());
	}

	@Override
	public void setRelationTypes(final List<RelationType> types) {
		this.types = types;
		for (final RelationType relationType : types) {
			this.typeComboBox.addItem(relationType.getDescription());
		}
	}

	@Override
	public void setTargetFeatures(final List<Feature> vector) {
		this.targets = vector;
		for (final Feature current : vector) {
			this.featureList.addItem(current.getName());
		}
	}
}
