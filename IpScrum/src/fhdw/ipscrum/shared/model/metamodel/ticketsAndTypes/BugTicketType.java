package fhdw.ipscrum.shared.model.metamodel.ticketsAndTypes;

import java.util.Collection;

import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.ListField;
import fhdw.ipscrum.shared.model.metamodel.fields.ReleaseFieldType;
import fhdw.ipscrum.shared.model.metamodel.fields.SingleField;
import fhdw.ipscrum.shared.model.metamodel.fields.SystemFieldType;
import fhdw.ipscrum.shared.model.nonMeta.Bug;
import fhdw.ipscrum.shared.model.nonMeta.Release;
import fhdw.ipscrum.shared.model.nonMeta.System;
import fhdw.ipscrum.shared.model.visitor.PBITicketTypeVisitor;

/**
 * this class represents the knowledge layer of bugs. objects of this class determine the behaviour of bugs.
 */
@SuppressWarnings("serial")
public class BugTicketType extends PBITicketType {

	/**
	 * Represents the version(release) the bug is related to.
	 */
	private ReleaseFieldType versionType;

	/**
	 * Represents the system the bug is related to.
	 */
	private SystemFieldType systemsType;

	/**
	 * Constructor of the BugTicketType.
	 * 
	 * @param model
	 *            : it is inserted into the model
	 * @param name
	 *            of the bugTicketType
	 * @param description
	 *            of the bugTicketType
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public BugTicketType(final Model model, final String name, final String description) throws IPScrumGeneralException {
		super(model, name, description);
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected BugTicketType() {
		super();
	}

	/**
	 * Constructor of the BugTicketType.
	 * 
	 * @param model
	 *            : it is inserted into the model
	 * @param name
	 *            of the bugTicketType
	 * @param description
	 *            of the bugTicketType
	 * @param typeManager
	 *            : it is related to the bug
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	protected BugTicketType(final Model model, final String name, final String description,
			final TypeManager typeManager) throws IPScrumGeneralException {
		super(model, name, description, typeManager);
	}

	@Override
	public void accept(final PBITicketTypeVisitor visitor) {
		visitor.handleBugTicketType(this);

	}

	@Override
	public void accept(final TicketTypeVisitor v) {
		v.handleBugTicketType(this);
	}

	/**
	 * Adds a system to the bug.
	 * 
	 * @param system
	 *            to add
	 * @param bug
	 *            attached
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void addSystem(final System system, final Bug bug) throws IPScrumGeneralException {
		@SuppressWarnings("unchecked")
		final ListField<System> target = (ListField<System>) this.getField(this.getSystemsType(), bug);
		target.addValue(system, bug);
	}

	/**
	 * Getter of the systems of the bug.
	 * 
	 * @param bug
	 *            attached
	 * @return all systems of the bug
	 */
	public Collection<System> getSystems(final Bug bug) {
		@SuppressWarnings("unchecked")
		final ListField<System> result = (ListField<System>) this.getField(this.getSystemsType(), bug);
		return result.getValues();
	}

	/**
	 * Getter of the system the bug is related to.
	 * 
	 * @return the related system of the bug
	 */
	public SystemFieldType getSystemsType() {
		return this.systemsType;
	}

	/**
	 * Getter of the version of the bug.
	 * 
	 * @param bug
	 *            attached
	 * @return the version (release) the bug is related to
	 */
	public Release getVersion(final Bug bug) {
		@SuppressWarnings("unchecked")
		final SingleField<Release> result = (SingleField<Release>) this.getField(this.getVersionType(), bug);
		return result.getValue();
	}

	/**
	 * Getter of the versionType.
	 * 
	 * @return the versionType of the bug
	 */
	public ReleaseFieldType getVersionType() {
		return this.versionType;
	}

	/**
	 * Removes systems from the bug.
	 * 
	 * @param system
	 *            to remove
	 * @param bug
	 *            attached
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void removeSystem(final System system, final Bug bug) throws IPScrumGeneralException {
		@SuppressWarnings("unchecked")
		final ListField<System> target = (ListField<System>) this.getField(this.getSystemsType(), bug);
		target.removeValue(system, bug);
	}

	/**
	 * Setter of the systemType.
	 * 
	 * @param systemsType
	 *            now related to the bug
	 */
	public void setSystemsType(final SystemFieldType systemsType) {
		if (this.systemsType != null) {
			return;
		}
		this.systemsType = systemsType;
		this.doAddFieldType(systemsType);
	}

	/**
	 * Setter of the version.
	 * 
	 * @param version
	 *            new version of the bug
	 * @param bug
	 *            attached
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void setVersion(final Release version, final Bug bug) throws IPScrumGeneralException {
		@SuppressWarnings("unchecked")
		final SingleField<Release> target = (SingleField<Release>) this.getField(this.getVersionType(), bug);
		target.setValue(version, bug);
	}

	/**
	 * Setter of the versionType.
	 * 
	 * @param versionType
	 *            : new versionType
	 */
	public void setVersionType(final ReleaseFieldType versionType) {
		if (this.versionType != null) {
			return;
		}
		this.versionType = versionType;
		this.doAddFieldType(versionType);
	}

	@Override
	protected void doInitializeStandard(final TypeManager typeManager) throws IPScrumGeneralException {
		super.doInitializeStandard(typeManager);
		this.setVersionType(typeManager.getVersionType());
		this.setSystemsType(typeManager.getSystemsType());

		this.doSetActive(typeManager.getOpen(), typeManager.getVersionType());
		this.doSetActive(typeManager.getOpen(), typeManager.getSystemsType());
	}

}
