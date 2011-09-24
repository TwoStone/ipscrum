package fhdw.ipscrum.client.presenter;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.eventargs.TicketTypeArgs;
import fhdw.ipscrum.client.view.TypeAdministrationView;
import fhdw.ipscrum.client.viewinterfaces.ITypeAdministrationView;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.BugTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.FeatureTicketTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.ticketTypes.TaskTicketTypeCreateCommand;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.BugTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.FeatureTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TaskTicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketTypeVisitor;

/**
 * This class represents the presenter which controls the view to administer ticketTypes.
 */
public class TypeAdministrationPresenter extends WritePresenter {

	/**
	 * Represents the view which is related to and controlled from this presenter.
	 */
	private TypeAdministrationView view;

	/**
	 * constructor of the ({@link}
	 * fhdw.ipscrum.client.presenter.TypeAdministrationPresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is
	 *            needed to get the model and other related classes.
	 */
	public TypeAdministrationPresenter(final ClientContext context) {
		super(context);

	}

	@Override
	public String getName() {
		return "Tickettyp Administration";
	}

	@Override
	public ITypeAdministrationView doGetView() {
		if (this.view == null) {
			this.view =
					this.getContext().getViewFactory().createTypeAdministrationView();

			this.view.registerAddType(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {

					TypeAdministrationPresenter.this.doAddType();

				}

			});

			this.view.registerDeleteType(new EventHandler<TicketTypeArgs>() {

				@Override
				public void
						onUpdate(final Object sender, final TicketTypeArgs eventArgs) {

					TypeAdministrationPresenter.this.getContext()
							.getToastMessageController()
							.toastMessage("Nicht implementiert!");

				}
			});

		}

		return this.view;
	}

	@Override
	public void updateView() {
		this.view.refreshTypes(this.getContext().getModel().getTypeManager()
				.fetchUserTicketTypes());
		this.view.refreshMainTypes(this.getContext().getModel().getTypeManager()
				.fetchStandardTicketTypes());
	}

	@Override
	public void onModelUpdate() {
		this.updateView();
	}

	/**
	 * Executes a command and does error handling.
	 * 
	 * @param command
	 *            The command that should be executed.
	 * @param <T>
	 *            The result type of the command.
	 */
	private <T extends TicketType> void executeTicketTypeCommand(
			final Command<T> command) {
		try {
			this.doCommand(command);
		} catch (final IPScrumGeneralException e) {
			this.getContext().getToastMessageController().toastMessage(e.getMessage());
		}
	}

	/**
	 * this methods adds a new type.
	 */
	private void doAddType() {
		TypeAdministrationPresenter.this.beginTransaction();

		final TicketType mainType = TypeAdministrationPresenter.this.view.getType();
		final String typeName = TypeAdministrationPresenter.this.view.getTypeName();
		final String typeDescription =
				TypeAdministrationPresenter.this.view.getDescription();

		if (mainType == null || typeName.equals("") || typeDescription.equals("")) {
			TypeAdministrationPresenter.this.getContext().getToastMessageController()
					.toastMessage("Bitte Eingaben überprüfen");
			TypeAdministrationPresenter.this.rollbackTransaction();
		} else {
			this.createTicketType(typeName, typeDescription, mainType);
		}
	}

	/**
	 * this method is needed to create a ticket type.
	 * 
	 * @param typeName
	 *            of the new ticket type
	 * @param typeDescription
	 *            of the new ticket type
	 * @param mainType
	 *            of the new ticket type
	 */
	private void createTicketType(final String typeName, final String typeDescription,
			final TicketType mainType) {

		mainType.accept(new TicketTypeVisitor() {

			@Override
			public void handleTaskTicketType(final TaskTicketType taskTicketType) {
				TypeAdministrationPresenter.this
						.executeTicketTypeCommand(new TaskTicketTypeCreateCommand(
								typeName, typeDescription));

			}

			@Override
			public void handleFeatureTicketType(
					final FeatureTicketType featureTicketType) {
				TypeAdministrationPresenter.this
						.executeTicketTypeCommand(new FeatureTicketTypeCreateCommand(
								typeName, typeDescription));
			}

			@Override
			public void handleBugTicketType(final BugTicketType bugTicketType) {
				TypeAdministrationPresenter.this
						.executeTicketTypeCommand(new BugTicketTypeCreateCommand(
								typeName, typeDescription));
			}
		});
		TypeAdministrationPresenter.this.commitTransaction();
		TypeAdministrationPresenter.this.updateView();

	}

}
