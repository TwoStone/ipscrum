package fhdw.ipscrum.client.view.metamodel.controller;

import java.io.Serializable;

import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.Field;

/**
 * Represents the FieldTypeController needed for controlling fieldTypes of tickets by editing tickets.
 * 
 * @param <T>
 *            is the type if the controller
 */
public interface FieldTypeController<T extends Serializable> {

	/**
	 * Updater of the controller.
	 * 
	 * @param model
	 *            which is current related to the controller
	 */
	void updateWidget(Model model);

	/**
	 * Updater of the model after the value of the controller changed.
	 * 
	 * @param model
	 *            which should be updated
	 * @throws NoObjectFindException
	 *             if no object to update exists
	 */
	void updateModel(Model model) throws NoObjectFindException;

	/**
	 * Getter of the field related to the controller.
	 * 
	 * @return the field
	 */
	Field<T> getField();

	/**
	 * Getter of the widget controlled by the controller.
	 * 
	 * @return the widget
	 */
	Widget getWidget();
}
