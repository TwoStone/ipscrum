package fhdw.ipscrum.shared.constants;

import java.util.HashMap;
import java.util.Map;

public final class TextConstantsForLists {

	public static final Map<Integer, String> SEARCH_TYPES = new HashMap<Integer, String>() {
		{
			put(1, "Logischer Operator");
			put(2, "Suchkriterium");
		}
	};;

	public static final Map<Integer, String> SEARCH_LOGICALS = new HashMap<Integer, String>() {
		{
			put(1, "AND");
			put(2, "OR");
			put(3, "NOT");
		}
	};;

	public static final Map<Integer, String> SEARCH_CRITERIA = new HashMap<Integer, String>() {
		{
			put(1, "Freitextsuche");
			put(2, "Projekt");
			put(3, "Release");
			put(4, "Name");
			put(5, "Sprint-Beschreibung");
			put(6, "Sprint-Name");
			put(7, "Aufwand");
			put(8, "Status");
			put(9, "Letzter Bearbeiter");
			put(10, "Beschreibung");
			put(11, "Beziehung");
			put(12, "Hinweis");
			put(13, "Akzeptanzkriterium");
			put(14, "System (nur Bugs)");
			put(15, "Version (nur Bugs)");
		}
	};;

	public static final Map<Integer, String> SEARCH_PBI_STATE = new HashMap<Integer, String>() {
		{
			put(1, "Offen");
			put(2, "Geschlossen");
		}
	};;
}
