package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexListFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Person;

public class PersonListFieldTypeController extends ListFieldTypeController<Person> {

	private final ComplexListFieldWidget<Person> widget;

	public PersonListFieldTypeController(final GenericTicketPresenter presenter,
			final ListField<Person> field, final Ticket ticket) {
		super(presenter, field, ticket);

		this.widget =
				new ComplexListFieldWidget<Person>(this.getField(),
						TypeRenderes.PersonRenderer);
		this.initialize();
	}

	@Override
	public ComplexListFieldWidget<Person> getWidget() {
		return this.widget;
	}

	@Override
	public void updateWidget(final Model model) {
		this.getWidget().setItems(this.getField().getValues());
		this.getWidget().setAvailableItems(model.getAllPersons());
	}

}
