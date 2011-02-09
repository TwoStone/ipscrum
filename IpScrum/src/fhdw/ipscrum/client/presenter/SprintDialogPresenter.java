package fhdw.ipscrum.client.presenter;

import java.util.Date;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.SprintDialogView;
import fhdw.ipscrum.client.view.interfaces.ISprintDialogView;
import fhdw.ipscrum.shared.model.Sprint;
import fhdw.ipscrum.shared.model.Team;


public class SprintDialogPresenter extends Presenter<ISprintDialogView> {
	final ISprintDialogView view = new SprintDialogView();
	
public SprintDialogPresenter(Panel parent) {
		super(parent);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected ISprintDialogView createView() {
		
		view.addCancelHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				finish();
			}
		});
		
		view.addOkHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				Date startdate;
				Date enddate;
				Team team;
				//Sprint sprint = new Sprint(startdate, enddate, team);
				finish();
			}
		});
		
		view.addRelateHandler(new EventHandler<EventArgs>() {
			
			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				
			}
		});
		
		return view;
	}

}
