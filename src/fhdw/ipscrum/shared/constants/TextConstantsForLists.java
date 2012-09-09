package fhdw.ipscrum.shared.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Constants for view lists.
 */
@SuppressWarnings("serial")
public final class TextConstantsForLists {

	/**
	 * constructor of the class.
	 */
	private TextConstantsForLists() {

	}

	/**
	 * Represents the contents of the search types list.
	 */
	public static final Map<Integer, String> SEARCH_TYPES = new HashMap<Integer, String>() {
		{
			this.put(1, "Logischer Operator");
			this.put(2, "Suchkriterium");
		}
	};;

	/**
	 * Represents the contents of the search logicals list.
	 */
	public static final Map<Integer, String> SEARCH_LOGICALS = new HashMap<Integer, String>() {
		{
			this.put(1, "UND");
			this.put(2, "ODER");
			this.put(TextConstantsForLists.NUMBER_THREE, TextConstants.NICHT);
		}
	};;

	/**
	 * Represents the contents of the SearchCriteria list.
	 */
	public static final Map<Integer, String> SEARCH_CRITERIA = new HashMap<Integer, String>() {
		{
			this.put(1, "Typ des PBI");
			this.put(2, "Projekt");
			this.put(TextConstantsForLists.NUMBER_THREE, "Release");
			this.put(TextConstantsForLists.FOUR, "Name");
			this.put(TextConstantsForLists.FIVE, "Sprint-Beschreibung");
			this.put(TextConstantsForLists.SIX, "Sprint-Name");
			this.put(TextConstantsForLists.SEVEN, "Aufwand");
			this.put(TextConstantsForLists.EIGHT, "Status");
			this.put(TextConstantsForLists.NINE, "Letzter Bearbeiter");
			this.put(TextConstantsForLists.TEN, "Beschreibung");
			this.put(TextConstantsForLists.ELEVEN, "Beziehung");
			this.put(TextConstantsForLists.TWELVE, "Hinweis");
			this.put(TextConstantsForLists.THIRTEEN, "Akzeptanzkriterium");
			this.put(TextConstantsForLists.FOURTEEN, "System (nur Bugs)");
			this.put(TextConstantsForLists.FIVETEEN, "Version (nur Bugs)");
		}
	};;

	/**
	 * Represents the contents of the SerachPBIState list.
	 */
	public static final Map<Integer, String> SEARCH_PBI_STATE = new HashMap<Integer, String>() {
		{
			this.put(1, "Offen");
			this.put(2, "Geschlossen");
		}
	};;

	/**
	 * Represents the contents of the SearchPBITypes list.
	 */
	public static final Map<Integer, String> SEARCH_PBI_TYPE = new HashMap<Integer, String>() {
		{
			this.put(1, "Feature");
			this.put(2, "Bug");
		}
	};;

	/**
	 * Represents the contents of the SearchRelationSearchType list.
	 */
	public static final Map<Integer, String> SEARCH_RELATIONSEARCHTYPE = new HashMap<Integer, String>() {
		{
			this.put(1, "Typ der Relation");
			this.put(2, "Ziel der Relation");
		}
	};;

	/**
	 * represents the number 3.
	 */
	private static final Integer NUMBER_THREE = 3;

	/**
	 * represents the number 4.
	 */
	private static final Integer FOUR = 4;

	/**
	 * represents the number 5.
	 */
	private static final Integer FIVE = 5;

	/**
	 * represents the number 6.
	 */
	private static final Integer SIX = 6;

	/**
	 * represents the number 7.
	 */
	private static final Integer SEVEN = 7;

	/**
	 * represents the number 8.
	 */
	private static final Integer EIGHT = 8;

	/**
	 * represents the number 9.
	 */
	private static final Integer NINE = 9;

	/**
	 * represents the number 10.
	 */
	private static final Integer TEN = 10;

	/**
	 * represents the number 11.
	 */
	private static final Integer ELEVEN = 11;

	/**
	 * represents the number 12.
	 */
	private static final Integer TWELVE = 12;

	/**
	 * represents the number 13.
	 */
	private static final Integer THIRTEEN = 13;

	/**
	 * represents the number 14.
	 */
	private static final Integer FOURTEEN = 14;

	/**
	 * represents the number 15.
	 */
	private static final Integer FIVETEEN = 15;
}
