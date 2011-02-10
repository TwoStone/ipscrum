package fhdw.ipscrum.shared.model.interfaces;

import java.sql.Date;
import java.util.Vector;

import fhdw.ipscrum.shared.exceptions.ConsistencyException;
import fhdw.ipscrum.shared.model.ProductBacklogItem;
import fhdw.ipscrum.shared.model.Team;

public interface ISprint {

	public Date getBegin();
	public void setBegin(Date begin);
	
	public Date getEnd();
	public void setEnd(Date end);
	
	public Team getTeam();
	public void setTeam(Team team);
	
	//TODO Modell�nderung gem�� Brack, falls unklar mich bitte ansprechen
	//Achtung! Bitte konsistenzbedingung einarbeiten, dass keine neuen
	//Releases definiert werden d�rfen, sondern nur Releases hinzugef�gt werden,
	//die bereits einem Project anh�ngen!
	public void setRelease(IRelease release);
	public IRelease getRelease();

	//TODO Reverse Assoziation!
	public Vector<ProductBacklogItem> getPBIs();
	
	//TODO Wir brauchen irgendeine String Repr�sentation um den Sprint auf der Oberfl�che anzeigen zu k�nnen.
	public String getName();
	
	//TODO Bitte das Hinzuf�gen und entferner �ber eigene Add/Remove Methoden
	//bereitstellen. Man kann dann besser die Konsistenzbedingungen pr�fen.
	//TODO bitte hier die Pr�fung einbauen, dass kein Ping-Pong-Effekt auftritt!
	public void addPBI(ProductBacklogItem pbi) throws ConsistencyException;

	//Wird ben�tigt, damit der PBI bei setSprint(null), sich auch aus dessen
	//Liste entfernen kann!
	public void removePBI(ProductBacklogItem pbi) throws ConsistencyException;
}
