package fhdw.ipscrum.shared.model.nonMeta;

import java.util.Vector;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.IPScrumGeneralException;
import fhdw.ipscrum.shared.exceptions.model.DoubleDefinitionException;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.visitor.ISystemVisitor;

/**
 * Class System.
 */
@SuppressWarnings("serial")
public class System extends AbstractSystem {

	/**
	 * Represents the name of the system.
	 */
	private String name;

	/**
	 * Represents the parentSystem of the system.
	 */
	private AbstractSystem parent;

	/**
	 * Constructor for System, automatically establish a bidirectional association.
	 * 
	 * @param model
	 *            the system is related to
	 * @param name
	 *            of the system
	 * @param parent
	 *            system of the system
	 * 
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public System(final Model model, final String name, final AbstractSystem parent)
			throws IPScrumGeneralException {
		super(model);
		this.setName(name);
		this.setParent(parent);
		this.putToObjectStore();
	}

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	protected System() {
	}

	@Override
	public Vector<System> getSystemsRecursiv() {
		final Vector<System> ret = new Vector<System>();
		for (final System current : this.getSystems()) {
			ret.add(current);
			ret.addAll(current.getSystemsRecursiv());
		}
		return ret;
	}

	/**
	 * Setter of the name of the system.
	 * 
	 * @param name
	 *            the name to set
	 * @throws IPScrumGeneralException
	 *             if something fails
	 */
	public void setName(final String name) throws IPScrumGeneralException {
		if (name == null || name.trim().length() <= 0) {
			throw new NoValidValueException(ExceptionConstants.NO_VALID_NAME);
		}
		this.name = name;
		this.changed();
	}

	/**
	 * @return the name
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/**
	 * @return the parent
	 */
	public AbstractSystem getParent() {
		return this.parent;
	}

	/**
	 * private to set / change the referenced parent.
	 * 
	 * @param parent
	 *            is the parentsystem of the system
	 * @throws DoubleDefinitionException
	 *             if the parent is already parent of the system
	 */
	private void setParent(final AbstractSystem parent)
			throws DoubleDefinitionException {
		if (parent.contains(this)) {
			throw new DoubleDefinitionException(ExceptionConstants.SYSTEM_ALREADY_KNOWN);
		} else {
			this.parent = parent;
			this.changed();
		}
	}

	@Override
	public void accept(final ISystemVisitor visitor) {
		visitor.handleSystem(this);
	}

	@Override
	public boolean contains(final System system) {
		if (system.getParent() != null) {
			return system.getParent().getRoot().containsAction(system);
		} else {
			return this.containsAction(system);
		}
	}

	@Override
	public boolean containsAction(final System system) {
		boolean result = false;
		if (this.getName().equals(system.getName())) {
			result = true;
		}

		final Vector<System> systems = this.getSystems();
		for (final System current : systems) {
			if (current.equals(system)) {
				result = true;
				break;
			} else {
				if (current.containsAction(system)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	@Override
	public Vector<System> getSystems() {
		return new Vector<System>(this.getModel().getDirectChildSystems(this));
	}

	@Override
	public AbstractSystem getRoot() {
		if (this.getParent() != null) {
			return this.getParent().getRoot();
		} else {
			return this;
		}
	}

	/**
	 * Returns the name of the System.
	 * 
	 * @return the name of the system
	 */
	@Override
	public String toString() {
		return this.name;
	}

	/**
	 * return the name with the parent as a prefix.
	 * 
	 * @return the name of the system with the name of the parent as a prefix
	 */
	public String toDisplayWithParent() {
		/**
		 * Represents the Visitor to handle Systems
		 */
		class IsRootVisitor implements ISystemVisitor {

			private Boolean result;

			@Override
			public void handleSystem(final System system) {
				this.result = false;
			}

			@Override
			public void handleRoot(final Rootsystem rootsystem) {
				this.result = true;
			}
		}
		final IsRootVisitor visitor = new IsRootVisitor();
		this.getParent().accept(visitor);
		if (!visitor.result) {
			return this.getParent().getName() + ">" + this.getName();
		}
		return this.getName();

	}
}
