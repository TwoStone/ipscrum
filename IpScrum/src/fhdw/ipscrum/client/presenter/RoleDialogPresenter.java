package fhdw.ipscrum.client.presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.view.interfaces.IRoleDialogView;
import fhdw.ipscrum.shared.model.Role;
import fhdw.ipscrum.shared.model.Root;


public class RoleDialogPresenter extends Presenter<IRoleDialogView> {

	private Role role;
	private Root root;
	private IRoleDialogView concreteView;
	
	public RoleDialogPresenter(Panel parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected IRoleDialogView createView() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void createRole(){
		this.role = new Role(this.getView().getRole().getText());
		this.root.getRoles().add(this.role);
	}
	
	private void changeRole(Role role){
		role.setDescription(this.getView().getRole().getText());
		this.role = role;
	}
	
	private void setupClickEvents() {
		concreteView.getOk_button().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
			}
		});	
		
		concreteView.getAbb_button_1().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				
			}
		});	
		
	
	
	}
}
