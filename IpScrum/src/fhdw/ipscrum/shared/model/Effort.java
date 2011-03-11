package fhdw.ipscrum.shared.model;

import java.io.Serializable;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.NoValidValueException;

/**
 * This class represents a container for Effort-values.
 * Effort-values cannot be set to less than zero.
 */
public class Effort implements Serializable {

	private static final long serialVersionUID = -8810450021746994455L;

	private Integer value = 0;

	@SuppressWarnings("unused")
	private Effort() {}

	public Effort(Integer value) throws NoValidValueException {
		if (value < 0) throw new NoValidValueException(ExceptionConstants.EFFORT_MIN_VALUE);
		this.value = value;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) throws NoValidValueException {
		if (value < 0) throw new NoValidValueException(ExceptionConstants.EFFORT_MIN_VALUE);
		this.value = value;
	}


	@Override
	public String toString() {
		return this.value.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Effort other = (Effort) obj;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
}
