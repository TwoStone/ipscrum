package fhdw.ipscrum.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.NavigationView;
import fhdw.ipscrum.client.view.PersonRoleMngmtView;
import fhdw.ipscrum.client.view.interfaces.INavigationView;
import fhdw.ipscrum.client.view.interfaces.IPersonRoleMngmtView;

public class PersonRoleMngmtPresenter extends Presenter<IPersonRoleMngmtView> {

	public PersonRoleMngmtPresenter(Panel parent) {
		super(parent);
	}
	
	@Override
	protected IPersonRoleMngmtView createView() {
		final IPersonRoleMngmtView concreteView = PersonRoleMngmtView.createView();
		
		return concreteView;
	}

}
