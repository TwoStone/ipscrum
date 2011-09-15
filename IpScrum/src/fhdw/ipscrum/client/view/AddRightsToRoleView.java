package fhdw.ipscrum.client.view;

import java.util.List;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.architecture.events.Event;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.shared.model.userRights.Right;

/**
 * represents the view in which rights could be added to a role.
 */
public class AddRightsToRoleView extends Composite implements IAddRightsToRoleView {
	private final CellList<Right> RightsToAdd;
	private final CellList<Right> addedRights;
	private final Event<TypedEventArg<Right>> addRight =
			new Event<TypedEventArg<Right>>();
	private final Event<TypedEventArg<Right>> removeRight =
			new Event<TypedEventArg<Right>>();

	private final SingleSelectionModel<Right> selModelAdded =
			new SingleSelectionModel<Right>();

	private final SingleSelectionModel<Right> selModel =
			new SingleSelectionModel<Right>();

	/**
	 * constructor of the AddRightsToRoleView.
	 */
	public AddRightsToRoleView() {

		final VerticalPanel horizontalPanel = new VerticalPanel();
		horizontalPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel.setSpacing(5);
		this.initWidget(horizontalPanel);
		horizontalPanel.setSize("500px", "300px");

		final Label lblHeader = new Label("Berechtigungen zuordnen");
		lblHeader.setStyleName("LabelElement");
		horizontalPanel.add(lblHeader);

		final HorizontalPanel horizontalPanel_1 = new HorizontalPanel();
		horizontalPanel_1.setSpacing(5);
		horizontalPanel_1.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		horizontalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		horizontalPanel.add(horizontalPanel_1);
		horizontalPanel_1.setSize("430px", "250px");

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel.setSpacing(1);
		horizontalPanel_1.add(verticalPanel);
		verticalPanel.setSize("200px", "250px");

		final Label lblNewLabel = new Label("Zugeordnete Rechte");
		verticalPanel.add(lblNewLabel);
		lblNewLabel.setHeight("20px");

		this.addedRights = new CellList<Right>(new AbstractCell<Right>() {
			@Override
			public void render(final Context context, final Right value,
					final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.toString());
			}
		});
		this.addedRights.setStyleName("tableBorder");
		verticalPanel.add(this.addedRights);
		this.addedRights.setSize("200px", "230px");

		final VerticalPanel verticalPanel_2 = new VerticalPanel();
		horizontalPanel_1.add(verticalPanel_2);
		verticalPanel_2.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		verticalPanel_2.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_2.setSize("90%", "90%");

		final Button btnAdd = new Button("<-");
		verticalPanel_2.add(btnAdd);

		final Button btnRemove = new Button("->");
		verticalPanel_2.add(btnRemove);
		btnRemove.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {

				AddRightsToRoleView.this.removeRight.fire(
						AddRightsToRoleView.this,
						new TypedEventArg<Right>(AddRightsToRoleView.this.selModelAdded
								.getSelectedObject()));

			}
		});

		btnAdd.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(final ClickEvent event) {

				AddRightsToRoleView.this.addRight.fire(
						AddRightsToRoleView.this,
						new TypedEventArg<Right>(AddRightsToRoleView.this.selModel
								.getSelectedObject()));

			}
		});

		final VerticalPanel verticalPanel_1 = new VerticalPanel();
		verticalPanel_1.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		verticalPanel_1.setSpacing(1);
		horizontalPanel_1.add(verticalPanel_1);
		verticalPanel_1.setSize("200px", "250px");

		final Label lblNewLabel_1 = new Label("Verfügbare Rechte");
		verticalPanel_1.add(lblNewLabel_1);
		lblNewLabel_1.setHeight("20px");

		this.RightsToAdd = new CellList<Right>(new AbstractCell<Right>() {
			@Override
			public void render(final Context context, final Right value,
					final SafeHtmlBuilder sb) {
				sb.appendEscaped(value.toString());
			}
		});
		this.RightsToAdd.setStyleName("tableBorder");
		verticalPanel_1.add(this.RightsToAdd);
		this.RightsToAdd.setSize("200px", "230px");
		this.RightsToAdd.setSelectionModel(this.selModel);

		this.addedRights.setSelectionModel(this.selModelAdded);
	}

	private CellList<Right> getRightsToAdd() {
		return this.RightsToAdd;
	}

	private CellList<Right> getAddedRights() {
		return this.addedRights;
	}

	@Override
	public void close() {
		this.addRight.removeAllHandler();

	}

	@Override
	public void setAddedRights(final List<Right> rights) {
		this.getAddedRights().setRowData(rights);
	}

	@Override
	public void setRightsToAdd(final List<Right> rights) {
		this.getRightsToAdd().setRowData(rights);
	}

	@Override
	public void registerAdd(final EventHandler<TypedEventArg<Right>> handler) {
		this.addRight.add(handler);
	}

	@Override
	public void registerRemove(final EventHandler<TypedEventArg<Right>> handler) {
		this.removeRight.add(handler);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}

}
