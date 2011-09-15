package fhdw.ipscrum.shared.model.nonMeta;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

import fhdw.ipscrum.shared.constants.ExceptionConstants;
import fhdw.ipscrum.shared.exceptions.model.NoValidValueException;

/**
 * This class represents a container for Effort-values. Effort-values cannot be set to
 * less than zero.
 */
public class Effort implements IsSerializable, Serializable {

	/**
	 * Default effort for initialization of fields.
	 */
	public static final Effort NULL = new Effort();

	/**
	 * Represents the serialVersionUID.
	 */
	private static final long serialVersionUID = -8810450021746994455L;

	/**
	 * Represents the value of the Effort.
	 */
	private Integer value = 0;

	/**
	 * Constructor without parameters. Needed for serialization.
	 */
	private Effort() {
	}

	/**
	 * Constructor of the Effort.
	 * 
	 * @param value
	 *            of the Effort
	 * @throws NoValidValueException
	 *             if the value is lass than null
	 */
	public Effort(final Integer value) throws NoValidValueException {
		super();
		if (value < 0) {
			throw new NoValidValueException(ExceptionConstants.EFFORT_MIN_VALUE);
		}
		this.value = value;
	}

	/**
	 * Getter for the value of the Effort.
	 * 
	 * @return the value of the Effort
	 */
	public Integer getValue() {
		return this.value;
	}

	/**
	 * Setter for the value.
	 * 
	 * @param value
	 *            the Effort should get
	 * @throws NoValidValueException
	 *             if the value is less than null
	 */
	public void setValue(final Integer value) throws NoValidValueException {
		if (value < 0) {
			throw new NoValidValueException(ExceptionConstants.EFFORT_MIN_VALUE);
		}
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
		result = prime * result + (this.value == null ? 0 : this.value.hashCode());
		return result;
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
		final Effort other = (Effort) obj;
		if (this.value == null) {
			if (other.value != null) {
				return false;
			}
		} else if (!this.value.equals(other.value)) {
			return false;
		}
		return true;
	}

}
