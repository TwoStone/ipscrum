package fhdw.ipscrum.client.view.metamodel.controller;

import java.io.Serializable;

import com.google.gwt.user.client.ui.Widget;

import fhdw.ipscrum.shared.exceptions.infrastructure.NoObjectFindException;
import fhdw.ipscrum.shared.model.Model;
import fhdw.ipscrum.shared.model.metamodel.fields.Field;

public interface FieldTypeController<T extends Serializable> {
	void updateWidget(Model model);

	void updateModel(Model model) throws NoObjectFindException;

	Field<T> getField();

	Widget getWidget();
}
