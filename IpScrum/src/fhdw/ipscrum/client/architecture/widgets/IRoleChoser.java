package fhdw.ipscrum.client.architecture.widgets;

import java.util.List;

import com.google.gwt.event.dom.client.ClickHandler;

import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.shared.model.nonMeta.Role;

/**
 * Represents the interface of the view in which the role to log in with is to be chosen.
 */
public interface IRoleChoser extends IView {

	/**
	 * Refreshes the list of the role the user could chose to log in with.
	 * 
	 * @param roles
	 *            related to the user
	 */
	void refreshRoles(List<Role> roles);

	/**
	 * Event which is needed to handle the movement to the project selection view.
	 * 
	 * @param handler
	 *            is needed to handle the event.
	 */
	void registerGo(ClickHandler handler);

	/**
	 * Getter of the selected role to log in with.
	 * 
	 * @return the selected role
	 */
	Role getSelRole();

	/**
	 * Sets the failure.
	 * 
	 * @param fail
	 *            is the string with shows the fail
	 */
	void setFailure(String fail);

}
