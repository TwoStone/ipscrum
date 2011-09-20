package fhdw.ipscrum.client.view.metamodel.controller;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.client.view.metamodel.ComplexListFieldWidget;
import fhdw.ipscrum.client.view.metamodel.TypeRenderes;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Person;

/**
 * Represents the PersonListFieldTypeController needed for editing tickets.
 */
public class PersonListFieldTypeController extends ListFieldTypeController<Person> {

	private final ComplexListFieldWidget<Person> widget;

	/**
	 * Constructor of the PersonListFieldTypeController.
	 * 
	 * @param presenter
	 *            the controller is created in
	 * @param field
	 *            the controller is related to
	 * @param ticket
	 *            the controller is related to
	 */
	public PersonListFieldTypeController(final GenericTicketPresenter presenter,
			final ListField<Person> field, final Ticket ticket) {
		super(presenter, field, ticket);

		this.widget =
				new ComplexListFieldWidget<Person>(this.getField(),
						TypeRenderes.PERSONRENDERER);
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
