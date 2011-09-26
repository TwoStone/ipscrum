package fhdw.ipscrum.client.presenter;

import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.BugTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.FeatureTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TaskTicketTypeCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketTypeVisitor;

/**
 * This class represents the presenter which controls the view to create Tickets.
 */
public class TicketTypeCreatePresenter extends WritePresenter {
	/**
	 * Represents the Interface of the View which is related to this presenter. It's the interface to the ({@link}
	 * fhdw.ipscrum.client.view.TicketTypeCreateView).
	 */
	public interface ITicketTypeCreateView extends IView {

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
		 * Getter of the text of the description field on the view.
		 * 
		 * @return the text in the description field
		 */
		String getDescription();

		/**
		 * Getter of the ticketType field on the view.
		 * 
		 * @return the ticketType field
		 */
		TicketType getCategorie();

		/**
		 * Getter of the text of the name field on the view.
		 * 
		 * @return the text in the name field
		 */
		String getName();

		/**
		 * this method is needed to fill the list in the view with the existing standard ticketTypes.
		 * 
		 * @param types
		 *            are the existing standard ticketTypes
		 */
		void refreshMainTypes(List<TicketType> types);
	}

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private ITicketTypeCreateView view;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.TicketTypeCreatePresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 */
	public TicketTypeCreatePresenter(final ClientContext context) {
		super(context);
		this.beginTransaction();
	}

	@Override
	public String getName() {
		return "Tickettypen erstellen";
	}

	@Override
	public ITicketTypeCreateView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createTicketTypeCreateView();
			this.view.registerSave(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					TicketTypeCreatePresenter.this.save();
					TicketTypeCreatePresenter.this.close();
				}
			});
			this.view.registetAbort(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					TicketTypeCreatePresenter.this.showQuestion("Do you want to leave without saving?", new Answer(
							"Yes!") {

						@Override
						public void onAction(final QuestionDialog widget) {
							widget.hide();
							TicketTypeCreatePresenter.this.close();
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
		this.view.getCategorie().accept(new TicketTypeVisitor() {

			@Override
			public void handleTaskTicketType(final TaskTicketType taskTicketType) {
				try {
					TicketTypeCreatePresenter.this.doCommand(new TaskTicketTypeCreateCommand(
							TicketTypeCreatePresenter.this.view.getName(), TicketTypeCreatePresenter.this.view
									.getDescription()));
				} catch (final IPScrumGeneralException e) {
					TicketTypeCreatePresenter.this.getContext().getToastMessageController()
							.toastMessage(e.getMessage());
				}

			}

			@Override
			public void handleFeatureTicketType(final FeatureTicketType featureTicketType) {
				try {
					TicketTypeCreatePresenter.this.doCommand(new FeatureTicketTypeCreateCommand(
							TicketTypeCreatePresenter.this.view.getName(), TicketTypeCreatePresenter.this.view
									.getDescription()));
				} catch (final IPScrumGeneralException e) {
					TicketTypeCreatePresenter.this.getContext().getToastMessageController()
							.toastMessage(e.getMessage());

				}

			}

			@Override
			public void handleBugTicketType(final BugTicketType bugTicketType) {
				try {
					TicketTypeCreatePresenter.this.doCommand(new BugTicketTypeCreateCommand(
							TicketTypeCreatePresenter.this.view.getName(), TicketTypeCreatePresenter.this.view
									.getDescription()));
				} catch (final IPScrumGeneralException e) {
					TicketTypeCreatePresenter.this.getContext().getToastMessageController()
							.toastMessage(e.getMessage());

				}

			}
		});
		this.commitTransaction();
		return super.onSave();

	}

	@Override
	public void updateView() {
		this.view.refreshMainTypes(this.getContext().getModel().getTypeManager().fetchStandardTicketTypes());
	}

	@Override
	public void onModelUpdate() {

	}

}
