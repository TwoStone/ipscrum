package fhdw.ipscrum.client.view.metamodel.controller;

import java.io.Serializable;

import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.FieldEventArgs;
import fhdw.ipscrum.client.view.metamodel.ListFieldWidget;
import fhdw.ipscrum.shared.commands.ticketsGeneral.ListFieldAddValueCommand;
import fhdw.ipscrum.shared.commands.ticketsGeneral.ListFieldRemoveValueCommand;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;

public abstract class ListFieldTypeController<T extends Serializable>
		implements FieldTypeController<T> {

	private final EventHandler<FieldEventArgs<T>> addHandler =
			new EventHandler<FieldEventArgs<T>>() {

				@Override
				public void onUpdate(final Object sender,
						final FieldEventArgs<T> eventArgs) {
					ListFieldTypeController.this.addObject(eventArgs.getObject());
				}
			};
	private final EventHandler<FieldEventArgs<T>> removeHandler =
			new EventHandler<FieldEventArgs<T>>() {

				@Override
				public void onUpdate(final Object sender,
						final FieldEventArgs<T> eventArgs) {
					ListFieldTypeController.this.removeObject(eventArgs.getObject());
				}
			};
	private final GenericTicketPresenter presenter;
	private ListField<T> field;
	private Ticket ticket;

	@Override
	public abstract ListFieldWidget<T> getWidget();

	public void addObject(final T object) {
		final ListFieldAddValueCommand<T> command =
				ListFieldAddValueCommand.createCommand(this.getField(), object,
						this.getTicket());
		this.getPresenter().addCommand(this, command);
	}

	public void removeObject(final T object) {
		final ListFieldRemoveValueCommand<T> command =
				ListFieldRemoveValueCommand.createCommand(this.getField(), object,
						this.getTicket());
		this.getPresenter().addCommand(this, command);
	}

	@Override
	public abstract void updateWidget(Model model);

	public ListFieldTypeController(final GenericTicketPresenter presenter,
			final ListField<T> field, final Ticket ticket) {
		this.presenter = presenter;
		this.field = field;
		this.ticket = ticket;
	}

	protected void initialize() {
		this.getWidget().registerAddHandler(this.addHandler);
		this.getWidget().registerRemoveHandler(this.removeHandler);
	}

	@Override
	public ListField<T> getField() {
		return this.field;
	}

	public GenericTicketPresenter getPresenter() {
		return this.presenter;
	}

	public Ticket getTicket() {
		return this.ticket;
	}

	@Override
	public void updateModel(final Model model) throws NoObjectFindException {
		this.ticket = model.getObject(this.ticket);
		this.field = model.getObject(this.field);
	}

}
