package fhdw.ipscrum.client.view.metamodel.controller;

import java.io.Serializable;

import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.SingleFieldWidget;
import fhdw.ipscrum.shared.commands.ticketsGeneral.SingleFieldChangeCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.SingleFieldIdentifiableObjectChangeCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.SingleFieldNonIdentifiableObjectChangeCommand;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

/**
 * Represents the SingleFieldTypeController needed for controlling singleFieldTypes for editing tickets.
 * 
 * @param <T>
 *            is the type of the singleFieldType
 */
public abstract class SingleFieldTypeController<T extends Serializable> implements FieldTypeController<T> {

	private Ticket ticket;
	private final GenericTicketPresenter presenter;
	private SingleField<T> field;
	private final EventHandler<TypedEventArg<T>> changeHandler = new EventHandler<TypedEventArg<T>>() {

		@Override
		public void onUpdate(final Object sender, final TypedEventArg<T> eventArgs) {
			SingleFieldTypeController.this.setValue(eventArgs.getObject());
		}
	};

	/**
	 * Constructor of the SingleFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public SingleFieldTypeController(final Ticket ticket, final GenericTicketPresenter presenter,
			final SingleField<T> field) {
		super();
		this.ticket = ticket;
		this.presenter = presenter;
		this.field = field;
	}

	protected void initialize() {
		this.getWidget().registerChangeHandler(this.changeHandler);
	}

	protected void setValue(final T object) {
		final SingleFieldChangeCommand<?> command;
		if (object instanceof IdentifiableObject) {
			command = new SingleFieldIdentifiableObjectChangeCommand<T>(this.getField(), object, this.getTicket());
		} else {
			command = new SingleFieldNonIdentifiableObjectChangeCommand<T>(this.getField(), object, this.getTicket());
		}
		this.getPresenter().addCommand(this, command);
	}

	@Override
	public abstract SingleFieldWidget<T> getWidget();

	@Override
	public SingleField<T> getField() {
		return this.field;
	}

	/**
	 * Getter of the presenter the controller is needed in.
	 * 
	 * @return the related presenter
	 */
	public GenericTicketPresenter getPresenter() {
		return this.presenter;
	}

	/**
	 * Getter of the ticket the singelFieldType is related to.
	 * 
	 * @return the related ticket
	 */
	public Ticket getTicket() {
		return this.ticket;
	}

	@Override
	public void updateModel(final Model model) throws NoObjectFindException {
		this.ticket = model.getObject(this.ticket);
		this.field = model.getObject(this.field);
	}

}
