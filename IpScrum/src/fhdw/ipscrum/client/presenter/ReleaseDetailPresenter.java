package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.events.args.SprintArgs;
import fhdw.ipscrum.client.utils.GwtUtils;
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

				ReleaseDetailPresenter.this.abort();
				
			}
		});
		
		view.addAddSprintEventHandler(new EventHandler<EventArgs>(){

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {
			
				
				final DialogBox diaBox = new DialogBox();
			
				final AddSprintToReleasePresenter presenter = new AddSprintToReleasePresenter(diaBox, ReleaseDetailPresenter.this.release);
			
					presenter.getAborted().add(new EventHandler<EventArgs>() {

								@Override
								public void onUpdate(Object sender,
										EventArgs eventArgs) {
									diaBox.clear();
									diaBox.hide();
								}
							});
					
					presenter.getFinished().add(new  EventHandler<EventArgs>() {
						
						@Override
						public void onUpdate(Object sender, EventArgs eventArgs) {
						
							diaBox.clear();
							diaBox.hide();
							ReleaseDetailPresenter.this.initialize();
						}
					});						
		diaBox.center();
			}	
		});
		
		view.addDeleteSprintEventHandler(new EventHandler<SprintArgs>() {

			@Override
			public void onUpdate(Object sender, SprintArgs eventArgs) {
				GwtUtils.displayError("Entfernen von Sprints ist derzeit noch nicht vorgesehen!");
			}
		});
		
		return view;
	}


}
	