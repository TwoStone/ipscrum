package fhdw.ipscrum.client.view;

import com.google.gwt.cell.client.ButtonCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.events.Event;
import fhdw.ipscrum.client.events.IEvent;
import fhdw.ipscrum.client.events.args.RemoveCriterionEventArgs;
import fhdw.ipscrum.client.events.args.RemoveHintEventArgs;
import fhdw.ipscrum.client.events.args.RemoveRelationEventArgs;
import fhdw.ipscrum.client.view.interfaces.IFeatureView;
import fhdw.ipscrum.shared.model.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.Hint;
import fhdw.ipscrum.shared.model.Relation;
import com.google.gwt.user.client.ui.SimplePanel;

public class FeatureView extends Composite implements IFeatureView {
	
	private TextBox txtBxName;
	private IntegerBox ibxComplexity;
	private TextArea textArea;
	private Button btnAddRelation;
	private Button btnAddHint;
	private Button btnAddCriterion;
	private Button btnSave;
	private Button btnDelete;
	private Button btnClose;
	private CellTable<Relation> relationTable;
	private Label lblCurrentState;
	private CellTable<Hint> hintTable;
	private Label lblAkzptanzkriterien;
	private CellTable<AcceptanceCriterion> criteriaTable;
	private Event<RemoveRelationEventArgs> removeRelationEvent = new Event<RemoveRelationEventArgs>();
	private Event<RemoveCriterionEventArgs> removeCriterionEvent = new Event<RemoveCriterionEventArgs>();
	private Event<RemoveHintEventArgs> removeHintEvent = new Event<RemoveHintEventArgs>();
	private SimplePanel addHintPanel;
	private SimplePanel addCriterionPanel;
	
	
	public FeatureView() {
		
		VerticalPanel verticalPanel_2 = new VerticalPanel();
		verticalPanel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		initWidget(verticalPanel_2);
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		verticalPanel_2.add(horizontalPanel);

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(10);
		horizontalPanel.add(verticalPanel);
		
		Grid grid = new Grid(3, 2);
		verticalPanel.add(grid);
		
		Label lblName = new Label("Name:");
		grid.setWidget(0, 0, lblName);
		
		txtBxName = new TextBox();
		grid.setWidget(0, 1, txtBxName);
		
		Label lblComplexity = new Label("Aufwand:");
		grid.setWidget(1, 0, lblComplexity);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		grid.setWidget(1, 1, horizontalPanel_1);
		
		ibxComplexity = new IntegerBox();
		ibxComplexity.setVisibleLength(5);
		horizontalPanel_1.add(ibxComplexity);
		
		Label lblMt = new Label("MT");
		horizontalPanel_1.add(lblMt);
		
		Label lblState = new Label("Status");
		grid.setWidget(2, 0, lblState);
		
		lblCurrentState = new Label("");
		grid.setWidget(2, 1, lblCurrentState);
		
		Label lblDescription = new Label("Beschreibung");
		verticalPanel.add(lblDescription);
		
		textArea = new TextArea();
		textArea.setCharacterWidth(25);
		verticalPanel.add(textArea);
		textArea.setWidth("223px");
		
		Label lblRelations = new Label("Beziehungen:");
		verticalPanel.add(lblRelations);
		
		relationTable = new CellTable<Relation>();
		
		TextColumn<Relation> typeCol = new TextColumn<Relation>() {
			@Override
			public String getValue(Relation object) {
				return object.getType().getDescription();
			}
		};
		relationTable.addColumn(typeCol);
		
		TextColumn<Relation> targetCol = new TextColumn<Relation>() {
			@Override
			public String getValue(Relation object) {
				return object.getTarget().getName();
			}
		};
		relationTable.addColumn(targetCol);
		
		Column<Relation, String> deleteCol = new Column<Relation, String>(new ButtonCell()) {
			@Override
			public String getValue(Relation object) {
				return "x";
			}
		};
		deleteCol.setFieldUpdater(new FieldUpdater<Relation, String>() {

			@Override
			public void update(int index, Relation object, String value) {
				FeatureView.this.removeRelationEvent.fire(FeatureView.this, new RemoveRelationEventArgs(object));
			}
		});
		
		relationTable.addColumn(deleteCol);
		verticalPanel.add(relationTable);
		
		btnAddRelation = new Button("New button");
		btnAddRelation.setText("Beziehung hinzuf\u00FCgen");
		verticalPanel.add(btnAddRelation);
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setSpacing(10);
		horizontalPanel.add(verticalPanel_1);
		
		Label lblHinweise = new Label("Hinweise:");
		verticalPanel_1.add(lblHinweise);
		
		hintTable = new CellTable<Hint>();
		
		TextColumn<Hint> hintTextCol = new TextColumn<Hint>() {
			@Override
			public String getValue(Hint object) {
				return object.getContent();
			}
		};
		hintTable.addColumn(hintTextCol);
		
		Column<Hint, String> removeHintCol = new Column<Hint, String>(new ButtonCell()) {
			@Override
			public String getValue(Hint object) {
				return object.toString();
			}
		};
		removeHintCol.setFieldUpdater(new FieldUpdater<Hint, String>() {
			
			@Override
			public void update(int index, Hint object, String value) {
				FeatureView.this.removeHintEvent.fire(FeatureView.this, new RemoveHintEventArgs(object));
			}
		});
		hintTable.addColumn(removeHintCol);
		verticalPanel_1.add(hintTable);
		
		addHintPanel = new SimplePanel();
		verticalPanel_1.add(addHintPanel);
		
		btnAddHint = new Button("New button");
		verticalPanel_1.add(btnAddHint);
		btnAddHint.setText("Hinweis hinzuf\u00FCgen");
		
		lblAkzptanzkriterien = new Label("Akzptanzkriterien:");
		verticalPanel_1.add(lblAkzptanzkriterien);
		
		criteriaTable = new CellTable<AcceptanceCriterion>();
		
		TextColumn<AcceptanceCriterion> criterionTextCol = new TextColumn<AcceptanceCriterion>() {
			@Override
			public String getValue(AcceptanceCriterion object) {
				return object.getContent();
			}
		};
		criteriaTable.addColumn(criterionTextCol);
		
		Column<AcceptanceCriterion, String> removeCriterionCol = new Column<AcceptanceCriterion, String>(new ButtonCell()) {
			@Override
			public String getValue(AcceptanceCriterion object) {
				return object.toString();
			}
		};
		removeCriterionCol.setFieldUpdater(new FieldUpdater<AcceptanceCriterion, String>() {

			@Override
			public void update(int index, AcceptanceCriterion object,
					String value) {
				FeatureView.this.removeCriterionEvent.fire(FeatureView.this, new RemoveCriterionEventArgs(object));
			}
		});
		
		criteriaTable.addColumn(removeCriterionCol);
		verticalPanel_1.add(criteriaTable);
		
		addCriterionPanel = new SimplePanel();
		verticalPanel_1.add(addCriterionPanel);
		
		btnAddCriterion = new Button("New button");
		verticalPanel_1.add(btnAddCriterion);
		btnAddCriterion.setText("Kriterium hinzuf\u00FCgen");
		
		HorizontalPanel horizontalPanel_2 = new HorizontalPanel();
		horizontalPanel_2.setSpacing(5);
		horizontalPanel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);
		verticalPanel_2.add(horizontalPanel_2);
		
		btnSave = new Button("New button");
		btnSave.setText("Speichern");
		horizontalPanel_2.add(btnSave);
		
		btnDelete = new Button("New button");
		btnDelete.setText("Verwerfen");
		horizontalPanel_2.add(btnDelete);
		
		btnClose = new Button("New button");
		btnClose.setText("Abschlie\u00DFen");
		horizontalPanel_2.add(btnClose);
	}
	public CellTable<Relation> getRelations() {
		return relationTable;
	}
	public TextBox getName() {
		return txtBxName;
	}
	public IntegerBox getComplexity() {
		return ibxComplexity;
	}
	public Label getState() {
		return lblCurrentState;
	}
	public TextArea getDescription() {
		return textArea;
	}
	public CellTable<Hint> getHints() {
		return hintTable;
	}
	public Button getCreateHint() {
		return btnAddHint;
	}
	public Button getCreateCriterion() {
		return btnAddCriterion;
	}
	public Button getCreateRelation() {
		return btnAddRelation;
	}
	public CellTable<AcceptanceCriterion> getCriteria() {
		return criteriaTable;
	}
	public Button getSave() {
		return btnSave;
	}
	public Button getAbort() {
		return btnDelete;
	}
	public Button getCloseFeature() {
		return btnClose;
	}
	@Override
	public IEvent<RemoveRelationEventArgs> getRemoveRelation() {
		return this.removeRelationEvent;
	}
	@Override
	public IEvent<RemoveCriterionEventArgs> getRemoveCriterion() {
		return this.removeCriterionEvent;
	}
	@Override
	public IEvent<RemoveHintEventArgs> getRemoveHint() {
		return this.removeHintEvent;
	}
	public SimplePanel getAddHintPanel() {
		return addHintPanel;
	}
	public SimplePanel getAddCriterionPanel() {
		return addCriterionPanel;
	}
}
