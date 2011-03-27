package fhdw.ipscrum.client.view;

import java.util.Date;
import java.util.Vector;

import com.google.gwt.cell.client.DateCell;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import com.google.gwt.user.datepicker.client.DateBox.DefaultFormat;

import fhdw.ipscrum.client.view.interfaces.IProjectHistoryView;
import fhdw.ipscrum.shared.model.incidents.Incident;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ValueBoxBase.TextAlignment;

public class ProjectHistoryView extends Composite implements IProjectHistoryView{
	private CellTable<Object> projectHistoryTable;
	public ProjectHistoryView() {
		
		AbsolutePanel concreteProjectHistoryPanel = new AbsolutePanel();
		initWidget(concreteProjectHistoryPanel);
		concreteProjectHistoryPanel.setSize("775px", "600px");
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setStyleName("createFeatureTable");
		horizontalPanel.setSpacing(3);
		concreteProjectHistoryPanel.add(horizontalPanel, 60, 384);
		horizontalPanel.setSize("500px", "150px");
		
		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(2);
		horizontalPanel.add(verticalPanel);
		verticalPanel.setSize("170px", "144px");
		
		Label lblTyp = new Label("Typ:");
		verticalPanel.add(lblTyp);
		
		ListBox listBox = new ListBox();
		listBox.setDirectionEstimator(false);
		verticalPanel.add(listBox);
		listBox.setSize("146px", "22px");
		listBox.setVisibleItemCount(1);
		
		Label lblStartdatum = new Label("Start-Datum:");
		verticalPanel.add(lblStartdatum);
		
		DateBox dateBox = new DateBox();
		dateBox.setFormat(new DefaultFormat(DateTimeFormat.getFormat("dd-MM-yyyy")));
		verticalPanel.add(dateBox);
		
		Label lblEndedatum = new Label("Ende-Datum:");
		verticalPanel.add(lblEndedatum);
		
		DateBox dateBox_1 = new DateBox();
		dateBox_1.setFormat(new DefaultFormat(DateTimeFormat.getFormat("dd-MM-yyyy")));
		verticalPanel.add(dateBox_1);
		
		VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setSpacing(2);
		horizontalPanel.add(verticalPanel_1);
		verticalPanel_1.setSize("200px", "144px");
		
		Label lblBeschreibung = new Label("Beschreibung:");
		verticalPanel_1.add(lblBeschreibung);
		
		TextBox textBox = new TextBox();
		textBox.setAlignment(TextAlignment.LEFT);
		verticalPanel_1.add(textBox);
		verticalPanel_1.setCellHorizontalAlignment(textBox, HasHorizontalAlignment.ALIGN_CENTER);
		textBox.setSize("218px", "70px");
		
		VerticalPanel verticalPanel_2 = new VerticalPanel();
		verticalPanel_2.setSpacing(2);
		horizontalPanel.add(verticalPanel_2);
		verticalPanel_2.setSize("200px", "144px");
		
		Label lblPersonen = new Label("Personen:");
		verticalPanel_2.add(lblPersonen);
		lblPersonen.setSize("226", "18");
		
		ListBox listBox_1 = new ListBox();
		verticalPanel_2.add(listBox_1);
		verticalPanel_2.setCellVerticalAlignment(listBox_1, HasVerticalAlignment.ALIGN_MIDDLE);
		listBox_1.setSize("200px", "77px");
		listBox_1.setVisibleItemCount(5);
		
		Button btnAnlegen = new Button("Anlegen");
		btnAnlegen.setStyleName("taskboardButton");
		verticalPanel_2.add(btnAnlegen);
		
		HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(3);
		concreteProjectHistoryPanel.add(horizontalPanel_1, 0, 0);
		horizontalPanel_1.setSize("760px", "368px");
		
		ScrollPanel scrollPanel = new ScrollPanel();
		horizontalPanel_1.add(scrollPanel);
		scrollPanel.setSize("760px", "362px");
		
		projectHistoryTable = new CellTable<Object>();
		scrollPanel.setWidget(projectHistoryTable);
		projectHistoryTable.setTableLayoutFixed(false);
		projectHistoryTable.setSize("760px", "360px");
		
		Column<Object, Date> startDateColumn = new Column<Object, Date>(new DateCell()) {
			@Override
			public Date getValue(Object object) {
				return null;
			}
		};
		projectHistoryTable.addColumn(startDateColumn, "Start-Datum");
		
		Column<Object, Date> endDateColumn = new Column<Object, Date>(new DateCell()) {
			@Override
			public Date getValue(Object object) {
				return null;
			}
		};
		projectHistoryTable.addColumn(endDateColumn, "Ende-Datum");
		
		TextColumn<Object> textColumn = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		projectHistoryTable.addColumn(textColumn, "Typ");
		
		TextColumn<Object> textColumn_1 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		projectHistoryTable.addColumn(textColumn_1, "Beschreibung");
		
		TextColumn<Object> textColumn_2 = new TextColumn<Object>() {
			@Override
			public String getValue(Object object) {
				return object.toString();
			}
		};
		projectHistoryTable.addColumn(textColumn_2, "Personen");

	}
	protected CellTable getProjectHistoryTable() {
		return projectHistoryTable;
	}
	@Override
	public void refreshProjectHistoryTable(Vector<Incident> incidents) {
		this.getProjectHistoryTable().setRowData(incidents);
	}
}
