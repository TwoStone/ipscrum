package fhdw.ipscrum.client.presenter;

import fhdw.ipscrum.client.architecture.ClientContext;
import fhdw.ipscrum.client.architecture.events.DefaultEventHandler;
import fhdw.ipscrum.client.architecture.events.EventArgs;
import fhdw.ipscrum.client.architecture.events.EventRegistration;
import fhdw.ipscrum.client.architecture.presenter.WritePresenter;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.client.architecture.widgets.Answer;
import fhdw.ipscrum.client.architecture.widgets.QuestionDialog;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.AcceptanceCriteriaFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.DateFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.EffortFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.HintFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.NumberFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.PBIFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.PersonFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.ReleaseFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.SprintFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.SystemFieldTypeCreateCommand;
import fhdw.ipscrum.shared.commands.admin.fieldTypes.TextFieldTypeCreateCommand;
import fhdw.ipscrum.shared.constants.TextConstants;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.metamodel.fields.Many;
import fhdw.ipscrum.shared.model.metamodel.fields.One;

/**
 * This class represents the presenter which controls the view to create FieldTypes.
 */
public class FieldTypeCreatePresenter extends WritePresenter {
	/**
	 * Represents the Interface of the View which is related to this presenter. It's the interface to the ({@link}
	 * fhdw.ipscrum.client.view.FieldTypeCreateView).
	 */
	public interface IFieldTypeCreateView extends IView {
		/**
		 * Represents the Event to handle the save.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles the save
		 */
		EventRegistration registerSave(DefaultEventHandler handler);

		/**
		 * Represents the Event to handle the abort.
		 * 
		 * @param handler
		 *            needed to handle the event
		 * @return the event which handles the abort
		 */
		EventRegistration registetAbort(DefaultEventHandler handler);

		/**
		 * Getter of the text of the description field on the view.
		 * 
		 * @return the text in the description field
		 */
		String getDescription();

		/**
		 * Getter of the text of the multiplicity field on the view.
		 * 
		 * @return the text in the multiplicity field
		 */
		String getMultiplicity();

		/**
		 * Getter of the text of the type field on the view.
		 * 
		 * @return the text in the type field
		 */
		String getType();

	}

	/**
	 * Represents the view which is related to and controlled by this presenter.
	 */
	private IFieldTypeCreateView view;

	/**
	 * constructor of the ({@link} fhdw.ipscrum.client.presenter.FieldTypeCreatePresenter).
	 * 
	 * @param context
	 *            is the ({@link} fhdw.ipscrum.client.architecture.ClientContext) which is needed to get the model and
	 *            other related classes.
	 */
	public FieldTypeCreatePresenter(final ClientContext context) {
		super(context);
		this.beginTransaction();
	}

	@Override
	public String getName() {
		return "Feldtypen erstellen";
	}

	@Override
	public IFieldTypeCreateView doGetView() {
		if (this.view == null) {
			this.view = this.getContext().getViewFactory().createFieldTypeCreateView();
			this.view.registerSave(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					FieldTypeCreatePresenter.this.save();
					FieldTypeCreatePresenter.this.close();
				}
			});
			this.view.registetAbort(new DefaultEventHandler() {

				@Override
				public void onUpdate(final Object sender, final EventArgs eventArgs) {
					FieldTypeCreatePresenter.this.showQuestion("Do you want to leave without saving?", new Answer(
							"Yes!") {

						@Override
						public void onAction(final QuestionDialog widget) {
							widget.hide();
							FieldTypeCreatePresenter.this.close();
						}
					}, new Answer("No!") {

						@Override
						public void onAction(final QuestionDialog widget) {
							widget.hide();
						}
					});
				}
			});
		}

		return this.view;
	}

	@Override
	public Boolean onSave() {
		try {
			this.createRightType();
			this.commitTransaction();
			return super.onSave();
		} catch (final IPScrumGeneralException e) {
			return false;
		}
	}

	@Override
	public void updateView() {

	}

	@Override
	public void onModelUpdate() {

	}

	/**
	 * is needed to identify which field type create command exactly needed to be used.
	 * 
	 * @throws IPScrumGeneralException
	 *             if one of the commands fails.
	 */
	private void createRightType() throws IPScrumGeneralException {

		// TODO: 508: FieldTypeCreatePresenter - Checkstyle Problem: Cyclomatic Complexity
		// is 34 (max allowed is 10).
		// https://fhdwdev.ha.bib.de/bugzilla/show_bug.cgi?id=508
		final One one = this.getContext().getModel().getTypeManager().getOne();
		final Many many = this.getContext().getModel().getTypeManager().getMany();

		if (this.view.getType().equals(TextConstants.FIELDTYPE_ACCEPTANCECRITERIAL)) {
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_ONE)) {
				this.doCommand(new AcceptanceCriteriaFieldTypeCreateCommand(this.view.getDescription(), one));
			}
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_MANY)) {
				this.doCommand(new AcceptanceCriteriaFieldTypeCreateCommand(this.view.getDescription(), many));
			}
		}
		if (this.view.getType().equals(TextConstants.FIELDTYPE_DATE)) {
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_ONE)) {
				this.doCommand(new DateFieldTypeCreateCommand(this.view.getDescription(), one));
			}
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_MANY)) {
				this.doCommand(new DateFieldTypeCreateCommand(this.view.getDescription(), many));
			}
		}
		if (this.view.getType().equals(TextConstants.FIELDTYPE_EFFORD)) {
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_ONE)) {
				this.doCommand(new EffortFieldTypeCreateCommand(this.view.getDescription(), one));
			}
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_MANY)) {
				this.doCommand(new EffortFieldTypeCreateCommand(this.view.getDescription(), many));
			}
		}
		if (this.view.getType().equals(TextConstants.FIELDTYPE_HINT)) {
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_ONE)) {
				this.doCommand(new HintFieldTypeCreateCommand(this.view.getDescription(), one));
			}
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_MANY)) {
				this.doCommand(new HintFieldTypeCreateCommand(this.view.getDescription(), many));
			}
		}
		if (this.view.getType().equals(TextConstants.FIELDTYPE_NUMBER)) {
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_ONE)) {
				this.doCommand(new NumberFieldTypeCreateCommand(this.view.getDescription(), one));
			}
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_MANY)) {
				this.doCommand(new NumberFieldTypeCreateCommand(this.view.getDescription(), many));
			}
		}
		if (this.view.getType().equals(TextConstants.FIELDTYPE_PBI)) {
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_ONE)) {
				this.doCommand(new PBIFieldTypeCreateCommand(this.view.getDescription(), one));
			}
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_MANY)) {
				this.doCommand(new PBIFieldTypeCreateCommand(this.view.getDescription(), many));
			}
		}
		if (this.view.getType().equals(TextConstants.FIELDTYPE_PERSON)) {
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_ONE)) {
				this.doCommand(new PersonFieldTypeCreateCommand(this.view.getDescription(), one));
			}
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_MANY)) {
				this.doCommand(new PersonFieldTypeCreateCommand(this.view.getDescription(), many));
			}
		}
		if (this.view.getType().equals(TextConstants.FIELDTYPE_RELEASE)) {
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_ONE)) {
				this.doCommand(new ReleaseFieldTypeCreateCommand(this.view.getDescription(), one));
			}
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_MANY)) {
				this.doCommand(new ReleaseFieldTypeCreateCommand(this.view.getDescription(), many));
			}
		}
		if (this.view.getType().equals(TextConstants.FIELDTYPE_SPRINT)) {
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_ONE)) {
				this.doCommand(new SprintFieldTypeCreateCommand(this.view.getDescription(), one));
			}
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_MANY)) {
				this.doCommand(new SprintFieldTypeCreateCommand(this.view.getDescription(), many));
			}
		}
		if (this.view.getType().equals(TextConstants.FIELDTYPE_SYSTEM)) {
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_ONE)) {
				this.doCommand(new SystemFieldTypeCreateCommand(this.view.getDescription(), one));
			}
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_MANY)) {
				this.doCommand(new SystemFieldTypeCreateCommand(this.view.getDescription(), many));
			}
		}
		if (this.view.getType().equals(TextConstants.FIELDTYPE_TEXT)) {
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_ONE)) {
				this.doCommand(new TextFieldTypeCreateCommand(this.view.getDescription(), one));
			}
			if (this.view.getMultiplicity().equals(TextConstants.FIELDTYPE_MANY)) {
				this.doCommand(new TextFieldTypeCreateCommand(this.view.getDescription(), many));
			}
		}
	}

}
