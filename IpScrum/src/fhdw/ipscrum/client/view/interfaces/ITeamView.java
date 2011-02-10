package fhdw.ipscrum.client.view.interfaces;

import java.util.ArrayList;

import fhdw.ipscrum.shared.model.interfaces.IPerson;


public interface ITeamView extends IView {

	public abstract void updatePersonTableData(ArrayList<IPerson> arrayList);

}