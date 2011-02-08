package fhdw.ipscrum.client.view;

import com.google.gwt.cell.client.AbstractCell;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;

import fhdw.ipscrum.shared.model.interfaces.IRole;

/**
 * This class is used to create cell-based widgets like <code>CellList</code> with <code>IRole</code>-Objects.
 * @author Wilken
 */
public class RoleCell extends AbstractCell<IRole> {

	@Override
	public void render(com.google.gwt.cell.client.Cell.Context context, IRole value, SafeHtmlBuilder sb) {
		if (value != null) {
			sb.appendEscaped(value.getDescription());
		}
	}
}
