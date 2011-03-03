package fhdw.ipscrum.shared.model;

import java.io.Serializable;

/**
 * A Hint represents a textual described hint for a {@link Feature}
 */
public class Hint implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2327097311477829394L;
	private String content;

	@SuppressWarnings("unused")
	private Hint() {
	}

	public Hint(final String content) {
		this.content = content;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final Hint other = (Hint) obj;
		if (this.content == null) {
			if (other.content != null) {
				return false;
			}
		} else if (!this.content.equals(other.content)) {
			return false;
		}
		return true;
	}

	public String getContent() {
		return this.content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((this.content == null) ? 0 : this.content.hashCode());
		return result;
	}

	public void setContent(final String content) {
		this.content = content;
	}
}
