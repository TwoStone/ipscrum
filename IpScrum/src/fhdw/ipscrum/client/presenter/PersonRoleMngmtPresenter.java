package fhdw.ipscrum.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.view.client.SingleSelectionModel;

import fhdw.ipscrum.client.view.PersonRoleMngmtView;
import fhdw.ipscrum.client.view.interfaces.IPersonRoleMngmtView;

public class PersonRoleMngmtPresenter extends Presenter<IPersonRoleMngmtView> {

	public PersonRoleMngmtPresenter(Panel parent) {
		super(parent);
	}

	@Override
	protected IPersonRoleMngmtView createView() {
		final IPersonRoleMngmtView concreteView = new PersonRoleMngmtView();

		concreteView.getButtonRoleRename().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				SingleSelectionModel selModel = (SingleSelectionModel) concreteView.getRoleList().getSelectionModel();
				Window.alert("renaming " + selModel.getSelectedObject());
			}
		});

		return concreteView;
	}

}
