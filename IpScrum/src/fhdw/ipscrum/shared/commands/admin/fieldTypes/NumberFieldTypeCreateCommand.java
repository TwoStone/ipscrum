package fhdw.ipscrum.shared.commands.admin.fieldTypes;

import fhdw.ipscrum.shared.commands.interfaces.IFieldTypesCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.Multiplicity;
import fhdw.ipscrum.shared.model.metamodel.fields.NumberFieldType;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a number field type.
 */
public class NumberFieldTypeCreateCommand extends Command<NumberFieldType> implements IFieldTypesCommand {

	/**
	 * Represents the Name of the FieldType.
	 */
	private String name;

	/**
	 * Represents the Multiplicity of the FieldType.
	 */
	private String multiplicityId;

	/**
	 * Constructor of the FieldType without parameters.
	 */
	@SuppressWarnings("unused")
	private NumberFieldTypeCreateCommand() {
		super();
	}

	/**
	 * Constructor of the FieldType.
	 * 
	 * @param name
	 *            of the new FieldType
	 * @param multiplicity
	 *            of the new FieldType
	 */
	public NumberFieldTypeCreateCommand(final String name, final Multiplicity multiplicity) {
		super();
		this.name = name;
		this.multiplicityId = multiplicity.getId();
	}

	@Override
	protected NumberFieldType onExecute(final Model model) throws IPScrumGeneralException {
		this.setStringValue(StringUtils.format("Neuer Feldtyp '%s' erstellt.", this.name));

		final Multiplicity multiplicity = (Multiplicity) model.getObject(this.multiplicityId);
		final NumberFieldType numberFieldType = new NumberFieldType(model, this.name, multiplicity);
		return numberFieldType;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handleNumberFieldTypeCreateCommand(this);
	}

	@Override
	public boolean dependsOnProject() {
		return false;
	}

	@Override
	public Project getDependingProject(final Model model) throws NoObjectFindException {
		return null;
	}

}
