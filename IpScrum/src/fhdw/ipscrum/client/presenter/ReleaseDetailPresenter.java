package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.view.ReleaseDetailView;
import fhdw.ipscrum.client.view.interfaces.IReleaseDetailView;
import fhdw.ipscrum.client.view.widgets.AbortDialog;
import fhdw.ipscrum.client.view.widgets.AbortDialog.OnOkayCommand;
import fhdw.ipscrum.shared.model.Release;

public class ReleaseDetailPresenter extends Presenter<IReleaseDetailView> {

	private Release release;
	
	public ReleaseDetailPresenter(Panel parent, Release release) {
		super(parent);
		this.release = release;
		this.initialize();
	}

	private void initialize() {
	if (this.release.getSprints() != null){
		this.getView().refreshSprints(this.release.getSprints());
	}
	}

	@Override
	protected IReleaseDetailView createView() {
		
		final IReleaseDetailView view = new ReleaseDetailView();
		
		view.addCancelReleaseDetailViewHandler(new EventHandler<EventArgs>(){

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
				new AbortDialog(new OnOkayCommand() {
					
					@Override
					public void onExecute() {
						ReleaseDetailPresenter.this.abort();
					}
				});
			}
			
		});
		
		
		
		return view;
	}


}
