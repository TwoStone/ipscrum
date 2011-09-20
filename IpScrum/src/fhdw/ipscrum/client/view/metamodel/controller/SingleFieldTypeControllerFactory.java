package fhdw.ipscrum.client.view.metamodel.controller;

import java.io.Serializable;
import java.util.Date;

import fhdw.ipscrum.client.presenter.GenericTicketPresenter;
import fhdw.ipscrum.shared.model.metamodel.fields.AcceptanceCriteriaFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.DateFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.EffortFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.FieldTypeVisitor;
import fhdw.ipscrum.shared.model.metamodel.fields.HintFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.NumberFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.PBIFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.PersonFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.ReleaseFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.fields.SprintFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SystemFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.TextFieldType;
import fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes.Ticket;
import fhdw.ipscrum.shared.model.nonMeta.Effort;
import fhdw.ipscrum.shared.model.nonMeta.Person;
import fhdw.ipscrum.shared.model.nonMeta.ProductBacklogItem;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.Sprint;
import fhdw.ipscrum.shared.model.nonMeta.System;

/**
 * Represents the Factory of the SingleFieldTypeController.
 */
public class SingleFieldTypeControllerFactory {

	/**
	 * Represents the FieldTypeVisitor for the implementation of a fieldType.
	 */
	private final class FieldTypeVisitorImplementation implements FieldTypeVisitor {
		@SuppressWarnings("unchecked")
		@Override
		public void handleTextFieldType(final TextFieldType textFieldType) {
			SingleFieldTypeControllerFactory.this.controller =
					new TextSingleFieldTypeController(
							SingleFieldTypeControllerFactory.this.ticket,
							SingleFieldTypeControllerFactory.this.genericTicketPresenter,
							(SingleField<String>) SingleFieldTypeControllerFactory.this.singleField);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handleSystemFieldType(final SystemFieldType systemFieldType) {
			SingleFieldTypeControllerFactory.this.controller =
					new SystemSingleFieldTypeController(
							SingleFieldTypeControllerFactory.this.ticket,
							SingleFieldTypeControllerFactory.this.genericTicketPresenter,
							(SingleField<System>) SingleFieldTypeControllerFactory.this.singleField);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handleSprintFieldType(final SprintFieldType sprintFieldType) {
			SingleFieldTypeControllerFactory.this.controller =
					new SprintSingleFieldTypeController(
							SingleFieldTypeControllerFactory.this.ticket,
							SingleFieldTypeControllerFactory.this.genericTicketPresenter,
							(SingleField<Sprint>) SingleFieldTypeControllerFactory.this.singleField);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handleReleaseFieldType(final ReleaseFieldType releaseFieldType) {
			SingleFieldTypeControllerFactory.this.controller =
					new ReleaseSingleFieldTypeController(
							SingleFieldTypeControllerFactory.this.ticket,
							SingleFieldTypeControllerFactory.this.genericTicketPresenter,
							(SingleField<Release>) SingleFieldTypeControllerFactory.this.singleField);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handlePersonFieldType(final PersonFieldType personFieldType) {
			SingleFieldTypeControllerFactory.this.controller =
					new PersonSingleFieldTypeController(
							SingleFieldTypeControllerFactory.this.ticket,
							SingleFieldTypeControllerFactory.this.genericTicketPresenter,
							(SingleField<Person>) SingleFieldTypeControllerFactory.this.singleField);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handlePBIFieldType(final PBIFieldType pbiFieldType) {
			SingleFieldTypeControllerFactory.this.controller =
					new PBISingleFieldTypeController(
							SingleFieldTypeControllerFactory.this.ticket,
							SingleFieldTypeControllerFactory.this.genericTicketPresenter,
							(SingleField<ProductBacklogItem>) SingleFieldTypeControllerFactory.this.singleField);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handleNumberFieldType(final NumberFieldType numberFieldType) {
			SingleFieldTypeControllerFactory.this.controller =
					new NumberSingleFieldTypeController(
							SingleFieldTypeControllerFactory.this.ticket,
							SingleFieldTypeControllerFactory.this.genericTicketPresenter,
							(SingleField<Long>) SingleFieldTypeControllerFactory.this.singleField);
		}

		@Override
		public void handleHintFieldType(final HintFieldType hintFieldType) {

		}

		@SuppressWarnings("unchecked")
		@Override
		public void handleEffortFieldType(final EffortFieldType effortFieldType) {
			SingleFieldTypeControllerFactory.this.controller =
					new EffortSingleFieldTypeController(
							SingleFieldTypeControllerFactory.this.ticket,
							SingleFieldTypeControllerFactory.this.genericTicketPresenter,
							(SingleField<Effort>) SingleFieldTypeControllerFactory.this.singleField);
		}

		@SuppressWarnings("unchecked")
		@Override
		public void handleDateFieldType(final DateFieldType dateFieldType) {
			SingleFieldTypeControllerFactory.this.controller =
					new DateSingleFieldTypeController(
							SingleFieldTypeControllerFactory.this.ticket,
							SingleFieldTypeControllerFactory.this.genericTicketPresenter,
							(SingleField<Date>) SingleFieldTypeControllerFactory.this.singleField);
		}

		@Override
		public void handleAcceptanceCriterionFieldType(
				final AcceptanceCriteriaFieldType acceptanceCriteriaFieldType) {

		}
	}

	private final SingleField<?> singleField;
	private final GenericTicketPresenter genericTicketPresenter;
	private final Ticket ticket;
	private SingleFieldTypeController<?> controller;

	/**
	 * Constructor of the SingleFieldTypeControllerFactory.
	 * 
	 * @param <T>
	 *            is the related type
	 * @param singleField
	 *            is the single field related to the controller
	 * @param genericTicketPresenter
	 *            is the related presenter
	 * @param ticket
	 *            is the related ticket
	 */
	public <T extends Serializable> SingleFieldTypeControllerFactory(
			final SingleField<T> singleField,
			final GenericTicketPresenter genericTicketPresenter, final Ticket ticket) {
		this.singleField = singleField;
		this.genericTicketPresenter = genericTicketPresenter;
		this.ticket = ticket;
	}

	/**
	 * creates a SingleFieldTypeCreator.
	 * 
	 * @return the singleFieldTypeCreator with the chosen type.
	 */
	public SingleFieldTypeController<?> create() {
		this.singleField.getType().accept(this.visitor);
		return this.controller;
	}

	private final FieldTypeVisitor visitor = new FieldTypeVisitorImplementation();

}
