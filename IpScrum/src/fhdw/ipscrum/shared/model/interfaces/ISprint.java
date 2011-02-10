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
	
	//TODO Modelländerung gemäß Brack, falls unklar mich bitte ansprechen
	//Achtung! Bitte konsistenzbedingung einarbeiten, dass keine neuen
	//Releases definiert werden dürfen, sondern nur Releases hinzugefügt werden,
	//die bereits einem Project anhängen!
	public void setRelease(IRelease release);
	public IRelease getRelease();

	//TODO Reverse Assoziation!
	public Vector<ProductBacklogItem> getPBIs();
	
	//TODO Wir brauchen irgendeine String Repräsentation um den Sprint auf der Oberfläche anzeigen zu können.
	public String getName();
	
	//TODO Bitte das Hinzufügen und entferner über eigene Add/Remove Methoden
	//bereitstellen. Man kann dann besser die Konsistenzbedingungen prüfen.
	//TODO bitte hier die Prüfung einbauen, dass kein Ping-Pong-Effekt auftritt!
	public void addPBI(ProductBacklogItem pbi) throws ConsistencyException;

	//Wird benötigt, damit der PBI bei setSprint(null), sich auch aus dessen
	//Liste entfernen kann!
	public void removePBI(ProductBacklogItem pbi) throws ConsistencyException;
}
