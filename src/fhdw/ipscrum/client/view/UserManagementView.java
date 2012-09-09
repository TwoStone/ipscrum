package fhdw.ipscrum.client.view;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.cell.client.ImageResourceCell;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import fhdw.ipscrum.client.architecture.events.DefaultEvent;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.view.MasterView;
import fhdw.ipscrum.client.presenter.UserManagementPresenter.IUserManagementView;
import fhdw.ipscrum.client.resources.MyResources;
import fhdw.ipscrum.shared.session.User;

/**
 * representst the view to manage users.
 */
public class UserManagementView extends MasterView implements IUserManagementView {
	private final ListHandler<User> sortHandler_2 = new ListHandler<User>(Collections.<User> emptyList());
	private final ListHandler<User> sortHandler_1 = new ListHandler<User>(Collections.<User> emptyList());
	private final ListHandler<User> sortHandler = new ListHandler<User>(Collections.<User> emptyList());

	/**
	 * constructor of the UserManagementView.
	 */
	public UserManagementView() {
		super();

		final VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setSpacing(10);
		this.add(verticalPanel);

		final Button newUserButton = new Button("Neuen Benutzer anlegen");
		newUserButton.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(final ClickEvent event) {
				UserManagementView.this.newUser.fire(UserManagementView.this);
			}
		});
		verticalPanel.add(newUserButton);
		verticalPanel.setCellHorizontalAlignment(newUserButton, HasHorizontalAlignment.ALIGN_RIGHT);

		final ScrollPanel scrollPanel = new ScrollPanel();
		verticalPanel.add(scrollPanel);
		scrollPanel.setSize("500px", "400px");

		this.userTable = new CellTable<User>();
		this.userTable.addColumnSortHandler(this.sortHandler_2);
		this.userTable.addColumnSortHandler(this.sortHandler_1);
		this.userTable.addColumnSortHandler(this.sortHandler);
		scrollPanel.setWidget(this.userTable);
		this.userTable.setSize("100%", "100%");

		final Column<User, ImageResource> iconCol = new Column<User, ImageResource>(new ImageResourceCell()) {

			@Override
			public ImageResource getValue(final User object) {
				return MyResources.INSTANCE.user();
			}
		};
		this.userTable.addColumn(iconCol);

		final TextColumn<User> accountNameCol = new TextColumn<User>() {
			@Override
			public String getValue(final User object) {
				return object.getName();
			}
		};
		accountNameCol.setSortable(true);
		this.userTable.addColumn(accountNameCol, "Anmeldename");
		this.sortHandler.setComparator(accountNameCol, new Comparator<User>() {
			@Override
			public int compare(final User o1, final User o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});

		final TextColumn<User> foreNameCol = new TextColumn<User>() {
			@Override
			public String getValue(final User object) {
				return object.getPerson().getFirstname();
			}
		};
		foreNameCol.setSortable(true);
		this.userTable.addColumn(foreNameCol, "Vorname");
		this.sortHandler_1.setComparator(foreNameCol, new Comparator<User>() {
			@Override
			public int compare(final User o1, final User o2) {
				return o1.getPerson().getFirstname().compareTo(o2.getPerson().getFirstname());
			}
		});

		final TextColumn<User> nameCol = new TextColumn<User>() {
			@Override
			public String getValue(final User object) {
				return object.getPerson().getLastname();
			}
		};
		nameCol.setSortable(true);
		this.userTable.addColumn(nameCol, "Nachname");
		this.sortHandler_2.setComparator(nameCol, new Comparator<User>() {
			@Override
			public int compare(final User o1, final User o2) {
				return o1.getPerson().getLastname().compareTo(o2.getPerson().getLastname());
			}
		});
	}

	private final DefaultEvent newUser = new DefaultEvent();
	private CellTable<User> userTable;

	@Override
	public void close() {
		this.newUser.removeAllHandler();
	}

	@Override
	public void setUsers(final List<User> users) {
		this.userTable.setRowData(users);
	}

	@Override
	public EventRegistration registerNewUserHandler(final DefaultEventHandler handler) {
		return this.newUser.add(handler);
	}

	@Override
	public void setRightVisibility(final Boolean value) {
		// No widgets to hide

	}
}
