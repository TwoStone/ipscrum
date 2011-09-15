package fhdw.ipscrum.client.view.metamodel.controller;

import java.util.Date;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.shared.model.metamodel.fields.AcceptanceCriteriaFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.DateFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.EffortFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldTypeVisitor;
import fhdw.ipscrum.shared.model.metamodel.fields.HintFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.fields.NumberFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.PBIFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.PersonFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.ReleaseFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SprintFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SystemFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.TextFieldType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.AcceptanceCriterion;
import fhdw.ipscrum.shared.model.nonMeta.Effort;
import fhdw.ipscrum.shared.model.nonMeta.Hint;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.System;

public class ListFieldTypeControllerFactory {

	private final class FieldTypeVisitorImplementation implements FieldTypeVisitor {
		@SuppressWarnings("unchecked")
		@Override
		public void handleTextFieldType(final TextFieldType textFieldType) {
			ListFieldTypeControllerFactory.this.controller =
					new TextListFieldTypeController(
							ListFieldTypeControllerFactory.this.genericTicketPresenter,
							(ListField<String>) ListFieldTypeControllerFactory.this.field,
							ListFieldTypeControllerFactory.this.ticket);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handleSystemFieldType(final SystemFieldType systemFieldType) {
			ListFieldTypeControllerFactory.this.controller =
					new SystemListFieldTypeController(
							ListFieldTypeControllerFactory.this.genericTicketPresenter,
							(ListField<System>) ListFieldTypeControllerFactory.this.field,
							ListFieldTypeControllerFactory.this.ticket);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handleSprintFieldType(final SprintFieldType sprintFieldType) {
			ListFieldTypeControllerFactory.this.controller =
					new SprintListFieldTypeController(
							ListFieldTypeControllerFactory.this.genericTicketPresenter,
							(ListField<Sprint>) ListFieldTypeControllerFactory.this.field,
							ListFieldTypeControllerFactory.this.ticket);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handleReleaseFieldType(final ReleaseFieldType releaseFieldType) {
			ListFieldTypeControllerFactory.this.controller =
					new ReleaseListFieldTypeController(
							ListFieldTypeControllerFactory.this.genericTicketPresenter,
							(ListField<Release>) ListFieldTypeControllerFactory.this.field,
							ListFieldTypeControllerFactory.this.ticket);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handlePersonFieldType(final PersonFieldType personFieldType) {
			ListFieldTypeControllerFactory.this.controller =
					new PersonListFieldTypeController(
							ListFieldTypeControllerFactory.this.genericTicketPresenter,
							(ListField<Person>) ListFieldTypeControllerFactory.this.field,
							ListFieldTypeControllerFactory.this.ticket);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handlePBIFieldType(final PBIFieldType pbiFieldType) {
			ListFieldTypeControllerFactory.this.controller =
					new PBIListFieldTypeController(
							ListFieldTypeControllerFactory.this.genericTicketPresenter,
							(ListField<ProductBacklogItem>) ListFieldTypeControllerFactory.this.field,
							ListFieldTypeControllerFactory.this.ticket);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handleNumberFieldType(final NumberFieldType numberFieldType) {
			ListFieldTypeControllerFactory.this.controller =
					new NumberListFieldTypeController(
							ListFieldTypeControllerFactory.this.genericTicketPresenter,
							(ListField<Long>) ListFieldTypeControllerFactory.this.field,
							ListFieldTypeControllerFactory.this.ticket);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handleHintFieldType(final HintFieldType hintFieldType) {
			ListFieldTypeControllerFactory.this.controller =
					new HintListFieldTypeController(
							ListFieldTypeControllerFactory.this.genericTicketPresenter,
							(ListField<Hint>) ListFieldTypeControllerFactory.this.field,
							ListFieldTypeControllerFactory.this.ticket);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handleEffortFieldType(final EffortFieldType effortFieldType) {
			ListFieldTypeControllerFactory.this.controller =
					new EffortListFieldTypeController(
							ListFieldTypeControllerFactory.this.genericTicketPresenter,
							(ListField<Effort>) ListFieldTypeControllerFactory.this.field,
							ListFieldTypeControllerFactory.this.ticket);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handleDateFieldType(final DateFieldType dateFieldType) {
			ListFieldTypeControllerFactory.this.controller =
					new DateListFieldTypeController(
							ListFieldTypeControllerFactory.this.genericTicketPresenter,
							(ListField<Date>) ListFieldTypeControllerFactory.this.field,
							ListFieldTypeControllerFactory.this.ticket);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handleAcceptanceCriterionFieldType(
				final AcceptanceCriteriaFieldType acceptanceCriteriaFieldType) {
			ListFieldTypeControllerFactory.this.controller =
					new fhdw.ipscrum.client.view.metamodel.controller.AcceptanceCriteriaListFieldTypeController(
							ListFieldTypeControllerFactory.this.genericTicketPresenter,
							(ListField<AcceptanceCriterion>) ListFieldTypeControllerFactory.this.field,
							ListFieldTypeControllerFactory.this.ticket);
		}
	}

	private final FieldType type;
	private final GenericTicketPresenter genericTicketPresenter;
	private final Ticket ticket;
	private ListFieldTypeController<?> controller;
	private final ListField<?> field;

	public ListFieldTypeControllerFactory(final ListField<?> field,
			final GenericTicketPresenter genericTicketPresenter, final Ticket ticket) {
		this.field = field;
		this.type = field.getType();
		this.genericTicketPresenter = genericTicketPresenter;
		this.ticket = ticket;

	}

	public ListFieldTypeController<?> create() {
		this.type.accept(this.typeVisitor);
		return this.controller;
	}

	private final FieldTypeVisitor typeVisitor = new FieldTypeVisitorImplementation();

}
