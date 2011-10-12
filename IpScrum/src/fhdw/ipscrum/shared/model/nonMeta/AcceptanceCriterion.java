package fhdw.ipscrum.shared.model.nonMeta;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;

/**
 * An acceptance criterion is a textual description of a condition, under that a product owner accepts a implemented
 * {@link Feature}.
 */
public class AcceptanceCriterion extends IdentifiableObject implements IsSerializable {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = 891100243968877751L;

	/**
	 * Represents the text of the Criterion.
	 */
	private String content;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	@SuppressWarnings("unused")
	private AcceptanceCriterion() {
	}

	/**
	 * Constructor of the Acceptance Criterion.
	 * 
	 * @param model
	 *            : the Acceptance Criterion is inserted in the model
	 * @param content
	 *            is the text of the Criterion
	 */
	public AcceptanceCriterion(final Model model, final String content) {
		super(model);
		this.content = content;
		this.putToObjectStore();
	}

	/**
	 * Gets the text of the Criterion.
	 * 
	 * @return the text of the Criterion
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * Sets a new text for the Criterion.
	 * 
	 * @param content
	 *            the new text of the Criterion
	 */
	public void setContent(final String content) {
		this.content = content;
		this.changed();
	}
}
