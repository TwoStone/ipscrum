package fhdw.ipscrum.shared.constants;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
// Werden nur in der Oberfläche verwendet.
public final class TextConstantsForLists {

	public static final Map<Integer, String> SEARCH_TYPES = new HashMap<Integer, String>() {
		{
			this.put(1, "Logischer Operator");
			this.put(2, "Suchkriterium");
		}
	};;

	public static final Map<Integer, String> SEARCH_LOGICALS = new HashMap<Integer, String>() {
		{
			this.put(1, "UND");
			this.put(2, "ODER");
			this.put(3, "NICHT");
		}
	};;

	public static final Map<Integer, String> SEARCH_CRITERIA = new HashMap<Integer, String>() {
		{
			this.put(1, "Typ des PBI");
			this.put(2, "Projekt");
			this.put(3, "Release");
			this.put(4, "Name");
			this.put(5, "Sprint-Beschreibung");
			this.put(6, "Sprint-Name");
			this.put(7, "Aufwand");
			this.put(8, "Status");
			this.put(9, "Letzter Bearbeiter");
			this.put(10, "Beschreibung");
			this.put(11, "Beziehung");
			this.put(12, "Hinweis");
			this.put(13, "Akzeptanzkriterium");
			this.put(14, "System (nur Bugs)");
			this.put(15, "Version (nur Bugs)");
		}
	};;

	public static final Map<Integer, String> SEARCH_PBI_STATE = new HashMap<Integer, String>() {
		{
			this.put(1, "Offen");
			this.put(2, "Geschlossen");
		}
	};;
	public static final Map<Integer, String> SEARCH_PBI_TYPE = new HashMap<Integer, String>() {
		{
			this.put(1, "Feature");
			this.put(2, "Bug");
		}
	};;
}
