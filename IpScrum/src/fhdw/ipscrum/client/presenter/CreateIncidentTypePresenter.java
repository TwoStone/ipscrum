package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.CreateIncidentTypeView;
import fhdw.ipscrum.client.view.interfaces.ICreateIncidentTypeView;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.incidents.IncidentType;

public class CreateIncidentTypePresenter extends
		Presenter<ICreateIncidentTypeView> {

	public CreateIncidentTypePresenter(Panel parent,
			Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
		this.addHandler();
	}

	private void addHandler() {
		this.getView().addCreateTypeHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {

				if (CreateIncidentTypePresenter.this.getView().getName()
						.equals("")) {
					GwtUtils.displayWarning("Bitte einen Namen eintragen!");
				} else {
					try {
						CreateIncidentTypePresenter.this
								.getSessionManager()
								.getModel()
								.addIncidentType(getView().getName(),
										new IncidentType(getView().getName()));
					} catch (DoubleDefinitionException e) {
						GwtUtils.displayError(e);
					}
					CreateIncidentTypePresenter.this.finish();
				}	
			}
		});

		this.getView().addCancelEventHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {

				CreateIncidentTypePresenter.this.abort();

			}
		});
	}

	@Override
	protected ICreateIncidentTypeView createView() {
		return new CreateIncidentTypeView();
	}

}
