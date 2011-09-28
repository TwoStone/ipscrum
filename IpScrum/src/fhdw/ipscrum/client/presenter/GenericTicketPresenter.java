package fhdw.ipscrum.client.presenter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.client.view.metamodel.controller.FieldTypeController;
import fhdw.ipscrum.client.view.metamodel.controller.ListFieldTypeController;
import fhdw.ipscrum.client.view.metamodel.controller.ListFieldTypeControllerFactory;
import fhdw.ipscrum.client.view.metamodel.controller.SingleFieldTypeController;
import fhdw.ipscrum.client.view.metamodel.controller.SingleFieldTypeControllerFactory;
import fhdw.ipscrum.client.viewinterfaces.IGenericTicketView;
import fhdw.ipscrum.shared.commands.ticketsGeneral.SingleFieldChangeCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.TicketChangeStateCommand;
import fhdw.ipscrum.shared.constants.HelpResources;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.metamodel.fields.Field;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldVisitor;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.fields.PersonFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.fields.TextFieldType;
import fhdw.ipscrum.shared.model.metamodel.states.StateType;
import fhdw.ipscrum.shared.model.metamodel.states.TransitionRule;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.TicketType;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Task;
import fhdw.ipscrum.shared.model.visitor.TicketVisitor;

/**
 * This class is responsible for displaying any kind of {@link Ticket} object. The elements of the correspondent view
 * will be chosen at runtime by analyzing the ticket object and its type.
 */
public class GenericTicketPresenter extends WritePresenter {

	@Override
	public IView getView() {
		final IView conView = this.doGetView();
		conView.registerHelpHandler(new DefaultEventHandler() {
			@Override
			public void onUpdate(final Object sender, final EventArgs eventArgs) {
				GenericTicketPresenter.this.ticket.accept(new TicketVisitor() {

					@Override
					public void handleTask(final Task task) {
						GenericTicketPresenter.this.getContext().getHelpController().showHelp(HelpResources.TASKTICKET);
					}

					@Override
					public void handlePBI(final ProductBacklogItem pbi) {
						GenericTicketPresenter.this.getContext().getHelpController().showHelp(HelpResources.PBITICKET);
					}
				});
			}
		});

		return this.view;
	}

	/**
	 * The ticket displayed by the presenter and its view.
	 */
	private Ticket ticket;

	/**
	 * The view of the presenter.
	 */
	private IGenericTicketView view;

	/**
	 * Determines if the changes were saved or not.
	 */
	private boolean saved;

	/**
	 * A list of controllers that control their own widgets in the view.
	 */
	private final List<FieldTypeController<?>> controllers;

	/**
	 * Creates a new {@link GenericTicketPresenter}.
	 * 
	 * @param ticket
	 *            the ticket the presenter is responsible for
	 * @param context
	 *            the current context
	 */
	public GenericTicketPresenter(final Ticket ticket, final ClientContext context) {
		super(context);
		this.ticket = ticket;
		this.controllers = new ArrayList<FieldTypeController<?>>();
		this.buildView();
		this.onModelUpdate();
		this.beginTransaction();
	}

	@Override
	public String getName() {
		return "Detailansicht - Ticket: " + this.ticket.getName();
	}

	@Override
	public IGenericTicketView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createGenericTicktView();
			this.view.registerSaveHandler(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					GenericTicketPresenter.this.save();
				}
			});
			this.view.registerAbortHandler(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					GenericTicketPresenter.this.close();
				}
			});
			this.view.registerNameChangedHandler(new EventHandler<TypedEventArg<String>>() {

				@Override
				public void onUpdate(final Object sender, final TypedEventArg<String> eventArgs) {
					GenericTicketPresenter.this.changeName(eventArgs.getObject());
				}
			});
			this.view.registerDescriptionChangeHandler(new EventHandler<TypedEventArg<String>>() {

				@Override
				public void onUpdate(final Object sender, final TypedEventArg<String> eventArgs) {
					GenericTicketPresenter.this.changeDescription(eventArgs.getObject());
				}
			});
			this.view.regsiterChangeStateHandler(new EventHandler<TypedEventArg<StateType>>() {

				@Override
				public void onUpdate(final Object sender, final TypedEventArg<StateType> eventArgs) {
					GenericTicketPresenter.this.changeState(eventArgs.getObject());
				}
			});
		}

		return this.view;
	}

	/**
	 * Changes the state of the ticket.
	 * 
	 * @param newState
	 *            the new state
	 */
	private void changeState(final StateType newState) {
		final TicketChangeStateCommand command = new TicketChangeStateCommand(this.ticket, newState);
		this.doCommandHandling(command);
		this.updateView();
	}

	/**
	 * Executes the command and displays errors in a toastMessage.
	 * 
	 * @param command
	 *            the command
	 * @param <T>
	 *            the result type of the command
	 * @return Result of the command execution if any error occured this will be null.
	 */
	private <T> T doCommandHandling(final Command<T> command) {
		try {
			this.setLastEditor();
			return this.doCommand(command);
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			return null;
		}
	}

	/**
	 * Changes the description of the ticket.
	 * 
	 * @param object
	 *            the new description
	 */
	@SuppressWarnings("unchecked")
	private void changeDescription(final String object) {
		final TextFieldType descriptionType = this.ticket.getTicketType().getDescriptionType();
		final SingleField<String> descriptionField = (SingleField<String>) this.findField(this.ticket, descriptionType);
		this.doCommandHandling(SingleFieldChangeCommand.createCommand(descriptionField, object, this.ticket));
		this.updateView();
	}

	/**
	 * Changes the name of the ticket.
	 * 
	 * @param object
	 *            the new name
	 */
	@SuppressWarnings("unchecked")
	private void changeName(final String object) {
		final TextFieldType nameType = this.ticket.getTicketType().getNameType();
		final SingleField<String> field = (SingleField<String>) this.findField(this.ticket, nameType);
		this.doCommandHandling(SingleFieldChangeCommand.createCommand(field, object, this.ticket));
		this.updateView();
	}

	/**
	 * Searches for a field of the specified in the ticket.
	 * 
	 * @param targetTicket
	 *            the ticket
	 * @param fieldType
	 *            the type of the field
	 * @return the field of the ticket of the specified type
	 */
	@SuppressWarnings("rawtypes")
	private Field<?> findField(final Ticket targetTicket, final FieldType fieldType) {
		final List<Field> fields = targetTicket.getAllFields();
		for (final Field<?> field : fields) {
			if (field.getType().equals(fieldType)) {
				return field;
			}
		}
		return null;
	}

	@Override
	public Boolean onSave() {
		this.setLastEditor();

		this.commitTransaction(new AsyncCallback<Void>() {

			@Override
			public void onSuccess(final Void result) {
				GenericTicketPresenter.this.saved = true;
				GenericTicketPresenter.this.close();
			}

			@Override
			public void onFailure(final Throwable caught) {
				GenericTicketPresenter.this.rollbackTransaction();
			}
		});
		return super.onSave();
	}

	/**
	 * If the ticket is a PBI the methods sets the last editor to the current user.
	 */
	private void setLastEditor() {
		this.ticket.accept(new TicketVisitor() {

			@Override
			public void handleTask(final Task task) {
				// for tasks there is nothing to do;
			}

			@Override
			public void handlePBI(final ProductBacklogItem pbi) {
				final Person currentEditor = GenericTicketPresenter.this.getContext().getCurrentUser().getPerson();
				final PersonFieldType lastEditorType = pbi.getTicketType().getLastEditorType();
				@SuppressWarnings("unchecked")
				final SingleField<Person> lastEditorField =
						(SingleField<Person>) GenericTicketPresenter.this.findField(pbi, lastEditorType);
				final SingleFieldChangeCommand<Person> createCommand =
						SingleFieldChangeCommand.createCommand(lastEditorField, currentEditor,
								GenericTicketPresenter.this.ticket);

				try {
					GenericTicketPresenter.this.doCommand(createCommand);
				} catch (final IPScrumGeneralException e) {
					GWT.log(e.getMessage(), e);
				}
			}
		});
	}

	@Override
	protected void onClose(final CloseCallback callback) {
		if (!this.saved && this.hasPendingChanges()) {
			this.showQuestion("Wollen sie die Oberfläche ohne Speichern verlassen?", new Answer("Ja!") {

				@Override
				public void onAction(final QuestionDialog widget) {
					GenericTicketPresenter.this.rollbackTransaction();
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
	public void updateView() {
		this.doGetView().setName(this.ticket.getName());
		this.doGetView().setDescription(this.ticket.getDescription());
		this.doGetView().setCurrentState(this.ticket.getCurrentState());
		this.doGetView().setPossibleStates(this.getPossibleStates());

		for (final FieldTypeController<?> controller : this.controllers) {
			controller.updateWidget(this.getContext().getModel());
		}
	}

	/**
	 * Gets all possible states for the ticket of the presenter that can be reached from the current state.
	 * 
	 * @return all possible states
	 */
	private List<StateType> getPossibleStates() {
		final StateType currentState = this.ticket.getCurrentState();
		final List<StateType> result = new ArrayList<StateType>();
		final List<TransitionRule> transitionRules = this.ticket.getTicketType().getStateProfile().getTransitionRules();
		for (final TransitionRule transitionRule : transitionRules) {
			if (transitionRule.getFrom().equals(currentState)) {
				result.add(transitionRule.getTo());
			}
		}
		return result;
	}

	@Override
	public void onModelUpdate() {
		try {
			this.ticket = this.getContext().getModel().getObject(this.ticket);
			for (final FieldTypeController<?> controller : this.controllers) {
				controller.updateModel(this.getContext().getModel());
			}
			this.updateView();
		} catch (final NoObjectFindException e) {
			this.toastMessage(e.getMessage());
			this.close();
		}
	}

	/**
	 * Executes and adds a command to the current transaction and updates the responsible widget in the view.
	 * 
	 * @param fieldTypeController
	 *            the controller for the field
	 * @param command
	 *            the command that should be added and executed.
	 * 
	 * @param <T>
	 *            the return type of the command
	 * @return The result returned by the {@link Command#execute(fhdw.ipscrum.shared.model.Model, Person)} method.
	 */
	public <T> T addCommand(final FieldTypeController<?> fieldTypeController, final Command<T> command) {
		try {
			final T result = this.doCommand(command);
			fieldTypeController.updateWidget(this.getContext().getModel());
			return result;
		} catch (final IPScrumGeneralException e) {
			this.toastMessage(e.getMessage());
			fieldTypeController.updateWidget(this.getContext().getModel());
			return null;
		}
	}

	/**
	 * Analyzes the presenters ticket and creates the view from the fields of the ticket.
	 */
	@SuppressWarnings("rawtypes")
	private void buildView() {
		final TicketType ticketType = this.ticket.getTicketType();
		final TextFieldType nameType = ticketType.getNameType();
		final TextFieldType descriptionType = ticketType.getDescriptionType();

		final List<Field> allFields = this.ticket.getAllFields();
		for (final Field<?> field : allFields) {
			final FieldType fieldType = field.getType();
			if (!fieldType.equals(nameType) && !fieldType.equals(descriptionType)) {
				field.accept(new FieldVisitor() {

					@Override
					public void handleSingleField(final SingleField<?> singleField) {
						GenericTicketPresenter.this.addSingleField(singleField);
					}

					@Override
					public void handleListField(final ListField<?> listField) {
						GenericTicketPresenter.this.addListField(listField);
					}
				});
			}
		}
	}

	/**
	 * Creates a controller for the field and adds it to the presenter controller list.
	 * 
	 * @param listField
	 *            some field
	 * @param <T>
	 *            the generic argument of the field.
	 */
	private <T extends Serializable> void addListField(final ListField<T> listField) {
		final ListFieldTypeControllerFactory factory = new ListFieldTypeControllerFactory(listField, this, this.ticket);
		final ListFieldTypeController<?> controller = factory.create();
		if (controller != null) {
			this.doGetView().add(controller);
			this.controllers.add(controller);
		}
	}

	/**
	 * Creates a controller for the field and adds it to the presenter controller list.
	 * 
	 * @param singleField
	 *            some field
	 * @param <T>
	 *            the generic argument of the field.
	 */
	private <T extends Serializable> void addSingleField(final SingleField<T> singleField) {
		final SingleFieldTypeControllerFactory factory =
				new SingleFieldTypeControllerFactory(singleField, this, this.ticket);
		final SingleFieldTypeController<?> controller = factory.create();
		if (controller != null) {
			this.doGetView().add(controller);
			this.controllers.add(controller);
		}
	}

}
