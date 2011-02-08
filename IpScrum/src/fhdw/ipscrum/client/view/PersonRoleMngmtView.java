package fhdw.ipscrum.client.view;

import java.util.Arrays;
import java.util.List;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.HasKeyboardSelectionPolicy.KeyboardSelectionPolicy;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.view.interfaces.IPersonRoleMngmtView;

public class PersonRoleMngmtView extends Composite implements IPersonRoleMngmtView {
	private Button buttonRight;
	private Button buttonLeft;
	private Button buttonPersonNew;
	private Button buttonPersonEdit;
	private Button buttonPersonDelete;
	private Button buttonRoleNew;
	private Button buttonRoleRename;
	private Button buttonRoleDelete;
	private CellList<String> roleList;
	private CellTable<Object> personTable;

	public static IPersonRoleMngmtView createView() {
		return new PersonRoleMngmtView();
	}

	public PersonRoleMngmtView() {

		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		initWidget(horizontalPanel);

		VerticalPanel personPanel = new VerticalPanel();
		horizontalPanel.add(personPanel);
		personPanel.setWidth("300px");

		Label lblPersonen = new Label("Personen");
		personPanel.add(lblPersonen);

		personTable = new CellTable<Object>();
		personTable.setStyleName("tableBorder");
		personPanel.add(personTable);
		personTable.setSize("300px", "300px");

		buttonPersonNew = new Button();
		personPanel.add(buttonPersonNew);
		buttonPersonNew.setWidth("100%");
		buttonPersonNew.setText("Neue Person anlegen");

		HorizontalPanel personButtonPanel = new HorizontalPanel();
		personPanel.add(personButtonPanel);
		personButtonPanel.setWidth("100%");

		buttonPersonEdit = new Button();
		buttonPersonEdit.setText("Editieren");
		personButtonPanel.add(buttonPersonEdit);
		buttonPersonEdit.setWidth("100%");

		buttonPersonDelete = new Button();
		buttonPersonDelete.setText("Entfernen");
		personButtonPanel.add(buttonPersonDelete);
		buttonPersonDelete.setWidth("100%");

		VerticalPanel buttonPanel = new VerticalPanel();
		horizontalPanel.add(buttonPanel);
		horizontalPanel.setCellVerticalAlignment(buttonPanel, HasVerticalAlignment.ALIGN_MIDDLE);

		buttonRight = new Button();
		buttonRight.setText("->");
		buttonPanel.add(buttonRight);

		buttonLeft = new Button();
		buttonLeft.setText("<-");
		buttonPanel.add(buttonLeft);

		VerticalPanel rolePanel = new VerticalPanel();
		horizontalPanel.add(rolePanel);
		rolePanel.setWidth("150px");

		Label lblRollen = new Label("Rollen");
		rolePanel.add(lblRollen);

		// Create a cell to render each value.
		TextCell textCell = new TextCell();

		// Create a CellList that uses the cell.
		roleList = new CellList<String>(textCell);
		roleList.setStyleName("tableBorder");
		roleList.setHeight("300px");
		roleList.setKeyboardSelectionPolicy(KeyboardSelectionPolicy.ENABLED);

		List<String> roles = Arrays.asList("Ticketsystem-Benutzer", "Scrum-Master", "Product-Owner", "Entwickler", "Tester", "GUI-Wizard");

		// Add a selection model to handle user selection.
		final SingleSelectionModel<String> selectionModel = new SingleSelectionModel<String>();
		roleList.setSelectionModel(selectionModel);

		// Push the data into the widget.
		roleList.setRowData(0, roles);
		rolePanel.add(roleList);

		buttonRoleNew = new Button();
		buttonRoleNew.setText("Neue Rolle anlegen");
		rolePanel.add(buttonRoleNew);
		buttonRoleNew.setWidth("100%");

		HorizontalPanel roleButtonPanel = new HorizontalPanel();
		rolePanel.add(roleButtonPanel);

		buttonRoleRename = new Button();
		buttonRoleRename.setText("Umbenennen");
		roleButtonPanel.add(buttonRoleRename);
		buttonRoleRename.setWidth("100%");

		buttonRoleDelete = new Button();
		buttonRoleDelete.setText("Entfernen");
		roleButtonPanel.add(buttonRoleDelete);
		buttonRoleDelete.setWidth("100%");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IPersonRoleMngm#getButtonRight()
	 */
	@Override
	public HasClickHandlers getButtonRight() {
		return buttonRight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IPersonRoleMngm#getButtonLeft()
	 */
	@Override
	public HasClickHandlers getButtonLeft() {
		return buttonLeft;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IPersonRoleMngm#getButtonPersonNew()
	 */
	@Override
	public HasClickHandlers getButtonPersonNew() {
		return buttonPersonNew;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IPersonRoleMngm#getButtonPersonEdit()
	 */
	@Override
	public HasClickHandlers getButtonPersonEdit() {
		return buttonPersonEdit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IPersonRoleMngm#getButtonPersonDelete()
	 */
	@Override
	public HasClickHandlers getButtonPersonDelete() {
		return buttonPersonDelete;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IPersonRoleMngm#getButtonRoleNew()
	 */
	@Override
	public HasClickHandlers getButtonRoleNew() {
		return buttonRoleNew;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IPersonRoleMngm#getButtonRoleRename()
	 */
	@Override
	public HasClickHandlers getButtonRoleRename() {
		return buttonRoleRename;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fhdw.ipscrum.client.view.IPersonRoleMngm#getButtonRoleDelete()
	 */
	@Override
	public HasClickHandlers getButtonRoleDelete() {
		return buttonRoleDelete;
	}
	public CellList getRoleList() {
		return roleList;
	}
	public CellTable getPersonTable() {
		return personTable;
	}
}
