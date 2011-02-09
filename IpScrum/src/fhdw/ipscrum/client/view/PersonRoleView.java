package fhdw.ipscrum.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.MultiSelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.view.interfaces.IPersonRoleView;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;
import com.google.gwt.user.client.ui.ScrollPanel;

public class PersonRoleView extends Composite implements IPersonRoleView {
	private CellTable<IPerson> cellTablePersons;
	private CellList<IRole> cellListAssignedRoles;
	private CellList<IRole> cellListRoles;
	private Button btnPersonNew;
	private Button btnPersonModify;
	private Button btnPersonRemove;
	private Button buttonRemoveRoleFromPerson;
	private Button buttonAddRoleToPerson;
	private Button btnRoleNew;
	private Button btnRoleRemove;
	private ScrollPanel scrollPanelPersons;

	public static IPersonRoleView createView() {
		return new PersonRoleView();
	}
	
	public PersonRoleView() {
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		horizontalPanel.setSpacing(5);
		initWidget(horizontalPanel);
		
		VerticalPanel verticalPanel = new VerticalPanel();
		horizontalPanel.add(verticalPanel);
		
		Label lblPersonen = new Label("Personen");
		verticalPanel.add(lblPersonen);
		
		HorizontalPanel horizontalPanelPersonRoles = new HorizontalPanel();
		verticalPanel.add(horizontalPanelPersonRoles);
		horizontalPanelPersonRoles.setSize("", "300px");
		
		scrollPanelPersons = new ScrollPanel();
		scrollPanelPersons.setStyleName("tableBorder");
		scrollPanelPersons.setSize("300px", "300px");
		horizontalPanelPersonRoles.add(scrollPanelPersons);
		
		cellTablePersons = new CellTable<IPerson>();
		scrollPanelPersons.setWidget(cellTablePersons);
		cellTablePersons.setSize("100%", "100%");
		final SingleSelectionModel<IPerson> selModelPersons = new SingleSelectionModel<IPerson>();
		cellTablePersons.setSelectionModel(selModelPersons);
		
		RoleCell roleCellAssignedRoles = new RoleCell();
		cellListAssignedRoles = new CellList<IRole>(roleCellAssignedRoles);
		cellListAssignedRoles.setStyleName("tableBorder");
		horizontalPanelPersonRoles.add(cellListAssignedRoles);
		cellListAssignedRoles.setSize("200px", "100%");
		SingleSelectionModel<IRole> selModelAssignedRoles = new SingleSelectionModel<IRole>();
		cellListAssignedRoles.setSelectionModel(selModelAssignedRoles);
		
		HorizontalPanel horizontalPanelPersonButtons = new HorizontalPanel();
		verticalPanel.add(horizontalPanelPersonButtons);
		horizontalPanelPersonButtons.setWidth("100%");
		verticalPanel.setCellHorizontalAlignment(horizontalPanelPersonButtons, HasHorizontalAlignment.ALIGN_CENTER);
		
		btnPersonNew = new Button("Neue Person anlegen");
		horizontalPanelPersonButtons.add(btnPersonNew);
		btnPersonNew.setWidth("100%");
		
		btnPersonModify = new Button("Editieren");
		horizontalPanelPersonButtons.add(btnPersonModify);
		btnPersonModify.setWidth("100%");
		
		btnPersonRemove = new Button("Entfernen");
		horizontalPanelPersonButtons.add(btnPersonRemove);
		btnPersonRemove.setWidth("100%");
		
		VerticalPanel verticalPanelAllocationButtons = new VerticalPanel();
		verticalPanelAllocationButtons.setStyleName("allocationButtonPanel");
		verticalPanelAllocationButtons.setHeight("");
		horizontalPanel.add(verticalPanelAllocationButtons);
		
		buttonRemoveRoleFromPerson = new Button("->");
		verticalPanelAllocationButtons.add(buttonRemoveRoleFromPerson);
		
		buttonAddRoleToPerson = new Button("<-");
		verticalPanelAllocationButtons.add(buttonAddRoleToPerson);
		
		VerticalPanel verticalPanelRoles = new VerticalPanel();
		horizontalPanel.add(verticalPanelRoles);
		verticalPanelRoles.setSize("200px", "");
		
		Label lblRollen = new Label("Rollen");
		verticalPanelRoles.add(lblRollen);
		
		RoleCell roleCellAvailRoles = new RoleCell();
		cellListRoles = new CellList<IRole>(roleCellAvailRoles);
		cellListRoles.setStyleName("tableBorder");
		verticalPanelRoles.add(cellListRoles);
		cellListRoles.setSize("100%", "300px");
		MultiSelectionModel<IRole> selModelAvailRoles = new MultiSelectionModel<IRole>();
		cellListRoles.setSelectionModel(selModelAvailRoles);
		
		btnRoleNew = new Button("Neue Rolle anlegen");
		verticalPanelRoles.add(btnRoleNew);
		btnRoleNew.setWidth("100%");
		
		btnRoleRemove = new Button("Entfernen");
		verticalPanelRoles.add(btnRoleRemove);
		btnRoleRemove.setWidth("100%");
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleView#getListBoxPersons()
	 */
	@Override
	public CellTable<IPerson> getCellTablePersons() {
		return cellTablePersons;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleView#getListBoxAssignedRoles()
	 */
	@Override
	public CellList<IRole> getCellListAssignedRoles() {
		return cellListAssignedRoles;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleView#getBtnPersonNew()
	 */
	@Override
	public HasClickHandlers getBtnPersonNew() {
		return btnPersonNew;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleView#getBtnPersonModify()
	 */
	@Override
	public HasClickHandlers getBtnPersonModify() {
		return btnPersonModify;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleView#getBtnPersonRemove()
	 */
	@Override
	public HasClickHandlers getBtnPersonRemove() {
		return btnPersonRemove;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleView#getButtonRemoveRoleFromPerson()
	 */
	@Override
	public HasClickHandlers getButtonRemoveRoleFromPerson() {
		return buttonRemoveRoleFromPerson;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleView#getButtonAddRoleToPerson()
	 */
	@Override
	public HasClickHandlers getButtonAddRoleToPerson() {
		return buttonAddRoleToPerson;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleView#getBtnRoleNew()
	 */
	@Override
	public HasClickHandlers getBtnRoleNew() {
		return btnRoleNew;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleView#getBtnRoleRemove()
	 */
	@Override
	public HasClickHandlers getBtnRoleRemove() {
		return btnRoleRemove;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleView#getListBoxRoles()
	 */
	@Override
	public CellList<IRole> getCellListRoles() {
		return cellListRoles;
	}
}
