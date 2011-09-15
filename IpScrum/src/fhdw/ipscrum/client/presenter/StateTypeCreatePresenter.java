package fhdw.ipscrum.client.presenter;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.StateTypeCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;

/**
 * This class represents the presenter which controls the view to create StateTypes.
 */
public class StateTypeCreatePresenter extends WritePresenter {
	/**
	 * Represents the Interface of the View which is related to this presenter. It's the
	 * interface to the ({@link} fhdw.ipscrum.client.view.StateCreateView).
	 */
	public static interface IStateCreateView extends IView {
		/**
		 * Represents the Event to handle the save.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles the save
		 */
		EventRegistration registerSave(DefaultEventHandler handler);

		/**
		 * Represents the Event to handle the abort.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles the abort
		 */
		EventRegistration registetAbort(DefaultEventHandler handler);

		/**
		 * Getter of the text of the name field on the view.
		 * 
		 * @return the text in the name field
		 */
		String getName();

		/**
		 * Getter of the text of the description field on the view.
		 * 
		 * @return the text in the description field
		 */
		String getDescription();
	}

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IStateCreateView view;

	/**
	 * constructor of the ({@link}
	 * fhdw.ipscrum.client.presenter.StateTypeCreatePresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 */
	public StateTypeCreatePresenter(final ClientContext context) {
		super(context);
		this.beginTransaction();
	}

	@Override
	public String getName() {
		return "Zustand erstellen";
	}

	@Override
	public IStateCreateView getView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createStateCreateView();
			this.view.registerSave(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					StateTypeCreatePresenter.this.save();
					StateTypeCreatePresenter.this.close();
				}
			});
			this.view.registetAbort(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					StateTypeCreatePresenter.this.showQuestion(
							"Do you want to leave without saving?", new Answer("Yes!") {

								@Override
								public void onAction(final QuestionDialog widget) {
									widget.hide();
									StateTypeCreatePresenter.this.close();
								}
							}, new Answer("No!") {

								@Override
								public void onAction(final QuestionDialog widget) {
									widget.hide();
								}
							});
				}
			});
		}

		return this.view;
	}

	@Override
	public Boolean onSave() {
		try {
			this.doCommand(new StateTypeCreateCommand(this.view.getName(), this.view
					.getDescription()));
			this.commitTransaction();
			return super.onSave();
		} catch (final IPScrumGeneralException e) {
			return false;
		}
	}

	@Override
	public void updateView() {

	}

	@Override
	public void onModelUpdate() {

	}

}
