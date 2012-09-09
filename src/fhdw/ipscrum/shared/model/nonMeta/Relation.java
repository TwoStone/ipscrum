package fhdw.ipscrum.shared.model.nonMeta;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;

/**
 * Objects of this class describe relations to one target {@link Feature}. The relation has one type (see
 * {@link RelationType}), which can be customized by a user of the ticket system.
 */
public class Relation extends IdentifiableObject implements IsSerializable {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -8092507081061821465L;

	/**
	 * Represents the type of the relation.
	 */
	private RelationType type;

	/**
	 * Represents the target of the realtion.
	 */
	private ProductBacklogItem target;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	@SuppressWarnings("unused")
	private Relation() {
	}

	/**
	 * Constructor of the Relation.
	 * 
	 * @param model
	 *            the Relation is inserted into the model
	 * @param type
	 *            of the relation
	 * @param target
	 *            of the relation
	 */
	public Relation(final Model model, final RelationType type, final ProductBacklogItem target) {
		super(model);
		this.type = type;
		this.target = target;
		this.putToObjectStore();
	}

	/**
	 * Getter of the target of the Relation.
	 * 
	 * @return the pbi related to the relation
	 */
	public ProductBacklogItem getTarget() {
		return this.target;
	}

	/**
	 * Getter of the type if the relation.
	 * 
	 * @return the type of the realation
	 */
	public RelationType getType() {
		return this.type;
	}
}
