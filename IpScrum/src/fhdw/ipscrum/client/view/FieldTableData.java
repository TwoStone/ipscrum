package fhdw.ipscrum.client.view;

import fhdw.ipscrum.shared.model.metamodel.fields.FieldType;

/**
 * represents the table containing the fields of a ticket type.
 */
public class FieldTableData {

	private final FieldType field;
	private final Boolean active;

	/**
	 * constructor of the FieldTableData.
	 * 
	 * @param field
	 *            is the contained field
	 * @param active
	 *            is the status of the field
	 */
	public FieldTableData(final FieldType field, final Boolean active) {
		super();
		this.active = active;
		this.field = field;
	}

	/**
	 * getter if the field is active or non active.
	 * 
	 * @return true if the fields is active
	 */
	public Boolean getActive() {
		return this.active;
	}

	/**
	 * getter of the field.
	 * 
	 * @return the field
	 */
	public FieldType getFieldType() {
		return this.field;
	}

}
