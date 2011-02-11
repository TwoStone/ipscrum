package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.events.args.RemoveCriterionEventArgs;
import fhdw.ipscrum.client.events.args.RemoveHintEventArgs;
import fhdw.ipscrum.client.events.args.RemoveRelationEventArgs;
import fhdw.ipscrum.client.view.interfaces.ICreateFeatureView;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.Relation;
import fhdw.ipscrum.shared.model.interfaces.ISprint;

public class CreateFeatureView extends Composite implements ICreateFeatureView {

	private TextBox txtBxName;
	private TextArea textArea;
	private final ListBox sprintComboBox = new ListBox();
	private final Button btnAddRelation;
	private final Button btnAddHint;
	private final Button btnAddCriterion;
	private final Button btnSave;
	private final Button btnAbort = new Button("Abbrechen");
	private final CellTable<Relation> relationTable;
	private final CellTable<Hint> hintTable;
	private final Label lblAkzptanzkriterien;
	private final CellTable<AcceptanceCriterion> criteriaTable;
	private final Event<RemoveRelationEventArgs> removeRelationEvent = new Event<RemoveRelationEventArgs>();
	private final Event<RemoveCriterionEventArgs> removeCriterionEvent = new Event<RemoveCriterionEventArgs>();
	private final Event<RemoveHintEventArgs> removeHintEvent = new Event<RemoveHintEventArgs>();
	private final SimplePanel addHintPanel;
	private final SimplePanel addCriterionPanel;
	private final ScrollPanel hintPanel;
	private final ScrollPanel criteriaPanel;
	private final ScrollPanel relationPanel;
	private final Event<EventArgs> save = new Event<EventArgs>();
	private final Event<EventArgs> createRelation = new Event<EventArgs>();
	private final Event<EventArgs> createHint = new Event<EventArgs>();
	private final Event<EventArgs> createCriterion = new Event<EventArgs>();
	private final Event<EventArgs> abort = new Event<EventArgs>();
	private final FlexTable detailTable;
	private List<ISprint> sprints;

	public CreateFeatureView() {

		final VerticalPanel verticalPanel_2 = new VerticalPanel();
		verticalPanel_2
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		this.initWidget(verticalPanel_2);

		final HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel_2.add(horizontalPanel);

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(10);
		horizontalPanel.add(verticalPanel);

		this.detailTable = new FlexTable();
		verticalPanel.add(this.detailTable);

		final Label lblName = new Label("Name:");
		this.detailTable.setWidget(0, 0, lblName);

		this.txtBxName = new TextBox();
		this.detailTable.setWidget(0, 1, this.txtBxName);

		final Label lblSprint = new Label("Sprint:");
		this.detailTable.setWidget(1, 0, lblSprint);

		this.detailTable.setWidget(1, 1, this.sprintComboBox);

		final Label lblDescription = new Label("Beschreibung");
		verticalPanel.add(lblDescription);

		this.textArea = new TextArea();
		this.textArea.setCharacterWidth(25);
		verticalPanel.add(this.textArea);
		this.textArea.setWidth("223px");

		final Label lblRelations = new Label("Beziehungen:");
		verticalPanel.add(lblRelations);

		this.relationPanel = new ScrollPanel();
		this.relationPanel.setStyleName("createFeatureTable");
		verticalPanel.add(this.relationPanel);
		this.relationPanel.setSize("300px", "150px");

		this.relationTable = new CellTable<Relation>();
		this.relationPanel.setWidget(this.relationTable);
		this.relationTable.setSize("100%", "100%");

		final TextColumn<Relation> typeCol = new TextColumn<Relation>() {
			@Override
			public String getValue(final Relation object) {
				return object.getType().getDescription();
			}
		};
		this.relationTable.addColumn(typeCol);

		final TextColumn<Relation> targetCol = new TextColumn<Relation>() {
			@Override
			public String getValue(final Relation object) {
				return object.getTarget().getName();
			}
		};
		this.relationTable.addColumn(targetCol);

		final Column<Relation, String> deleteCol = new Column<Relation, String>(
				new ButtonCell()) {
			@Override
			public String getValue(final Relation object) {
				return "x";
			}
		};
		deleteCol.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		deleteCol.setFieldUpdater(new FieldUpdater<Relation, String>() {

			@Override
			public void update(final int index, final Relation object,
					final String value) {
				CreateFeatureView.this.removeRelationEvent.fire(
						CreateFeatureView.this, new RemoveRelationEventArgs(
								object));
			}
		});

		this.relationTable.addColumn(deleteCol);

		this.btnAddRelation = new Button("Beziehung hinzuf\u00FCgen");
		this.btnAddRelation.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				CreateFeatureView.this.createRelation.fire(
						CreateFeatureView.this, new EventArgs());
			}
		});
		verticalPanel.add(this.btnAddRelation);

		final VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setSpacing(10);
		horizontalPanel.add(verticalPanel_1);

		final Label lblHinweise = new Label("Hinweise:");
		verticalPanel_1.add(lblHinweise);
		lblHinweise.setWidth("300px");

		this.hintPanel = new ScrollPanel();
		this.hintPanel.setStyleName("createFeatureTable");
		verticalPanel_1.add(this.hintPanel);
		this.hintPanel.setSize("300px", "150px");

		this.hintTable = new CellTable<Hint>();
		this.hintPanel.setWidget(this.hintTable);
		this.hintTable.setSize("100%", "100%");

		final TextColumn<Hint> hintTextCol = new TextColumn<Hint>() {
			@Override
			public String getValue(final Hint object) {
				return object.getContent();
			}
		};
		this.hintTable.addColumn(hintTextCol);

		final Column<Hint, String> removeHintCol = new Column<Hint, String>(
				new ButtonCell()) {
			@Override
			public String getValue(final Hint object) {
				return "X";
			}
		};
		removeHintCol
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		removeHintCol.setFieldUpdater(new FieldUpdater<Hint, String>() {

			@Override
			public void update(final int index, final Hint object,
					final String value) {
				CreateFeatureView.this.removeHintEvent
						.fire(CreateFeatureView.this, new RemoveHintEventArgs(
								object));
			}
		});
		this.hintTable.addColumn(removeHintCol);

		this.addHintPanel = new SimplePanel();
		verticalPanel_1.add(this.addHintPanel);

		this.btnAddHint = new Button("Hinweis hinzuf\u00FCgen");
		this.btnAddHint.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				CreateFeatureView.this.createHint.fire(CreateFeatureView.this,
						new EventArgs());
			}
		});
		verticalPanel_1.add(this.btnAddHint);

		this.lblAkzptanzkriterien = new Label("Akzptanzkriterien:");
		verticalPanel_1.add(this.lblAkzptanzkriterien);
		this.lblAkzptanzkriterien.setWidth("300px");

		this.criteriaPanel = new ScrollPanel();
		this.criteriaPanel.setStyleName("createFeatureTable");
		verticalPanel_1.add(this.criteriaPanel);
		this.criteriaPanel.setSize("300px", "150px");

		this.criteriaTable = new CellTable<AcceptanceCriterion>();
		this.criteriaPanel.setWidget(this.criteriaTable);
		this.criteriaTable.setSize("100%", "100%");

		final TextColumn<AcceptanceCriterion> criterionTextCol = new TextColumn<AcceptanceCriterion>() {
			@Override
			public String getValue(final AcceptanceCriterion object) {
				return object.getContent();
			}
		};
		this.criteriaTable.addColumn(criterionTextCol);

		final Column<AcceptanceCriterion, String> removeCriterionCol = new Column<AcceptanceCriterion, String>(
				new ButtonCell()) {
			@Override
			public String getValue(final AcceptanceCriterion object) {
				return "x";
			}
		};
		removeCriterionCol
				.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		removeCriterionCol
				.setFieldUpdater(new FieldUpdater<AcceptanceCriterion, String>() {

					@Override
					public void update(final int index,
							final AcceptanceCriterion object, final String value) {
						CreateFeatureView.this.removeCriterionEvent.fire(
								CreateFeatureView.this,
								new RemoveCriterionEventArgs(object));
					}
				});

		this.criteriaTable.addColumn(removeCriterionCol);

		this.addCriterionPanel = new SimplePanel();
		verticalPanel_1.add(this.addCriterionPanel);

		this.btnAddCriterion = new Button("New button");
		this.btnAddCriterion.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				CreateFeatureView.this.createCriterion.fire(
						CreateFeatureView.this, new EventArgs());
			}
		});
		verticalPanel_1.add(this.btnAddCriterion);
		this.btnAddCriterion.setText("Kriterium hinzuf\u00FCgen");

		final HorizontalPanel buttonPanel = new HorizontalPanel();
		buttonPanel.setSpacing(5);
		buttonPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel_2.add(buttonPanel);

		this.btnSave = new Button("Speichern");
		this.btnSave.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				CreateFeatureView.this.save.fire(CreateFeatureView.this,
						new EventArgs());
			}
		});
		buttonPanel.add(this.btnSave);
		this.btnAbort.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				CreateFeatureView.this.abort.fire(CreateFeatureView.this,
						new EventArgs());
			}
		});

		buttonPanel.add(this.btnAbort);
	}

	@Override
	public Panel addCriterionPanel() {
		return this.addCriterionPanel;
	}

	@Override
	public Panel addHintPanel() {
		return this.addHintPanel;
	}

	@Override
	public IEvent<EventArgs> getAbort() {
		return this.abort;
	}

	protected Button getBtnAbort() {
		return this.btnAbort;
	}

	protected Button getBtnAddCriterion() {
		return this.btnAddCriterion;
	}

	protected Button getBtnAddHint() {
		return this.btnAddHint;
	}

	protected Button getBtnAddRelation() {
		return this.btnAddRelation;
	}

	@Override
	public IEvent<EventArgs> getCreateCriterion() {
		return this.createCriterion;
	}

	@Override
	public IEvent<EventArgs> getCreateHint() {
		return this.createHint;
	}

	@Override
	public IEvent<EventArgs> getCreateRelation() {
		return this.createRelation;
	}

	@Override
	public String getDescription() {
		return this.textArea.getText();
	}

	protected FlexTable getGrid() {
		return this.detailTable;
	}

	@Override
	public String getName() {
		return this.txtBxName.getText();
	}

	@Override
	public IEvent<RemoveCriterionEventArgs> getRemoveCriterion() {
		return this.removeCriterionEvent;
	}

	@Override
	public IEvent<RemoveHintEventArgs> getRemoveHint() {
		return this.removeHintEvent;
	}

	@Override
	public IEvent<RemoveRelationEventArgs> getRemoveRelation() {
		return this.removeRelationEvent;
	}

	@Override
	public IEvent<EventArgs> getSave() {
		return this.save;
	}

	@Override
	public ISprint getSelectedSprint() {
		final Integer index = this.sprintComboBox.getSelectedIndex();
		if (index.equals(0) || index.equals(-1)) {
			return null;
		} else {
			return this.sprints.get(index + 1);
		}

	}

	@Override
	public void setCriteria(final List<AcceptanceCriterion> criterions) {
		if (criterions.size() > 0) {
			this.criteriaTable.setVisible(true);
			this.criteriaTable.setRowData(criterions);
		} else {
			this.criteriaTable.setVisible(false);
		}
	}

	@Override
	public void setDescription(final String description) {
		this.textArea.setText(description);
	}

	@Override
	public void setHints(final List<Hint> hints) {
		if (hints.size() > 0) {
			this.hintTable.setVisible(true);
			this.hintTable.setRowData(hints);
		} else {
			this.hintTable.setVisible(false);
		}
	}

	@Override
	public void setName(final String name) {
		this.txtBxName.setText(name);
	}

	@Override
	public void setNewCriterionEnabled(final Boolean enabled) {
		this.btnAddCriterion.setVisible(enabled);
	}

	@Override
	public void setNewHintEnabled(final Boolean enabled) {
		this.btnAddHint.setVisible(enabled);
	}

	@Override
	public void setRelations(final List<Relation> relations) {
		if (relations.size() > 0) {
			this.relationTable.setVisible(true);
			this.relationTable.setRowData(relations);
		} else {
			this.relationTable.setVisible(false);
		}
	}

	@Override
	public void setSprints(final List<ISprint> sprints, final ISprint selected) {
		this.sprints = sprints;
		this.sprintComboBox.clear();
		this.sprintComboBox.addItem(""); // Adding an empty item!
		for (final ISprint iSprint : sprints) {
			String text = iSprint.getName();
			if (text == null) {
				text = iSprint.toString();
			}

			this.sprintComboBox.addItem(text);
		}
		if (selected != null) {
			final int index = sprints.indexOf(selected);
			this.sprintComboBox.setSelectedIndex(index + 1);
		} else {
			this.sprintComboBox.setSelectedIndex(0);
		}
	}
}
