package fhdw.ipscrum.shared.commands.admin.fieldTypes;

import fhdw.ipscrum.shared.commands.interfaces.IFieldTypesCommand;
import fhdw.ipscrum.shared.commands.visitor.CommandVisitor;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.infrastructure.Command;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.Multiplicity;
import fhdw.ipscrum.shared.model.metamodel.fields.PersonFieldType;
import fhdw.ipscrum.shared.model.nonMeta.Project;
import fhdw.ipscrum.shared.utils.StringUtils;

/**
 * Creates a person field type.
 */
public class PersonFieldTypeCreateCommand extends Command<PersonFieldType>
		implements IFieldTypesCommand {

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
	private PersonFieldTypeCreateCommand() {
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
	public PersonFieldTypeCreateCommand(final String name,
			final Multiplicity multiplicity) {
		super();
		this.name = name;
		this.multiplicityId = multiplicity.getId();
	}

	@Override
	protected PersonFieldType onExecute(final Model model)
			throws IPScrumGeneralException {
		this.setStringValue(StringUtils.format("Neuer Feldtyp '%s' erstellt.",
				this.name));

		final Multiplicity multiplicity =
				(Multiplicity) model.getObject(this.multiplicityId);
		final PersonFieldType personFieldType =
				new PersonFieldType(model, this.name, multiplicity);
		return personFieldType;
	}

	@Override
	public void accept(final CommandVisitor v) {
		v.handlePersonFieldTypeCreateCommand(this);
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
