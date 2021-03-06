package fhdw.ipscrum.client.architecture.widgets;

import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.shared.model.nonMeta.Role;

/**
 * represents the view to chose the role to log in the IPScrum.
 */
public class RoleChooserView extends MasterView implements IRoleChoser {
	private final CellList<Role> roleList;
	private final SingleSelectionModel<Role> selModel = new SingleSelectionModel<Role>();

	private final Button btnGo;
	private final Label lbFailure;

	/**
	 * constructor of the RoleChooserView.
	 */
	public RoleChooserView() {

		// final VerticalPanel verticalPanel = new VerticalPanel();
		this.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		this.setSpacing(5);
		// this.initWidget(verticalPanel);
		this.setSize("250px", "200px");

		final Label lblHeader = new Label("Bitte eine Rolle auswählen:");
		lblHeader.setStyleName("LabelElement");
		this.add(lblHeader);

		this.lbFailure = new Label("");
		this.lbFailure.setStyleName("serverResponseLabelError");
		this.add(this.lbFailure);

		this.roleList = new CellList<Role>(new AbstractCell<Role>() {
			@Override
			public void render(final Context context, final Role value, final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.getDescription());
			}
		});
		this.roleList.setStyleName("tableBorder");
		this.add(this.roleList);
		this.roleList.setHeight("150px");

		this.roleList.setSelectionModel(this.selModel);

		this.btnGo = new Button("Weiter");

		this.add(this.btnGo);
	}

	private CellList<Role> getRoleList() {
		return this.roleList;
	}

	@Override
	public void refreshRoles(final List<Role> roles) {
		this.getRoleList().setRowData(roles);
	}

	@Override
	public void registerGo(final ClickHandler handler) {
		this.btnGo.addClickHandler(handler);
	}

	@Override
	public Role getSelRole() {
		return this.selModel.getSelectedObject();
	}

	@Override
	public void setFailure(final String fail) {
		this.lbFailure.setText(fail);

	}

	@Override
	public void close() {
		// no events to remove!

	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// no widgets to hide.

	}

}
