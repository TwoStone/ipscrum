package fhdw.ipscrum.client.view;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellBrowser;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.AbstractDataProvider;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.NoSelectionModel;
import com.google.gwt.view.client.SelectionModel.AbstractSelectionModel;
import com.google.gwt.view.client.TreeViewModel;

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
	
	public static IPersonRoleMngmtView createView() {
		return new PersonRoleMngmtView();
	}
	
	public PersonRoleMngmtView() {
		
		HorizontalPanel horizontalPanel = new HorizontalPanel();
		initWidget(horizontalPanel);
		
		VerticalPanel personPanel = new VerticalPanel();
		horizontalPanel.add(personPanel);
		personPanel.setWidth("300px");
		
		Label lblPersonen = new Label("Personen");
		personPanel.add(lblPersonen);
		
		CellBrowser cellBrowser = new CellBrowser(
			new TreeViewModel() {
				final AbstractDataProvider<String> dataProvider = new ListDataProvider<String>();
				final AbstractSelectionModel<String> selectionModel = new NoSelectionModel<String>();
				@Override
				public <T> NodeInfo<?> getNodeInfo(T value) {
					return new DefaultNodeInfo<String>(dataProvider, new TextCell(), selectionModel, null);
				}
				@Override
				public boolean isLeaf(Object value) {
					return true;
				}
			}, null);
		personPanel.add(cellBrowser);
		
		buttonPersonNew = new Button("New button");
		personPanel.add(buttonPersonNew);
		buttonPersonNew.setText("Neue Person anlegen");
		
		HorizontalPanel personButtonPanel = new HorizontalPanel();
		personPanel.add(personButtonPanel);
		
		buttonPersonEdit = new Button("New button");
		buttonPersonEdit.setText("Editieren");
		personButtonPanel.add(buttonPersonEdit);
		
		buttonPersonDelete = new Button("New button");
		buttonPersonDelete.setText("Entfernen");
		personButtonPanel.add(buttonPersonDelete);
		
		VerticalPanel buttonPanel = new VerticalPanel();
		horizontalPanel.add(buttonPanel);
		
		buttonRight = new Button("New button");
		buttonRight.setText("->");
		buttonPanel.add(buttonRight);
		
		buttonLeft = new Button("New button");
		buttonLeft.setText("<-");
		buttonPanel.add(buttonLeft);
		
		VerticalPanel rolePanel = new VerticalPanel();
		horizontalPanel.add(rolePanel);
		rolePanel.setWidth("150px");
		
		Label lblRollen = new Label("Rollen");
		rolePanel.add(lblRollen);
		
		CellList<Object> cellList = new CellList<Object>(new AbstractCell<Object>(){
			@Override
			public void render(Context context, Object value, SafeHtmlBuilder sb) {
				// TODO
			}
		});
		rolePanel.add(cellList);
		
		buttonRoleNew = new Button("New button");
		buttonRoleNew.setText("Neue Rolle anlegen");
		rolePanel.add(buttonRoleNew);
		
		HorizontalPanel roleButtonPanel = new HorizontalPanel();
		rolePanel.add(roleButtonPanel);
		
		buttonRoleRename = new Button("New button");
		buttonRoleRename.setText("Umbenennen");
		roleButtonPanel.add(buttonRoleRename);
		
		buttonRoleDelete = new Button("New button");
		buttonRoleDelete.setText("Entfernen");
		roleButtonPanel.add(buttonRoleDelete);
	}


	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleMngm#getButtonRight()
	 */
	@Override
	public HasClickHandlers getButtonRight() {
		return buttonRight;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleMngm#getButtonLeft()
	 */
	@Override
	public HasClickHandlers getButtonLeft() {
		return buttonLeft;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleMngm#getButtonPersonNew()
	 */
	@Override
	public HasClickHandlers getButtonPersonNew() {
		return buttonPersonNew;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleMngm#getButtonPersonEdit()
	 */
	@Override
	public HasClickHandlers getButtonPersonEdit() {
		return buttonPersonEdit;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleMngm#getButtonPersonDelete()
	 */
	@Override
	public HasClickHandlers getButtonPersonDelete() {
		return buttonPersonDelete;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleMngm#getButtonRoleNew()
	 */
	@Override
	public HasClickHandlers getButtonRoleNew() {
		return buttonRoleNew;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleMngm#getButtonRoleRename()
	 */
	@Override
	public HasClickHandlers getButtonRoleRename() {
		return buttonRoleRename;
	}
	/* (non-Javadoc)
	 * @see fhdw.ipscrum.client.view.IPersonRoleMngm#getButtonRoleDelete()
	 */
	@Override
	public HasClickHandlers getButtonRoleDelete() {
		return buttonRoleDelete;
	}
}
