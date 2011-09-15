package fhdw.ipscrum.client.view;

import java.util.List;

import fhdw.ipscrum.client.architecture.events.EventHandler;
import fhdw.ipscrum.client.architecture.events.TypedEventArg;
import fhdw.ipscrum.client.architecture.view.IView;
import fhdw.ipscrum.shared.model.userRights.Right;

public interface IAddRightsToRoleView extends IView {

	void setAddedRights(List<Right> rights);

	void setRightsToAdd(List<Right> rights);

	void registerAdd(EventHandler<TypedEventArg<Right>> handler);

	void registerRemove(EventHandler<TypedEventArg<Right>> handler);

}
