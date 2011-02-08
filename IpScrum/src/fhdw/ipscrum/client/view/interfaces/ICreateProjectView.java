package fhdw.ipscrum.client.view.interfaces;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasText;

public interface ICreateProjectView extends IView{

	public abstract HasClickHandlers getBtnCreateProject();

	public abstract HasText getTxtBoxBezeichnung();

}