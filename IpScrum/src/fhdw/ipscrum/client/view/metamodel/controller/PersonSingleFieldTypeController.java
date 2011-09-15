package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexSingleFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Person;

public class PersonSingleFieldTypeController extends SingleFieldTypeController<Person> {

	private final ComplexSingleFieldWidget<Person> widget;

	public PersonSingleFieldTypeController(final Ticket ticket,
			final GenericTicketPresenter presenter, final SingleField<Person> field) {
		super(ticket, presenter, field);

		this.widget = new ComplexSingleFieldWidget<Person>(TypeRenderes.PersonRenderer);
		this.initialize();
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setItems(model.getAllPersons());
		this.getWidget().setValue(this.getField().getValue());
	}

	@Override
	public ComplexSingleFieldWidget<Person> getWidget() {
		return this.widget;
	}

}
