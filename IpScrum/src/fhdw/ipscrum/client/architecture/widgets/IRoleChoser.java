package fhdw.ipscrum.client.architecture.widgets;

import java.util.List;

import com.google.gwt.event.dom.client.ClickHandler;

import fhdw.ipscrum.shared.model.nonMeta.Role;

public interface IRoleChoser {

	void refreshRoles(List<Role> roles);

	void registerGo(ClickHandler handler);

	Role getSelRole();

	void setFailure(String fail);

}
