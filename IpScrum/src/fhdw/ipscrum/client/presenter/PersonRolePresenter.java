package fhdw.ipscrum.client.presenter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.AssociatePersonAndRoleArgs;
import fhdw.ipscrum.client.events.args.MultipleRoleArgs;
import fhdw.ipscrum.client.events.args.PersonArgs;
import fhdw.ipscrum.client.view.PersonRoleView;
import fhdw.ipscrum.client.view.interfaces.IPersonRoleView;
import fhdw.ipscrum.shared.SessionManager;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.IRole;

/**
 */
public class PersonRolePresenter extends Presenter<IPersonRoleView> {

	private IPersonRoleView concreteView;
	private CellTable<IPerson> personTable;
	private CellList<IRole> assignedRoleList;
	private CellList<IRole> availRoleList;

	/**
	 * Constructor for PersonRolePresenter.
	 * @param parent Panel
	 */
	public PersonRolePresenter(Panel parent) {
		super(parent);
	}

	/**
	 * Method createView.
	 * @return IPersonRoleView
	 */
	@Override
	protected IPersonRoleView createView() {
		this.concreteView = new PersonRoleView();
		this.personTable = this.concreteView.getCellTablePersons();
		this.assignedRoleList = this.concreteView.getCellListAssignedRoles();
		this.availRoleList = this.concreteView.getCellListRoles();

		this.updateGuiTables();

		this.setupEventHandlers();

		return this.concreteView;
	}

	/**
	 * This method is called to update the GUI with new data.
	 * TODO auslagern in View wegen Trennung View/Presenter
	 */
	private void updateGuiTables() {
		HashSet<IPerson> personSet = SessionManager.getInstance().getModel().getPersons();
	    this.personTable.setRowData(new ArrayList<IPerson>(personSet));

		this.assignedRoleList.setRowData((this.concreteView.getSelectedPerson() != null) ? new ArrayList<IRole>(this.concreteView.getSelectedPerson().getRoles()) : new Vector<Role>());

		HashSet<IRole> roleSet = SessionManager.getInstance().getModel().getRoles();
		this.availRoleList.setRowData(new ArrayList<IRole>(roleSet));
	}



	/**
	 * This method is called to set up the algorithms for each button of the GUI.
	 */
	private void setupEventHandlers() {

		this.concreteView.defineNewPersonEventHandler(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				final DialogBox box = new DialogBox();
				final PersonDialogPresenter presenter = new PersonDialogPresenter(box);
				box.setAnimationEnabled(true);
				box.setAutoHideEnabled(true);
				box.setGlassEnabled(true);
				box.setText("Neue Person anlegen");

				presenter.getFinished().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						PersonRolePresenter.this.updateGuiTables();
						box.hide();
					}
				});

				presenter.getAborted().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						box.hide();
					}
				});
				box.center();
			}
		});

		this.concreteView.defineModifyPersonEventHandler(new EventHandler<PersonArgs>() {
			@Override
			public void onUpdate(Object sender, PersonArgs eventArgs) {
				final DialogBox box = new DialogBox();
				final PersonDialogPresenter presenter = new PersonDialogPresenter(box, eventArgs.getPerson());
				box.setAnimationEnabled(true);
				box.setAutoHideEnabled(true);
				box.setGlassEnabled(true);
				box.setText(eventArgs.getPerson().getFirstname() + " bearbeiten");
				box.center();

				presenter.getFinished().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						PersonRolePresenter.this.updateGuiTables();
						box.hide();
					}
				});

				presenter.getAborted().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						box.hide();
					}
				});
			}
		});

		this.concreteView.defineRemoveRoleFromPersonEventHandler(new EventHandler<AssociatePersonAndRoleArgs>() {
			@Override
			public void onUpdate(Object sender, AssociatePersonAndRoleArgs eventArgs) { // TODO prüfung in view verschieben.
				if (eventArgs != null && eventArgs.getPerson() != null && eventArgs.getRoles().size() > 0) {
					eventArgs.getPerson().removeRole(eventArgs.getSingleRole());
					PersonRolePresenter.this.updateGuiTables();
				}
			}
		});

		this.concreteView.defineAddRoleToPersonEventHandler(new EventHandler<AssociatePersonAndRoleArgs>() {
			@Override
			public void onUpdate(Object sender, AssociatePersonAndRoleArgs eventArgs) {
				if (eventArgs != null && eventArgs.getPerson() != null && eventArgs.getRoles().size() > 0) {
					Iterator<IRole> i = eventArgs.getRoles().iterator();
					while (i.hasNext()) {
						IRole current = i.next();
						eventArgs.getPerson().addRole(current);
					}
				}
				PersonRolePresenter.this.updateGuiTables();
			}
		});

		this.concreteView.defineNewRoleEventHandler(new EventHandler<EventArgs>() {
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				final DialogBox box = new DialogBox();
				final RoleDialogPresenter presenter = new RoleDialogPresenter(box);
				box.setAnimationEnabled(true);
				box.setAutoHideEnabled(true);
				box.setGlassEnabled(true);
				box.setText("Neue Rolle anlegen");

				presenter.getFinished().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						PersonRolePresenter.this.updateGuiTables();
						box.hide();
					}
				});

				presenter.getAborted().add(new EventHandler<EventArgs>() {
					@Override
					public void onUpdate(Object sender, EventArgs eventArgs) {
						box.hide();
					}
				});

				box.center();
			}
		});

		this.concreteView.defineRemoveRoleEventHandler(new EventHandler<MultipleRoleArgs>() {
			@Override
			public void onUpdate(Object sender, MultipleRoleArgs eventArgs) {
				SessionManager.getInstance().getModel().getRoles().removeAll(eventArgs.getRoles()); // TODO
				PersonRolePresenter.this.updateGuiTables();
			}
		});
	}
}
