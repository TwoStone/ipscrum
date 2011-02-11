package fhdw.ipscrum.client.view.interfaces;

import java.util.ArrayList;
import java.util.HashSet;

import fhdw.ipscrum.shared.model.interfaces.IPerson;
import fhdw.ipscrum.shared.model.interfaces.ITeam;


public interface ITeamView extends IView {

	public abstract void updatePersonTableData(ArrayList<IPerson> arrayList);
	public abstract void updateTeamTreeData(HashSet<ITeam> teamSet);
	
}