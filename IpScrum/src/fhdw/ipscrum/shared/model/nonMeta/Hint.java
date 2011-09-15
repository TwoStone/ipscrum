package fhdw.ipscrum.shared.model.nonMeta;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.infrastructure.IdentifiableObject;
import fhdw.ipscrum.shared.model.Model;

/**
 * A Hint represents a textual described hint.
 */
public class Hint extends IdentifiableObject implements IsSerializable {

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -2327097311477829394L;

	/**
	 * Represents the text of the hint.
	 */
	private String content;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	@SuppressWarnings("unused")
	private Hint() {
	}

	/**
	 * Constructor of the hint.
	 * 
	 * @param model
	 *            : the hint is inserted in the model
	 * @param content
	 *            of the hint
	 */
	public Hint(final Model model, final String content) {
		super(model);
		this.content = content;
		this.putToObjectStore();
	}

	/**
	 * Getter for the content of the hint.
	 * 
	 * @return the text of the hint.
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * Setter for the content of the hint.
	 * 
	 * @param content
	 *            is the new text of the hint
	 */
	public void setContent(final String content) {
		this.content = content;
		this.changed();
	}
}
