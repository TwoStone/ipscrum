package fhdw.ipscrum.client.presenter;

import java.util.List;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.shared.commands.productBacklog.BugCreateCommand;
import fhdw.ipscrum.shared.commands.productBacklog.FeatureCreateCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.SingleFieldChangeCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.metamodel.fields.PersonFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.model.nonMeta.Release;

/**
 * 
 */
public class ProductBacklogItemCreatePresenter extends WritePresenter {

	/**
	 * Visitor for creating tickets depending on their type.
	 */
	private final class CreateTicketVisitor implements CreateTicketEventVisitor {
		/**
		 * The name of the ticket.
		 */
		private final String name;
		/**
		 * The description of the ticket.
		 */
		private final String description;

		/**
		 * Creates a new {@link ProductBacklogItemCreatePresenter.CreateTicketVisitor}
		 * object.
		 * 
		 * @param name
		 *            the name of the ticket
		 * @param description
		 *            the description of the ticket
		 */
		private CreateTicketVisitor(final String name, final String description) {
			this.name = name;
			this.description = description;
		}

		@Override
		public void handleBug(final CreateBugEvent createBugEvent) {
			final Release release = createBugEvent.getRelease();
			final BugTicketType type = createBugEvent.getType();

			if (release != null) {
				final BugCreateCommand command =
						new BugCreateCommand(this.name, this.description, type,
								ProductBacklogItemCreatePresenter.this.project
										.getBacklog(), release);
				ProductBacklogItemCreatePresenter.this.saveTicket(command);

			} else {
				ProductBacklogItemCreatePresenter.this
						.toastMessage("Bitte wählen Sie ein Release aus!");
			}
		}

		@Override
		public void handleFeature(final CreateFeatureEvent createFeatureEvent) {
			final FeatureTicketType type = createFeatureEvent.getType();

			final FeatureCreateCommand command =
					new FeatureCreateCommand(this.name, this.description, type,
							ProductBacklogItemCreatePresenter.this.project.getBacklog());
			ProductBacklogItemCreatePresenter.this.saveTicket(command);
		}
	}

	/**
	 * Event arguments for creating a new bug.
	 */
	public static class CreateBugEvent extends CreateTicketEvent {

		/**
		 * The release of the bug.
		 */
		private final Release release;
		/**
		 * The type of the bug.
		 */
		private final BugTicketType type;

		/**
		 * 
		 * @param name
		 *            name of the bug
		 * @param description
		 *            description of the bug
		 * @param type
		 *            type of the bug
		 * @param release
		 *            release of the bug
		 */
		public CreateBugEvent(final String name, final String description,
				final BugTicketType type, final Release release) {
			super(name, description);

			this.type = type;
			this.release = release;
		}

		@Override
		public void accept(final CreateTicketEventVisitor visitor) {
			visitor.handleBug(this);
		}

		/**
		 * @return the release of the bug.
		 */
		public Release getRelease() {
			return this.release;
		}

		@Override
		public BugTicketType getType() {
			return this.type;
		}

	}

	/**
	 * Event arguments for creating a new feature.
	 */
	public static class CreateFeatureEvent extends CreateTicketEvent {

		/**
		 * Type of the feature.
		 */
		private final FeatureTicketType type;

		/**
		 * 
		 * @param name
		 *            name of the feature
		 * @param description
		 *            description of the feature
		 * @param type
		 *            type of the feature
		 */
		public CreateFeatureEvent(final String name, final String description,
				final FeatureTicketType type) {
			super(name, description);
			this.type = type;
		}

		@Override
		public void accept(final CreateTicketEventVisitor visitor) {
			visitor.handleFeature(this);
		}

		@Override
		public FeatureTicketType getType() {
			return this.type;
		}
	}

	/**
	 * Event arguments for creating a new ticket.
	 */
	public abstract static class CreateTicketEvent extends EventArgs {
		/**
		 * description of the ticket.
		 */
		private final String description;

		/**
		 * name of the ticket.
		 */
		private final String name;

		/**
		 * 
		 * @param name
		 *            name of the ticket
		 * @param description
		 *            description of the ticket
		 */
		public CreateTicketEvent(final String name, final String description) {
			super();
			this.name = name;
			this.description = description;
		}

		/**
		 * Determines the subclass.
		 * 
		 * @param visitor
		 *            visits the object
		 */
		public abstract void accept(CreateTicketEventVisitor visitor);

		/**
		 * 
		 * @return description of the ticket
		 */
		public String getDescription() {
			return this.description;
		}

		/**
		 * 
		 * @return name of the ticket
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * 
		 * @return type of the ticket
		 */
		public abstract TicketType getType();
	}

	/**
	 * Interface for determining subclass of {@link CreateTicketEvent}.
	 */
	private static interface CreateTicketEventVisitor {

		/**
		 * 
		 * @param createBugEvent
		 *            the bug create event arguments
		 */
		void handleBug(CreateBugEvent createBugEvent);

		/**
		 * 
		 * @param createFeatureEvent
		 *            the feature create event arguments
		 */
		void handleFeature(CreateFeatureEvent createFeatureEvent);

	}

	/**
	 * Represents the Interface of the View which is related to this presenter. It's the
	 * interface to the ({@link} fhdw.ipscrum.client.view.ProductBacklockItemCreateView).
	 */
	public static interface IProductBacklogItemCreateView extends IView {

		/**
		 * Returns the event fired when the workflow shell be aborted.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event handling the abort
		 */
		EventRegistration registerAbortHandler(DefaultEventHandler handler);

		/**
		 * Returns the event fired when the object shell be saved.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event handling the save
		 */
				EventRegistration
				registerSaveHandler(
						EventHandler<ProductBacklogItemCreatePresenter.CreateTicketEvent> handler);

		/**
		 * this method is needed to fill the list in the view with the data of the known
		 * bugTicketTypes.
		 * 
		 * @param featureTicketTypes
		 *            are the known bugTicketTypes
		 */
		void setBugType(List<BugTicketType> featureTicketTypes);

		/**
		 * this method is needed to fill the list in the view with the data of the known
		 * featureTicketTypes.
		 * 
		 * @param types
		 *            are the known featureTicketTypes
		 */
		void setFeatureTypes(List<FeatureTicketType> types);

		/**
		 * this method is needed to fill the list in the view with the data of the
		 * releases of the project.
		 * 
		 * @param releases
		 *            are the releases of the project
		 */
		void setReleases(List<Release> releases);
	}

	/**
	 * represents the project related to this view. It is needed to make clear in which
	 * project the PBI should be created.
	 */
	private final Project project;
	/**
	 * represents a flag to check if the question asking if the view should been left
	 * without saving should be asked.
	 */
	private boolean saved = false;
	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private IProductBacklogItemCreateView view;

	/**
	 * constructor of the ({@link}
	 * fhdw.ipscrum.client.presenter.ProductBacklogItemCreatePresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 * @param project
	 *            is the related project for which a ticket should be created
	 */
	public ProductBacklogItemCreatePresenter(final ClientContext context,
			final Project project) {
		super(context);
		this.project = project;

	}

	/**
	 * this method is needed to create a new ticket with the help of a visitor.
	 * 
	 * @param eventArgs
	 *            are needed to get the name, description and type of the ticket to
	 *            create.
	 */
	private void createTicket(final CreateTicketEvent eventArgs) {
		final String name = eventArgs.getName();
		final String description = eventArgs.getDescription();
		if (eventArgs.getType() == null) {
			this.toastMessage("Bitte wählen Sie einen Typen aus!");
		}

		eventArgs.accept(new CreateTicketVisitor(name, description));

	}

	@Override
	public String getName() {
		return "ProductBacklogItem erstellen";
	}

	@Override
	public IProductBacklogItemCreateView getView() {
		if (this.view == null) {
			this.view =
					this.getContext().getViewFactory()
							.createProductBacklogItemCreateView();

			this.view.registerAbortHandler(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					ProductBacklogItemCreatePresenter.this.close();
				}
			});
			this.view
					.registerSaveHandler(new EventHandler<ProductBacklogItemCreatePresenter.CreateTicketEvent>() {

						@Override
						public void onUpdate(final Object sender,
								final CreateTicketEvent eventArgs) {
							ProductBacklogItemCreatePresenter.this
									.createTicket(eventArgs);
						}
					});
		}

		return this.view;
	}

	@Override
	protected void onClose(final CloseCallback callback) {
		if (!this.saved) {
			this.showQuestion("Möchten Sie den Vorgang ohne Speichern abbrechen?",
					new Answer("Ja!") {

						@Override
						public void onAction(final QuestionDialog widget) {
							callback.closed();
						}
					}, new Answer("Nein!") {

						@Override
						public void onAction(final QuestionDialog widget) {
							callback.closeAborted();
						}
					});
		} else {
			callback.closed();
		}
	}

	@Override
	public void onModelUpdate() {
		this.updateView();
	}

	/**
	 * This method is needed to set the last Editor on the new created PBI.
	 * 
	 * @param <T>
	 *            is the type of the ticket to create.
	 * @param command
	 *            is the command done related to the type <T>
	 */
	private <T extends ProductBacklogItem> void saveTicket(final Command<T> command) {
		this.beginTransaction();
		try {
			final T result = this.doCommand(command);
			final PersonFieldType lastEditorType =
					result.getTicketType().getLastEditorType();
			final SingleField<Person> field = result.getField(lastEditorType);
			final Person currentEditor = this.getContext().getCurrentUser().getPerson();
			final SingleFieldChangeCommand<Person> setLastEditorCommand =
					SingleFieldChangeCommand
							.createCommand(field, currentEditor, result);
			this.doCommand(setLastEditorCommand);
			this.commitTransaction();
			this.saved = true;
			this.close();
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			this.rollbackTransaction();
		}
	}

	@Override
	public void updateView() {
		this.getView().setBugType(this.getContext().getModel().getAllBugTicketTypes());
		this.getView().setFeatureTypes(
				this.getContext().getModel().getAllFeatureTicketTypes());
		this.getView().setReleases(this.project.getReleases());
	}

}
