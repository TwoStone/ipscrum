package fhdw.ipscrum.client.architecture.widgets;

/**
 * represents the answer to an action.
 */
public abstract class Answer {

	private final String caption;

	/**
	 * constructor of the Answer.
	 * 
	 * @param caption
	 *            of the answer
	 */
	public Answer(final String caption) {
		super();
		this.caption = caption;
	}

	/**
	 * getter of the caption.
	 * 
	 * @return the current caption
	 */
	public String getCaption() {
		return this.caption;
	}

	/**
	 * is needed to react on some action.
	 * 
	 * @param widget
	 *            is the dialaog which needs the answer
	 */
	public abstract void onAction(QuestionDialog widget);
}
