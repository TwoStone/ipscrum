package fhdw.ipscrum.client.presenter;

import com.google.gwt.user.client.ui.Panel;

import fhdw.ipscrum.client.events.EventArgs;
import fhdw.ipscrum.client.events.EventHandler;
import fhdw.ipscrum.client.utils.GwtUtils;
import fhdw.ipscrum.client.view.CreateIncidentTypeView;
import fhdw.ipscrum.client.view.interfaces.ICreateIncidentTypeView;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.DoubleDefinitionException;
import fhdw.ipscrum.shared.model.incidents.IncidentType;

/**
 * Presenter for creating new {@link IncidentType}
 * 
 * @author Phase IV - Group Reporting II
 * 
 */
public class CreateIncidentTypePresenter extends
		Presenter<ICreateIncidentTypeView> {

	/**
	 * Creates a new instance of {@link CreateIncidentTypePresenter}
	 * 
	 * @param parent
	 * @param parentPresenter
	 */
	public CreateIncidentTypePresenter(Panel parent,
			Presenter<?> parentPresenter) {
		super(parent, parentPresenter);
		this.addHandler();
	}

	/**
	 * Adds the Handler for an event which creates a new {@link IncidentType}
	 * and the Handler for an cancel event
	 */
	private void addHandler() {
		this.getView().addCreateTypeHandler(new EventHandler<EventArgs>() {

			@Override
			public void onUpdate(Object sender, EventArgs eventArgs) {

				if (CreateIncidentTypePresenter.this.getView().getName()
						.equals(TextConstants.EMPTY_TEXT)) {
					GwtUtils.displayWarning(TextConstants.INCIDENT_WARNING_4);
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
