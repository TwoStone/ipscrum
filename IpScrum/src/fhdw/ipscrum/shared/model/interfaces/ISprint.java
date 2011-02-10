package fhdw.ipscrum.shared.model.interfaces;

import java.sql.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Team;

public interface ISprint {

	public Date getBegin();
	public void setBegin(Date begin);
	
	public Date getEnd();
	public void setEnd(Date end);
	
	public Team getTeam();
	public void setTeam(Team team);
	
	//TODO PWOLF Modell�nderung gem�� Brack, falls unklar mich bitte ansprechen
	//Achtung! Bitte konsistenzbedingung einarbeiten, dass keine neuen
	//Releases definiert werden d�rfen, sondern nur Releases hinzugef�gt werden,
	//die bereits einem Project anh�ngen!
	public void setRelease(IRelease release);
	public IRelease getRelease();

	//TODO Reverse Assoziation!
	public Vector<ProductBacklogItem> getPBIs();
	
	//TODO Wir brauchen irgendeine String Repr�sentation um den Sprint auf der Oberfl�che anzeigen zu k�nnen.
	public String getName();
}
